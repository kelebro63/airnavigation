package com.example.airnavigate.Views.Main.Deputies.Article;

import com.example.airnavigate.Dao.Deputy;
import com.example.airnavigate.MVP.IView;

interface IArticleView extends IView {
    void displayDeputyInfo(Deputy deputy);
}
