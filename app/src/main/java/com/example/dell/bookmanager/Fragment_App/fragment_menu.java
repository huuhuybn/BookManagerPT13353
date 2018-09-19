package com.example.dell.bookmanager.Fragment_App;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dell.bookmanager.Account.DoiTaiKhoanActivity;
import com.example.dell.bookmanager.Catalog.HoaDonActivity;
import com.example.dell.bookmanager.Catalog.SachActivity;
import com.example.dell.bookmanager.Catalog.SachbanActivity;
import com.example.dell.bookmanager.Catalog.TheloaiActivity;
import com.example.dell.bookmanager.Catalog.ThongkeActivity;
import com.example.dell.bookmanager.DangKiActivity;
import com.example.dell.bookmanager.DangNhapActivity;
import com.example.dell.bookmanager.R;
import com.example.dell.bookmanager.Setting.NgonNguActivity;
import com.example.dell.bookmanager.Setting.TroGiupActivity;

public class fragment_menu extends Fragment {

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
        tvtaikhoan=view.findViewById(R.id.tvtaikhoang);

        lldangxuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().notify();
            }
        });

        lltrogiup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),TroGiupActivity.class));
            }
        });

        llngonngu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),NgonNguActivity.class));
            }
        });

        llthongke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getChildFragmentManager().beginTransaction().replace(R.id.fragment_contener,new fragment_Overview());
            }
        });

        llsachban.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),SachbanActivity.class));
            }
        });

        lltheloai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),TheloaiActivity.class));
            }
        });

        llsach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),SachActivity.class));
            }
        });

        llhoadon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),HoaDonActivity.class));
            }
        });

        lldoitaikhoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),DoiTaiKhoanActivity.class));
            }
        });

        return view;
    }


}
