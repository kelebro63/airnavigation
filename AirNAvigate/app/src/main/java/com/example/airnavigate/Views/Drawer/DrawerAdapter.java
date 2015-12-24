package com.example.airnavigate.Views.Drawer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.airnavigate.R;

import java.util.List;


/**
 * Adapter for drawer menu
 */
class DrawerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {


    private List<DrawerItem> mItems;
    private LayoutInflater mInflater;
    private DrawerAdapterCallbacks mCallbacks;

    public DrawerAdapter(@NonNull Context context,
                         @NonNull List<DrawerItem> mItems,
                         @NonNull DrawerAdapterCallbacks callbacks) {
        this.mItems = mItems;
        this.mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.mCallbacks = callbacks;

    }

    public boolean isEnabled(int position) {
        return mItems.get(position).getType() != DrawerItem.Type.HEADER &&  mItems.get(position).getType() != DrawerItem.Type.TOP;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == DrawerItem.Type.TOP.ordinal()) {
            return new NavDrawerHeaderHolder(mInflater.inflate(R.layout.drawer_item_top, parent, false));
        } else if (viewType == DrawerItem.Type.HEADER.ordinal()) {
            return new NavDrawerHeaderHolder(mInflater.inflate(R.layout.drawer_item_header_more, parent, false));
        } else if (viewType == DrawerItem.Type.MAIN_ITEM.ordinal()) {
            return new NavDrawerItemHolder(mInflater.inflate(R.layout.drawer_item_main, parent, false));
        } else {
            return new NavDrawerItemHolder(mInflater.inflate(R.layout.drawer_item_more_item, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof NavDrawerItemHolder) {
            ((NavDrawerItemHolder) holder).bind(mItems.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return mItems == null ? 0 : mItems.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mItems.get(position).getType().ordinal();
    }


    public void setSelected(int position) {
        for (int i = 0; i < mItems.size(); i++) {
            mItems.get(i).setSelected(false);
            if (i == position) {
                mItems.get(i).setSelected(true);
            }
        }
        notifyDataSetChanged();
    }



    @Override
    public void onClick(View v) {

    }


    public class NavDrawerHeaderHolder extends RecyclerView.ViewHolder {


        public NavDrawerHeaderHolder(View itemView) {
            super(itemView);

        }
    }


    public class NavDrawerItemHolder extends RecyclerView.ViewHolder {
        int colorRegular;
        int colorSelected;
        View root;
        ImageView icon;
        TextView title;

        public NavDrawerItemHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mCallbacks.onPositionSelected(getPosition());
                }
            });
            Context context = itemView.getContext();
            root = itemView;
            icon = (ImageView) itemView.findViewById(R.id.drawer_item_icon);
            title = (TextView) itemView.findViewById(R.id.drawer_item_title);
            colorRegular = context.getResources().getColor(R.color.darker_darker_gray_color);
            colorSelected = context.getResources().getColor(R.color.navdrawer_text_color_selected);

        }

        public void bind(DrawerItem item) {
            icon.setImageResource(item.isSelected() ? item.getIcons().getIconActiveResource()
                    : item.getIcons().getIconInactiveResource());

            title.setText(item.getTitle());

            /*
            title.setTextColor(item.isSelected() ?
                    colorSelected :
                    colorRegular);
                    */

            root.setSelected(item.isSelected());

        }
    }

    public interface DrawerAdapterCallbacks{
        public void onPositionSelected(int position);
    }

}
