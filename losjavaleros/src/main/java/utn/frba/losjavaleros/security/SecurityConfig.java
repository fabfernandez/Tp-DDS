package utn.frba.losjavaleros.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.PostConstruct;


@EnableWebSecurity
@Order(101)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

        @Autowired
        private WebApplicationContext applicationContext;

        private CustomUserDetailService userDetailsService;

        @PostConstruct
        public void completeSetup() {
            userDetailsService = applicationContext.getBean(CustomUserDetailService.class);
        }

        @Override
        protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(userDetailsService)
                    .passwordEncoder(encoder())
                    .and()
                    .authenticationProvider(authenticationProvider());
        }

        @Override
        public void configure(WebSecurity web) {
            web.ignoring()
                    .antMatchers("/resources/**");
        }

        @Override
        protected void configure(final HttpSecurity http) throws Exception {
            http.authorizeRequests()
                    .antMatchers("/validar")
                    .permitAll()
                    .antMatchers("/*")
                    .authenticated()
                    .antMatchers("/login")
                    .permitAll()
                    .and()
                    .formLogin()
                    .and()
                    .csrf()
                    .disable();

            //disable frame options to use h2 console
            http.headers().frameOptions().disable();
        }

        @Bean
        public AuthenticationProvider authenticationProvider() {
            final DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
            authProvider.setUserDetailsService(userDetailsService);
            authProvider.setPasswordEncoder(encoder());
            return authProvider;
        }

        @Bean
        public PasswordEncoder encoder() {
            return new BCryptPasswordEncoder(11);
        }

    }
}