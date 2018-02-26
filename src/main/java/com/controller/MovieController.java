package com.controller;

import com.model.MovieReview;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.service.MovieReviewService;
import com.service.ValidationService;
import com.util.InvalidDataException;
import com.util.ListToJsonUtil;

import java.util.Date;
import java.util.List;

@RestController
public class MovieController {

    @Autowired
    private ValidationService validationService ;

    @Autowired
    private MovieReviewService movieReviewService;

    final Log LOG = LogFactory.getLog(this.getClass());

    @RequestMapping("/fetchMovieReviews/{id}")
    public String fetchMovieReviewByReviewId(@PathVariable("id") Long id, @RequestParam(name = "filterDate", required = false)
            Date filterDate) {
        String errorMessage = validateInput(id, filterDate);
        if(!StringUtils.isEmpty(errorMessage)){
            return errorMessage;
        }
        List<MovieReview> movieList = movieReviewService.fetchListForMovieId(id, filterDate);
        if(CollectionUtils.isEmpty(movieList)){
            LOG.info("Result is empty for the criteria"+ id);
            return "No data found for the movie ID"+id;
        }
        return ListToJsonUtil.returnJson(movieList);
    }

    private String validateInput(final Long movieId, final Date filterDate){
        try {
            validationService.validateInput(movieId, filterDate);
        } catch (InvalidDataException e) {
            LOG.error("Error occurred while parsing the input", e);
            return "Error occurred while parsing the input";
        }
        return null;
    }
}
