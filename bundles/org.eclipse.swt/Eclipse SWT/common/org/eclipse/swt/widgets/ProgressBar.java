/*******************************************************************************
 * Copyright (c) 2000, 2012 IBM Corporation and others.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.swt.widgets;


import org.eclipse.swt.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.internal.win32.*;

/**
 * Instances of the receiver represent an unselectable
 * user interface object that is used to display progress,
 * typically in the form of a bar.
 * <dl>
 * <dt><b>Styles:</b></dt>
 * <dd>SMOOTH, HORIZONTAL, VERTICAL, INDETERMINATE</dd>
 * <dt><b>Events:</b></dt>
 * <dd>(none)</dd>
 * </dl>
 * <p>
 * Note: Only one of the styles HORIZONTAL and VERTICAL may be specified.
 * </p><p>
 * IMPORTANT: This class is <em>not</em> intended to be subclassed.
 * </p>
 *
 * @see <a href="http://www.eclipse.org/swt/snippets/#progressbar">ProgressBar snippets</a>
 * @see <a href="http://www.eclipse.org/swt/examples.php">SWT Example: ControlExample</a>
 * @see <a href="http://www.eclipse.org/swt/">Sample code and further information</a>
 * @noextend This class is not intended to be subclassed by clients.
 */
public class ProgressBar extends Control implements ICustomWidget {
	static final int DELAY = 100;
	static final int TIMER_ID = 100;
	static final int MINIMUM_WIDTH = 100;

	private int state = SWT.NORMAL;

