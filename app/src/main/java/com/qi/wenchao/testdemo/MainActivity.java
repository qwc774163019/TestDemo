package com.qi.wenchao.testdemo;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    TextView tv1;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv= (TextView) findViewById(R.id.tv);
        tv1= (TextView) findViewById(R.id.tv1);
        tv1.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG|Paint.ANTI_ALIAS_FLAG);
        tv1.setTextColor(Color.parseColor("#646464"));
//        tv.setText(PhoneUtils.getPhoneStatus(this));
//        String content="您取消行程过晚，需支付取消费，这是本月最后一次免费取消的机会，请谨慎操作，以免多次取消产生扣款";
//        String msg="本月最后一次";
//        int start = content.indexOf(msg);
//        SpannableString spannableString = setTextForeground(content, start, start + msg.length(), Color.parseColor("#ff5252"));
//        tv.setText(spannableString);

//        String str="3元";
//        String money="3";
//        int start=str.indexOf(money);
//        tv.setText(setTextSize(str,start+money.length(),str.length(),(int)sp2px(this,15f)));
        btn= (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,RadioActivity.class));
            }
        });
    }

    public static SpannableString setTextForeground(String content, int startIndex, int endIndex, int foregroundColor) {
        if (android.text.TextUtils.isEmpty(content) || startIndex < 0 || endIndex >= content.length() || startIndex >= endIndex) {
            return null;
        }

        SpannableString spannableString = new SpannableString(content);
        spannableString.setSpan(new ForegroundColorSpan(foregroundColor), startIndex, endIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        return spannableString;
    }


    public static SpannableString setTextSize(String content, int startIndex, int endIndex, int fontSize) {
        if (android.text.TextUtils.isEmpty(content) || fontSize <= 0 || startIndex >= endIndex || startIndex < 0 || endIndex > content.length()) {
            return null;
        }

        SpannableString spannableString = new SpannableString(content);
        spannableString.setSpan(new AbsoluteSizeSpan(fontSize), startIndex, endIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        return spannableString;
    }

    public static float sp2px(Context context, float spValue) {
        if (context == null)
            return 0;
        return spValue * context.getResources().getDisplayMetrics().scaledDensity;
    }
}
