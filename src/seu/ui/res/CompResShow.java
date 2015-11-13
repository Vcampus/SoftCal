package com.seu.ui.res;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Button;

import java.lang.annotation.Annotation;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.jfree.chart.JFreeChart;
import org.jfree.experimental.chart.swt.ChartComposite;


import com.sun.org.glassfish.gmbal.NameValue;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;


public class CompResShow extends Composite {
	private Table table;

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
		
		table = new Table(compTableShow, SWT.BORDER | SWT.FULL_SELECTION | SWT.MULTI | SWT.CHECK);
		table.setBounds(0, 0, 615, 463);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		//创建表头
		TableColumn colName = new TableColumn(table, SWT.NONE);
		colName.setWidth(100);
		colName.setText("项目名称");
		
		TableColumn colVersion = new TableColumn(table, SWT.NONE);
		colVersion.setWidth(95);
		colVersion.setText("版本号");
		
		TableColumn colPM = new TableColumn(table, SWT.NONE);
		colPM.setWidth(86);
		colPM.setText("软件规模");
		
        //加入表项
		TableItem item1=new TableItem(table,SWT.NONE); 
		 item1.setText(new String[]{"Tim","Hatton","Kentucky"}); 
		 
		TableItem item2=new TableItem(table,SWT.NONE); 
		item2.setText(new String[]{"Tim2","Hatton","Kentucky"}); 
		
		TableItem item3=new TableItem(table,SWT.NONE); 
		item3.setText(new String[]{"Tim","Hatton","Kentucky"}); 
		
		
		//获取已经选择的表项的内容
		Button button = new Button(this, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent arg0) {
				
				TableItem []chooseItem = table.getItems();
				for(int i=0;i<chooseItem.length;i++){
					if(chooseItem[i].getChecked()){
						chooseItem[i].setText(2, "true");
					}
				}
			}
		});
		button.setBounds(424, 520, 80, 27);
		button.setText("选择项目");
		
		TabItem tbtmChart = new TabItem(folderResShow, SWT.NONE);
		tbtmChart.setText("图表显示");
		CreateLineChart op =new CreateLineChart(); 
		JFreeChart chart =op.getJFreeChart();
		ChartComposite chartCP = new ChartComposite(folderResShow, SWT.NONE, chart, true);
		tbtmChart.setControl(chartCP);
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
