package com.seu.ui;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
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
		
		TabFolder tabfolderArgsAdjust = new TabFolder(this, SWT.NONE);
		tabfolderArgsAdjust.setBounds(10, 10, 615, 523);
		
		TabItem tbtmHistroyGet = new TabItem(tabfolderArgsAdjust, SWT.NONE);
		tbtmHistroyGet.setText("历史规模录入");
		
		Composite compHisGet = new Composite(tabfolderArgsAdjust, SWT.NONE);
		tbtmHistroyGet.setControl(compHisGet);
		
		ScrolledComposite scrolledComposite = new ScrolledComposite(compHisGet, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite.setBounds(10, 10, 574, 443);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		
		tableHisGet = new Table(scrolledComposite, SWT.BORDER | SWT.FULL_SELECTION);
		tableHisGet.setToolTipText("");
		tableHisGet.setHeaderVisible(true);
		tableHisGet.setLinesVisible(true);
		
		TableColumn colName = new TableColumn(tableHisGet, SWT.NONE);
		colName.setWidth(100);
		colName.setText("项目名字");
		
		TableColumn colVersion = new TableColumn(tableHisGet, SWT.NONE);
		colVersion.setWidth(100);
		colVersion.setText("项目版本号");
		
		TableColumn colPM = new TableColumn(tableHisGet, SWT.NONE);
		colPM.setWidth(100);
		colPM.setText("开发成本");
		scrolledComposite.setContent(tableHisGet);
		scrolledComposite.setMinSize(tableHisGet.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		
		TabItem tbtmAargs = new TabItem(tabfolderArgsAdjust, SWT.NONE);
		tbtmAargs.setText("A常数校准结果");
		
		Composite compAargs = new Composite(tabfolderArgsAdjust, SWT.NONE);
		tbtmAargs.setControl(compAargs);
		
		ScrolledComposite scrolledCompositeAargs = new ScrolledComposite(compAargs, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledCompositeAargs.setExpandVertical(true);
		scrolledCompositeAargs.setExpandHorizontal(true);
		scrolledCompositeAargs.setBounds(10, 10, 587, 395);
		
		tableAargs = new Table(scrolledCompositeAargs, SWT.BORDER | SWT.FULL_SELECTION);
		tableAargs.setHeaderVisible(true);
		tableAargs.setLinesVisible(true);
		
		TableColumn colAName = new TableColumn(tableAargs, SWT.NONE);
		colAName.setWidth(100);
		colAName.setText("项目名字");
		
		TableColumn colAVersion = new TableColumn(tableAargs, SWT.NONE);
		colAVersion.setWidth(100);
		colAVersion.setText("项目版本号");
		
		TableColumn colAPM = new TableColumn(tableAargs, SWT.NONE);
		colAPM.setWidth(100);
		colAPM.setText("开发成本");
		scrolledCompositeAargs.setContent(tableAargs);
		scrolledCompositeAargs.setMinSize(tableAargs.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		scrolledCompositeAargs.setMinSize(new Point(302, 45));
		
		TabItem tbtmABargsAdjust = new TabItem(tabfolderArgsAdjust, SWT.NONE);
		tbtmABargsAdjust.setText("AB常数同时校准结果");
		
		Composite compABargs = new Composite(tabfolderArgsAdjust, SWT.NONE);
		tbtmABargsAdjust.setControl(compABargs);
		
		ScrolledComposite scrolledCompositeABargs = new ScrolledComposite(compABargs, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledCompositeABargs.setExpandVertical(true);
		scrolledCompositeABargs.setExpandHorizontal(true);
		scrolledCompositeABargs.setBounds(10, 10, 587, 395);
		
		tableABargs = new Table(scrolledCompositeABargs, SWT.BORDER | SWT.FULL_SELECTION);
		tableABargs.setLinesVisible(true);
		tableABargs.setHeaderVisible(true);
		
		TableColumn colABName = new TableColumn(tableABargs, SWT.NONE);
		colABName.setWidth(100);
		colABName.setText("项目名字");
		
		TableColumn colABVersion = new TableColumn(tableABargs, SWT.NONE);
		colABVersion.setWidth(100);
		colABVersion.setText("项目版本号");
		
		TableColumn colABPM = new TableColumn(tableABargs, SWT.NONE);
		colABPM.setWidth(100);
		colABPM.setText("开发成本");
		scrolledCompositeABargs.setContent(tableABargs);
		scrolledCompositeABargs.setMinSize(tableABargs.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		
		//添加录入表格的编辑器
		TableEditor tableHisGetEditor = new TableEditor(tableHisGet);
//		tableHisGetEditor.setEditor(new Button(tableHisGet,SWT.PUSH),tableItem,1);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
