/*******************************************************************************
 * Copyright (c) 2000, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.swt.internal.gdip;

import org.eclipse.swt.internal.*;

public class Gdip extends Platform {
	static {
		Library.loadLibrary ("swt-gdip"); //$NON-NLS-1$
	}
	
	/** GdiPlus constants */
	public static final float FlatnessDefault = 0.25f;
	public static final int BrushTypeSolidColor = 0;
	public static final int BrushTypeHatchFill = 1;
	public static final int BrushTypeTextureFill = 2;
	public static final int BrushTypePathGradient = 3;
	public static final int BrushTypeLinearGradient = 4;
	public static final int ColorAdjustTypeBitmap = 1;
	public static final int ColorMatrixFlagsDefault = 0;
	public static final int CombineModeReplace = 0;
	public static final int CombineModeIntersect = 1;
	public static final int CombineModeUnion = 2;
	public static final int CombineModeXor = 3;
	public static final int CombineModeExclude = 4;
	public static final int CombineModeComplement = 5;
	public static final int FillModeAlternate = 0;
	public static final int FillModeWinding = 1;
	public static final int DashCapFlat = 0;
	public static final int DashCapRound = 2;
	public static final int DashCapTriangle = 3;
	public static final int DashStyleSolid = 0;
	public static final int DashStyleDash = 1;
	public static final int DashStyleDot = 2;
	public static final int DashStyleDashDot = 3;
	public static final int DashStyleDashDotDot = 4;
	public static final int DashStyleCustom = 5;
	public static final int DriverStringOptionsRealizedAdvance = 4; 
	public static final int FontStyleRegular = 0;
	public static final int FontStyleBold = 1;
	public static final int FontStyleItalic = 2;
	public static final int FontStyleBoldItalic = 3;
	public static final int FontStyleUnderline = 4;
	public static final int FontStyleStrikeout = 8;
	public static final int PaletteFlagsHasAlpha = 0x0001;
	public static final int FlushIntentionFlush = 0;
	public static final int FlushIntentionSync = 1;
	public static final int HotkeyPrefixNone = 0;
	public static final int HotkeyPrefixShow = 1;
	public static final int HotkeyPrefixHide = 2;
	public static final int LineJoinMiter = 0;
	public static final int LineJoinBevel = 1;
	public static final int LineJoinRound = 2;
	public static final int LineCapFlat = 0;
	public static final int LineCapSquare = 1;
	public static final int LineCapRound = 2;
	public static final int MatrixOrderPrepend = 0;
	public static final int MatrixOrderAppend = 1;
	public static final int QualityModeDefault = 0;
	public static final int QualityModeLow = 1;
	public static final int QualityModeHigh = 2;
	public static final int InterpolationModeDefault = QualityModeDefault;
	public static final int InterpolationModeLowQuality = QualityModeLow;
	public static final int InterpolationModeHighQuality = QualityModeHigh;
	public static final int InterpolationModeBilinear = QualityModeHigh + 1;
	public static final int InterpolationModeBicubic = QualityModeHigh + 2;
	public static final int InterpolationModeNearestNeighbor = QualityModeHigh + 3;
	public static final int InterpolationModeHighQualityBilinear = QualityModeHigh + 4;
	public static final int InterpolationModeHighQualityBicubic = QualityModeHigh + 5;
	public static final int PathPointTypeStart = 0;
	public static final int PathPointTypeLine = 1;
	public static final int PathPointTypeBezier = 3;
	public static final int PathPointTypePathTypeMask = 0x7;
	public static final int PathPointTypePathDashMode = 0x10;
	public static final int PathPointTypePathMarker = 0x20;
	public static final int PathPointTypeCloseSubpath = 0x80;
	public static final int PathPointTypeBezier3 = 3;
	public static final int PixelFormatIndexed = 0x00010000;
	public static final int PixelFormatGDI = 0x00020000;
	public static final int PixelFormatAlpha = 0x00040000;
	public static final int PixelFormatPAlpha = 0x00080000;
	public static final int PixelFormatExtended = 0x00100000;
	public static final int PixelFormatCanonical = 0x00200000;
	public static final int PixelFormat1bppIndexed = (1 | ( 1 << 8) | PixelFormatIndexed | PixelFormatGDI);
	public static final int PixelFormat4bppIndexed = (2 | ( 4 << 8) | PixelFormatIndexed | PixelFormatGDI);
	public static final int PixelFormat8bppIndexed = (3 | ( 8 << 8) | PixelFormatIndexed | PixelFormatGDI);
	public static final int PixelFormat16bppGrayScale = (4 | (16 << 8) | PixelFormatExtended);
	public static final int PixelFormat16bppRGB555 = (5 | (16 << 8) | PixelFormatGDI);
	public static final int PixelFormat16bppRGB565 = (6 | (16 << 8) | PixelFormatGDI);
	public static final int PixelFormat16bppARGB1555 = (7 | (16 << 8) | PixelFormatAlpha | PixelFormatGDI);
	public static final int PixelFormat24bppRGB = (8 | (24 << 8) | PixelFormatGDI);
	public static final int PixelFormat32bppRGB = (9 | (32 << 8) | PixelFormatGDI);
	public static final int PixelFormat32bppARGB = (10 | (32 << 8) | PixelFormatAlpha | PixelFormatGDI | PixelFormatCanonical);
	public static final int PixelFormat32bppPARGB = (11 | (32 << 8) | PixelFormatAlpha | PixelFormatPAlpha | PixelFormatGDI);
	public static final int PixelFormat48bppRGB = (12 | (48 << 8) | PixelFormatExtended);
	public static final int PixelFormat64bppARGB = (13 | (64 << 8) | PixelFormatAlpha  | PixelFormatCanonical | PixelFormatExtended);
	public static final int PixelFormat64bppPARGB = (14 | (64 << 8) | PixelFormatAlpha  | PixelFormatPAlpha | PixelFormatExtended);
	public static final int PixelFormatMax = 15;
	public static final int PixelOffsetModeNone = QualityModeHigh + 1;
	public static final int PixelOffsetModeHalf = QualityModeHigh + 2;
	public static final int SmoothingModeDefault = QualityModeDefault;
	public static final int SmoothingModeHighSpeed = QualityModeLow;
	public static final int SmoothingModeHighQuality = QualityModeHigh;
	public static final int SmoothingModeNone = 3;
	public static final int SmoothingModeAntiAlias8x4 = 4;
	public static final int SmoothingModeAntiAlias = SmoothingModeAntiAlias8x4;
	public static final int SmoothingModeAntiAlias8x8 = 5;
	public static final int StringFormatFlagsDirectionRightToLeft = 0x00000001;
	public static final int StringFormatFlagsDirectionVertical = 0x00000002;
	public static final int StringFormatFlagsNoFitBlackBox = 0x00000004;
	public static final int StringFormatFlagsDisplayFormatControl = 0x00000020;
	public static final int StringFormatFlagsNoFontFallback = 0x00000400;
	public static final int StringFormatFlagsMeasureTrailingSpaces = 0x00000800;
	public static final int StringFormatFlagsNoWrap = 0x00001000;
	public static final int StringFormatFlagsLineLimit = 0x00002000;
	public static final int StringFormatFlagsNoClip = 0x00004000;
	public static final int TextRenderingHintSystemDefault = 0;
	public static final int TextRenderingHintSingleBitPerPixelGridFit = 1;
	public static final int TextRenderingHintSingleBitPerPixel = 2;
	public static final int TextRenderingHintAntiAliasGridFit = 3;
	public static final int TextRenderingHintAntiAlias = 4;
	public static final int TextRenderingHintClearTypeGridFit = 5;
	public static final int UnitPixel = 2;
	public static final int WrapModeTile = 0;
	public static final int WrapModeTileFlipX = 1;
	public static final int WrapModeTileFlipY = 2;
	public static final int WrapModeTileFlipXY = 3;
	public static final int WrapModeClamp = 4;

