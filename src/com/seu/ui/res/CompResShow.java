package com.seu.ui.res;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.jfree.chart.JFreeChart;
import org.jfree.experimental.chart.swt.ChartComposite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;


public class CompResShow extends Composite {
	private Table table;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public CompResShow(Composite parent, int style) {
		super(parent, style);
		setLayout(new FormLayout());
		
		TabFolder folderResShow = new TabFolder(this, SWT.NONE);
		FormData folderReShowfd = new FormData();
		folderReShowfd.top = new FormAttachment( 0, 10);
		folderReShowfd.left = new FormAttachment(0, 10);
		folderReShowfd.bottom = new FormAttachment(90,-5);
		folderReShowfd.right = new FormAttachment(100, -2);
		folderResShow.setLayoutData(folderReShowfd);
		
		TabItem tbtmTable = new TabItem(folderResShow, SWT.NONE);
		tbtmTable.setText("列表显示");
		
		Composite compTableShow = new Composite(folderResShow, SWT.NONE);
		compTableShow.setLayout(new FormLayout());
		tbtmTable.setControl(compTableShow);
		FormData compTableShowfd = new FormData();
		compTableShowfd.top = new FormAttachment( 0, 10);
		compTableShowfd.left = new FormAttachment(0, 10);
		compTableShowfd.bottom = new FormAttachment(100,-2);
		compTableShowfd.right = new FormAttachment(100, -2);
		compTableShow.setLayoutData(compTableShowfd);
		
		table = new Table(compTableShow, SWT.BORDER | SWT.FULL_SELECTION | SWT.MULTI | SWT.CHECK);
		FormData tablefd = new FormData();
		tablefd.top = new FormAttachment( 0, 2);
		tablefd.left = new FormAttachment(0, 2);
		tablefd.bottom = new FormAttachment(100,-2);
		tablefd.right = new FormAttachment(100, -2);
		table.setLayoutData(tablefd);
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
		
		Button btnExit = new Button(this, SWT.NONE);
		FormData btnExisfd = new FormData();
		btnExisfd.top = new FormAttachment( folderResShow,3);
		btnExisfd.bottom = new FormAttachment(100,-10);
		btnExisfd.left = new FormAttachment(90,3);
		btnExisfd.right = new FormAttachment(100,-5);
		btnExit.setLayoutData(btnExisfd);
		btnExit.setText("退出");
		
		//获取已经选择的表项的内容
		Button choosebutton = new Button(this, SWT.NONE);
		choosebutton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent arg0) {
				
				TableItem []chooseItem = table.getItems();
				for(int i=0;i<chooseItem.length;i++){
					if(chooseItem[i].getChecked()){
						chooseItem[i].setText(2, "true");
					}
				}
			}
		});
		FormData choosebntfd = new FormData();
		choosebntfd.top = new FormAttachment( folderResShow, 3);
		choosebntfd.left = new FormAttachment(80,5);
		choosebntfd.bottom = new FormAttachment(100,-10);
		choosebntfd.right = new FormAttachment(btnExit,-5);
		choosebutton.setLayoutData(choosebntfd);
		choosebutton.setText("选择项目");
		
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
