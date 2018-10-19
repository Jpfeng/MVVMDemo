package com.jpfeng.mvvmdemo;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

/**
 * Author: Jpfeng
 * E-mail: fengjp@mixotc.com
 * Date: 2018/10/17
 */
public class MainViewModel extends ViewModel {
    private final MediatorLiveData<String> text1 = new MediatorLiveData<>();
    private final MediatorLiveData<String> text2 = new MediatorLiveData<>();
    private final MutableLiveData<Integer> count = new MutableLiveData<>();

    public MainViewModel() {
        text1.addSource(count, integer -> text1.setValue("String " + integer));
        text2.addSource(count, integer -> text2.setValue("Text " + integer));
        count.setValue(0);
    }

    public LiveData<String> getText1() {
        return text1;
    }

    public LiveData<String> getText2() {
        return text2;
    }

    public void addCount() {
        int value = null == count.getValue() ? 0 : count.getValue();
        count.setValue(++value);
    }
}
