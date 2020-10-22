package org.tensorflow.demo;
import android.content.Intent;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

public class HomeActivity extends AppCompatActivity {

    Button classify, detect, speech, stylize,wifi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        classify = (Button) findViewById(R.id.classifyBtn);
        detect = (Button) findViewById(R.id.detectBtn);
        //speech = (Button) findViewById(R.id.speechBtn);
       // stylize = (Button) findViewById(R.id.stylizeBtn);
        wifi = (Button) findViewById(R.id.wifiBtn);

        classify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,ClassifierActivity.class));
            }
        });
        detect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,DetectorActivity.class));
            }
        });
        //speech.setOnClickListener(new View.OnClickListener() {
          //  @Override
          //  public void onClick(View view) {
          //      startActivity(new Intent(HomeActivity.this,SpeechActivity.class));
           // }
      //  });
       // stylize.setOnClickListener(new View.OnClickListener() {
        //    @Override
          //  public void onClick(View view) {
            //    startActivity(new Intent(HomeActivity.this,StylizeActivity.class));
           // }
        //});
        wifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HomeActivity.this, "Connecting to wifi", Toast.LENGTH_SHORT).show();
                //wifi code here
                String networkSSID = "Mind ov Mine";
                String networkPass = "letmein1..";

//                WifiConfiguration conf = new WifiConfiguration();
//                conf.SSID = "\"" + networkSSID + "\"";   // Please note the quotes. String should contain ssid in quotes
//                conf.wepKeys[0] = "\"" + networkPass + "\"";
//                conf.wepTxKeyIndex = 0;
//                conf.allowedKeyManagement.set(WifiConfiguration.KeyMgmt.NONE);
//                conf.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.WEP40);
//                conf.preSharedKey = "\""+ networkPass +"\"";
//                conf.allowedKeyManagement.set(WifiConfiguration.KeyMgmt.NONE);
//                WifiManager wifiManager = (WifiManager)getApplicationContext().getSystemService(Context.WIFI_SERVICE);
//                wifiManager.addNetwork(conf);
//                List<WifiConfiguration> list = wifiManager.getConfiguredNetworks();
//                for( WifiConfiguration i : list ) {
//                    if(i.SSID != null && i.SSID.equals("\"" + networkSSID + "\"")) {
//                        wifiManager.disconnect();
//                        wifiManager.enableNetwork(i.networkId, true);
//                        wifiManager.reconnect();
//                        Toast.makeText(HomeActivity.this, "Connected", Toast.LENGTH_SHORT).show();
//                        break;
//                    }
//                }
                String ssid = "Mind ov Mine";
                String key = "letmein1..";
                WifiConfiguration wifiConfig = new WifiConfiguration();
                wifiConfig.SSID = String.format("\"%s\"", ssid);
                wifiConfig.preSharedKey = String.format("\"%s\"", key);
                WifiManager wifiManager = (WifiManager)getApplicationContext().getSystemService(WIFI_SERVICE);
                int netId = wifiManager.addNetwork(wifiConfig);
                wifiManager.disconnect();
                wifiManager.enableNetwork(netId, true);
                wifiManager.reconnect();
              //  LocalOnlyHotspotCallback.onStarted(LocalOnlyHotspotReservation);

            }
        });
    }
}