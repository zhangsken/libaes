package com.github.zhangsken.libaes;

import android.widget.ProgressBar;
import android.content.Context;
import android.util.AttributeSet;
import android.graphics.drawable.Drawable;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.content.res.ColorStateList;

public class OneHundredPercantClickToSendProgressBar extends ProgressBar {
    
    public static final String TAG = "OneHundredPercantClickToSendProgressBar";
    
    public OneHundredPercantClickToSendProgressBar(Context context) {
        super(context);
    }

    public OneHundredPercantClickToSendProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        Drawable drawable = context.getDrawable(R.drawable.ohpcts_frame);
        setProgressDrawable(drawable);
        //setProgress(49);
        //setSecondaryProgress(87);
        
        // 获得TypedArray
        //TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.AToolbar);
        // 获得attrs.xml里面的属性值,格式为:名称_属性名,后面是默认值
        //int colorBackgroud = a.getColor(R.styleable.ACard_backgroudColor, context.getColor(R.color.colorACardBackgroung));
        //int centerColor = a.getColor(R.styleable.AToolbar_centerColor, context.getColor(R.color.colorAToolbarCenterColor));
        //int endColor = a.getColor(R.styleable.AToolbar_endColor, context.getColor(R.color.colorAToolbarEndColor));
        //float tSize = a.getDimension(R.styleable.CustomView_tSize, 35);
        //p.setColor(tColor);
        //p.setTextSize(tSize);
        //Drawable drawable = context.getDrawable(R.drawable.frame_atoolbar);

        //setBackground(context.getDrawable(R.drawable.acard_frame_main));

        // 返回一个绑定资源结束的信号给资源
        //a.recycle();

    }

    public OneHundredPercantClickToSendProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    
}