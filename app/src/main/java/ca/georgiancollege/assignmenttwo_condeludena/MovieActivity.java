/*
 * Emilio Sebastian Conde Ludena
 * 200478144
 * July 31, 2025
 * 5:40pm
 * */
package ca.georgiancollege.assignmenttwo_condeludena;

import android.os.Bundle;
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
        //instantiate firebase
        db = FirebaseFirestore.getInstance();
        //TODO: reuse views from movies recycler view

    }
}