package jp.techacademy.naoto.fukuda.calcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();

        Double value1 = intent.getDoubleExtra("Add_Result", 0);      //Button1
        Double value2 = intent.getDoubleExtra("Minus_Result", 0);    //Button2
        Double value3 = intent.getDoubleExtra("Multiple_Result", 0); //Button3
        Double value4 = intent.getDoubleExtra("Divide_Result", 0);   //Button4

        Log.d("Calc", value1 + "です");

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(String.valueOf(value1 + value2 + value3 + value4));
        /*計算結果の表示:
          TextView.setTextの行をValueごとに４つに分けると末尾行のValueしか
          表示できなくなってしまったため、上記のように和を用い、1行の式とした。
        　ボタンは1回に1つしか押せないため、表示結果に問題はない（常に1つのValueの値のみ表示される)
         */

    }
}
