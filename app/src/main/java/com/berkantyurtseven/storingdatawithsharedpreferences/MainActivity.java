package com.berkantyurtseven.storingdatawithsharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText ;
    TextView textView ;
    SharedPreferences sharedPreferneces;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText.findViewById(R.id.editTextText);
        textView.findViewById(R.id.textView2);

        sharedPreferneces =this.getSharedPreferences("com.berkantyurtseven.storingdatawithsharedpreferences" , Context.MODE_PRIVATE);
        int storingNum = sharedPreferneces.getInt("numberSaved",-1);
        textView.setText("Your Number : " + storingNum);

    }
    public void saveData (View view){
        if(!editText.getText().toString().matches("")){
            int userNumber =  Integer.parseInt(editText.getText().toString());
            textView.setText("Your Number : " + userNumber);

            sharedPreferneces.edit().putInt("numberSaved", userNumber).apply();

        }
    }
    public void Delete (View view){
        int storedData = sharedPreferneces.getInt("numberSaved" , 0);

        if (storedData != 0){
            sharedPreferneces.edit().remove("numberSaved").apply();
        }

    }
}