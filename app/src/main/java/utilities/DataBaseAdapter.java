package utilities;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.renderscript.Sampler;
import android.util.Log;

import utilisateur.Utilisateur;


public class DataBaseAdapter
{
    // Database fields

    private Context context;
    private SQLiteDatabase database;
    private DBHelper dbHelper;
    private String STUDENT_TABLE = "LOGIN_STUDENT";
    private String TUTOR_TABLE = "LOGIN_TUTOR";
    private String KEY_NAME = "NOM";
    private String KEY_ID = "ID";
    private String KEY_EMAIL = "EMAIL";
    private String KEY_PRENOM = "PRENOM";
    private String KEY_PASSWORD = "PASSWORD";
    private static Utilisateur tutor;
    private static Utilisateur student
            ;
    public DataBaseAdapter(Context context) {
        this.context = context;
    }

    public DataBaseAdapter open() throws SQLException {
        dbHelper = new DBHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public String getSinlgeEntryTableStudent(String userName)
    {
        Cursor cursor=database.query("LOGIN_STUDENT", null, " USERNAME=?", new String[]{userName}, null, null, null);
        if(cursor.getCount()<1) // UserName Not Exist
        {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        String password= cursor.getString(cursor.getColumnIndex("PASSWORD"));
        student = new Utilisateur(cursor.getString(4), cursor.getString(5));
        student.setPassword(cursor.getString(2));
        student.setEmail(cursor.getString(3));
        student.setId(cursor.getInt(0));
        student.setUsername(cursor.getString(1));
        cursor.close();
        return password;
    }

    public String getSinlgeEntryTableTutor(String userName)
    {
        Cursor cursor = database.query("LOGIN_TUTOR", null, " USERNAME=?", new String[]{userName}, null, null, null);
        if(cursor.getCount()<1) // UserName Not Exist
        {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        String password= cursor.getString(cursor.getColumnIndex("PASSWORD"));
        tutor = new Utilisateur(cursor.getString(4), cursor.getString(5));
        tutor.setPassword(cursor.getString(2));
        tutor.setEmail(cursor.getString(3));
        tutor.setId(cursor.getInt(0));
        tutor.setUsername(cursor.getString(1));

        cursor.close();
        return password;
    }

    public Utilisateur getStudent() {
        return student;
    }
    // get a single tutor
    public Utilisateur getTutor() {
        return tutor;
    }

    public Cursor fetchAllTAble1data() {
        return database.query("LOGIN_STUDENT", new String[] { "ID", "USERNAME",
                "PASSWORD", "PRENOM", "NOM" }, null, null, null, null, null);
    }

    public Cursor fetchAllTable2data() {
        return database.query("LOGIN_STUDENT", new String[] { "ID", "USERNAME",
                "PASSWORD", "PRENOM", "NOM" }, null, null, null, null, null);
    }


    public void createIndividualTable(String query){
        database.execSQL(query);
    }

    // Getting contacts Count
    public int getContactsCount() {
        String countQuery = "SELECT  * FROM LOGIN_TUTOR";
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        //cursor.close();

        // return count
        return cursor.getCount();
    }

    public void insertTableStudentData(Utilisateur student) {


        ContentValues newValues = new ContentValues();
        // Assign values for each row.
        newValues.put("USERNAME", student.getUsername());
        newValues.put("PASSWORD",student.getPassword());
        newValues.put("EMAIL", student.getEmail());
        newValues.put("Nom", student.getNom());
        newValues.put("PRENOM", student.getPrenom());

        //values.put("Comment", review.Comment);
        //values.put("Rating", review.Rating);

        database.insert("LOGIN_STUDENT", null, newValues);

    }

    public void insertTableTutorData(Utilisateur tutor) {

        ContentValues newValues = new ContentValues();
        // Assign values for each row.
        newValues.put("USERNAME", tutor.getUsername());
        newValues.put("PASSWORD",tutor.getPassword());
        newValues.put("EMAIL", tutor.getEmail());
        newValues.put("Nom", tutor.getNom());
        newValues.put("PRENOM", tutor.getPrenom());

        //values.put("Comment", review.Comment);
        //values.put("Rating", review.Rating);


        database.insert("LOGIN_TUTOR", null, newValues);

    }



    // Updating single contact
    public int updateContact(Utilisateur utilisateur) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, utilisateur.getNom());
        values.put(KEY_EMAIL, utilisateur.getEmail());
        values.put(KEY_PRENOM, utilisateur.getPrenom());
        values.put(KEY_PASSWORD, utilisateur.getPassword());
        //values
        // updating row
        return db.update(TUTOR_TABLE, values, KEY_ID + " = ?",
                new String[] { String.valueOf(utilisateur.getId()) });
    }
    // Deleting single contact
    public void deleteTutor(Utilisateur tutor) {
        database = dbHelper.getWritableDatabase();
        database.delete(TUTOR_TABLE, KEY_ID + " = ?",
                new String[] { String.valueOf(tutor.getId()) });
        database.close();
    }
}