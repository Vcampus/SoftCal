package com.seu.ui.main;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.seu.bean.Proj;
import com.seu.dao.impl.ProjDaoImpl;

import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class OpenProjShell extends Shell {
	
	private MainShell father;
	private ProjDaoImpl projDaoImpl;
	List list_proj;
	java.util.List<Proj> listProjs= new ArrayList<Proj>();
	
	/**
	 * Create the shell.
	 * @param display
	 */
	public OpenProjShell(Display display,MainShell father) {
		super(display, SWT.SHELL_TRIM);
		projDaoImpl = new ProjDaoImpl();
		this.father = father;
		
		
		initLayout();
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Open Project");
		setSize(450, 300);

	}
	
	private void initLayout() {
		// TODO 自动生成的方法存根
		list_proj = new List(this, SWT.BORDER);
		list_proj.setBounds(32, 20, 360, 190);
		
		listProjs = projDaoImpl.findByParams("select * from proj_info ");
		for(Proj proj:listProjs){
            list_proj.add(proj.getName());
        }
		Button btn_ok = new Button(this, SWT.NONE);
		btn_ok.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				Proj sel_projlist_proj = listProjs.get(list_proj.getFocusIndex());
				father.setProj(sel_projlist_proj);
				father.refresh();
				close();			
			}
		});
		btn_ok.setBounds(237, 224, 80, 27);
		btn_ok.setText("open");

		Button btn_cancel = new Button(this, SWT.NONE);
		btn_cancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				close();
			}
		});
		btn_cancel.setBounds(323, 224, 80, 27);
		btn_cancel.setText("cancel");
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
