package com.github.zhangsken.libaes;

import androidx.appcompat.widget.Toolbar;
import android.content.Context;
import android.util.AttributeSet;
import android.graphics.drawable.GradientDrawable;
import android.graphics.Color;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.github.zhangsken.libaes.drawable.AToolbarDrawable;

public class ASupportToolbar extends Toolbar {

    int startColor;
    int centerColor;
    int endColor;

    public ASupportToolbar(Context context) {
        super(context);
    }

    public ASupportToolbar(Context context, AttributeSet attrs) {
        super(context, attrs);

        // 获得TypedArray
        /*TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.AToolbar);
        // 获得attrs.xml里面的属性值,格式为:名称_属性名,后面是默认值
        startColor = a.getColor(R.styleable.AToolbar_attrAToolbarStartColor, context.getColor(R.color.colorAToolbarStartColor));
        centerColor = a.getColor(R.styleable.AToolbar_attrAToolbarCenterColor, context.getColor(R.color.colorAToolbarCenterColor));
        endColor = a.getColor(R.styleable.AToolbar_attrAToolbarEndColor, context.getColor(R.color.colorAToolbarEndColor));
        //float tSize = a.getDimension(R.styleable.CustomView_tSize, 35);
        //p.setColor(tColor);
        //p.setTextSize(tSize);
        //Drawable drawable = context.getDrawable(R.drawable.frame_atoolbar);

        //setBackground(context.getDrawable(R.drawable.atoolbar_frame));

        // 返回一个绑定资源结束的信号给资源
        a.recycle();
        notifyColorChange();*/
        
        setBackground(context.getDrawable(R.drawable.atoolbar_frame));
    }

    public ASupportToolbar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setStartColor(int startColor) {
        this.startColor = startColor;
    }

    /*public int getStartColor() {
        return startColor;
    }

    public void setCenterColor(int centerColor) {
        this.centerColor = centerColor;
    }

    public int getCenterColor() {
        return centerColor;
    }

    public void setEndColor(int endColor) {
        this.endColor = endColor;
    }

    public int getEndColor() {
        return endColor;
    }*/

    /*public void notifyColorChange() {

        //GradientDrawable mGradientDrawableBackground = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP,
        //                                                                  new int[]{mnStartColor, mnCenterColor,mnEndColor});
        //mGradientDrawableBackground.setBounds(                                              
        //GradientDrawable mGradientDrawableBorder = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP,
        //                                                                new int[]{mnCenterColor, mnCenterColor,mnCenterColor});
        AToolbarDrawable mGradientDrawableShape = new AToolbarDrawable(GradientDrawable.Orientation.TOP_BOTTOM,
                                                                       startColor, centerColor, endColor);
        // mGradientDrawableShape.setStroke(20, Color.BLUE);
        // mGradientDrawableShape.setStroke(10, Color.BLACK);
        setBackground(mGradientDrawableShape);

    }*/

}
    
    
    

