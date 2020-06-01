package ru.geekbrains.broadcastsender;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final String ACTION_SEND_MSG = "ru.geekbrains.broadcastsender.message";
    private static final String NAME_MSG = "MSG";
    // Эта константа спрятана в Intent классе,
    // но именно при помощи ее можно поднять приложение
    //public static final int FLAG_RECEIVER_INCLUDE_BACKGROUND = 0x01000000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button send = findViewById(R.id.buttonSend);
        final EditText message = findViewById(R.id.textMessage);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = message.getText().toString();
                Intent intent = new Intent();
                intent.setAction(ACTION_SEND_MSG);
                intent.putExtra(NAME_MSG, msg);
                intent.addFlags(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);
                //Intent.FLAG_RECEIVER_INCLUDE_BACKGROUND
                sendBroadcast(intent);
            }
        });
    }
}