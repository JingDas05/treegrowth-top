package top.treegrowth.consumer.security.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import top.treegrowth.consumer.security.model.TgUserFactory;
import top.treegrowth.consumer.service.UserService;
import top.treegrowth.model.entity.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private UserService userService;

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
