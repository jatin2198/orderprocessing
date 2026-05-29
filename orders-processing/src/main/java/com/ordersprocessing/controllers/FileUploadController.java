package com.ordersprocessing.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ordersprocessing.model.FileMetadata;
import com.ordersprocessing.repo.MetadataStore;
import com.ordersprocessing.services.KafkaProducerService;


import java.io.File;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/files")
public class FileUploadController {

 @Autowired
 private KafkaProducerService producerService;
 
 @Autowired
 private FileMetadata fileMetadata;

 @PostMapping("/upload")
 public String uploadFile(
         @RequestParam("file") MultipartFile file)
         throws Exception {

     File folder = new File("uploads");

     if (!folder.exists()) {
         folder.mkdir();
     }

     String filePath =
             "uploads/" + file.getOriginalFilename();

     File dest = new File(filePath);

     file.transferTo(dest);
     

     FileMetadata metadata =
             new FileMetadata();

     metadata.setFileName(
             file.getOriginalFilename());

     metadata.setUploadTime(
             LocalDateTime.now());

     metadata.setStatus("UPLOADED");

     MetadataStore.metadataList
             .add(metadata);

     producerService.sendMessage(filePath);

     return "File Uploaded Successfully";
 }
}
