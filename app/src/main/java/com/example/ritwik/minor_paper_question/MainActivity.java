package com.example.ritwik.minor_paper_question;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener{

    RadioButton rb1,rb2;
    RadioGroup grp;
    Button btn;
    Spinner s;
    String str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        s = findViewById(R.id.spin);
        grp = findViewById(R.id.grp);
        rb1 = findViewById(R.id.btn1);
        rb2 = findViewById(R.id.btn2);
        btn = findViewById(R.id.submit);
        s.setOnItemSelectedListener(this);
        btn.setOnClickListener(this);
        grp.setVisibility(View.INVISIBLE);
        //grp.setVisibility(false);
    }

    @Override
    public void onClick(View view) {
        String txt="";
        switch(grp.getCheckedRadioButtonId()) {
            case R.id.btn1:                                                     //###########
                txt = rb1.getText().toString();
                break;
            case R.id.btn2:                                                     //###########
                txt = rb2.getText().toString();
                break;
        }
        Toast.makeText(this,txt+"",Toast.LENGTH_LONG).show();       //############
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        str = adapterView.getItemAtPosition(i).toString();
        grp.setVisibility(View.VISIBLE);
        //grp.setVisibility(true);
        if(str.equals("stateA")) {
            rb1.setText("A1");
            rb2.setText("A2");
        } else if(str.equals("stateB")) {
            rb1.setText("B1");
            rb2.setText("B2");
        } else {
            rb1.setText("C1");
            rb2.setText("C2");
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
