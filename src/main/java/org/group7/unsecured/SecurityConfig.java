package org.group7.unsecured;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {


//    @Bean
//    public UserDetailsService users() {
//        UserDetails user = User.builder()
//                .username("user")
//                .password("secretPassword")
//                .roles("USER")
//                .build();
//        return new InMemoryUserDetailsManager(user);
//    }
//
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }


    @Bean
    public SecurityFilterChain config(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(c ->
                        c.requestMatchers("/secured")
                                .authenticated()
                                .requestMatchers("/login")
                                .permitAll()
                                .anyRequest()
                                .permitAll()
                )
                .formLogin(c -> c.defaultSuccessUrl("/secured").loginPage("/login").permitAll().loginProcessingUrl("/login").permitAll())
                .authenticationProvider(new AuthenticationProvider() {
                    @Override
                    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
                        if (authentication.getPrincipal().toString().equals("user") && authentication.getCredentials().toString().equals("s3cret")) {
                            return new UsernamePasswordAuthenticationToken(authentication.getPrincipal(), authentication.getCredentials(), null);
                        } else {
                            return null;
                        }
                    }

                    @Override
                    public boolean supports(Class<?> authentication) {
                        return true;
                    }
                })
                .csrf(AbstractHttpConfigurer::disable)
                .build();
    }


}
