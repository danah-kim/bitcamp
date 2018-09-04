package app.rstone.com.myschedule;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        final Context ctx = Main.this;
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
        calender.setMinDate(Long.parseLong(new SimpleDateFormat("yyyyMMdd", Locale.KOREA).format(new Date())));
        time.setHour(Integer.parseInt(new SimpleDateFormat("HH").format(new Date())));
        time.setMinute(Integer.parseInt(new SimpleDateFormat("mm").format(new Date())));

        findViewById(R.id.rdoCalendar).setOnClickListener((View v)->{
            calender.setVisibility(View.VISIBLE);
            time.setVisibility(View.INVISIBLE);
        });
        findViewById(R.id.rdoTime).setOnClickListener((View v)->{
            calender.setVisibility(View.INVISIBLE);
            time.setVisibility(View.VISIBLE);
        });
        findViewById(R.id.btnEnd).setOnClickListener((View v)->{
            Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(calender.getDate());
            year.setText(cal.get(Calendar.YEAR)+"");
            month.setText(cal.get(Calendar.MONTH)+"");
            day.setText(cal.get(Calendar.DATE)+"");
            hour.setText(time.getHour()+"");
            minute.setText(time.getMinute()+"");

            //Toast.makeText(ctx,"선택결과:"+result,Toast.LENGTH_LONG).show();
        });

    }

}
