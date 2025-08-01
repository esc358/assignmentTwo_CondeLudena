/*
 * Emilio Sebastian Conde Ludena
 * 200478144
 * August 1, 2025
 * 2:20am
 * From: https://github.com/esc358/assignmentOne_CondeLudena*/
package ca.georgiancollege.assignmenttwo_condeludena;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class MovieViewModel extends ViewModel {
    //instantiate firebase db and mutable live data passing a list of Movie Model and collection reference for Moview
    private final FirebaseFirestore db = FirebaseFirestore.getInstance();
    private final MutableLiveData<List<MovieModel>> moviesLiveData = new MutableLiveData<>();
    private final CollectionReference collectionReference = db.collection("Movies");

    //get method that load movies and return movies live data
    public LiveData<List<MovieModel>> getMovies() {
        loadMovies();
        return moviesLiveData;
    }

    // load all movies from Firebase
    public void loadMovies() {
        //get method from firebase on listener
        collectionReference.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                //instantiate a list of movie list as a new array list
                List<MovieModel> movieList = new ArrayList<>();
                //loop throguh queryducmentsnapshot adding new doc to moview mode and adding moview to movie list
                for (QueryDocumentSnapshot doc : queryDocumentSnapshots) {
                    MovieModel movie = doc.toObject(MovieModel.class);
                    movieList.add(movie);
                }
                //setvalue of live data to movie list
                moviesLiveData.setValue(movieList);
            }
        });
    }
    // add a movie to Firebase
    public void addMovie(MovieModel movie) {
        collectionReference.add(movie);
    }
}
