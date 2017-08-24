package lekhicomp.com.medicare;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;

public class BuyMedicine extends Fragment implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {
    EditText txtName;
    EditText txtAmount;
    EditText txtDoze;
    RadioButton rbTablet;
    RadioButton rbSyrup;
    Button btnAddBuy;

    public BuyMedicine() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_buy_medicine, container, false);
        txtAmount = view.findViewById(R.id.editTextAmount);
        txtDoze = view.findViewById(R.id.editTextDoze);
        txtName = view.findViewById(R.id.editTextName);
        rbTablet = view.findViewById(R.id.radioButtonTab);
        rbSyrup = view.findViewById(R.id.radioButtonSyrup);
        btnAddBuy = view.findViewById(R.id.buttonAdd);
        rbTablet.setOnCheckedChangeListener(this);
        rbSyrup.setOnCheckedChangeListener(this);
        btnAddBuy.setOnClickListener(this);
        return view;
    }


    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        int id = compoundButton.getId();
        switch (id) {
            case R.id.radioButtonTab:
                txtAmount.setHint("Enter Amount of Medicine");
                break;
            case R.id.radioButtonSyrup:
                txtAmount.setHint("Enter Number of Tablets bought");
                break;
        }
    }

    @Override
    public void onClick(View view) {
        String medName = txtName.getText().toString();
        String medAmt = txtAmount.getText().toString();
        String medDoze = txtDoze.getText().toString();
        String type;
        if (rbSyrup.isChecked())
            type = "S";
        else
            type = "T";
    }

}
