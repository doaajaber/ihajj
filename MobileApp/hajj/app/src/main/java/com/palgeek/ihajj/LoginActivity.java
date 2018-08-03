package com.palgeek.ihajj;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.palgeek.ihajj.model.user.User;

/**
 * Created by Tamer on 2.08.2018.
 */

public class LoginActivity extends AppCompatActivity {

    protected Button btnLogin;
    protected EditText txtUsername;
    protected EditText txtPassword;

    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        txtUsername = (EditText) findViewById(R.id.etUsername);
        txtPassword = (EditText) findViewById(R.id.etPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        //events
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String username = txtUsername.getText().toString().trim();
                String password = txtPassword.getText().toString().trim();

                if (username.isEmpty()) {

                    btnLogin.setEnabled(true);
                    Toast.makeText(LoginActivity.this, getResources().getString(R.string.valid_username_empty), Toast.LENGTH_SHORT).show();
                    return;
                }
                if (password.isEmpty()) {

                    btnLogin.setEnabled(true);
                    Toast.makeText(LoginActivity.this, getResources().getString(R.string.valid_password_empty), Toast.LENGTH_SHORT).show();
                    return;
                }
                doLogin(username, password);

            }
        });

    }

    private void doLogin(String username, String password) {

        //TODO: Connect to webservice and check user information
        User user = new User();
        user.Username = username;
        user.Name = "Doaa Jaber";
        user.Avatar = "";

        Toast.makeText(LoginActivity.this, String.format("%s %s ", getResources().getString(R.string.hello), username), Toast.LENGTH_LONG).show();

        Intent intent = new Intent(LoginActivity.this, MainActivity.class);

        startActivity(intent);
    }
}
