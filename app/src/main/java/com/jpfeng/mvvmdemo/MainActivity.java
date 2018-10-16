package com.jpfeng.mvvmdemo;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private MainViewModel mModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mModel = ViewModelProviders.of(this).get(MainViewModel.class);
        final ViewDataBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mModel.getText1().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                binding.setVariable(BR.text1, s);
            }
        });

        mModel.getText2().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                binding.setVariable(BR.text2, s);
            }
        });

        binding.setVariable(BR.handler, new ClickHandler());
    }

    public class ClickHandler {
        public void onClick() {
            mModel.addCount();
        }
    }

    public static class MainViewModel extends ViewModel {
        private final MutableLiveData<String> text1 = new MutableLiveData<>();
        private final MutableLiveData<String> text2 = new MutableLiveData<>();
        private final MutableLiveData<Integer> count = new MutableLiveData<>();

        public MainViewModel() {
            count.observeForever(new Observer<Integer>() {
                @Override
                public void onChanged(@Nullable Integer integer) {
                    text1.setValue("String " + integer);
                    text2.setValue("Text " + integer);
                }
            });

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
}
