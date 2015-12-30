package com.example.airnavigate.Views.Main.ThematicBloks;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.airnavigate.Model.News;
import com.example.airnavigate.R;
import com.example.airnavigate.Views.Base.Adapter.BaseArrayAdapter;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;


class NewsListAdapter extends BaseArrayAdapter<News, AbstractNewsHolder> {

    private final static int TYPE_REGULAR_POST = 0;
    private final static int TYPE_TWITTER_POST = 1;
    private final static int TYPE_PROGRESS = 2;

    private final static int ID_PROGRESS_ITEM = -2;

    @Inject
    public NewsListAdapter() {
        setHasStableIds(true);
    }

    private boolean isLoading;

    @Override
    protected void onBindViewHolder(AbstractNewsHolder holder, News item) {
        holder.bind(item);
    }


    @Override
    public long getItemId(int position) {
        News item = getItem(position);
        return item == null ? ID_PROGRESS_ITEM : item.getId();
    }

    @Override
    public AbstractNewsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE_REGULAR_POST:
                return new NewsListHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item, parent, false));
//            case TYPE_TWITTER_POST:
//                return new NewsListTwitterHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.news_twitter_item, parent, false));
//            case TYPE_PROGRESS:
//                return new NewsLoadingFooterHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item_footer, parent, false));
            default:
                throw new IllegalStateException("ViewHolder is not implemented");
        }

    }

    @Override
    public int getItemViewType(int position) {
        News item = getItem(position);
        if (item == null) {
            return TYPE_PROGRESS;
        }
//        if (item.getContentType().equals(ContentType.RETWET.value()) || item.getContentType().equals(ContentType.TWEET.value())) {
//            return TYPE_TWITTER_POST;
//        } else {
//            return TYPE_REGULAR_POST;
//        }
        return TYPE_REGULAR_POST;
    }


    @Override
    public void addAll(Collection<News> collection) {
        if (!isEmpty()) {
            //remove the progress item
            News remove = getItems().remove(getItemCount() - 1);
            if (remove != null) {
//                IllegalStateException illegalStateException =
//                        new IllegalStateException("loading logic gone wrong - item removed is not a progress item!");
//                Cr.e(this, illegalStateException);
            }
        }
        super.addAll(collection);
        isLoading = false;
    }

    @Override
    public void setItems(List<News> items) {
        super.setItems(items);
        isLoading = false;

    }

    public void displayLoadingFooter() {
        isLoading = true;
        add(null);//null item means the progress item
    }

    public boolean isLoading() {
        return isLoading;
    }
}
