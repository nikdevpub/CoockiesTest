package com.niknightarts.coockiestest.ui.email;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import com.niknightarts.coockiestest.App;
import com.niknightarts.coockiestest.BaseFragment;
import com.niknightarts.coockiestest.R;
import com.niknightarts.coockiestest.presentation.email.EmailSuccessView;
import com.niknightarts.coockiestest.presentation.email.EmailSuccessPresenter;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

public final class EmailSuccessFragment extends BaseFragment implements EmailSuccessView {
    @Inject
    @InjectPresenter
    EmailSuccessPresenter presenter;
    Unbinder unbinder;

    public static EmailSuccessFragment newInstance() {
        EmailSuccessFragment fragment = new EmailSuccessFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @ProvidePresenter
    EmailSuccessPresenter providePresenter() {
        return presenter;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        App.appComponent().inject(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_email_success;
    }

    @Override
    public View onCreateView(
            final LayoutInflater inflater, final ViewGroup container,
            final Bundle savedInstanceState
    ) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public void onViewCreated(
            @NonNull View view, @Nullable Bundle savedInstanceState
    ) {
        super.onViewCreated(view, savedInstanceState);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public boolean onBackPressed() {
        return false;
    }
}
