package com.example.androidexam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.res.Resources;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button registerBtn;
    private ConstraintLayout constraintLay;
    private EditText name, email, password;
    private CheckBox license;
    private RadioGroup gender;
    private Spinner country;

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

         license = findViewById(R.id.checkBox);
         gender = findViewById(R.id.genderToggle);
         country = findViewById(R.id.country);

        ArrayList<String> countries = new ArrayList<>();
        countries.add(getString(R.string.US));
        countries.add(getString(R.string.Ger));
        countries.add(getString(R.string.etc));

        ArrayAdapter<String> countriesAdpater = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                countries
        );

        country.setAdapter(countriesAdpater);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button2:
                //checks if there's a entry missing
                //TextUtils is a set of utility functions on String objects
                if(!TextUtils.isEmpty(name.getText())
                    && !TextUtils.isEmpty(email.getText())
                    && !TextUtils.isEmpty(password.getText())
                    && license.isChecked() && radioCheck()
                    && spinnerCheck()){

                    showSnackbar();
                    break;
                }
                else
                    showEmpty();
                    break;

        }
    }

    public void showSnackbar(){
        Snackbar.make(constraintLay,getString(R.string.Registration), Snackbar.LENGTH_SHORT).show();
    }
    public void showEmpty(){
        Snackbar.make(constraintLay, getString(R.string.Empty), Snackbar.LENGTH_SHORT).show();
    }

    public boolean radioCheck(){
        if(gender.getCheckedRadioButtonId() ==-1){
            return false;
        }
        else
            return true;
    }

    public boolean spinnerCheck(){
        if(country.getSelectedItem() != null){
            return true;
        }
        else return false;
    }
}