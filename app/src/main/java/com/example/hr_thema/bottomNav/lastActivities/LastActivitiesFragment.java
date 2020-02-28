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
import com.example.hr_thema.api.APIService;
import com.example.hr_thema.api.APIUrl;
import com.example.hr_thema.api.Deneme;
import com.example.hr_thema.api.ProcessRequest;
import com.example.hr_thema.detail.DetailFragment;
import com.example.hr_thema.navigationDrawer.IDrawerListener;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
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
//        getWaitingProcess();
//        getWaitingProcess2();

        return view;
    }



    public void getWaitingProcess2()
    {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://hcm-manager-dev.opthemateknoloji.com/WorkflowApi/GetWaiting")
                .method("GET", null)
                .addHeader("Authorization", "Bearer "+ Deneme.getTokenNow)
                .build();
        //okhttp3.Response response = client.newCall(request).execute();
        client.newCall(request).enqueue(new okhttp3.Callback()
        {
          @Override
          public void onFailure(okhttp3.Call call, IOException e) {
              System.out.println("onFailure okhttp3");
          }
          @Override
          public void onResponse(okhttp3.Call call, okhttp3.Response response) throws IOException {
              System.out.println("success onResponse");
          }
        });
    }

    public void getWaitingProcess(){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(APIUrl.BASE_URL).addConverterFactory(GsonConverterFactory.create()).client(new OkHttpClient()).build();
        APIService apis = retrofit.create(APIService.class);
        Call<List<ProcessRequest>> call = apis.getProcessInformation("Bearer " + Deneme.getTokenNow);
        call.enqueue(new Callback<List<ProcessRequest>>() {
            @Override
            public void onResponse(Call<List<ProcessRequest>> call, Response<List<ProcessRequest>> response) {
                if(response.isSuccessful() == true){
                    System.out.println("başarılı");
                    for(ProcessRequest item : response.body()){
                        System.out.println(item.getRequestNumber());
//                        if(item.getRequestNumber() == null){
//                            System.out.println("request number yok");
//                        }
                        System.out.println(item.getCreator());
                        System.out.println(item.getRequestId());
                        System.out.println(item.getState());
                    }
                    //System.out.println(response.body().getCreator());
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
