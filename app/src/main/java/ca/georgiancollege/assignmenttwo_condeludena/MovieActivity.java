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
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import ca.georgiancollege.assignmenttwo_condeludena.databinding.ActivityMovieBinding;

public class MovieActivity extends AppCompatActivity {
    //initialize binding MovieAdapter, MovieViewModel
    ActivityMovieBinding activityMovieBinding;
    private MovieAdapter movieAdapter;
    private MovieViewModel movieViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //assign binding to layout
        activityMovieBinding = ActivityMovieBinding.inflate(getLayoutInflater());
        setContentView(activityMovieBinding.getRoot());

        //setup RecyclerView with Adapter
        movieAdapter = new MovieAdapter();
        activityMovieBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        activityMovieBinding.recyclerView.setAdapter(movieAdapter);

        //setup ViewModel
        movieViewModel = new ViewModelProvider(this).get(MovieViewModel.class);

        //observe LiveData and update RecyclerView automatically
        movieViewModel.getMovies().observe(this, movies -> {
            if (movies != null) {
                movieAdapter.submitList(movies);
            }
        });

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