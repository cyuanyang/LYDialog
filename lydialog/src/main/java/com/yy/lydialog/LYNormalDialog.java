package com.yy.lydialog;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by cyy on 2016/6/27.
 * normal dialog
 * same with system
 */
public class LYNormalDialog extends LYDialog implements View.OnClickListener {

    protected TextView titleView;
    protected TextView contentView;
    protected Button cancelBtn;
    protected Button enterBtn;

    private String title , content , cancel , enter;
    private int animations;

    private DialogDelegate delegate;

    public LYNormalDialog(Context context) {
        this(context, R.style.LYDialog_Transparent);
    }

    public LYNormalDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    public LYNormalDialog(Context context ,  String title , String content , String cancel , String enter , int animations){
        this(context);
        this.title = title ; this.content = content ; this.cancel = cancel;this.enter = enter;
        this.animations = animations;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
    }

    private void initData() {
        titleView.setText(title);
        contentView.setText(content);

        if (!TextUtils.isEmpty(cancel)){
            cancelBtn.setText(cancel);
        }else {
            cancelBtn.setVisibility(View.GONE);
        }

        if (!TextUtils.isEmpty(enter)){
            enterBtn.setText(enter);
        }else {
            enterBtn.setVisibility(View.GONE);
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.normal_dialog;
    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.cancel_btn) {
            if (delegate!=null)delegate.onCancel(view);
        } else if (view.getId() == R.id.enter_btn) {
            if (delegate!=null)delegate.OnEnter(view);

            enterAction();
        }
    }

    protected void enterAction() {

    }

    private void initView() {
        titleView = (TextView) findViewById(R.id.normal_dialog_title);
        contentView = (TextView) findViewById(R.id.contentView);
        cancelBtn = (Button) findViewById(R.id.cancel_btn);
        cancelBtn.setOnClickListener(LYNormalDialog.this);
        enterBtn = (Button) findViewById(R.id.enter_btn);
        enterBtn.setOnClickListener(LYNormalDialog.this);
    }

    @Override
    public int getWindowAnimations() {
        return animations;
    }

    public void setDelegate(DialogDelegate delegate){
        this.delegate = delegate;
    }

    public static class Builder{
        protected String title;
        protected String content;
        protected String cancel;
        protected String enter;
        protected int anim = 0;

        protected Context context;

        public Builder(Context context){
            this.context = context;
        }

        public Builder setTitle(String title){
            this.title = title;
            return this;
        }
        public Builder setContent(String content){
            this.content = content;
            return this;
        }

        public Builder setCancel(String cancel) {
            this.cancel = cancel;
            return this;
        }

        public Builder setEnter(String enter) {
            this.enter = enter;
            return this;
        }

        public Builder setAnim(int anim){
            this.anim = anim;
            return this;
        }

        public LYNormalDialog build(){
            return new LYNormalDialog(context ,title,content,cancel,enter , anim);
        }
    }


}
