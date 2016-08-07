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
class DBHelperEnter extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 5;
    // Database Name
    private static final String DATABASE_NAME = "EnterQuiz";
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
    public DBHelperEnter(Context context) {
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
        Question q1=new Question("First Indian Movie submitted for Oscar :" ,"The Guide", "Mother India", "Mother India", "Mother India");
        this.addQuestion(q1);
        Question q2=new Question("Satyajit Ray won Oscar in the year ?" ,"1992", "1994", "1986", "1992");
        this.addQuestion(q2);
        Question q3=new Question("First Indian sound film was " ,"Alam ara", "Raja Harishchandra", "Kishan Kanaya", "Alam ara");
        this.addQuestion(q3);
        Question q4=new Question("Filmfare Awards started from the year ?" ,"1952", "1964", "1954", "1954");
        this.addQuestion(q4);
        Question q5=new Question("From which year Indian government sponsered National Film awards ?" ,"1972", "1973","1980", "1973");
        this.addQuestion(q5);

        Question q6=new Question("Total number of awards won by Satyajit Ray at National Film awards " ,"10", "32","8", "32");
        this.addQuestion(q6);
        Question q7=new Question("First Indian to win an Oscar " ,"Bhanu Athaiya", "A R Rehman", "Rasul Pokutty", "Bhanu Athaiya");
        this.addQuestion(q7);
        Question q8=new Question("Total number of Best Actor Nominations for Amitabh Bachchan in Filfmare awards are " ,"28", "22", "30", "28");
        this.addQuestion(q8);
        Question q9=new Question("First Filmfare award for the Best Actor was awarded to " ,"Ashok Kumar", "Dilip Kumar", "Raj Kumar",
                "Dilip Kumar");
        this.addQuestion(q9);
        Question q10=new Question("Last film directed by Satyajit Ray " ,"Agantuk", "Bala", "Piku", "Agantuk");
        this.addQuestion(q10);

        Question q11=new Question("Film and Television Institute of India is located at " ,"Mumbai", "Kolkata", "Pune", "Pune");
        this.addQuestion(q11);
        Question q12=new Question("Film and Television Institute of India was established in the year " ,"1655", "1962", "1965", "1965");
        this.addQuestion(q12);
        Question q13=new Question("First 3D animated movie from India is " ,"Roadside Romeo", "Gayab aaya", "Hanuman", "Roadside Romeo");
        this.addQuestion(q13);
        Question q14=new Question("First Indian animation Film 'Ek Anek aur Ekta' in 1974 was directed by  " ,"Ram Mohan", "Vijaya Mulay",
                "Milind Ukey", "Vijaya Mulay");
        this.addQuestion(q14);
        Question q15=new Question("DoorDarshan founded in India in the year " ,"1962", "1965", "1952", "1952");
        this.addQuestion(q15);
        Question q16=new Question("First Program telecasted on Doordarshan is " ,"Krishi Darshan", "Asian Games",
                "The Peacock Call", "Krishi Darshan");
        this.addQuestion(q16);
        Question q17=new Question("First sponsered program telecasted on Doordarshan " ,"Hum Log", "Buniyaad","Sarab Sanji Gurbani", "Sarab Sanji Gurbani");
        this.addQuestion(q17);
        Question q18=new Question("Who played leading role in the movie Raja HarishChandra ?" ,"Vithal", "PrithviRaj Kapoor", "DD Dakke", "DD Dakke");
        this.addQuestion(q18);
        Question q19=new Question("Which is the bollywood movie with highest number of songs " ,
                "Neel Kamal", "Indra Sabha","Kishan Kanaya", "Indra Sabha");
        this.addQuestion(q19);
        Question q20=new Question("First Indian movie to be premeried at USA " ,"Mother India", "Amar Jyoti", "Ram Rajya", "Ram Rajya");
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

