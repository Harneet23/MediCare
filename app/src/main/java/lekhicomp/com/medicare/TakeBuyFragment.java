package lekhicomp.com.medicare;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.icu.text.SelectFormat;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class TakeBuyFragment extends Fragment implements View.OnClickListener {
    Button btnTake;
    Button btnBuy;
    TextView txtDebug;


    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.buttonBuy) {
            btnBuy.setTextColor(Color.parseColor("#f5171e"));
            btnTake.setTextColor(Color.parseColor("#FF000000"));
            ref.selectFragment(true);
        }
        else{
            btnTake.setTextColor(Color.parseColor("#f5171e"));
            btnBuy.setTextColor(Color.parseColor("#FF000000"));
            ref.selectFragment(false);
        }
    }

    public interface Data {
        void selectFragment(boolean val);
    }

    Data ref;

    public TakeBuyFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //super.onCreate(savedInstanceState);
        View view=inflater.inflate(R.layout.fragment_take_buy, container,false);
        txtDebug = view.findViewById(R.id.textDebug);
        btnBuy = view.findViewById(R.id.buttonBuy);
        btnTake = view.findViewById(R.id.buttonTake);
        btnBuy.setOnClickListener(this);
        btnTake.setOnClickListener(this);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        ref = (Data) context;
    }

}
