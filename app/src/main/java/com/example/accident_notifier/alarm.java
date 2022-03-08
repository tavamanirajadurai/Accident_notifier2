package com.example.accident_notifier;



import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.widget.Toast;
import com.example.accident_notifier.R;

public class alarm extends AppCompatActivity {
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        play_media();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                play_media();

                String number= "9360064984";
                String msg="i am in need of help" +
                        " name: raja\nvehicle no: TN 1111 ";
                try {
                    SmsManager smsManager= SmsManager.getDefault();
                    smsManager.sendTextMessage(number,null,msg,null,null);
                    Toast.makeText(getApplicationContext(),"Message Sent",Toast.LENGTH_LONG).show();
                }catch (Exception e)
                {

                    Toast.makeText(getApplicationContext(),""+e,Toast.LENGTH_LONG).show();
                }
                AlertDialog dig;
                dig = new AlertDialog.Builder(alarm.this)
                        .setTitle("Alert !!!")
                        .setMessage("Driver needs help...!, Touch OK to Stop the Alarm")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                stop_playing();

                            }
                        }).setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
                dig.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        stop_playing();

                    }
                });
            }
        });


    }
    public void play_media()
    {
        stop_playing();
        mp = MediaPlayer.create(this, R.raw.alarm);
        mp.start();
    }
    public void stop_playing()
    {
        if (mp != null) {
            mp.stop();
            mp.release();
            mp = null;
        }
    }
}
