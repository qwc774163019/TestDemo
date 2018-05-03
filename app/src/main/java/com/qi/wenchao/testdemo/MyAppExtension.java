package com.qi.wenchao.testdemo;

import com.bumptech.glide.annotation.GlideExtension;
import com.bumptech.glide.annotation.GlideOption;
import com.bumptech.glide.request.RequestOptions;

/**
 * @author chao
 * @Description {todo}
 * @date 2018/4/9 下午5:50
 * @todo:
 */
@GlideExtension
public class MyAppExtension {
    private  static final int MINI_THUMB_SIZE=100;

    private MyAppExtension() {
    }

    @GlideOption
    public static void miniThumb(RequestOptions options){
        options.fitCenter().override(MINI_THUMB_SIZE);
    }
}
