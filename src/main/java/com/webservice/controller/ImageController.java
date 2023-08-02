package com.webservice.controller;

import com.webservice.model.Image;
import com.webservice.service.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/image")
public class ImageController {
    @Autowired
    IImageService iImageService;

    @GetMapping
    public ResponseEntity<List<Image>> getAll() {
        return new ResponseEntity<>(iImageService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Image> createImage(@RequestBody Image image) {
        return new ResponseEntity<>(iImageService.create(image), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Image> editImage(@RequestBody Image image) {
        return new ResponseEntity<>(iImageService.edit(image), HttpStatus.OK);
    }

    @DeleteMapping
    public void deleteImage(@RequestBody Image image) {
        iImageService.deleteById(image.getId());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Image> findImageById(@PathVariable int id) {
        return new ResponseEntity<>(iImageService.getById(id), HttpStatus.OK);
    }
}
