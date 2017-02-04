package com.zy.myaddsubtract;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        final LinearLayout linear_ll = (LinearLayout) findViewById(R.id.linear_ll);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        final TextView textView = (TextView) findViewById(R.id.text);
        final AddAndSubView a = new AddAndSubView(MainActivity.this);
        linearLayout.addView(a);
        a.setOnNumChangeListener(new AddAndSubView.OnNumChangeListener() {
            @Override
            public void onNumChange(View view, int num) {
                Toast.makeText(MainActivity.this, Integer.toString(num), Toast.LENGTH_SHORT).show();
                textView.setText(Integer.toString(num));
            }
        });

        /**
         * 点击EditText以外的部分，结束EditText焦点。同时隐藏输入法
         */
        linear_ll.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                linear_ll.setFocusable(true);
                linear_ll.setFocusableInTouchMode(true);
                linear_ll.requestFocus();
                return false;
            }
        });
    }


}
