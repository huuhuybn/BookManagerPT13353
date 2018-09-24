package com.example.dell.bookmanager.fragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dell.bookmanager.catalog.SachActivity;
import com.example.dell.bookmanager.R;

import java.util.Calendar;

public class fragment_addbooks extends Fragment {
    private EditText edtmasach;
    private EditText lltensach;
    private EditText edttacgia;
    private EditText edtgiasach;
    private EditText edtsoluong;
    private TextView tvlich;
    private Button btnluu;
    private Button btnhienthi;
    private EditText edtthongbao;
    private LinearLayout llchonlich;
    private ImageView xoatrang;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

      View view=inflater.inflate(R.layout.fragment_books,container,false);

        edtmasach = (EditText) view.findViewById(R.id.edtmasach);
        lltensach = view.findViewById(R.id.edttensach);
        edttacgia = (EditText) view.findViewById(R.id.edttacgia);
        edtgiasach = (EditText) view.findViewById(R.id.edtgiasach);
        edtsoluong = (EditText) view.findViewById(R.id.edtsoluong);
        tvlich = (TextView) view.findViewById(R.id.tvlich);
        btnluu = (Button) view.findViewById(R.id.btnluu);
        btnhienthi = (Button) view.findViewById(R.id.btnhienthi);
        edtthongbao=view.findViewById(R.id.edtthongbao);
        llchonlich=view.findViewById(R.id.llchonlich);
        xoatrang=view.findViewById(R.id.xoatrang);

        btnluu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String masach=edtmasach.getText().toString();
                String tensach=lltensach.getText().toString();
                String tacgia=edttacgia.getText().toString();
                String soluong=edtsoluong.getText().toString();

                if (masach.equals("") && tensach.equals("") &&tacgia.equals("") && soluong.equals("")){
                    edtthongbao.setError(getString(R.string.khongduocdetrong));
                }

                else {
                        //xu lý luu

                    String thongbao=getString(R.string.xuathoadon);
                    Toast.makeText(getActivity(),""+thongbao,Toast.LENGTH_SHORT).show();

                }
            }
        });

        btnhienthi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),SachActivity.class));
            }
        });

        llchonlich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal=Calendar.getInstance();
                int Year =cal.get(Calendar.YEAR);
                int Month=cal.get(Calendar.MONTH);
                int Day=cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog date=new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        String stringOfDate = "Ngày "+dayOfMonth + "/" + month + "/" + year;
                        tvlich.setText(tvlich.getText() + "\n " + stringOfDate);

                    }

                }, Year, Month, Day);

                date.show();
            }
        });

        xoatrang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtmasach.setText("");
                edttacgia.setText("");
                edtsoluong.setText("");
                lltensach.setText("");
                edtgiasach.setText("");

            }
        });





        return view;
    }
}
