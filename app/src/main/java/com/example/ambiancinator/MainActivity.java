package com.example.ambiancinator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.SeekBar;
import android.widget.Toast;

import com.example.ambiancinator.R.id;

public class MainActivity extends AppCompatActivity {
    private final static int MAX_VOLUME = 100;
    private final static float DEFAULT_VOLUME = 1f;
    private SoundPool soundPool;

    private boolean isOrageChecked;
    private boolean isOiseauxChecked;
    private boolean isOiseauxForetChecked;
    private boolean isFeuillesChecked;
    private boolean isFeuDeCampChecked;
    private boolean isRuisseauChecked;
    private boolean isChemineeChecked;
    private boolean isCoteChecked;
    private boolean isVentChecked;
    private boolean isPluieChecked;
    private boolean isStressChecked;

    private int orage;
    private int oiseaux;
    private int oiseauxForet;
    private int feuilles;
    private int feuDeCamp;
    private int ruisseau;
    private int cheminee;
    private int cote;
    private int vent;
    private int pluie;
    private int stress;

    private ImageButton ibOiseauxForet;
    private ImageButton ibFeuilles;
    private ImageButton ibFeuDeCamp;
    private  ImageButton ibOiseaux;
    private ImageButton ibRuisseau;
    private ImageButton ibCheminee;
    private ImageButton ibCote;
    private ImageButton ibVent;
    private ImageButton ibPluie;
    private ImageButton ibStress;
    private ImageButton ibOrage;

    private CardView cvOiseauxForet;
    private CardView cvFeuDeCamp;
    private CardView cvOiseaux;
    private CardView cvRuisseau;
    private CardView cvCheminee;
    private CardView cvCote;
    private CardView cvVent;
    private CardView cvPluie;
    private CardView cvStress;
    private CardView cvOrage;
    private CardView cvFeuilles;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //###############################--Bouton INFO--###############################\\
        ImageButton imageButtonInfo = findViewById(R.id.ImageButton_Info);
        imageButtonInfo.setOnClickListener(v -> {
            // inflate the layout of the popup window
            LayoutInflater inflater = (LayoutInflater)
                    getSystemService(LAYOUT_INFLATER_SERVICE);
            @SuppressLint("InflateParams") View popupView = inflater.inflate(R.layout.popup, null);

            // create the popup window
            int width = LinearLayout.LayoutParams.WRAP_CONTENT;
            int height = LinearLayout.LayoutParams.WRAP_CONTENT;
            final PopupWindow popupWindow = new PopupWindow(popupView, width, height, true);

            // show the popup window
            // which view you pass in doesn't matter, it is only used for the window tolken
            popupWindow.showAtLocation(imageButtonInfo, Gravity.CENTER, 0, 0);

            // dismiss the popup window when touched
            popupView.setOnTouchListener((v1, event) -> {
                popupWindow.dismiss();
                return true;
            });
        });

        //###############################--ImageBouton--###############################\\
        ibOiseauxForet = findViewById(id.ImageButton_OiseauxForet);
        ibFeuilles = findViewById(id.ImageButton_Feuilles);
        ibFeuDeCamp = findViewById(id.ImageButton_FeuDeCamp);
        ibOiseaux = findViewById(id.ImageButton_Oiseaux);
        ibRuisseau = findViewById(id.ImageButton_Ruisseau);
        ibCheminee = findViewById(id.ImageButton_Cheminee);
        ibCote = findViewById(id.ImageButton_Cote);
        ibVent = findViewById(id.ImageButton_Vent);
        ibPluie = findViewById(id.ImageButton_Pluie);
        ibStress = findViewById(id.ImageButton_Stress);
        ibOrage = findViewById(id.ImageButton_Orage);

