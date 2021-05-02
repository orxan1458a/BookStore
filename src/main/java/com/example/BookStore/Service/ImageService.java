package com.example.BookStore.Service;

import com.example.BookStore.Model.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ImageService {
    void saved( MultipartFile file) throws IOException;
    List<Image>  allImages();

}
