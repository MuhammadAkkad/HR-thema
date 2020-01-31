package com.example.hr_thema.ongoin;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.hr_thema.R;
import com.example.hr_thema.detail.DetailFragment;
import com.example.hr_thema.home.HomeFragment;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnGoingFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link OnGoingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */

public class OnGoingFragment extends Fragment {
    CardView cardView;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    Dialog myDialog;
    Dialog dialog;
    private OnFragmentInteractionListener mListener;

    public OnGoingFragment() {
        // Required empty public constructor
    }
    Button btn3;
    Button btnFilter;
    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
       // btn3 = view.findViewById(R.id.button3);
//        btn3.getBackground().setAlpha(128);
        cardView = view.findViewById(R.id.cardView);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListenerOnGoingFragment listenerOnGoingFragment = (ListenerOnGoingFragment) getActivity();
                listenerOnGoingFragment.openDetail();
            }
        });

        btnFilter = view.findViewById(R.id.btn_filters);
        btnFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialogShow();
               //openFilter(v);
               //ListenerOnGoingFragment listenerOnGoingFragment = (ListenerOnGoingFragment) getActivity();
               //listenerOnGoingFragment.openFilters(v);
            }
        });
    }

    public void dialogShow(){
        View child = getLayoutInflater().inflate(R.layout.activity_filter, null);
        myDialog.setContentView(child);

        // Window window = myDialog.getWindow();
        // WindowManager.LayoutParams wlp = window.getAttributes();

        // wlp.gravity = Gravity.CENTER;
        // window.setAttributes(wlp);

        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable());
        myDialog.show();
    }
    public interface ListenerOnGoingFragment{
        void openDetail();
        void openFilters(View v);
    }

    public void openFilter(View view){
        dialog.setContentView(R.layout.activity_filter);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable());
        dialog.show();
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OnGoingFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OnGoingFragment newInstance(String param1, String param2) {
        OnGoingFragment fragment = new OnGoingFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_on_going, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
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