        //###############################--CardView--###############################\\
        cvOiseauxForet = findViewById(id.CardView_OiseauxForet);
        cvFeuilles = findViewById(id.CardView_Feuilles);
        cvFeuDeCamp = findViewById(id.CardView_FeuDeCamp);
        cvOiseaux = findViewById(id.CardView_Oiseaux);
        cvRuisseau = findViewById(id.CardView_Ruisseau);
        cvCheminee = findViewById(id.CardView_Cheminee);
        cvCote = findViewById(id.CardView_Cote);
        cvVent = findViewById(id.CardView_Vent);
        cvPluie = findViewById(id.CardView_Pluie);
        cvStress = findViewById(id.CardView_Stress);
        cvOrage = findViewById(id.CardView_Orage);


        //###############################--CardView--###############################\\
        SeekBar sbOiseauxForet = findViewById(R.id.SeekBar_OiseauxForet);
        SeekBar sbFeuilles = findViewById(R.id.SeekBar_Feuilles);
        SeekBar sbFeuDeCamp = findViewById(R.id.SeekBar_FeuDeCamp);
        SeekBar sbOiseaux = findViewById(R.id.SeekBar_Oiseaux);
        SeekBar sbRuisseau = findViewById(R.id.SeekBar_Ruisseau);
        SeekBar sbCheminee = findViewById(R.id.SeekBar_Cheminee);
        SeekBar sbCote = findViewById(R.id.SeekBar_Cote);
        SeekBar sbVent = findViewById(R.id.SeekBar_Vent);
        SeekBar sbPluie = findViewById(R.id.SeekBar_Pluie);
        SeekBar sbStress = findViewById(R.id.SeekBar_Stress);
        SeekBar sbOrage = findViewById(R.id.SeekBar_Orage);

        //###############################--SoundPool--###############################\\

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();

            soundPool = new SoundPool.Builder()
                    .setMaxStreams(12)
                    .setAudioAttributes(audioAttributes)
                    .build();
        }
        else{
            soundPool = new SoundPool(12, AudioManager.STREAM_MUSIC,0);
        }

        orage =         soundPool.load(this,R.raw.orage,1);
        oiseaux =       soundPool.load(this,R.raw.oiseaux,1);
        oiseauxForet =  soundPool.load(this,R.raw.oiseauxforet,1);
        feuilles =      soundPool.load(this,R.raw.feuilles,1);
        feuDeCamp =     soundPool.load(this,R.raw.feudecamp,1);
        ruisseau =      soundPool.load(this,R.raw.ruisseau,1);
        cheminee =      soundPool.load(this,R.raw.cheminee,1);
        cote =          soundPool.load(this,R.raw.cote,1);
        vent =          soundPool.load(this,R.raw.vent,1);
        pluie =         soundPool.load(this,R.raw.pluie,1);
        stress =        soundPool.load(this,R.raw.stress,1);

        /*
        //###############################--MediaPlayer--###############################\\
        final MediaPlayer mpOiseauxForet = MediaPlayer.create(this,R.raw.oiseauxforet);
        mpOiseauxForet.setVolume(DEFAULT_VOLUME, DEFAULT_VOLUME);
        final MediaPlayer mpFeuilles = MediaPlayer.create(this,R.raw.feuilles);
        mpFeuilles.setVolume(DEFAULT_VOLUME, DEFAULT_VOLUME);
        final MediaPlayer mpFeuDeCamp = MediaPlayer.create(this,R.raw.feudecamp);
        mpFeuDeCamp.setVolume(DEFAULT_VOLUME, DEFAULT_VOLUME);
        final MediaPlayer mpOiseaux = MediaPlayer.create(this,R.raw.oiseaux);
        mpOiseaux.setVolume(DEFAULT_VOLUME, DEFAULT_VOLUME);
        final MediaPlayer mpRuisseau = MediaPlayer.create(this,R.raw.ruisseau);
        mpRuisseau.setVolume(DEFAULT_VOLUME, DEFAULT_VOLUME);
        final MediaPlayer mpCheminee = MediaPlayer.create(this,R.raw.cheminee);
        mpCheminee.setVolume(DEFAULT_VOLUME, DEFAULT_VOLUME);
        final MediaPlayer mpCote = MediaPlayer.create(this,R.raw.cote);
        mpCote.setVolume(DEFAULT_VOLUME, DEFAULT_VOLUME);
        final MediaPlayer mpVent = MediaPlayer.create(this,R.raw.vent);
        mpVent.setVolume(DEFAULT_VOLUME, DEFAULT_VOLUME);
        final MediaPlayer mpPluie = MediaPlayer.create(this,R.raw.pluie);
        mpPluie.setVolume(DEFAULT_VOLUME, DEFAULT_VOLUME);
        final MediaPlayer mpStress = MediaPlayer.create(this,R.raw.stress);
        mpStress.setVolume(DEFAULT_VOLUME, DEFAULT_VOLUME);
        final MediaPlayer mpOrage = MediaPlayer.create(this,R.raw.orage);
        mpOrage.setVolume(DEFAULT_VOLUME, DEFAULT_VOLUME);
*/

        //###############################--OiseauxForet--###############################\\
        ibOiseauxForet.setOnClickListener(v -> {
            isOiseauxForetChecked = !isOiseauxForetChecked;
            toggleBouton(isOiseauxForetChecked, soundPool, ibOiseauxForet, cvOiseauxForet, oiseauxForet);

        });
        sbOiseauxForet.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float volume = (float) (1 - (Math.log(MAX_VOLUME - sbOiseauxForet.getProgress()) / Math.log(MAX_VOLUME)));
                soundPool.setVolume(oiseauxForet,volume,volume);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
