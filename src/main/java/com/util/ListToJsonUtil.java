package com.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.MovieReview;

import java.util.List;

public class ListToJsonUtil {

    public static String returnJson(final List<MovieReview> movieReviewlist){
        StringBuffer stringBufer = new StringBuffer();
        for(MovieReview movieReview: movieReviewlist){
            ObjectMapper mapper = new ObjectMapper();
            try {
                stringBufer.append(mapper.writeValueAsString(movieReview));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return stringBufer.toString();
    }
}
