//package org.example.bookstore.security;
//
//import org.example.bookstore.entities.User;
//import org.example.bookstore.services.UserService;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity
//                .httpBasic(Customizer.withDefaults())
//                .formLogin(AbstractHttpConfigurer::disable)
//                .csrf(AbstractHttpConfigurer::disable)
//                .cors(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests(authorizeRequests ->
//                        authorizeRequests
//                                .requestMatchers(HttpMethod.DELETE, "/api/v1/users/{id}").hasRole("ADMIN")
//                                .requestMatchers(HttpMethod.POST, "/api/v1/books").hasRole("ADMIN")
//                                .requestMatchers(HttpMethod.PUT, "/api/v1/books/**").hasRole("ADMIN")
//                                .requestMatchers(HttpMethod.DELETE, "/api/v1/books/**").hasRole("ADMIN")
//                                .requestMatchers(HttpMethod.GET, "/api/v1/users").hasRole("ADMIN")
//                                .requestMatchers(HttpMethod.GET, "/api/v1/users").hasRole("ADMIN")
//                                .requestMatchers(HttpMethod.GET, "/api/v1/books/**").permitAll()
//                                .requestMatchers(HttpMethod.POST, "/api/v1/users/**").anonymous()
//                                .requestMatchers(HttpMethod.POST, "/api/v1/users/{id}/cart/items").authenticated()
//                                .requestMatchers(HttpMethod.POST, "/api/v1/users/{id}/orders").authenticated()
//                                .anyRequest().authenticated()
//                );
//        return httpSecurity.build();
//    }
//
//    @Bean PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public CommandLineRunner initData(UserService userService, PasswordEncoder passwordEncoder) {
//        return args -> {
//            if (userService.getUserByUsernameForTest("admin") == null) {
//                User admin = new User(
//                        "Admin",
//                        "Admin",
//                        "admin",
//                        "admin@example.com",
//                        passwordEncoder.encode("admin"),
//                        "Admin Address",
//                        "ADMIN");
//                userService.createUser(admin);
//            }
//        };
//    }
//}
