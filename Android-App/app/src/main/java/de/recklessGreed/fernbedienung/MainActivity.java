package de.recklessGreed.fernbedienung;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

import java.net.URISyntaxException;

public class MainActivity extends AppCompatActivity {

    Button btn_ard;
    Button btn_zdf;
    Button btn_p7;

    Button btn_nick;
    Button btn_disney;
    Button btn_maxx;

    Button btn_zander;
    Button btn_sport1;
    Button btn_keiz;

    Button btn_earli;
    Button btn_gdq;
    Button btn_rbtv;

    Button btn_nflnetwork;
    Button btn_twitch;
    Button btn_netflix;

    Button btn_yt_add;
    Button btn_yt_start;
    Button btn_yt_skip;

    EditText editText_twitch;
    EditText editText_yt;

    private Socket mSocket;
    {
        try {
            mSocket = IO.socket("http://recklessGreed.de:1234");
            Log.i("IO Socket", "IO socket Connected to");
        } catch (URISyntaxException e) {
            Log.e("IO Socket Error", "URISyntaxException");
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent receivedIntent = getIntent();
        //get the action
        String receivedAction = receivedIntent.getAction();
        //find out what we are dealing with
        String receivedType = receivedIntent.getType();

        //make sure it's an action and type we can handle
        if(receivedAction.equals(Intent.ACTION_SEND)){
            //get the received text
            String receivedText = receivedIntent.getStringExtra(Intent.EXTRA_TEXT);

            //check we have a string
            if (receivedText != null) {
                //set the text
                if (receivedText.contains("netflix")) {
                    editText_twitch.setText(receivedText.split("www.")[1].split("source")[0]);
                }
                else if (receivedText.contains("you")) {
                    editText_yt.setText(receivedText);
                }
                else if (receivedText.contains("nfl")) {
                    editText_twitch.setText(receivedText);
                }

            }
        }
        else if(receivedAction.equals(Intent.ACTION_MAIN)){
            //app has been launched directly, not from share list
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_ard        = findViewById(R.id.button_ard);
        btn_zdf        = findViewById(R.id.button_zdf);
        btn_p7         = findViewById(R.id.button_p7);
        btn_nick       = findViewById(R.id.button_nick);
        btn_disney     = findViewById(R.id.button_disney);
        btn_maxx       = findViewById(R.id.button_maxx);
        btn_zander     = findViewById(R.id.button_zander);
        btn_sport1     = findViewById(R.id.button_sport1);
        btn_keiz       = findViewById(R.id.button_keiz);
        btn_earli      = findViewById(R.id.button_earli);
        btn_gdq        = findViewById(R.id.button_gdq);
        btn_rbtv       = findViewById(R.id.button_rbtv);
        btn_nflnetwork = findViewById(R.id.button_nflnetwork);
        btn_twitch     = findViewById(R.id.button_twitch);
        btn_netflix    = findViewById(R.id.button_netflix);
        btn_yt_add     = findViewById(R.id.button_yt_add);
        btn_yt_start   = findViewById(R.id.button_yt_start);
        btn_yt_skip    = findViewById(R.id.button_yt_skip);

        editText_yt       = findViewById(R.id.editText_yt);
        editText_twitch   = findViewById(R.id.editText_twitch);
        //btn_earli.setImageURI(Uri.parse("https://static-cdn.jtvnw.net/jtv_user_pictures/e21dc7e298c83e59-profile_image-150x150.png"));


        mSocket.connect();

        btn_ard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSocket.emit("fernbedienung", "reck#§#ard");

            }
        });

        btn_zdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSocket.emit("fernbedienung", "reck#§#zdf");

            }
        });

        btn_p7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Wechsel:", "ProSieben");
                mSocket.emit("fernbedienung", "reck#§#p7");


            }
        });

        btn_nick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSocket.emit("fernbedienung", "reck#§#nick");

            }
        });

        btn_disney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSocket.emit("fernbedienung", "reck#§#disney");

            }
        });

        btn_maxx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSocket.emit("fernbedienung", "reck#§#maxx");

            }
        });

        btn_zander.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSocket.emit("fernbedienung", "reck#§#zander");

            }
        });

        btn_sport1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSocket.emit("fernbedienung", "reck#§#sport1");

            }
        });

        btn_keiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSocket.emit("fernbedienung", "reck#§#keiz");

            }
        });

        btn_earli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSocket.emit("fernbedienung", "reck#§#earli");

            }
        });

        btn_gdq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSocket.emit("fernbedienung", "reck#§#gdq");

            }
        });

        btn_rbtv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSocket.emit("fernbedienung", "reck#§#rbtv");

            }
        });

        btn_nflnetwork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editText_twitch.getText().toString());

                if (text.trim().equals("")) {
                    mSocket.emit("fernbedienung", "reck#§#nflnetwork");
                }
                else {
                    String series = text.split()
                    mSocket.emit("fernbedienung", "reck#§#nflnetwork#?#"+text);
                }


                

            }
        });

        btn_twitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSocket.emit("fernbedienung", "reck#§#twitch#?#"+editText_twitch.getText().toString());

            }
        });

        btn_netflix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSocket.emit("fernbedienung", "reck#§#netflix#?#"+editText_twitch.getText().toString());

            }
        });

        btn_yt_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSocket.emit("fernbedienung", "reck#§#youtube_add#?#"+editText_yt.getText().toString());

            }
        });

        btn_yt_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSocket.emit("fernbedienung", "reck#§#youtube_skip");

            }
        });

        btn_yt_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSocket.emit("fernbedienung", "reck#§#youtube_start");

            }
        });
    }


}
