package com.example.hr_thema.bottomNav.lastActivities;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

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
                //PopupMenu popup = new PopupMenu(requireContext(), btnFilter);
                //popup.setGravity(Gravity.TOP+2);
                //popup.getMenuInflater().inflate(R.menu.filter_menu, popup.getMenu());
//                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
//                    public boolean onMenuItemClick(MenuItem item) {
//                        Toast.makeText(requireContext(), "You Clicked : " + item.getTitle(), Toast.LENGTH_SHORT).show();
//                        return true;
//                    }
//                });
//                popup.show();

                PopUpClass popUpClass = new PopUpClass();
                popUpClass.showPopupWindow(v);
            }
        });


//        arrow = view.findViewById(R.id.imageView4);
        testText = view.findViewById(R.id.textView4);
        testText.setVisibility(View.GONE);


//        arrow.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getContext(), "Clicked", Toast.LENGTH_SHORT).show();
//                if(testText.getVisibility() == View.GONE){
//                    crossfade();}
//                else {
//                    crossfade();
//                }
//            }
//        });


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
