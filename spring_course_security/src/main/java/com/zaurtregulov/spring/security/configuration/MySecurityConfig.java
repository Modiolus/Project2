package com.zaurtregulov.spring.security.configuration;

//import com.sun.tools.javac.comp.Todo;

import org.graalvm.compiler.lir.StandardOp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity // помечает класс ответственный за security конфигурацию. Если перейти по этой аннотации
// то видно что клас помечен @Configuration а значит здесь нам не нужно прописывать @Configuration
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource; // создаём ссылку на DataSource в MyConfig

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication().dataSource(dataSource); // подключает к БД - через описанные данные в DataSource для подключения к БД
//        auth.jdbcAuthentication().dataSource(dataSource)
//                .passwordEncoder(passwordEncoder())
//                .usersByUsernameQuery("select username,password,enabled from `users` where username = ?") //SQL query
//                .authoritiesByUsernameQuery("select username,authority from `authorities` where username = ?"); //SQL query

//        закоментированный код ниже поозвооляет прописать данные прямо в коде без БД
//        UserBuilder userBuilder = User.withDefaultPasswordEncoder(); // дефолтное шифрование паролей
//        auth.inMemoryAuthentication()
//                .withUser(userBuilder.username("zaur")
//                        .password("zaur")
//                        .roles("EMPLOYEE"))
//                .withUser(userBuilder.username("elena")
//                        .password("elena")
//                        .roles("HR"))
//                .withUser(userBuilder.username("ivan")
//                        .password("ivan")
//                        .roles("MANAGER", "HR"));

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {  //
        http.authorizeRequests()  // авторизация url-ов - т.е. разрешение конкректных урлов конкретным ролям
                .antMatchers("/").hasAnyRole("EMPLOYEE", "HR", "MANAGER")  // такой адрес "/" могут просматривать роли в скобках
                .antMatchers("/hr_info").hasRole("HR")
                .antMatchers("/manager_info/**").hasRole("MANAGER")
                .and().formLogin().permitAll()  // логин и пароль будут запрашиваться у всех
                .and().logout().permitAll();

    }
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        PasswordEncoder encoder = new BCryptPasswordEncoder(20);
//        return encoder;
//    }

// TODO: 07.05.2022 вне рамках курса проверить работу кода ниже
//    user.setPassword(BCrypt.hashpw(password, BCrypt.gensalt(4)))



}
