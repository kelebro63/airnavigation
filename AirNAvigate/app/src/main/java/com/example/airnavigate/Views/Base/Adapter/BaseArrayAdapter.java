package com.example.airnavigate.Views.Base.Adapter;

import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Abstract RecyclerView Array-based adapter
 */
public abstract class BaseArrayAdapter<T, VH extends BaseViewHolder> extends RecyclerView.Adapter<VH> {
    private List<T> items;
    private OnItemClickListener<T> itemClickListener;

    public BaseArrayAdapter() {
        items = new ArrayList<>();
    }

    protected List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    public void addAll(Collection<T> collection) {
        items.addAll(collection);
        notifyDataSetChanged();
    }

    public void add(T item) {
        items.add(item);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return items == null ? 0 : items.size();
    }

    public T getItem(int position) {
        return items.get(position);
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        if (holder.itemView != null) {
            holder.itemView.setOnClickListener(v -> {
                T item = getItem(position);
                if (itemClickListener != null) {
                    itemClickListener.onItemClicked(item);
                }
            });
        }
        onBindViewHolder(holder, getItem(position));
    }

    protected abstract void onBindViewHolder(VH holder, T item);

    public void setItemClickListener(OnItemClickListener<T> itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public boolean isEmpty() {
        return items == null || items.size() == 0;
    }

    protected void notifyItemSelected(T item) {
        if (itemClickListener != null) {
            itemClickListener.onItemClicked(item);
        }
    }

    public interface OnItemClickListener<T> {
        void onItemClicked(T item);
    }
}
