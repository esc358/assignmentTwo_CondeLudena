/*
 * Emilio Sebastian Conde Ludena
 * 200478144
 * July 31, 2025
 * 7:00pam
 * */
package ca.georgiancollege.assignmenttwo_condeludena;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import ca.georgiancollege.assignmenttwo_condeludena.databinding.ActivityAddEditBinding;

public class AddEdit extends AppCompatActivity {
    //initialize binding for activity_main.xml
    ActivityAddEditBinding activityAddEditBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //assign binding to layout
        activityAddEditBinding = ActivityAddEditBinding.inflate(getLayoutInflater());
        setContentView(activityAddEditBinding.getRoot());

        //get the text from Intent
        String titleText = getIntent().getStringExtra("titleText");
        //assign text to intent
        activityAddEditBinding.textMoviesListTitle.setText(titleText);
        activityAddEditBinding.addEditButton.setText(titleText);


        //TODO: Logic for Add Edit



    }
}