	private int minimum = 0;
	private int maximum = 100;
	private int selection = 0;


/**
 * Constructs a new instance of this class given its parent
 * and a style value describing its behavior and appearance.
 * <p>
 * The style value is either one of the style constants defined in
 * class <code>SWT</code> which is applicable to instances of this
 * class, or must be built by <em>bitwise OR</em>'ing together
 * (that is, using the <code>int</code> "|" operator) two or more
 * of those <code>SWT</code> style constants. The class description
 * lists the style constants that are applicable to the class.
 * Style bits are also inherited from superclasses.
 * </p>
 *
 * @param parent a composite control which will be the parent of the new instance (cannot be null)
 * @param style the style of control to construct
 *
 * @exception IllegalArgumentException <ul>
 *    <li>ERROR_NULL_ARGUMENT - if the parent is null</li>
 * </ul>
 * @exception SWTException <ul>
 *    <li>ERROR_THREAD_INVALID_ACCESS - if not called from the thread that created the parent</li>
 *    <li>ERROR_INVALID_SUBCLASS - if this class is not an allowed subclass</li>
 * </ul>
 *
 * @see SWT#SMOOTH
 * @see SWT#HORIZONTAL
 * @see SWT#VERTICAL
 * @see SWT#INDETERMINATE
 * @see Widget#checkSubclass
 * @see Widget#getStyle
 */
public ProgressBar (Composite parent, int style) {
	super (parent, checkStyle (style));

	Listener listener = event -> {
		switch (event.type) {
//		case SWT.MouseEnter -> onMouseEnter();
//		case SWT.MouseExit -> onMouseExit();
//		case SWT.Dispose -> onDispose(event);
//		case SWT.MouseDown -> onMouseDown(event);
//		case SWT.MouseUp -> onMouseUp(event);
		case SWT.Paint -> onPaint(event);
//		case SWT.Resize -> onResize();
//		case SWT.FocusIn -> onFocusIn();
//		case SWT.FocusOut -> onFocusOut();
//		case SWT.Traverse -> onTraverse(event);
//		case SWT.Selection -> onSelection(event);
//		case SWT.KeyDown -> onKeyDown(event);
//		case SWT.KeyUp -> onKeyUp(event);
		}
	};
	addListener(SWT.Dispose, listener);
	addListener(SWT.MouseDown, listener);
	addListener(SWT.MouseUp, listener);
	addListener(SWT.Paint, listener);
	addListener(SWT.Resize, listener);
	addListener(SWT.KeyUp, listener);
	addListener(SWT.KeyDown, listener);
	addListener(SWT.FocusIn, listener);
	addListener(SWT.FocusOut, listener);
	addListener(SWT.Traverse, listener);
	addListener(SWT.Selection, listener);
	addListener(SWT.MouseEnter, listener);
	addListener(SWT.MouseExit, listener);
}

static int checkStyle (int style) {
	style |= SWT.NO_FOCUS;
	return checkBits (style, SWT.HORIZONTAL, SWT.VERTICAL, 0, 0, 0, 0);
}

@Override Point computeSizeInPixels (int wHint, int hHint, boolean changed) {
	checkWidget ();
	int border = getBorderWidthInPixels ();
	int width = border * 2, height = border * 2;
	if ((style & SWT.HORIZONTAL) != 0) {
		width += getSystemMetrics (OS.SM_CXHSCROLL) * 10;
		height += getSystemMetrics (OS.SM_CYHSCROLL);
	} else {
		width += getSystemMetrics (OS.SM_CXVSCROLL);
		height += getSystemMetrics (OS.SM_CYVSCROLL) * 10;
	}
	if (wHint != SWT.DEFAULT) width = wHint + (border * 2);
	if (hHint != SWT.DEFAULT) height = hHint + (border * 2);
	return new Point (width, height);
}

@Override
void createHandle () {
	super.createHandle ();

	if (display.progressbarUseColors) {
		char[] noTheme = new char[]{0};
		OS.SetWindowTheme(handle, noTheme, noTheme);
	}

	startTimer ();
}


/**
 * Returns the maximum value which the receiver will allow.
 *
 * @return the maximum
 *
 * @exception SWTException <ul>
 *    <li>ERROR_WIDGET_DISPOSED - if the receiver has been disposed</li>
 *    <li>ERROR_THREAD_INVALID_ACCESS - if not called from the thread that created the receiver</li>
 * </ul>
 */
public int getMaximum () {
	checkWidget ();
	return this.maximum;
}

/**
 * Returns the minimum value which the receiver will allow.
 *
 * @return the minimum
 *
 * @exception SWTException <ul>
 *    <li>ERROR_WIDGET_DISPOSED - if the receiver has been disposed</li>
 *    <li>ERROR_THREAD_INVALID_ACCESS - if not called from the thread that created the receiver</li>
 * </ul>
 */
public int getMinimum () {
	checkWidget ();
	return this.minimum;
}

/**
 * Returns the single 'selection' that is the receiver's position.
 *
 * @return the selection
 *
 * @exception SWTException <ul>
 *    <li>ERROR_WIDGET_DISPOSED - if the receiver has been disposed</li>
 *    <li>ERROR_THREAD_INVALID_ACCESS - if not called from the thread that created the receiver</li>
 * </ul>
 */
public int getSelection () {
	checkWidget ();
	return this.selection;
}

/**
 * Returns the state of the receiver. The value will be one of:
 * <ul>
 * 	<li>{@link SWT#NORMAL}</li>
 * 	<li>{@link SWT#ERROR}</li>
 * 	<li>{@link SWT#PAUSED}</li>
 * </ul>
 *
 * @return the state
 *
 * @exception SWTException <ul>
 *    <li>ERROR_WIDGET_DISPOSED - if the receiver has been disposed</li>
 *    <li>ERROR_THREAD_INVALID_ACCESS - if not called from the thread that created the receiver</li>
 * </ul>
 *
 * @since 3.4
 */
public int getState () {
	checkWidget ();

	return this.state;
}

@Override
void releaseWidget () {
	super.releaseWidget ();
	stopTimer ();
}

void startTimer () {
	if ((style & SWT.INDETERMINATE) != 0) {
		int bits = OS.GetWindowLong (handle, OS.GWL_STYLE);
		if ((bits & OS.PBS_MARQUEE) == 0) {
			OS.SetTimer (handle, TIMER_ID, DELAY, 0);
		} else {
			OS.SendMessage (handle, OS.PBM_SETMARQUEE, 1, DELAY);
		}
	}
}

void stopTimer () {
	if ((style & SWT.INDETERMINATE) != 0) {
		int bits = OS.GetWindowLong (handle, OS.GWL_STYLE);
		if ((bits & OS.PBS_MARQUEE) == 0) {
			OS.KillTimer (handle, TIMER_ID);
		} else {
			OS.SendMessage (handle, OS.PBM_SETMARQUEE, 0, 0);
		}
	}
}

/**
 * Sets the maximum value that the receiver will allow.  This new
 * value will be ignored if it is not greater than the receiver's current
 * minimum value.  If the new maximum is applied then the receiver's
 * selection value will be adjusted if necessary to fall within its new range.
 *
 * @param value the new maximum, which must be greater than the current minimum
 *
 * @exception SWTException <ul>
 *    <li>ERROR_WIDGET_DISPOSED - if the receiver has been disposed</li>
 *    <li>ERROR_THREAD_INVALID_ACCESS - if not called from the thread that created the receiver</li>
 * </ul>
 */
public void setMaximum (int value) {
	checkWidget ();
	if (0 <= this.minimum && this.minimum < value && value != this.maximum) {
		this.maximum = value;
		this.redraw();
	}
}

/**
 * Sets the minimum value that the receiver will allow.  This new
 * value will be ignored if it is negative or is not less than the receiver's
 * current maximum value.  If the new minimum is applied then the receiver's
 * selection value will be adjusted if necessary to fall within its new range.
 *
 * @param value the new minimum, which must be nonnegative and less than the current maximum
 *
 * @exception SWTException <ul>
 *    <li>ERROR_WIDGET_DISPOSED - if the receiver has been disposed</li>
 *    <li>ERROR_THREAD_INVALID_ACCESS - if not called from the thread that created the receiver</li>
 * </ul>
 */
public void setMinimum (int value) {
	checkWidget ();

	if (0 <= value && value < this.maximum && value != this.minimum) {
		this.minimum = value;
		this.redraw();
	}
}

/**
 * Sets the single 'selection' that is the receiver's
 * position to the argument which must be greater than or equal
 * to zero.
 *
 * @param value the new selection (must be zero or greater)
 *
 * @exception SWTException <ul>
 *    <li>ERROR_WIDGET_DISPOSED - if the receiver has been disposed</li>
 *    <li>ERROR_THREAD_INVALID_ACCESS - if not called from the thread that created the receiver</li>
 * </ul>
 */
public void setSelection (int value) {
	checkWidget ();

	if (this.minimum >= 0) {
		this.selection = value;
		this.redraw();
	}
}

/**
 * Sets the state of the receiver. The state must be one of these values:
 * <ul>
 * 	<li>{@link SWT#NORMAL}</li>
 * 	<li>{@link SWT#ERROR}</li>
 * 	<li>{@link SWT#PAUSED}</li>
 * </ul>
 * <p>
 * Note: This operation is a hint and is not supported on
 * platforms that do not have this concept.
 * </p>
 *
 * @param state the new state
 *
 * @exception SWTException <ul>
 *    <li>ERROR_WIDGET_DISPOSED - if the receiver has been disposed</li>
 *    <li>ERROR_THREAD_INVALID_ACCESS - if not called from the thread that created the receiver</li>
 * </ul>
 *
 * @since 3.4
 */
public void setState (int state) {
	checkWidget ();
	switch (state) {
		case SWT.NORMAL:
			OS.SendMessage (handle, OS.PBM_SETSTATE, OS.PBST_NORMAL, 0);
			break;
		case SWT.ERROR:
			OS.SendMessage (handle, OS.PBM_SETSTATE, OS.PBST_ERROR, 0);
			break;
		case SWT.PAUSED:
			OS.SendMessage (handle, OS.PBM_SETSTATE, OS.PBST_PAUSED, 0);
			break;
	}
}

private void onPaint(Event event) {
	if (!isVisible()) {
		return;
	}
	Drawing.drawWithGC(this, event.gc, this::doPaint);
}

private void doPaint(GC gc) {
	Rectangle r = getBounds();
	if (r.width == 0 && r.height == 0) {
		return;
	}
	gc.setForeground(getDisplay().getSystemColor(SWT.COLOR_CYAN));
	gc.setBackground(getDisplay().getSystemColor(SWT.COLOR_RED));
	int xPos = r.x;
	int yPos = r.y;
	int width = r.width;
	int height = r.height;

	float visualizationValue = this.selection;
	float size = visualizationValue / (this.maximum - this.minimum);
	if ((style & SWT.VERTICAL) != 0) {
		gc.fillRectangle(0, 0, width, (int) (height * size));
	} else {
		// Horizontal
		gc.fillRectangle(0, 0, (int) (width * size), height);
	}
}

}
