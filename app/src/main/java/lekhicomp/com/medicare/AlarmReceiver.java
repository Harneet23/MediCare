package lekhicomp.com.medicare;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;


public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "BroadCast Receiver Working!!", Toast.LENGTH_SHORT).show();

        Intent service_intent=new Intent(context,RingtonePlayingService.class);
        context.startService(service_intent);

            }
}
