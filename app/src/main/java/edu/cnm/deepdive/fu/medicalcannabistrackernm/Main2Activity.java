package edu.cnm.deepdive.fu.medicalcannabistrackernm;

import android.app.DatePickerDialog;
import android.content.Intent;
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
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import edu.cnm.deepdive.fu.medicalcannabistrackernm.database.DBHandler;
import edu.cnm.deepdive.fu.medicalcannabistrackernm.database.PatientCardID;
import edu.cnm.deepdive.fu.medicalcannabistrackernm.fragments.DatePickerFragment;
import edu.cnm.deepdive.fu.medicalcannabistrackernm.fragments.DisplayMessageActivity;
import edu.cnm.deepdive.fu.medicalcannabistrackernm.fragments.IDCard;
import edu.cnm.deepdive.fu.medicalcannabistrackernm.fragments.PatientIDCard;
import edu.cnm.deepdive.fu.medicalcannabistrackernm.fragments.PatientIDCard.OnFragmentInteractionListener;
import edu.cnm.deepdive.fu.medicalcannabistrackernm.fragments.Home;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class Main2Activity extends AppCompatActivity
    implements NavigationView.OnNavigationItemSelectedListener, OnFragmentInteractionListener,
    Home.OnFragmentInteractionListener, IDCard.OnFragmentInteractionListener, DatePickerDialog.OnDateSetListener {

  public static final String EXTRA_MESSAGE ="edu.cnm.deepdive.fu.medicalcannabistrackernm.MESSAGE";

  FragmentManager manager = getSupportFragmentManager();
  Fragment fragment = manager.findFragmentById(R.id.fragment_container);
  DBHandler db;





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

    db = new DBHandler(this);


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

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }

  @SuppressWarnings("StatementWithEmptyBody")
  @Override
  public boolean onNavigationItemSelected(MenuItem item) {
    // Handle navigation view item clicks here.
    int id = item.getItemId();

    if (id == R.id.nav_home) {
      Home home  = new Home();
      manager.beginTransaction().replace(R.id.fragment_container, home).commit();
    } else if (id == R.id.nav_patient_id_card) {
      PatientIDCard patientIDCard = new PatientIDCard();
      manager.beginTransaction().replace(R.id.fragment_container, patientIDCard).commit();
    } else if (id == R.id.nav_idcard) {
      IDCard idCard = new IDCard();
      manager.beginTransaction().replace(R.id.fragment_container, idCard).commit();
    }

    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    drawer.closeDrawer(GravityCompat.START);
    return true;
  }

  @Override
  public void onFragmentInteraction(Uri uri) {

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
    db.addPatientCardID(patientCardID);
  }


}
