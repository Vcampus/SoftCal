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

public class CompArgCal extends Composite {

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public CompArgCal(Composite parent, int style) {
		super(parent, style);
		
		final int selecttabItem = 1;//用于标志当前tabItem，若selecttabItem = 1，则是软件演化规模；selecttabItem = 2，则是指数比例因子；selecttabItem = ，则是工作量乘数
		TabFolder tabFolder = new TabFolder(this, SWT.NONE);
		tabFolder.setBounds(10, 10, 616, 505);
		
		TabItem evolutionItem = new TabItem(tabFolder, SWT.NONE);
		evolutionItem.setText("软件演化规模");
		Composite evolutionCp = new Composite(tabFolder, SWT.NONE);
		evolutionItem.setControl(evolutionCp);
		
		TabItem proportionItem = new TabItem(tabFolder, SWT.NONE);
		proportionItem.setText("指数比例因子 ");
		Composite proportionCp = new Composite(tabFolder, SWT.NONE);
		proportionItem.setControl(proportionCp);
		
		TabItem workloadItem = new TabItem(tabFolder, SWT.NONE);
		workloadItem.setText("工作量乘数");
		Composite workloadCp = new Composite(tabFolder, SWT.NONE);
		workloadItem.setControl(workloadCp);
		
		Button historydataBtn = new Button(this, SWT.NONE);
		historydataBtn.addMouseListener(new MouseAdapter() {
			public void mouseDown(MouseEvent arg0) {
				if(selecttabItem == 1){
					try{
						Display display = Display.getDefault();
						HistoryScaleShell shell = new HistoryScaleShell(display);
						shell.open();
						shell.layout();
						while (!shell.isDisposed()) {
							if (!display.readAndDispatch()) {
								display.sleep();
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}else if (selecttabItem == 2){
					//跳出指数比例因子输入界面
				}else if( selecttabItem == 3){
					//跳出工作量乘数的输入界面
				}
			}
		});
		historydataBtn.setBounds(51, 521, 80, 25);
		historydataBtn.setText("历史数据录入");
		
		Button estimationdataBtn = new Button(this, SWT.NONE);
		estimationdataBtn.addMouseListener(new MouseAdapter() {
			public void mouseDown(MouseEvent arg0){
				if(selecttabItem == 1){
					try {
						Display display = Display.getDefault();
						FunctionPointShell shell = new FunctionPointShell(display);
						shell.open();
						shell.layout();
						while (!shell.isDisposed()) {
							if (!display.readAndDispatch()) {
								display.sleep();
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}else if (selecttabItem == 2){
					try {
						Display display = Display.getDefault();
						ProportionShell shell = new ProportionShell(display);
						shell.open();
						shell.layout();
						while (!shell.isDisposed()) {
							if (!display.readAndDispatch()) {
								display.sleep();
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}else if( selecttabItem == 3){
					//跳出估算工作量乘数的输入界面
				}
			}
		});
		estimationdataBtn.setBounds(268, 521, 80, 25);
		estimationdataBtn.setText("数据估算");
		
		Button calculateBtn = new Button(this, SWT.NONE);
		calculateBtn.addMouseListener(new MouseAdapter() {
			public void mouseDown(MouseEvent arg0) {
				//若各参数输入完成，则计算演化成本
			}
		});
		calculateBtn.setBounds(516, 521, 80, 25);
		calculateBtn.setText("计算演化成本");
		
		

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
