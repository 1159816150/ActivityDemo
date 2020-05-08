package com.gxun.myactivitydemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class ActivityB extends AppCompatActivity {
    String ATG="myActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        final String var = getIntent().getStringExtra("name");
        TextView textView = findViewById(R.id.textView4);
        textView.setText(var);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                Log.d(ATG,"???33");
                intent.putExtra("back", var);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

    }

}
