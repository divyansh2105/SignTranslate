package com.example.dahiya.signtranslate;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.speech.RecognizerIntent;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Text_to_sign2 extends YouTubeBaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    YouTubePlayerView youTubePlayerView;
    Button button;
    YouTubePlayer.OnInitializedListener onInitializedListener;
    Databasehandler databasehandler;
    EditText text1;
    String word,words[];
    final YouTubeConfig youTubeConfig = null;
    String str;
    int flag;
    YouTubePlayer yt;

    protected void onCreate(Bundle bundle) {

        super.onCreate(bundle);
        setContentView(R.layout.activitymain_tts);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setElevation(0);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        button=(Button)findViewById(R.id.translate_button);

        youTubePlayerView=(YouTubePlayerView) findViewById(R.id.yplayer);
        text1=(EditText) findViewById(R.id.text1);

        Bundle extra=getIntent().getExtras();
        str=extra.getString("alphabet2");
        if(!(str.equals("No_way")))
        {
            text1.setText(str);
        }

        databasehandler=new Databasehandler(this,null,null,1);



        Video_structure vid1=new Video_structure("add","-GMgMrlPteU");
        databasehandler.addVideo(vid1);
        Video_structure vid2=new Video_structure("above","J0zpzH0QcWU");
        databasehandler.addVideo(vid2);
        Video_structure vid3=new Video_structure("accept","kI0IucAwId0");
        databasehandler.addVideo(vid3);
        Video_structure vid4=new Video_structure("accident","9eCSc1_itck");
        databasehandler.addVideo(vid4);
        Video_structure vid5=new Video_structure("actor","d7LWYz4OZpg");
        databasehandler.addVideo(vid5);

        Intent intent = getIntent();
        flag=intent.getIntExtra("flag_key", 0);
        words=intent.getStringArrayExtra("words_12");
        String text1_string=Arrays.toString(words).replaceAll("\\[|\\]", "");

        char[] text1_string_new = new char[50];
        int j=0;
        for(int i=0;i<text1_string.length();i++)
        {
            if(!(text1_string.charAt(i)==','))
            {
                text1_string_new[j]=text1_string.charAt(i);
                j+=1;
            }
        }
        String final_str=String.valueOf(text1_string_new);
        text1.setText(final_str);
        //button.performClick();
        button.post(new Runnable() {
            @Override
            public void run() {
                button.performClick();
            }
        });


//        Toast.makeText(getApplicationContext(), "Added to database ",
//                Toast.LENGTH_LONG).show();

        //databasehandler.deleteVideo("a","b");
        //displaycursor();


        onInitializedListener=new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                List<String> videolist=new ArrayList<>();
                Cursor data;
                for (int i = 0; i < words.length; i++) {
                    //System.out.print(words[i]);


                    //data = databasehandler.getcursorURL(words[i]);
                    data = databasehandler.getcursorURL(words[i]);

                    while(data.moveToNext()) {

                        videolist.add(data.getString(1));
                    }
                }

                Log.d("words2",String.valueOf(videolist));
                youTubePlayer.loadVideos(videolist);
                yt=youTubePlayer;
                videolist.clear();

            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                youTubePlayerView.initialize(youTubeConfig.getApiKey(), onInitializedListener);
                word=text1.getText().toString();
                words = word.split("\\s+");
                for (int i = 0; i < words.length; i++) {

                    words[i] = words[i].replaceAll("[^\\w]", "");
                }


                if(flag%2==0)
                {
                    Intent i = new Intent(Text_to_sign2.this, Text_to_sign.class);
                    i.putExtra("flag_key",flag);
                    i.putExtra("words_12",words);
                    i.putExtra("alphabet2","from2");

                    yt.release();
                    startActivity(i);
                }

                Log.d("flag2", String.valueOf(flag));
                flag=flag+1;
            }
        });
    }




    public void displaycursor() {

        Cursor data = databasehandler.getcursor();
        if (data.getCount() == 0) {
            display("error","no data found");
        }
        data = databasehandler.getcursor();
        StringBuffer buffer = new StringBuffer();
        while (data.moveToNext()) {
            buffer.append(data.getString(0) + "\n" + data.getString(1) + "\n"
            );
            //display("data stored",buffer.toString());
        }

    }



    public void display(String title, String message)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    public void mic_clicked(View view) {

        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, 10);
        } else {
            Toast.makeText(this, "Your Device Don't Support Speech Input", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case 10:
                if (resultCode == RESULT_OK && data != null) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    text1.setText(result.get(0));
                }
                break;
        }
    }
//int flag=0;
//    public void translate_clicked(View view) {
//        flag++;
//
//        if(flag%2==0){
//            Bundle mybundle=new Bundle();
//            onCreate(mybundle);
//
//        return;}
//        youTubePlayerView.initialize(youTubeConfig.getApiKey(), onInitializedListener);
//        word=text1.getText().toString();
//        words = word.split("\\s+");
//        for (int i = 0; i < words.length; i++) {
//
//            words[i] = words[i].replaceAll("[^\\w]", "");
//        }
//
//        //flag++;
//
//    }

    public void camera_buttonclicked(View v)
    {
        Intent i=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(i,0);
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//    }

    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        Intent i;
        int id = item.getItemId();

        if (id == R.id.home) {
            i = new Intent(this, MainActivity.class);;startActivity(i);
        } else if (id == R.id.text_to_sign) {
            i = new Intent(this, Text_to_sign.class);i.putExtra("alphabet2","No_way");;startActivity(i);
        } else if (id == R.id.sign_to_text) {
            i = new Intent(this, Sign_to_text.class);;startActivity(i);
        } else if (id == R.id.dictionary) {
            i = new Intent(this, Dictionary_alphabets.class);;startActivity(i);
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
