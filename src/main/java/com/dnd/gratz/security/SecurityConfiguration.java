package com.dnd.gratz.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final GratzOAuthService gratzOAuthService;
    private final OAuthSuccessHandler oAuth2SuccessHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .formLogin().disable()
                .cors()
                .and()
                    .authorizeRequests()
                    .antMatchers("/", "/gratz/**").permitAll()
                    .anyRequest().authenticated()
                .and()
                    .logout().logoutSuccessUrl("/gratz")
                .and()
                    .oauth2Login()
                    .userInfoEndpoint()
                    .userService(gratzOAuthService)
                .and()
                    .successHandler(oAuth2SuccessHandler)
                    .permitAll();
    }
}
