package ca.georgiancollege.assignmenttwo_condeludena;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import ca.georgiancollege.assignmenttwo_condeludena.databinding.MovieItemBinding;

public class MovieAdapter extends RecyclerView.Adapter<MovieViewHolder> {

    //instantiate a list of movie models ans an arraylist
    private List<MovieModel> movieList = new ArrayList<>();

    //void method takes list of movie models assign movies to moviesList and notifydatasetchanged
    @SuppressLint("NotifyDataSetChanged")
    public void submitList(List<MovieModel> movies) {
        this.movieList = movies;
        notifyDataSetChanged();
    }

    //method to bind movie item
    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Use View Binding to inflate
        MovieItemBinding binding = MovieItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MovieViewHolder(binding);
    }

    //metho to populate movie item
    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        //get position in list from movie
        MovieModel movie = movieList.get(position);

        //from MovieViewHolder use binding to set value using get methods from Movie Model
        holder.movieItemBinding.movieTextName.setText(movie.getTitle());
        holder.movieItemBinding.yearTextName.setText(movie.getYear());
        holder.movieItemBinding.ratingTextName.setText(movie.getRatingValue());

        //assign movie poster to url
        String posterUrl = movie.getPoster();
        //if poster is not null
        if (posterUrl != null) {
            Picasso.get()
                    .load(posterUrl)
                    //set placeholder
                    .placeholder(R.drawable.no_poster)
                    // on failure
                    .error(      R.drawable.no_poster)
                    .fit()
                    .centerCrop()
                    .into(holder.movieItemBinding.imageView);
        } else {
            // no valid url show no poster
            holder.movieItemBinding.imageView.setImageResource(R.drawable.no_poster);
        }
    }

    //method to count the list size
    @Override
    public int getItemCount() {
        return movieList.size();
    }
}
