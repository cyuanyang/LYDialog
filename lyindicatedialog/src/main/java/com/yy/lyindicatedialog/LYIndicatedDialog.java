package com.yy.lyindicatedialog;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by cyy on 2016/6/29.
 * <p/>
 * 透明指示的dialog
 */
public class LYIndicatedDialog extends LYDialog {

    protected RelativeLayout mainLayout;
    protected ProgressBar progressBar;
    protected ImageView indicateImageView;
    protected TextView loadView;

    //工厂模式创建
    public static LYIndicatedDialog newIndicatedDialog(Context context) {
        return new LYIndicatedDialog(context);
    }

    private LYIndicatedDialog(Context context) {
        this(context, R.style.LYDialog_IndicatedDialog);
    }

    private LYIndicatedDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        setDialogWidthRatio(LYAttach.widthRatio);
        setHeightquipWidth();
        setCanceledOnTouchOutside(LYAttach.touchInsideHide);
    }

    @Override
    public int getLayoutId() {
        return R.layout.indicated_dialog_layout;
    }

    private void initView() {
        mainLayout = (RelativeLayout) findViewById(R.id.main_layout);
        GradientDrawable gd = new GradientDrawable();
        gd.setColor(LYAttach.IndicatedDialogBackground);
        gd.setCornerRadius(LYAttach.Radius);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            mainLayout.setBackground(gd);
        } else {
            mainLayout.setBackgroundDrawable(gd);
        }
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        indicateImageView = (ImageView) findViewById(R.id.indicate_imageView);
        loadView = (TextView) findViewById(R.id.load_view);
    }


    public void success() {
        indicateImageView.setVisibility(View.VISIBLE);
        indicateImageView.setImageResource(R.mipmap.ic_correct);
        progressBar.setVisibility(View.GONE);
        loadView.setText("完成");

        mDismiss();
    }

    public void error(){
        indicateImageView.setVisibility(View.VISIBLE);
        indicateImageView.setImageResource(R.mipmap.ic_error);
        progressBar.setVisibility(View.GONE);
        loadView.setText("失败");
        mDismiss();
    }


    private void mDismiss() {
        mainLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                dismiss();
            }
        } , 1000);
    }
}
