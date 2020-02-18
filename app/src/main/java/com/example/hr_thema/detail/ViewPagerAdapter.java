package com.example.hr_thema.detail;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.hr_thema.detail.comment.CommentFragment;
import com.example.hr_thema.detail.operation.OperationsFragment;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private final List<String> baslikListesi = new ArrayList<>();
    private final List<Fragment> fragmentList = new ArrayList<>();

    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0){
            OperationsFragment operationsFragment = new OperationsFragment();
            return operationsFragment;
        }
        else {
            CommentFragment commentFragment = new CommentFragment();
            return commentFragment;
        }
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

//    @Nullable
//    @Override
//    public CharSequence getPageTitle(int position) {
//        return baslikListesi.get(position);
//    }



    public void addFragment(Fragment fragment, String title){
        fragmentList.add(fragment);
        baslikListesi.add(title);
    }

}
