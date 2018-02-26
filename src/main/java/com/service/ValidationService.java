package com.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import com.util.InputDataValidator;
import com.util.InvalidDataException;

import java.util.Date;

@Service
public class ValidationService {

    final Log LOG = LogFactory.getLog(this.getClass());

    public void validateInput(final Long movieId, final Date filterDate) throws InvalidDataException, InvalidDataException {
        LOG.info("Validating input fields");
        InputDataValidator.validateMovieId(movieId);
        InputDataValidator.validateDate(filterDate);
    }


}
