//package org.example.bookstore.security;
//
//import lombok.RequiredArgsConstructor;
//import org.example.bookstore.entities.User;
//import org.example.bookstore.services.UserService;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Set;
//import java.util.stream.Stream;
//
//
//@Service
//@RequiredArgsConstructor
//public class UserSecurityService implements UserDetailsService {
//    private final UserService userService;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userService.getUserByUsernameForTest(username);
//
//        String role = user.getRole();
//
//        List<RolesSecurity> rolesSecurityList = Stream.of(role)
//                .map(RolesSecurity::new)
//                .toList();
//        return UserPrincipal.builder()
//                .username(user.getUsername())
//                .password(user.getPassword())
//                .authorities(rolesSecurityList)
//                .build();
//    }
//
//}
