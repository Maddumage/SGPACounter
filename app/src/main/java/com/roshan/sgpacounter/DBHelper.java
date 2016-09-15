package com.roshan.sgpacounter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Roshan on 8/14/2016.
 */
public class DBHelper extends SQLiteOpenHelper {
     //Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    public static final String DATABASE_NAME = "SGPA";
    // Labels table name
    public static final String TABLE_STUDENT = "Student";
    public static final String TABLE_LOGIN = "Login";
    // Labels Table Columns names
    public static final String KEY_ID = "id";
    public static final String KEY_name = "name";
    public static final String KEY_email = "email";
    public static final String KEY_batch = "batch";
    public static final String KEY_index = "index";
    public static final String KEY_pass = "password";
    public  SQLiteDatabase db;
    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_STUDENT = "CREATE TABLE " + TABLE_STUDENT  + "("
                + KEY_ID  + " TEXT PRIMARY KEY,"
                + KEY_name + " TEXT, "
                + KEY_email + " TEXT, "
                + KEY_batch + " TEXT, "
                + KEY_index + " TEXT, "
                + KEY_pass + " TEXT" + ");";
        db.execSQL(CREATE_TABLE_STUDENT);

        String CREATE_TABLE_LOGIN = "CREATE TABLE "+TABLE_LOGIN+" ("
                + KEY_index +" TEXT PRIMARY KEY, "
                + KEY_pass + " TEXT NOT NULL, "
                + " CONSTRAINT fk FOREIGN KEY(index) REFERENCES Student(id));";
        db.execSQL(CREATE_TABLE_LOGIN);

        Log.d("db","create");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LOGIN);
        // Create tables again
        onCreate(db);
    }

    // Adding new student
    public void addStudent(Student student)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID, student.getStudent_ID());
        values.put(KEY_name,student.getName());
        values.put(KEY_email,student.getEmail());
        values.put(KEY_batch,student.getBatch());
        ///inserting row
        db.insert(TABLE_STUDENT,null,values);
        //db close
        db.close();
    }
    //add login details
    public void addLoginDetails(Student student)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_index, student.getUsername());
        values.put(KEY_index, student.getPassword());
        //inserting raw
        db.insert(TABLE_LOGIN, null, values);
        //db close
        db.close();
    }
    // Getting single student
    public Student getStudent(String id)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_STUDENT, new String[] { KEY_ID,
                        KEY_name, KEY_email,KEY_batch }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Student student = new Student((cursor.getString(0)),
                cursor.getString(1), cursor.getString(2),cursor.getString(3) );
        // return contact
        return student;
    }

    //get login details
    public Student getLoginDetails(String index)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_LOGIN, new String[] { KEY_index,
                        KEY_pass}, KEY_ID + "=?",
                new String[] { String.valueOf(index) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Student student = new Student((cursor.getString(0)),
                cursor.getString(1));
        // return contact
        return student;
    }

    // Getting All student
    public List<Student> getAllStudents()
    {
        List<Student> studentList = new ArrayList<Student>();
        //select query
        String select_query = "SELECT * FROM " + TABLE_STUDENT;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(select_query, null);
        if(cursor.moveToFirst())
        {
            do {
                Student student = new Student();
                student.setId(cursor.getString(0));
                student.setName(cursor.getString(1));
                student.setEmail(cursor.getString(2));
                student.setBatch(cursor.getString(3));
                studentList.add(student);
            }while (cursor.moveToNext());
        }
        return studentList;
    }


    public int updateStudent(Student student)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_ID,student.getStudent_ID());
        values.put(KEY_name,student.getName());
        values.put(KEY_email,student.getEmail());
        values.put(KEY_batch,student.getBatch());
        // updating row
        return db.update(TABLE_STUDENT, values, KEY_ID + " = ?",
                new String[] { String.valueOf(student.getStudent_ID()) });
    }

    public String getData(String name){
        String selectQuery = "SELECT password FROM Student WHERE username="+name+";";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        Student student = new Student();
        if(cursor.moveToFirst())
        {
            do {

                student.getPassword();
            }while (cursor.moveToNext());
        }
        return student.getPassword();
    }

}
