package com.example.code05;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Boolean bPwdSwitch = false;
    private EditText etPwd;
    private EditText etAccount;
    private CheckBox cbRememberPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etPwd = findViewById(R.id.et_pwd);
        etAccount = findViewById(R.id.et_account);
        cbRememberPwd = findViewById(R.id.cb_remember_pwd);
        Button btLogin = findViewById(R.id.bt_login);
        final ImageView ivPwdSwitch = findViewById(R.id.iv_pwd_switch);

        String spFileName = getResources()
                .getString(R.string.shared_preferences_file_name);
        String accountKey = getResources()
                .getString(R.string.login_account_name);
        String passwordKey =  getResources()
                .getString(R.string.login_password);
        String rememberPasswordKey = getResources()
                .getString(R.string.login_remember_password);

        SharedPreferences spFile = getSharedPreferences(
                spFileName,
                MODE_PRIVATE);
        String account = spFile.getString(accountKey, null);
        String password = spFile.getString(passwordKey, null);
        Boolean rememberPassword = spFile.getBoolean(
                rememberPasswordKey,
                false);

        if (account != null && !TextUtils.isEmpty(account)) {
            etAccount.setText(account);
        }

        if (password != null && !TextUtils.isEmpty(password)) {
            etPwd.setText(password);
        }

        cbRememberPwd.setChecked(rememberPassword);

        //修改密码的显示与隐藏
        ivPwdSwitch.setOnClickListener(view -> {

            if (!bPwdSwitch) {
                ivPwdSwitch.setImageResource(
                        R.drawable.ic_baseline_visibility_24);
                etPwd.setInputType(
                        InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            } else {
                ivPwdSwitch.setImageResource(
                        R.drawable.ic_baseline_visibility_off_24);
                etPwd.setInputType(
                        InputType.TYPE_TEXT_VARIATION_PASSWORD | InputType.TYPE_CLASS_TEXT);
                etPwd.setTypeface(Typeface.DEFAULT);
            }
            bPwdSwitch = !bPwdSwitch;
        });
        btLogin.setOnClickListener(view -> {
            onClick();
        });

    }
    public void onClick() {
        String spFileName = getResources()
                .getString(R.string.shared_preferences_file_name);
        String accountKey = getResources()
                .getString(R.string.login_account_name);
        String passwordKey =  getResources()
                .getString(R.string.login_password);
        String rememberPasswordKey = getResources()
                .getString(R.string.login_remember_password);

        SharedPreferences spFile = getSharedPreferences(
                spFileName,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = spFile.edit();

        if (cbRememberPwd.isChecked()) {
            String password = etPwd.getText().toString();
            String account = etAccount.getText().toString();

            editor.putString(accountKey, account);
            editor.putString(passwordKey, password);
            editor.putBoolean(rememberPasswordKey, true);
        } else {
            editor.remove(accountKey);
            editor.remove(passwordKey);
            editor.remove(rememberPasswordKey);
        }
        editor.apply();
    }
}