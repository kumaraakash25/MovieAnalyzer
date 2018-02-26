package com.model;

import javax.persistence.*;

@Entity
public class MovieReview {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private long id;
    @Column(name = "USER_ID", nullable = false)
    private int userId;
    @Column(name = "MOVIE_ID", nullable = false)
    private long movieId;
    @Column(name = "RATING", nullable = false)
    private float rating;
    @Column(name = "REVIEW_TIME", nullable = false)
    private long reviewTime;


    public MovieReview(int userId, long movieId, float rating, long reviewTime) {
        this.userId = userId;
        this.movieId = movieId;
        this.rating = rating;
        this.reviewTime = reviewTime;
    }

    public MovieReview() {
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public long getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public long getReviewTime() {
        return reviewTime;
    }

    public void setReviewTime(long reviewTime) {
        this.reviewTime = reviewTime;
    }
}
