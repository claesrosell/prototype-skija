/* ***** BEGIN LICENSE BLOCK *****
 * Version: MPL 1.1
 *
 * The contents of this file are subject to the Mozilla Public License Version
 * 1.1 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * http://www.mozilla.org/MPL/
 *
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License
 * for the specific language governing rights and limitations under the
 * License.
 *
 * Contributor(s):
 *
 * IBM
 * -  Binding to permit interfacing between Cairo and SWT
 * -  Copyright (C) 2005 IBM Corp.  All Rights Reserved.
 *
 * ***** END LICENSE BLOCK ***** */

#include "swt.h"
#include "cairo_structs.h"
#include "cairo_stats.h"

#define Cairo_NATIVE(func) Java_org_eclipse_swt_internal_cairo_Cairo_##func

#ifndef NO_cairo_1add_1path
static void moveTo(cairo_t *cairo, double x, double y) {
	cairo_move_to(cairo, x, y);
}

static void lineTo(cairo_t *cairo, double x, double y) {
	cairo_line_to(cairo, x, y);
}

static void curveTo(cairo_t *cairo, double x1, double y1, double x2, double y2, double x3, double y3) {
	cairo_curve_to(cairo, x1, y1, x2, y2, x3, y3);
}

static void closePath(cairo_t *cairo) {
	cairo_close_path(cairo);
}

JNIEXPORT void JNICALL Cairo_NATIVE(cairo_1add_1path)
	(JNIEnv *env, jclass that, SWT_PTR arg0, SWT_PTR arg1)
{
	Cairo_NATIVE_ENTER(env, that, cairo_1add_1path_FUNC);
	cairo_new_path((cairo_t *)arg0);
	cairo_current_path((cairo_t *)arg1, (cairo_move_to_func_t *)moveTo, (cairo_line_to_func_t *)lineTo, (cairo_curve_to_func_t *)curveTo, (cairo_close_path_func_t *)closePath, (void *)arg0);
	Cairo_NATIVE_EXIT(env, that, cairo_1add_1path_FUNC);
}
#endif

#ifndef NO_cairo_1extents
#include <float.h>
#define EXTENTS(x, y, extents) \
	if (x < extents[0]) extents[0] = x; \
	if (y < extents[1]) extents[1] = y; \
	if (x > extents[2]) extents[2] = x; \
	if (y > extents[3]) extents[3] = y;

static void extentsMoveTo(jdouble *extents, double x, double y) {
	EXTENTS(x, y, extents)
}

static void extentsLineTo(jdouble *extents, double x, double y) {
	EXTENTS(x, y, extents)
}

static void extentsCurveTo(jdouble *extents, double x1, double y1, double x2, double y2, double x3, double y3) {
	EXTENTS(x1, y1, extents)
	EXTENTS(x2, y2, extents)
	EXTENTS(x3, y3, extents)
}

static void extentsClosePath(jdouble *extents) {
}

JNIEXPORT void JNICALL Cairo_NATIVE(cairo_1extents)
	(JNIEnv *env, jclass that, jint arg0, jdoubleArray arg1)
{
	jdouble *lparg1=NULL;
	Cairo_NATIVE_ENTER(env, that, cairo_1extents_FUNC);
	if (arg1) if ((lparg1 = (*env)->GetDoubleArrayElements(env, arg1, NULL)) == NULL) goto fail;
	lparg1[0] = lparg1[1] = DBL_MAX;
	lparg1[2] = lparg1[3] = DBL_MIN;
	cairo_current_path((cairo_t *)arg0, (cairo_move_to_func_t *)extentsMoveTo, (cairo_line_to_func_t *)extentsLineTo, (cairo_curve_to_func_t *)extentsCurveTo, (cairo_close_path_func_t *)extentsClosePath, (void *)lparg1);
	if (lparg1[0] == lparg1[1] && lparg1[0] == DBL_MAX) lparg1[0] = lparg1[1] = 0;
	if (lparg1[2] == lparg1[3] && lparg1[2] == DBL_MAX) lparg1[2] = lparg1[3] = 0;
fail:
	if (arg1 && lparg1) (*env)->ReleaseDoubleArrayElements(env, arg1, lparg1, 0);
	Cairo_NATIVE_EXIT(env, that, cairo_1extents_FUNC);
}
#endif
