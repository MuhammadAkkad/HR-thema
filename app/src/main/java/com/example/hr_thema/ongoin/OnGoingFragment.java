package com.example.hr_thema.ongoin;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
        cardView = view.findViewById(R.id.activity_card_view);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListenerOnGoingFragment listenerOnGoingFragment = (ListenerOnGoingFragment) getActivity();
                listenerOnGoingFragment.openDetail();
            }
        });

    }


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


        return inflater.inflate(R.layout.fragment_on_going, container, false);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface ListenerOnGoingFragment {
        void openDetail();

    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
