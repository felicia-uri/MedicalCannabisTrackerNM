package edu.cnm.deepdive.fu.medicalcannabistrackernm.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper{


  private static final String DATABASE_NAME = "PatientCardInfo";
  private static final int DATABASE_VERSION = 1;

  public DBHelper(Context context) {
    super(context,DATABASE_NAME, null, DATABASE_VERSION);
  }

  @Override
  public void onCreate(SQLiteDatabase db) {
    db.execSQL(PatientCardTable.SQL_CREATE);
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL(PatientCardTable.SQL_DELETE);
    onCreate(db);
  }
}
