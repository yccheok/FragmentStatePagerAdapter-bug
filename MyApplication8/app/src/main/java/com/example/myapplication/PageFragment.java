package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class PageFragment extends Fragment {
    private int index;

    public PageFragment(int index) {
        Bundle bundle = new Bundle();
        bundle.putInt("index", index);
        setArguments(bundle);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Bundle arguments = getArguments();
        this.index = arguments.getInt("index");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pager_fragment, container, false);

        TextView textView = view.findViewById(R.id.text_view);

        textView.setText("" + index);

        return view;
    }
}
