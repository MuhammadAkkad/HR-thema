package com.example.hr_thema.bottomNav.lastActivities;

import android.annotation.SuppressLint;
import android.os.CountDownTimer;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Switch;

import com.example.hr_thema.R;

public class PopUpClass {

    //PopupWindow display method

    @SuppressLint("ResourceType")
    public void showPopupWindow(final View view) {


        //Create a View object yourself through inflater
        LayoutInflater inflater = (LayoutInflater) view.getContext().getSystemService(view.getContext().LAYOUT_INFLATER_SERVICE);

        final View popupView = inflater.inflate(R.layout.filter_popup, null);

        popupView.setAnimation(AnimationUtils.loadAnimation(view.getContext(), R.animator.popupanim));

        //Specify the length and width through constants
        int width = LinearLayout.LayoutParams.MATCH_PARENT;
        int height = LinearLayout.LayoutParams.MATCH_PARENT;

        //Make Inactive Items Outside Of PopupWindow
        boolean focusable = true;

        //Create a window with our parameters
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        //Set the location of the window on the screen
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        //Initialize the elements of our window, install the handler

        Switch aSwitch = popupView.findViewById(R.id.switch1);
        Switch aSwitch2 = popupView.findViewById(R.id.switch2);
        Switch aSwitch3 = popupView.findViewById(R.id.switch3);
        Switch aSwitch4 = popupView.findViewById(R.id.switch4);
        Switch aSwitch5 = popupView.findViewById(R.id.switch5);

        //Handler for clicking on the inactive zone of the window

        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                //Close the window when clicked
                popupWindow.dismiss();
                return true;
            }
        });
    }

}