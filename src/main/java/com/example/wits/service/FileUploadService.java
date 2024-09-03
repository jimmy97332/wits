package com.example.wits.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileUploadService {

    // dictionary where files are stored
    @Value("${file.upload-dir}")
    private String UPLOAD_DIR;

    public String uploadFile(MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            throw new IllegalArgumentException("no files");
        }

        // Validate file types
        String fileType = file.getContentType();
        if (!(fileType.equals("image/jpeg") || fileType.equals("image/png") || fileType.equals("application/pdf"))) {
            throw new IllegalArgumentException("illegal file type");
        }

        File dir = new File(UPLOAD_DIR);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        String fileName = file.getOriginalFilename();
        Path path = Paths.get(UPLOAD_DIR + fileName);
        Files.write(path, file.getBytes());

        return path.toString();
    }
}
