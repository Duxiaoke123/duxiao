package com.example.x.duxiaoke201947;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import com.example.x.duxiaoke201947.fragment.Fragment1;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager pager;
    private RadioGroup radio;
    private ArrayList<Fragment> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pager = findViewById(R.id.viewpager);
        radio = findViewById(R.id.radio);
        list = new ArrayList<>();
        list.add(new Fragment());
        list.add(new Fragment1());
        pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return list.get(i);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
        radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.button1:
                        pager.setCurrentItem(0,false);
                        break;
                    case R.id.button2:
                        pager.setCurrentItem(1);
                        break;
                    case R.id.button3:
                        pager.setCurrentItem(2);
                        break;


                }
            }
        });

    }
}
