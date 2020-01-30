package com.example.hr_thema.home;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
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
    ImageView imageView;
    FragmentManager fragmentManager;
    NotificationBadge badge;
    ImageButton imageButton;

    public HomeFragment() {
    }



    // set status bar icon colors to dark
    public static void setLightStatusBar(View view, Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            int flags = view.getSystemUiVisibility();
            flags |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            view.setSystemUiVisibility(flags);
            activity.getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        setLightStatusBar(container, getActivity());

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        OnGoingFragment onGoingFragment = new OnGoingFragment();

        fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.constraintLayout2, onGoingFragment);
        fragmentTransaction.commit();

        badge = view.findViewById(R.id.badge);

        // notification badge TEST
        imageButton = view.findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: impalement your notification badge increment/decrement
                badge.setNumber(5);
            }
        });

        imageView = view.findViewById(R.id.img_profile_activity_login2);

        imageView.setOnClickListener(new View.OnClickListener() {
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

        //   if(getFragmentManager().getFragments() != null){
        //       for (Fragment fragment : getFragmentManager().getFragments()) {
        //           if (fragment != null) {
        //               getFragmentManager().beginTransaction().remove(fragment).commit();
        //           }
        //       }
        //   }

        FragmentTransaction fragmentTransaction2 = fragmentManager.beginTransaction();
        fragmentTransaction2.replace(R.id.constraintLayout2, detailFragment);
        fragmentTransaction2.commit();
    }

}
