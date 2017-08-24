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

public class UserAdapter2 extends ArrayAdapter<SwitchSettings> {


    Context context;
    int resource;
    ArrayList<SwitchSettings> userlist;


    public UserAdapter2(Context context, int resource, ArrayList<SwitchSettings> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.userlist=objects;

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view=null;

        view= LayoutInflater.from(context).inflate(resource,parent,false);
        TextView textView= (TextView)view.findViewById(R.id.textView11);


        SwitchSettings user=userlist.get(position);
        textView.setText(user.getText());




        return view;
    }
}
