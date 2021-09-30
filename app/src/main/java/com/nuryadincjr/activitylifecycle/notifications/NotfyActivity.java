package com.nuryadincjr.activitylifecycle.notifications;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.nuryadincjr.activitylifecycle.R;
import com.nuryadincjr.activitylifecycle.activityLifecycle.MainActivity;
import com.nuryadincjr.activitylifecycle.databinding.ActivityNotfyBinding;

public class NotfyActivity extends AppCompatActivity {

    private ActivityNotfyBinding binding;
    private static final String CHANNEL_ID = "primary_notification_channel";
    private static final int NOTIFICATION_ID = 0;
    private NotificationManager notificationManager;

    private static final String ACTION_UPDATE_NOTIFICATION =
            "com.example.android.notifyme.ACTION_UPDATE_NOTIFICATION";

    private NotificationReceiver mReceiver = new NotificationReceiver();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notfy);

        binding = ActivityNotfyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        createNotificationChannel();

        setBtnFocuse(true, false, false);

        registerReceiver(mReceiver,new IntentFilter(ACTION_UPDATE_NOTIFICATION));

        binding.btnNotify.setOnClickListener(view -> {
            sendNotification();
            setBtnFocuse(false, true, true);
        });

        binding.btnUpdate.setOnClickListener(view -> {
            updateNotification();
            setBtnFocuse(false, false, true);
        });

        binding.btnCencel.setOnClickListener(view -> {
            cancelNotification();
            setBtnFocuse(true, false, false);
        });
    }

    @Override
    protected void onDestroy() {
        unregisterReceiver(mReceiver);
        super.onDestroy();
    }

    public void sendNotification() {
        Intent updateIntent = new Intent(ACTION_UPDATE_NOTIFICATION);
        PendingIntent updatePendingIntent = PendingIntent.getBroadcast
                (this, NOTIFICATION_ID, updateIntent,
                        PendingIntent.FLAG_IMMUTABLE);



        getNotificationBuilder().addAction(R.drawable.author, "Update Notification",
                updatePendingIntent);
        notificationManager.notify(NOTIFICATION_ID, getNotificationBuilder().build());
    }

    public void updateNotification() {
        notificationData("tes", "Notifikasi update");
    }

    public void cancelNotification() {
        notificationManager.cancel(NOTIFICATION_ID);
    }

    private void createNotificationChannel() {
        notificationManager = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID,
                    getString(R.string.app_name), NotificationManager.IMPORTANCE_HIGH);

            channel.enableLights(true);
            channel.setLightColor(Color.RED);
            channel.enableVibration(true);
            channel.setDescription("Notification from Apps");
            notificationManager.createNotificationChannel(channel);        }
    }

    public Bitmap bitmap(int img) {
        return BitmapFactory.decodeResource(getResources(), img);
    }

    public void notificationData(String title, String text) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, NOTIFICATION_ID,
                intent, PendingIntent.FLAG_IMMUTABLE);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_notify)
                .setContentTitle(title)
                .setContentText(text)
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText(text))
                .setStyle(new NotificationCompat.BigPictureStyle()
                        .bigPicture(bitmap(R.drawable.author))
                        .bigPicture(bitmap(R.drawable.author)))
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_MAX)
                .setDefaults(NotificationCompat.DEFAULT_ALL);

        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }

    public void setBtnFocuse(boolean b1, boolean b2, boolean b3) {
        binding.btnNotify.setEnabled(b1);
        binding.btnUpdate.setEnabled(b2);
        binding.btnCencel.setEnabled(b3);
    }

    private NotificationCompat.Builder getNotificationBuilder(){
        NotificationCompat.Builder notifyBuilder = new
                NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle("You've been notified!")
                .setContentText("This is your notification text.")
                .setSmallIcon(R.drawable.author);
        return notifyBuilder;
    }

    public class NotificationReceiver extends BroadcastReceiver {

        public NotificationReceiver() {
        }

        @Override
        public void onReceive(Context context, Intent intent) {
            updateNotification();
        }
    }
}