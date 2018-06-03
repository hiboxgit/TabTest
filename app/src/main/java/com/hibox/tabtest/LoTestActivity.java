package com.hibox.tabtest;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.bumptech.glide.Glide;
import com.rrtoyewx.touchimageviewlibrary.TouchImageView;

public class LoTestActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showStatusBar();
        setContentView(R.layout.activity_lo_test);

        TouchImageView imageView = (TouchImageView)findViewById(R.id.tiv_main_image);
        Glide.with(this)
                .load("http://pic1.win4000.com/mobile/1/520d9410ebc79.jpg")
                .into(imageView);
    }

    private void showStatusBar() { //使得布局内容可以填充整个屏幕，状态栏悬浮在布局上面，
//        WindowManager.LayoutParams attrs = getWindow().getAttributes();
//        attrs.flags &= ~WindowManager.LayoutParams.FLAG_FULLSCREEN;
//        getWindow().setAttributes(attrs);
//
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
//        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);



//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
//            WindowManager.LayoutParams flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
//            if(Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP){
//                //将侧边栏顶部延伸至status bar
//                mDrawerLayout.setFitsSystemWindows(true);
//                //将主页面顶部延伸至status bar;虽默认为false,但经测试,DrawerLayout需显示设置
//                mDrawerLayout.setClipToPadding(false);
//            }
//        }

        init();

    }

    private void init(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }

}
