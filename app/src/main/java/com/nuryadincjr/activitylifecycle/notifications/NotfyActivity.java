package com.nuryadincjr.activitylifecycle.notifications;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
    private static final String CHANNEL_ID = "0";
    private static final int NOTIFICATION_ID = 0;
    NotificationManagerCompat notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notfy);

        binding = ActivityNotfyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        createNotificationChannel();

        notificationManager = NotificationManagerCompat.from(this);

        setBtnFocuse(true, false, false);

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

    public void sendNotification() {
        notificationData("Nuryadin Abutani", "Notifikasi baru");
    }

    public void updateNotification() {
        notificationData("tes", "Notifikasi update");
    }

    public void cancelNotification() {
        notificationManager.cancel(NOTIFICATION_ID);
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.app_name);
            String description = getString(R.string.app_name);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
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

}