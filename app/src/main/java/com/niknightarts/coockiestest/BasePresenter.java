package com.niknightarts.coockiestest;

import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.MvpView;

public abstract class BasePresenter<V extends MvpView> extends MvpPresenter<V> {
    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
