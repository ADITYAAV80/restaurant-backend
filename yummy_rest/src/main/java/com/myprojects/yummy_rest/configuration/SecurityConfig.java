package org.myprojects.yummy_rest.configuration;

import lombok.RequiredArgsConstructor;
import org.myprojects.yummy_rest.helper.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig /*implements WebMvcConfigurer*/ {
//    private final RequestInterceptor requestInterceptor;

    /*@Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(requestInterceptor)
        .addPathPatterns("/**")
        .excludePathPatterns("/api/v1/auth/**")
        .excludePathPatterns("/api/v1/customer/**")
        ;
    }*/

    @Bean
    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
        return new Argon2PasswordEncoder(16, 32,1,16 * 1024,4);
    }
}
