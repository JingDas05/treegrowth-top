package top.treegrowth.provider.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @author wusi
 * @version 2017/6/21 21:41.
 */
public interface IUploadService {

    void saveUploadedFiles(List<MultipartFile> files) throws IOException;
}
