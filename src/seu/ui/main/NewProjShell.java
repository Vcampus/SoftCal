package com.seu.ui.main;

import java.sql.Savepoint;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

import com.seu.bean.Proj;
import com.seu.dao.impl.ProjDaoImpl;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class NewProjShell extends Shell {

	/**
	 * Create the shell.
	 * @param display
	 */
	MainShell father;
	private Text text_name;
	private Text text_dep;
	private ProjDaoImpl projDaoImpl;
	
	public NewProjShell(Display display,MainShell father) {
		super(display, SWT.SHELL_TRIM);
		projDaoImpl = new ProjDaoImpl();
		this.father = father;
		initLayout();
		createContents();
	}
	
	private void initLayout(){
		Label LabelProjName = new Label(this, SWT.NONE);
		LabelProjName.setBounds(33, 31, 105, 17);
		LabelProjName.setText("ProjectName:");
		
		Label LableProjDep = new Label(this, SWT.NONE);
		LableProjDep.setBounds(33, 97, 127, 17);
		LableProjDep.setText("Description:");
		
		text_name = new Text(this, SWT.BORDER);
		text_name.setBounds(33, 54, 355, 28);
		
		text_dep = new Text(this, SWT.BORDER);
		text_dep.setBounds(33, 128, 355, 75);
		
		Button btn_ok = new Button(this, SWT.NONE);
		btn_ok.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent arg0) {
				Save();
			}
		});
		btn_ok.setBounds(227, 224, 80, 27);
		btn_ok.setText("OK");
		
		Button btn_cancle = new Button(this, SWT.NONE);
		btn_cancle.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				close();
			}
		});
		btn_cancle.setBounds(327, 224, 80, 27);
		btn_cancle.setText("Cancle");
		
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("New Project");
		setSize(450, 300);
	}
	
	private void Save(){
		Proj proj = new Proj(text_name.getText(),text_dep.getText());
		projDaoImpl.Save(proj);
		father.setProj(proj);
		father.refresh();
		close();
	}
	

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
