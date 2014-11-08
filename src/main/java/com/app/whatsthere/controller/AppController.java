package com.app.whatsthere.controller;

import com.app.whatsthere.data.Image;
import com.app.whatsthere.exception.ImageToOldException;
import com.app.whatsthere.manager.ImageStore;
import com.app.whatsthere.transformers.ToJsonTransformer;
import com.app.whatsthere.transformers.MessageTransformer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/data")
public class AppController {

    private final ImageStore imageStore = new ImageStore();
    private final MessageTransformer<Image> transformer = new ToJsonTransformer();


    @RequestMapping(value = "/image/store", method = RequestMethod.GET)
    public ResponseEntity<Image> storeImage(@RequestBody String data) {
        Image imageToStore = transformer.transform(data);
        try {
            imageStore.storeImage(imageToStore);
        } catch (ImageToOldException e) {
            e.getImageId();
        }
        return new ResponseEntity<Image>(imageToStore, HttpStatus.OK);
    }
}