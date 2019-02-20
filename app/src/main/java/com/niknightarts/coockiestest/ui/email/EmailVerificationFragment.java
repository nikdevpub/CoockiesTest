package com.niknightarts.coockiestest.ui.email;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.niknightarts.coockiestest.App;
import com.niknightarts.coockiestest.BaseFragment;
import com.niknightarts.coockiestest.R;
import com.niknightarts.coockiestest.presentation.email.EmailVerificationPresenter;
import com.niknightarts.coockiestest.presentation.email.EmailVerificationView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public final class EmailVerificationFragment extends BaseFragment implements EmailVerificationView {
    @Inject
    @InjectPresenter
    EmailVerificationPresenter presenter;
    Unbinder unbinder;
    @BindView(R.id.email_verification_done)
    Button btnDone;

    public static EmailVerificationFragment newInstance() {
        EmailVerificationFragment fragment = new EmailVerificationFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @ProvidePresenter
    EmailVerificationPresenter providePresenter() {
        return presenter;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        App.appComponent().inject(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_email_verification;
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

    @OnClick(R.id.email_verification_done)
    public void onViewClicked() {
        presenter.openEmailSuccessScreen();
    }
}
