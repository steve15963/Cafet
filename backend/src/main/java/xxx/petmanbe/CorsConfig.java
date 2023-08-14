// package xxx.petmanbe;
//
// import org.springframework.context.annotation.Configuration;
// import org.springframework.web.servlet.config.annotation.CorsRegistry;
// import org.springframework.web.servlet.config.annotation.EnableWebMvc;
// import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
// // CORS 설정
// @Configuration
// @EnableWebMvc
// public class CorsConfig implements WebMvcConfigurer {
//
// 	@Override
// 	public void addCorsMappings(CorsRegistry registry) {
//
//
// 		registry
// 			.addMapping("/**")
// 			.allowedOriginPatterns("http://localhost:8080")
// 			.allowCredentials(true)
//
// 			.allowedMethods("GET", "POST", "PUT", "DELETE")
// 			.allowedHeaders("Origin", "X-Requested-With", "Content-Type", "Accept")
// 			.maxAge(3600); // Optional: specify max age of preflight requests
// 	}
// }
