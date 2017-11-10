package edu.cnm.deepdive.fu.medicalcannabistrackernm.database;

public class DataCardId {

  private String keyId;
  private String cardHolderName;
  private String cardID;
  private String issueDate;
  private String expDate;
  private String unitsStartDate;
  private String unitsRenewalDate;

  public DataCardId() {

  }

  public DataCardId(String keyId, String cardHolderName, String cardID, String issueDate, String expDate, String unitsStartDate,
      String unitsRenewalDate) {
    this.keyId = keyId;
    this.cardHolderName = cardHolderName;
    this.cardID = cardID;
    this.issueDate = issueDate;
    this.expDate = expDate;
    this.unitsStartDate = unitsStartDate;
    this.unitsRenewalDate = unitsRenewalDate;
  }

  public String getKeyId() {
    return keyId;
  }

  public void setKeyId(String keyId) {
    this.keyId = keyId;
  }

  public String getCardHolderName() {
    return cardHolderName;
  }

  public void setCardHolderName(String cardHolderName) {
    this.cardHolderName = cardHolderName;
  }

  public String getCardID() {
    return cardID;
  }

  public void setCardID(String cardID) {
    this.cardID = cardID;
  }

  public String getIssueDate() {
    return issueDate;
  }

  public void setIssueDate(String issueDate) {
    this.issueDate = issueDate;
  }

  public String getExpDate() {
    return expDate;
  }

  public void setExpDate(String expDate) {
    this.expDate = expDate;
  }

  public String getUnitsStartDate() {
    return unitsStartDate;
  }

  public void setUnitsStartDate(String unitsStartDate) {
    this.unitsStartDate = unitsStartDate;
  }

  public String getUnitsRenewalDate() {
    return unitsRenewalDate;
  }

  public void setUnitsRenewalDate(String unitsRenewalDate) {
    this.unitsRenewalDate = unitsRenewalDate;
  }

  @Override
  public String toString() {
    return "DataCardId{" +
        "keyId='" + keyId + '\'' +
        ", cardHolderName='" + cardHolderName + '\'' +
        ", cardID='" + cardID + '\'' +
        ", issueDate='" + issueDate + '\'' +
        ", expDate='" + expDate + '\'' +
        ", unitsStartDate='" + unitsStartDate + '\'' +
        ", unitsRenewalDate='" + unitsRenewalDate + '\'' +
        '}';
  }
}
