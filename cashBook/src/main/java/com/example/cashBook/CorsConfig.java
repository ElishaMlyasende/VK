package com.example.cashBook;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
<<<<<<< HEAD
                .allowedOrigins("http://192.168.100.100:5173")
=======
                .allowedOrigins("http://192.168.100.100:5173", // wakati wa development (vite dev server)
                        "http://192.168.100.100",      // wakati wa production (XAMPP build)
                        "http://localhost:5173",
                        "http://localhost")
>>>>>>> 86c89b0 (just complited the two modules file module and documnt module)
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
