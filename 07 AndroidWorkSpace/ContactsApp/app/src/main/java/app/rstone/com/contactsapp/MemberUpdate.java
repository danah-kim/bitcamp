package app.rstone.com.contactsapp;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import app.rstone.com.contactsapp.Main.*;
import static app.rstone.com.contactsapp.Main.*;

public class MemberUpdate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.member_update);
        Context ctx = MemberUpdate.this;
        //String[] specs = this.getIntent().getExtras().getString("spec").split(",");
        ImageView profile = findViewById(R.id.profile);
        profile.setImageDrawable(getResources()
                                    .getDrawable(getResources()
                                    .getIdentifier(getPackageName()+":drawable/"+getIntent().getExtras().getString("photo"), null, null),
                        ctx.getTheme()));
        EditText name = findViewById(R.id.textName);
        name.setText(getIntent().getExtras().getString("name"));
        /*name.setText(specs[1]);*/
        EditText email = findViewById(R.id.changeEmail);
        email.setText(getIntent().getExtras().getString("email"));
        EditText phone = findViewById(R.id.changePhone);
        phone.setText(getIntent().getExtras().getString("phone"));
        EditText addr = findViewById(R.id.changeAddress);
        addr.setText(getIntent().getExtras().getString("addr"));

        findViewById(R.id.imageBtn).setOnClickListener((View v)->{

        });
        findViewById(R.id.confirmBtn).setOnClickListener((View v)->{
            ItemUpdate query = new ItemUpdate(ctx);
            query.member.seq = Integer.parseInt(getIntent().getExtras().getString("seq"));
            query.member.name = (name.getText().toString().equals(null))?
                                    getIntent().getExtras().getString("name")
                                    : name.getText().toString();
            query.member.email = (email.getText().toString().equals(null)) ?
                                    getIntent().getExtras().getString("email")
                                    : email.getText().toString();
            query.member.phone = (phone.getText().toString().equals(null))?
                                    getIntent().getExtras().getString("phone")
                                    : phone.getText().toString();
            query.member.addr = (addr.getText().toString().equals(null)) ?
                                    getIntent().getExtras().getString("addr")
                                    : addr.getText().toString();
            new UpdateService(){
                @Override
                public void perform() { query.execute(); }
            }.perform();
            Intent intent = new Intent(ctx, MemberDetail.class);
            intent.putExtra("seq",query.member.seq+"");
            startActivity(intent);
        });
        findViewById(R.id.cancelBtn).setOnClickListener((View v)->{
            Intent intent = new Intent(ctx, MemberDetail.class);
            intent.putExtra("seq", getIntent().getExtras().getString("seq"));
            startActivity(intent);
        });
    }
    private class MemberUpdateQuery extends QueryFactory {
        SQLiteHelper helper;
        public MemberUpdateQuery(Context ctx) {
            super(ctx);
            helper = new SQLiteHelper(ctx);
        }

        @Override
        public SQLiteDatabase getDatabase() {
            return helper.getWritableDatabase();
        }
    }
    private class ItemUpdate extends MemberUpdateQuery {
        Member member;
        public ItemUpdate(Context ctx) {
            super(ctx);
            member = new Member();
        }
        public void execute(){
            getDatabase().execSQL(String.format(
                                    " UPDATE %s SET %s = '%s', "
                                    + " %s = '%s', "
                                    + " %s = '%s', "
                                    + " %s = '%s' "
                                    + " WHERE %s LIKE %s ",
                                    MTAB, MNAME, member.name,
                                    MEMAIL, member.email,
                                    MPHONE, member.phone,
                                    MADDR, member.addr,
                                    MSEQ, member.seq
            ));
        }
    }
}