/*
        //###############################--Feuilles--###############################\\
        ibFeuilles.setOnClickListener(v -> {
            isFeuillesChecked = !isFeuillesChecked;
            toggleBouton(isFeuillesChecked, mpFeuilles, ibFeuilles, cvFeuilles);

        });
        sbFeuilles.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float volume = (float) (1 - (Math.log(MAX_VOLUME - sbFeuilles.getProgress()) / Math.log(MAX_VOLUME)));
                mpFeuilles.setVolume(volume, volume);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //###############################--FeuDeCamp--###############################\\
        ibFeuDeCamp.setOnClickListener(v -> {
            isFeuDeCampChecked = !isFeuDeCampChecked;
            toggleBouton(isFeuDeCampChecked, mpFeuDeCamp, ibFeuDeCamp, cvFeuDeCamp);

        });
        sbFeuDeCamp.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float volume = (float) (1 - (Math.log(MAX_VOLUME - sbFeuDeCamp.getProgress()) / Math.log(MAX_VOLUME)));
                mpFeuDeCamp.setVolume(volume, volume);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //###############################--Oiseaux--###############################\\
        ibOiseaux.setOnClickListener(v -> {
            isOiseauxChecked = !isOiseauxChecked;
            toggleBouton(isOiseauxChecked, mpOiseaux, ibOiseaux, cvOiseaux);

        });
        sbOiseaux.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float volume = (float) (1 - (Math.log(MAX_VOLUME - sbOiseaux.getProgress()) / Math.log(MAX_VOLUME)));
                mpOiseaux.setVolume(volume, volume);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //###############################--Ruisseau--###############################\\
        ibRuisseau.setOnClickListener(v -> {
            isRuisseauChecked = !isRuisseauChecked;
            toggleBouton(isRuisseauChecked, mpRuisseau, ibRuisseau, cvRuisseau);

        });
        sbRuisseau.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float volume = (float) (1 - (Math.log(MAX_VOLUME - sbRuisseau.getProgress()) / Math.log(MAX_VOLUME)));
                mpRuisseau.setVolume(volume, volume);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        
        //###############################--Cheminee--###############################\\
        ibCheminee.setOnClickListener(v -> {
            isChemineeChecked = !isChemineeChecked;
            toggleBouton(isChemineeChecked, mpCheminee, ibCheminee, cvCheminee);

        });
        sbCheminee.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float volume = (float) (1 - (Math.log(MAX_VOLUME - sbCheminee.getProgress()) / Math.log(MAX_VOLUME)));
                mpCheminee.setVolume(volume, volume);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //###############################--Cote--###############################\\
        ibCote.setOnClickListener(v -> {
            isCoteChecked = !isCoteChecked;
            toggleBouton(isCoteChecked, mpCote, ibCote, cvCote);

        });
        sbCote.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float volume = (float) (1 - (Math.log(MAX_VOLUME - sbCote.getProgress()) / Math.log(MAX_VOLUME)));
                mpCote.setVolume(volume, volume);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //###############################--Vent--###############################\\
        ibVent.setOnClickListener(v -> {
            isVentChecked = !isVentChecked;
            toggleBouton(isVentChecked, mpVent, ibVent, cvVent);

        });
        sbVent.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float volume = (float) (1 - (Math.log(MAX_VOLUME - sbVent.getProgress()) / Math.log(MAX_VOLUME)));
                mpVent.setVolume(volume, volume);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //###############################--Pluie--###############################\\
        ibPluie.setOnClickListener(v -> {
            isPluieChecked = !isPluieChecked;
            toggleBouton(isPluieChecked, mpPluie, ibPluie, cvPluie);

        });
        sbPluie.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float volume = (float) (1 - (Math.log(MAX_VOLUME - sbPluie.getProgress()) / Math.log(MAX_VOLUME)));
                mpPluie.setVolume(volume, volume);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //###############################--Stress--###############################\\
        ibStress.setOnClickListener(v -> {
            isStressChecked = !isStressChecked;
            toggleBouton(isStressChecked, mpStress, ibStress, cvStress);

        });
        sbStress.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float volume = (float) (1 - (Math.log(MAX_VOLUME - sbStress.getProgress()) / Math.log(MAX_VOLUME)));
                mpStress.setVolume(volume, volume);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //###############################--Orage--###############################\\
        ibOrage.setOnClickListener(v -> {
            isOrageChecked = !isOrageChecked;
            toggleBouton(isOrageChecked, mpOrage, ibOrage, cvOrage);

        });
        sbOrage.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float volume = (float) (1 - (Math.log(MAX_VOLUME - sbOrage.getProgress()) / Math.log(MAX_VOLUME)));
                mpOrage.setVolume(volume, volume);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
*/
    }
