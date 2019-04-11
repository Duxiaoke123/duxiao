package com.example.x.duxiaoke201947.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.x.duxiaoke201947.R;

/**
 * @Author：x
 * @E-mail：
 * @Date：2019/4/7 14:14
 * @Description：描述信息
 */
public class Fragment extends android.support.v4.app.Fragment {

    private RecyclerView recycle;
    private EditText extit;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment, container, false);
        recycle = view.findViewById(R.id.recycler);
        extit = view.findViewById(R.id.extit);
        return view;
    }
}
