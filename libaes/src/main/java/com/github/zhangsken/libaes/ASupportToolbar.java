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

    int startColor;
    int centerColor;
    int endColor;
	LayerDrawable ld;
	GradientDrawable[] array = new GradientDrawable[3];
	
	
	//private GradientDrawable gradientDrawable;

    public ASupportToolbar(Context context) {
        super(context, null);
    }

    public ASupportToolbar(Context context, AttributeSet attrs) {
        super(context, attrs);
		// 获得TypedArray
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.AToolbarStyle);
		// 获得attrs.xml里面的属性值,格式为:名称_属性名,后面是默认值
		startColor = a.getColor(R.styleable.AToolbarStyle_attrAToolbarStartColor, context.getColor(R.color.colorAToolbarStartColor));
		centerColor = a.getColor(R.styleable.AToolbarStyle_attrAToolbarCenterColor, context.getColor(R.color.colorAToolbarCenterColor));
		endColor = a.getColor(R.styleable.AToolbarStyle_attrAToolbarEndColor, context.getColor(R.color.colorAToolbarEndColor));
		// 返回一个绑定资源结束的信号给资源
		a.recycle();
		
		// 工具栏描边
		int nStroke = 5;
		
		//分别为开始颜色，中间夜色，结束颜色
		int colors0[] = { endColor , centerColor,  startColor};
		GradientDrawable gradientDrawable0;
	    array[2] = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, colors0);
	    gradientDrawable0 = array[2];
		gradientDrawable0.setShape(GradientDrawable.RECTANGLE);
        gradientDrawable0.setColors(colors0); //添加颜色组
		gradientDrawable0.setGradientType(GradientDrawable.LINEAR_GRADIENT);//设置线性渐变
        gradientDrawable0.setCornerRadius(20);
		
        int colors1[] = { centerColor , centerColor, centerColor };
		GradientDrawable gradientDrawable1;
		array[1] = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, colors1);
	    gradientDrawable1 = array[1];
		gradientDrawable1.setShape(GradientDrawable.RECTANGLE);
        gradientDrawable1.setColors(colors1); //添加颜色组
		gradientDrawable1.setGradientType(GradientDrawable.LINEAR_GRADIENT);//设置线性渐变
        gradientDrawable1.setCornerRadius(20);
        
		int colors2[] = {  endColor, centerColor, startColor };
		GradientDrawable gradientDrawable2;
		array[0] = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, colors2);
	    gradientDrawable2 = array[0];
		gradientDrawable2.setShape(GradientDrawable.RECTANGLE);
        gradientDrawable2.setColors(colors2); //添加颜色组
		gradientDrawable2.setGradientType(GradientDrawable.LINEAR_GRADIENT);//设置线性渐变
        gradientDrawable2.setCornerRadius(20);
        
		
		ld = new LayerDrawable(array); //参数为上面的Drawable数组
		ld.setLayerInset(2, nStroke*2, nStroke*2, getWidth()+nStroke*2, getHeight()+nStroke*2); 
		ld.setLayerInset(1, nStroke, nStroke, getWidth()+nStroke, getHeight()+nStroke); 
		ld.setLayerInset(0, 0, 0, getWidth(), getHeight()); 
		
		setBackgroundDrawable(ld);
		
		//setContentDescription(context.getResources().getString(
			//					  R.string.app_name));
      // drawable = new ShapeDrawable(new RectShape());
        
        //drawable.setShape(GradientDrawable.RECTANGLE);
//        drawable.setColor(0xff74AC23);
        // If the color isn't set, the shape uses black as the default.
       // drawable.getPaint().setColor(Color.parseColor("#c8db8c"));
        // If the bounds aren't set, the shape can't be drawn.
       // drawable.setBounds(x, y, x + width, y + height);

        
		 //float tSize = a.getDimension(R.styleable.CustomView_tSize, 35);
		 //p.setColor(tColor);
		 //p.setTextSize(tSize);
		 //Drawable drawable = context.getDrawable(R.drawable.frame_atoolbar);

		 //setBackground(context.getDrawable(R.drawable.atoolbar_frame));


		// notifyColorChange();
		
		
		/*drawable = new GradientDrawable();
		drawable.setShape(GradientDrawable.RECTANGLE);
		drawable.setCornerRadius(8);
		drawable.setStroke(width,Color.YELLOW);

		动态修改可实现同一背景资源，各个组件自定义差异使用
		*/
        //setBackground(context.getDrawable(R.drawable.atoolbar_frame));

//组件在xml已配置，代码中动态修改
			 //drawable = (GradientDrawable)getBackground();
		//drawable.getco color)//填充颜色
		
    }
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}

    public void setStartColor(int startColor) {
        this.startColor = startColor;
    }

    public int getStartColor() {
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
    }

    public void notifyColorChange() {

        //GradientDrawable mGradientDrawableBackground = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP,
        //                                                                  new int[]{mnStartColor, mnCenterColor,mnEndColor});
        //mGradientDrawableBackground.setBounds(                                              
        //GradientDrawable mGradientDrawableBorder = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP,
        //                                                                new int[]{mnCenterColor, mnCenterColor,mnCenterColor});
        //AToolbarDrawable mGradientDrawableShape = new AToolbarDrawable(GradientDrawable.Orientation.TOP_BOTTOM,
          //                                                             startColor, centerColor, endColor);
        //mGradientDrawableShape.setStroke(20, Color.BLUE);
        //mGradientDrawableShape.setStroke(10, Color.BLACK);
        //setBackground(mGradientDrawableShape);

    }

	@Override
	public void draw(Canvas canvas) {
		super.draw(canvas);
		/*Paint mPaint = drawable.();
        mPaint.setColor(Color.RED);
		canvas.drawRect(0,0,getWidth(),getHeight(),mPaint);*/
	}
}
    
    
    

