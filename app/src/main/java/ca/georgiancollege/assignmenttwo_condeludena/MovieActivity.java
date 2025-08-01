/*
 * Emilio Sebastian Conde Ludena
 * 200478144
 * July 31, 2025
 * 5:40pm
 * */
package ca.georgiancollege.assignmenttwo_condeludena;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.firestore.FirebaseFirestore;
import ca.georgiancollege.assignmenttwo_condeludena.databinding.ActivityMovieBinding;

public class MovieActivity extends AppCompatActivity {
    //initialize binding
    ActivityMovieBinding activityMovieBinding;
    //initialize database
    FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //assign binding to layout
        activityMovieBinding = ActivityMovieBinding.inflate(getLayoutInflater());
        setContentView(activityMovieBinding.getRoot());
        //instantiate firebase
        db = FirebaseFirestore.getInstance();
        //TODO: Logic for creating into database

        //onclick for add button
        activityMovieBinding.addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //initialize new intent to AddEdit
                Intent intentAddEdit = new Intent(getApplicationContext(), AddEdit.class);
                //add intent to change title
                intentAddEdit.putExtra("titleText", "Add Movie");
                startActivity(intentAddEdit);
            }
        });

    }
}