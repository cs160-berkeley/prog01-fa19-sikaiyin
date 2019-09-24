package com.example.ev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Main3Activity extends AppCompatActivity {
    Button mButton;
    Button conButton;
    TextView mText;
    TextView mkmeter;
    TextView mTime;
    EditText batlevel;
    EditText midis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Intent intent2 = getIntent();
        String name2 = intent2.getStringExtra("com.example.ev.MESSAGE");
        String email2 = intent2.getStringExtra("com.example.ev.Email");

        mButton = (Button) findViewById(R.id.button);
        conButton = (Button) findViewById(R.id.button6);
        mText = (TextView) findViewById(R.id.textView_name3);
        mkmeter = (TextView) findViewById(R.id.textView_convert);
        mTime = (TextView) findViewById(R.id.textView_time);
        batlevel = (EditText) findViewById(R.id.editText4);
        midis = (EditText) findViewById(R.id.editText3);
        mText.setText(name2);

        Spinner spinner = (Spinner) findViewById(R.id.brands_spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.brands_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);

    }

    @Override
    protected void onStart() {
        super.onStart();
        conButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inter = midis.getText().toString();
                String per = batlevel.getText().toString();
                Integer percent = Integer.parseInt(per);
                Double value = Double.parseDouble(inter);
                mkmeter.setText("The distance you enter in mile is equal to ".concat(String.valueOf((int)(value * 1.60934))).concat("km."));
                if (value > 200){
                    mTime.setText("Error! The maximal distance range is 200 miles.");
                }
                else if((int)((value * 0.5 - percent) * 3) < 0){
                    mTime.setText("You can cover that range with current battery level without charging.");}
                else{
                    mTime.setText("This will take ".concat(String.valueOf((int)((value * 0.5 - percent) * 6))).concat(" estimated minutes to charge."));
                }

            }
        });

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name2 = mText.getText().toString();

                Intent intent2 = new Intent(Main3Activity.this, Main2Activity.class);
                intent2.putExtra("com.example.ev.Name", name2);
                startActivity(intent2);
            }
        });


    }



}
