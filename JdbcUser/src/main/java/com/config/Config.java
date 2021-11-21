package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;

@Configuration
public class Config {

    // Expects sql data in tables and columns with default names.
    // Default names are defined in data.sql
//    @Bean
//    public UserDetailsService userDetailsService(DataSource dataSource) {
//        return new JdbcUserDetailsManager(dataSource);
//    }

    // Allows to customize names of tables and columns with userDetails data
    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {
        String usersQuery = "select username, password, enabled from spring.users where username = ?";
        String authsQuery = "select username, authority from spring.authorities where username = ?";

        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
        userDetailsManager.setUsersByUsernameQuery(usersQuery);
        userDetailsManager.setAuthoritiesByUsernameQuery(authsQuery);
        return userDetailsManager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
