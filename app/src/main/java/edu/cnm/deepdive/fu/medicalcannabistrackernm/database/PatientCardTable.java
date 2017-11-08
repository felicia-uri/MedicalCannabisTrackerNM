package edu.cnm.deepdive.fu.medicalcannabistrackernm.database;

public class PatientCardTable {

  //Table name
  public static final String PATIENT_CARD_TABLE = "cardInfo";

  //Columns
  public static final String KEY_ID = "cardIdNumber";
  public static final String COLUMN_ISSUE_DATE = "cardIssueDate";
  public static final String COLUMN_EXP_DATE = "cardExpDate";
  public static final String COLUMN_UNITS_START_DATE = "unitsStartDate";
  public static final String COLUMN_UNITS_RENEWAL_DATE = "unitsRenewalDate";

  public static final String SQL_CREATE =
      "CREATE TABLE " + PATIENT_CARD_TABLE + "(" +
          KEY_ID + " TEXT PRIMARY KEY," +
          COLUMN_ISSUE_DATE + " DATE," +
          COLUMN_EXP_DATE + " DATE," +
          COLUMN_UNITS_START_DATE + " DATE," +
          COLUMN_UNITS_RENEWAL_DATE + " DATE," + ");";
  public static final String SQL_DELETE =
      "DROP TABLE " + PATIENT_CARD_TABLE;

}
