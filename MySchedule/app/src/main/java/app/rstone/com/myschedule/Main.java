package app.rstone.com.myschedule;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Context ctx = Main.this;
        class Mydate{ String year, month, day; }
        TextView today = findViewById(R.id.today);
        CalendarView calender = findViewById(R.id.calender);
        TimePicker time = findViewById(R.id.time);
        final TextView year = findViewById(R.id.year);
        final TextView month = findViewById(R.id.month);
        final TextView day = findViewById(R.id.day);
        final TextView hour = findViewById(R.id.hour);
        final TextView minute = findViewById(R.id.minute);
        calender.setVisibility(View.VISIBLE);
        time.setVisibility(View.INVISIBLE);
        today.setText(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.KOREA).format(new Date()));
        time.setHour(Integer.parseInt(new SimpleDateFormat("HH").format(new Date())));
        time.setMinute(Integer.parseInt(new SimpleDateFormat("mm").format(new Date())));
        final Mydate m =new Mydate();

        findViewById(R.id.rdoCalendar).setOnClickListener((View v)->{
            calender.setVisibility(View.VISIBLE);
            time.setVisibility(View.INVISIBLE);
        });
        findViewById(R.id.rdoTime).setOnClickListener((View v)->{
            calender.setVisibility(View.INVISIBLE);
            time.setVisibility(View.VISIBLE);
        });
        calender.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                m.year = year + "";
                m.month = month+1 + "";
                m.day = dayOfMonth + "";
            }
        });

        findViewById(R.id.btnEnd).setOnClickListener((View v)->{
            year.setText(m.year);
            month.setText(m.month);
            day.setText(m.day);
            hour.setText(time.getHour()+"");
            minute.setText(time.getMinute()+"");
            String result = year.getText().toString() + "-"
                    + month.getText().toString() + "-"
                    + day.getText().toString() + "-"
                    + hour.getText().toString() + ":"
                    + minute.getText().toString();

            Toast.makeText(ctx,"선택결과:"+result,Toast.LENGTH_LONG).show();
        });

    }

}
