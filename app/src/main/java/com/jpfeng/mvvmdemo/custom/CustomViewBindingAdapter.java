package com.jpfeng.mvvmdemo.custom;

import androidx.databinding.BindingAdapter;

/**
 * Author: Jpfeng
 * E-mail: fengjupeng@whale.ws
 * Date: 2018/10/24
 */
public class CustomViewBindingAdapter {

    @BindingAdapter({"firstName", "lastName"})
    public static void showName(NameCustomView view, String firstName, String lastName) {
        view.showName(new Name(firstName, lastName));
    }
}
