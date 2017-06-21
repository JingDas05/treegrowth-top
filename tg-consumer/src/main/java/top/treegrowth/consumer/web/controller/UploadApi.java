package top.treegrowth.consumer.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.treegrowth.consumer.service.UploadService;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @author wusi
 * @version 2017/6/21 21:36.
 */
@RestController
@RequestMapping(value = "api")
public class UploadApi {

    @Autowired
    private UploadService uploadService;

    @RequestMapping(value = "/upload", method = POST)
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile uploadFile) {
        return uploadService.uploadFile(uploadFile);
    }
}
