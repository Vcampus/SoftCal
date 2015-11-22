package com.seu.ui.main;

import java.util.ArrayList;

import javax.security.auth.Refreshable;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.seu.bean.Proj;
import com.seu.bean.Version;
import com.seu.dao.impl.VersionDaoImpl;
import com.seu.exception.VersionExistedException;

import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;

public class AddVersionShell extends Shell {

	List list_version;
	Proj proj;
	VersionDaoImpl versionDaoImpl;
	MainShell father;
	java.util.List<Version> versions;
	private Text text;
	/**
	 * Create the shell.
	 * @param display
	 */
	
	public AddVersionShell(Display display,Proj proj,MainShell father) {
		super(display, SWT.SHELL_TRIM);
		this.proj = proj;
		versionDaoImpl = new VersionDaoImpl();
		this.father = father;
		initLayout();
		refresh();
		createContents();
	}
	
	public void initLayout(){
		setLayout(new FormLayout());
		
		Label label_list = new Label(this, SWT.NONE);
		label_list.setBounds(10, 10, 61, 17);
		label_list.setText("已有版本号");
		FormData label_list_fd = new FormData();
		label_list_fd.top = new FormAttachment( 0, 10);
		label_list_fd.left = new FormAttachment(0, 10);
		label_list_fd.bottom = new FormAttachment(10,-5);
		label_list_fd.right = new FormAttachment(80, -2);
		label_list.setLayoutData(label_list_fd);
		
		list_version = new List(this, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		FormData list_version_fd = new FormData();
		list_version_fd.top = new FormAttachment( label_list, 10);
		list_version_fd.left = new FormAttachment(0, 10);
		list_version_fd.bottom = new FormAttachment(50,-5);
		list_version_fd.right = new FormAttachment(80, -2);
		list_version.setLayoutData(list_version_fd);
		
		//监听新版本输入框，如果有内容，就默认是添加新版本
		Label lable_new = new Label(this, SWT.NONE);
		lable_new.setText("新版本名称");
		FormData label_new_fd = new FormData();
		label_new_fd.top = new FormAttachment( list_version, 10);
		label_new_fd.left = new FormAttachment(0, 10);
		label_new_fd.bottom = new FormAttachment(60,-5);
		label_new_fd.right = new FormAttachment(80, -2);
		lable_new.setLayoutData(label_new_fd);
		
		text = new Text(this, SWT.BORDER);
		FormData text_fd = new FormData();
		text_fd.top = new FormAttachment( lable_new, 10);
		text_fd.left = new FormAttachment(0, 10);
		text_fd.bottom = new FormAttachment(100,-5);
		text_fd.right = new FormAttachment(80, -2);
		text.setLayoutData(text_fd);

		Button btnSelect = new Button(this, SWT.NONE);
		btnSelect.setText("Select");
		btnSelect.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {	
				if(list_version.getFocusIndex()!=-1)
				selectVersion(versions.get(list_version.getFocusIndex()));
			}
		});
		FormData btnSelect_fd = new FormData();
		btnSelect_fd.top = new FormAttachment( 10, 10);
		btnSelect_fd.left = new FormAttachment(85, 10);
		btnSelect_fd.bottom = new FormAttachment(25,-5);
		btnSelect_fd.right = new FormAttachment(100, -10);
		btnSelect.setLayoutData(btnSelect_fd);
	
		
		//取消按钮
		Button btn_cancel = new Button(this, SWT.NONE);
		btn_cancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				close();
			}
		});
		btn_cancel.setText("Cancel");
		FormData btn_cancel_fd = new FormData();
		btn_cancel_fd.top = new FormAttachment( 45, 10);
		btn_cancel_fd.left = new FormAttachment(85, 10);
		btn_cancel_fd.bottom = new FormAttachment(60,-5);
		btn_cancel_fd.right = new FormAttachment(100, -10);
		btn_cancel.setLayoutData(btn_cancel_fd);
		
		
		//确认添加按钮
		Button btn_add = new Button(this, SWT.NONE);
		btn_add.setBounds(443, 195, 51, 27);
		btn_add.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				Version version = new Version(proj.getId(),proj.getName(),text.getText());
				try {
					versionDaoImpl.Save(version);
				} catch (VersionExistedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				refresh();
			}
		});
		btn_add.setText("Add");
		FormData btn_add_fd = new FormData();
		btn_add_fd.top = new FormAttachment( 75, 10);
		btn_add_fd.left = new FormAttachment(85, 10);
		btn_add_fd.bottom = new FormAttachment(90,-5);
		btn_add_fd.right = new FormAttachment(100, -10);
		btn_add.setLayoutData(btn_add_fd);
	}
	

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText(proj.getName()+"-版本添加");
		setSize(649, 326);

	}
	
	public void refresh(){
		list_version.removeAll();
		versions = new ArrayList<Version>();
		versions = versionDaoImpl.findByParams("select * from version_info where proj_id = ?", proj.getId());
		if( versions!=null){
			for(Version version:versions){
				list_version.add(version.getProj_name()+"  "+version.getVersion());
			}
		}
	}
	
	public void selectVersion(Version version){
		father.version = version;
		father.refresh();
		close();
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
