package app.rstone.com.contactsapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static app.rstone.com.contactsapp.Main.*;

public class MemberList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.member_list);
        Context ctx = MemberList.this;
        ItemList list = new ItemList(ctx);
        ListView memberList = findViewById(R.id.memberList);
        memberList.setAdapter(new MemberAdapter(ctx, (ArrayList<Member>) new ListService(){
            @Override
            public List<?> perform() {
                return list.execute();
            }
        }.perform()));
        memberList.setOnItemClickListener((AdapterView<?> p, View v, int i, long l)->{
            Intent intent = new Intent(ctx, MemberDetail.class);
            Member m = (Member) memberList.getItemAtPosition(i);
            intent.putExtra("seq",m.seq+"");
            startActivity(intent);
        });
        memberList.setOnItemLongClickListener((AdapterView<?> p, View v, int i, long l)->{
            new AlertDialog.Builder(ctx)
                    .setTitle("DELETE")
                    .setMessage("정말로 삭제할까요?")
                    .setPositiveButton(android.R.string.yes,
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ItemDelete delete = new ItemDelete(ctx);
                                    delete.member.seq = ((Member) memberList.getItemAtPosition(i)).seq;
                                    new DeleteService(){
                                        @Override
                                        public void perform() { delete.execute(); }
                                    }.perform();
                                    Toast.makeText(ctx, "삭제완료",Toast.LENGTH_LONG).show();
                                    startActivity(new Intent(ctx, MemberList.class));
                                }
                            })
                    .setNegativeButton(android.R.string.no,
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(ctx, "삭제취소",Toast.LENGTH_LONG).show();
                                }
                            }).show();
            return true;
        });
        /*for(Member m :list){
            Log.d("회원이름", m.name);
        }*/
    }
    private class MemberListQuery extends Main.QueryFactory {
        SQLiteOpenHelper helper;
        public MemberListQuery(Context ctx) {
            super(ctx);
            helper = new SQLiteHelper(ctx);
        }

        @Override
        public SQLiteDatabase getDatabase() {
            return helper.getReadableDatabase();
        }
    }
    private class ItemList extends MemberListQuery {
        public ItemList(Context ctx) {
            super(ctx);
        }
        public ArrayList<Member> execute() {
            ArrayList<Member> list = new ArrayList<>();
            Member member = null;
            Cursor cursor = getDatabase()
                    .rawQuery(String.format(
                            " SELECT * FROM %s ",
                            MTAB),null);
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
                    list.add(member);
                    /*Log.d("등록된회원수", list.size()+"");*/
                }
            }else {
                Log.d("등록된회원이","없습니다.");
            }
            Log.d("멤버 수",String.valueOf(list.size()));
            return list;
        }
    }
    private class MemberAdapter extends BaseAdapter{
        ArrayList<Member> list;
        LayoutInflater inflater;

        public MemberAdapter(Context context, ArrayList<Member> list) {
            this.list = list;
            this.inflater = LayoutInflater.from(context);
        }
        private int[] photos = {
                R.drawable.profile_1,
                R.drawable.profile_2,
                R.drawable.profile_3,
                R.drawable.profile_4,
                R.drawable.profile_5
        };

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int i) {
            return list.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View v, ViewGroup g) {
            ViewHolder holder;
            if(v==null){
                v = inflater.inflate(R.layout.member_item, null);
                holder = new ViewHolder();
                holder.profile = v.findViewById(R.id.profile);
                holder.name = v.findViewById(R.id.name);
                holder.phone = v.findViewById(R.id.phone);
                v.setTag(holder);
            }else{
                holder = (ViewHolder)v.getTag();
            }
            holder.profile.setImageResource(photos[i]);
            holder.name.setText(list.get(i).name);
            holder.phone.setText(list.get(i).phone);
            return v;
        }
    }
    static class ViewHolder{
        ImageView profile;
        TextView name, phone;
    }
    private class MemberDeleteQuery extends QueryFactory{
        SQLiteHelper helper;
        public MemberDeleteQuery(Context ctx) {
            super(ctx);
            helper = new SQLiteHelper(ctx);
        }

        @Override
        public SQLiteDatabase getDatabase() {
            return helper.getWritableDatabase();
        }
    }
    private class ItemDelete extends MemberDeleteQuery{
        Member member;
        public ItemDelete(Context ctx) {
            super(ctx);
            member = new Member();
        }
        public void execute(){
            getDatabase().execSQL(String .format(
                                    " DELETE FROM %s "
                                    +" WHERE %s LIKE '%s' ",
                                    MTAB, MSEQ, member.seq));
        }
    }
}
