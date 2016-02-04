package com.example.airnavigate.Views.Main.Votings.List;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.airnavigate.Model.Voting;
import com.example.airnavigate.R;

import butterknife.Bind;

/**
 * Gokixx CMS article UI representation in list
 * */
class VotingsListHolder extends AbstractVotingHolder {
    @Bind(R.id.votingPreviewImage)
    ImageView votingPreviewImage;
    @Bind(R.id.votingSubject)
    TextView votingTitle;

//    @Bind(R.id.icPlay)
//    ImageView play;

    public VotingsListHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void bind(Voting voting) {
        votingTitle.setText(voting.getSubject());
        loadPicture(voting);
    }

    private void loadPicture(Voting voting) {
        Context context = itemView.getContext();
//        http://lorempixel.com/
//        String altVersion = news.getImage();
//        String primaryVersion = news.getImage2();
//        String url = TextUtils.isEmpty(primaryVersion) ? altVersion : primaryVersion;

//        Picasso.with(context).cancelRequest(newsPreviewImage);
//        Picasso.with(context).load(url).into(newsPreviewImage);

    }


}
