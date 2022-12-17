package com.github.zhangsken.aes.fragments;

import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.view.View;
import com.github.zhangsken.liblogutils.LogView;
import com.github.zhangsken.aes.R;
import com.github.zhangsken.aes.TestActivity;
import com.github.zhangsken.liblogutils.LogFilterSpec;

public class LogFragment extends Fragment {
    public static final String TAG = "LogFragment";
    
    LogView mLogView;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_log, container, false);
        mLogView = view.findViewById(R.id.fragmentlogLogView1);
        // 开始显示Log.
        mLogView.addLogFilterSpec(new LogFilterSpec(LogFilterSpec.LogLevel.D, TestActivity.TAG));
        mLogView.addLogFilterSpec(new LogFilterSpec(LogFilterSpec.LogLevel.D, LogView.TAG));
        
        mLogView.startLog();
        
        return view;
    }
    
    
    
}
