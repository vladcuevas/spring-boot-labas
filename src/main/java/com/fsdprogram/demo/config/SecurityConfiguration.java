package com.fsdprogram.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
    @Autowired
    UserDetailsService userDetailsService;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        final String AUTHENTICATION_TYPE = "JPA";
        // Set your configuration on the auth object

        if (AUTHENTICATION_TYPE.equals("JPA")) {
            auth.userDetailsService(userDetailsService);
        }
        
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().authorizeRequests()
        .antMatchers("/api/admin/").hasAuthority("ADMIN")
        .antMatchers("/api/admin/*").hasAuthority("ADMIN")
        .antMatchers("/api/admin/**").hasAuthority("ADMIN")
        .antMatchers("/api/*").hasAnyAuthority("ADMIN", "USER")
        .and()
          .httpBasic()
        .and().cors().and().csrf().disable()
        .formLogin().disable();

        http.authorizeRequests().antMatchers("/h2-console/**").permitAll()
        .and().headers().frameOptions().sameOrigin();

        // http
        //     .logout()
        //     .logoutUrl("/perform_logout")
        //     .deleteCookies("JSESSIONID")
        //     .clearAuthentication(true)
        //     .invalidateHttpSession(true);
    }

    
    
}
