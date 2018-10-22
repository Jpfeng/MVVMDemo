package com.jpfeng.mvvmdemo.list;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.jpfeng.mvvmdemo.R;
import com.jpfeng.mvvmdemo.databinding.ActivityListBinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

public class ListActivity extends AppCompatActivity {

    private ListViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ListViewModel.class);
        ActivityListBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_list);
        ListAdapter adapter = new ListAdapter();
        binding.rvListDemo.setAdapter(adapter);

        mViewModel.getData().observe(this, adapter::setData);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.list_action, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.list_action_refresh:
                mViewModel.refresh();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
