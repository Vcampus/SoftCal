package com.seu.ui.main;

import java.util.ArrayList;

import javax.security.auth.Refreshable;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.seu.bean.Proj;
import com.seu.bean.Version;
import com.seu.dao.impl.VersionDaoImpl;

import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

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
		
		
		list_version = new List(this, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		list_version.setBounds(10, 28, 393, 73);
		
		
		
		Label label_list = new Label(this, SWT.NONE);
		label_list.setBounds(10, 10, 61, 17);
		label_list.setText("已有版本号");
		
		//监听新版本输入框，如果有内容，就默认是添加新版本
		text = new Text(this, SWT.BORDER);
		text.setBounds(10, 165, 393, 57);
		
		
		
		Label lable_new = new Label(this, SWT.NONE);
		lable_new.setBounds(10, 135, 61, 17);
		lable_new.setText("新版本名称");
		
		
		//取消按钮
		Button btn_cancel = new Button(this, SWT.NONE);
		btn_cancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				close();
			}
		});
		btn_cancel.setBounds(443, 59, 43, 27);
		btn_cancel.setText("Cancel");
		
		
		//确认添加按钮
		Button btn_add = new Button(this, SWT.NONE);
		btn_add.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				Version version = new Version(proj.getId(),proj.getName(),text.getText());
				versionDaoImpl.Save(version);
				refresh();
			}
		});
		btn_add.setBounds(443, 195, 51, 27);
		btn_add.setText("Add");
		
		
		//选择按钮
		Button btnSelect = new Button(this, SWT.NONE);
		btnSelect.setBounds(443, 28, 43, 27);
		btnSelect.setText("Select");
		btnSelect.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				if(list_version.getFocusIndex()!=-1)
				selectVersion(versions.get(list_version.getFocusIndex()));
				else {
					selectVersion(null);
				}
			}
		});
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText(proj.getName()+"-版本添加");
		setSize(542, 329);

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
