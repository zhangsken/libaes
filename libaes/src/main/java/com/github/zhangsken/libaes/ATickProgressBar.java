package com.github.zhangsken.libaes;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ProgressBar;

public class ATickProgressBar extends ProgressBar {
        int mnStepDistantce = 100 / 10;
        int mnProgress = 0;

    public ATickProgressBar(Context context) {
        super(context);

    }

    public ATickProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        setProgress(50);
    }

    public int stepOnTick(int nStepDistantce) {
        if (mnProgress < 100) {
            int nProgressOld = mnProgress;
            mnProgress += nStepDistantce;
            new Handler().postDelayed(new Runnable(){

                    @Override
                    public void run() {
                        ;
                    }
                }, 1000);
            return nProgressOld;
        } else {
            return mnProgress;
        }
    }
    /*@Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int nWidthSize = MeasureSpec.getSize(widthMeasureSpec);
        int nHeightSize = MeasureSpec.getSize(heightMeasureSpec);
        
        setMeasuredDimension(nWidthSize, nHeightSize);
    }*/

}
