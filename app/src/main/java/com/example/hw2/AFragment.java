package com.example.hw2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class AFragment extends Fragment {
    private Button on1, on2, open;
    private TextView only;
    private Integer integer=0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_a, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    private void initView() {
        on1 = requireActivity().findViewById(R.id.on1);
        on2 = requireActivity().findViewById(R.id.on2);
        open = requireActivity().findViewById(R.id.open);
        only = requireActivity().findViewById(R.id.only);
        initListen();
    }

    private void initListen() {
        on1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                integer--;
                only.setText(String.valueOf(integer));
            }
        });
        on2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                integer++;
                only.setText(String.valueOf(integer));
            }
        });
        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                goToBFragment();
            }
        });

    }

    private void goToBFragment() {
        int  result=integer;
        Bundle bundle= new Bundle();
        bundle.putInt("zero",result);
        BFragment bFragment =new BFragment();
        bFragment.setArguments(bundle);
        requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.containerA,bFragment).addToBackStack(null).commit();
        integer=0;
    }

}