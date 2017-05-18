package com.example.barba.fragments;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.icu.util.Calendar;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TimePicker;

import com.example.barba.R;


public class  TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener{


  //  @Override
  //  public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current time as the default values for the picker
     //   final Calendar c = Calendar.getInstance();
      //  int hour = c.get(Calendar.HOUR_OF_DAY);
       // int minute = c.get(Calendar.MINUTE);

        // Create a new instance of TimePickerDialog and return it
        //return new TimePickerDialog(getActivity(), this, hour, minute,
              //  DateFormat.is24HourFormat(getActivity()));
   //     return 0;
 //   }

    public void showTimePickerDialog(View v) {
        DialogFragment newFragment = new TimePickerFragment();
        //newFragment.show(getSupportFragmentManager(), "timePicker");
    }

    private OnFragmentInteractionListener mListener;

    public TimePickerFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static TimePickerFragment newInstance(String param1, String param2) {
        TimePickerFragment fragment = new TimePickerFragment();
        Bundle args = new Bundle();
     //   args.putString(ARG_PARAM1, param1);
      //  args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
          //  mParam1 = getArguments().getString(ARG_PARAM1);
           // mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

  //  @Override
  //  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                            // Bundle savedInstanceState) {
        // Inflate the layout for this fragment
    //    return inflater.inflate(R.layout.fragment_time_picker, container, false);
   // }

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

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
