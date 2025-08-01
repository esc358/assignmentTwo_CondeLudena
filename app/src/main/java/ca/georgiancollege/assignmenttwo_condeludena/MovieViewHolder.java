package ca.georgiancollege.assignmenttwo_condeludena;

import androidx.recyclerview.widget.RecyclerView;

import ca.georgiancollege.assignmenttwo_condeludena.databinding.MovieItemBinding;

public class MovieViewHolder extends RecyclerView.ViewHolder {
    MovieItemBinding movieItemBinding;

    //constructor using binding view
    public MovieViewHolder(MovieItemBinding movieItemBinding) {
        super(movieItemBinding.getRoot());
        this.movieItemBinding = movieItemBinding;
    }
}
