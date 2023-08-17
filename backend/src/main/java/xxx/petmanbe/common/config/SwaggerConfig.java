package xxx.petmanbe.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI openAPI(){
		Info info = new Info()
			.title("SSAFY 9기 공통 프로젝트 Capet API Docs")
			.description("전국 동물카페 커뮤니티, capet");

		return new OpenAPI()
			.components(new Components())
			.info(info);
	}
}
