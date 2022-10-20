package cc.zhangsken.aes;

import android.app.Activity;
import android.os.Bundle;
import cc.zhangsken.libaes.AToolbar;
import cc.zhangsken.libaes.AOneHundredPercantClickToSendSeekBar;
import android.widget.Toast;

public class MainActivity extends Activity { 

    AToolbar mAToolbar;
    AOneHundredPercantClickToSendSeekBar mAOneHundredPercantClickToSendSeekBar;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAToolbar = findViewById(R.id.activitymainAToolbar1);
        setActionBar(mAToolbar);
        
        mAOneHundredPercantClickToSendSeekBar = findViewById(R.id.activitymainAOneHundredPercantClickToSendSeekBar1);
        mAOneHundredPercantClickToSendSeekBar.setOnOneHundredPercantCommitListener(
            new AOneHundredPercantClickToSendSeekBar.OnOneHundredPercantCommitListener(){

                @Override
                public void onOneHundredPercantCommit() {
                    Toast.makeText(getApplication(), "Commit", Toast.LENGTH_SHORT).show();
                }
                
                
            });
    }

} 
