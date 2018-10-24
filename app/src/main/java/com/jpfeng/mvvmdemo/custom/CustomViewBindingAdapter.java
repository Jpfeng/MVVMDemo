package com.jpfeng.mvvmdemo.custom;

import androidx.databinding.BindingAdapter;

/**
 * Author: Jpfeng
 * E-mail: fengjupeng@whale.ws
 * Date: 2018/10/24
 */
public class CustomViewBindingAdapter {

    @BindingAdapter("name")
    public static void showName(NameCustomView view, Name name) {
        view.showName(name);
    }
}
