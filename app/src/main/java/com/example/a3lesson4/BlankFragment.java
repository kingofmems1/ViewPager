package com.example.a3lesson4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class BlankFragment extends Fragment {

    private TextView text ;



    public BlankFragment() {

    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
View view = inflater.inflate(R.layout.fragment_blank, container, false);

 text = view.findViewById(R.id.txt_text);

        return  view ;
    }
}