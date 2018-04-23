package top.treegrowth.single.serviceimpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import top.treegrowth.model.entity.User;
import top.treegrowth.single.security.model.TgUserFactory;
import top.treegrowth.single.service.IUserService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IUserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findUserByPhone(username);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("没有找到用户 '%s'.", username));
        } else {
            return TgUserFactory.get(user);
        }
    }

}
