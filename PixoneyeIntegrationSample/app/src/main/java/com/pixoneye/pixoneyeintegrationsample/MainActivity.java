package com.pixoneye.pixoneyeintegrationsample;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.pixoneye.pixoneyesdk.Campaign;
import com.pixoneye.pixoneyesdk.GetBestItemListener;
import com.pixoneye.pixoneyesdk.GetBestItemsListener;
import com.pixoneye.pixoneyesdk.Pixoneye;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity
{
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private static final String PIXONEYE_API_KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhcHBJRCI6InBpeG9uZXllLXNhbXBsZS1hcHAiLCJ0b2tlblJvbGUiOiJzZGstY3VzdG9tZXIiLCJ0b2tlblR5cGUiOiJyZWZyZXNoLXRva2VuIiwia2V5VmVyc2lvbiI6InYyIiwiaWF0IjoxNDk5NjAxMDY0fQ.vT34obwtGKDCgQ7oiJCECtteoCovlYBkIvehOJTLuQ0";
    private static final String PIXONEYE_APP_ID = "pixoneye-sample-app";
    private static final String AD_UNIT_ID = "146351541";

    private static final int PERMISSION_REQUEST_CODE = 0x100;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(LOG_TAG, "onCreate(), Pixoneye version: " + Pixoneye.getVersion());
        if (checkPermission()) // Pixoneye require Read external storage permission.
        {
            startPixoneye(); // Start Pixoneye
        }
        else
        {
            requestPermission();
        }

        findViewById(R.id.get_best_campaign).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                getBestCampaign();
            }
        });

        findViewById(R.id.get_best_campaigns).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                getBestCampaigns();
            }
        });
    }

    private void startPixoneye()
    {
        //Enables pixoneye logs.
        Pixoneye.setVerbose(true);

        //Start pixoneye process
        Pixoneye.startPixoneye(MainActivity.this, PIXONEYE_APP_ID, PIXONEYE_API_KEY, "");
    }



    private boolean checkPermission()
    {
        if (Build.VERSION.SDK_INT < 23)
        {
            return true;
        }
        int result = ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE);
        return result == PackageManager.PERMISSION_GRANTED;
    }

    private void requestPermission()
    {
        if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, android.Manifest.permission.READ_EXTERNAL_STORAGE))
        {
            Toast.makeText(MainActivity.this, " Please allow accesses to external storage  this permission in App Settings.", Toast.LENGTH_LONG).show();
        }
        else
        {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == PERMISSION_REQUEST_CODE)
        {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {
                    startPixoneye(); // User gave permmision - Start Pixoneye.
                }
        }
    }

    public void getBestCampaign()
    {
        Pixoneye.getBestItem(MainActivity.this, PIXONEYE_API_KEY, PIXONEYE_APP_ID, AD_UNIT_ID, new GetBestItemListener() {
            @Override
            public void onResult(@Nullable String s)
            {
                Log.d(LOG_TAG, "onResult(), Got best campaign: " + s);
            }
        });
    }

    public void getBestCampaigns()
    {
        // List of ad units id. - optional without the list the all units defined
        // in Pixoneye server will be return.
        ArrayList<String> adUnits = new ArrayList<>();

        Pixoneye.getBestItems(MainActivity.this, PIXONEYE_API_KEY, PIXONEYE_APP_ID, adUnits, new GetBestItemsListener() {
            @Override
            public void onResult(@NonNull HashMap<String, Campaign> hashMap)
            {
                Log.d(LOG_TAG, "onResult(), Got best Items for list of Ad units.");
            }
        });
    }
}
