package com.yy.lyindicatedialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

import com.yy.lyindicatedialog.LYTools.ScreenTools;


/**
 * Created by cyy on 2016/6/27.
 *
 */
public abstract class LYDialog extends Dialog {

    /***能拿到的rootView***/
    protected View rootView;

    private WindowManager.LayoutParams layoutParams;

    public LYDialog(Context context) {
        super(context);
    }


    public LYDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    protected LYDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rootView = LayoutInflater.from(getContext()).inflate(getLayoutId() , null);
        setContentView(rootView);

        //默认宽高
        layoutParams = getWindow().getAttributes();
        setDialogHeightRatio(0.3f);
        setDialogWidthRatio(0.8f);
        resetRectForIt();

        if (getWindowAnimations()!=0)
        getWindow().setWindowAnimations(getWindowAnimations());
    }

    public void setDialogWidthRatio(float ratio){
        layoutParams.width = (int) (ScreenTools.getScreenWidth(this.getContext())* ratio);
    }

    public void setDialogHeightRatio(float ratio){
        layoutParams.height = (int) (ScreenTools.getScreenHeight(this.getContext()) * ratio);
    }
    //设置高等与宽
    public void setHeightquipWidth(){
        layoutParams.height = layoutParams.width;
    }

    private void resetRectForIt(){
        getWindow().setAttributes(layoutParams);
    }

    abstract public int getLayoutId();

    public int getWindowAnimations(){
        return 0;
    }

}
