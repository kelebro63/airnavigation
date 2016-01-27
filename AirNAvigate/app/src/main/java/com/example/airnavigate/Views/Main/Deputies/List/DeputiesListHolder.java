package com.example.airnavigate.Views.Main.Deputies.List;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.airnavigate.Dao.Deputy;
import com.example.airnavigate.R;

import butterknife.Bind;

/**
 * Gokixx CMS article UI representation in list
 * */
class DeputiesListHolder extends AbstractDeputiesHolder {
    @Bind(R.id.newsPreviewImage)
    ImageView newsPreviewImage;
    @Bind(R.id.newsTitle)
    TextView newsTitle;
    @Bind(R.id.newsTags)
    TextView newsTags;

//    @Bind(R.id.icPlay)
//    ImageView play;

    public DeputiesListHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void bind(Deputy deputy) {

        loadPicture(deputy);

        newsTitle.setText(deputy.getName());
       // newsTags.setText(news.getSubtitle());
       // boolean hasVideo = news.getContentType().equals(ContentType.VIDEO.value());
       // play.setVisibility(hasVideo ? View.VISIBLE : View.GONE);
    }

    private void loadPicture(Deputy deputy) {
        Context context = itemView.getContext();

//        String altVersion = news.getImage();
//        String primaryVersion = news.getImage2();
//        String url = TextUtils.isEmpty(primaryVersion) ? altVersion : primaryVersion;

//        Picasso.with(context).cancelRequest(newsPreviewImage);
//        Picasso.with(context).load(url).into(newsPreviewImage);

    }


}
