package com.github.zhangsken.aes;

import android.os.Bundle;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.view.View;
import com.github.zhangsken.liblogutils.LogView;
import com.github.zhangsken.liblogutils.LogFilterSpec;
import android.app.Activity;
import com.github.zhangsken.libaes.AOHPCTCSeekBar;

public class LogViewActivity extends Activity {

    public static final String TAG = "LogViewFragment";
    LogView mLogView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logview);
        initView();
        
    }

    public void initView() {
        mLogView = findViewById(R.id.fragmentlogviewLogView1);
        // 开始显示Log.
        mLogView.addLogFilterSpec(new LogFilterSpec(LogFilterSpec.LogLevel.D, MainActivity.TAG));
        mLogView.addLogFilterSpec(new LogFilterSpec(LogFilterSpec.LogLevel.D, LogView.TAG));
        mLogView.addLogFilterSpec(new LogFilterSpec(LogFilterSpec.LogLevel.D, AOHPCTCSeekBar.TAG));
        
        mLogView.startLog();

    }
    
}
