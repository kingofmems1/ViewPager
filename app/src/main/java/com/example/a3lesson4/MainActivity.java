package com.example.a3lesson4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private fragmentAdapter adapter;
    private LinearLayout point;
    private TextView[] ok;
    private Button btnNext, btnSkip, btnFinish;
    private int currentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        addOk(0);
    }

    private void initView() {
        btnNext = findViewById(R.id.btn_next);
        btnSkip = findViewById(R.id.btn_skip);
        btnFinish = findViewById(R.id.btn_finish);

        viewPager = findViewById(R.id.vp_first);
        viewPager.addOnPageChangeListener(viewListener);
        point = findViewById(R.id.ok);
        List<fragmentModel> list = new ArrayList<>();
        list.add(new fragmentModel("Welcome to Surf.", "I provide essential stuff for your\n" +
                "ui designs every tuesday!", R.drawable.home));
        list.add(new fragmentModel("Design Template uploads\n" +
                "Every Tuesday!", "Make sure to take a look my uplab\n" +
                "profile every tuesday", R.drawable.second));
        list.add(new fragmentModel("Download now!", "You can follow me if you wantand comment\n" +
                "on any to get some freebies", R.drawable.last));
        adapter = new fragmentAdapter(getSupportFragmentManager(), list);
        viewPager.setAdapter(adapter);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(currentPage + 1);
            }
        });
        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, new BlankFragment());
                transaction.addToBackStack("BlankFragment");
                transaction.commit();


            }
        });
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, FinishActivity.class);
//                startActivity(intent);
                finish();
            }
        });
    }

    private void addOk(int pos) {
        ok = new TextView[3];
        point.removeAllViews();
        for (int i = 0; i < ok.length; i++) {
            ok[i] = new TextView(this);
            ok[i].setText(Html.fromHtml("•"));
            ok[i].setTextSize(34);
            point.addView(ok[i]);

        }
        if (ok.length > 0) {
            ok[pos].setTextColor(getResources().getColor(R.color.black));
        }

    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addOk(position);
            currentPage = position;
            if (position == 0) {
                btnFinish.setEnabled(false);
                btnSkip.setEnabled(false);
                btnSkip.setVisibility(View.INVISIBLE);

            } else if (position == ok.length - 1) {
                btnNext.setEnabled(false);
                btnNext.setVisibility(View.INVISIBLE);
                btnFinish.setEnabled(true);
                btnFinish.setVisibility(View.VISIBLE);

            } else {
                btnFinish.setEnabled(false);
                btnNext.setEnabled(true);
                btnSkip.setEnabled(true);
                btnSkip.setVisibility(View.VISIBLE);
                btnNext.setVisibility(View.VISIBLE);
                btnFinish.setVisibility(View.INVISIBLE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}