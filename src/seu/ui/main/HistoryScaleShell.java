package com.seu.ui.main;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

//该界面用于添加历史软件规模，其中ItemShowCp用于展示还添加的项目的具体信息
public class HistoryScaleShell extends Shell {
	private Text ItemNametext;
	private Text ItemVersiontext;
	private Text ItemScaletext;
	private Button addItem;
	private Button btnX;
	private Composite ItemShowCp;

	public HistoryScaleShell(Display display) {
		super(display, SWT.SHELL_TRIM);
		setLayout(null);
		
		Label ItemName = new Label(this, SWT.NONE);
		ItemName.setBounds(10, 10, 47, 15);
		ItemName.setText("项目名称");
		
		Label ItemVersion = new Label(this, SWT.NONE);
		ItemVersion.setBounds(142, 10, 50, 15);
		ItemVersion.setText("项目版本");
		
		Label ItemScale = new Label(this, SWT.NONE);
		ItemScale.setBounds(277, 10, 48, 15);
		ItemScale.setText("项目规模");
		
		ItemNametext = new Text(this, SWT.BORDER);
		ItemNametext.setBounds(63, 7, 73, 18);
		
		ItemVersiontext = new Text(this, SWT.BORDER);
		ItemVersiontext.setBounds(198, 7, 73, 18);
		
		ItemScaletext = new Text(this, SWT.BORDER);
		ItemScaletext.setBounds(331, 7, 61, 21);
		
		addItem = new Button(this, SWT.NONE);
		addItem.setBounds(393, 5, 32, 25);
		addItem.setText("+");
		
		btnX = new Button(this, SWT.NONE);
		btnX.setBounds(427, 5, 32, 25);
		btnX.setText("X");
		
		ItemShowCp = new Composite(this, SWT.NONE);
		ItemShowCp.setBounds(7, 31, 452, 286);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("历史规模输入");
		setSize(478, 356);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
