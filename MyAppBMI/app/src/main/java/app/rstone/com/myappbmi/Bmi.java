package app.rstone.com.myappbmi;

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
        final EditText name = findViewById(R.id.name);
        final EditText height = findViewById(R.id.height);
        final EditText weight = findViewById(R.id.weight);
        final TextView result = findViewById(R.id.result);

        class Clac{
            String name, result;
            double height, weight;


            public void setName(String name) { this.name = name; }
            public void setHeight(Double height) { this.height = height; }
            public void setWeight(Double weight) { this.weight = weight; }
            public void setResult() {
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
            public String getName() { return name; }
            public double getHeight() { return height; }
            public double getWeight() { return weight; }
            public String getResult() { return result; }

        }

        final Clac bmi = new Clac();
        
        findViewById(R.id.resultBtn).setOnClickListener((View v)->{
            bmi.setName(name.getText().toString());
            bmi.setHeight(Double.parseDouble(height.getText().toString()));
            bmi.setWeight(Double.parseDouble(weight.getText().toString()));
            bmi.setResult();
            result.setText(result.getText()+bmi.getResult());
        });
    }
}