package com.example.hr_thema.bottomNav.lastActivities;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.hr_thema.R;
import com.example.hr_thema.detail.DetailFragment;
import com.example.hr_thema.navigationDrawer.IDrawerListener;


public class LastActivitiesFragment extends Fragment {

    Button btnFilter;
    ImageButton drawer_trigger;
    View view;
    CardView activity;

    TextView testText;
    private int shortAnimationDuration;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_last_activities, container, false);
        // Opens navigation drawer
        drawer_trigger = view.findViewById(R.id.btn_trigger_drawer);
        drawer_trigger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IDrawerListener drawerListener = (IDrawerListener) getActivity();
                drawerListener.OpenDrawer();
            }
        });

        // filter button
        btnFilter = view.findViewById(R.id.btnFilter);
        btnFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopUpClass popUpClass = new PopUpClass();
                popUpClass.showPopupWindow(v);
            }
        });


        testText = view.findViewById(R.id.textView4);
        testText.setVisibility(View.GONE);


        // TODO : open one activity from son aktiviteler
        activity = view.findViewById(R.id.activity_card_view);
        activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                DetailFragment detailFragment = new DetailFragment();
                transaction.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);
                transaction.replace(R.id.nav_home, detailFragment);
                transaction.commit();
            }
        });

        return view;
    }

    private void crossfade() {
        shortAnimationDuration = getResources().getInteger(
                android.R.integer.config_longAnimTime);
        // Set the content view to 0% opacity but visible, so that it is visible
        // (but fully transparent) during the animation.
        testText.setAlpha(0f);
        testText.setVisibility(View.VISIBLE);

        // Animate the content view to 100% opacity, and clear any animation
        // listener set on the view.
        testText.animate()
                .alpha(1f)
                .setDuration(shortAnimationDuration)
                .setListener(null);
    }
}
