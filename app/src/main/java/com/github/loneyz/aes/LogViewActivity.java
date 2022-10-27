package com.github.loneyz.aes;

import android.os.Bundle;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.view.View;
import com.github.loneyz.libapplogutils.LogView;
import com.github.loneyz.libapplogutils.LogFilterSpec;
import android.app.Activity;

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
        mLogView.startLog();

    }
    
}
