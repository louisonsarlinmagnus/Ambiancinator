package com.example.ambiancinator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    private final static int MAX_VOLUME = 100;
    private final static float DEFAULT_VOLUME = .2f;
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


//###############################--OiseauxForet--###############################\\

        /*On note les références des boutons et image etc*/
        ImageButton ibOiseauxForet = findViewById(R.id.ImageButton_OiseauxForet);
        CardView cvOiseauxForet = findViewById(R.id.CardView_OiseauxForet);
        SeekBar sbOiseauxForet = findViewById(R.id.SeekBar_OiseauxForet);
        final MediaPlayer mpOiseauxForet = MediaPlayer.create(this,R.raw.oiseauxforet);
        mpOiseauxForet.setVolume(DEFAULT_VOLUME, DEFAULT_VOLUME);

        /*On créer les action si on appui ou on bouge*/
        ibOiseauxForet.setOnClickListener(v -> {
            isOiseauxForetChecked = !isOiseauxForetChecked;
            toggleBouton(isOiseauxForetChecked, mpOiseauxForet, ibOiseauxForet, cvOiseauxForet);

        });
        sbOiseauxForet.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float volume = (float) (1 - (Math.log(MAX_VOLUME - sbOiseauxForet.getProgress()) / Math.log(MAX_VOLUME)));
                mpOiseauxForet.setVolume(volume, volume);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

//###############################--Feuilles--###############################\\

        /*On note les références des boutons et image etc*/
        ImageButton ibFeuilles = findViewById(R.id.ImageButton_Feuilles);
        CardView cvFeuilles = findViewById(R.id.CardView_Feuilles);
        SeekBar sbFeuilles = findViewById(R.id.SeekBar_Feuilles);
        final MediaPlayer mpFeuilles = MediaPlayer.create(this,R.raw.feuilles);
        mpFeuilles.setVolume(DEFAULT_VOLUME, DEFAULT_VOLUME);

        /*On créer les action si on appui ou on bouge*/
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

        /*On note les références des boutons et image etc*/
        ImageButton ibFeuDeCamp = findViewById(R.id.ImageButton_FeuDeCamp);
        CardView cvFeuDeCamp = findViewById(R.id.CardView_FeuDeCamp);
        SeekBar sbFeuDeCamp = findViewById(R.id.SeekBar_FeuDeCamp);
        final MediaPlayer mpFeuDeCamp = MediaPlayer.create(this,R.raw.feudecamp);
        mpFeuDeCamp.setVolume(DEFAULT_VOLUME, DEFAULT_VOLUME);

        /*On créer les action si on appui ou on bouge*/
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

        /*On note les références des boutons et image etc*/
        ImageButton ibOiseaux = findViewById(R.id.ImageButton_Oiseaux);
        CardView cvOiseaux = findViewById(R.id.CardView_Oiseaux);
        SeekBar sbOiseaux = findViewById(R.id.SeekBar_Oiseaux);
        final MediaPlayer mpOiseaux = MediaPlayer.create(this,R.raw.oiseaux);
        mpOiseaux.setVolume(DEFAULT_VOLUME, DEFAULT_VOLUME);

        /*On créer les action si on appui ou on bouge*/
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

        /*On note les références des boutons et image etc*/
        ImageButton ibRuisseau = findViewById(R.id.ImageButton_Ruisseau);
        CardView cvRuisseau = findViewById(R.id.CardView_Ruisseau);
        SeekBar sbRuisseau = findViewById(R.id.SeekBar_Ruisseau);
        final MediaPlayer mpRuisseau = MediaPlayer.create(this,R.raw.ruisseau);
        mpRuisseau.setVolume(DEFAULT_VOLUME, DEFAULT_VOLUME);

        /*On créer les action si on appui ou on bouge*/
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

        /*On note les références des boutons et image etc*/
        ImageButton ibCheminee = findViewById(R.id.ImageButton_Cheminee);
        CardView cvCheminee = findViewById(R.id.CardView_Cheminee);
        SeekBar sbCheminee = findViewById(R.id.SeekBar_Cheminee);
        final MediaPlayer mpCheminee = MediaPlayer.create(this,R.raw.cheminee);
        mpCheminee.setVolume(DEFAULT_VOLUME, DEFAULT_VOLUME);

        /*On créer les action si on appui ou on bouge*/
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

        /*On note les références des boutons et image etc*/
        ImageButton ibCote = findViewById(R.id.ImageButton_Cote);
        CardView cvCote = findViewById(R.id.CardView_Cote);
        SeekBar sbCote = findViewById(R.id.SeekBar_Cote);
        final MediaPlayer mpCote = MediaPlayer.create(this,R.raw.cote);
        mpCote.setVolume(DEFAULT_VOLUME, DEFAULT_VOLUME);

        /*On créer les action si on appui ou on bouge*/
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

        /*On note les références des boutons et image etc*/
        ImageButton ibVent = findViewById(R.id.ImageButton_Vent);
        CardView cvVent = findViewById(R.id.CardView_Vent);
        SeekBar sbVent = findViewById(R.id.SeekBar_Vent);
        final MediaPlayer mpVent = MediaPlayer.create(this,R.raw.vent);
        mpVent.setVolume(DEFAULT_VOLUME, DEFAULT_VOLUME);

        /*On créer les action si on appui ou on bouge*/
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

        /*On note les références des boutons et image etc*/
        ImageButton ibPluie = findViewById(R.id.ImageButton_Pluie);
        CardView cvPluie = findViewById(R.id.CardView_Pluie);
        SeekBar sbPluie = findViewById(R.id.SeekBar_Pluie);
        final MediaPlayer mpPluie = MediaPlayer.create(this,R.raw.pluie);
        mpPluie.setVolume(DEFAULT_VOLUME, DEFAULT_VOLUME);

        /*On créer les action si on appui ou on bouge*/
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

        /*On note les références des boutons et image etc*/
        ImageButton ibStress = findViewById(R.id.ImageButton_Stress);
        CardView cvStress = findViewById(R.id.CardView_Stress);
        SeekBar sbStress = findViewById(R.id.SeekBar_Stress);
        final MediaPlayer mpStress = MediaPlayer.create(this,R.raw.stress);
        mpStress.setVolume(DEFAULT_VOLUME, DEFAULT_VOLUME);

        /*On créer les action si on appui ou on bouge*/
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

        /*On note les références des boutons et image etc*/
        ImageButton ibOrage = findViewById(R.id.ImageButton_Orage);
        CardView cvOrage = findViewById(R.id.CardView_Orage);
        SeekBar sbOrage = findViewById(R.id.SeekBar_Orage);
        final MediaPlayer mpOrage = MediaPlayer.create(this,R.raw.orage);
        mpOrage.setVolume(DEFAULT_VOLUME, DEFAULT_VOLUME);

        /*On créer les action si on appui ou on bouge*/
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

    }

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

}