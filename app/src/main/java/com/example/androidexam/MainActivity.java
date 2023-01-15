package com.example.androidexam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button registerBtn;
    private ConstraintLayout constraintLay;
    private EditText name, email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         registerBtn = findViewById(R.id.button2);
         //Forgot this part. Gotta add the object to onClick listener. Oops.
         registerBtn.setOnClickListener(this);

         constraintLay = findViewById(R.id.constraintLay);

         name = findViewById(R.id.edttxtName);
         email = findViewById(R.id.edtxtEmail);
         password = findViewById(R.id.edtxtPassword);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button2:
                if()
                showSnackbar();
            break;
        }
    }

    public void showSnackbar(){
        Snackbar.make(constraintLay, , Snackbar.LENGTH_SHORT).show();
    }
}