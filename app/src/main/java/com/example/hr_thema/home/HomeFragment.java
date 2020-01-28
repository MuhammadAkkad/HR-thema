package com.example.hr_thema.home;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.hr_thema.IDrawerListener;
import com.example.hr_thema.R;
import com.example.hr_thema.detail.DetailFragment;

public class HomeFragment extends Fragment {

    View view;
    ImageView imageView;
    CardView cardView;

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
        imageView = view.findViewById(R.id.img_profile_activity_login2);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IDrawerListener iDrawerListener = (IDrawerListener) getActivity();
                iDrawerListener.OpenDrawer();
            }
        });

        cardView = view.findViewById(R.id.cardView);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // ListenerHome listenerHome = (ListenerHome) getActivity();
               // listenerHome.OpenDetailPage();
                openDetail();
            }
        });
    }

    public void openDetail(){
        DetailFragment detailFragment = new DetailFragment();
        FragmentManager fragmentManager = getFragmentManager();

      // for (Fragment fragment : getFragmentManager().getFragments()) {
      //     if (fragment != null) {
      //         getFragmentManager().beginTransaction().remove(fragment).commit();
      //     }
      // }
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.constraintLayout2, detailFragment);
        fragmentTransaction.commit();
    }

    public interface ListenerHome{
        void OpenDetailPage();
    }
}
