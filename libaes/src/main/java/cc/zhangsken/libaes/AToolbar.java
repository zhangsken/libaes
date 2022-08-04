package cc.zhangsken.libaes;
import android.widget.Toolbar;
import android.content.Context;
import android.util.AttributeSet;

public class AToolbar extends Toolbar {
    
    public AToolbar(Context context) {
        super(context);
    }

    public AToolbar(Context context, AttributeSet attrs) {
        super(context, attrs);
        setBackground(context.getDrawable(cc.zhangsken.libaes.R.drawable.frame_toolbar));
    }

    public AToolbar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    
}
