package com.example.tp1;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class Llamada911 extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent.getExtras().getBoolean("connected")) {
            Intent in = new Intent(intent.ACTION_CALL).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            in.setData(Uri.parse("tel:911"));

            if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            context.startActivity(in);
        }
        else {
            Toast.makeText(context, "USB No conectado", Toast.LENGTH_LONG).show();

        }
    }
}