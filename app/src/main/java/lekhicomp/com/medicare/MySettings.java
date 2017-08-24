package lekhicomp.com.medicare;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MySettings extends AppCompatActivity{
    ListView listView,listView2,listView3,listView4,listView5,listView6;
    ArrayList<TextSettings> userList,userList3,userList5;
    UserAdapter1 userAdapter,userAdapter3,userAdapter5;
    ArrayList<SwitchSettings> userList2,userList4,userList6;
    UserAdapter2 userAdapter2,userAdapter4,userAdapter6;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
Dialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_settings);

        preferences=getSharedPreferences("SETTINGS",MODE_PRIVATE);
        editor=preferences.edit();

        listView = (ListView) findViewById(R.id.list1);
        userList = new ArrayList<TextSettings>();
        TextSettings obj1 = new TextSettings("Date Format", "MM/DD/YYYY");
        userList.add(obj1);
        TextSettings obj2 = new TextSettings("Report Tasks as (Default)", "Notification");
        userList.add(obj2);
        TextSettings obj3 = new TextSettings("Snooze Length (Default)", "10 Minutes");
        userList.add(obj3);

        listView2 = (ListView) findViewById(R.id.list2);
        userList2 = new ArrayList<SwitchSettings>();
        SwitchSettings obj4 = new SwitchSettings("Show Weekday Name");
        userList2.add(obj4);
        userAdapter = new UserAdapter1(this, R.layout.list1, userList);
        listView.setAdapter(userAdapter);

        userAdapter2 = new UserAdapter2(this, R.layout.list2, userList2);
        listView2.setAdapter(userAdapter2);

        listView3 = (ListView) findViewById(R.id.list3);
        userList3 = new ArrayList<TextSettings>();
        TextSettings obj5 = new TextSettings("Theme", "Deep Blue");
        userList3.add(obj5);
        TextSettings obj6 = new TextSettings("Font Size", "30pt");
        userList3.add(obj6);
        userAdapter3 = new UserAdapter1(this, R.layout.list1, userList3);
     //   listView3.setAdapter(userAdapter3);

        listView4 = (ListView) findViewById(R.id.list4);
        userList4 = new ArrayList<SwitchSettings>();
        SwitchSettings obj7 = new SwitchSettings("Sounds");
        userList4.add(obj7);
        userAdapter4 = new UserAdapter2(this, R.layout.list2, userList4);
        listView4.setAdapter(userAdapter4);


        listView5 = (ListView) findViewById(R.id.list5);
        userList5 = new ArrayList<TextSettings>();
        TextSettings obj8 = new TextSettings("Notification Sound", "Charming");
        userList5.add(obj8);
        TextSettings obj9 = new TextSettings("Alarming Sound", "Morning Glory");
        userList5.add(obj9);
        userAdapter5 = new UserAdapter1(this, R.layout.list1, userList5);
        listView5.setAdapter(userAdapter5);


        listView6 = (ListView) findViewById(R.id.list6);
        userList6 = new ArrayList<SwitchSettings>();
        SwitchSettings obj10 = new SwitchSettings("Vibrations");
        userList6.add(obj10);
        userAdapter6 = new UserAdapter2(this, R.layout.list2, userList6);
        listView6.setAdapter(userAdapter6);
//listView.setOnItemClickListener(this);
//listView2.setOnItemClickListener(this);
       // listView3.setOnItemClickListener(this);
          listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
              @Override
              public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                  alertDialog();
              }
          });

    }
    public void alertDialog(){
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setTitle("Date Format");
        String [] item={"DD/MM/YYYY","YYYY/MM/DD","MM/DD/YYYY"};
        builder.setItems(item,null);
        builder.setNegativeButton("CANCEL",null);
        builder.setPositiveButton("OK",null);
        AlertDialog dialog= builder.create();
        dialog.show();
    }
    public void alertDialog2(){
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setTitle("Report Tasks as(Default)");
        String [] item={"Notification","Alarm"};
        builder.setItems(item,null);
        builder.setNegativeButton("CANCEL",null);
        builder.setPositiveButton("OK",null);
        AlertDialog dialog= builder.create();
        dialog.show();
    }
    public void alertDialog3(){
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setTitle("Snooze Length(Default)");
        String [] item={"5 Minutes","10 Minutes","15 Minutes","20 Minutes","25 Minutes","30 Minutes"};
        builder.setItems(item,null);
        builder.setNegativeButton("CANCEL",null);
        builder.setPositiveButton("OK",null);
        AlertDialog dialog= builder.create();
        dialog.show();
    }
    public void ringTone(){
        Intent intent = new Intent(RingtoneManager.ACTION_RINGTONE_PICKER);
        intent.putExtra(RingtoneManager.EXTRA_RINGTONE_TYPE,RingtoneManager.TYPE_NOTIFICATION);
        intent.putExtra(RingtoneManager.EXTRA_RINGTONE_TITLE,"Select Tone");
        intent.putExtra(RingtoneManager.EXTRA_RINGTONE_EXISTING_URI,(Uri) null);
        this.startActivityForResult(intent,5);
    }


}

