package com.example.ev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button mlogButton;
    EditText musername;
    EditText maddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mlogButton = (Button) findViewById(R.id.logbtn);
        musername = (EditText) findViewById(R.id.editText_username);
        maddress = (EditText) findViewById(R.id.editText_email);
    }

    @Override
    protected void onStart() {
        super.onStart();

        mlogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = musername.getText().toString();
                String email = maddress.getText().toString();


                Intent intent = new Intent(MainActivity.this, Main3Activity.class);
                intent.putExtra("com.example.ev.MESSAGE", name);
                startActivity(intent);


            }
        });
    }
}
