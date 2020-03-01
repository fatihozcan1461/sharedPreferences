package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView textView;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        editText = findViewById( R.id.editText );
        textView = findViewById( R.id.textView );

        SharedPreferences sharedPreferences = this.getSharedPreferences( "com.example.metods", Context.MODE_PRIVATE );
        int storedAge = sharedPreferences.getInt( "storedAge",0 );
        if (storedAge == 0)
        {
            textView.setText( "Yaşınız :" );
        }
        else
        {
            textView.setText( "Yaşınız :"+storedAge );
        }
    }

    public void save(View view)
    {
        if(!editText.getText().toString().matches( "" ))
        {
            int userAge = Integer.parseInt( editText.getText().toString() );
            textView.setText( " Yaşın :"+ userAge );

            sharedPreferences.edit().putInt("storedAge",userAge).apply();
        }
    }

    public void delete(View view)
    {
        int storedData = sharedPreferences.getInt("storedAge",0);

        if (storedData != 0) {
            sharedPreferences.edit().remove("storedAge").apply();
            textView.setText("Your age: ");
        }

    }
}
