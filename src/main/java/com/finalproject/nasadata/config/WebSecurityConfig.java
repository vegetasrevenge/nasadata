package com.finalproject.nasadata.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
            .authorizeRequests()
            .antMatchers("/", "/map", "/register", "/api/meteorites", "../static/map_style.css", "/static/map_style.css", "map_style.css", "/map_style.css", "/login_post").permitAll()
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
        System.out.println("Configure method firing: " + http);

    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(this.dataSource)
                .usersByUsernameQuery("select username, password from users where username=?")
                .authoritiesByUsernameQuery("select username, authority from authority where username = ?");
    }
}
