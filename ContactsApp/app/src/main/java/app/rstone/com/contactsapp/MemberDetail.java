package app.rstone.com.contactsapp;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import static app.rstone.com.contactsapp.Main.*;

public class MemberDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.member_detail);
        Context ctx = MemberDetail.this;
        Intent intent = this.getIntent();
        String seq = intent.getExtras().getString("seq");
        Log.d("넘어온 seq 값",seq);
        ItemRetrieve query = new ItemRetrieve(ctx);
        query.seq = intent.getExtras().getString("seq");
        Member member = (Member) new RetrieveService(){
            @Override
            public Object perform() {
                return query.execute();
            }
        }.perform();
        Log.d("검색된 이름", member.name);
        ImageView profile = findViewById(R.id.profile);
        profile.setImageDrawable(getResources()
                                    .getDrawable(getResources()
                                    .getIdentifier(this.getPackageName()+":drawable/"+member.photo, null, null),
                                            ctx.getTheme()));
        TextView name = findViewById(R.id.name);
        name.setText(member.name);
        TextView phone = findViewById(R.id.phone);
        phone.setText(member.phone);
        TextView email = findViewById(R.id.email);
        email.setText(member.email);
        TextView addr = findViewById(R.id.addr);
        addr.setText(member.addr);

    }
    private class MemberRetrieveQuery extends Main.QueryFactory {
        SQLiteOpenHelper helper;
        public MemberRetrieveQuery(Context ctx) {
            super(ctx);
            helper = new SQLiteHelper(ctx);
        }

        @Override
        public SQLiteDatabase getDatabase() {
            return helper.getReadableDatabase();
        }
    }
    private class ItemRetrieve extends MemberRetrieveQuery {
        String seq;
        public ItemRetrieve(Context ctx) {
            super(ctx);
        }
        public Member execute(){
            Member member = null;
            Cursor cursor = this.getDatabase()
                    .rawQuery(String.format(
                                " SELECT * FROM %s " +
                                " WHERE %s LIKE '%s' ",
                                MTAB, MSEQ, seq
                    ),null);
            if(cursor != null){
                while (cursor.moveToNext()){
                    member = new Member();
                    member.seq = Integer.parseInt(cursor.getString(cursor.getColumnIndex(MSEQ)));
                    member.name = cursor.getString(cursor.getColumnIndex(MNAME));
                    member.pw = cursor.getString(cursor.getColumnIndex(MPW));
                    member.email = cursor.getString(cursor.getColumnIndex(MEMAIL));
                    member.phone = cursor.getString(cursor.getColumnIndex(MPHONE));
                    member.addr = cursor.getString(cursor.getColumnIndex(MADDR));
                    member.photo = cursor.getString(cursor.getColumnIndex(MPHOTO));
                }
            }else {
                Log.d("상세내역이","존재하지 않습니다.");
            }
            return member;
        }
    }
}
