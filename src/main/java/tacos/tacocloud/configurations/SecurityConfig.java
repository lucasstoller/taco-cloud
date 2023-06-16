package tacos.tacocloud.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import tacos.tacocloud.entities.User;
import tacos.tacocloud.repositories.UserRepository;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository) {
        return username -> {
            User user = userRepository.findByUsername(username);
            if (user != null) return user;

            String errMessage = String.format("User '%s' not found", username);
            throw new UsernameNotFoundException(errMessage);
        };
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
         http
            .authorizeRequests()
                .antMatchers("/design", "/orders", "/orders/**").hasRole("USER")
                .antMatchers("/h2-console/**").permitAll()
                .antMatchers("/", "/**").permitAll()
            .and().csrf().disable();

         http
             .headers().frameOptions().sameOrigin()
                .and()
                    .formLogin()
                        .loginPage("/login")
                        .defaultSuccessUrl("/design");
         return http.build();
    }
}
