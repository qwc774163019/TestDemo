package com.qi.wenchao.testdemo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.bumptech.glide.GenericTransitionOptions;
import com.bumptech.glide.Glide;
import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;

import static com.qi.wenchao.testdemo.GlideOptions.centerCropTransform;

/**
 * @author chao
 * @Description {todo}
 * @date 2018/3/8 下午2:33
 * @todo:
 */
public class SecondActivity extends Activity {

    ImageView iv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.i("QWC","Second---onCreate");
        iv= (ImageView) findViewById(R.id.iv);
        String url = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1523188553723&di=754f103770ecfaa7c2627f6063f1ed8c&imgtype=0&src=http%3A%2F%2Fpic.58pic.com%2F58pic%2F15%2F24%2F50%2F43Q58PICkj4_1024.jpg";
//        Glide.with(this).load(url).error(R.mipmap.ic_launcher).into(iv);
//        Glide.with(this).load(url).into(new SimpleTarget<GlideDrawable>() {
//            @Override
//            public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
//               iv.setImageDrawable(resource);
//            }
//        });
//        String url="http://i2.mhimg.com/M00/0E/AE/CgAAilTPWJ2Aa_EIACcMxiZi5xE299.gif";
//        Glide.with(this).load(url).asGif().error(R.mipmap.ic_launcher).into(iv);
        Glide.with(this).load(url).apply(RequestOptions.placeholderOf(R.mipmap.ic_launcher)).into(iv);
//        GlideApp.with(this).load(url).placeholder(R.mipmap.ic_launcher).into(iv);
        GlideApp.with(this).load(url).apply(centerCropTransform()).transition(DrawableTransitionOptions.withCrossFade()).into(iv);
        GlideApp.with(this).load(url).thumbnail(GlideApp.with(this).load(url).override(100)).into(iv);
        GlideApp.with(this).load(url).miniThumb().into(iv);
        GlideApp.with(this).load(R.mipmap.ic_launcher).listener(new RequestListener<Drawable>() {
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object o, Target<Drawable> target, boolean b) {
                return false;
            }

            @Override
            public boolean onResourceReady(Drawable drawable, Object o, Target<Drawable> target, DataSource dataSource, boolean b) {
                if(dataSource==DataSource.MEMORY_CACHE){
//                    iv.startAnimation(AnimationUtils.loadAnimation(this,R.anim.));
                }
                return false;
            }
        }).transition(GenericTransitionOptions.<Drawable>withNoTransition()).into(iv);
        GlideApp.with(this).load(url).transition(DrawableTransitionOptions.withCrossFade()).into(iv);
        GlideApp.with(this).load(url).dontAnimate().into(iv);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("QWC","Second---onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("QWC","Second---onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("QWC","Second---onResume");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.i("QWC","Second---onPostResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("QWC","Second---onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("QWC","Second---onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("QWC","Second---onDestroy");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i("QWC","Second---onActivityResult");
    }
}
