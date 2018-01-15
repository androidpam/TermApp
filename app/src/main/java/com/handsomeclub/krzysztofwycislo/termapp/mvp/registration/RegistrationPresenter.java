package com.handsomeclub.krzysztofwycislo.termapp.mvp.registration;

import android.app.Activity;

import com.google.firebase.auth.FirebaseUser;

/**
 * Created by Ashish on 27-09-2017.
 *
 */

public class RegistrationPresenter implements IRegistrationContract.IPresenter, IRegistrationContract.OnRegistrationListener {
    private IRegistrationContract.IView mRegisterView;
    private RegistrationInteractor mRegistrationInteractor;

    public RegistrationPresenter(IRegistrationContract.IView registerView){
        this.mRegisterView = registerView;
        mRegistrationInteractor = new RegistrationInteractor(this);
    }
    @Override
    public void register(Activity activity, String email, String password) {
        mRegistrationInteractor.performRegistration(activity, email, password);
    }

    @Override
    public void onSuccess(FirebaseUser firebaseUser) {
        mRegisterView.onRegistrationSuccess(firebaseUser);
    }

    @Override
    public void onFailure(String message) {
        mRegisterView.onRegistrationFailure(message);

    }
}
