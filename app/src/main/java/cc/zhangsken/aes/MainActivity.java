package cc.zhangsken.aes;

import android.app.Activity;
import android.os.Bundle;
import cc.zhangsken.libaes.AToolbar;

public class MainActivity extends Activity { 

    AToolbar mAToolbar;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAToolbar = findViewById(R.id.activitymainAToolbar1);
        setActionBar(mAToolbar);
    }

} 
