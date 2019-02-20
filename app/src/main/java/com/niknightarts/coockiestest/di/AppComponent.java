package com.niknightarts.coockiestest.di;

import com.niknightarts.coockiestest.di.module.ContextModule;
import com.niknightarts.coockiestest.di.module.NavigationModule;
import com.niknightarts.coockiestest.ui.email.ChangeEmailFragment;
import com.niknightarts.coockiestest.ui.email.EmailSuccessFragment;
import com.niknightarts.coockiestest.ui.email.EmailVerificationFragment;
import com.niknightarts.coockiestest.ui.main.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = {
                ContextModule.class,
                NavigationModule.class
        }
)
public interface AppComponent {
    void inject(MainActivity mainActivity);

    void inject(ChangeEmailFragment changeEmailFragment);

    void inject(EmailVerificationFragment emailVerificationFragment);

    void inject(EmailSuccessFragment emailSuccessFragment);
}
