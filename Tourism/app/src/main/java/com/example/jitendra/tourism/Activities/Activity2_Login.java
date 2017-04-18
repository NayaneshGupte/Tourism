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

public class Activity2_Login extends AppCompatActivity {

    private EditText Et_Username;
    private EditText Et_Password;
    private Button Button_Login;

    //Strings for comparision with user input in username and password field
    String Uname ="";/* "user123@example.com";*/
    String Pass = "";/*"User@1234";*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //attaching variables to xml file
        Et_Username = (EditText) findViewById(R.id.et_Username);
        Et_Password = (EditText) findViewById(R.id.et_Password);
        Button_Login = (Button) findViewById(R.id.b_Login);

        //checking weather username and password are correct or not
        Button_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //if correct then grant permission
                if (Uname.equals(Et_Username.getText().toString()) && Pass.equals(Et_Password.getText().toString())) {

                    Toast.makeText(Activity2_Login.this, "Login Successful....", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(Activity2_Login.this, Activity3_GridView.class);
                    startActivity(intent);
                }

                //if not then assign fields with NULL and show error Toast
                else {

                    Toast.makeText(Activity2_Login.this, "Either username or password is incorrect", Toast.LENGTH_SHORT).show();
                    Et_Username.setText(null);
                    Et_Password.setText(null);
                }
            }
        });
    }
}
