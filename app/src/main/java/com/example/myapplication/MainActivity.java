package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import java.util.Calendar;



public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText selectDate,selectDate1;
    private int mYear, mMonth, mDay;
    private int indexOfMyView = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        selectDate=(EditText)findViewById(R.id.OneCq1edit);
        selectDate1=(EditText)findViewById(R.id.OneCq2edit);
        selectDate.setOnClickListener(this);
        selectDate1.setOnClickListener(this);
        final Button buttonNext = (Button) findViewById(R.id.btAnnulerGar);
        final Button buttonBack = (Button) findViewById(R.id.btConfirmerGar);

        // Les boutons de navigations

        buttonNext.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                RelativeLayout layout = (RelativeLayout) findViewById(R.id.Frame);

                if (indexOfMyView < layout.getChildCount()-1) {
//
                    View child = layout.getChildAt(indexOfMyView);
                    child.setVisibility(View.INVISIBLE);

                    child = layout.getChildAt(indexOfMyView + 1);
                    child.setVisibility(View.VISIBLE);
                    indexOfMyView = indexOfMyView + 1;
                }

            }
        });

        buttonBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                RelativeLayout layout = (RelativeLayout) findViewById(R.id.Frame);

                if (indexOfMyView > 0) {
                    View child = layout.getChildAt(indexOfMyView);
                    child.setVisibility(View.INVISIBLE);

                    child = layout.getChildAt(indexOfMyView - 1);
                    child.setVisibility(View.VISIBLE);
                    indexOfMyView = indexOfMyView - 1;
                }

            }
        });

    }

    @Override
    public void onClick(View view) {
        if (view == selectDate || view == selectDate1 ) {
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            selectDate.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            selectDate1.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
    }



}
