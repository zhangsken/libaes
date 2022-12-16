package com.github.zhangsken.aes;

import android.app.Activity;
import android.os.Bundle;
import java.util.ArrayList;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import com.github.zhangsken.libaes.ASupportToolbar;
import android.widget.ListView;
import android.view.View;
import androidx.fragment.app.FragmentTransaction;
import com.github.zhangsken.aes.fragments.LogFragment;
import android.widget.AdapterView;
import android.util.Log;

public class TestActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    public static final String TAG = "TestActivity";

    ArrayList<Fragment> mlistFragment;
    DrawerLayout mDrawerLayout;
    ActionBarDrawerToggle mActionBarDrawerToggle;
    ASupportToolbar mToolbar;
    private ListView mlvDrawerMenuItem;
    private ArrayList<DrawerMenuItem> malDrawerMenuItem;
    DrawerMenuDataAdapter mDrawerMenuDataAdapter;
    boolean mIsDrawerOpened = false;
    boolean mIsDrawerOpening = false;
    boolean mIsDrawerClosing = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        if (mlistFragment == null) {
            mlistFragment = new ArrayList<Fragment>();
        }

        initView();
    }

    void initView() {
        mToolbar = findViewById(R.id.activitytestASupportToolbar1);
        setSupportActionBar(mToolbar);

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setHomeButtonEnabled(true);
        //getSupportActionBar().setDisplayShowHomeEnabled(true);
        //mToolbar.setNavigationIcon(R.mipmap.ic_launcher3);

        //mToolbar.setOnMenuItemClickListener(onMenuItemClickListener);

        mDrawerLayout = findViewById(R.id.activitytestDrawerLayout1);
        mlvDrawerMenuItem = findViewById(R.id.activitytestListView1);

        malDrawerMenuItem = new ArrayList<DrawerMenuItem>();
        malDrawerMenuItem.add(new DrawerMenuItem(R.drawable.ic_launcher, getString(R.string.app_name)));
        malDrawerMenuItem.add(new DrawerMenuItem(R.drawable.ic_launcher, getString(R.string.app_name)));
        malDrawerMenuItem.add(new DrawerMenuItem(R.drawable.ic_launcher, getString(R.string.app_name)));
        malDrawerMenuItem.add(new DrawerMenuItem(R.drawable.ic_launcher, getString(R.string.app_name)));
        mDrawerMenuDataAdapter = new DrawerMenuDataAdapter<DrawerMenuItem>(malDrawerMenuItem, R.layout.listview_drawermenu) {
            @Override
            public void bindView(ViewHolder holder, DrawerMenuItem obj) {
                holder.setImageResource(R.id.listviewdrawermenuImageView1, obj.getIconId());
                holder.setText(R.id.listviewdrawermenuTextView1, obj.getIconName());
            }
        };
        mlvDrawerMenuItem.setAdapter(mDrawerMenuDataAdapter);
        mlvDrawerMenuItem.setOnItemClickListener(this);

        mActionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.app_name, R.string.app_name) {
            @Override
            public void onDrawerOpened(View drawerView) {//完全打开时触发
                super.onDrawerOpened(drawerView);
                mIsDrawerOpened = true;
                mIsDrawerOpening = false;
                //Toast.makeText(MainActivity.this,"onDrawerOpened",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDrawerClosed(View drawerView) {//完全关闭时触发
                super.onDrawerClosed(drawerView);
                mIsDrawerOpened = false;
                mIsDrawerClosing = false;
                //Toast.makeText(MainActivity.this,"onDrawerClosed",Toast.LENGTH_SHORT).show();
            }

            /** 
             * 当抽屉被滑动的时候调用此方法 
             * slideOffset表示 滑动的幅度（0-1） 
             */  
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
            }

            /** 
             * 当抽屉滑动状态改变的时候被调用 
             * 状态值是STATE_IDLE（闲置--0）, STATE_DRAGGING（拖拽的--1）, STATE_SETTLING（固定--2）中之一。 
             *具体状态可以慢慢调试
             */  
            @Override
            public void onDrawerStateChanged(int newState) {
                super.onDrawerStateChanged(newState);
            }
        };

        //设置显示旋转菜单
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //通过下面这句实现toolbar和Drawer的联动：如果没有这行代码，箭头是不会随着侧滑菜单的开关而变换的（或者没有箭头），
        // 可以尝试一下，不影响正常侧滑
        mActionBarDrawerToggle.syncState();

        mDrawerLayout.setDrawerListener(mActionBarDrawerToggle);

        //去掉侧滑的默认图标（动画箭头图标），也可以选择不去，
        //不去的话把这一行注释掉或者改成true，然后把toolbar.setNavigationIcon注释掉就行了
        //mActionBarDrawerToggle.setDrawerIndicatorEnabled(false);

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mIsDrawerOpened || mIsDrawerOpening) {
                        mIsDrawerClosing = true;
                        mIsDrawerOpening = false;
                        mDrawerLayout.closeDrawer(mlvDrawerMenuItem);
                        return;
                    } 
                    if (!mIsDrawerOpened || mIsDrawerClosing) {
                        mIsDrawerOpening = true;
                        mIsDrawerClosing = false;
                        mDrawerLayout.openDrawer(mlvDrawerMenuItem);
                        return;
                    }
                }
            });

        if (mlistFragment.size() == 0) {
            FragmentTransaction tx = getSupportFragmentManager().beginTransaction();


            LogFragment logFragment = new LogFragment();
            tx.add(R.id.activitytestFrameLayout1, logFragment, LogFragment.TAG);

            tx.commit();

            mlistFragment.add(logFragment);
            setSelectFragment(0);
        }
    }

    void setSelectFragment(int nSelect) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        for (int i = 0; i < mlistFragment.size(); i++) {
            if (nSelect == i) {
                transaction.show(mlistFragment.get(i));
            } else {
                transaction.hide(mlistFragment.get(i));
            }
        }

        transaction.commit();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        mDrawerLayout.closeDrawer(mlvDrawerMenuItem);
        switch (position) {
            case 0 :{
                    setSelectFragment(0);
                    Log.d(TAG, "MenuItem 0");
                    break;
                }
            case 1 :{
                    Log.d(TAG, "MenuItem 1");
                    break;
                }
            case 2: {
                    Log.d(TAG, "MenuItem 2");
                    break;
                }
            case 3: {
                    Log.d(TAG, "MenuItem 3");

                    break;
                }
        }
    }

    class DrawerMenuItem {

        private int iconId;
        private String iconName;

        public DrawerMenuItem() {
        }

        public DrawerMenuItem(int iconId, String iconName) {
            this.iconId = iconId;
            this.iconName = iconName;
        }

        public int getIconId() {
            return iconId;
        }

        public String getIconName() {
            return iconName;
        }

        public void setIconId(int iconId) {
            this.iconId = iconId;
        }

        public void setIconName(String iconName) {
            this.iconName = iconName;
        }

    }
}
