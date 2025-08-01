/*
 * Emilio Sebastian Conde Ludena
 * 200478144
 * July 31, 2025
 * 7:00pam
 * */
package ca.georgiancollege.assignmenttwo_condeludena;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import ca.georgiancollege.assignmenttwo_condeludena.databinding.ActivityAddEditBinding;

public class AddEdit extends AppCompatActivity {
    //initialize binding for activity_main.xml and MovieViewModel
    ActivityAddEditBinding activityAddEditBinding;
    private MovieViewModel movieViewModel;


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

        //instantiate ViewModelProvider using MovieViewModel
        movieViewModel = new ViewModelProvider(this).get(MovieViewModel.class);

        //onclick for addEdit button
        activityAddEditBinding.addEditButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get information from input
                String movieTitle = activityAddEditBinding.editTitle.getText().toString();
                String movieYear = activityAddEditBinding.editYear.getText().toString();
                String movieRating = activityAddEditBinding.editRating.getText().toString();
                String movieImageLink = activityAddEditBinding.editImageLink.getText().toString();

                //use constructor of MovieModel to create a movie instance
                MovieModel newMovie = new MovieModel(movieTitle, movieYear, movieRating, movieImageLink);
                //use addMovie method to add to firebase
                movieViewModel.addMovie(newMovie);

                //initialize new intent to Movie Activity
                Intent intentMovieActivity = new Intent(getApplicationContext(), MovieActivity.class);
                startActivity(intentMovieActivity);
                finish();
            }
        });

        //onclick for back button
        activityAddEditBinding.backMoviesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //initialize new intent to Movie Activity
                Intent intentMovieActivity = new Intent(getApplicationContext(), MovieActivity.class);
                startActivity(intentMovieActivity);
            }
        });



    }
}