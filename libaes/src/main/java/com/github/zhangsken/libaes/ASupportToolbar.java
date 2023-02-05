package com.github.zhangsken.libaes;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.Toolbar;
import com.github.zhangsken.libaes.R;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;

public class ASupportToolbar extends Toolbar {

    int mStartColor;
    int mCenterColor;
    int mEndColor;
	LayerDrawable ld;
	GradientDrawable[] array = new GradientDrawable[3];


	//private GradientDrawable gradientDrawable;

    public ASupportToolbar(Context context) {
        super(context);
    }

    public ASupportToolbar(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.AToolbar, R.attr.aToolbar, 0);
        mStartColor = a.getColor(R.styleable.AToolbar_attrAToolbarStartColor, Color.BLUE);
        mCenterColor = a.getColor(R.styleable.AToolbar_attrAToolbarCenterColor, Color.RED);
        mEndColor = a.getColor(R.styleable.AToolbar_attrAToolbarEndColor, Color.YELLOW);
        // 返回一个绑定资源结束的信号给资源
        a.recycle();
        notifyColorChange();
    }


    void notifyColorChange() {
        // 工具栏描边
        int nStroke = 5;

        //分别为开始颜色，中间夜色，结束颜色
        int colors0[] = { mEndColor , mCenterColor,  mStartColor};
        GradientDrawable gradientDrawable0;
        array[2] = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, colors0);
        gradientDrawable0 = array[2];
        gradientDrawable0.setShape(GradientDrawable.RECTANGLE);
        gradientDrawable0.setColors(colors0); //添加颜色组
        gradientDrawable0.setGradientType(GradientDrawable.LINEAR_GRADIENT);//设置线性渐变
        gradientDrawable0.setCornerRadius(20);

        int colors1[] = { mCenterColor , mCenterColor, mCenterColor };
        GradientDrawable gradientDrawable1;
        array[1] = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, colors1);
        gradientDrawable1 = array[1];
        gradientDrawable1.setShape(GradientDrawable.RECTANGLE);
        gradientDrawable1.setColors(colors1); //添加颜色组
        gradientDrawable1.setGradientType(GradientDrawable.LINEAR_GRADIENT);//设置线性渐变
        gradientDrawable1.setCornerRadius(20);

        int colors2[] = {  mEndColor, mCenterColor, mStartColor };
        GradientDrawable gradientDrawable2;
        array[0] = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, colors2);
        gradientDrawable2 = array[0];
        gradientDrawable2.setShape(GradientDrawable.RECTANGLE);
        gradientDrawable2.setColors(colors2); //添加颜色组
        gradientDrawable2.setGradientType(GradientDrawable.LINEAR_GRADIENT);//设置线性渐变
        gradientDrawable2.setCornerRadius(20);


        ld = new LayerDrawable(array); //参数为上面的Drawable数组
        ld.setLayerInset(2, nStroke * 2, nStroke * 2, getWidth() + nStroke * 2, getHeight() + nStroke * 2); 
        ld.setLayerInset(1, nStroke, nStroke, getWidth() + nStroke, getHeight() + nStroke); 
        ld.setLayerInset(0, 0, 0, getWidth(), getHeight()); 

		setBackgroundDrawable(ld);
    }

}
    
    
    

