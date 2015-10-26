package com.seu.ui;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;

public class CompWorkCal extends Composite {
	private Text text;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public CompWorkCal(Composite parent, int style) {
		super(parent, style);
		
		text = new Text(this, SWT.BORDER);
		text.setText("变更功能点输入");
		text.setBounds(10, 10, 73, 23);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
