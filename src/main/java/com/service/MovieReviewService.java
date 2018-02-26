package com.service;

import com.model.MovieReview;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.repository.MovieReviewRepository;

import java.util.Date;
import java.util.List;

@Service
public class MovieReviewService {
    @Autowired
    private MovieReviewRepository movieReviewRepository;

    final Log LOG = LogFactory.getLog(this.getClass());

    public List<MovieReview> fetchListForMovieId(final Long movieId, final Date reviewDate) {
        if (reviewDate == null) {
            LOG.info("Query the database with the movieId");
            return movieReviewRepository.findByMovieId(movieId);
        }
        final Long reviewTime = reviewDate.getTime();
        LOG.info("Query the database with movieID and date");
        return movieReviewRepository.findByReviewTimeGreaterThanEqualAndMovieId(reviewTime, movieId);
    }

}
