package jp.techacademy.naoto.fukuda.calcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText mEditText1;
    EditText mEditText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);

        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);

        mEditText1 = (EditText) findViewById(R.id.editText1);
        mEditText2 = (EditText) findViewById(R.id.editText2);
    }

    @Override
    public void onClick(View v){

        String getText1 = mEditText1.getText().toString();
        String getText2 = mEditText2.getText().toString();
        Double getDouble1 = Double.parseDouble(getText1);
        Double getDouble2 = Double.parseDouble(getText2);

        if (v.getId() == R.id.button1) {
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra("Add_Result",getDouble1 + getDouble2);
            startActivity(intent);

        }else if(v.getId() == R.id.button2) {
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra("Minus_Result",getDouble1 - getDouble2);
            startActivity(intent);

        }else if(v.getId() == R.id.button3) {
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra("Multiple_Result",getDouble1 * getDouble2);
            startActivity(intent);

        }else if(v.getId() == R.id.button4) {
            if(getDouble2 == 0){
                Toast toast = Toast.makeText(this, "Can't divide by 0", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER_VERTICAL,0,0);
                toast.show();
            }else if(getDouble2<0 || getDouble2>0) {
                Intent intent = new Intent(this, SecondActivity.class);
                intent.putExtra("Divide_Result", getDouble1 / getDouble2);
                startActivity(intent);
            }
        }
    }
}

