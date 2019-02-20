package com.niknightarts.coockiestest.presentation.email;

import javax.inject.Inject;

import com.arellomobile.mvp.InjectViewState;
import com.niknightarts.coockiestest.BasePresenter;
import com.niknightarts.coockiestest.utils.Screens;

import ru.terrakok.cicerone.Router;

@InjectViewState
public final class ChangeEmailPresenter extends BasePresenter<ChangeEmailView> {
    private final Router router;

    @Inject
    public ChangeEmailPresenter(Router router) {
        this.router = router;
    }

    public void openVerificationScreen() {
        router.navigateTo(new Screens.EmailVerificationScreen());
    }
}