/** 64 bit */
public static final native int ColorPalette_sizeof();
public static final native int GdiplusStartupInput_sizeof();

/** GdiPlus natives */
public static final native int GdiplusStartup(int /*long*/[] token, GdiplusStartupInput input, int /*long*/ output);
public static final native void GdiplusShutdown(int /*long*/ token);
public static final native int /*long*/ Bitmap_new(int /*long*/ hbm, int /*long*/ hpal);
public static final native int /*long*/ Bitmap_new(int /*long*/ hicon);
public static final native int /*long*/ Bitmap_new(int width, int height, int stride, int format, int /*long*/ scan0);
public static final native int /*long*/ Bitmap_new(char[] filename, boolean useIcm);
public static final native void Bitmap_delete(int /*long*/ bitmap);
public static final native int Bitmap_GetHBITMAP(int /*long*/ bitmap, int /*long*/ colorBackground, int /*long*/[] hbmReturn);
public static final native int Bitmap_GetHICON(int /*long*/ bitmap, int /*long*/[] hicon);
public static final native int /*long*/ BitmapData_new();
public static final native void BitmapData_delete(int /*long*/ bitmapData);
public static final native int Bitmap_LockBits(int /*long*/ bitmap, int /*long*/ rect, int flags, int pixelFormat, int /*long*/ lockedBitmapData);
public static final native int Bitmap_UnlockBits(int /*long*/ bitmap, int /*long*/ lockedBitmapData);
public static final native int /*long*/ Brush_Clone(int /*long*/ brush);
public static final native int Brush_GetType(int /*long*/ brush);
public static final native int /*long*/ Color_new(int argb);
public static final native void Color_delete(int /*long*/ color);
public static final native int /*long*/ Font_new(int /*long*/ hdc, int /*long*/ hfont);
public static final native int /*long*/ Font_new(char[] familyName, float emSize, int style, int unit, int /*long*/ fontCollection);
public static final native void Font_delete(int /*long*/ font);
public static final native int Font_GetFamily(int /*long*/ font, int /*long*/ family);
public static final native float Font_GetSize(int /*long*/ font);
public static final native int Font_GetStyle(int /*long*/ font);
public static final native boolean Font_IsAvailable(int /*long*/ font);
public static final native int /*long*/ FontFamily_new();
public static final native void FontFamily_delete(int /*long*/ family);
public static final native int FontFamily_GetFamilyName(int /*long*/ family, char[] name, char language);
public static final native int /*long*/ Graphics_new(int /*long*/ hdc);
public static final native void Graphics_delete(int /*long*/ graphics);
public static final native int Graphics_DrawArc(int /*long*/ graphics, int /*long*/ pen, int x, int y, int width, int height, float startAngle, float sweepAngle);
public static final native int Graphics_DrawDriverString( int /*long*/ graphics, int /*long*/ text, int length, int /*long*/ font, int /*long*/ brush, PointF /*long*/ positions, int flags, int /*long*/ matrix);
public static final native int Graphics_DrawEllipse(int /*long*/ graphics, int /*long*/ pen, int x, int y, int width, int height);
public static final native int Graphics_DrawImage(int /*long*/ graphics, int /*long*/ image, int x, int y);
public static final native int Graphics_DrawImage(int /*long*/ graphics, int /*long*/ image, Rect destRect, int srcx, int srcy, int srcwidth, int srcheight, int srcUnit, int /*long*/ imageAttributes, int /*long*/ callback, int /*long*/ callbackData);
public static final native int Graphics_DrawLine(int /*long*/ graphics, int /*long*/ pen, int x1, int y1, int x2, int y2);
public static final native int Graphics_DrawLines(int /*long*/ graphics, int /*long*/ pen, int[] points, int count);
public static final native int Graphics_DrawPath(int /*long*/ graphics, int /*long*/ pen, int /*long*/ path);
public static final native int Graphics_DrawPolygon(int /*long*/ graphics, int /*long*/ pen, int[] points, int count);
public static final native int Graphics_DrawRectangle(int /*long*/ graphics, int /*long*/ pen, int x, int y, int width, int height);
public static final native int Graphics_DrawString(int /*long*/ graphics, char[] string, int length, int /*long*/ font, PointF origin, int /*long*/ brush);
public static final native int Graphics_DrawString(int /*long*/ graphics, char[] string, int length, int /*long*/ font, PointF origin, int /*long*/ format, int /*long*/ brush);
public static final native int Graphics_FillEllipse(int /*long*/ graphics, int /*long*/ brush, int x, int y, int width, int height);
public static final native int Graphics_FillPath(int /*long*/ graphics, int /*long*/ brush, int /*long*/ path);
public static final native void Graphics_Flush(int /*long*/ graphics, int intention);
public static final native int Graphics_FillPie(int /*long*/ graphics, int /*long*/ brush, int x, int y, int width, int height, float startAngle, float sweepAngle);
public static final native int Graphics_FillPolygon(int /*long*/ graphics, int /*long*/ brush, int[] points, int count, int fillMode);
public static final native int Graphics_FillRectangle(int /*long*/ graphics, int /*long*/ brush, int x, int y, int width, int height);
public static final native int Graphics_GetClipBounds(int /*long*/ graphics, RectF rect);
public static final native int Graphics_GetClipBounds(int /*long*/ graphics, Rect rect);
public static final native int Graphics_GetClip(int /*long*/ graphics, int /*long*/ region);
public static final native int /*long*/ Graphics_GetHDC(int /*long*/ graphics);
public static final native void Graphics_ReleaseHDC(int /*long*/ graphics, int /*long*/ hdc);
public static final native int Graphics_GetInterpolationMode(int /*long*/ graphics);
public static final native int Graphics_GetSmoothingMode(int /*long*/ graphics);
public static final native int Graphics_GetTextRenderingHint(int /*long*/ graphics);
public static final native int Graphics_GetTransform(int /*long*/ graphics, int /*long*/ matrix);
public static final native int Graphics_GetVisibleClipBounds(int /*long*/ graphics, Rect rect);
public static final native int Graphics_MeasureString(int /*long*/ graphics, char[] string, int length, int /*long*/ font, PointF origin, RectF boundingBox);
public static final native int Graphics_MeasureString(int /*long*/ graphics, char[] string, int length, int /*long*/ font, PointF origin, int /*long*/ format, RectF boundingBox);
public static final native int Graphics_ResetClip(int /*long*/ graphics);
public static final native int Graphics_Restore(int /*long*/ graphics, int gstate);
public static final native int Graphics_Save(int /*long*/ graphics);
public static final native int Graphics_ScaleTransform(int /*long*/ graphics, float sx, float sy, int order);
public static final native int Graphics_SetClip(int /*long*/ graphics, int /*long*/ hrgn, int combineMode);
public static final native int Graphics_SetClip(int /*long*/ graphics, Rect rect, int combineMode);
public static final native int Graphics_SetClipPath(int /*long*/ graphics, int /*long*/ path);
public static final native int Graphics_SetClipPath(int /*long*/ graphics, int /*long*/ path, int combineMode);
public static final native int Graphics_SetCompositingQuality(int /*long*/ graphics, int compositingQuality);
public static final native int Graphics_SetPageUnit(int /*long*/ graphics, int unit);
public static final native int Graphics_SetPixelOffsetMode(int /*long*/ graphics, int pixelOffsetMode);
public static final native int Graphics_SetSmoothingMode(int /*long*/ graphics, int smoothingMode);
public static final native int Graphics_SetTransform(int /*long*/ graphics, int /*long*/ matrix);
public static final native int Graphics_SetInterpolationMode(int /*long*/ graphics, int mode);
public static final native int Graphics_SetTextRenderingHint(int /*long*/ graphics, int mode);
public static final native int Graphics_TranslateTransform(int /*long*/ graphics, float dx, float dy, int order);
public static final native int /*long*/ GraphicsPath_new(int fillMode);
public static final native int /*long*/ GraphicsPath_new(int[] points, byte[] types, int count, int fillMode);
public static final native void GraphicsPath_delete(int /*long*/ path);
public static final native int GraphicsPath_AddArc(int /*long*/ path, float x, float y, float width, float height, float startAngle, float sweepAngle);
public static final native int GraphicsPath_AddBezier(int /*long*/ path, float x1, float y1, float x2, float y2, float x3, float y3, float x4, float y4);
public static final native int GraphicsPath_AddLine(int /*long*/ path, float x1, float y1, float x2, float y2);
public static final native int GraphicsPath_AddPath(int /*long*/ path, int /*long*/ addingPath, boolean connect);
public static final native int GraphicsPath_AddRectangle(int /*long*/ path, RectF rect);
public static final native int GraphicsPath_AddString(int /*long*/ path, char[] string, int length, int /*long*/ family, int style, float emSize, PointF origin, int /*long*/ format);
public static final native int GraphicsPath_CloseFigure(int /*long*/ path);
public static final native int /*long*/ GraphicsPath_Clone(int /*long*/ path);
public static final native int GraphicsPath_Flatten(int /*long*/ path, int /*long*/ matrix, float flatness);
public static final native int GraphicsPath_GetBounds(int /*long*/ path, RectF bounds, int /*long*/ matrix, int /*long*/ pen);
public static final native int GraphicsPath_GetLastPoint(int /*long*/ path, PointF lastPoint);
public static final native int GraphicsPath_GetPathPoints(int /*long*/ path, float[] points, int count);
public static final native int GraphicsPath_GetPathTypes(int /*long*/ path, byte[] types, int count);
public static final native int GraphicsPath_GetPointCount(int /*long*/ path);
public static final native boolean GraphicsPath_IsOutlineVisible(int /*long*/ path, float x, float y, int /*long*/ pen, int /*long*/ g);
public static final native boolean GraphicsPath_IsVisible(int /*long*/ path, float x, float y, int /*long*/ g);
public static final native int GraphicsPath_SetFillMode(int /*long*/ path, int fillmode);
public static final native int GraphicsPath_StartFigure(int /*long*/ path);
public static final native int GraphicsPath_Transform(int /*long*/ path, int /*long*/ matrix);
public static final native int /*long*/ HatchBrush_new(int hatchStyle, int /*long*/ foreColor, int /*long*/ backColor);
public static final native int Image_GetLastStatus(int /*long*/ image);
public static final native int Image_GetPixelFormat(int /*long*/ image);
public static final native int Image_GetWidth(int /*long*/ image);
public static final native int Image_GetHeight(int /*long*/ image);
public static final native int Image_GetPalette(int /*long*/ image, int /*long*/ palette, int size);
public static final native int Image_GetPaletteSize(int /*long*/ image);
public static final native int /*long*/ ImageAttributes_new();
public static final native void ImageAttributes_delete(int /*long*/ attrib);
public static final native int ImageAttributes_SetWrapMode(int /*long*/ attrib, int wrap);
public static final native int ImageAttributes_SetColorMatrix(int /*long*/ attrib, float[] matrix, int mode, int type);
public static final native void HatchBrush_delete(int /*long*/ brush);
public static final native int /*long*/ LinearGradientBrush_new(PointF point1, PointF point2, int /*long*/ color1, int /*long*/ color2);
public static final native void LinearGradientBrush_delete(int /*long*/ brush);
public static final native int LinearGradientBrush_SetInterpolationColors(int /*long*/ brush, int /*long*/[] presetColors, float[] blendPositions, int count);
public static final native int LinearGradientBrush_SetWrapMode(int /*long*/ brush, int wrapMode);
public static final native int LinearGradientBrush_ResetTransform(int /*long*/ brush);
public static final native int LinearGradientBrush_ScaleTransform(int /*long*/ brush, float sx, float sy, int order);
public static final native int LinearGradientBrush_TranslateTransform(int /*long*/ brush, float dx, float dy, int order);
public static final native int /*long*/ Matrix_new(float m11, float m12, float m21, float m22, float dx, float dy);
public static final native void Matrix_delete(int /*long*/ matrix);
public static final native int Matrix_GetElements(int /*long*/ matrix, float[] m);
public static final native int Matrix_Invert(int /*long*/ matrix);
public static final native boolean Matrix_IsIdentity(int /*long*/ matrix);
public static final native int Matrix_Multiply(int /*long*/ matrix, int /*long*/ matrix1, int order);
public static final native int Matrix_Rotate(int /*long*/ matrix, float angle, int order);
public static final native int Matrix_Scale(int /*long*/ matrix, float scaleX, float scaleY, int order);
public static final native int Matrix_Shear(int /*long*/ matrix, float shearX, float shearY, int order);
public static final native int Matrix_TransformPoints(int /*long*/ matrix, PointF pts, int count);
public static final native int Matrix_TransformPoints(int /*long*/ matrix, float[] pts, int count);
public static final native int Matrix_Translate(int /*long*/ matrix, float offsetX, float offsetY, int order);
public static final native int Matrix_SetElements(int /*long*/ matrix, float m11, float m12, float m21, float m22, float dx, float dy);
public static final native void MoveMemory(ColorPalette Destination, int /*long*/ SourcePtr, int Length);
public static final native void MoveMemory(BitmapData Destination, int /*long*/ SourcePtr);
public static final native int /*long*/ PathGradientBrush_new(int /*long*/ path);
public static final native void PathGradientBrush_delete(int /*long*/ brush);
public static final native int PathGradientBrush_SetCenterColor(int /*long*/ brush, int /*long*/ color);
public static final native int PathGradientBrush_SetCenterPoint(int /*long*/ brush, PointF pt);
public static final native int PathGradientBrush_SetInterpolationColors(int /*long*/ brush, int /*long*/[] presetColors, float[] blendPositions, int count);
public static final native int PathGradientBrush_SetSurroundColors(int /*long*/ brush, int /*long*/[] colors, int[] count);
public static final native int PathGradientBrush_SetGraphicsPath(int /*long*/ brush, int /*long*/ path);
public static final native int PathGradientBrush_SetWrapMode(int /*long*/ brush, int wrapMode);
public static final native int /*long*/ Pen_new(int /*long*/ brush, float width);
public static final native void Pen_delete(int /*long*/ pen);
public static final native int /*long*/ Pen_GetBrush(int /*long*/ pen);
public static final native int Pen_SetBrush(int /*long*/ pen, int /*long*/ brush);
public static final native int Pen_SetDashOffset(int /*long*/ pen, float dashOffset);
public static final native int Pen_SetDashPattern(int /*long*/ pen, float[] dashArray, int count);
public static final native int Pen_SetDashStyle(int /*long*/ pen, int dashStyle);
public static final native int Pen_SetLineCap(int /*long*/ pen, int startCap, int endCap, int dashCap);
public static final native int Pen_SetLineJoin(int /*long*/ pen, int lineJoin);
public static final native int Pen_SetMiterLimit(int /*long*/ pen, float miterLimit);
public static final native int Pen_SetWidth(int /*long*/ pen, float width);
public static final native int /*long*/ Point_new(int x, int y);
public static final native void Point_delete(int /*long*/ point);
public static final native int /*long*/ Region_new(int /*long*/ hRgn);
public static final native int /*long*/ Region_newGraphicsPath(int /*long*/ path);
public static final native int /*long*/ Region_new();
public static final native void Region_delete(int /*long*/ region);
public static final native int /*long*/ Region_GetHRGN(int /*long*/ region, int /*long*/ graphics);
public static final native boolean Region_IsInfinite(int /*long*/ region, int /*long*/ graphics);
public static final native int /*long*/ SolidBrush_new(int /*long*/ color);
public static final native void SolidBrush_delete(int /*long*/ brush);
public static final native void StringFormat_delete(int /*long*/ format);
public static final native int /*long*/ StringFormat_Clone(int /*long*/ format);
public static final native int /*long*/ StringFormat_GenericDefault();
public static final native int /*long*/ StringFormat_GenericTypographic();
public static final native int StringFormat_GetFormatFlags(int /*long*/ format);
public static final native int StringFormat_SetHotkeyPrefix(int /*long*/ format, int hotkeyPrefix);
public static final native int StringFormat_SetFormatFlags(int /*long*/ format, int flags);
public static final native int StringFormat_SetTabStops(int /*long*/ format, float firstTabOffset, int count, float[] tabStops);
public static final native int /*long*/ TextureBrush_new(int /*long*/ image, int wrapMode, float dstX, float dstY, float dstWidth, float dstHeight);
public static final native void TextureBrush_delete(int /*long*/ brush);
public static final native int TextureBrush_SetTransform(int /*long*/ brush, int /*long*/ matrix);
public static final native int TextureBrush_ResetTransform(int /*long*/ brush);
public static final native int TextureBrush_ScaleTransform(int /*long*/ brush, float sx, float sy, int order);
public static final native int TextureBrush_TranslateTransform(int /*long*/ brush, float dx, float dy, int order);
}
