package com.example.hr_thema.bottomNav.lastActivities;

import android.os.Bundle;
import android.util.JsonReader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.hr_thema.R;
import com.example.hr_thema.api.APIService;
import com.example.hr_thema.api.APIUrl;
import com.example.hr_thema.api.ProcessRequest;
import com.example.hr_thema.api.User;
import com.example.hr_thema.detail.DetailFragment;
import com.example.hr_thema.login.LoginActivity;
import com.example.hr_thema.navigationDrawer.IDrawerListener;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


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
        getWaitingProcess();
        return view;
    }



    public void getWaitingProcess(){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(APIUrl.BASE_URL).addConverterFactory(GsonConverterFactory.create(gson)).client(new OkHttpClient()).build();
        APIService apis = retrofit.create(APIService.class);
        Call<List<ProcessRequest>> call = apis.getProcessInformation("application/x-www-form-urlencoded","Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJib3JhbiIsImp0aSI6IjAxZGI0MTQyLWViODEtNDcxNS1hMTg2LWYyYThiNjMxZGU1YSIsImlhdCI6MTU4MjcyNDc4OCwiVXNlckRhdGEiOiJ7XCJJZFwiOjgsXCJOYW1lXCI6XCJCb3JhblwiLFwiU3VybmFtZVwiOlwiR29rYnVsdXRcIixcIlVzZXJOYW1lXCI6XCJib3JhblwiLFwiRnVsbE5hbWVcIjpcIkJvcmFuIEdva2J1bHV0XCIsXCJQaG90b3VybFwiOlwiL0NvbnRlbnQvaW1hZ2VzL2VtcHktdXNlci5wbmdcIixcIkxvZ2luVHlwZXNcIjpudWxsLFwiUm9sZXNcIjpbe1wiQ29kZVwiOm51bGwsXCJDb2RlMlwiOm51bGwsXCJOYW1lXCI6bnVsbCxcIkRlc2NyaXB0aW9uXCI6bnVsbCxcIkRlc2NyaXB0aW9uMlwiOm51bGwsXCJSZWZLZXlcIjpudWxsLFwiUmVmS2V5MlwiOjAsXCJSZWZLZXkzXCI6bnVsbCxcIlJlZktleTRcIjowLFwiUmVmS2V5NVwiOlwiMDAwMDAwMDAtMDAwMC0wMDAwLTAwMDAtMDAwMDAwMDAwMDAwXCIsXCJSZWZLZXk2XCI6ZmFsc2UsXCJSZWZLZXlGbG9hdFwiOjAuMCxcIlJlZkRhdGVcIjpcIjAwMDEtMDEtMDFUMDA6MDA6MDBcIixcIlJlZkRhdGUyXCI6XCIwMDAxLTAxLTAxVDAwOjAwOjAwXCIsXCJSZWZEYXRlM1wiOm51bGwsXCJMaXN0XCI6bnVsbCxcIkludExpc3RcIjpbXSxcIlNlbGV0ZWRDb3VudFwiOm51bGwsXCJJc2NvbXBsZXRlZFwiOmZhbHNlLFwiU3RhdHVcIjpmYWxzZSxcIlJlZktleURvdWJsZVwiOjAuMCxcIlRpdGxlXCI6bnVsbCxcIkhhc1dhcm5pbmdNZXNzYWdlXCI6ZmFsc2UsXCJUYWdDb2xvckNvZGVcIjpudWxsLFwiSXNOb3JtXCI6ZmFsc2UsXCJDYW5Vc2VBc0xpbmtcIjpmYWxzZSxcIkxldmVsXCI6MCxcIlN1YkxldmVsXCI6MCxcIk5vcm1TdGFmZkRvbWFpblVzZXJJZFwiOjAsXCJQaG90b1wiOm51bGwsXCJPcmRlclwiOjAsXCJSZWZEYXRlRm9ybWF0XCI6XCIwMS4wMS4wMDAxXCIsXCJUZXh0XCI6bnVsbCxcIlBhcmFtZXRlckxpc3RcIjpbXSxcIkRvbWFpblVzZXJJZFwiOjAsXCJUYWdMaXN0XCI6bnVsbCxcIkludExpc3QyXCI6bnVsbCxcIkNvdW50XCI6MCxcIkN1cnJlbmN5RW51bVwiOjAsXCJJc0RlZmF1bHRcIjpmYWxzZSxcIkNvbG9yXCI6bnVsbCxcIkljb25cIjpudWxsLFwiSWRcIjoxLFwiSXNTZWxlY3RlZFwiOmZhbHNlLFwiSXNBY3RpdmVcIjpmYWxzZSxcIklzRGVsZXRlZFwiOmZhbHNlLFwiQ29tbWVudENvdW50XCI6MCxcIkFkZGVkQnlcIjowLFwiQWRkZWRCeUlkXCI6bnVsbCxcIkNyZWF0ZWREYXRlXCI6bnVsbH0se1wiQ29kZVwiOm51bGwsXCJDb2RlMlwiOm51bGwsXCJOYW1lXCI6bnVsbCxcIkRlc2NyaXB0aW9uXCI6bnVsbCxcIkRlc2NyaXB0aW9uMlwiOm51bGwsXCJSZWZLZXlcIjpudWxsLFwiUmVmS2V5MlwiOjAsXCJSZWZLZXkzXCI6bnVsbCxcIlJlZktleTRcIjowLFwiUmVmS2V5NVwiOlwiMDAwMDAwMDAtMDAwMC0wMDAwLTAwMDAtMDAwMDAwMDAwMDAwXCIsXCJSZWZLZXk2XCI6ZmFsc2UsXCJSZWZLZXlGbG9hdFwiOjAuMCxcIlJlZkRhdGVcIjpcIjAwMDEtMDEtMDFUMDA6MDA6MDBcIixcIlJlZkRhdGUyXCI6XCIwMDAxLTAxLTAxVDAwOjAwOjAwXCIsXCJSZWZEYXRlM1wiOm51bGwsXCJMaXN0XCI6bnVsbCxcIkludExpc3RcIjpbXSxcIlNlbGV0ZWRDb3VudFwiOm51bGwsXCJJc2NvbXBsZXRlZFwiOmZhbHNlLFwiU3RhdHVcIjpmYWxzZSxcIlJlZktleURvdWJsZVwiOjAuMCxcIlRpdGxlXCI6bnVsbCxcIkhhc1dhcm5pbmdNZXNzYWdlXCI6ZmFsc2UsXCJUYWdDb2xvckNvZGVcIjpudWxsLFwiSXNOb3JtXCI6ZmFsc2UsXCJDYW5Vc2VBc0xpbmtcIjpmYWxzZSxcIkxldmVsXCI6MCxcIlN1YkxldmVsXCI6MCxcIk5vcm1TdGFmZkRvbWFpblVzZXJJZFwiOjAsXCJQaG90b1wiOm51bGwsXCJPcmRlclwiOjAsXCJSZWZEYXRlRm9ybWF0XCI6XCIwMS4wMS4wMDAxXCIsXCJUZXh0XCI6bnVsbCxcIlBhcmFtZXRlckxpc3RcIjpbXSxcIkRvbWFpblVzZXJJZFwiOjAsXCJUYWdMaXN0XCI6bnVsbCxcIkludExpc3QyXCI6bnVsbCxcIkNvdW50XCI6MCxcIkN1cnJlbmN5RW51bVwiOjAsXCJJc0RlZmF1bHRcIjpmYWxzZSxcIkNvbG9yXCI6bnVsbCxcIkljb25cIjpudWxsLFwiSWRcIjozLFwiSXNTZWxlY3RlZFwiOmZhbHNlLFwiSXNBY3RpdmVcIjpmYWxzZSxcIklzRGVsZXRlZFwiOmZhbHNlLFwiQ29tbWVudENvdW50XCI6MCxcIkFkZGVkQnlcIjowLFwiQWRkZWRCeUlkXCI6bnVsbCxcIkNyZWF0ZWREYXRlXCI6bnVsbH1dLFwiUGhvbmVcIjpcIjUzNDM1MzUzXCIsXCJFbWFpbFwiOlwiOF9iZXloYW4udHV0dW5jdWxlckBiaWxnZWFkYW0uY29tXCIsXCJUaXRsZVwiOlwiRGlyZWt0w7ZyIFwifSIsIlNlbGVjdGVkRG9tYWluIjoie1wiRG9tYWluVXNlcklkXCI6NSxcIkRvbWFpbklkXCI6MSxcIlBhcnJuZXREb21haW5JZFwiOm51bGwsXCJMb2dvXCI6XCJ-L0NvbnRlbnQvaW1hZ2VzL0xvZ29CaWxpc2ltR3J1YnUucG5nXCIsXCJOYW1lXCI6XCJCaWxnZSBBZGFtIERldmVsb3BtZW50XCJ9IiwibmJmIjoxNTgyNzI0Nzg4LCJleHAiOjE1ODI4OTc1ODgsImlzcyI6IkhDTS5BcGkiLCJhdWQiOiJIQ00uQXBpIn0.pmjcWz01v33RTUAkUOFgXouKf2tHqPluYlRC0hV2Cfo");
        call.enqueue(new Callback<List<ProcessRequest>>() {
            @Override
            public void onResponse(Call<List<ProcessRequest>> call, Response<List<ProcessRequest>> response) {
                if(response.isSuccessful() == true){
                    System.out.println("başarılı");
                    for(ProcessRequest item : response.body()){
                        System.out.println(item.getRequestNumber());
                    }
//                    System.out.println(response.body().getCreator());
                }
                else{
                    System.out.println("başarısız");
                }
            }

            @Override
            public void onFailure(Call<List<ProcessRequest>> call, Throwable t) {
                System.out.println(t + " adsf");
            }
        });
    }






    private void crossfade() {
        shortAnimationDuration = getResources().getInteger(android.R.integer.config_longAnimTime);
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
