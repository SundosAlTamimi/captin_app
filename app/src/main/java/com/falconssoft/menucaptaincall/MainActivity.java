package com.falconssoft.menucaptaincall;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
//    final Handler hafndler = new Handler();
    private TextView co;
//    NotificationManager notificationManager;
//    static int id=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_list_activaty);
//
//        co = (TextView) findViewById(R.id.ac);

        startService(new Intent(MainActivity.this, MyService.class));
//        startServerSocket();

    }


//    private void notification (String detail){
//
//        NotificationCompat.Builder nbuilder=new NotificationCompat.Builder(MainActivity.this)
//                .setContentTitle("Call Captain Notification ......")
//                .setContentText(detail)
//                .setDefaults(Notification.DEFAULT_ALL)
//                .setSmallIcon(R.drawable.burger);
//
//        notificationManager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
//
//        notificationManager.notify(id,nbuilder.build());
//        id++;
//
//    }


//    private void startServerSocket() {
////        getipAddress();
////        getIPAddress(true);
//
//        Thread thread = new Thread(new Runnable() {
//
//            private String stringData =null;
//
//
//            @Override
//            public void run() {
//
//                try {
//
//                    ServerSocket ss = new ServerSocket(9008);
//
//                    while (true) {
//                        //Server is waiting for client here, if needed
//                        Socket s = ss.accept();
//                        BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
//                        PrintWriter output = new PrintWriter(s.getOutputStream());
//
//
//                        stringData = input.readLine();
//                        Log.e("data come :"," "+stringData);
////                        output.println("FROM SERVER - " + stringData.toUpperCase()+"more rawan ");
////                        output.flush();
//
//
////                        for(int i=0;i<TABLE.length;i++){
////
//
//
//                            String[] TABLE=stringData.split(",");
//
//
//                            String table=TABLE[0].substring(TABLE[0].indexOf(" "));
//                            String sec=TABLE[1].substring(TABLE[1].indexOf(" "));
//                            String site=TABLE[2].substring(TABLE[2].indexOf(" "));
//
//                            notification("Table No : "+table+"   "+"section No : "+sec+"    "+"site No : "+site+"   ");
//
//
////                        }
//
//                        try {
//                            Thread.sleep(1000);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                        updateUI(stringData);
//                        if (stringData.equalsIgnoreCase("STOP")) {
////                            end = true;
//                            output.close();
//                            s.close();
//                            break;
//                        }
//
//                        output.close();
//                        s.close();
//                    }
//                    ss.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//
//        });
//        thread.start();
//    }
//
//    private void updateUI(final String stringData) {
//
//        handler.post(new Runnable() {
//            @SuppressLint("SetTextI18n")
//            @Override
//            public void run() {
//
//                String s = co.getText().toString();
//                if (stringData.trim().length() != 0){
//
//                    String[] TABLE=stringData.split(",");
//
//
//                String table=TABLE[0].substring(TABLE[0].indexOf(" "));
//                String sec=TABLE[1].substring(TABLE[1].indexOf(" "));
//                String site=TABLE[2].substring(TABLE[2].indexOf(" "));
//
//                co.setText("Table #="+table+"\n"+"sec # ="+sec+"\n"+"site ="+site+"\n");}
//
////                co.setText(s + "\n" + "From Client : " + stringData);
//            }
//        });
//    }
//



}
