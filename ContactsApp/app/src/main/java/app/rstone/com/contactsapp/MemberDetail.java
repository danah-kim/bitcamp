package app.rstone.com.contactsapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MemberDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.member_detail);
        Context ctx = MemberDetail.this;
        findViewById(R.id.updateBtn).setOnClickListener((View v)->{
            startActivity(new Intent(ctx, MemberUpdate.class));
        });
        findViewById(R.id.listBtn).setOnClickListener((View v)->{
            startActivity(new Intent(ctx, MemberList.class));
        });
    }
}
