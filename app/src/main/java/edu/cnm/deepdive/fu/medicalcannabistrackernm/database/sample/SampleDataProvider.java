package edu.cnm.deepdive.fu.medicalcannabistrackernm.database.sample;

import edu.cnm.deepdive.fu.medicalcannabistrackernm.database.DataCardId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SampleDataProvider {
  public static List<DataCardId> dataCardList;
  public static Map<String, DataCardId> dataCardMap;

  static {
    dataCardList = new ArrayList<>();
    dataCardMap = new HashMap<>();

    addItem(new DataCardId(null, "Felicia", "One", "December", "November",
        "Issue Date", "Exp Date"));

    addItem(new DataCardId(null, "Estevan", "Two", "July", "June",
      "Issue Date", "Exp Date"));

    addItem(new DataCardId(null, "Wynter", "Three", "May", "April",
        "Issue Date", "Exp Date"));

    addItem(new DataCardId(null, "Francheska", "Four", "January", "December",
      "Issue Date", "Exp Date"));

    addItem(new DataCardId(null, "Darian", "Five", "June", "May",
        "Issue Date", "Exp Date"));

    addItem(new DataCardId(null, "Tori", "Six", "November", "October",
      "Issue Date", "Exp Date"));

    addItem(new DataCardId(null, "Seth", "Seven", "August", "July",
        "Issue Date", "Exp Date"));

    addItem(new DataCardId(null, "Locklyn", "Eight", "October", "September",
      "Issue Date", "Exp Date"));
  }


  private static void addItem(DataCardId data) {
    dataCardList.add(data);
    dataCardMap.put(data.getCardHolderName(), data);
  }
}
