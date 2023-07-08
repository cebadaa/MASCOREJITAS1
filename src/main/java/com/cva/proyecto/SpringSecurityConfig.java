package com.cva.proyecto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.cva.proyecto.model.service.UserService;

@Configuration
public class SpringSecurityConfig {

    @Autowired
    private UserService userService;

    @Bean
    public static BCryptPasswordEncoder encriptarPassword(){
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void criptografiaPassword(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userService).passwordEncoder(encriptarPassword());
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests()
        .requestMatchers("/*").permitAll()
        .anyRequest().authenticated()
        .and().formLogin().loginPage("/login/").defaultSuccessUrl("/principal",true).permitAll()
        .and().logout().permitAll();
        return http.build();
    }

    @Bean
    public static BCryptPasswordEncoder encriptarPassword(){
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void criptografiaPassword(AuthenticationManager auth) throws Exception{
        auth.userdetailsService(userService).passwordEncoder(encriptarPassword());
    }
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() throws Exception{
        return (web) -> web.ignoring().requestMatchers("/css/**","/js/**","/img/**","/lib/**","/index");
    }

    // @Bean
    // public InMemoryUserDetailsManager configureAuthentication(){
    //     List<UserDetails> listaUsuarios = new ArrayList<>();
    //     List<GrantedAuthority> rolesAdministradores = new ArrayList<>();
    //     List<GrantedAuthority> rolesUsuarios = new ArrayList<>();

    //     rolesAdministradores.add(new SimpleGrantedAuthority("ADMIN"));
    //     rolesUsuarios.add(new SimpleGrantedAuthority("USER"));

    //     listaUsuarios.add(new User("Administrador", "{noop}123456", rolesAdministradores));
    //     listaUsuarios.add(new User("Jorge", "{noop}123456", rolesUsuarios));

    //     return new InMemoryUserDetailsManager(listaUsuarios);
    // }
    
}
