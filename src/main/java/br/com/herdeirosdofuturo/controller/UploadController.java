package br.com.herdeirosdofuturo.controller;

import br.com.herdeirosdofuturo.infra.FileSaver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/upload")
public class UploadController {

    @Autowired
    private FileSaver fileSaver;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        String rootPath = fileSaver.write("item-imagens", file);
        return ResponseEntity.ok(rootPath);
    }
}
