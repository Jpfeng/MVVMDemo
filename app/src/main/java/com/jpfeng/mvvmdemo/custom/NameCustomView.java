package com.jpfeng.mvvmdemo.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.jpfeng.mvvmdemo.BR;
import com.jpfeng.mvvmdemo.R;
import com.jpfeng.mvvmdemo.databinding.ViewNameBinding;

import androidx.annotation.Nullable;
import androidx.databinding.BindingMethod;
import androidx.databinding.BindingMethods;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;

/**
 * Author: Jpfeng
 * E-mail: fengjp@mixotc.com
 * Date: 2018/10/22
 */
@BindingMethods({
        @BindingMethod(type = NameCustomView.class,
                attribute = "name",
                method = "showName")
})
public class NameCustomView extends LinearLayout {

    private ViewNameBinding mBinding;
    private final ObservableField<Name> mName = new ObservableField<>();

    public NameCustomView(Context context) {
        this(context, null);
    }

    public NameCustomView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NameCustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mBinding = DataBindingUtil.inflate(LayoutInflater.from(context),
                R.layout.view_name, this, true);
        setOrientation(VERTICAL);
        int padding = getResources().getDimensionPixelSize(R.dimen.default_padding);
        setPaddingRelative(padding, padding, padding, padding);
        mName.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                mBinding.setVariable(BR.propertyName, mName.get());
            }
        });
    }

    public void showName(Name name) {
        mName.set(name);
    }
}
