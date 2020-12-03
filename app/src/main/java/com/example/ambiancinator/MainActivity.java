package com.example.ambiancinator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.SeekBar;

import com.example.ambiancinator.R.id;

public class MainActivity extends AppCompatActivity {
    private final static int MAX_VOLUME = 100;
    private final static int DEFAULT_VOLUME = 20;
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

    private int orageStreamID;
    private int oiseauxStreamID;
    private int oiseauxForetStreamID;
    private int feuillesStreamID;
    private int feuDeCampStreamID;
    private int ruisseauStreamID;
    private int chemineeStreamID;
    private int coteStreamID;
    private int ventStreamID;
    private int pluieStreamID;
    private int stressStreamID;

    private ImageButton ibOiseauxForet;
    private ImageButton ibFeuilles;
    private ImageButton ibFeuDeCamp;
    private ImageButton ibOiseaux;
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
        ibOiseauxForet  = findViewById(id.ImageButton_OiseauxForet);
        ibFeuilles      = findViewById(id.ImageButton_Feuilles);
        ibFeuDeCamp     = findViewById(id.ImageButton_FeuDeCamp);
        ibOiseaux       = findViewById(id.ImageButton_Oiseaux);
        ibRuisseau      = findViewById(id.ImageButton_Ruisseau);
        ibCheminee      = findViewById(id.ImageButton_Cheminee);
        ibCote          = findViewById(id.ImageButton_Cote);
        ibVent          = findViewById(id.ImageButton_Vent);
        ibPluie         = findViewById(id.ImageButton_Pluie);
        ibStress        = findViewById(id.ImageButton_Stress);
        ibOrage         = findViewById(id.ImageButton_Orage);

        //###############################--CardView--###############################\\
        cvOiseauxForet  = findViewById(id.CardView_OiseauxForet);
        cvFeuilles      = findViewById(id.CardView_Feuilles);
        cvFeuDeCamp     = findViewById(id.CardView_FeuDeCamp);
        cvOiseaux       = findViewById(id.CardView_Oiseaux);
        cvRuisseau      = findViewById(id.CardView_Ruisseau);
        cvCheminee      = findViewById(id.CardView_Cheminee);
        cvCote          = findViewById(id.CardView_Cote);
        cvVent          = findViewById(id.CardView_Vent);
        cvPluie         = findViewById(id.CardView_Pluie);
        cvStress        = findViewById(id.CardView_Stress);
        cvOrage         = findViewById(id.CardView_Orage);


        //###############################--CardView--###############################\\
        SeekBar sbOiseauxForet  = findViewById(R.id.SeekBar_OiseauxForet);
        SeekBar sbFeuilles      = findViewById(R.id.SeekBar_Feuilles);
        SeekBar sbFeuDeCamp     = findViewById(R.id.SeekBar_FeuDeCamp);
        SeekBar sbOiseaux       = findViewById(R.id.SeekBar_Oiseaux);
        SeekBar sbRuisseau      = findViewById(R.id.SeekBar_Ruisseau);
        SeekBar sbCheminee      = findViewById(R.id.SeekBar_Cheminee);
        SeekBar sbCote          = findViewById(R.id.SeekBar_Cote);
        SeekBar sbVent          = findViewById(R.id.SeekBar_Vent);
        SeekBar sbPluie         = findViewById(R.id.SeekBar_Pluie);
        SeekBar sbStress        = findViewById(R.id.SeekBar_Stress);
        SeekBar sbOrage         = findViewById(R.id.SeekBar_Orage);

        //###############################--SoundPool--###############################\\

