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
import org.eclipse.wb.swt.SWTResourceManager;

import com.seu.adapter.UiAdapter;
import com.seu.ui.input.EIndexEnterCP;
import com.seu.ui.input.EMEnterCp;
import com.seu.ui.input.SoftwareSizeEnterCp;

import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;

public class CompArgsAdjust extends Composite implements UiAdapter{
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
		FormData fd_tabFolder = new FormData();
		fd_tabFolder.bottom = new FormAttachment(0, 464);
		fd_tabFolder.right = new FormAttachment(90);
		fd_tabFolder.top = new FormAttachment(0, 57);
		fd_tabFolder.left = new FormAttachment(0, 10);
		tabFolder.setLayoutData(fd_tabFolder);

		//软件规模页面
		TabItem tabItem = new TabItem(tabFolder, SWT.NONE);
		tabItem.setText("软件规模SizeM");
		SoftwareSizeEnterCp cpSize = new SoftwareSizeEnterCp(tabFolder, SWT.NONE);
		tabItem.setControl(cpSize);
		
		
		//指数E页面
		TabItem tabfolderEIndex = new TabItem(tabFolder, SWT.NONE);
		tabfolderEIndex.setText("指数E");
		EIndexEnterCP cpE= new EIndexEnterCP(tabFolder, SWT.NONE);
		tabfolderEIndex.setControl(cpE);
		
		//工作量常数页面
		TabItem tbtmem = new TabItem(tabFolder, SWT.NONE);
		tbtmem.setText("工作量乘数EM");
		EMEnterCp cpEm = new EMEnterCp(tabFolder, SWT.NONE);
		tbtmem.setControl(cpEm);
		
		

	}

	@Override
	public void load() {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void refresh() {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public boolean save() {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
