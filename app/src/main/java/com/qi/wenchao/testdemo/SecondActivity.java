package com.qi.wenchao.testdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * @author chao
 * @Description {todo}
 * @date 2018/3/8 下午2:33
 * @todo:
 */
public class SecondActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.i("QWC","Second---onCreate");
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
