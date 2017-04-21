package top.treegrowth.consumer.security.model;

import org.springframework.security.core.authority.AuthorityUtils;
import top.treegrowth.model.entity.User;

/**
 * @author wusi
 * @version 2017/4/21 21:23.
 */
public class TgUserFactory {

    public static TgUser get(User user) {
        return new TgUser(
              user.getId(),
                user.getRoleId(),
                user.getName(),
                user.getPhone(),
                user.getPassword(),
                user.getRegisterTime(),
                AuthorityUtils.commaSeparatedStringToAuthorityList("ADMIN, ROOT, USER"),
                user.getLastPasswordReset()
        );
    }
}
