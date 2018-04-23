package top.treegrowth.single.serviceimpl;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import top.treegrowth.single.service.SecurityService;

@Service
public class SecurityServiceImpl implements SecurityService {

  @Override
  public Boolean hasProtectedAccess() {
    return (SecurityContextHolder.getContext().getAuthentication().
            getAuthorities().contains(new SimpleGrantedAuthority("ADMIN")));
  }

}
