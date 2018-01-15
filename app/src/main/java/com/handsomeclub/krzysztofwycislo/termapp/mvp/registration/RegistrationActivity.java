package com.handsomeclub.krzysztofwycislo.termapp.mvp.registration;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseUser;
import com.handsomeclub.krzysztofwycislo.termapp.R;
import com.handsomeclub.krzysztofwycislo.termapp.mvp.base.BaseActivity;
import com.handsomeclub.krzysztofwycislo.termapp.mvp.login.LoginActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by KrzysztofWycislo on 1/15/2018.
 *
 */

public class RegistrationActivity extends BaseActivity implements View.OnClickListener, IRegistrationContract.IView {

    @BindView(R.id.btn_register) Button btnRegistration;

    @BindView(R.id.tv_login) TextView tvLogin;

    @BindView(R.id.email_register) EditText edtEmail;

    @BindView(R.id.password_register) EditText edtPassword;

    private RegistrationPresenter registerPresenter;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        initViews();

    }
    private void initViews() {
        ButterKnife.bind(this);
        // btnRegistration = (Button)findViewById(R.id.btn_register);
        btnRegistration.setOnClickListener(this);
        // tvLogin = (TextView)findViewById(R.id.tv_login);
        tvLogin.setOnClickListener(this);
        // edtEmail = (EditText)findViewById(R.id.email_register);
        // edtPassword = (EditText)findViewById(R.id.password_register);

        registerPresenter = new RegistrationPresenter(this);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait, Adding profile to database.");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_register:
                checkRegistrationDetails();
                break;
            case R.id.tv_login:
                moveToLoginActivity();
                break;
        }
    }

    private void moveToLoginActivity() {
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
    }

    private void checkRegistrationDetails() {
        if(!TextUtils.isEmpty(edtEmail.getText().toString()) && !TextUtils.isEmpty(edtPassword.getText().toString())){
            initLogin(edtEmail.getText().toString(), edtPassword.getText().toString());
        }else{
            if(TextUtils.isEmpty(edtEmail.getText().toString())){
                edtEmail.setError("Please enter a valid email");
            }if(TextUtils.isEmpty(edtPassword.getText().toString())){
                edtPassword.setError("Please enter password");
            }
        }
    }

    private void initLogin(String email, String password) {
        progressDialog.show();
        registerPresenter.register(this, email, password);
    }

    @Override
    public void onRegistrationSuccess(FirebaseUser firebaseUser) {
        progressDialog.dismiss();
        Toast.makeText(getApplicationContext(), "Successfully Registered" , Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRegistrationFailure(String message) {
        progressDialog.dismiss();
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}
