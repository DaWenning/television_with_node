package de.recklessGreed.fernbedienung;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

import java.net.URISyntaxException;

public class MainActivity extends AppCompatActivity {

    ImageButton imgBtn_ard;
    ImageButton imgBtn_zdf;
    ImageButton imgBtn_p7;

    ImageButton imgBtn_nick;
    ImageButton imgBtn_disney;
    ImageButton imgBtn_maxx;

    ImageButton imgBtn_zander;
    ImageButton imgBtn_sport1;
    ImageButton imgBtn_keiz;

    ImageButton imgBtn_earli;
    ImageButton imgBtn_gdq;
    ImageButton imgBtn_rbtv;

    ImageButton imgBtn_nflnetwork;
    ImageButton imgBtn_twitch;
    ImageButton imgBtn_netflix;

    ImageButton imgBtn_yt_add;
    ImageButton imgBtn_yt_start;
    ImageButton imgBtn_yt_skip;

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

        imgBtn_ard        = findViewById(R.id.imageButton_ard);
        imgBtn_zdf        = findViewById(R.id.imageButton_zdf);
        imgBtn_p7         = findViewById(R.id.imageButton_p7);
        imgBtn_nick       = findViewById(R.id.imageButton_nick);
        imgBtn_disney     = findViewById(R.id.imageButton_disney);
        imgBtn_maxx       = findViewById(R.id.imageButton_maxx);
        imgBtn_zander     = findViewById(R.id.imageButton_zander);
        imgBtn_sport1     = findViewById(R.id.imageButton_sport1);
        imgBtn_keiz       = findViewById(R.id.imageButton_keiz);
        imgBtn_earli      = findViewById(R.id.imageButton_earli);
        imgBtn_gdq        = findViewById(R.id.imageButton_gdq);
        imgBtn_rbtv       = findViewById(R.id.imageButton_rbtv);
        imgBtn_nflnetwork = findViewById(R.id.imageButton_nflnetwork);
        imgBtn_twitch     = findViewById(R.id.imageButton_twitch);
        imgBtn_netflix    = findViewById(R.id.imageButton_netflix);
        imgBtn_yt_add     = findViewById(R.id.imageButton_yt_add);
        imgBtn_yt_start   = findViewById(R.id.imageButton_yt_start);
        imgBtn_yt_skip    = findViewById(R.id.imageButton_yt_skip);

        editText_yt       = findViewById(R.id.editText_yt);
        editText_twitch   = findViewById(R.id.editText_twitch);
        //imgBtn_earli.setImageURI(Uri.parse("https://static-cdn.jtvnw.net/jtv_user_pictures/e21dc7e298c83e59-profile_image-150x150.png"));


        mSocket.connect();

        imgBtn_ard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSocket.emit("fernbedienung", "reck#§#ard");

            }
        });

        imgBtn_zdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSocket.emit("fernbedienung", "reck#§#zdf");

            }
        });

        imgBtn_p7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Wechsel:", "ProSieben");
                mSocket.emit("fernbedienung", "reck#§#p7");


            }
        });

        imgBtn_nick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSocket.emit("fernbedienung", "reck#§#nick");

            }
        });

        imgBtn_disney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSocket.emit("fernbedienung", "reck#§#disney");

            }
        });

        imgBtn_maxx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSocket.emit("fernbedienung", "reck#§#maxx");

            }
        });

        imgBtn_zander.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSocket.emit("fernbedienung", "reck#§#zander");

            }
        });

        imgBtn_sport1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSocket.emit("fernbedienung", "reck#§#sport1");

            }
        });

        imgBtn_keiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSocket.emit("fernbedienung", "reck#§#keiz");

            }
        });

        imgBtn_earli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSocket.emit("fernbedienung", "reck#§#earli");

            }
        });

        imgBtn_gdq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSocket.emit("fernbedienung", "reck#§#gdq");

            }
        });

        imgBtn_rbtv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSocket.emit("fernbedienung", "reck#§#rbtv");

            }
        });

        imgBtn_nflnetwork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSocket.emit("fernbedienung", "reck#§#nflnetwork");

            }
        });

        imgBtn_twitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSocket.emit("fernbedienung", "reck#§#twitch#?#"+editText_twitch.getText().toString());

            }
        });

        imgBtn_netflix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSocket.emit("fernbedienung", "reck#§#netflix#?#"+editText_twitch.getText().toString());

            }
        });

        imgBtn_yt_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSocket.emit("fernbedienung", "reck#§#youtube_add#?#"+editText_yt.getText().toString());

            }
        });

        imgBtn_yt_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSocket.emit("fernbedienung", "reck#§#youtube_skip");

            }
        });

        imgBtn_yt_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSocket.emit("fernbedienung", "reck#§#youtube_start");

            }
        });
    }

    private View.OnClickListener onButtonClick(View view) {
        String tmp = "reck#$#";
        final String message;

        switch (view.getId()) {
            case R.id.imageButton_ard:
                tmp += "ard";
                break;
            case R.id.imageButton_zdf:
                tmp += "zdf";
                break;
            case R.id.imageButton_p7:
                tmp += "p7";
                break;
            case R.id.imageButton_nick:
                tmp += "nick";
                break;
            case R.id.imageButton_disney:
                tmp += "disney";
                break;
            case R.id.imageButton_maxx:
                tmp += "maxx";
                break;
            case R.id.imageButton_zander:
                tmp += "zander";
                break;
            case R.id.imageButton_sport1:
                tmp += "sport1";
                break;
            case R.id.imageButton_keiz:
                tmp += "keiz";
                break;
            case R.id.imageButton_earli:
                tmp += "earli";
                break;
            case R.id.imageButton_gdq:
                tmp += "gdq";
                break;
            case R.id.imageButton_rbtv:
                tmp += "rbtv";
                break;
            case R.id.imageButton_nflnetwork:
                tmp += "nflnetwork";
                break;
            case R.id.imageButton_twitch:
                tmp += "custom_twitch";
                break;
            case R.id.imageButton_yt_add:
                tmp += "youtube_add";
                break;
            case R.id.imageButton_yt_skip:
                tmp += "youtube_skip";
                break;
            case R.id.imageButton_yt_start:
                tmp += "youtube_start";
                break;
            default:
                tmp = "";
                break;
        }

        message = tmp;

        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSocket.emit("fernbedienung", message);
            }
        };
    }

}
