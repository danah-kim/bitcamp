package app.rstone.com.myappbmi;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Bmi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi);
        final Context ctx = Bmi.this;
        final EditText name = findViewById(R.id.name);
        final EditText height = findViewById(R.id.height);
        final EditText weight = findViewById(R.id.weight);
        final TextView result = findViewById(R.id.result);

        final class Calc{
            String name, result;
            double height, weight;
            public void execute(){
                double bmi = weight / ((height / 100) * (height / 100));
                if (bmi >= 35.0) {
                    result = "3단계 비만";
                } else if (bmi >= 30.0) {
                    result = "2단계 비만";
                } else if (bmi >= 25.0) {
                    result = "1단계 비만";
                } else if (bmi >= 23.0) {
                    result = "비만 전단계";
                } else if (bmi >= 18.5) {
                    result = "정상";
                } else if (bmi < 18.5) {
                    result = "저체중";
                }
            }

        }

        findViewById(R.id.resultBtn).setOnClickListener((View v)->{
            Calc bmi = new Calc();
            double h = Double.parseDouble(height.getText().toString());
            double w = Double.parseDouble(weight.getText().toString());
            bmi.name = name.getText().toString();
            bmi.height = h;
            bmi.weight= w;
            bmi.execute();
            result.setText(bmi.name+"님의 BMI 결과"+bmi.result);
        });
    }
}