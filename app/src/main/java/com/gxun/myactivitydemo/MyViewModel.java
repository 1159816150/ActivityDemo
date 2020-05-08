package com.gxun.myactivitydemo;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    private MutableLiveData<Double> number;

    MutableLiveData<Double> getNumber() {
        if (number == null) {
            number = new MutableLiveData<>();
            number.setValue((double) 0);
        }
        return number;
    }

    void sub(double a, double b) {

        number.setValue((double) (a * b));

    }

    void div(double a, double b) {
        if(b==0){
            number.setValue((double) 0);
        }
        if(b!=0) {
            number.setValue((a / b));
        }
    }
}
