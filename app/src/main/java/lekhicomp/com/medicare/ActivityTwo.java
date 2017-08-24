package lekhicomp.com.medicare;

import android.provider.AlarmClock;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ActivityTwo extends AppCompatActivity implements TakeBuyFragment.Data {

    FragmentManager fragmentManager;
    TakeBuyFragment takeBuyFragment;
    TakeMedicine takeMedicine;
    BuyMedicine buyMedicine;
    int x = 0;

    public void initViews() {
        takeBuyFragment = new TakeBuyFragment();
        buyMedicine = new BuyMedicine();
        takeMedicine = new TakeMedicine();
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.upperFrame, takeBuyFragment).commit();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        initViews();
    }

    @Override
    public void selectFragment(boolean val) {
        if (val == true) {
            if (x == 2) {
            } else {
                x = 2;
                fragmentManager.beginTransaction().remove(takeMedicine).commit();
                fragmentManager.beginTransaction().add(R.id.lowerFrame, buyMedicine).commit();
            }

        } else {

            if (x == 1) {
            } else {
                x = 1;
                fragmentManager.beginTransaction().remove(buyMedicine).commit();
                fragmentManager.beginTransaction().add(R.id.lowerFrame, takeMedicine).commit();
            }
        }
    }
}
