package com.niknightarts.coockiestest.ui.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.niknightarts.coockiestest.App;
import com.niknightarts.coockiestest.BaseActivity;
import com.niknightarts.coockiestest.R;
import com.niknightarts.coockiestest.utils.Screens;

import javax.inject.Inject;

import butterknife.ButterKnife;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;
import ru.terrakok.cicerone.android.support.SupportAppNavigator;


public final class MainActivity extends BaseActivity {
    @Inject
    NavigatorHolder navigatorHolder;
    @Inject
    Router router;

    public static Intent newIntent(final Context context) {
        return new Intent(context, MainActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        App.appComponent().inject(this);
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        router.replaceScreen(new Screens.ChangeEmailScreen());
    }

    @Override
    protected void onPause() {
        navigatorHolder.removeNavigator();
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        navigatorHolder.setNavigator(new Navigator());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        super.handleOnBackPressed(R.id.main_container);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    private final class Navigator extends SupportAppNavigator {
        Navigator() {
            super(MainActivity.this, R.id.main_container);
        }
    }
}
