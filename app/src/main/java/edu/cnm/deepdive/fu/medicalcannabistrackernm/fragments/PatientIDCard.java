package edu.cnm.deepdive.fu.medicalcannabistrackernm.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import edu.cnm.deepdive.fu.medicalcannabistrackernm.Main2Activity;
import edu.cnm.deepdive.fu.medicalcannabistrackernm.R;
import edu.cnm.deepdive.fu.medicalcannabistrackernm.database.DataCardId;
import edu.cnm.deepdive.fu.medicalcannabistrackernm.database.sample.SampleDataProvider;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 * A simple {@link Fragment} subclass. Activities that contain this fragment must implement the
 * {@link PatientIDCard.OnFragmentInteractionListener} interface to handle interaction events. Use
 * the {@link PatientIDCard#newInstance} factory method to create an instance of this fragment.
 */
public class PatientIDCard extends Fragment {


  private OnFragmentInteractionListener mListener;
  //TextView tvOut;
  List<DataCardId> dataCardIdList = SampleDataProvider.dataCardList;
  List<String> dataNames = new ArrayList<>();

  public PatientIDCard() {
    // Required empty public constructor
  }


  // TODO: Rename and change types and number of parameters
  public static PatientIDCard newInstance(String param1, String param2) {
    PatientIDCard fragment = new PatientIDCard();
    Bundle args = new Bundle();
    fragment.setArguments(args);
    return fragment;
  }

//  @Override
//  public void onCreate(Bundle savedInstanceState) {
//    super.onCreate(savedInstanceState);
//    findViewById(R.id.list_test).setListAdapter(new ArrayAdapter(this,  android.R.layout.simple_list_item_1, listItems));
//  }
//
//  public void onViewCreated(View view, @Nullable Bundle saveInstanceState){
//    ListView listView = (ListView) getView().findViewById(R.id.list_test);
//    listView.setListAdapter(new ArrayAdapter(this,  android.R.layout.simple_list_item_1, listItems));
//  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View inflate = inflater.inflate(R.layout.fragment_patient_idcard, container, false);

//    DataCardId data = new DataCardId(null, "card ID", "date",
//        "date", "date",
//        "date");

//    tvOut = (TextView) inflate.findViewById(R.id.data_out);
//    tvOut.setText("");

    //Sort alphabetically
//    Collections.sort(dataCardIdList, new Comparator<DataCardId>() {
//      @Override
//      public int compare(DataCardId o1, DataCardId o2) {
//        return o1.getCardHolderName().compareTo(o2.getCardHolderName());
//      }
//    });

    for (DataCardId data : dataCardIdList) {
      // tvOut.append(data.getCardHolderName() + "\n");
      dataNames.add(data.getCardHolderName());
    }
    Collections.sort(dataNames);

//    ArrayAdapter<String> adapter = new ArrayAdapter<String>(
//        this,
//    )


    return inflate;



  }

  // TODO: Rename method, update argument and hook method into UI event
  public void onButtonPressed(Uri uri) {
    if (mListener != null) {
      mListener.onFragmentInteraction(uri);
    }
  }

  @Override
  public void onAttach(Context context) {
    super.onAttach(context);
    if (context instanceof OnFragmentInteractionListener) {
      mListener = (OnFragmentInteractionListener) context;
    } else {
      throw new RuntimeException(context.toString()
          + " must implement OnFragmentInteractionListener");
    }
  }

  @Override
  public void onDetach() {
    super.onDetach();
    mListener = null;
  }

  /**
   * This interface must be implemented by activities that contain this fragment to allow an
   * interaction in this fragment to be communicated to the activity and potentially other fragments
   * contained in that activity. <p> See the Android Training lesson <a href=
   * "http://developer.android.com/training/basics/fragments/communicating.html" >Communicating with
   * Other Fragments</a> for more information.
   */
  public interface OnFragmentInteractionListener {

    // TODO: Update argument type and name
    void onFragmentInteraction(Uri uri);
  }
}
