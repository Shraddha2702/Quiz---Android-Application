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
class DBHelperGk extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 5;
    // Database Name
    private static final String DATABASE_NAME = "GKQuiz";
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
    public DBHelperGk(Context context) {
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
    private void addQuestions() {
        Question q1 = new Question("Grand Central Terminal, Park Avenue, New York is the World's ", "" +
                "Largest Railway Station", "Highest Railway Station", "Longest Railway Station", "Largest Railway Station");
        this.addQuestion(q1);
        Question q2 = new Question("" +
                "Entomology is the science that studies", "Behavior of human beings", "Insects",
                "The origin and history of technical and scientific terms", "Insects");

        this.addQuestion(q2);
        Question q3 = new Question("Eritrea, which became the 182nd member of the UN in 1993, is in the continent of",
                "Asia", " Africa", "Europe ", "Africa");
        this.addQuestion(q3);
        Question q4 = new Question("Garampani sanctuary is located at"
                , "Junagarh, Gujarat", "Diphu, Assam", "Kohima, Nagaland", "Diphu, Assam");
        this.addQuestion(q4);

        Question q5 = new Question("For which of the following disciplines is Nobel Prize awarded?",
                "Physics and Chemistry", "Literature, Peace and Economics", "All of the above", "All of the above");
        this.addQuestion(q5);

        Question q6=new Question("Hitler party which came into power in 1933 is known as" ,
                " Labour Party", "Nazi Party", "Ku-Klux-Klan", "Nazi Party");
        this.addQuestion(q6);

        Question q7=new Question("FFC stands for" ,
                "Foreign Finance Corporation", "Film Finance Corporation", "Federation of Football Council",
                "Film Finance Corporation");
        this.addQuestion(q7);

        Question q8=new Question("Fastest shorthand writer was" ,"Dr. G. D. Bist",
                "J.R.D. Tata", "J.M. Tagore", "Dr. G. D. Bist");
        this.addQuestion(q8);

        Question q9=new Question("Epsom (England) is the place associated with" ,
                "Horse racing", "Polo","Snooker", "Horse racing");
        this.addQuestion(q9);

        Question q10=new Question("" +
                "First human heart transplant operation conducted by Dr. Christiaan Barnard on Louis Washkansky, was conducted in" ,
                "1967", "1968","1922", "1967");
        this.addQuestion(q10);

        Question q11=new Question("Galileo was an Italian astronomer who" ,
                "Discovered four satellites of Jupiter",
                "Discovered that the movement of pendulum produces a regular time measurement","All of the above", "All of the above");
        this.addQuestion(q11);

        Question q12=new Question("" +
                "Habeas Corpus Act 1679" ,"States that no one was to be imprisoned without a writ or warrant stating the charge against him",
                "Safeguarded the personal liberties of the people against arbitrary imprisonment by the king's orders",
                "All of the above", "All of the above");
        this.addQuestion(q12);

        Question q13=new Question("Exposure to sunlight helps a person improve his health because" ,
                "Resistance power increases", "The pigment cells in the skin get stimulated and produce a healthy tan",
                "The ultraviolet rays convert skin oil into Vitamin D", "The ultraviolet rays convert skin oil into Vitamin D");
        this.addQuestion(q13);

        Question q14=new Question("Golf player Vijay Singh belongs to which country?" ,
                "USA", "Fiji", "India", "Fiji");
        this.addQuestion(q14);

        Question q15=new Question("Guarantee to an exporter that the importer of his goods will pay immediately for the " +
                "Goods ordered by him, is known as" ,"Letter of Credit (L/C)",
                "Inflation", "Laissezfaire", "Letter of Credit (L/C)");
        this.addQuestion(q15);

        Question q16=new Question("First Afghan War took place in" ,
                "1839", "1843","1848", "1839");
        this.addQuestion(q16);

        Question q17=new Question("Gulf cooperation council was originally formed by" ,
                "Bahrain, Kuwait, Oman, Qatar, Saudi Arabia and United Arab Emirates",
                "Second World Nations","Fourth World Nations", "Bahrain, Kuwait, Oman, Qatar, Saudi Arabia and United Arab Emirates");
        this.addQuestion(q17);

        Question q18=new Question("First China War was fought between" ,
                "China and Britain", "China and France", "China and Egypt", "China and Britain");
        this.addQuestion(q18);

        Question q19=new Question(" Dumping is" ,"Selling of goods abroad at a price well below the production cost at the home market price",
                "The process by which the supply of a manufacture's product remains low in " +
                        "the domestic market, Which batches him better price","All of the above", "All of the above");
        this.addQuestion(q19);

        Question q20=new Question("For the Olympics and World Tournaments, the dimensions of basketball court are" ,
                "26 m x 14 m", "28 m x 15 m", "27 m x 16 m", "28 m x 15 m");
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
