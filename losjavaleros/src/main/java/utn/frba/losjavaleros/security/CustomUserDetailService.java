package utn.frba.losjavaleros.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import utn.frba.losjavaleros.model.User;
import utn.frba.losjavaleros.repository.UserRepository;

import javax.annotation.PostConstruct;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private WebApplicationContext applicationContext;

    private UserRepository userRepository;

    @PostConstruct
    public void completeSetup() {
        userRepository = applicationContext.getBean(UserRepository.class);
    }

    @Override
    public UserDetails loadUserByUsername(final String username) {
        final User appUser = userRepository.findByUsername(username);
        if (appUser == null) {
            throw new UsernameNotFoundException(username);
        }
        return new UserPrincipal(appUser);
    }
}