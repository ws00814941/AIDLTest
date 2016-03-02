package com.cqf.aidltest;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.cqf.aidltest.aldl.AIDLTest1;

public class MainActivity extends AppCompatActivity {
    AIDLTest1 aidl;
    AIDLConnection connection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initService();
        try {
            int a = aidl.add(10, 20);
            System.out.print(a);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    private void initService() {
        connection = new AIDLConnection();
        Intent i = new Intent();
        i.setClass(this, AIDLService.class);
        bindService(i, connection, Context.BIND_AUTO_CREATE);
    }

    class AIDLConnection implements ServiceConnection {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            aidl = AIDLTest1.Stub.asInterface(service);
            Toast.makeText(MainActivity.this, "Service connected", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            aidl = null;
            Toast.makeText(MainActivity.this, "Service disconnected", Toast.LENGTH_LONG).show();
        }
    }
}
