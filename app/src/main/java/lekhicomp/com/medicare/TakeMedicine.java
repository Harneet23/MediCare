package lekhicomp.com.medicare;


import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.support.v4.app.AlarmManagerCompat;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 */
public class TakeMedicine extends Fragment implements View.OnClickListener {
    EditText txtName;
    TextView txtTime;
    TextView txtDate;
    Button setAlarm;
    AlarmManager alarmManager;
    PendingIntent pendingIntent;
    int hour, minute,day,month, year;
    long timeMil=0;
    String ampm="AM";
TimePicker timePicker;
    public TakeMedicine() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_take_medicine, container, false);
        txtDate = view.findViewById(R.id.buttonDate);
        txtName = view.findViewById(R.id.editTakeName);
        txtTime = view.findViewById(R.id.buttonTime);
        setAlarm = view.findViewById(R.id.buttonSetAlarm);
        alarmManager = (AlarmManager) getActivity().getSystemService(Context.ALARM_SERVICE);


        final Intent intent = new Intent(getActivity(), AlarmReceiver.class);

        txtTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Calendar mcurrentTime = Calendar.getInstance();
                hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        hour=timePicker.getCurrentHour();
                        minute=timePicker.getCurrentMinute();
                        txtTime.setText("Time: "+selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, true);
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();
            }
        });


        txtDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Calendar mcurrentDate = Calendar.getInstance();
                day = mcurrentDate.get(Calendar.DAY_OF_MONTH);
                month = mcurrentDate.get(Calendar.MONTH);
                year = mcurrentDate.get(Calendar.YEAR);
                DatePickerDialog datePicker;
                datePicker = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int selectedDay, int selectedMonth, int selectedYear) {
                        day =datePicker.getDayOfMonth();
                        month =datePicker.getMonth();
                        year =datePicker.getYear();
                        txtDate.setText("Date: "  +day + " / " + (month+1) + " / " + year);
                    }

                }, year, month, day);
                datePicker.setTitle("Select Time");
                datePicker.show();
            }
        });


        setAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String medName = txtName.getText().toString();
                txtName.setText("");
                Calendar calendar=Calendar.getInstance();
                calendar.set(Calendar.DAY_OF_MONTH,day);
                calendar.set(Calendar.MONTH,month);
                calendar.set(Calendar.YEAR,year);
                calendar.set(Calendar.HOUR_OF_DAY,hour);
                calendar.set(Calendar.MINUTE,minute);

                timeMil=calendar.getTimeInMillis();
                timeMil-=60000;

                pendingIntent = PendingIntent.getBroadcast(getActivity(), 100, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                alarmManager.set(AlarmManager.RTC_WAKEUP, timeMil, pendingIntent);

                Toast toast = new Toast(getActivity());
                toast.setGravity(Gravity.CENTER,50,50);
                toast.makeText(getActivity(), "Alarm Set Successfully!!   Time:"+timeMil, Toast.LENGTH_SHORT).show();
                toast.makeText(getActivity(), "Day:"+day, Toast.LENGTH_SHORT).show();
                toast.makeText(getActivity(), "Month:"+month, Toast.LENGTH_SHORT).show();
                toast.makeText(getActivity(), "Year:"+year, Toast.LENGTH_SHORT).show();
                toast.makeText(getActivity(), "Hour:"+hour, Toast.LENGTH_SHORT).show();
                toast.makeText(getActivity(), "Min:"+minute, Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }


    @Override
    public void onClick(View view) {

    }
}
