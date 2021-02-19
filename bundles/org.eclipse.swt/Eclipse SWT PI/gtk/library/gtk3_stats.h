/*******************************************************************************
 * Copyright (c) 2000, 2021 IBM Corporation and others.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation
 *******************************************************************************/

/* Note: This file was auto-generated by org.eclipse.swt.tools.internal.JNIGenerator */
/* DO NOT EDIT - your changes will be lost. */

#ifdef NATIVE_STATS
extern int GTK3_nativeFunctionCount;
extern int GTK3_nativeFunctionCallCount[];
extern char* GTK3_nativeFunctionNames[];
#define GTK3_NATIVE_ENTER(env, that, func) GTK3_nativeFunctionCallCount[func]++;
#define GTK3_NATIVE_EXIT(env, that, func) 
#else
#ifndef GTK3_NATIVE_ENTER
#define GTK3_NATIVE_ENTER(env, that, func) 
#endif
#ifndef GTK3_NATIVE_EXIT
#define GTK3_NATIVE_EXIT(env, that, func) 
#endif
#endif

typedef enum {
	gtk_1accel_1label_1new_FUNC,
	gtk_1accel_1label_1set_1accel_FUNC,
	gtk_1accel_1label_1set_1accel_1widget_FUNC,
	gtk_1bin_1get_1child_FUNC,
	gtk_1box_1pack_1end_FUNC,
	gtk_1box_1reorder_1child_FUNC,
	gtk_1box_1set_1child_1packing_FUNC,
	gtk_1button_1set_1image_FUNC,
	gtk_1calendar_1get_1date_FUNC,
	gtk_1calendar_1select_1day_FUNC,
	gtk_1calendar_1select_1month_FUNC,
	gtk_1calendar_1set_1display_1options_FUNC,
	gtk_1container_1add_FUNC,
	gtk_1container_1forall_FUNC,
	gtk_1container_1get_1border_1width_FUNC,
	gtk_1container_1get_1children_FUNC,
	gtk_1container_1propagate_1draw_FUNC,
	gtk_1container_1remove_FUNC,
	gtk_1container_1set_1border_1width_FUNC,
	gtk_1dialog_1run_FUNC,
	gtk_1hsv_1to_1rgb_FUNC,
	gtk_1im_1context_1filter_1keypress_FUNC,
	gtk_1rgb_1to_1hsv_FUNC,
} GTK3_FUNCS;
