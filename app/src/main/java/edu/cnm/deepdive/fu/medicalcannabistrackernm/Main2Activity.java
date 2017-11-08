package edu.cnm.deepdive.fu.medicalcannabistrackernm;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import edu.cnm.deepdive.fu.medicalcannabistrackernm.database.DBHelper;
import edu.cnm.deepdive.fu.medicalcannabistrackernm.database.PatientCardID;
import edu.cnm.deepdive.fu.medicalcannabistrackernm.fragments.DatePickerFragment;
import edu.cnm.deepdive.fu.medicalcannabistrackernm.fragments.DisplayMessageActivity;
import edu.cnm.deepdive.fu.medicalcannabistrackernm.fragments.IDCard;
import edu.cnm.deepdive.fu.medicalcannabistrackernm.fragments.NmRegulations;
import edu.cnm.deepdive.fu.medicalcannabistrackernm.fragments.PatientIDCard;
import edu.cnm.deepdive.fu.medicalcannabistrackernm.fragments.PatientIDCard.OnFragmentInteractionListener;
import edu.cnm.deepdive.fu.medicalcannabistrackernm.fragments.Home;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main2Activity extends AppCompatActivity
    implements NavigationView.OnNavigationItemSelectedListener, OnFragmentInteractionListener,
    Home.OnFragmentInteractionListener, IDCard.OnFragmentInteractionListener, DatePickerDialog.OnDateSetListener {

  public static final String EXTRA_MESSAGE ="edu.cnm.deepdive.fu.medicalcannabistrackernm.MESSAGE";


  FragmentManager manager = getSupportFragmentManager();
  Fragment fragment = manager.findFragmentById(R.id.fragment_container);

  SQLiteDatabase database;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main2);

    if (fragment == null) {
      Home home = new Home();
      getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, home).commit();
    }

    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

//    FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//    fab.setOnClickListener(new View.OnClickListener() {
//      @Override
//      public void onClick(View view) {
//        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//            .setAction("Action", null).show();
//      }
//    });

    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
        this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
    drawer.setDrawerListener(toggle);
    toggle.syncState();

    NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
    navigationView.setNavigationItemSelectedListener(this);

    SQLiteOpenHelper dbHelper = new DBHelper(this);
    database = dbHelper.getWritableDatabase();
    Toast.makeText(this, "Database acquired!", Toast.LENGTH_SHORT).show();

  }

  @Override
  public void onConfigurationChanged(Configuration newConfig) {
    super.onConfigurationChanged(newConfig);
    if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
      Toast.makeText(this, "Your orientation is portrait", Toast.LENGTH_SHORT).show();
    } else {
      Toast.makeText(this, "Your orientation is landscape", Toast.LENGTH_SHORT).show();
    }
  }

  @Override
  public void onBackPressed() {
    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    if (drawer.isDrawerOpen(GravityCompat.START)) {
      drawer.closeDrawer(GravityCompat.START);
    } else {
      super.onBackPressed();
    }
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.main2, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    switch (id) {
      case R.id.action_settings:
        return true;
      case R.id.action_about:
        return true;
    }

    return super.onOptionsItemSelected(item);
  }

  @SuppressWarnings("StatementWithEmptyBody")
  @Override
  public boolean onNavigationItemSelected(MenuItem item) {
    // Handle navigation view item clicks here.
    int id = item.getItemId();

    switch (id) {
      case R.id.nav_home:
        Home home = new Home();
        manager.beginTransaction().replace(R.id.fragment_container, home).commit();
        break;
      case R.id.nav_patient_id_card:
        PatientIDCard patientIDCard = new PatientIDCard();
        manager.beginTransaction().replace(R.id.fragment_container, patientIDCard).commit();
        break;
      case R.id.nav_idcard:
        IDCard idCard = new IDCard();
        manager.beginTransaction().replace(R.id.fragment_container, idCard).commit();
        break;
      case R.id.nav_regulations:
        NmRegulations nmRegulations = new NmRegulations();
        manager.beginTransaction().replace(R.id.fragment_container, nmRegulations).commit();
        break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }


  public void onDateSet(DatePicker view, int year, int month, int day) {
    Calendar cal = new GregorianCalendar(year, month, day);
    setDate(cal);
  }

  private void setDate(final Calendar calendar) {
    final DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
    ((TextView) findViewById(R.id.showDate)).setText(dateFormat.format(calendar.getTime()));

  }

  public void datePicker(View view) {
    DatePickerFragment fragment = new DatePickerFragment();
    fragment.show(getFragmentManager(), "datePicker");
  }

  public void sendMessage(View view) {
    Intent intent = new Intent(this, DisplayMessageActivity.class);
    EditText editText = (EditText) findViewById(R.id.editText);
    String message = editText.getText().toString();
    intent.putExtra(EXTRA_MESSAGE, message);
    startActivity(intent);

  }

  public void save(View view) {
    String issueDate = ((TextView) findViewById(R.id.showDate)).getText().toString();
    PatientCardID patientCardID = new PatientCardID();
    patientCardID.setIssueDate(issueDate);
//    database.addPatientCardID(patientCardID);
  }


  @Override
  public void onFragmentInteraction(Uri uri) {

  }
}
