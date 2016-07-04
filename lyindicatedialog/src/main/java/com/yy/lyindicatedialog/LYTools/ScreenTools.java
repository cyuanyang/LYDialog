package com.yy.lyindicatedialog.LYTools;

import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;

/**
 * Created by cyy on 2016/6/27.
 *
 *
 */
public class ScreenTools {

    public static int getScreenHeight(Context context){
        DisplayMetrics dm =  context.getResources().getDisplayMetrics();
        return  dm.heightPixels;
    }

    public static int getScreenWidth(Context context){
        DisplayMetrics dm =  context.getResources().getDisplayMetrics();
        return  dm.widthPixels;
    }

    public static Rect getScreenSize(Context context){
        DisplayMetrics dm =  context.getResources().getDisplayMetrics();
        return  new Rect(0 , 0 , dm.widthPixels , dm.heightPixels);
    }
}
