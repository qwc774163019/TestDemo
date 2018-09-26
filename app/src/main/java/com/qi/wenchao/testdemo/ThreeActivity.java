package com.qi.wenchao.testdemo;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author chao
 * @Description {todo}
 * @date 2018/3/8 下午2:33
 * @todo:
 */
public class ThreeActivity extends Activity {
    Button dialog;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        Log.i("QWC","Three---onCreate");
        dialog= (Button) findViewById(R.id.dialog);
        dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Dialog(ThreeActivity.this).show();
            }
        });
        String address = "";
        try {
            JSONObject jo = new JSONObject();
            jo.put("city", "北京市");
            jo.put("place_name", "方恒");
            jo.put("latitude", "39.12344");
            jo.put("longitude", "116.32334");
            address = jo.toString();
            Log.i("QWC",address);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("QWC","Three---onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("QWC","Three---onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("QWC","Three---onResume");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.i("QWC","Three---onPostResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("QWC","Three---onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("QWC","Three---onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("QWC","Three---onDestroy");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i("QWC","Three---onActivityResult");
    }
}
