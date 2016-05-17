package com.example.airnavigate.Views.Main.ThematicBloks;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.airnavigate.Dao.Topic;
import com.example.airnavigate.R;

import butterknife.Bind;

/**
 * CMS article UI representation in list
 * */
class TopicsListHolder extends AbstractTopicsHolder {
    @Bind(R.id.newsPreviewImage)
    ImageView newsPreviewImage;
    @Bind(R.id.newsTitle)
    TextView newsTitle;
    @Bind(R.id.newsTags)
    TextView newsTags;

//    @Bind(R.id.icPlay)
//    ImageView play;

    public TopicsListHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void bind(Topic news) {

        loadPicture(news);

        newsTitle.setText(news.getName());
       // newsTags.setText(news.getSubtitle());
       // boolean hasVideo = news.getContentType().equals(ContentType.VIDEO.value());
       // play.setVisibility(hasVideo ? View.VISIBLE : View.GONE);
    }

    private void loadPicture(Topic news) {
        Context context = itemView.getContext();

//        String altVersion = news.getImage();
//        String primaryVersion = news.getImage2();
//        String url = TextUtils.isEmpty(primaryVersion) ? altVersion : primaryVersion;

//        Picasso.with(context).cancelRequest(newsPreviewImage);
//        Picasso.with(context).load(url).into(newsPreviewImage);

    }


}
