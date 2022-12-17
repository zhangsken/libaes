package com.github.zhangsken.aes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import com.github.zhangsken.aes.R;
import java.util.ArrayList;
import java.util.List;
import com.github.zhangsken.libaes.AToolbar;
import android.view.Menu;
import com.github.zhangsken.libaes.ASupportToolbar;
import android.view.MenuItem;
import android.content.Intent;
import com.github.zhangsken.libaes.AOHPCTCSeekBar;
import android.widget.Toast;
import com.a4455jkjh.colorpicker.ColorPickerDialog;
import android.graphics.Color;
import android.graphics.ColorSpace;
import com.a4455jkjh.colorpicker.view.ColorUtils;
import com.github.zhangsken.libaes.storageselecter.StoragePathDialog;
import com.github.zhangsken.libaes.storageselecter.LocalFileSelectDialog;
import com.github.zhangsken.libaes.utils.ScreenUtil;


public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener
, View.OnClickListener {
    public static String TAG = "MainActivity";

    private ViewPager viewPager;
    private List<View> views; //用来存放放进ViewPager里面的布局
    //实例化存储imageView（导航原点）的集合
    ImageView[] imageViews;
    private ImagePagerAdapter adapter;//适配器
    private LinearLayout linearLayout;//下标所在在LinearLayout布局里
    private int currentPoint = 0;//当前被选中中页面的下标

    ASupportToolbar mASupportToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //viewPager = findViewById(R.id.activitymainViewPager1);
        initData();
        initView();//调用初始化视图方法
        initPoint();//调用初始化导航原点的方法
        viewPager.addOnPageChangeListener(this);//滑动事件
        //viewPager.setAdapter(new MyAdapter());

        // 获取屏幕参数
        //ScreenUtil.ScreenSize ss = ScreenUtil.getScreenSize(MainActivity.this);
        //Toast.makeText(getApplication(), Integer.toString(ss.getHeightPixels())+" "+Integer.toString(ss.getWidthPixels()), Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_develop, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_log : {
                    Intent intent = new Intent(this, LogViewActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_LAUNCH_ADJACENT | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    break;
                }

            case R.id.item_colordialog : {
                    ColorPickerDialog dlg = new ColorPickerDialog(this, getColor(R.color.colorPrimary));
                    dlg.setOnColorChangedListener(new com.a4455jkjh.colorpicker.view.OnColorChangedListener() {

                            @Override
                            public void beforeColorChanged() {
                            }

                            @Override
                            public void onColorChanged(int color) {

                            }

                            @Override
                            public void afterColorChanged() {
                            }


                        });
                    dlg.show();
                    break;
                }
            case R.id.item_dialogstoragepath : {
                    final StoragePathDialog dialog = new StoragePathDialog(this, 0);
                    dialog.setOnOKClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog.dismiss();
                            }
                        });
                    dialog.show();
                    break;
                }
            case R.id.item_localfileselectdialog : {
                    final LocalFileSelectDialog dialog = new LocalFileSelectDialog(this);
                    dialog.setOnOKClickListener(new LocalFileSelectDialog.OKClickListener() {
                            @Override
                            public void onOKClick(String sz) {
                                Toast.makeText(getApplication(), sz, Toast.LENGTH_SHORT).show();
                                //dialog.dismiss();
                            }
                        });
                    dialog.open();
                    break;
                }
        }
        return false;
        //return super.onOptionsItemSelected(item);
    }

    //初始化view，即显示的图片
    void initView() {
        mASupportToolbar = findViewById(R.id.activitymainAToolbar1);
        setSupportActionBar(mASupportToolbar);

        adapter = new ImagePagerAdapter(views);
        viewPager = findViewById(R.id.activitymainViewPager1);
        viewPager.setAdapter(adapter);
        linearLayout = findViewById(R.id.linearLayout);
        initPoint();//初始化页面下方的点
        viewPager.setOnPageChangeListener(this);
        initAOHPCTCSeekBar();


    }



    //初始化所要显示的布局
    void initData() {

        LayoutInflater inflater = LayoutInflater.from(this);
        View view2 = inflater.inflate(R.layout.viewpage_acard, null);
        View view3 = inflater.inflate(R.layout.viewpage_aohpctccard, null);
        View view4 = inflater.inflate(R.layout.viewpage_aohpctcsb, null);

        View view5 = inflater.inflate(R.layout.viewpage_atickprogressbar, null);
        views = new ArrayList<>();
        views.add(view2);
        views.add(view3);
        views.add(view4);
        views.add(view5);

    }

    //setTag注释
    /*
     //View中的setTag（Onbect）表示给View添加一个格外的数据，以后可以用getTag()将这个数据取出来。来
     代表这个数据，即实例化
     Tag是标签的bai意识，这里的tag是object类型。所以通常会使用setTag()设置不同的Object子类对象，
     然后使用强制转换getTag()获得对象。
     //可以用在多个Button添加一个监听器，每个Button都设置不同的setTag。
     这个监听器就通过getTag来分辨是哪个Button 被按下。
     public class Main extends Activity {

     @Override
     public void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);
     setContentView(R.layout.main);
     Button button1 = (Button) findViewById(R.id.Button01);
     Button button2 = (Button) findViewById(R.id.Button02);
     Button button3 = (Button) findViewById(R.id.Button03);
     Button button4 = (Button) findViewById(R.id.Button04);
     MyListener listener = new MyListener();
     button1.setTag(1);
     button1.setOnClickListener(listener);
     button2.setTag(2);
     button2.setOnClickListener(listener);
     button3.setTag(3);
     button3.setOnClickListener(listener);
     button4.setTag(4);
     button4.setOnClickListener(listener);
     }

     public class MyListener implements View.OnClickListener {

     @Override
     public void onClick(View v) {
     int tag = (Integer) v.getTag();
     switch (tag) {
     case 1:
     System.out.println(“button1 click”);
     break;
     case 2:
     System.out.println(“button2 click”);
     break;
     case 3:
     System.out.println(“button3 click”);
     break;
     case 4:
     System.out.println(“button4 click”);
     break;
     }

     */

    private void initPoint() {

        imageViews = new ImageView[5];//实例化5个图片
        for (int i = 0; i < linearLayout.getChildCount(); i++) {
            imageViews[i] = (ImageView) linearLayout.getChildAt(i);
            imageViews[i].setImageResource(R.drawable.ic_arrow_expand_horizontal);
            imageViews[i].setOnClickListener(this);//点击导航点，即可跳转
            imageViews[i].setTag(i);//重复利用实例化的对象
        }
        currentPoint = 0;//默认第一个坐标
        imageViews[currentPoint].setImageResource(R.drawable.ic_arrow_expand_vertical);
    }

    //OnPageChangeListener接口要实现的三个方法
    /*    onPageScrollStateChanged(int state)
     此方法是在状态改变的时候调用，其中state这个参数有三种状态：
     SCROLL_STATE_DRAGGING（1）表示用户手指“按在屏幕上并且开始拖动”的状态
     （手指按下但是还没有拖动的时候还不是这个状态，只有按下并且手指开始拖动后log才打出。）
     SCROLL_STATE_IDLE（0）滑动动画做完的状态。
     SCROLL_STATE_SETTLING（2）在“手指离开屏幕”的状态。*/
    @Override
    public void onPageScrollStateChanged(int state) {

    }
    /*    onPageScrolled(int position, float positionOffset, int positionOffsetPixels)
     当页面在滑动的时候会调用此方法，在滑动被停止之前，此方法回一直得到调用。其中三个参数的含义分别为：

     position :当前页面，即你点击滑动的页面（从A滑B，则是A页面的position。
     positionOffset:当前页面偏移的百分比
     positionOffsetPixels:当前页面偏移的像素位置*/
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }
    /*    onPageSelected(int position)
     此方法是页面滑动完后得到调用，position是你当前选中的页面的Position（位置编号）
     (从A滑动到B，就是B的position)*/
    public void onPageSelected(int position) {

        ImageView preView = imageViews[currentPoint];
        preView.setImageResource(R.drawable.ic_arrow_expand_horizontal);
        ImageView currView = imageViews[position];
        currView.setImageResource(R.drawable.ic_arrow_expand_vertical);
        currentPoint = position;
    }

    //小圆点点击事件
    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        //通过getTag(),可以判断是哪个控件
        int i = (Integer) v.getTag();
        viewPager.setCurrentItem(i);//直接跳转到某一个页面的情况
    }

    void initAOHPCTCSeekBar() {
        AOHPCTCSeekBar seekbar = findViewById(R.id.activitymainAOHPCTCSeekBar1);
        seekbar.setThumb(getDrawable(R.drawable.ic_launcher));
        seekbar.setThumbOffset(10);
        seekbar.setOnOHPCListener(new AOHPCTCSeekBar.OnOHPCListener() {

                @Override
                public void onOHPCommit() {
                    Toast.makeText(getApplication(), "onOHPCommit ", Toast.LENGTH_SHORT).show();
                }


            });
    }
}
