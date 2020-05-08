package com.gxun.myactivitydemo;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.gxun.myactivitydemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    MyViewModel myViewModel;
    ActivityMainBinding binding;
    double n = 0;
    String ATG="myActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        myViewModel = ViewModelProviders.of(this).get(MyViewModel.class);
        myViewModel.getNumber().observe(this, new Observer<Double>() {
            @Override
            public void onChanged(@Nullable Double aDouble) {
                n = Double.parseDouble(String.valueOf(aDouble));
            }
        });

        binding.button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(binding.editText1.getText().toString().trim()) || TextUtils.isEmpty(binding.editText2.getText().toString().trim())) {
                    Toast.makeText(MainActivity.this, "数字不能为空", Toast.LENGTH_SHORT).show();
                } else {
                    myViewModel.sub(Double.parseDouble(binding.editText1.getText().toString()), Double.parseDouble(binding.editText2.getText().toString()));
                    String s = String.valueOf(binding.editText1.getText().toString()) + "*" + String.valueOf(binding.editText2.getText().toString() + "=" + String.valueOf(n));
                    Intent intent = new Intent(MainActivity.this, ActivityB.class);
                    //使用putExtra（）方法传递数据
                    intent.putExtra("name", s);
                    //由于需要返回数据，使用 startActivityForResult()方法
                    startActivityForResult(intent, 1);
                }
            }
        });
        binding.button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(binding.editText1.getText().toString().trim()) || TextUtils.isEmpty(binding.editText2.getText().toString().trim())) {
                    Toast.makeText(MainActivity.this, "数字不能为空", Toast.LENGTH_SHORT).show();
                } else if (Double.parseDouble(binding.editText2.getText().toString()) == 0) {
                    Toast.makeText(MainActivity.this, "数字不能为0", Toast.LENGTH_SHORT).show();

                } else {
                    myViewModel.div(Double.parseDouble(binding.editText1.getText().toString()), Double.parseDouble(binding.editText2.getText().toString()));
                    String s = String.valueOf(binding.editText1.getText().toString()) + "/" + String.valueOf(binding.editText2.getText().toString() + "=" + String.valueOf(n));
                    Intent intent = new Intent(MainActivity.this, ActivityB.class);
                    //使用putExtra（）方法传递数据
                    intent.putExtra("name", s);
                    //由于需要返回数据，使用 startActivityForResult()方法
                    startActivityForResult(intent, 1);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                String str = data.getStringExtra("back");
                String str1 = str.substring(0, str.indexOf("="));
                String str2 = str.substring(str1.length() + 1, str.length());
                if (str.contains("/")) {
                    binding.textView9.setText("除法");
                } else {
                    binding.textView9.setText("乘法");
                }
                binding.textView10.setText(str2);

            }
        }
    }
}
