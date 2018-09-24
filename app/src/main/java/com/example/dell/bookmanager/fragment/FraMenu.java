package com.example.dell.bookmanager.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dell.bookmanager.ActListUser;
import com.example.dell.bookmanager.account.DoiTaiKhoanActivity;
import com.example.dell.bookmanager.catalog.HoaDonActivity;
import com.example.dell.bookmanager.catalog.SachActivity;
import com.example.dell.bookmanager.catalog.SachbanActivity;
import com.example.dell.bookmanager.catalog.TheloaiActivity;
import com.example.dell.bookmanager.R;
import com.example.dell.bookmanager.setting.NgonNguActivity;
import com.example.dell.bookmanager.setting.TroGiupActivity;

public class FraMenu extends Fragment implements View.OnClickListener {

    private LinearLayout lltaikhoan;
    private LinearLayout lldoitaikhoan;
    private LinearLayout lltheloai;
    private LinearLayout llsach;
    private LinearLayout llhoadon;
    private LinearLayout llsachban;
    private LinearLayout llthongke;
    private LinearLayout llngonngu;
    private LinearLayout lltrogiup;
    private LinearLayout lldangxuat;
    private TextView tvtaikhoan;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);

        lltaikhoan = view.findViewById(R.id.lltaikhoan);
        lldoitaikhoan = view.findViewById(R.id.lldoitaikhoan);
        lltheloai = view.findViewById(R.id.lltheloai);
        llsach = view.findViewById(R.id.llsach);
        llhoadon = view.findViewById(R.id.llhoadon);
        llsachban = view.findViewById(R.id.llsachban);
        llthongke = view.findViewById(R.id.llthongke);
        llngonngu = view.findViewById(R.id.llngonngu);
        lltrogiup = view.findViewById(R.id.lltrogiup);
        lldangxuat = view.findViewById(R.id.lldangxuat);
        tvtaikhoan = view.findViewById(R.id.tvtaikhoang);

        lltaikhoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), ActListUser.class));
            }
        });

        lldangxuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().notify();
            }
        });

        lltrogiup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), TroGiupActivity.class));
            }
        });

        llngonngu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), NgonNguActivity.class));
            }
        });

        llthongke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getChildFragmentManager().beginTransaction().replace(R.id.fragment_contener, new fragment_Overview());
            }
        });

        llsachban.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), SachbanActivity.class));
            }
        });

        lltheloai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), TheloaiActivity.class));
            }
        });

        llsach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), SachActivity.class));
            }
        });

        llhoadon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), HoaDonActivity.class));
            }
        });

        lldoitaikhoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), DoiTaiKhoanActivity.class));
            }
        });

        return view;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.llchonlich:

                break;
        }
    }
}
