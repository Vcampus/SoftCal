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
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;

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
		setLayout(new FormLayout());
		Label LabelProjName = new Label(this, SWT.NONE);
		LabelProjName.setText("ProjectName:");
		FormData LabelProjName_fd = new FormData();
		LabelProjName_fd.top = new FormAttachment( 0, 10);
		LabelProjName_fd.left = new FormAttachment(0, 10);
		LabelProjName_fd.bottom = new FormAttachment(10,-5);
		LabelProjName_fd.right = new FormAttachment(100, -10);
		LabelProjName.setLayoutData(LabelProjName_fd);
		
		text_name = new Text(this, SWT.BORDER);
		FormData text_name_fd = new FormData();
		text_name_fd.top = new FormAttachment( LabelProjName, 5);
		text_name_fd.left = new FormAttachment(0, 10);
		text_name_fd.bottom = new FormAttachment(45,-5);
		text_name_fd.right = new FormAttachment(100, -10);
		text_name.setLayoutData(text_name_fd);
		
		Label LableProjDep = new Label(this, SWT.NONE);
		LableProjDep.setText("Description:");
		FormData LableProjDep_fd = new FormData();
		LableProjDep_fd.top = new FormAttachment( text_name, 10);
		LableProjDep_fd.left = new FormAttachment(0, 10);
		LableProjDep_fd.bottom = new FormAttachment(55,-5);
		LableProjDep_fd.right = new FormAttachment(100, -10);
		LableProjDep.setLayoutData(LableProjDep_fd);
		
		text_dep = new Text(this, SWT.BORDER);
		text_dep.setBounds(33, 128, 355, 75);
		FormData text_dep_fd = new FormData();
		text_dep_fd.top = new FormAttachment( LableProjDep, 2);
		text_dep_fd.left = new FormAttachment(0, 10);
		text_dep_fd.bottom = new FormAttachment(90,-5);
		text_dep_fd.right = new FormAttachment(100, -10);
		text_dep.setLayoutData(text_dep_fd);
		
		Button btn_ok = new Button(this, SWT.NONE);
		btn_ok.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent arg0) {
				Save();
			}
		});
		btn_ok.setText("OK");
		FormData btn_ok_fd = new FormData();
		btn_ok_fd.top = new FormAttachment( text_dep, 5);
		btn_ok_fd.left = new FormAttachment(70, 2);
		btn_ok_fd.bottom = new FormAttachment(100,-5);
		btn_ok_fd.right = new FormAttachment(85, -2);
		btn_ok.setLayoutData(btn_ok_fd);
		
		Button btn_cancle = new Button(this, SWT.NONE);
		btn_cancle.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				close();
			}
		});
		btn_cancle.setText("Cancle");
		FormData btn_cancle_fd = new FormData();
		btn_cancle_fd.top = new FormAttachment( text_dep, 5);
		btn_cancle_fd.left = new FormAttachment(85, 2);
		btn_cancle_fd.bottom = new FormAttachment(100,-5);
		btn_cancle_fd.right = new FormAttachment(100, -2);
		btn_cancle.setLayoutData(btn_cancle_fd);
		
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("New Project");
		setSize(541, 377);
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
