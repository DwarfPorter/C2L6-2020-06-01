package ru.geekbrains.brodcastreceiver;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.core.app.NotificationCompat;

public class MessageReceiver extends BroadcastReceiver {
    private static final String NAME_MSG = "MSG";
    private static final String TAG = "[MessageBroadcastReceiver]";

    @Override
    public void onReceive(Context context, Intent intent) {
        String message = intent.getStringExtra(NAME_MSG);
        if (message == null){
            message = "Null";
        }
        Log.d(TAG, message);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, MainActivity.CHANNEL_ID)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Broadcast Receiver")
                .setContentText(message);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1, builder.build());
    }
}
