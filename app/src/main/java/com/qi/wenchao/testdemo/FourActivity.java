package com.qi.wenchao.testdemo;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

public class FourActivity extends Activity implements View.OnClickListener{
    Chronometer timer;
    Button btn_start;
    Button btn_stop;
    Chronometer timer1;
    Button btn_start1;
    Button btn_stop1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);
        timer = (Chronometer) findViewById(R.id.timer);
        btn_start= (Button) findViewById(R.id.btn_start);
        btn_stop= (Button) findViewById(R.id.btn_stop);
        btn_start.setOnClickListener(this);
        btn_stop.setOnClickListener(this);
        timer1 = (Chronometer) findViewById(R.id.timer1);
        btn_start1= (Button) findViewById(R.id.btn_start1);
        btn_stop1= (Button) findViewById(R.id.btn_stop1);
        btn_start1.setOnClickListener(this);
        btn_stop1.setOnClickListener(this);
        timer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer cArg) {
                long time =System.currentTimeMillis() - cArg.getBase();
                Log.i("QWC","System.currentTimeMillis()="+System.currentTimeMillis()+","+"cArg.getBase()="+cArg.getBase());
                Date d = new Date(time);
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss", Locale.CHINA);
                sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
                String format = sdf.format(d);
                int hours = d.getHours();
                int minutes = d.getMinutes();
                int seconds = d.getSeconds();
                Log.i("QWC","hours="+hours+",minutes="+minutes+",second="+seconds);
                timer.setText(Html.fromHtml("累计等候"+"<font color='#ff7272'>"+ format +"</font>"));
            }
        });

        timer1.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_start:
                long now=1531993793;
                long old=1532049173000L;
                timer.setBase(old);
                timer.start();
                break;
            case R.id.btn_stop:
                timer.stop();
                break;
            case R.id.btn_start1:
                timer1.setBase(1532072040000L);
                timer1.start();
                break;
            case R.id.btn_stop1:
                timer1.stop();
                break;

        }
    }

    public enum TIME_TYPE {
        DAY,
        HOUR,
        MINUTE,
        SECOND,;
    }

    /**
     * 计算两个时间时间格式下相差天时分秒
     *
     * @param startTime
     * @param endTime
     * @param format
     * @return
     */
    public static Map<TIME_TYPE, Long> dateDiff(long startTime, long endTime) {
        long nd = 1000 * 24 * 60 * 60;// 一天的毫秒数
        long nh = 1000 * 60 * 60;// 一小时的毫秒数
        long nm = 1000 * 60;// 一分钟的毫秒数
        long ns = 1000;// 一秒钟的毫秒数
        long diff;
        long day = 0;
        long hour = 0;
        long min = 0;
        long sec = 0;
        // 获得两个时间的毫秒时间差异
        diff = endTime - startTime;
        day = diff / nd;// 计算差多少天
        hour = diff % nd / nh + day * 24;// 计算差多少小时
        min = diff % nd % nh / nm + day * 24 * 60;// 计算差多少分钟
        sec = diff % nd % nh % nm / ns;// 计算差多少秒

        Map<TIME_TYPE, Long> resultMap = new HashMap<>();
        resultMap.put(TIME_TYPE.DAY, day);
        resultMap.put(TIME_TYPE.HOUR, (hour - day * 24));
        resultMap.put(TIME_TYPE.MINUTE, (min - day * 24 * 60));
        resultMap.put(TIME_TYPE.SECOND, sec);
        // 输出结果
        return resultMap;

    }
}
