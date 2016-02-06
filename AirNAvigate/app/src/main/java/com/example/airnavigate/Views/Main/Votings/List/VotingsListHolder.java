package com.example.airnavigate.Views.Main.Votings.List;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.airnavigate.Dao.Voting;
import com.example.airnavigate.R;
import com.squareup.picasso.Picasso;

import java.util.Random;

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
        final Random random = new Random();
        String url = "http://lorempixel.com/400/200/sports/" + random.nextInt(11);

        Picasso.with(context).cancelRequest(votingPreviewImage);
        Picasso.with(context).load(url).placeholder(android.R.drawable.gallery_thumb).resize(216, 216).centerCrop().into(votingPreviewImage);

    }


}
