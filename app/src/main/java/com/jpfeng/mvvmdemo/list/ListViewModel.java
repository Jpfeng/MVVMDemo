package com.jpfeng.mvvmdemo.list;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Jpfeng
 * E-mail: fengjp@mixotc.com
 * Date: 2018/10/19
 */
public class ListViewModel extends ViewModel {
    private static final int SIZE = 30;
    private MediatorLiveData<List<String>> data = new MediatorLiveData<>();
    private MutableLiveData<Integer> index = new MutableLiveData<>();

    public ListViewModel() {
        data.addSource(index, this::generateNewData);
        index.setValue(0);
    }

    private void generateNewData(Integer integer) {
        ArrayList<String> newData = new ArrayList<>();
        int start = (null == integer ? 0 : integer) * SIZE;
        for (int i = 0; i < SIZE; i++) {
            newData.add("List Item #" + (start + i));
        }
        data.setValue(newData);
    }

    public void refresh() {
        Integer value = index.getValue();
        index.setValue((null == value ? 0 : value) + 1);
    }

    public LiveData<List<String>> getData() {
        return data;
    }
}
