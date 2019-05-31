package ru.vsu.amm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.sql.DataSource;

/**
 * Spring security configurartion class
 * @author Alena Pominova
 * @version 1.0
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    @Bean(name = "dataSource")
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("org.postgresql.Driver");
        driverManagerDataSource.setUrl("jdbc:postgresql://localhost:5433/postgres");
        driverManagerDataSource.setUsername("postgres");
        driverManagerDataSource.setPassword("postgres");
        return driverManagerDataSource;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(11);
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder())
//                .usersByUsernameQuery("select email, password, 1 as enabled from \"user\" where email=?")
//                .authoritiesByUsernameQuery("SELECT U.email as username, R.name as role FROM public.user U\n" +
//                        "join public.role R\n" +
//                        "on U.role_id = R.role_id\n" +
//                        "where U.email =?");
        auth.inMemoryAuthentication().withUser("ivanov@mail.ru").password("ivanov").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("petrov@gmail.com").password("petrov").roles("USER");
    }

    @Bean
    public AuthenticationSuccessHandler successHandler() {
        return new MyCustomLoginSuccessHandler("/map");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/map", "/singup", "/singin", "/resources/**", "/profile").permitAll()
                .antMatchers("/admin").hasRole("ADMIN").anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/singin").failureUrl("/singin?error")
                .usernameParameter("email").passwordParameter("password")
                .successHandler(successHandler()).permitAll()
                .and()
                .logout().logoutSuccessUrl("/singin?logout")
                .and()
                .csrf().disable();
    }
}
