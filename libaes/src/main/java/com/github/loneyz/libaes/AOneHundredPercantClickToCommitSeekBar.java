package com.github.loneyz.libaes;
import android.widget.SeekBar;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.Toast;

public class AOneHundredPercantClickToCommitSeekBar extends SeekBar{
    
    public static final String TAG = "AOneHundredPercantClickToCommitSeekBar";
    
    //Context mContext;
    OnOneHundredPercantCommitListener mOnOneHundredPercantCommitListener;
    
    OnSeekBarChangeListener mOnSeekBarChangeListener = new OnSeekBarChangeListener() {

        @Override
        public void onProgressChanged(SeekBar seekBar, int p2, boolean p3) {
            }

        @Override
        public void onStartTrackingTouch(SeekBar p1) {
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            int nUserSeekProgress = seekBar.getProgress();
            //Toast.makeText(mContext, Integer.toString(nUserSeekProgress), Toast.LENGTH_SHORT).show();
            if(nUserSeekProgress < 100) {
                seekBar.setProgress(0);
            } else {
                mOnOneHundredPercantCommitListener.onOneHundredPercantCommit();
            }
        }
        
        
    };
    
    public void setOnOneHundredPercantCommitListener(OnOneHundredPercantCommitListener listener) {
        mOnOneHundredPercantCommitListener = listener;
    }
    public interface OnOneHundredPercantCommitListener{
        abstract void onOneHundredPercantCommit();
    } 
    
    public AOneHundredPercantClickToCommitSeekBar(Context context) {
        super(context);
        //mContext = context;
    }

    public AOneHundredPercantClickToCommitSeekBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        //mContext = context;
        setOnSeekBarChangeListener(mOnSeekBarChangeListener);

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

    public AOneHundredPercantClickToCommitSeekBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //mContext = context;
    }
    
    
}
