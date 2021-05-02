package com.example.BookStore.Service.imp;

import com.example.BookStore.Model.Image;
import com.example.BookStore.Repository.ImageRepository;
import com.example.BookStore.Service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Service
public class ImageServiceImp implements ImageService {
    @Autowired
    ImageRepository imageRepository;
    @Override
    public void saved(MultipartFile file)  {

    Image image =new Image();
        try {
            image.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        imageRepository.save(image);

    }

    @Override
    public List<Image>  allImages() {
       return imageRepository.findAll();
    }
}
