package com.example.hietadminapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    private EditText userEmail, userPass;
    private RelativeLayout loginBtn;
    private String email, pass;
    private TextView tvShow;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        userEmail = (EditText) findViewById(R.id.userEmail);
        userPass = (EditText) findViewById(R.id.userPass);
        loginBtn = (RelativeLayout) findViewById(R.id.loginBtn);
        tvShow = (TextView) findViewById(R.id.tvShow);
        sharedPreferences  = this.getSharedPreferences("login", MODE_PRIVATE);
        editor = sharedPreferences.edit();


        if(sharedPreferences.getString("isLogin","false").equals("false")){
            openDash();
        }

        tvShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(userPass.getInputType() == 144){
                    userPass.setInputType(129);
                    tvShow.setText("Hide");
                }else{
                    userPass.setInputType(144);
                    tvShow.setText("Show");
                }
                userPass.setSelection(userPass.getText().length());
            }
        });
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateData();
            }
        });
    }

    private void validateData() {
        email = userEmail.getText().toString();
        pass = userPass.getText().toString();
        if(email.isEmpty()){
            userEmail.setError("Required");
            userEmail.requestFocus();
        }else if(pass.isEmpty()){
            userPass.setError("Required");
            userPass.requestFocus();
        }else if(email.equals("admin@hiet.com") && pass.equals("AdminOfHIET")){

            openDash();
        }else{
            Toast.makeText(this, "Please Check username and password again!", Toast.LENGTH_SHORT).show();
        }
    }

    private void openDash() {
        editor.putString("isLogin","yes");
        editor.commit();

        startActivity(new Intent(Login.this,MainActivity.class));
        finish();

    }
}