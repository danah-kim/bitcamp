package app.rstone.com.contactsapp;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import app.rstone.com.contactsapp.Main.*;

import static app.rstone.com.contactsapp.Main.*;

public class MemberAdd extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.member_add);
        Context ctx = MemberAdd.this;
        ItemInsert query = new ItemInsert(ctx);
        new InsertService() {
            @Override
            public void perform() {
                //query.member.seq = findViewById(R.id.);
                //query.member.name = findViewById(R.id.);
                //query.member.pw = findViewById(R.id.);
                //query.member.email = findViewById(R.id.);
                //query.member.phone = findViewById(R.id.);
                //query.member.addr = findViewById(R.id.);
                //query.member.photo = findViewById(R.id.);
            }
        }.perform();
    }
    private class MemberInsertQuery extends QueryFactory{
        SQLiteHelper helper;
        public MemberInsertQuery(Context ctx) {
            super(ctx);
            helper = new SQLiteHelper(ctx);
        }

        @Override
        public SQLiteDatabase getDatabase() {
            return helper.getWritableDatabase();
        }
    }
    private class ItemInsert extends MemberInsertQuery {
        Member member;

        public ItemInsert(Context ctx) {
            super(ctx);
            member = new Member();
        }
        public void execute(){
            getDatabase().execSQL(String.format(
                    " INSERT INTO %s (%s, %s, %s, %s, %s, %s) " +
                            " VALUES ('%s', '%s', '%s', '%s', '%s', '%s')",
                    MTAB, MNAME, MPW, MEMAIL, MPHONE, MADDR, MPHOTO,
                    member.name, member.pw, member.email, member.phone, member.addr, member.photo
            ));
        }
    }
}
