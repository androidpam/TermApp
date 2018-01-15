package com.handsomeclub.krzysztofwycislo.termapp.mvp.login;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by Ashish on 27-09-2017.
 *
 */

public class LoginInteractor implements ILoginContract.IIntractor {
    private ILoginContract.OnLoginListener onLoginListener;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    public LoginInteractor(ILoginContract.OnLoginListener onLoginListener){
        this.onLoginListener = onLoginListener;
    }
    @Override
    public void performFirebaseLogin(Activity activity, String email, String password) {
        FirebaseAuth.getInstance()
                .signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            onLoginListener.onSuccess(task.getResult().toString());
                        }
                        else {
                            onLoginListener.onFailure(task.getException().toString());
                        }
                    }
                });
    }

    public void checkUserLogged(){
        FirebaseAuth.AuthStateListener mAuthListener;
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null){
                    onLoginListener.onSuccess("Jesteś zalogowany");
                }
            }
        };

    }
}
