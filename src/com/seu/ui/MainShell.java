package com.seu.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.internal.win32.SYSTEMTIME;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class MainShell extends Shell {
	CompWorkCal compWorkCal;
	CompArgsAdjust compArgsAdjust;
	CompResShow compResShow;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			MainShell shell = new MainShell(display);
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
	}

	/**
	 * Create the shell.
	 * @param display
	 */
	public MainShell(Display display) {
		super(display, SWT.SHELL_TRIM);
		setMinimumSize(new Point(943, 616));
		setLayout(null);
		//参数生成按钮代码和相关响应
		Button btnArgsCal = new Button(this, SWT.NONE);
		btnArgsCal.setBounds(0, 0, 224, 132);
		btnArgsCal.setText("演化成本估算(基于经验模型)");
		btnArgsCal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent arg0) {
				compResShow.setVisible(false);
				compArgsAdjust.setVisible(false);
				compWorkCal.setVisible(true);
			}
		});
		
		//演化工作量按钮代码和响应
		Button btnArgsAdjust = new Button(this, SWT.NONE);
		btnArgsAdjust.setText("演化估算成本公式校准");
		btnArgsAdjust.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent arg0) {
				compResShow.setVisible(false);
				compArgsAdjust.setVisible(true);
				compWorkCal.setVisible(false);
			}
		});
		
		btnArgsAdjust.setBounds(0, 138, 224, 132);
		
		//结果展示按钮代码和响应
		Button btnResShow = new Button(this, SWT.NONE);
		btnResShow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent arg0) {
				compResShow.setVisible(true);
				compArgsAdjust.setVisible(false);
				compWorkCal.setVisible(false);
			}
		});
		btnResShow.setBounds(0, 276, 224, 132);
		btnResShow.setText("结果展示");
		
		
		//主界面布局
		Composite comp_Content = new Composite(this, SWT.NONE);
		comp_Content.setBounds(259, 10, 645, 557);
		
		
		compWorkCal = new CompWorkCal(comp_Content, SWT.NONE);
		compWorkCal.setBounds(0, 0, 645, 557);
		
		compArgsAdjust = new CompArgsAdjust(comp_Content, SWT.NONE);
		compArgsAdjust.setBounds(0, 0, 645, 557);
		
		compResShow = new CompResShow(comp_Content, SWT.NONE);
		compResShow.setBounds(0, 0, 645, 557);
	
		createContents();
		
		
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("SWT Application");
		setSize(450, 300);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