        @SuppressLint("WrongConstant") AudioAttributes audioAttributes = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_MEDIA)
                .setContentType(AudioAttributes.USAGE_MEDIA)
                .build();

        soundPool = new SoundPool.Builder()
                .setMaxStreams(12)
                .setAudioAttributes(audioAttributes)
                .build();


        orage           = soundPool.load(this,R.raw.orage,1);
        oiseaux         = soundPool.load(this,R.raw.oiseaux,1);
        oiseauxForet    = soundPool.load(this,R.raw.oiseauxforet,1);
        feuilles        = soundPool.load(this,R.raw.feuilles,1);
        feuDeCamp       = soundPool.load(this,R.raw.feudecamp,1);
        ruisseau        = soundPool.load(this,R.raw.ruisseau,1);
        cheminee        = soundPool.load(this,R.raw.cheminee,1);
        cote            = soundPool.load(this,R.raw.cote,1);
        vent            = soundPool.load(this,R.raw.vent,1);
        pluie           = soundPool.load(this,R.raw.pluie,1);
        stress          = soundPool.load(this,R.raw.stress,1);



        //###############################--OiseauxForet--###############################\\
        ibOiseauxForet.setOnClickListener(v -> {
            isOiseauxForetChecked = !isOiseauxForetChecked;
            oiseauxForetStreamID = toggleBouton(isOiseauxForetChecked, soundPool, ibOiseauxForet, cvOiseauxForet, oiseauxForet, oiseauxForetStreamID);
        });
        sbOiseauxForet.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float volume = (float) (1 - (Math.log(MAX_VOLUME - sbOiseauxForet.getProgress()) / Math.log(MAX_VOLUME)));
                soundPool.setVolume(oiseauxForetStreamID,volume,volume);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //###############################--Feuilles--###############################\\
        ibFeuilles.setOnClickListener(v -> {
            isFeuillesChecked = !isFeuillesChecked;
            feuillesStreamID = toggleBouton(isFeuillesChecked, soundPool, ibFeuilles, cvFeuilles, feuilles, feuillesStreamID);
        });
        sbFeuilles.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                soundPool.setVolume(feuillesStreamID,getVolumeFromSeekBar(sbFeuilles),getVolumeFromSeekBar(sbFeuilles));
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
            feuDeCampStreamID = toggleBouton(isFeuDeCampChecked, soundPool, ibFeuDeCamp, cvFeuDeCamp, feuDeCamp,feuDeCampStreamID);
        });
        sbFeuDeCamp.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                soundPool.setVolume(feuDeCampStreamID,getVolumeFromSeekBar(sbFeuDeCamp),getVolumeFromSeekBar(sbFeuDeCamp));
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
            oiseauxStreamID = toggleBouton(isOiseauxChecked, soundPool, ibOiseaux, cvOiseaux,oiseaux,oiseauxStreamID);
        });
        sbOiseaux.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                soundPool.setVolume(oiseauxStreamID,getVolumeFromSeekBar(sbOiseaux), getVolumeFromSeekBar(sbOiseaux));
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
            ruisseauStreamID = toggleBouton(isRuisseauChecked, soundPool, ibRuisseau, cvRuisseau, ruisseau, ruisseauStreamID);
        });
        sbRuisseau.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                soundPool.setVolume(ruisseauStreamID,getVolumeFromSeekBar(sbRuisseau), getVolumeFromSeekBar(sbRuisseau));
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
            chemineeStreamID = toggleBouton(isChemineeChecked, soundPool, ibCheminee, cvCheminee,cheminee, chemineeStreamID);
        });
        sbCheminee.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                soundPool.setVolume(chemineeStreamID,getVolumeFromSeekBar(sbCheminee), getVolumeFromSeekBar(sbCheminee));
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
            coteStreamID = toggleBouton(isCoteChecked, soundPool, ibCote, cvCote, cote, coteStreamID);
        });
        sbCote.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                soundPool.setVolume(coteStreamID,getVolumeFromSeekBar(sbCote), getVolumeFromSeekBar(sbCote));
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
            ventStreamID = toggleBouton(isVentChecked, soundPool, ibVent, cvVent, vent, ventStreamID);
        });
        sbVent.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                soundPool.setVolume(ventStreamID,getVolumeFromSeekBar(sbVent), getVolumeFromSeekBar(sbVent));
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
            pluieStreamID = toggleBouton(isPluieChecked, soundPool, ibPluie, cvPluie,pluie, pluieStreamID);
        });
        sbPluie.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                soundPool.setVolume(pluieStreamID,getVolumeFromSeekBar(sbPluie), getVolumeFromSeekBar(sbPluie));
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
            stressStreamID = toggleBouton(isStressChecked, soundPool, ibStress, cvStress, stress, stressStreamID);
        });
        sbStress.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                soundPool.setVolume(stressStreamID, getVolumeFromSeekBar(sbStress), getVolumeFromSeekBar(sbStress));
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
            orageStreamID = toggleBouton(isOrageChecked, soundPool, ibOrage, cvOrage, orage, orageStreamID);
        });
        sbOrage.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                soundPool.setVolume(orageStreamID,getVolumeFromSeekBar(sbOrage), getVolumeFromSeekBar(sbOrage));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private int toggleBouton(boolean bool, SoundPool soundPool, ImageButton imageButton, CardView cardView, int soundID, int streamID){
        if (bool){
            if (streamID == 0) {
                streamID = soundPool.play(soundID, getInitVolume(), getInitVolume(), 0, -1, 1);
            }
            else{
                soundPool.resume(streamID);
            }
            cardView.setCardBackgroundColor(ColorStateList.valueOf(getColor(R.color.purple_500)));
            imageButton.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.softer_grey)));
        }
        else{
            soundPool.pause(streamID);
            cardView.setCardBackgroundColor(ColorStateList.valueOf(getColor(R.color.softer_grey)));
            imageButton.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.soft_grey)));
        }
        return streamID;
    }
    private float getVolumeFromSeekBar(SeekBar seekBar){
        return (float) (1 - (Math.log(MAX_VOLUME - seekBar.getProgress()) / Math.log(MAX_VOLUME)));
    }

    private float getInitVolume(){
        return (float) (1 - (Math.log(MAX_VOLUME - MainActivity.DEFAULT_VOLUME) / Math.log(MAX_VOLUME)));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        soundPool.release();
        soundPool = null;
    }
}