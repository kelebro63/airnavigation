package com.example.airnavigate.Views.Main.Votings.List;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.airnavigate.Dao.Voting;
import com.example.airnavigate.R;
import com.example.airnavigate.Views.Base.Adapter.BaseArrayAdapter;
import com.example.airnavigate.Dao.Voting;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;


class VotingsListAdapter extends BaseArrayAdapter<Voting, AbstractVotingHolder> {

    private final static int TYPE_STANDART_VOTING = 0;
    private final static int TYPE_PROGRESS = 2;
    private final static int ID_PROGRESS_ITEM = -2;

    @Inject
    public VotingsListAdapter() {
        setHasStableIds(true);
    }

    private boolean isLoading;

    @Override
    protected void onBindViewHolder(AbstractVotingHolder holder, Voting item) {
        holder.bind(item);
    }


    @Override
    public long getItemId(int position) {
        Voting item = getItem(position);
        return item == null ? ID_PROGRESS_ITEM : (int) item.getId();
    }

    @Override
    public AbstractVotingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE_STANDART_VOTING:
                return new VotingsListHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.voting_item, parent, false));
            case TYPE_PROGRESS:
                return new VotingsLoadingFooterHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item_footer, parent, false));
            default:
                throw new IllegalStateException("ViewHolder is not implemented");
        }

    }

    @Override
    public int getItemViewType(int position) {
        Voting item = getItem(position);
        if (item == null) {
            return TYPE_PROGRESS;
        }
        return TYPE_STANDART_VOTING;
    }


    @Override
    public void addAll(Collection<Voting> collection) {
        if (!isEmpty()) {
            //remove the progress item
            Voting remove = getItems().remove(getItemCount() - 1);
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
    public void setItems(List<Voting> items) {
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
