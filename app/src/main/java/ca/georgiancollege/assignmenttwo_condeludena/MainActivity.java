/*
 * Emilio Sebastian Conde Ludena
 * 200478144
 * July 29, 2025
 * 10:00am
 * */
package ca.georgiancollege.assignmenttwo_condeludena;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import ca.georgiancollege.assignmenttwo_condeludena.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    //initialize binding for activity_main.xml
    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //assign binding to layout
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());
    }
}