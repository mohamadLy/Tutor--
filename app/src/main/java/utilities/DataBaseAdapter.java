package utilities;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;


public class DataBaseAdapter
{
    // Database fields

    private Context context;
    private SQLiteDatabase database;
    private DBHelper dbHelper;

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
        cursor.close();
        return password;
    }

    public String getSinlgeEntryTableTutor(String userName)
    {
        Cursor cursor=database.query("LOGIN_TUTOR", null, " USERNAME=?", new String[]{userName}, null, null, null);
        if(cursor.getCount()<1) // UserName Not Exist
        {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        String password= cursor.getString(cursor.getColumnIndex("PASSWORD"));
        cursor.close();
        return password;
    }

    public Cursor fetchAllTAble1data() {
        return database.query("LOGIN_STUDENT", new String[] { "ID", "USERNAME",
                "PASSWORD", "PRENOM", "NOM" }, null, null, null, null, null);
    }

    public Cursor fetchAllTable2data() {
        return database.query("LOGIN_STUDENT", new String[] { "ID", "USERNAME",
                "PASSWORD", "PRENOM", "NOM" }, null, null, null, null, null);
    }

    public void deleteTable(String tablename){
        database.execSQL("drop table if exists "+tablename+';');
    }
    public void createIndividualTable(String query){
        database.execSQL(query);
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



    public ContentValues createContentValues(String category, String summary,
                                             String description) {
        ContentValues values = new ContentValues();

        return values;
    }
}