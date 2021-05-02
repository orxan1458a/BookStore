package com.example.BookStore.Controller;

import com.example.BookStore.Model.Image;
import com.example.BookStore.Service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ImageController {
    @Autowired
    ImageService imageService;
    @GetMapping("/imageAdd")
    public String imageAdd(){
   // model.addAttribute("image",new Image());
        return "addImage";
    }
    @PostMapping("/imageAdded")
    public String add(@RequestParam("file") MultipartFile file) throws IOException {
        System.out.println("save olundu");
        imageService.saved(file);

        return "addImage";
    }
    @GetMapping("/list")
    public String list(Model model){
        List<Image> images=imageService.allImages();
         model.addAttribute("images",images);
        System.out.println("SEKILLER CAP OLUNDU");

        return "list";
    }
}
