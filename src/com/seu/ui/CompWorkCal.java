package com.seu.ui;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Label;
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

public class CompWorkCal extends Composite {
	private Table table;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public CompWorkCal(Composite parent, int style) {
		super(parent, style);
		
		final int selecttabItem = 1;
		
		Button btnAddVersion = new Button(this, SWT.NONE);
		btnAddVersion.setBounds(458, 523, 80, 25);
		btnAddVersion.addMouseListener(new MouseAdapter() {
			public void mouseDown(MouseEvent arg0) {
				//若各参数输入完成，则计算演化成本
			}
		});
		btnAddVersion.setText("添加项目版本");
		
		Button btnChangeVeision = new Button(this, SWT.NONE);
		btnChangeVeision.setText("修改版本参数");
		btnChangeVeision.setBounds(544, 523, 80, 25);
		
		ScrolledComposite scrolledComposite = new ScrolledComposite(this, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite.setBounds(10, 10, 614, 496);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		
		table = new Table(scrolledComposite, SWT.BORDER | SWT.FULL_SELECTION);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn colName = new TableColumn(table, SWT.NONE);
		colName.setWidth(100);
		colName.setText("项目名称");
		
		TableColumn colVersion = new TableColumn(table, SWT.NONE);
		colVersion.setWidth(95);
		colVersion.setText("版本号");
		
		TableColumn colPM = new TableColumn(table, SWT.NONE);
		colPM.setWidth(86);
		colPM.setText("软件规模");
		
		TableCursor tableCursor = new TableCursor(table, SWT.NONE);
		scrolledComposite.setContent(table);
		scrolledComposite.setMinSize(table.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		
		

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
