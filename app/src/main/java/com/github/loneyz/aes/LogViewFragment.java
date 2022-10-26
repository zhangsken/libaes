package com.github.loneyz.aes;
import android.app.Fragment;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.view.View;
import com.github.loneyz.libapplogutils.LogView;
import com.github.loneyz.libapplogutils.LogFilterSpec;

public class LogViewFragment extends Fragment {
    
    public static final String TAG = "LogViewFragment";
    LogView mLogView;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_logview, container,false);
        
        mLogView = view.findViewById(R.id.fragmentlogviewLogView1);
        // 开始显示Log.
        mLogView.addLogFilterSpec(new LogFilterSpec(LogFilterSpec.LogLevel.D, MainActivity.TAG));
        mLogView.addLogFilterSpec(new LogFilterSpec(LogFilterSpec.LogLevel.D, LogView.TAG));

        
        
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mLogView.startLog();
    }

    
    
    
}
