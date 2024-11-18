package org.icet.controller;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.icet.service.FileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/file")
public class FileController {
    private  final FileService service;

    @Value("${project.profile}")
    private String path;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFileHandler(@RequestPart MultipartFile file)throws IOException{
        String uploadFileName = service.uploadFile(path,file);
        return ResponseEntity.ok("File uploaded : "+uploadFileName);
    }
    @GetMapping("/{fileName}")
    public void servFileHandler(@PathVariable String fileName, HttpServletResponse response) throws IOException {
        InputStream resourceFile = service.getResourceFile(path,fileName);
        response.setContentType(MediaType.IMAGE_PNG_VALUE);
        StreamUtils.copy(resourceFile,response.getOutputStream());
    }
}
