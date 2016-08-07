package com.example.shraddha.quiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SHRADDHA on 04-07-2016.
 */
class DBHelperCap extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 5;
    // Database Name
    private static final String DATABASE_NAME = "CapQuiz";
    // tasks table name
    private static final String TABLE_QUEST = "quest";
    // tasks Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_QUES = "question";
    private static final String KEY_ANSWER = "answer"; //correct option
    private static final String KEY_OPTA= "opta"; //option a
    private static final String KEY_OPTB= "optb"; //option b
    private static final String KEY_OPTC= "optc"; //option c
    private SQLiteDatabase dbase;
    public DBHelperCap(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase=db;
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
                +KEY_OPTB +" TEXT, "+KEY_OPTC+" TEXT)";
        db.execSQL(sql);
        addQuestions();
//db.close();
    }
    private void addQuestions()
    {
        Question q1=new Question("Cairo is the Capital of which country?"
                ,"Georgia", "Haiti","Egypt", "Egypt");
        this.addQuestion(q1);
        Question q2=new Question("Zagreb is the Capital of which country? ",
                "Croatia", "Costa Rica", "Estonia", "Croatia");
        this.addQuestion(q2);
        Question q3=new Question("Tbilisi is the Capital of which country?"
                ,"Georgia", "Gabon","Indonesia","Georgia");
        this.addQuestion(q3);
        Question q4=new Question("Santiago is the Capital of which country?"
                ,    "Croatia", "Cuba","Chille","Chille");
        this.addQuestion(q4);
        Question q5=new Question("Tehran is the Capital of which country?"
                ,"Iraq","Iran","Kenya","Iran");
        this.addQuestion(q5);

        Question q6=new Question("Buenos Aires is the Capital of which country?"
                ,"Bermuda","Bolivia","Argentina","Argentina");
        this.addQuestion(q6);
        Question q7=new Question("New Delhi is the Capital of which country?"
                ,"India","New Guyana","Kuwait","India");
        this.addQuestion(q7);
        Question q8=new Question("Pyongyang is the Capital of which country?"
                ,"South Korea","North Korea","Kyagyzstan","North Korea");
        this.addQuestion(q8);
        Question q9=new Question("Kabul is the Capital of which country?"
                ,"Andorra","Ukraine","Afganistan","Afganistan");
        this.addQuestion(q9);
        Question q10=new Question("Reykjavik is the Capital of which country?"
                ,"Jamaica","Jordan","Iceland","Iceland");
        this.addQuestion(q10);


        Question q11=new Question("Canberra is the Capital of which country?"
                ,"Austria","Australlia","Angola","Australlia");
        this.addQuestion(q11);
        Question q12=new Question("Port-au-Prince is the Capital of which country?" +
                "","Honduras","Haiti","Eritrea","Haiti");
        this.addQuestion(q12);
        Question q13=new Question("Copenhagen is the Capital of which country?" +
                "","Norway","Denmark","Netherlands","Denmark");
        this.addQuestion(q13);
        Question q14=new Question("Helsinki is the Capital of which country?" +
                "","France","Honduras","Finland","Finland");
        this.addQuestion(q14);
        Question q15=new Question("Tallinn is the Capital of which country?" +
                "","Equador","Chech Republic","Estonia","Estonia");
        this.addQuestion(q15);
        Question q16=new Question("Kathmandu is the Capital of which country?" +
                "","Peru","Oman","Nepal","Nepal");
        this.addQuestion(q16);
        Question q17=new Question("Beirut is the Capital of which country?" +
                "","Lebanon","Latvia","Maldives","Lebanon");
        this.addQuestion(q17);
        Question q18=new Question("Ankara is the Capital of which country?" +
                "","Uruguay","Turkey","Uganda","Turkey");
        this.addQuestion(q18);
        Question q19=new Question("Lima is the Capital of which country?" +
                "","Nicaragua","Peru","Paraguay","Peru");
        this.addQuestion(q19);
        Question q20=new Question("Mogadishu is the Capital of which country?" +
                "","Tanzania","Senegal","Somalia","Somalia");
        this.addQuestion(q20);



    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
// Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);
// Create tables again
        onCreate(db);
    }
    // Adding new question
    public void addQuestion(Question quest) {
//SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION());
        values.put(KEY_ANSWER, quest.getANSWER());
        values.put(KEY_OPTA, quest.getOPTA());
        values.put(KEY_OPTB, quest.getOPTB());
        values.put(KEY_OPTC, quest.getOPTC());
// Inserting Row
        dbase.insert(TABLE_QUEST, null, values);
    }
    public List<Question> getAllQuestions() {
        List<Question> quesList = new ArrayList<Question>();
// Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
// looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));
                quesList.add(quest);
            } while (cursor.moveToNext());
        }
// return quest list
        return quesList;
    }
    public int rowcount()
    {
        int row=0;
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        row=cursor.getCount();
        return row;
    }


}

