package cc.zhangsken.aes;

import android.os.Bundle;
import cc.zhangsken.libaes.AToolbar;
import cc.zhangsken.libaes.AOneHundredPercantClickToCommitSeekBar;
import android.widget.Toast;
import com.github.zhangsken.liblogutils.LogView;
import android.util.Log;
import java.util.logging.Level;
import com.github.zhangsken.liblogutils.LogFilterSpec;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import java.util.List;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.PagerAdapter;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public static String TAG = "MainActivity";
    
    private ViewPager mViewPager;
    private List<View> mViews;  //存放视图的数组
    private View view1,view2,view3;
    private PagerAdapter mPagerAdapter;//适配器
    AToolbar mAToolbar;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mAToolbar = findViewById(R.id.activitymainAToolbar1);
        setActionBar(mAToolbar);
        
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.activitymainFrameLayout1, new LogViewFragment(), LogViewFragment.TAG);
        ft.commit();
        
       
        //testAOneHundredPercantClickToCommitSeekBar();
    }
    
    
    
    /*AOneHundredPercantClickToCommitSeekBar mAOneHundredPercantClickToCommitSeekBar;
    void testAOneHundredPercantClickToCommitSeekBar() {
        mAOneHundredPercantClickToCommitSeekBar = findViewById(R.id.activitymainAOneHundredPercantClickToSendSeekBar1);
        mAOneHundredPercantClickToCommitSeekBar.setOnOneHundredPercantCommitListener(
            new AOneHundredPercantClickToCommitSeekBar.OnOneHundredPercantCommitListener(){

                @Override
                public void onOneHundredPercantCommit() {
                    Log.d(TAG, "CommitA");
                    Toast.makeText(getApplication(), "", Toast.LENGTH_SHORT).show();
                }


            });
    }*/

} 
