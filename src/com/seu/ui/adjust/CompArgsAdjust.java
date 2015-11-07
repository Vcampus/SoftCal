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

import com.seu.ui.input.EIndexEnterCP;
import com.seu.ui.input.EMEnterCp;
import com.seu.ui.input.SoftwareSizeEnterCp;

public class CompArgsAdjust extends Composite {
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
		
		TabFolder tabFolder = new TabFolder(this, SWT.NONE);
		tabFolder.setBounds(10, 57, 574, 407);

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
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
