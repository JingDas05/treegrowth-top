package top.treegrowth.provider.service;

import top.treegrowth.provider.serviceImpl.exception.ServiceException;

/**
 * @author wusi
 * @version 2017/2/7.
 */
public interface ICodeService {

    void sendIdentifyCode(String phone, String code) throws ServiceException;
}
