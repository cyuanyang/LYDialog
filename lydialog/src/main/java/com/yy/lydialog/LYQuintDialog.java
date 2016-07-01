package com.yy.lydialog;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

/**
 * Created by cyy on 2016/6/28.
 *
 * 专门做动画的dialog
 */
public class LYQuintDialog extends LYNormalDialog{

    public LYQuintDialog(Context context) {
        super(context);
    }

    public LYQuintDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    public LYQuintDialog(Context context, String title, String content, String cancel, String enter, int animations) {
        super(context, title, content, cancel, enter, animations);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void enterAction() {
        super.enterAction();

        ObjectAnimator//
                .ofFloat(rootView, "rotationX", 0.0F, 360.0F)//
                .setDuration(5000)//
                .start();
    }

    public static class Builder extends LYNormalDialog.Builder{
        public Builder(Context context) {
            super(context);
        }

        @Override
        public LYNormalDialog build() {
            return  new LYQuintDialog(context ,title,content,cancel,enter , anim);
        }
    }
}
