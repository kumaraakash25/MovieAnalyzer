package com.repository;

import com.model.MovieReview;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MovieReviewRepository extends CrudRepository<MovieReview, Long>{

    List<MovieReview> findByMovieId(Long movieId);

    List<MovieReview> findByReviewTimeGreaterThanEqualAndMovieId(long reviewDate, Long movieId);
}
