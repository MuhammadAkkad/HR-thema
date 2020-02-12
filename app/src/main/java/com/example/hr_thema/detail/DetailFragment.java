package com.example.hr_thema.detail;

import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hr_thema.R;
import com.example.hr_thema.detail.comment.CommentFragment;
import com.example.hr_thema.detail.operation.OperationsFragment;
import com.google.android.material.tabs.TabLayout;


public class DetailFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    TabLayout tabLayout;
    ViewPager viewPager;


    private OnFragmentInteractionListener mListener;

    public DetailFragment() {
    }

    public static DetailFragment newInstance(String param1, String param2) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }



    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    @Override
    public void onDetach() {
//        getActivity().onBackPressed();
        super.onDetach();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        viewPager = view.findViewById(R.id.viewPager);
        tabLayout = view.findViewById(R.id.tabLayout);

        FragmentManager fragmentManager = getFragmentManager();
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(fragmentManager);
        viewPagerAdapter.addFragment(new OperationsFragment(),"İŞLEMLER");
        viewPagerAdapter.addFragment(new CommentFragment(),"YORUMLAR");

        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        for(int i=0; i < tabLayout.getTabCount(); i++) {
            if (i == 1){
            View tab = ((ViewGroup) tabLayout.getChildAt(0)).getChildAt(i);
            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) tab.getLayoutParams();
            p.setMargins(50, 0, 0, 0);
            tab.requestLayout();
            }
        }
    }


}
