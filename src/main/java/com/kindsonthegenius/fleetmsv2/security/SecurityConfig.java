//package com.kindsonthegenius.fleetmsv2.security;
//
//
//import com.kindsonthegenius.fleetmsv2.security.services.AuthService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true, jsr250Enabled = true)
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    AuthService authService;
//
//    @Autowired
//    JwtFilter jwtFilter;
//
//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder() {
//
//        return new BCryptPasswordEncoder();
//    }
//
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .cors().disable()
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//
//                .authorizeRequests()
//                .antMatchers("/login", "/resources/**", "/css/**", "/fonts/**", "/img/**").permitAll()
//                .antMatchers("/register", "/resources/**", "/css/**", "/fonts/**", "/img/**", "/js/**").permitAll()
//                .antMatchers("/users/addNew").permitAll()
//                .antMatchers("/security/user/Edit/**").hasAuthority("ADMIN")
//                .anyRequest().authenticated()
////                .authorizeRequests()
////                .antMatchers("/",
////                        "/favicon.ico",
////                        "//*.png",
////                        "//*.gif",
////                        "//*.svg",
////                        "//*.jpg",
////                        "//*.html",
////                        "//*.css",
////                        "//*.js",
////                        "/swagger-ui.html",
////                        "/swagger-resources/",
////                        "/v2/",
////                        "/csrf",
////                        "/webjars/")
////                .permitAll()
//
//                .and()
//                .formLogin()
//                .loginPage("/login").permitAll()
//                .defaultSuccessUrl("/index")
//                .and()
//                .logout().invalidateHttpSession(true)
//                .clearAuthentication(true)
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                .logoutSuccessUrl("/login").permitAll()
//                .and()
//                .exceptionHandling().accessDeniedPage("/accessDenied")
//        ;
//
//        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(authService);
//    }
//
//    @Override
//    protected AuthenticationManager authenticationManager() throws Exception {
//        return super.authenticationManager();
//    }
//
//    @Bean
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//
//}
