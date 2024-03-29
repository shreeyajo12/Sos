package com.example.sos;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
public class DraftSms extends AppCompatActivity {
    Button sendBtn, safeBtn;
    EditText txtphoneNo;
    EditText txtMessage;
    Toolbar Toolbar;
    public static final String MyPREFERENCES = "MyPrefs";
    String sms;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_sms);

        sendBtn = (Button) findViewById(R.id.btnalert);
        safeBtn = (Button) findViewById(R.id.btnsafe);
        txtphoneNo = (EditText) findViewById(R.id.editText1);
        txtMessage = (EditText) findViewById(R.id.editText2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.view);
        // setSupportActionBar(toolbar);


//        sendBtn.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View view) {
//                sendSMSMessage();
//            }
//        });
    }

    /*public void sendSMSMessage() {
        Log.i("Send SMS", "");
        //String phoneNo = txtphoneNo.getText().toString();
        SharedPreferences sharedpreferences = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE);
        SharedPreferences sharedpreferences1 = getSharedPreferences("Emergency_Contacts", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences1.edit();
        sms = (sharedpreferences1.getString("Safetymsg",null));
        //Toast.makeText(getApplicationContext(),sms,Toast.LENGTH_LONG).show();
        /*for(int i=0;i<5;i++){
        try {
            phoneNo = sharedpreferences.getString("phno"+i, phoneNo);
            SmsManager smsManager = SmsManager.getDefault();
            if(message.isEmpty())
            {smsManager.sendTextMessage(phoneNo, null, sms, null, null);}
            else
            {smsManager.sendTextMessage(phoneNo, null, message, null, null);}
            Toast.makeText(getApplicationContext(), "SMS sent.", Toast.LENGTH_LONG).show();
            }
        catch (Exception e) {
            Toast.makeText(getApplicationContext(), "SMS failed, please try again.", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
        }
    }*/
    public void safeClick(View view) {
        SharedPreferences sharedpreferences = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        String message = txtMessage.getText().toString();
        editor.putString("Safetymsg", message);
        editor.commit();
        Toast.makeText(this, "Your Message is stored !", Toast.LENGTH_LONG).show();
    }

    public void alertClick(View view) {

        //Log.i("Send SMS", "");
        //String phoneNo = txtphoneNo.getText().toString();
        SharedPreferences sharedpreferences = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        String message = txtMessage.getText().toString();
        editor.putString("Alertmsg", message);
        editor.commit();
        Toast.makeText(this, "Your Message is stored !", Toast.LENGTH_LONG).show();

        //String alert = (sharedpreferences.getString("Alertmsg", null));
        /*try{
        //SmsManager smsManager = SmsManager.getDefault();
        //smsManager.sendTextMessage(phoneNo, null, alert, null, null);
        //Toast.makeText(getApplicationContext(), "Alert SMS sent.", Toast.LENGTH_LONG).show();
           }
        catch (Exception e) {
            Toast.makeText(getApplicationContext(), "SMS failed, please try again.", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}