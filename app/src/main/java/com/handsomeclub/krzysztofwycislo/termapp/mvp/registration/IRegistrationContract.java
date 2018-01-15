package com.handsomeclub.krzysztofwycislo.termapp.mvp.registration;

import android.app.Activity;

import com.google.firebase.auth.FirebaseUser;

/**
 * Created by Ashish on 27-09-2017.
 *
 */

public interface IRegistrationContract {
    interface IView {
        void onRegistrationSuccess(FirebaseUser firebaseUser);
        void onRegistrationFailure(String message);
    }

    interface IPresenter {
        void register(Activity activity, String email, String password);
    }

    interface IInteractor {
        void performRegistration(Activity activity, String email, String password);
    }

    interface OnRegistrationListener {
        void onSuccess(FirebaseUser firebaseUser);
        void onFailure(String message);
    }
}
