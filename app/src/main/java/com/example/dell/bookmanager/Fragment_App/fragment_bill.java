package com.example.dell.bookmanager.Fragment_App;

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
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dell.bookmanager.Catalog.TheloaiActivity;
import com.example.dell.bookmanager.R;

import java.util.Calendar;

public class fragment_bill extends Fragment {
    private EditText edtmahoadon;
    private EditText edtgia;
    private LinearLayout llchontheloai;
    private LinearLayout lllich;
    private Button btnxacnhan;
    private TextView tv;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_bill,container,false);

        edtmahoadon = (EditText) view.findViewById(R.id.edtmahoadon);
        edtgia = (EditText) view.findViewById(R.id.edtgia);
        llchontheloai = (LinearLayout) view.findViewById(R.id.llchontheloai);
        lllich = (LinearLayout) view.findViewById(R.id.lllich);
        btnxacnhan = (Button) view.findViewById(R.id.btnxacnhan);
        tv=view.findViewById(R.id.tv);


        btnxacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mahoadon=edtmahoadon.getText().toString();
                String gia=edtgia.getText().toString();

                if (mahoadon.equals("")){
                    edtmahoadon.setError(getString(R.string.chuanhapma));
                }
                if (gia.equals("")){
                    edtmahoadon.setError(getString(R.string.chuanhapgia));
                }

                else if (!mahoadon.equals("")&&!gia.equals("")){


                    //sử lý đăng xác nhận

                    String thongbao=getString(R.string.xuathoadon);
                    Toast.makeText(getActivity(),""+thongbao,Toast.LENGTH_SHORT).show();
                }
            }
        });

        llchontheloai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),TheloaiActivity.class));

                //su ly chon the loai
            }
        });

        lllich.setOnClickListener(new View.OnClickListener() {
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
                        tv.setText(tv.getText() + "\n " + stringOfDate);

                    }

                }, Year, Month, Day);

                date.show();
            }
        });

        return view;
    }
}
