package com.niknightarts.coockiestest.presentation.email;

import javax.inject.Inject;

import com.arellomobile.mvp.InjectViewState;
import com.niknightarts.coockiestest.BasePresenter;

import ru.terrakok.cicerone.Router;

@InjectViewState
public final class EmailSuccessPresenter extends BasePresenter<EmailSuccessView> {
    private final Router router;

    @Inject
    public EmailSuccessPresenter(Router router) {
        this.router = router;
    }
}
