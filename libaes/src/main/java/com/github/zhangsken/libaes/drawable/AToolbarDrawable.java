package com.github.zhangsken.libaes.drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

public class AToolbarDrawable extends GradientDrawable {
    int mnStartColor;
    int mnCenterColor;
    int mnEndColor;
    
    public AToolbarDrawable(android.graphics.drawable.GradientDrawable.Orientation orientation, int nStartColor, int nCenterColor, int nEndColor) {
        
        super(orientation, new int[]{nStartColor, nCenterColor,nEndColor});
        mnStartColor = nStartColor;
        mnCenterColor= nCenterColor;
        mnEndColor = nEndColor;
        
    }
    
    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        
    }
}
