package com.github.loneyz.libaes;
import androidx.appcompat.widget.Toolbar;
import android.content.Context;
import android.util.AttributeSet;

public class ASupportToolbar extends Toolbar {

    public ASupportToolbar(Context context) {
        super(context);
    }

    public ASupportToolbar(Context context, AttributeSet attrs) {
        super(context, attrs);

        // 获得TypedArray
        //TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.AToolbar);
        // 获得attrs.xml里面的属性值,格式为:名称_属性名,后面是默认值
        //int startColor = a.getColor(R.styleable.AToolbar_startColor, context.getColor(R.color.colorAToolbarStartColor));
        //int centerColor = a.getColor(R.styleable.AToolbar_centerColor, context.getColor(R.color.colorAToolbarCenterColor));
        //int endColor = a.getColor(R.styleable.AToolbar_endColor, context.getColor(R.color.colorAToolbarEndColor));
        //float tSize = a.getDimension(R.styleable.CustomView_tSize, 35);
        //p.setColor(tColor);
        //p.setTextSize(tSize);
        //Drawable drawable = context.getDrawable(R.drawable.frame_atoolbar);

        setBackground(context.getDrawable(R.drawable.atoolbar_frame));

        // 返回一个绑定资源结束的信号给资源
        //a.recycle();
    }

    public ASupportToolbar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

}
    
    
    

