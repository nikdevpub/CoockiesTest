package com.niknightarts.coockiestest.utils;

import android.support.v4.app.Fragment;

import com.niknightarts.coockiestest.ui.email.ChangeEmailFragment;
import com.niknightarts.coockiestest.ui.email.EmailSuccessFragment;
import com.niknightarts.coockiestest.ui.email.EmailVerificationFragment;

import ru.terrakok.cicerone.android.support.SupportAppScreen;

public final class Screens {
    public static final class ChangeEmailScreen extends SupportAppScreen {
        @Override
        public Fragment getFragment() {
            return ChangeEmailFragment.newInstance();
        }
    }

    public static final class EmailSuccessScreen extends SupportAppScreen {
        @Override
        public Fragment getFragment() {
            return EmailSuccessFragment.newInstance();
        }
    }

    public static final class EmailVerificationScreen extends SupportAppScreen {
        @Override
        public Fragment getFragment() {
            return EmailVerificationFragment.newInstance();
        }
    }
}
