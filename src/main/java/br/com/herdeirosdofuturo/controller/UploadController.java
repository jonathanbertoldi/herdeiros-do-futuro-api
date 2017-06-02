package br.com.herdeirosdofuturo.controller;

import br.com.herdeirosdofuturo.infra.FileSaver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin
@RestController
@RequestMapping("/api/upload")
public class UploadController {

    @Autowired
    private FileSaver fileSaver;

    private static final String PASTA = "imagens";

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file) {
        String path = fileSaver.write(PASTA, file);
        return ResponseEntity.ok(path);
    }
}
