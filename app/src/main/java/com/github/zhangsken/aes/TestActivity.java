package com.github.zhangsken.aes;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.a4455jkjh.colorpicker.ColorPickerDialog;
import com.github.zhangsken.aes.R;
import com.github.zhangsken.aes.fragments.AButtonFragment;
import com.github.zhangsken.aes.fragments.LogFragment;
import com.github.zhangsken.libaes.ASupportToolbar;
import com.github.zhangsken.libaes.storageselecter.LocalFileSelectDialog;
import com.github.zhangsken.libaes.storageselecter.StoragePathDialog;
import java.util.ArrayList;
import android.content.SharedPreferences;

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
        setBaseTheme();
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
        malDrawerMenuItem.add(new DrawerMenuItem(R.drawable.ic_launcher, "GitSource"));
        malDrawerMenuItem.add(new DrawerMenuItem(R.drawable.ic_launcher, LogFragment.TAG));
        malDrawerMenuItem.add(new DrawerMenuItem(R.drawable.ic_launcher, AButtonFragment.TAG));
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
            public void onDrawerOpened(View drawerView) {//?????????????????????
                super.onDrawerOpened(drawerView);
                mIsDrawerOpened = true;
                mIsDrawerOpening = false;
                //Toast.makeText(MainActivity.this,"onDrawerOpened",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDrawerClosed(View drawerView) {//?????????????????????
                super.onDrawerClosed(drawerView);
                mIsDrawerOpened = false;
                mIsDrawerClosing = false;
                //Toast.makeText(MainActivity.this,"onDrawerClosed",Toast.LENGTH_SHORT).show();
            }

            /** 
             * ?????????????????????????????????????????? 
             * slideOffset?????? ??????????????????0-1??? 
             */  
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
            }

            /** 
             * ????????????????????????????????????????????? 
             * ????????????STATE_IDLE?????????--0???, STATE_DRAGGING????????????--1???, STATE_SETTLING?????????--2??????????????? 
             *??????????????????????????????
             */  
            @Override
            public void onDrawerStateChanged(int newState) {
                super.onDrawerStateChanged(newState);
            }
        };

        //????????????????????????
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //????????????????????????toolbar???Drawer????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????
        // ??????????????????????????????????????????
        mActionBarDrawerToggle.syncState();

        mDrawerLayout.setDrawerListener(mActionBarDrawerToggle);

        //??????????????????????????????????????????????????????????????????????????????
        //?????????????????????????????????????????????true????????????toolbar.setNavigationIcon??????????????????
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
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            LogFragment fragment = new LogFragment();
            ft.add(R.id.activitytestFrameLayout1, fragment, fragment.TAG);
            ft.show(fragment);
            ft.commit();
            mlistFragment.add(fragment);
        }
    }

    // ?????? TAG, ?????? Fragment ?????????
    // ?????? Fragment ??????????????????????????????
    //
    void setSelectFragment(String szFragmentTAG) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        boolean isExist = false;
        for (int i = 0; i < mlistFragment.size(); i++) {
            if (mlistFragment.get(i).getTag().equals(szFragmentTAG)) {
                ft.show(mlistFragment.get(i));
                isExist = true;
            } else {
                ft.hide(mlistFragment.get(i));
            }
        }

        if (!isExist) {
            switch (szFragmentTAG) {
                case LogFragment.TAG : {
                        LogFragment fragment = new LogFragment();
                        ft.add(R.id.activitytestFrameLayout1, fragment, fragment.TAG);
                        ft.show(fragment);
                        mlistFragment.add(fragment);
                        break;
                    }
                case AButtonFragment.TAG : {
                        AButtonFragment fragment = new AButtonFragment();
                        ft.add(R.id.activitytestFrameLayout1, fragment, fragment.TAG);
                        ft.show(fragment);
                        mlistFragment.add(fragment);

                        break;
                    }
            }
        }

        ft.commit();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        mDrawerLayout.closeDrawer(mlvDrawerMenuItem);
        switch (position) {
            case 0 :{
                    //Log.d(TAG, "MenuItem 0");
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://8.210.159.116:28369/gitweb/libaes.git"));
                    intent.setClassName("org.mozilla.firefox", "org.mozilla.gecko.LauncherActivity");
                    startActivity(intent);
                    break;
                }
            case 1 :{
                    //Log.d(TAG, "MenuItem 1");
                    setSelectFragment(LogFragment.TAG);
                    break;
                }
            case 2: {
                    //Log.d(TAG, "MenuItem 2");
                    setSelectFragment(AButtonFragment.TAG);
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
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_develop, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_defaulttheme : {
                    SharedPreferences sharedPreferences = getSharedPreferences(
                        "com.github.zhangsken.aes.theme_preferences", MODE_PRIVATE);
                    sharedPreferences.edit().putString("theme_type", "????????????").commit();
                    recreate();
                    break;
                }
            case R.id.item_skytheme : {
                    SharedPreferences sharedPreferences = getSharedPreferences(
                        "com.github.zhangsken.aes.theme_preferences", MODE_PRIVATE);
                    sharedPreferences.edit().putString("theme_type", "????????????").commit();
                    recreate();
                    break;
                }
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
    private  void setBaseTheme() {
        SharedPreferences sharedPreferences = getSharedPreferences(
            "com.github.zhangsken.aes.theme_preferences", MODE_PRIVATE);
        String themeType = sharedPreferences.getString("theme_type", "????????????");
        int themeId;
        switch (themeType) {
            case "????????????":
                themeId = R.style.AppTheme;
                break;
            case "????????????":
                themeId = R.style.SkyAppTheme;
                break;
            default:
                themeId = R.style.AppTheme;
        }
        setTheme(themeId);
    }
}
