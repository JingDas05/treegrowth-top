package top.treegrowth.provider.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import top.treegrowth.provider.service.ICodeService;
import top.treegrowth.provider.serviceImpl.exception.AaliApiException;
import top.treegrowth.provider.serviceImpl.exception.ForbiddenException;
import top.treegrowth.provider.serviceImpl.exception.ServiceException;
import top.treegrowth.redis.dao.RedisDao;

import static com.google.common.base.Strings.isNullOrEmpty;
import static top.treegrowth.common.utils.Conditions.checkState;

/**
 * @author wusi
 * @version 2017/2/7.
 */
@Service
public class CodeServiceImpl implements ICodeService {

    @Autowired
    private RedisDao redisDao;
    private static final String url = "http://gw.api.taobao.com/router/rest";
    @Value(value = "${top.treegrowth.sms.app-key}")
    private String key;
    @Value(value = "${top.treegrowth.sms.app-secret}")
    private String secret;
    @Value(value = "${top.treegrowth.sms.sign-name}")
    private String signName;
    @Value(value = "${top.treegrowth.sms.template-id}")
    private String templateId;
    private final static String smsType = "normal";

    @Override
    public void sendIdentifyCode(String phone, String code) throws ServiceException {

    }
}
