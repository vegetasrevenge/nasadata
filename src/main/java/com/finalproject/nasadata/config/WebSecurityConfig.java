package com.finalproject.nasadata.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
            .csrf()
            .requireCsrfProtectionMatcher(new AntPathRequestMatcher("**/login"))
            .and()
            .authorizeRequests()
            .antMatchers("/googleb495abb535b82d92.html", "/login", "/about", "/if_meteor_749391.png",
                    "/", "/map", "/register", "/api/meteorites",
                    "/api/search_by_details", "../static/map_style.css",
                    "/static/map_style.css", "map_style.css", "/map_style.css").permitAll()
            .anyRequest().authenticated()
            .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .defaultSuccessUrl("/map", true)
                .and()
            .logout()
                .permitAll()
                .logoutSuccessUrl("/map");
        System.out.println("**************************Configure method is firing: " + http + "**********************************");

    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(this.dataSource)
                .usersByUsernameQuery("select username, password, enabled from users where username=?");
//                .authoritiesByUsernameQuery("select username, authority from authority where username = ?");
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder;
    }
}
