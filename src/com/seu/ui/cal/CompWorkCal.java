package com.seu.ui.cal;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.custom.TableCursor;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.List;

import com.seu.adapter.UiAdapter;
import com.seu.bean.Proj;
import com.seu.bean.Version;
import com.seu.ui.input.EIndexEnterCP;
import com.seu.ui.input.EMEnterCp;
import com.seu.ui.input.SoftwareSizeEnterCp;
import com.seu.ui.main.VersionShell;

public class CompWorkCal extends Composite implements UiAdapter{
	Proj proj;
	Version version;
	SoftwareSizeEnterCp cpSize;
	EIndexEnterCP cpE;
	EMEnterCp cpEm;
	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public CompWorkCal(Composite parent, int style) {
		super(parent, style);
		TabFolder tabFolder = new TabFolder(this, SWT.NONE);
		tabFolder.setBounds(10, 57, 574, 407);

	

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
	
	
}
