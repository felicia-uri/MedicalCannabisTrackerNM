package edu.cnm.deepdive.fu.medicalcannabistrackernm.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper{

  //Database Version
  private static final int DATABASE_VERSION = 1;

  //Database Name
  private static final String DATABASE_NAME = "PatientCardInfo";

  //Contacts table name
  private static final String TABLE_ID_CARD = "idCard";

  //ID Card Table Colunms names
  private static final String KEY_ID ="id";
  private static final String KEY_ISSUE_DATE = "issue_date";
  private static final String KEY_EXP_DATE = "exp_date";

  public DBHandler(Context context) {
    super(context,DATABASE_NAME, null, DATABASE_VERSION);
  }

  @Override
  public void onCreate(SQLiteDatabase db) {
    String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_ID_CARD + " ("
        + KEY_ID + " INTEGER PRIMARY KEY," + KEY_ISSUE_DATE + " DATE,"
        + KEY_EXP_DATE + " DATE" + " )";
    db.execSQL(CREATE_CONTACTS_TABLE);

  }

  @Override
  public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

  }

  //Add new card info
  public void addPatientCardID(PatientCardID patientCardID) {
    SQLiteDatabase db = this.getWritableDatabase();
    ContentValues values = new ContentValues();
    values.put(KEY_ISSUE_DATE, patientCardID.getIssueDate()); //get issued date
    values.put(KEY_EXP_DATE, patientCardID.getExpDate()); //get exp date

    //Inserting Row
    db.insert(TABLE_ID_CARD, null, values);
    db.close();
  }

  //Getting patient card info
  public PatientCardID getPatientCardID(int id) {
    SQLiteDatabase db = this.getReadableDatabase();
    Cursor cursor = db.query(TABLE_ID_CARD, new String[]
        {KEY_ID, KEY_ISSUE_DATE, KEY_EXP_DATE}, KEY_ID + "=?", new String[] { String.valueOf(id)},
        null, null, null, null);
    if (cursor != null)
      cursor.moveToFirst();
    PatientCardID contact = new PatientCardID(Integer.parseInt(cursor.getString(0)), cursor.getShort(1), cursor.getShort(2));
    return contact;

  }

  //Get all Patient card info
  public List<PatientCardID> getAllPatientCardID() {
    List<PatientCardID> patientCardIDList = new ArrayList<PatientCardID>();
    //Select All Query
    String selectQuery = "SELECT * FROM " + TABLE_ID_CARD;
    SQLiteDatabase db = this.getWritableDatabase();
    Cursor cursor = db.rawQuery(selectQuery, null);
    //looping through all the rows
    if (cursor.moveToFirst()) {
      do {
        PatientCardID patientCardID = new PatientCardID();
        patientCardID.setId(Integer.parseInt(cursor.getString(0)));
        patientCardID.setIssueDate(cursor.getString(1));
        patientCardID.setExpDate(cursor.getString(2));
        //Adding contact to list
        patientCardIDList.add(patientCardID);
      } while (cursor.moveToNext());
    }
    return patientCardIDList;
  }

  // Updating a patient info
  public int updatePatientCardID(PatientCardID patientCardID) {
    SQLiteDatabase db = this.getWritableDatabase();
    ContentValues values = new ContentValues();
    values.put(KEY_ISSUE_DATE, patientCardID.getIssueDate());
    values.put(KEY_EXP_DATE, patientCardID.getExpDate());
// updating row
    return db.update(TABLE_ID_CARD, values, KEY_ID + " = ?",
        new String[]{String.valueOf(patientCardID.getId())});
  }

  // Deleting a info
  public void deletePatientCardID(PatientCardID patientCardID) {
    SQLiteDatabase db = this.getWritableDatabase();
    db.delete(TABLE_ID_CARD, KEY_ID + " = ?",
        new String[] { String.valueOf(patientCardID.getId())});
    db.close();
  }

}
