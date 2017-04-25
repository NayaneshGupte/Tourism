//class to get login details and to verify them

package com.example.jitendra.tourism.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jitendra.tourism.R;

public class Activity2Login extends AppCompatActivity {

    private EditText etUsername;
    private EditText etPassword;
    private Button buttonLogin;

    //Strings for comparision with user input in username and password field
    String Uname = "user123@example.com";
    String Pass = "User@1234";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitylogin);

        //attaching variables to xml file
        etUsername = (EditText) findViewById(R.id.et_Username);
        etPassword = (EditText) findViewById(R.id.et_Password);
        buttonLogin = (Button) findViewById(R.id.b_Login);

        //checking weather username and password are correct or not
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //if correct then grant permission
                if (Uname.equals(etUsername.getText().toString()) && Pass.equals(etPassword.getText().toString())) {

                    Toast.makeText(Activity2Login.this, "Login Successful....", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(Activity2Login.this, Activity3GridView.class);
                    startActivity(intent);
                }

                //if not then assign fields with NULL and show error Toast
                else {

                    Toast.makeText(Activity2Login.this, "Either username or password is incorrect", Toast.LENGTH_SHORT).show();
                    etUsername.setText(null);
                    etPassword.setText(null);
                }
            }
        });
    }
}
