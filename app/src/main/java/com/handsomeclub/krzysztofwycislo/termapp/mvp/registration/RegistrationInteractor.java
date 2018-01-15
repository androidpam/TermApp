package com.handsomeclub.krzysztofwycislo.termapp.mvp.registration;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by Ashish on 27-09-2017.
 *
 */

public class RegistrationInteractor implements IRegistrationContract.IInteractor {

    private IRegistrationContract.OnRegistrationListener mOnRegistrationListener;

    RegistrationInteractor(IRegistrationContract.OnRegistrationListener onRegistrationListener){
        this.mOnRegistrationListener = onRegistrationListener;
    }

    @Override
    public void performRegistration(Activity activity, String email, String password) {
        FirebaseAuth.getInstance()
                    .createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                mOnRegistrationListener.onFailure(task.getException().getMessage());
                            }else{
                                mOnRegistrationListener.onSuccess(task.getResult().getUser());
                            }
                        }
                    });
    }
}
