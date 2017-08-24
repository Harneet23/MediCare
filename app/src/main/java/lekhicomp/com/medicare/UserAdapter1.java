package lekhicomp.com.medicare;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import android.widget.TextView;



import java.util.ArrayList;

/**
 * Created by Thaman on 02-Aug-17.
 */

public class UserAdapter1  extends ArrayAdapter<TextSettings>{


        Context context;
        int resource;
        ArrayList<TextSettings> userlist;


        public UserAdapter1(Context context, int resource, ArrayList<TextSettings> objects) {
            super(context, resource, objects);
            this.context=context;
            this.resource=resource;
            this.userlist=objects;

        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view=null;

            view= LayoutInflater.from(context).inflate(resource,parent,false);
            TextView textView= (TextView)view.findViewById(R.id.textView8);
            TextView textView2= (TextView)view.findViewById(R.id.textView9);


            TextSettings user=userlist.get(position);
            textView.setText(user.getText1());
            textView2.setText(user.getText2());



            return view;
        }
    }


