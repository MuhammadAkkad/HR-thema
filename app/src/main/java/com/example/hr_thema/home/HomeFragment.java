package com.example.hr_thema.home;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.hr_thema.R;
import com.example.hr_thema.navigationDrawer.IDrawerListener;
import com.skydoves.powermenu.CustomPowerMenu;

public class HomeFragment extends Fragment {

    Button btnFilter;
    ImageButton drawer_trigger;
    View view;
    CardView activity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);

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
                PopupMenu popup = new PopupMenu(requireContext(), btnFilter);
                popup.getMenuInflater().inflate(R.menu.filter_menu, popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(requireContext(), "You Clicked : " + item.getTitle(), Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
                popup.show();
            }
        });

        // TODO : open one activity from son aktiviteler
        activity = view.findViewById(R.id.activity_card_view);
        activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Implement activity of islemler", Toast.LENGTH_LONG).show();
            }
        });




        return view;
    }
}
