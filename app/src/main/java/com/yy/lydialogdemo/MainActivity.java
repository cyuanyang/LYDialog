package com.yy.lydialogdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.yy.lydialog.LYNormalDialog;
import com.yy.lydialog.LYQuintDialog;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    protected Button normalBtn;
    protected Button dropBtn;
    protected Button scaleBtn;
    protected Button slideBtn;
    protected Button btn3d;
    protected Button inBtn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);
        initView();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.normal_btn) {
            LYNormalDialog.Builder builder = new LYNormalDialog.Builder(this);
            builder.setTitle("提示")
                    .setContent("您欠费了！")
                    .setEnter("缴费");
            builder.build().show();

        } else if (view.getId() == R.id.drop_btn) {
            LYNormalDialog.Builder builder = new LYNormalDialog.Builder(this);
            builder.setTitle("提示")
                    .setContent("您欠费了！")
                    .setEnter("缴费")
                    .setAnim(R.style.LYDialog_DropAnim);
            builder.build().show();
        } else if (view.getId() == R.id.scale_btn) {
            LYNormalDialog.Builder builder = new LYNormalDialog.Builder(this);
            builder.setTitle("提示")
                    .setContent("scale！")
                    .setEnter("缴费")
                    .setAnim(R.style.LYDialog_ScaleAnim);
            builder.build().show();
        } else if (view.getId() == R.id.slide_btn) {
            LYNormalDialog.Builder builder = new LYNormalDialog.Builder(this);
            builder.setTitle("提示")
                    .setContent("slide！")
                    .setEnter("缴费")
                    .setAnim(R.style.LYDialog_SlideAnim);
            builder.build().show();
        } else if (view.getId() == R.id.btn_3d) {
            LYQuintDialog.Builder builder = new LYQuintDialog.Builder(this);
            builder.setTitle("提示")
                    .setContent("Quint！")
                    .setEnter("给钱")
                    .setCancel("取消");
//                    .setAnim(R.style.LYDialog_SlideAnim);
            builder.build().show();
        } else if (view.getId() == R.id.in_btn1) {

        }
    }

    private void initView() {
        normalBtn = (Button) findViewById(R.id.normal_btn);
        normalBtn.setOnClickListener(MainActivity.this);
        dropBtn = (Button) findViewById(R.id.drop_btn);
        dropBtn.setOnClickListener(MainActivity.this);
        scaleBtn = (Button) findViewById(R.id.scale_btn);
        scaleBtn.setOnClickListener(MainActivity.this);
        slideBtn = (Button) findViewById(R.id.slide_btn);
        slideBtn.setOnClickListener(MainActivity.this);
        btn3d = (Button) findViewById(R.id.btn_3d);
        btn3d.setOnClickListener(MainActivity.this);
        inBtn1 = (Button) findViewById(R.id.in_btn1);
        inBtn1.setOnClickListener(MainActivity.this);
    }
}
