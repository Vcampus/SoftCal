package com.seu.ui.cal;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;

import com.seu.adapter.UiAdapter;
import com.seu.bean.Version;
import com.seu.exception.VersionExistedException;
import com.seu.ui.input.EIndexEnterCP;
import com.seu.ui.input.EMEnterCp;
import com.seu.ui.input.SoftwareSizeEnterCp;


public class CompWorkCal extends Composite implements UiAdapter{
	Version version;
	SoftwareSizeEnterCp cpSize;
	EIndexEnterCP cpE;
	EMEnterCp cpEm;
	
	
	@Override
	public void load() {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void refresh() {
		// TODO 自动生成的方法存根
		cpSize.setVersion(version);
		cpSize.refresh();
	}

	@Override
	public boolean save() {
		// TODO 自动生成的方法存根
		return false;
	}

	public Version getVersion() {
		return version;
	}

	public void setVersion(Version version) {
		this.version = version;
	}

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public CompWorkCal(Composite parent, int style) {
		super(parent, style);
		setLayout(new FormLayout());
		
		TabFolder tabFolder = new TabFolder(this, SWT.NONE);
		FormData tbdata = new FormData();
		tbdata.top = new FormAttachment( 0, 10);
		tbdata.left = new FormAttachment(0, 10);
		tbdata.bottom = new FormAttachment(100,-5);
		tbdata.right = new FormAttachment(100, -2);
		tabFolder.setLayoutData(tbdata);
		
		//软件规模页面
		TabItem tabItem = new TabItem(tabFolder, SWT.NONE);
		tabItem.setText("软件规模SizeM");
		cpSize = new SoftwareSizeEnterCp(tabFolder, SWT.NONE);
		tabItem.setControl(cpSize);
		
		
		//指数E页面
		TabItem tabfolderEIndex = new TabItem(tabFolder, SWT.NONE);
		tabfolderEIndex.setText("指数E");
		cpE= new EIndexEnterCP(tabFolder, SWT.NONE);
		tabfolderEIndex.setControl(cpE);
		
		//工作量常数页面
		TabItem tbtmem = new TabItem(tabFolder, SWT.NONE);
		tbtmem.setText("工作量乘数EM");
		cpEm = new EMEnterCp(tabFolder, SWT.NONE);
		tbtmem.setControl(cpEm);
		
		

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
