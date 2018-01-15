package com.handsomeclub.krzysztofwycislo.termapp.mvp.login;

import android.app.Activity;


/**
 * Created by Ashish on 27-09-2017.
 *
 */

public class LoginPresenter implements ILoginContract.IPresenter, ILoginContract.OnLoginListener {
    private ILoginContract.IView mILoginView;
    private ILoginContract.IIntractor mILoginInteractor;

    public LoginPresenter(ILoginContract.IView mILoginView){
        this.mILoginView = mILoginView;
        mILoginInteractor = new LoginInteractor(this);
    }
    @Override
    public void login(Activity activity, String email, String password) {
        mILoginInteractor.performFirebaseLogin(activity, email, password);

    }

    @Override
    public void onSuccess(String message) {
        mILoginView.onLoginSuccess(message);

    }

    @Override
    public void onFailure(String message) {
        mILoginView.onLoginFailure(message);

    }

}
