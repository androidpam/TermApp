package com.handsomeclub.krzysztofwycislo.termapp.mvp.login;

import android.app.Activity;

import com.handsomeclub.krzysztofwycislo.termapp.mvp.base.IBasePresenter;
import com.handsomeclub.krzysztofwycislo.termapp.mvp.base.IBaseView;


/**
 * Created by Ashish on 27-09-2017.
 *
 */

public interface ILoginContract {

    public interface IView extends IBaseView {
        void onLoginSuccess(String message);
        void onLoginFailure(String message);
    }

    public interface IPresenter extends IBasePresenter {
        void login(Activity activity, String email, String password);
    }

    public interface IIntractor {
        void performFirebaseLogin(Activity activity, String email, String password);
    }

    public interface OnLoginListener {
        void onSuccess(String message);
        void onFailure(String message);
    }
}
