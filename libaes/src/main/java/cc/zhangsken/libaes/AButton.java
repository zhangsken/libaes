package cc.zhangsken.libaes;

import android.content.Context;
import android.util.AttributeSet;

public class AButton extends android.widget.Button {
    
    public AButton(Context context) {
        super(context);
    }

    public AButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        setBackground(context.getDrawable(cc.zhangsken.libaes.R.drawable.btn_style));
        setTextColor(context.getColor(cc.zhangsken.libaes.R.drawable.text_style));
        
    }

    public AButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    
}
