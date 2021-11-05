package com.example.product.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Configuration
@EnableWebSecurity
/* To enable authentication and authorization support in
spring boot rest apis, we can configure a utility class WebSecurityConfigurerAdapter.
It helps in requiring the user to be authenticated prior to accessing any configured URL
 (or all urls) within our application. */
public class SecurityConfig extends WebSecurityConfigurerAdapter {
   /* @Override
    protected void configure(HttpSecurity htppSecurity) throws Exception {
        htppSecurity.authorizeRequests().anyRequest().authenticated()
                .and().httpBasic();
    }
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.inMemoryAuthentication()
                .withUser("user1").password(passwordEncoder().encode("password"))
                .authorities("ROLE_USER");
    } */
   //Credentials hardcoded
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/", "/home").permitAll()
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .loginPage("/login")
            .permitAll()
            .and()
            .logout()
            .permitAll();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user =
            User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user);
    }

    /* Credentials in Database
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authentication)
            throws Exception {
        // use jdbc authentication (for in memory authentication use authentication.inMemoryAuthentication())
        authentication.jdbcAuthentication()
                .dataSource(dataSource)
                .authoritiesByUsernameQuery("select username,authority "
                        + "from authorities "
                        + "where username = ?")
                .usersByUsernameQuery(
                        "select username, password, 'true' as enabled from users where username = ?");

    } */

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
