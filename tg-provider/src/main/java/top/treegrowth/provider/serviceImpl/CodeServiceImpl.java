package top.treegrowth.provider.serviceImpl;

import org.springframework.stereotype.Service;
import top.treegrowth.provider.service.CodeService;

/**
 * @author wusi
 * @version 2017/2/7.
 */
@Service
public class CodeServiceImpl implements CodeService {

    @Override
    public void sendIdentifyCode(String phone, String code) {
        // TODO: 2017/2/7 添加 阿里大于 发送验证码功能
    }
}
