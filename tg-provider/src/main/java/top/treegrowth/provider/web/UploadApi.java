package top.treegrowth.provider.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.treegrowth.provider.service.IUploadService;

import java.io.IOException;
import java.util.Arrays;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @author wusi
 * @version 2017/6/21 21:36.
 */
@RestController
@RequestMapping(value = "api/service")
public class UploadApi {

    @Autowired
    private IUploadService uploadService;

    @RequestMapping(value = "/upload", method = POST)
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile uploadFile) {
        if (uploadFile.isEmpty()) {
            return new ResponseEntity<>("请选择一个文件", HttpStatus.OK);
        }
        try {
            uploadService.saveUploadedFiles(Arrays.asList(uploadFile));
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("上传成功" + uploadFile.getOriginalFilename(), new HttpHeaders(), HttpStatus.OK);
    }
}
