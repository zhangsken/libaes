package com.github.zhangsken.libaes.storageselecter;

import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.github.zhangsken.libaes.R;
import android.app.AlertDialog;

public class StoragePathDialog extends AlertDialog {

    public static final String TAG = "ColorPickerDialog";
    View.OnClickListener mOnOKClickListener;

    public StoragePathDialog(android.content.Context context) {
        super(context);

    }

    public StoragePathDialog(android.content.Context context, int themeResId) {
        super(context, (themeResId == 0) ? com.github.zhangsken.libaes.R.style.NormalDialogStyle: themeResId);
        // 加载默认布局
        View view = View.inflate(context, R.layout.dialog_storagepath, null);
        setContentView(view);
        // 添加按键点击监听
        view.findViewById(R.id.dialogstoragepathButton1).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mOnOKClickListener != null) {
                        mOnOKClickListener.onClick(view);
                    }
                }
            });
        // 使得点击对话框外部不消失对话框
        setCanceledOnTouchOutside(false);
        // 设置对话框大小
        view.setMinimumHeight((int) (ScreenSizeUtils.getInstance(context).getScreenHeight() * 0.23f));
        Window dialogWindow = getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.width = (int) (ScreenSizeUtils.getInstance(context).getScreenWidth() * 0.75f);
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.gravity = Gravity.CENTER;
        dialogWindow.setAttributes(lp);

    }

    protected StoragePathDialog(android.content.Context context, boolean cancelable, android.content.DialogInterface.OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }
    
    public void setOnOKClickListener(View.OnClickListener listener) {
        mOnOKClickListener = listener;
    }

}
