package com.example.a3lesson4;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;


import java.util.ArrayList;
import java.util.List;

public class fragmentAdapter extends FragmentPagerAdapter{
    private List<fragmentModel> list ;

    public fragmentAdapter(@NonNull FragmentManager fm, List<fragmentModel> list) {
        super(fm);
        this.list = list;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return FirstFragment.newInstance(list.get(position).getTitle(),list.get(position).getDescription(),list.get(position).getImage());
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
