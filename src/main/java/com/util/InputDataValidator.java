package com.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Calendar;
import java.util.Date;

public class InputDataValidator {

    private static Log LOG = LogFactory.getLog(InputDataValidator.class);

    public static void validateMovieId(final Long movieId) throws InvalidDataException {
        if (movieId == null) {
            LOG.error("Entered movieID is not valid");
            throw new InvalidDataException("MovieId is invalid " + movieId);
        }
    }

    public static void validateDate(final Date filterDate) throws InvalidDataException {
        if (filterDate == null) {
            return;
        }
        Calendar cal = Calendar.getInstance();
        cal.setLenient(false);
        cal.setTime(filterDate);
        try {
            cal.getTime();
        } catch (Exception e) {
            LOG.error("Entered date is invalid", e);
            throw new InvalidDataException("Entered date is not in valid format " + filterDate);
        }
    }

}
