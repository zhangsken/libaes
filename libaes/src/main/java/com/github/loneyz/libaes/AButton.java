package com.github.loneyz.libaes;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater.Factory2;

public class AButton extends android.widget.Button {
    
    public AButton(Context context) {
        super(context);
    }

    public AButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        setBackground(context.getDrawable(com.github.loneyz.libaes.R.drawable.btn_style));
        setTextColor(context.getColor(com.github.loneyz.libaes.R.drawable.text_style));
        
    }

    public AButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    
}
