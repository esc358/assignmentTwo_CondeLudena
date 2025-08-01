/*
 * Emilio Sebastian Conde Ludena
 * 200478144
 * August 1, 2025
 * 2:20am
 * From: https://github.com/esc358/assignmentOne_CondeLudena*/
package ca.georgiancollege.assignmenttwo_condeludena;

public class MovieModel {
    private String title;
    private String ratingValue;
    private String year;
    private String poster;

    public MovieModel() {
    }

    public MovieModel(String title, String ratingValue, String year, String poster) {
        this.title = title;
        this.ratingValue = ratingValue;
        this.year = year;
        this.poster = poster;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRatingValue() {
        return ratingValue;
    }

    public void setRatingValue(String ratingValue) {
        this.ratingValue = ratingValue;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }
}
