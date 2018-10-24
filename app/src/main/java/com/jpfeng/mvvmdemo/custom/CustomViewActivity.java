package com.jpfeng.mvvmdemo.custom;

import android.os.Bundle;
import android.view.View;

import com.jpfeng.mvvmdemo.BR;
import com.jpfeng.mvvmdemo.R;
import com.jpfeng.mvvmdemo.databinding.ActivityCustomViewBinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

public class CustomViewActivity extends AppCompatActivity {

    private CustomViewViewModel mModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mModel = ViewModelProviders.of(this).get(CustomViewViewModel.class);
        ActivityCustomViewBinding binding
                = DataBindingUtil.setContentView(this, R.layout.activity_custom_view);
        mModel.getName().observe(this, name -> binding.setVariable(BR.activityName, name));
        binding.setVariable(BR.changeNameClickListener, (View.OnClickListener) v -> mModel.addCount());
    }
}
