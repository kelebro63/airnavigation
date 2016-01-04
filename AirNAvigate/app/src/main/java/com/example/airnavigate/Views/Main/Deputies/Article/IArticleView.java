package com.example.airnavigate.Views.Main.Deputies.Article;

import com.example.airnavigate.MVP.IView;
import com.example.airnavigate.Model.Deputy;

interface IArticleView extends IView {
    void displayDeputyInfo(Deputy deputy);
}
