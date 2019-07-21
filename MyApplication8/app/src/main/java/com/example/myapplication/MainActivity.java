package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Integer> indices = new ArrayList<>();
    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;

    /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private class PagerAdapter extends FragmentStatePagerAdapter {
        public PagerAdapter(FragmentManager fm) {
            super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

            // Replace super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT); with super(fm); to avoid
            // crash
            //super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Integer index = indices.get(position);

            PageFragment pageFragment = new PageFragment(index);

            return pageFragment;
        }

        @Override
        public int getCount() {
            return indices.size();
        }

        @Override
        public int getItemPosition(Object object) {
            // refresh all fragments when data set changed
            return PagerAdapter.POSITION_NONE;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        for (int i=0; i<3; i++) {
            indices.add(i);
        }

        setContentView(R.layout.activity_main);

        this.viewPager = findViewById(R.id.view_pager);

        this.pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                indices.remove(0);
                pagerAdapter.notifyDataSetChanged();
            }
        });
    }
}
