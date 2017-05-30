package br.com.herdeirosdofuturo.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class FileSaver {

    @Autowired
    private HttpServletRequest request;

    public String write(String baseFolder, MultipartFile file) {
        try {
            String realPath = request.getServletContext().getRealPath("/" + baseFolder);

            if (! new File(realPath).exists()){
                new File(realPath).mkdir();
            }

            byte[] bytes = file.getBytes();
            Path finalPath = Paths.get(realPath, file.getOriginalFilename());
            Files.write(finalPath, bytes);

            return finalPath.toUri().toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
