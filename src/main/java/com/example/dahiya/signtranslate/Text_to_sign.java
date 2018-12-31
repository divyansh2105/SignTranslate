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

public class Text_to_sign extends YouTubeBaseActivity implements NavigationView.OnNavigationItemSelectedListener {

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

        flag=0;


        Intent intent = getIntent();

        str=intent.getStringExtra("alphabet2");
        if(str.equals("from2"))
        {

            flag=intent.getIntExtra("flag_key", 0);
            words=intent.getStringArrayExtra("words_12");

            //text1.setText(Arrays.toString(words).replaceAll("\\[|\\]", ""));
            String text1_string=Arrays.toString(words).replaceAll("\\[|\\]", "");
            char[] text1_string_new = new char[200];
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
//            button.performClick();
            button.post(new Runnable() {
                @Override
                public void run() {
                    button.performClick();
                }
            });

        }
        else if(!(str.equals("No_way")))
        {

            text1.setText(str);
            button.post(new Runnable() {
                @Override
                public void run() {
                    button.performClick();
                }
            });
        }

        databasehandler=new Databasehandler(this,null,null,1);



        Video_structure vid1=new Video_structure("I","URmkMj-WIDc");
        databasehandler.addVideo(vid1);
        Video_structure vid2=new Video_structure("india","JFqqzkRVgko");
        databasehandler.addVideo(vid2);
        Video_structure vid3=new Video_structure("love","2FMsP1SR2oE");
        databasehandler.addVideo(vid3);
        Video_structure vid4=new Video_structure("my","ngKcZKtBoJc");
        databasehandler.addVideo(vid4);
        Video_structure vid5=new Video_structure("meet","d0eoV78cwc8");
        databasehandler.addVideo(vid5);
        Video_structure vid6=new Video_structure("me","XpOfDMdDgrg");
        databasehandler.addVideo(vid6);
        Video_structure vid7=new Video_structure("do","jdthb_lC0DU");
        databasehandler.addVideo(vid7);
        Video_structure vid8=new Video_structure("where","5UbtoCUInxg");
        databasehandler.addVideo(vid8);
        Video_structure vid9=new Video_structure("we","RLAoCg96aWs");
        databasehandler.addVideo(vid9);
        Video_structure vid10=new Video_structure("keep","7-GBAlce5Zo");
        databasehandler.addVideo(vid10);
        Video_structure vid11=new Video_structure("this","Uv7kwjiPCbA");
        databasehandler.addVideo(vid11);
        Video_structure vid12=new Video_structure("there","tT8IE8EieX0");
        databasehandler.addVideo(vid12);
        Video_structure vid13=new Video_structure("pencil","2Ez-S4GnEMg");
        databasehandler.addVideo(vid13);
        Video_structure vid14=new Video_structure("our","O1t1wPSfO-8");
        databasehandler.addVideo(vid14);



//        Video_structure vida1=new Video_structure("nagpur","XBWAHuSNUkA");
//        databasehandler.addVideo(vida1);
//        Video_structure vida2=new Video_structure("nails","ZiOtDgTWtpg");
//        databasehandler.addVideo(vida2);
//        Video_structure vida3=new Video_structure("narrow","xW7tT_sS9bc");
//        databasehandler.addVideo(vida3);
//        Video_structure vida4=new Video_structure("near","I342FngLTOM");
//        databasehandler.addVideo(vida4);
//        Video_structure vida5=new Video_structure("new","xrdLdULi6o8");
//        databasehandler.addVideo(vida5);
//        Video_structure vida6=new Video_structure("need","AbP2OqCojI4");
//        databasehandler.addVideo(vida6);
//        Video_structure vida7=new Video_structure("needle","RycGiFSjXlY");
//        databasehandler.addVideo(vida7);
//        Video_structure vida8=new Video_structure("never","lg29fsQ8u0o");
//        databasehandler.addVideo(vida8);
//        Video_structure vida9=new Video_structure("news","lk3f4SKAxuE");
//        databasehandler.addVideo(vida9);
//        Video_structure vida10=new Video_structure("night","0urh_BJ8oBg");
//        databasehandler.addVideo(vida10);
//
//        Video_structure vidb1=new Video_structure("office","vAJmESLjjJo");
//        databasehandler.addVideo(vidb1);
//        Video_structure vidb2=new Video_structure("old","h64SpXkb_20");
//        databasehandler.addVideo(vidb2);
//        Video_structure vidb3=new Video_structure("order","aAPCUjWPcik");
//        databasehandler.addVideo(vidb3);
//        Video_structure vidb4=new Video_structure("original","eeiPYdx0YNY");
//        databasehandler.addVideo(vidb4);
//        Video_structure vidb5=new Video_structure("onion","1_FTb0P46Wk");
//        databasehandler.addVideo(vidb5);
//        Video_structure vidb6=new Video_structure("one Rupee","e7KGMi_O2b8");
//        databasehandler.addVideo(vidb6);
//        Video_structure vidb7=new Video_structure("ownership","CBN11IMproQ");
//        databasehandler.addVideo(vidb7);
//        Video_structure vidb8=new Video_structure("often","Vh2QhJkwbqM");
//        databasehandler.addVideo(vidb8);
//        Video_structure vidb9=new Video_structure("oil","k8faAJ5GWfQ");
//        databasehandler.addVideo(vidb9);
//        Video_structure vidb10=new Video_structure("own","va6uY3YbDhA");
//        databasehandler.addVideo(vidb10);
//
//        Video_structure vidc1=new Video_structure("pure","uWku2IukBkQ");
//        databasehandler.addVideo(vidc1);
//        Video_structure vidc2=new Video_structure("pen","avDwgT-C_eE");
//        databasehandler.addVideo(vidc2);
//        Video_structure vidc3=new Video_structure("pencil","2Ez-S4GnEMg");
//        databasehandler.addVideo(vidc3);
//        Video_structure vidc4=new Video_structure("picture","PVFaEejGozA");
//        databasehandler.addVideo(vidc4);
//        Video_structure vidc5=new Video_structure("plenty","iAFQyY-0EMA");
//        databasehandler.addVideo(vidc5);
//        Video_structure vidc6=new Video_structure("pattern","lbkjwKxqeKc");
//        databasehandler.addVideo(vidc6);
//        Video_structure vidc7=new Video_structure("paise","BYIDHVvUxh8");
//        databasehandler.addVideo(vidc7);
//        Video_structure vidc8=new Video_structure("pedestrian","cjrG5Zehxgo");
//        databasehandler.addVideo(vidc8);
//        Video_structure vidc9=new Video_structure("principal","6-m3aKlPgY0I");
//        databasehandler.addVideo(vidc9);
//        Video_structure vidc10=new Video_structure("profit","7jfEnVhyeRw");
//        databasehandler.addVideo(vidc10);
//
//        Video_structure vidd1=new Video_structure("quadrant","k-0IK-f2BN0");
//        databasehandler.addVideo(vidd1);
//        Video_structure vidd2=new Video_structure("question","qz8aigIOFLg");
//        databasehandler.addVideo(vidd2);
//        Video_structure vidd3=new Video_structure("quiz","-khqmCfB2Qw");
//        databasehandler.addVideo(vidd3);
//        Video_structure vidd4=new Video_structure("quote","2B9RBKm3it0");
//        databasehandler.addVideo(vidd4);
//        Video_structure vidd5=new Video_structure("quran","7r0N4mBbcq4");
//        databasehandler.addVideo(vidd5);
//
//        Video_structure vide1=new Video_structure("run","klKEYDEpe9A");
//        databasehandler.addVideo(vide1);
//        Video_structure vide2=new Video_structure("reply","5r_X7v73R4o");
//        databasehandler.addVideo(vide2);
//        Video_structure vide3=new Video_structure("remove","UYaEBceedEY");
//        databasehandler.addVideo(vide3);
//        Video_structure vide4=new Video_structure("repair","zY4aRRWgUj0");
//        databasehandler.addVideo(vide4);
//        Video_structure vide5=new Video_structure("remember","-2U7UKJRAm8");
//        databasehandler.addVideo(vide5);
//        Video_structure vide6=new Video_structure("regret","4iSzPD-SBdo");
//        databasehandler.addVideo(vide6);
//        Video_structure vide7=new Video_structure("refuse","-FFYWp-IstQ");
//        databasehandler.addVideo(vide7);
//        Video_structure vide8=new Video_structure("read","KKlRY0U-OSM");
//        databasehandler.addVideo(vide8);
//        Video_structure vide9=new Video_structure("raise","UGXA_zJzBUQ");
//        databasehandler.addVideo(vide9);
//        Video_structure vide10=new Video_structure("race","hfhRnzY7Fag");
//        databasehandler.addVideo(vide10);
//
//        Video_structure vidf1=new Video_structure("start","cA90wyM4Izk");
//        databasehandler.addVideo(vidf1);
//        Video_structure vidf2=new Video_structure("sing","rJiiKZ35V-k");
//        databasehandler.addVideo(vidf2);
//        Video_structure vidf3=new Video_structure("shopkeeper","-S-yrE3uL_o");
//        databasehandler.addVideo(vidf3);
//        Video_structure vidf4=new Video_structure("share","RwUBksFdLF8");
//        databasehandler.addVideo(vidf4);
//        Video_structure vidf5=new Video_structure("sentence","Sgj2P_JliMw");
//        databasehandler.addVideo(vidf5);
//        Video_structure vidf6=new Video_structure("section","xNGRRmj5tTg");
//        databasehandler.addVideo(vidf6);
//        Video_structure vidf7=new Video_structure("search","76smGNHBeg4");
//        databasehandler.addVideo(vidf7);
//        Video_structure vidf8=new Video_structure("scissor","PQGSY6kj0h4");
//        databasehandler.addVideo(vidf8);
//        Video_structure vidf9=new Video_structure("salt","zzW87xVWErU");
//        databasehandler.addVideo(vidf9);
//        Video_structure vidf10=new Video_structure("slope","0iLmGfpt__Q");
//        databasehandler.addVideo(vidf10);
//
//        Video_structure vidg1=new Video_structure("train","5C5WOvloD0k");
//        databasehandler.addVideo(vidg1);
//        Video_structure vidg2=new Video_structure("truth","ns0oRodZ3jI");
//        databasehandler.addVideo(vidg2);
//        Video_structure vidg3=new Video_structure("turn","cuwmNzS6X5g");
//        databasehandler.addVideo(vidg3);
//        Video_structure vidg4=new Video_structure("thief","e1vglvKJcnw");
//        databasehandler.addVideo(vidg4);
//        Video_structure vidg5=new Video_structure("telephone","8k9pWImfFgQ");
//        databasehandler.addVideo(vidg5);
//        Video_structure vidg6=new Video_structure("temple","B39-mkFYWAw");
//        databasehandler.addVideo(vidg6);
//        Video_structure vidg7=new Video_structure("teacher","Vw0OadFHl_Y");
//        databasehandler.addVideo(vidg7);
//        Video_structure vidg8=new Video_structure("taxi","f0aEYjUZ1ec");
//        databasehandler.addVideo(vidg8);
//        Video_structure vidg9=new Video_structure("tablet","fL2I3aidCCo");
//        databasehandler.addVideo(vidg9);
//        Video_structure vidg10=new Video_structure("table","S4qfbX-zEg0");
//        databasehandler.addVideo(vidg10);
//
//        Video_structure vidh1=new Video_structure("us","qV6_vuYUlQE");
//        databasehandler.addVideo(vidh1);
//        Video_structure vidh2=new Video_structure("up","h18cGKJQbJc");
//        databasehandler.addVideo(vidh2);
//        Video_structure vidh3=new Video_structure("unpredictable","PKZ_IPPL13E");
//        databasehandler.addVideo(vidh3);
//        Video_structure vidh4=new Video_structure("upload","lN5EztKcYik");
//        databasehandler.addVideo(vidh4);
//        Video_structure vidh5=new Video_structure("until","JeHtIzF2-Hg");
//        databasehandler.addVideo(vidh5);
//        Video_structure vidh6=new Video_structure("university","G7-sA1gPAvs");
//        databasehandler.addVideo(vidh6);
//        Video_structure vidh7=new Video_structure("uniform","BrBR46cGAVg");
//        databasehandler.addVideo(vidh7);
//        Video_structure vidh8=new Video_structure("understand","T7c3qGJWgmY");
//        databasehandler.addVideo(vidh8);
//        Video_structure vidh9=new Video_structure("under","AW6AY5rg6Pg");
//        databasehandler.addVideo(vidh9);
//        Video_structure vidh10=new Video_structure("umbrella","NyIg93npFW4");
//        databasehandler.addVideo(vidh10);
//
//        Video_structure vidi1=new Video_structure("voltage","LmsuveiCNaA");
//        databasehandler.addVideo(vidi1);
//        Video_structure vidi2=new Video_structure("vomit","wU-IgklSYy8");
//        databasehandler.addVideo(vidi2);
//        Video_structure vidi3=new Video_structure("vote","H_4E7RC3x04");
//        databasehandler.addVideo(vidi3);
//        Video_structure vidi4=new Video_structure("vegetarian","LIqLN9GDqS0");
//        databasehandler.addVideo(vidi4);
//        Video_structure vidi5=new Video_structure("visit","WrvA35Mx7h8");
//        databasehandler.addVideo(vidi5);
//        Video_structure vidi6=new Video_structure("vegetables","ci27cbH-MIs");
//        databasehandler.addVideo(vidi6);
//        Video_structure vidi7=new Video_structure("variables","JgZYOKLDgio");
//        databasehandler.addVideo(vidi7);
//        Video_structure vidi8=new Video_structure("value","fcyRKO_QHPA");
//        databasehandler.addVideo(vidi8);
//        Video_structure vidi9=new Video_structure("van","Ovc36oyHFGs");
//        databasehandler.addVideo(vidi9);
//        Video_structure vidi10=new Video_structure("vacancy","MT79x10b5Cc");
//        databasehandler.addVideo(vidi10);
//
//        Video_structure vidj1=new Video_structure("whistle","WbQ_2QocbZo");
//        databasehandler.addVideo(vidj1);
//        Video_structure vidj2=new Video_structure("wheat","mZnckKNs18c");
//        databasehandler.addVideo(vidj2);
//        Video_structure vidj3=new Video_structure("welcome","fcbbfNUg8Dc");
//        databasehandler.addVideo(vidj3);
//        Video_structure vidj4=new Video_structure("weight","jjdi1mrYUkc");
//        databasehandler.addVideo(vidj4);
//        Video_structure vidj5=new Video_structure("weakness","0pLSruHBibk");
//        databasehandler.addVideo(vidj5);
//        Video_structure vidj6=new Video_structure("water","FbnAF7Ebk_o");
//        databasehandler.addVideo(vidj6);
//        Video_structure vidj7=new Video_structure("waste","ERAS6RtAUqg");
//        databasehandler.addVideo(vidj7);
//        Video_structure vidj8=new Video_structure("wait","Qymh8EdgB5M");
//        databasehandler.addVideo(vidj8);
//        Video_structure vidj9=new Video_structure("wrong","Cy0VofTRsFc");
//        databasehandler.addVideo(vidj9);
//        Video_structure vidj10=new Video_structure("write","Hojk9sx-Iw");
//        databasehandler.addVideo(vidj10);
//
//        Video_structure vidk1=new Video_structure("x-ray","sg0pDjm5g9I");
//        databasehandler.addVideo(vidk1);
//
//        Video_structure vidl1=new Video_structure("lesson","4nngTDAI2Bs");
//        databasehandler.addVideo(vidl1);
//        Video_structure vidl2=new Video_structure("yourself","P5fhGa0de4U");
//        databasehandler.addVideo(vidl2);
//        Video_structure vidl3=new Video_structure("your own","8q6uDDN4nos");
//        databasehandler.addVideo(vidl3);
//        Video_structure vidl4=new Video_structure("your","DOlNiKNLD4w");
//        databasehandler.addVideo(vidl4);
//        Video_structure vidl5=new Video_structure("you","tB9i8__qNA8");
//        databasehandler.addVideo(vidl5);
//        Video_structure vidl6=new Video_structure("yes","l8h8IXWvb7Y");
//        databasehandler.addVideo(vidl6);
//        Video_structure vidl7=new Video_structure("yesterday","7Di9rsdpj98");
//        databasehandler.addVideo(vidl7);
//
//        Video_structure vidm1=new Video_structure("zinc","52h1wodgQkA");
//        databasehandler.addVideo(vidm1);
//        Video_structure vidm2=new Video_structure("zoom","W76HnQG-GoI");
//        databasehandler.addVideo(vidm2);
//        Video_structure vidm3=new Video_structure("zoo","YU_9ZIQCp1s");
//        databasehandler.addVideo(vidm3);
//        Video_structure vidm4=new Video_structure("zero","yzqb5jGGmKk");
//        databasehandler.addVideo(vidm4);
//        Video_structure vidm5=new Video_structure("zebra","ietPMSc-KMU");
//        databasehandler.addVideo(vidm5);






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
                //Log.d("words",words[0]+" "+words[1]);
                if(flag%2==1)
                {
                    Intent i = new Intent(Text_to_sign.this, Text_to_sign2.class);
                    i.putExtra("flag_key",flag);
                    i.putExtra("words_12",words);
                    i.putExtra("alphabet2","from1");

                    yt.release();
                    startActivity(i);
                }

                Log.d("flag1", String.valueOf(flag));
                flag+=1;
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
