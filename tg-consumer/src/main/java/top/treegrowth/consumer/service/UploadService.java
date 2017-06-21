package top.treegrowth.consumer.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @author wusi
 * @version 2017/6/21 22:03.
 */
@FeignClient("provider")
@RequestMapping(value = "api/service/")
public interface UploadService {

    @RequestMapping(value = "/upload", method = POST)
    ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile uploadFile);
}
