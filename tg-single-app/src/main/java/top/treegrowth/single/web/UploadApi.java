package top.treegrowth.single.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import top.treegrowth.model.res.UploadResult;
import top.treegrowth.single.service.IUploadService;

import java.io.IOException;
import java.util.Collections;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @author wusi
 * @version 2017/6/21 21:36.
 */
@RestController
@RequestMapping(value = "api")
public class UploadApi {

    @Autowired
    private IUploadService uploadService;

    // 这个地方返回值之前用的 ResponseEntity，很好的返回体，但是没有实现 Serializable 接口
    @RequestMapping(value = "/upload", method = POST)
    public UploadResult uploadFile(@RequestParam("file") MultipartFile uploadFile) {
        String httpPath;
        if (uploadFile.isEmpty()) {
            return null;
        }
        try {
            httpPath = uploadService.saveUploadedFiles(Collections.singletonList(uploadFile));
        } catch (IOException e) {
            e.printStackTrace();
            return new UploadResult("存储失败");
        }
        return new UploadResult(httpPath);
    }
}
