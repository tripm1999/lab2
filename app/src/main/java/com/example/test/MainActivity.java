package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button btnlogin;
    private EditText edtUsername;
    private EditText edtPassword;
    private EditText edtName;
    private String username = "", password = "", name = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnlogin = findViewById(R.id.btn_login);
        edtUsername = findViewById(R.id.edt_username);
        edtPassword = findViewById(R.id.edt_password);
        edtName = findViewById(R.id.edt_name);

        username = edtUsername.getText().toString();
        password = edtPassword.getText().toString();
        name = edtName.getText().toString();

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("test", "onClick: " + username);
                HttpPostTask httpPostTask = new HttpPostTask(username,password,name);
                httpPostTask.execute("http://dotplays.com/android/login.php");
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("edtname", name);
                startActivity(intent);


            }
        });
    }
}
