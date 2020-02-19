package com.example.hr_thema.detail;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hr_thema.R;
import com.example.hr_thema.detail.comment.CommentFragment;
import com.example.hr_thema.detail.operation.OperationsFragment;
import com.google.android.material.tabs.TabLayout;


public class DetailFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    TabLayout tabLayout;
    ViewPager viewPager;
    ImageView tab0,tab1,imgDown;
    TextView txt_operation_summery_detail_fragment;

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
        tab0 = view.findViewById(R.id.tab0);
        tab1 = view.findViewById(R.id.tab1);
        imgDown = view.findViewById(R.id.imgDown);
        txt_operation_summery_detail_fragment = view.findViewById(R.id.txt_operation_summery_detail_fragment);

        imgDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgDown.setVisibility(View.GONE);
                txt_operation_summery_detail_fragment.setVisibility(View.VISIBLE);
            }
        });

        FragmentManager fragmentManager = getFragmentManager();
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(fragmentManager);
        viewPagerAdapter.addFragment(new OperationsFragment(),"İŞLEMLER");
        viewPagerAdapter.addFragment(new CommentFragment(),"YORUMLAR");

        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.group8);
        int tabIconColor2 = ContextCompat.getColor(requireContext(), R.color.transparentColor);
        tabLayout.getTabAt(0).getIcon().setColorFilter(tabIconColor2,PorterDuff.Mode.ADD);
        tabLayout.getTabAt(1).setIcon(R.drawable.group81);

        //int tabIndicatorColor = ContextCompat.getColor(requireContext(),R.drawable.indicator_gradient_bg);
       // tabLayout.setSelectedTabIndicatorColor(tabIndicatorColor);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int tabIconColor = ContextCompat.getColor(requireContext(), R.color.transparentColor);
                int tabIndicatorColor = ContextCompat.getColor(requireContext(), R.color.colorAccent);
                if(tab.getPosition() == 0)
                {
                    tab0.setVisibility(View.VISIBLE);
                    tab1.setVisibility(View.INVISIBLE);
                }
                else if(tab.getPosition() == 1){
                    tab0.setVisibility(View.INVISIBLE);
                    tab1.setVisibility(View.VISIBLE);
                }
                tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.ADD);
            }

            @SuppressLint("ResourceAsColor")
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(R.color.colorAccent, PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                int tabIconColor = ContextCompat.getColor(requireContext(), R.color.transparentColor);
                tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.DARKEN);
            }
        });
//        for(int i=0; i < tabLayout.getTabCount(); i++) {
//            if (i == 1){
//            View tab = ((ViewGroup) tabLayout.getChildAt(0)).getChildAt(i);
//            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) tab.getLayoutParams();
//            p.setMargins(50, 0, 0, 0);
//            tab.requestLayout();
//            }
//        }
    }


}
