package com.example.workpost.controllers;

import com.example.workpost.services.FilesServise;
import org.apache.catalina.util.IOTools;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@RestController
@RequestMapping("/files")
public class FilesController {
    private final FilesServise filesServise;

    public FilesController(FilesServise filesServise) {
        this.filesServise = filesServise;
    }

    @GetMapping(value = "/export/ingridient")
    public ResponseEntity<InputStreamResource> dowloadDataFile() throws FileNotFoundException {
        File file = filesServise.getDataFile();
        if (file.exists()) {
            InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .contentLength(file.length())
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"IngridientData.json\"")
                    .body(resource);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping(value = "/export/recipe")
    public ResponseEntity<InputStreamResource> dowloadRecipeFile() throws FileNotFoundException {
        File file = filesServise.getRecipeFile();
        if (file.exists()) {
            InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .contentLength(file.length())
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"RecipeData.json\"")
                    .body(resource);
        } else {
            return ResponseEntity.noContent().build();
        }
    }
    @GetMapping(value = "/download")
    public ResponseEntity<InputStreamResource> dowloadRecipeFile1() throws FileNotFoundException {
        File file = filesServise.getRecipeFile();
        if (file.exists()) {
            InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .contentLength(file.length())
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"RecipeData.txt\"")
                    .body(resource);
        } else {
            return ResponseEntity.noContent().build();
        }
    }


    @PostMapping(value = "/import/ingridients",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> upLoadFile(@RequestParam MultipartFile file) {
        filesServise.cleanDataFile();
        File ingridient = filesServise.getDataFile();

        try (FileOutputStream fos = new FileOutputStream(ingridient)) {
            IOUtils.copy(file.getInputStream(), fos);
            return ResponseEntity.ok().build();
        }  catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
    @PostMapping(value = "/import/recipe",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> upRecipeFile(@RequestParam MultipartFile file) {
        filesServise.cleanRecipeFile();
        File ingridient = filesServise.getDataFile();

        try (FileOutputStream fos = new FileOutputStream(ingridient)) {
            IOUtils.copy(file.getInputStream(), fos);
            return ResponseEntity.ok().build();
        }  catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

}
