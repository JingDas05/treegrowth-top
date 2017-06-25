package top.treegrowth.provider.serviceImpl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import top.treegrowth.provider.service.IUploadService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author wusi
 * @version 2017/6/21 21:41.
 */
@Service
public class UploadServiceImpl implements IUploadService{

    @Value(value = "${top.treegrowth.static-server.uri}")
    private String staticServerUri;
    private static String UPLOADED_FOLDER = "F://temp//";

    public void saveUploadedFiles(List<MultipartFile> files) throws IOException {

        for (MultipartFile file : files) {
            if (file.isEmpty()) {
                continue;
            }
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
        }
    }
}
