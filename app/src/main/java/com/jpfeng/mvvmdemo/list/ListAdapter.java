package com.jpfeng.mvvmdemo.list;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.jpfeng.mvvmdemo.R;
import com.jpfeng.mvvmdemo.databinding.ItemListBinding;

import java.util.List;

/**
 * Author: Jpfeng
 * E-mail: fengjp@mixotc.com
 * Date: 2018/10/19
 */
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListHolder> {

    private List<String> mData;

    public void setData(List<String> data) {
        if (null == mData) {
            mData = data;
            notifyItemRangeInserted(0, data.size());

        } else {
            DiffUtil.DiffResult result = DiffUtil.calculateDiff(new DiffUtil.Callback() {
                @Override
                public int getOldListSize() {
                    return mData.size();
                }

                @Override
                public int getNewListSize() {
                    return data.size();
                }

                /**
                 * Called by the DiffUtil to decide whether two object represent the same Item.
                 * <p>
                 * For example, if your items have unique ids, this method should check their id equality.
                 *
                 * @param oldItemPosition The position of the item in the old list
                 * @param newItemPosition The position of the item in the new list
                 * @return True if the two items represent the same object or false if they are different.
                 */
                @Override
                public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                    return TextUtils.equals(mData.get(oldItemPosition), data.get(newItemPosition));
                }

                /**
                 * Called by the DiffUtil when it wants to check whether two items have the same data.
                 * DiffUtil uses this information to detect if the contents of an item has changed.
                 * <p>
                 * DiffUtil uses this method to check equality instead of {@link Object#equals(Object)}
                 * so that you can change its behavior depending on your UI.
                 * For example, if you are using DiffUtil with a
                 * {@link android.support.v7.widget.RecyclerView.Adapter RecyclerView.Adapter}, you should
                 * return whether the items' visual representations are the same.
                 * <p>
                 * This method is called only if {@link #areItemsTheSame(int, int)} returns
                 * {@code true} for these items.
                 *
                 * @param oldItemPosition The position of the item in the old list
                 * @param newItemPosition The position of the item in the new list which replaces the
                 *                        oldItem
                 * @return True if the contents of the items are the same or false if they are different.
                 */
                @Override
                public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                    return true;
                }
            });

            mData = data;
            result.dispatchUpdatesTo(this);
        }
    }

    @NonNull
    @Override
    public ListHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ItemListBinding binding = DataBindingUtil
                .inflate(LayoutInflater.from(viewGroup.getContext()),
                        R.layout.item_list, viewGroup, false);
        return new ListHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ListHolder listHolder, int i) {
        listHolder.mBinding.setListItemText(mData.get(i));
        listHolder.mBinding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return null == mData ? 0 : mData.size();
    }

    class ListHolder extends RecyclerView.ViewHolder {

        private final ItemListBinding mBinding;

        ListHolder(@NonNull ItemListBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }
    }
}
