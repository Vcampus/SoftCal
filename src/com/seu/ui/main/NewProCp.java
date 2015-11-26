package com.seu.ui.main;

import java.sql.Savepoint;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

import com.seu.bean.Proj;
import com.seu.dao.impl.ProjDaoImpl;

import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;

public class NewProCp extends Composite {

	/**
	 * Create the shell.
	 * @param display
	 */
	private Text text_name;
	private Text text_dep;
	private ProjDaoImpl projDaoImpl;
	private Label lblhorizontal;
	
	public NewProCp(Composite parent, int style) {
		super(parent,style);
		projDaoImpl = new ProjDaoImpl();
		initLayout();

	}
	
	private void initLayout(){
		setLayout(new FormLayout());
		
		Label lblNewProj = new Label(this, SWT.NONE);
		FormData fd_lblNewProj = new FormData();
		fd_lblNewProj.top = new FormAttachment(2, 1);
		fd_lblNewProj.left = new FormAttachment(0,6);
		fd_lblNewProj.bottom = new FormAttachment(10, -1);
		lblNewProj.setLayoutData(fd_lblNewProj);
		lblNewProj.setText("项目创建");
		
		lblhorizontal = new Label(this, SWT.SEPARATOR | SWT.HORIZONTAL);
		FormData lblhorizontal_fd = new FormData();
		lblhorizontal_fd.bottom = new FormAttachment(10,-1);
		lblhorizontal_fd.top = new FormAttachment(2,1);
		lblhorizontal_fd.left = new FormAttachment(lblNewProj,1);
		lblhorizontal_fd.right = new FormAttachment(95, -5);
		lblhorizontal.setLayoutData(lblhorizontal_fd);
		
		Label LabelProjName = new Label(this, SWT.NONE);
		LabelProjName.setText("ProjectName:");
		FormData LabelProjName_fd = new FormData();
		LabelProjName_fd.top = new FormAttachment( lblNewProj, 5);
		LabelProjName_fd.left = new FormAttachment(0, 10);
		LabelProjName_fd.bottom = new FormAttachment(20,-5);
		LabelProjName_fd.right = new FormAttachment(100, -10);
		LabelProjName.setLayoutData(LabelProjName_fd);
		
		text_name = new Text(this, SWT.BORDER);
		FormData text_name_fd = new FormData();
		text_name_fd.top = new FormAttachment( LabelProjName, 5);
		text_name_fd.left = new FormAttachment(0, 10);
		text_name_fd.bottom = new FormAttachment(35,-5);
		text_name_fd.right = new FormAttachment(100, -10);
		text_name.setLayoutData(text_name_fd);
		
		Label LableProjDep = new Label(this, SWT.NONE);
		LableProjDep.setText("Description:");
		FormData LableProjDep_fd = new FormData();
		LableProjDep_fd.top = new FormAttachment( text_name, 10);
		LableProjDep_fd.left = new FormAttachment(0, 10);
		LableProjDep_fd.bottom = new FormAttachment(45,-5);
		LableProjDep_fd.right = new FormAttachment(100, -10);
		LableProjDep.setLayoutData(LableProjDep_fd);
		
		text_dep = new Text(this, SWT.BORDER);
		text_dep.setBounds(33, 128, 355, 75);
		FormData text_dep_fd = new FormData();
		text_dep_fd.top = new FormAttachment( LableProjDep, 2);
		text_dep_fd.left = new FormAttachment(0, 10);
		text_dep_fd.bottom = new FormAttachment(60,-5);
		text_dep_fd.right = new FormAttachment(100, -10);
		text_dep.setLayoutData(text_dep_fd);
		
		Button btn_ok = new Button(this, SWT.NONE);
		btn_ok.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent arg0) {
				Save();	
				text_dep.setText("");
				text_name.setText("");
			}
		});
		btn_ok.setText("Save");
		FormData btn_ok_fd = new FormData();
		btn_ok_fd.top = new FormAttachment(65, 5);
		btn_ok_fd.left = new FormAttachment(85, 5);
		btn_ok_fd.bottom = new FormAttachment(75,-5);
		btn_ok_fd.right = new FormAttachment(100, -15);
		btn_ok.setLayoutData(btn_ok_fd);
		
	}

	/**
	 * Create contents of the shell.
	 */
	
	private void Save(){
		Proj proj = new Proj(text_name.getText(),text_dep.getText());
		projDaoImpl.Save(proj);
	}
	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
