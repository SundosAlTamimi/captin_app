package com.falconssoft.menucaptaincall;


import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Rawan on 2019.
 */

public class MyService extends Service {
    //creating a mediaplayer object
    Timer T;
    NotificationManager notificationManager;
    static int id=1;
    final Handler handler = new Handler();
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        T = new Timer();

        T.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
Log.e("My call caption ....","table ");
                startServerSocket();

            }
        }, 10000, 3000);

        //START_REDELIVER_INTENT

        return START_STICKY;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        //stopping the player when service is destroyed

    }



    public void message() {
        Toast.makeText(MyService.this, "is send succ", Toast.LENGTH_SHORT).show();

    }

    private void startServerSocket() {
//        getipAddress();
//        getIPAddress(true);

        Thread thread = new Thread(new Runnable() {

            private String stringData =null;


            @Override
            public void run() {

                try {

                    ServerSocket ss = new ServerSocket(9008);

                    while (true) {
                        //Server is waiting for client here, if needed
                        Socket s = ss.accept();
                        BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
                        PrintWriter output = new PrintWriter(s.getOutputStream());


                        stringData = input.readLine();
                        Log.e("data come :"," "+stringData);
//                        output.println("FROM SERVER - " + stringData.toUpperCase()+"more rawan ");
//                        output.flush();


//                        for(int i=0;i<TABLE.length;i++){
//


                        String[] TABLE=stringData.split(",");


                        String table=TABLE[0].substring(TABLE[0].indexOf(" "));
                        String sec=TABLE[1].substring(TABLE[1].indexOf(" "));
                        String site=TABLE[2].substring(TABLE[2].indexOf(" "));

                        notification("Table No : "+table+"   "+"section No : "+sec+"    "+"site No : "+site+"   ");


//                        }

                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        updateUI(stringData);
                        if (stringData.equalsIgnoreCase("STOP")) {
//                            end = true;
                            output.close();
                            s.close();
                            break;
                        }

                        output.close();
                        s.close();
                    }
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        });
        thread.start();
    }

    private void updateUI(final String stringData) {

        handler.post(new Runnable() {
            @SuppressLint("SetTextI18n")
            @Override
            public void run() {

//                String s = co.getText().toString();
                if (stringData.trim().length() != 0){

                    String[] TABLE=stringData.split(",");


                    String table=TABLE[0].substring(TABLE[0].indexOf(" "));
                    String sec=TABLE[1].substring(TABLE[1].indexOf(" "));
                    String site=TABLE[2].substring(TABLE[2].indexOf(" "));

//                    co.setText("Table #="+table+"\n"+"sec # ="+sec+"\n"+"site ="+site+"\n");
                }

//                co.setText(s + "\n" + "From Client : " + stringData);
            }
        });
    }

    private void notification (String detail){

        NotificationCompat.Builder nbuilder=new NotificationCompat.Builder(MyService.this)
                .setContentTitle("Call Captain Notification ......")
                .setContentText(detail)
                .setDefaults(Notification.DEFAULT_ALL)
                .setSmallIcon(R.drawable.burger);

        notificationManager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(id,nbuilder.build());
        id++;

    }


}