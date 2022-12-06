package com.github.zhangsken.libaes.storageselecter;

import android.content.DialogInterface;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import java.io.File;
import java.lang.reflect.Field;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import android.content.Context;
import android.view.View;

public class LocalFileSelectDialog {
    
    public static final String TAG = LocalFileSelectDialog.class.getSimpleName();
    
    File mfCurrentPath = new File("/storage/emulated/0");
    String mszResultPath = "/storage/emulated/0";
    OKClickListener mOKClickListener;
    
    Context mContext;
    
    public LocalFileSelectDialog(Context context) {
        mContext = context;
    }
    
    public void open() {
        Log.d(TAG, "call open()");
        String[] szlist = getChildFileList(mfCurrentPath);
        if (szlist != null) {
            showSingleChoiceDialog(szlist, 0);
        }
    }

    int yourChoice;
    private void showSingleChoiceDialog(final String[] szItems, final int nChoice) {
        Log.d(TAG, "call showSingleChoiceDialog(...)");
        yourChoice = nChoice;
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);   
        String sz = mfCurrentPath.getPath();

        builder.setTitle(sz);
        //builder.setCancelable(false);
        builder.setSingleChoiceItems(szItems, nChoice, 
            new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    yourChoice = which;
                }
            });
        // 确定按钮
        builder.setPositiveButton("确定",
            new DialogInterface.OnClickListener() {

                @Override
                public void onClick(
                    DialogInterface dialog,
                    int which) {
                    mszResultPath = mfCurrentPath.getPath() + File.separator + szItems[yourChoice];
                    //Toast.makeText(mContext, mszResultPath, Toast.LENGTH_SHORT).show();
                    mOKClickListener.onOKClick(mszResultPath);
                }
            });
        // 下一层文件按钮
        builder.setNegativeButton(">>>", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    String[] szlist = getChildFileList(new File(mfCurrentPath.getPath() + File.separator + szItems[yourChoice]));
                    if (szlist != null) {
                        mfCurrentPath = new File(mfCurrentPath.getPath() + File.separator + szItems[yourChoice]);

                        showSingleChoiceDialog(szlist, 0);

                    } else {
                        Toast.makeText(mContext, "这是一个最低的目录", Toast.LENGTH_SHORT).show();
                        String[] szlistOld = getChildFileList(mfCurrentPath);
                        showSingleChoiceDialog(szlistOld, yourChoice);
                    }

                }
            });
        // 上一层文件按钮
        builder.setNeutralButton("<<<",
            new DialogInterface.OnClickListener() {// 添加返回按钮

                @Override
                public void onClick(
                    DialogInterface dialog,
                    int which) {// 响应事件

                    String[] szlist = getChildFileList(mfCurrentPath.getParentFile());
                    if (szlist != null) {
                        mfCurrentPath = mfCurrentPath.getParentFile();

                        showSingleChoiceDialog(szlist, 0);

                    } else {
                        Toast.makeText(mContext, "这是一个最高的目录", Toast.LENGTH_SHORT).show();
                        String[] szlistOld = getChildFileList(mfCurrentPath);
                        showSingleChoiceDialog(szlistOld, yourChoice);
                    }

                }
            });
        AlertDialog dialog = builder.create();
        dialog.show();

        // 反射原理修改对话框元素
        //
        //需要在show()方法之后才能修改
        //修改“确认”、“取消”按钮的字体大小
        //dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextSize(16);
        //dialog.getButton(DialogInterface.BUTTON_NEGATIVE).setTextSize(16);
        //dialog.getButton(DialogInterface.BUTTON_NEUTRAL).setTextSize(16);
        try {
            Field mAlert = AlertDialog.class.getDeclaredField("mAlert");
            mAlert.setAccessible(true);
            Object mAlertController = mAlert.get(dialog);

            //通过反射修改title字体大小和颜色
            Field mTitle = mAlertController.getClass().getDeclaredField("mTitleView");
            mTitle.setAccessible(true);
            TextView mTitleView = (TextView) mTitle.get(mAlertController);
            //mTitleView.setTextSize(16);
            //mTitleView.setTextColor(Color.RED);
            mTitleView.setSingleLine(false);

            //通过反射修改message字体大小和颜色
            //Field mMessage = mAlertController.getClass().getDeclaredField("mMessageView");
            //mMessage.setAccessible(true);
            //TextView mMessageView = (TextView) mMessage.get(mAlertController);
            //mMessageView.setTextSize(16);
            //mMessageView.setTextColor(Color.GREEN);
        } catch (IllegalAccessException e) {
            Log.d(TAG, "IllegalAccessException : " + e.getMessage());
        } catch (NoSuchFieldException e) {
            Log.d(TAG, "NoSuchFieldException : " + e.getMessage());
        }
    }
    
    public void setOnOKClickListener(OKClickListener listener) {
        mOKClickListener = listener;
    }
    
    public interface OKClickListener {
        void onOKClick(String szResultPath);
    }

    // 读取文件夹子目录
    //
    // "/storage/emulated/0"以上
    // 和没有子目录的f参数返回空列表
    private String[] getChildFileList(File file) {
        ArrayList<String> szlistFiles = new ArrayList<String>();
        if (!file.getPath().equals("/storage/emulated")) {
            File[] fileList = file.listFiles();
            if (fileList != null) {
                for (File fileItem : fileList) {
                    if (fileItem.getName().charAt(0) != '.') {
                        if (fileItem.isDirectory()) {
                            szlistFiles.add(fileItem.getName());
                        }
                    }
                }
            }
        }
        Collections.sort(szlistFiles, new SortChineseName(true)); 

        if (szlistFiles.size() > 0) {
            return szlistFiles.toArray(new String[szlistFiles.size()]);
        } else {
            return null;
        }
    }

    private class SortChineseName implements Comparator<String> {
        private boolean mIsA2Z = true;
        public SortChineseName(boolean isA2Z) {
            mIsA2Z = isA2Z;
        }
        Collator cmp = Collator.getInstance(java.util.Locale.CHINA);
        @Override
        public int compare(String o1, String o2) {
            if (mIsA2Z) {
                if (cmp.compare(o1, o2) > 0) {
                    return 1;
                } else if (cmp.compare(o1, o2) < 0) {
                    return -1;
                }
            } else {
                if (cmp.compare(o1, o2) > 0) {
                    return -1;
                } else if (cmp.compare(o1, o2) < 0) {
                    return 1;
                }
            }
            return 0;
        }
    }
    
}
