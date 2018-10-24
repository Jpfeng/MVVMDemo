package com.jpfeng.mvvmdemo.custom;

import java.util.ArrayList;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Author: Jpfeng
 * E-mail: fengjupeng@whale.ws
 * Date: 2018/10/24
 */
public class CustomViewViewModel extends ViewModel {

    private final MediatorLiveData<Name> mName = new MediatorLiveData<>();
    private final MutableLiveData<Integer> mIndex = new MediatorLiveData<>();
    private final ArrayList<Name> mNames = new ArrayList<>();

    public CustomViewViewModel() {
        mNames.add(new Name("Tyler", "Swift"));
        mNames.add(new Name("Jupeng", "feng"));
        mNames.add(new Name("Jack", "Ma"));
        mName.addSource(mIndex, integer -> mName.setValue(mNames.get(integer % mNames.size())));
        mIndex.setValue(0);
    }

    public LiveData<Name> getName() {
        return mName;
    }

    public void addCount() {
        int value = null == mIndex.getValue() ? 0 : mIndex.getValue();
        mIndex.setValue(++value);
    }
}
