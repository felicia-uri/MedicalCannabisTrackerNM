package edu.cnm.deepdive.fu.medicalcannabistrackernm.fragments;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import edu.cnm.deepdive.fu.medicalcannabistrackernm.Main2Activity;
import edu.cnm.deepdive.fu.medicalcannabistrackernm.R;
import edu.cnm.deepdive.fu.medicalcannabistrackernm.database.DataCardId;

public class DisplayMessageActivity extends AppCompatActivity {

  TextView tvOut;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_display_message);

    Intent intent = getIntent();
    String message = intent.getStringExtra(Main2Activity.EXTRA_MESSAGE);

    TextView textView = (TextView) findViewById(R.id.textView3);
    textView.setText(message);

    DataCardId data = new DataCardId(null, "name", "card ID", "date",
        "date", "date",
        "date");

    tvOut = (TextView) findViewById(R.id.out);
    tvOut.setText(data.toString());
  }
}