/*
    private void toggleBouton(boolean bool, MediaPlayer mediaPlayer, ImageButton imageButton, CardView cardView){
        if (bool){
            mediaPlayer.start();
            mediaPlayer.setLooping(true);
            cardView.setCardBackgroundColor(ColorStateList.valueOf(getColor(R.color.purple_500)));
            imageButton.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.softer_grey)));
        }
        else{
            mediaPlayer.pause();
            mediaPlayer.setLooping(false);
            cardView.setCardBackgroundColor(ColorStateList.valueOf(getColor(R.color.softer_grey)));
            imageButton.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.soft_grey)));
        }
    }
*/

    private void toggleBouton(boolean bool, SoundPool soundPool, ImageButton imageButton, CardView cardView, int soundID){
        if (bool){
            Toast.makeText(this, "Pouet "+soundID, Toast.LENGTH_SHORT).show();
            soundPool.play(soundID,DEFAULT_VOLUME,DEFAULT_VOLUME,0,-1,1);
            cardView.setCardBackgroundColor(ColorStateList.valueOf(getColor(R.color.purple_500)));
            imageButton.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.softer_grey)));
        }
        else{
            soundPool.autoPause();
            cardView.setCardBackgroundColor(ColorStateList.valueOf(getColor(R.color.softer_grey)));
            imageButton.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.soft_grey)));
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        soundPool.release();
        soundPool = null;
    }
}