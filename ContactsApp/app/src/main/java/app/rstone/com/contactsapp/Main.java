package app.rstone.com.contactsapp;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.List;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Context ctx = Main.this;
        findViewById(R.id.createDBBtn).setOnClickListener((View v)->{
            SQLiteHelper helper = new SQLiteHelper(ctx);
        });
        findViewById(R.id.loginMenuBtn).setOnClickListener((View v)->{
            startActivity(new Intent(ctx, Login.class));
        });
    }
    static class Member{int seq; String name, pw, email, phone, addr, photo;}
    static interface CreateService{public void perform();}
    static interface ListService{public List<?> perform();}
    static interface RetrieveService{public Object perform();}
    static interface UpdateService{public void perform();}
    static interface DeleteService{public void perform();}
    static interface StatusService{public void perform();}
    static String DBNAME = "rstone.db";
    static String MTAB = "MEMBER";
    static String MSEQ = "SEQ";
    static String MNAME = "NAME";
    static String MPW = "PW";
    static String MEMAIL = "EMAIL";
    static String MPHONE = "PHONE";
    static String MADDR = "ADDR";
    static String MPHOTO = "PHOTO";
    static abstract class QueryFactory{
        Context ctx;
        public QueryFactory(Context ctx) {
            this.ctx = ctx;
        }
        public abstract SQLiteDatabase getDatabase();
    }
    static class SQLiteHelper extends SQLiteOpenHelper {
        public SQLiteHelper(Context context) {
            super(context, DBNAME, null, 1);
            this.getWritableDatabase();
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String sql = String.format(
                            " CREATE TABLE IF NOT EXISTS %s" +
                            " (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT)",
                            MTAB, MSEQ, MNAME, MPW, MEMAIL, MPHONE, MADDR, MPHOTO
            );
            Log.d("실행할 쿼리 :",sql);
            db.execSQL(sql);
            Log.d("=========","insert 쿼리실행전");
            for (int i=1; i<=5; i++){
                db.execSQL(String.format(
                            " INSERT INTO %s (%s, %s, %s, %s, %s, %s) " +
                            " VALUES ('%s', '%s', '%s', '%s', '%s', '%s')",
                            MTAB, MNAME, MPW, MEMAIL, MPHONE, MADDR, MPHOTO,
                            "홍길동"+i,"1","hong"+i+"@test.com","010-1234-567"+i,"신촌"+i+"길","hong"+i+".jpg"
                ));
            }
            Log.d("=========","insert 쿼리실행완료");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + MTAB);
            onCreate(db);
        }
    }

}
