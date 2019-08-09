package com.example.quizmain;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Quizdb extends SQLiteOpenHelper {
    public Quizdb(Context context) {
        super(context, "Quiz", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String reg = "create table registration(id integer primary key ,user text,password text)";
        String ss="create table jtable (id integer primary key autoincrement ,q text, op1 text,op2 text, op3 text, op4 text, ans text)";
        String ss1="create table cqtable (id integer primary key autoincrement ,q text, op1 text,op2 text, op3 text, op4 text, ans text)";
        String ss2="create table dqtable (id integer primary key autoincrement ,q text, op1 text,op2 text, op3 text, op4 text, ans text)";
                db.execSQL(ss);
        db.execSQL(reg);
       db.execSQL(ss1);
       db.execSQL(ss2);

        //db.execSQL(sdbms);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       //db.execSQL("DROP TABLE IF EXISTS ctable");
       //db.execSQL("DROP TABLE IF EXISTS dsatable");

    }

    public void ad_quiz1(String qs, String p1, String p2,String p3,String p4,String anss)
    {

        SQLiteDatabase d = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("q",qs);
        cv.put("op1",p1);
        cv.put("op2",p2);
        cv.put("op3",p3);
        cv.put("op4",p4);
        cv.put("ans",anss);
        d.insert("jtable",null,cv);
        d.close();

    }
    public void ad_cquiz(String q, String o1, String o2, String o3, String o4, String a) {

        SQLiteDatabase d = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("q",q);
        cv.put("op1",o1);
        cv.put("op2",o2);
        cv.put("op3",o3);
        cv.put("op4",o4);
        cv.put("ans",a);
        d.insert("cqtable",null,cv);
        d.close();

    }



    public Cursor set_quiz(int idd)
    {
        SQLiteDatabase d = this.getWritableDatabase();
        String qus = "select* from jtable where id="+idd+"";

        Cursor c = d.rawQuery(qus,null);
        return c;
    }

    public Cursor set_cquiz(int p) {
        SQLiteDatabase d = this.getWritableDatabase();
        String qus = "select* from cqtable where id="+p+"";

        Cursor c = d.rawQuery(qus,null);
        return c;
    }



    public  void add(int id, String name,String ps)
    {
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("id",id);
        cv.put("user",name);
        cv.put("password",ps);
        db.insert("registration",null,cv);
        db.close();
    }

    public Cursor login(int idd,String ps)
    {
        SQLiteDatabase d=this.getWritableDatabase();

        String lg="select* from registration where id = "+idd+" and password = '"+ps+"'";

        Cursor c=d.rawQuery(lg,null);

        return c;
    }


 public void ad_dsaquiz(String q, String o1, String o2, String o3, String o4, String a) {
        SQLiteDatabase d = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("q",q);
        cv.put("op1",o1);
        cv.put("op2",o2);
        cv.put("op3",o3);
        cv.put("op4",o4);
        cv.put("ans",a);
        d.insert("dqtable",null,cv);
        d.close();


    }

    public Cursor set_dsquiz(int d) {

        SQLiteDatabase de = this.getWritableDatabase();
        String qus = "select* from dqtable where id="+d+"";

        Cursor c = de.rawQuery(qus,null);
        return c;
    }
}
