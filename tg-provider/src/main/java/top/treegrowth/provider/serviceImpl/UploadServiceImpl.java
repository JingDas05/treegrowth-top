package top.treegrowth.provider.serviceImpl;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import top.treegrowth.common.utils.Generator;
import top.treegrowth.model.res.UploadResult;
import top.treegrowth.provider.config.StaticServerProperties;
import top.treegrowth.provider.service.IUploadService;

import java.io.File;
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
@EnableConfigurationProperties(value = StaticServerProperties.class)
public class UploadServiceImpl implements IUploadService {

    private StaticServerProperties serverProperties;
    private DateTimeFormatter format = DateTimeFormat.forPattern("yyyyMMdd");

    public UploadServiceImpl(StaticServerProperties properties) {
        this.serverProperties = properties;
    }

    public String saveUploadedFiles(List<MultipartFile> files) throws IOException {
        // 构建每日时间，作为子路径
        DateTime now = new DateTime();
        String subPath = now.toString(format);
        // 构建最终路径
        String finalPath = serverProperties.getDataPath() + subPath;
        File fileFolder = new File(finalPath);
        // 如果文件不存在，就依次创建
        if (!fileFolder.exists()) {
            Files.createDirectories(Paths.get(finalPath));
        }
        String fileName = "";
        // 写入文件
        for (MultipartFile file : files) {
            if (file.isEmpty()) {
                continue;
            }
            byte[] bytes = file.getBytes();
            // 防止传入相同的文件，覆盖掉
            fileName = Generator.uuid() + file.getOriginalFilename();
            Path path = Paths.get(finalPath + "/" + fileName);
            Files.write(path, bytes);
        }
        // 目前只上传单个文件，所以只返回一个地址
        return serverProperties.getUri() + subPath + "/" + fileName;
    }
}
