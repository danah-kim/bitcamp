package app.rstone.com.contactsapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MemberList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.member_list);
        Context ctx = MemberList.this;
        findViewById(R.id.addBtn).setOnClickListener((View v)->{
            startActivity(new Intent(ctx, MemberAdd.class));
        });
        findViewById(R.id.detailBtn).setOnClickListener((View v)->{
            startActivity(new Intent(ctx, MemberDetail.class));
        });
    }
}
