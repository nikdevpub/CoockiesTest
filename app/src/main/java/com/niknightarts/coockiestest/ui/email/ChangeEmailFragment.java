package com.niknightarts.coockiestest.ui.email;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.niknightarts.coockiestest.App;
import com.niknightarts.coockiestest.BaseFragment;
import com.niknightarts.coockiestest.R;
import com.niknightarts.coockiestest.presentation.email.ChangeEmailPresenter;
import com.niknightarts.coockiestest.presentation.email.ChangeEmailView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public final class ChangeEmailFragment extends BaseFragment implements ChangeEmailView {
    @Inject
    @InjectPresenter
    ChangeEmailPresenter presenter;
    Unbinder unbinder;
    @BindView(R.id.change_email_edit_email)
    EditText editEmail;
    @BindView(R.id.change_email_continue)
    Button btnContinue;
    @BindView(R.id.change_email_root)
    ConstraintLayout root;

    public static ChangeEmailFragment newInstance() {
        ChangeEmailFragment fragment = new ChangeEmailFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @ProvidePresenter
    ChangeEmailPresenter providePresenter() {
        return presenter;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        App.appComponent().inject(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_change_email;
    }

    @Override
    public View onCreateView(
            final LayoutInflater inflater, final ViewGroup container,
            final Bundle savedInstanceState
    ) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
        setupUI(root);
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

    @OnClick(R.id.change_email_continue)
    public void onViewClicked() {
        presenter.openVerificationScreen();
    }

    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager =
                (InputMethodManager) activity.getSystemService(
                        Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(
                activity.getCurrentFocus().getWindowToken(), 0);
    }

    public void setupUI(View view) {

        // Set up touch listener for non-text box views to hide keyboard.
        if (!(view instanceof EditText)) {
            view.setOnTouchListener((v, event) -> {
                hideSoftKeyboard(getActivity());
                return false;
            });
        }

        //If a layout container, iterate over children and seed recursion.
        if (view instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                View innerView = ((ViewGroup) view).getChildAt(i);
                setupUI(innerView);
            }
        }
    }
}
