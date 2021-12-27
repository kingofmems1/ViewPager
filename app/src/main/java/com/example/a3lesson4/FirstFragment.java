package com.example.a3lesson4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class FirstFragment extends Fragment {

    private TextView title , description ;
    private ImageView image ;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;
    private int imager ;

    public FirstFragment() {
    }



    public static FirstFragment newInstance(String param1, String param2 , int image ) {
        FirstFragment fragment = new FirstFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        args.putInt("pas",image);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            imager = getArguments().getInt("pas");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
View view = inflater.inflate(R.layout.fragment_first, container, false);
        title = view.findViewById(R.id.txt_title);
        description = view.findViewById(R.id.txt_description);
        image = view.findViewById(R.id.image_fragment);
        title.setText(mParam1);
        description.setText(mParam2);
      image.setImageDrawable(getResources().getDrawable(imager));
        return view ;
    }
}