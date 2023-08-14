package xxx.petmanbe;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import lombok.RequiredArgsConstructor;

// CORS 설정
@Configuration
@EnableWebSocket
@RequiredArgsConstructor
public class WebSocketConfig implements WebSocketConfigurer {

	// @Override
	// public void addCorsMappings(WebSocketHandlerRegistry registry) {



		// registry
		// 	.addMapping("/**")
		// 	.allowedOriginPatterns("http://localhost:8080")
		// 	.allowCredentials(true)
		//
		// 	.allowedMethods("GET", "POST", "PUT", "DELETE")
		// 	.allowedHeaders("Origin", "X-Requested-With", "Content-Type", "Accept")
		// 	.maxAge(3600); // Optional: specify max age of preflight requests
	// }

	// @Override
	// public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
	// 	registry.addHandler()
	// 		.setAllowedOriginPatterns()
	// }
}
