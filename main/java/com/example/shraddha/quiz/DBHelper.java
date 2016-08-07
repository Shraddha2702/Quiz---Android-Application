package com.example.shraddha.quiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SHRADDHA on 27-06-2016.
 */
class DBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 5;
    // Database Name
    private static final String DATABASE_NAME = "CompQuiz";
    // tasks table name
    private static final String TABLE_QUEST = "quest";
    // tasks Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_QUES = "question";
    private static final String KEY_ANSWER = "answer"; //correct option
    private static final String KEY_OPTA= "opta"; //option a
    private static final String KEY_OPTB= "optb"; //option b
    private static final String KEY_OPTC= "optc"; //option c
    private SQLiteDatabase dbase1;
    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase1=db;
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
        Question q1=new Question("Which of the following memories is an" +
                " optical Device?","Floppy Disk", "Bubble Memories", "CD-ROM", "CD-ROM");
        addQuestion(q1);
        Question q2=new Question("DNS refers to: ", "Data Number Sequence", "Digital Network Service", "Domain Name System",
                "Digital Network Service");
        addQuestion(q2);
        Question q3=new Question("Java was originally invented by:","Oracle", "Microsoft","Novell","Novell");
        addQuestion(q3);
        Question q4=new Question("The unit of speed used for"+
                " superComputers?",    "KELOPS", "GELOPS", "MELOPS","GELOPS");
        addQuestion(q4);
        Question q5=new Question("Whose Trademark is the Operating System" +
                " UNIX?","Motorola","Mircrosoft","BELL Laboratories","BELL Laboratories");
        addQuestion(q5);

        Question q6=new Question("The First Mechanical Computer designed by" +
                " Charles Babbage was called","Abacus","Analytical Engine","Processor","Analytical Engine");
        addQuestion(q6);
        Question q7=new Question("Which of the following is the most" +
                "powerful type of Computer?","Super-Micro","Super conductor","Super Computer","Super Computer");
        addQuestion(q7);
        Question q8=new Question("Which Gate is a single Intergrated Circuit?"
                ,"Gate","MotherBoard","CPU","Gate");
        addQuestion(q8);
        Question q9=new Question("C is :"
                ,"A third Generation High Level Language","A Machine Language","An Assembly Language",
                "A third Generation High Level Language");
        addQuestion(q9);
        Question q10=new Question("WebPages are written using "
                ,"FTP","HTML","URL","URL");
        addQuestion(q10);

        Question q11=new Question("Find the off man out."
                ,"Coaxial Cables","Microwaves","Optical Fibre","Microwaves");
        addQuestion(q11);
        Question q12=new Question("The parity bit is added for the purpose of"
                ,"Coding","Error Detection","Controlling","Error Detection");
        addQuestion(q12);
        Question q13=new Question("India's First SuperComputer is "
                ,"Agni","Flow Solver","Param","Param");
        addQuestion(q13);
        Question q14=new Question("Which of the following is NOT an" +
                " operating System?","Unix","Windows NT","JAVA","JAVA");
        addQuestion(q14);
        Question q15=new Question("The computer that is not considered" +
                " Portable is","Laptop Computer","Mini Computer","Notebook Computer","Mini Computer");
        addQuestion(q15);
        Question q16=new Question("UNIVAC is an " +
                " example of","First Generation Computer","Second Generation Computer","Third Generation Computer",
                "First Generation Computer");
        addQuestion(q16);
        Question q17=new Question("The first movie released in 1982 with terrific" +
                " Computer animation and graphics was ","Star Wars","Tron","Dark Star","Star Wars");
        addQuestion(q17);
        Question q18=new Question("Which of the following is an example " +
                " of non-volatile Memory?","VLSI","LSI","ROM","ROM");
        addQuestion(q18);
        Question q19=new Question("One byte is equivalent to "
                ,"4 Bits","8 Bits","12 Bits","8 Bits");
        addQuestion(q19);
        Question q20=new Question("Graphic Interfaces were first used in a xerox" +
                " product is called","Ethernet","Inter LISP","Zeta LISP","Ethernet");
        addQuestion(q20);


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
        dbase1.insert(TABLE_QUEST, null, values);
    }
    public List<Question> getAllQuestions() {
        List<Question> quesList = new ArrayList<Question>();
// Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        dbase1=this.getReadableDatabase();
        Cursor cursor = dbase1.rawQuery(selectQuery, null);
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
