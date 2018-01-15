package com.handsomeclub.krzysztofwycislo.termapp.mvp.login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.handsomeclub.krzysztofwycislo.termapp.R;
import com.handsomeclub.krzysztofwycislo.termapp.data.Communicate;
import com.handsomeclub.krzysztofwycislo.termapp.mvp.base.BaseActivity;
import com.handsomeclub.krzysztofwycislo.termapp.mvp.base.IBasePresenter;
import com.handsomeclub.krzysztofwycislo.termapp.mvp.registration.RegistrationActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ashish on 27-09-2017.
 *
 */

public class LoginActivity extends BaseActivity implements View.OnClickListener, ILoginContract.IView {

    @BindView(R.id.button_login) Button btnLogin;

    @BindView(R.id.tv_register) TextView tvRegister;

    @BindView(R.id.email_login) EditText edtEmail;

    @BindView(R.id.password_login) EditText edtPassword;

    private ILoginContract.IPresenter presenter;

    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();


    }
    private void initViews() {
        Toast.makeText(getApplicationContext(), "Internet Required" , Toast.LENGTH_SHORT).show();
        ButterKnife.bind(this);

        btnLogin.setOnClickListener(this);
        tvRegister.setOnClickListener(this);
        presenter = new LoginPresenter(this);
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setMessage("Please wait, Logging in..");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_login:
                checkLoginDetails();
                break;
            case R.id.tv_register:
                moveToRegisterActivity();
                break;
        }
    }

    private void moveToRegisterActivity() {
        Intent intent = new Intent(getApplicationContext(), RegistrationActivity.class);
        startActivity(intent);
    }

    private void checkLoginDetails() {
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
        mProgressDialog.show();
        presenter.login(this, email, password);
    }

    @Override
    public void onLoginSuccess(String message) {
        mProgressDialog.dismiss();
        Toast.makeText(getApplicationContext(), "Successfully Logged in" , Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginFailure(String message) {
        mProgressDialog.dismiss();
        Toast.makeText(getApplicationContext(),message , Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPresenter(IBasePresenter presenter) {
        this.presenter = (ILoginContract.IPresenter) presenter;
    }

    @Override
    public void showCommunicate(Communicate communicate) {

    }
}
