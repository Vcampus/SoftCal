package com.seu.ui.main;

import java.util.ArrayList;

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
		createContents();
	}
	
	public void initLayout(){
		
		
		list_version = new List(this, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		list_version.setBounds(10, 28, 393, 73);
		
		java.util.List<Version> versions = new ArrayList<Version>();
		versions = versionDaoImpl.findByParams("select * from version_info where proj_id = ?", proj.getId());
		if( versions!=null){
			for(Version version:versions){
				list_version.add(version.getProj_name()+"  "+version.getVersion());
			}
		}
		
		Label label_list = new Label(this, SWT.NONE);
		label_list.setBounds(10, 10, 61, 17);
		label_list.setText("已有版本号");
		
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
		btn_cancel.setBounds(323, 234, 80, 27);
		btn_cancel.setText("Cancel");
		
		
		//确认添加按钮
		Button btn_ok = new Button(this, SWT.NONE);
		btn_ok.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				Version version = new Version(proj.getId(),proj.getName(),text.getText());
				versionDaoImpl.Save(version);
				version = versionDaoImpl.getByVesionProjID(proj.getId(), version.getVersion());
				father.version = version;
				father.refresh();
				close();
				
			}
		});
		btn_ok.setBounds(237, 234, 80, 27);
		btn_ok.setText("OK");
		
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText(proj.getName()+"-版本添加");
		setSize(450, 300);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
