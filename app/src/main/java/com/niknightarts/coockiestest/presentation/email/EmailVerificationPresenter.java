package com.niknightarts.coockiestest.presentation.email;

import javax.inject.Inject;

import com.arellomobile.mvp.InjectViewState;
import com.niknightarts.coockiestest.BasePresenter;
import com.niknightarts.coockiestest.utils.Screens;

import ru.terrakok.cicerone.Router;

@InjectViewState
public final class EmailVerificationPresenter extends BasePresenter<EmailVerificationView> {
    private final Router router;

    @Inject
    public EmailVerificationPresenter(Router router) {
        this.router = router;
    }

    public void openEmailSuccessScreen() {
        router.navigateTo(new Screens.EmailSuccessScreen());
    }
}
