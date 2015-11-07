package com.seu.ui.res;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;

public class CompResShow extends Composite {

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public CompResShow(Composite parent, int style) {
		super(parent, style);
		
		Button btnExit = new Button(this, SWT.NONE);
		btnExit.setBounds(556, 520, 80, 27);
		btnExit.setText("退出");
		
		TabFolder folderResShow = new TabFolder(this, SWT.NONE);
		folderResShow.setBounds(10, 10, 623, 493);
		
		TabItem tbtmTable = new TabItem(folderResShow, SWT.NONE);
		tbtmTable.setText("列表显示");
		
		Composite compTableShow = new Composite(folderResShow, SWT.NONE);
		tbtmTable.setControl(compTableShow);
		
		TabItem tbtmChart = new TabItem(folderResShow, SWT.NONE);
		tbtmChart.setText("图表显示");
		
		Composite compChartShow = new Composite(folderResShow, SWT.NONE);
		tbtmChart.setControl(compChartShow);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
