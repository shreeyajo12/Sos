package com.example.sos;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

//This activity provides the navigation drawer and emergency buttons such as the send alert msg, send safety msg and show my location.
        public class MainActivity extends AppCompatActivity
{
    public static final String MyPREFERENCES = "MyPrefs";
    private android.util.Log Log;
    private String msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //android.support.v7.app.ActionBar bar = getSupportActionBar();
// bar.setBackgroundDrawable(new ColorDrawable(""));
        // ColorDrawable colorDrawable = new ColorDrawable(Color.rgb(179,0,0));
        //   bar.setBackgroundDrawable(colorDrawable);


        //To send alert msg
        /*public void Msg(View view) {
        Log.i("Send SMS", "");
        String phoneNo = txtphoneNo.getText().toString();
        SharedPreferences sharedpreferences = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE);
        String alert = (sharedpreferences.getString("Alertmsg", null));
        try{
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNo, null, alert, null, null);
            Toast.makeText(getApplicationContext(), "Alert SMS sent.", Toast.LENGTH_LONG).show();
        }
        catch (Exception e) {
            Toast.makeText(getApplicationContext(), "SMS failed, please try again.", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }*/

        //on click of send alert msg button, this method is called.
        public void onAlertClick (View v)
        {

            SharedPreferences sharedpreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
            String Alertmsg = sharedpreferences.getString("Alertmsg", "Help");
            sendSms(Alertmsg);
        }
        //on click of send safety msg button, this method is called.
        public void onSafeClick (View view)
        {

            SharedPreferences sharedpreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
            String Alertmsg = sharedpreferences.getString("Safetymsg", "Reached safely");
            sendSms(Alertmsg);
        }

        //this method is used to shoot sms
        public void sendSms( String msg);
        {
            SharedPreferences sharedpreferences = getSharedPreferences("Emergency_Numbers", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedpreferences.edit();
            int size_of_emergency_contacts = sharedpreferences.getAll().size();
            int j = 0;
            try {
                SmsManager smsManager = SmsManager.getDefault();
                while (size_of_emergency_contacts > 0) {
                    String phoneNo = sharedpreferences.getString("phno" + j, "9869105188");
                    j++;
                    smsManager.sendTextMessage(phoneNo, null, msg, null, null);
                    Toast.makeText(getApplicationContext(), "SMS sent.", Toast.LENGTH_LONG).show();
                    size_of_emergency_contacts--;
                }
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), "SMS failed, please try again.", Toast.LENGTH_LONG).show();
                e.printStackTrace();
            }

        }
    }

    private void sendSms(String alertmsg) {

    }

}