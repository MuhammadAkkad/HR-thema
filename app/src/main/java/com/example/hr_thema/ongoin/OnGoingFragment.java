package com.example.hr_thema.ongoin;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.hr_thema.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnGoingFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link OnGoingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */

public class OnGoingFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    CardView cardView;
    Dialog myDialog;
    Button btn3;
    Button btnFilter;
    private OnFragmentInteractionListener mListener;

    public OnGoingFragment() {
        // Required empty public constructor
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
                alertDialog();
                //dialogShow();
                //openFilter(v);
                //ListenerOnGoingFragment listenerOnGoingFragment = (ListenerOnGoingFragment) getActivity();
                //listenerOnGoingFragment.openFilters(v);
            }
        });
    }

    public void dialogShow() {
        View child = getLayoutInflater().inflate(R.layout.activity_filter, null);
        myDialog.setContentView(child);

        // Window window = myDialog.getWindow();
        // WindowManager.LayoutParams wlp = window.getAttributes();

        // wlp.gravity = Gravity.CENTER;
        // window.setAttributes(wlp);

        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable());
        myDialog.show();
    }

//    public void openFilter(View view) {
//        dialog.setContentView(R.layout.activity_filter);
//        dialog.getWindow().setBackgroundDrawable(new ColorDrawable());
//        dialog.show();
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            // TODO: Rename and change types of parameters
            String mParam1 = getArguments().getString(ARG_PARAM1);
            String mParam2 = getArguments().getString(ARG_PARAM2);
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

    private void alertDialog() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity(), R.style.CustomAlertDialog);
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        dialog.setView(inflater.inflate(R.layout.pop_up_layout, null));
        dialog.setPositiveButton("YES",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int which) {
                        Toast.makeText(getContext(), "Yes is clicked", Toast.LENGTH_LONG).show();
                    }
                });
        dialog.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getContext(), "cancel is clicked", Toast.LENGTH_LONG).show();
            }
        });
        AlertDialog alertDialog = dialog.create();
        alertDialog.show();
    }

    public interface ListenerOnGoingFragment {
        void openDetail();

        void openFilters(View v);
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
