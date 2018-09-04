package app.rstone.com.myapp2;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Context ctx = MainActivity.this;
        class Calc{
            int res, num;
            String op ;
            public void exe(){
                switch (op){
                    case "+" :
                        res += num;
                        break;
                    case "-" :
                        res -= num;
                        break;
                    case "*" :
                        res *= num;
                        break;
                    case "/":
                        res /= num;
                        break;
                }
            }
            public int getNum(){return num;}
            public void setNum(int num){this.num=num;}
            public String getOp(){return op;}
            public void setOp(String op){this.op=op;}
            public int getRes(){return res;}
            public void setRes(int res){this.res=res;}
        }
        final Calc calc = new Calc();
        final EditText num = findViewById(R.id.num);

        findViewById(R.id.plusBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calc.setNum(Integer.parseInt(num.getText().toString()));
                calc.setOp("+");
                calc.exe();
                num.setText("");
                Toast.makeText(ctx,"결과 :"+calc.res,Toast.LENGTH_LONG).show();
            }
        });
        findViewById(R.id.minusBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calc.setNum(Integer.parseInt(num.getText().toString()));
                calc.setOp("-");
                calc.exe();
                num.setText("");
            }
        });
        findViewById(R.id.mutiBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calc.setNum(Integer.parseInt(num.getText().toString()));
                calc.setOp("*");
                calc.exe();
                num.setText("");
            }
        });
        findViewById(R.id.divBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calc.setNum(Integer.parseInt(num.getText().toString()));
                calc.setOp("/");
                calc.exe();
                num.setText("");
            }
        });
        findViewById(R.id.resultBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("= before num::",calc.num+"");
                calc.setNum(Integer.parseInt(num.getText().toString()));
                Log.d("op::",calc.op);
                calc.setOp(calc.getOp());
                calc.exe();
                num.setText("계산결과 : "+calc.res);
            }
        });
        findViewById(R.id.acBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num.setText("");
                calc.setRes(0);
            }
        });
    }

}
