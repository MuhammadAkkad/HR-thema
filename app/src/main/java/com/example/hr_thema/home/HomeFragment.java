package com.example.hr_thema.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.hr_thema.R;
import com.example.hr_thema.detail.DetailFragment;
import com.example.hr_thema.navigationDrawer.IDrawerListener;
import com.example.hr_thema.ongoin.OnGoingFragment;
import com.nex3z.notificationbadge.NotificationBadge;

public class HomeFragment extends Fragment {

    View view;
    ImageView drawer_trigger_btn;
    FragmentManager fragmentManager;
    NotificationBadge badge;
    ImageButton badge_trigger_btn;
    ConstraintLayout poppContainer;

    public HomeFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        poppContainer = view.findViewById(R.id.filter_popup_container);


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        OnGoingFragment onGoingFragment = new OnGoingFragment();
        fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.constraintLayout2, onGoingFragment);
        fragmentTransaction.commit();


        // TODO : this is a test implementation for notification badge
        badge = view.findViewById(R.id.badge);
        badge_trigger_btn = view.findViewById(R.id.btn_pending_approval);
        badge_trigger_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: impalement your notification badge increment/decrement
                badge.setNumber(5);
            }
        });

        // TODO : this is drawer trigger implementation
        drawer_trigger_btn = view.findViewById(R.id.img_profile_activity_login2);
        drawer_trigger_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IDrawerListener iDrawerListener = (IDrawerListener) getActivity();
                iDrawerListener.OpenDrawer();
            }
        });
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    public void openDetailShow(FragmentManager fragmentManager) {
        DetailFragment detailFragment = new DetailFragment();
        FragmentTransaction fragmentTransaction2 = fragmentManager.beginTransaction();
        fragmentTransaction2.replace(R.id.constraintLayout2, detailFragment);
        fragmentTransaction2.commit();
    }
}
