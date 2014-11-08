package com.app.whatsthere.manager;

import com.app.whatsthere.dao.ImageDao;
import com.app.whatsthere.dao.ImageDaoImpl;
import com.app.whatsthere.data.Image;
import com.app.whatsthere.exception.ImageToOldException;
import com.app.whatsthere.utils.DateTimeUtils;
import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by guyk on 11/5/14.
 */
public class ImageStore {

    private final ImageDao dao = new ImageDaoImpl();
    private final DateTimeUtils dateTimeUtils = new DateTimeUtils();

    public void storeImage(Image image) throws ImageToOldException {
        if (!dateTimeUtils.ValidateDateTime(image.getTimeOfCapture())) throw new ImageToOldException(image.getId());

    }

    public Image fetchImage(int id) {
        return null;
    }
}

