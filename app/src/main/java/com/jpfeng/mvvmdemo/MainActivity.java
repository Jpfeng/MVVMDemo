package com.jpfeng.mvvmdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View.OnClickListener;

import com.jpfeng.mvvmdemo.databinding.ActivityMainBinding;
import com.jpfeng.mvvmdemo.list.ListActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

public class MainActivity extends AppCompatActivity {

    private MainViewModel mModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mModel = ViewModelProviders.of(this).get(MainViewModel.class);
        final ActivityMainBinding binding
                = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mModel.getText1().observe(this, s -> binding.setVariable(BR.mainText1, s));
        mModel.getText2().observe(this, s -> binding.setVariable(BR.mainText2, s));
        binding.setVariable(BR.mainClickListener, (OnClickListener) v -> mModel.addCount());
        binding.setVariable(BR.mainListClickListener, (OnClickListener) v -> toList());
    }

    private void toList() {
        startActivity(new Intent(this, ListActivity.class));
    }
}
