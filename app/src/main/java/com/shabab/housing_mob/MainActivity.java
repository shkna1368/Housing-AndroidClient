package com.shabab.housing_mob;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
Button btnRegister,btnHouses,btnShare;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRegister= (Button) findViewById(R.id.btnRegister);
        btnHouses= (Button) findViewById(R.id.btnHouses);
        btnShare= (Button) findViewById(R.id.btnShare);



        btnHouses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
startActivity(new Intent(MainActivity.this,HouseActivity.class));
            }
        });

   btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,RegisterActivity.class));

            }
        });

   btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
sendApp();
            }
        });



    }
    private void sendApp(){
        PackageManager pm = getPackageManager();

        ApplicationInfo appInfo;
        try {
            appInfo = pm.getApplicationInfo("com.shabab.housing_mob", PackageManager.GET_META_DATA);

            Intent sendBt = new Intent(Intent.ACTION_SEND);

            // NOT THIS! sendBt.setType("application/vnd.android.package-archive");
            sendBt.setType("application/zip");

            sendBt.putExtra(Intent.EXTRA_STREAM,
                    Uri.parse("file://" + appInfo.publicSourceDir));

          /*      sendBt.setClassName("com.android.bluetooth",
                        "com.android.bluetooth.opp.BluetoothOppLauncherActivity");*/

            startActivity(sendBt);
        } catch (PackageManager.NameNotFoundException e1) {
            e1.printStackTrace();

        }
    }
}
