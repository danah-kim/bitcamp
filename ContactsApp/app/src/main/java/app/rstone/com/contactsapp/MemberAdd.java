package app.rstone.com.contactsapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MemberAdd extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.member_add);
        Context ctx = MemberAdd.this;
        findViewById(R.id.listBtn).setOnClickListener((View v)->{
            startActivity(new Intent(ctx, MemberList.class));
        });
    }
}
