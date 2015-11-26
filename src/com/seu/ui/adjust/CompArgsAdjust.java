package com.seu.ui.adjust;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.wb.swt.SWTResourceManager;

import com.seu.adapter.UiAdapter;
import com.seu.bean.Version;
import com.seu.ui.adjust.input.AdjEIndexEnterCP;
import com.seu.ui.adjust.input.AdjEMEnterCp;
import com.seu.ui.adjust.input.AdjSizeAndPMCp;

public class CompArgsAdjust extends Composite implements UiAdapter{
	
	AdjSizeAndPMCp cpSize ;
	AdjEIndexEnterCP cpE;
	AdjEMEnterCp cpEm;
	Version version;
	@Override
	public void load() {
		// TODO 自动生成的方法存根
		
	}

	

	@Override
	public void refresh() {
		// TODO 自动生成的方法存根
		cpSize.setVersion(version);
		cpSize.refresh();
		cpEm.setVersion(version);
		cpEm.refresh();
		cpE.setVersion(version);
		cpE.refresh();
	}

	@Override
	public boolean save() {
		// TODO 自动生成的方法存根
		return false;
	}

	private Table tableHisGet;
	private Table tableAargs;
	private Table tableABargs;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public CompArgsAdjust(Composite parent, int style) {
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
		tabItem.setText("PMandSizeM");
		cpSize = new AdjSizeAndPMCp(tabFolder, SWT.NONE);
		tabItem.setControl(cpSize);
		
		
		//指数E页面
		TabItem tabfolderEIndex = new TabItem(tabFolder, SWT.NONE);
		tabfolderEIndex.setText("指数E");
		cpE= new AdjEIndexEnterCP(tabFolder, SWT.NONE);
		tabfolderEIndex.setControl(cpE);
		
		//工作量常数页面
		TabItem tbtmem = new TabItem(tabFolder, SWT.NONE);
		tbtmem.setText("工作量乘数EM");
		cpEm = new AdjEMEnterCp(tabFolder, SWT.NONE);
		tbtmem.setControl(cpEm);
		
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	
	public Version getVersion() {
		return version;
	}

	public void setVersion(Version version) {
		this.version = version;
	}
}
