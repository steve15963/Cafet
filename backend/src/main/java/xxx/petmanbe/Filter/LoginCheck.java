package xxx.petmanbe.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.util.PatternMatchUtils;

import lombok.extern.slf4j.Slf4j;
import xxx.petmanbe.user.entity.User;

@Slf4j
public class LoginCheck implements Filter {

	//로그인 없어도 되는 path
	// private static final String[] whiteList = {"/", "/api/user/new", "/api/user/login","/logout","/css","/js"};

	// 테스트용, 필터 해제
	private static final String[] whiteList = {"/*"};

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		Filter.super.init(filterConfig);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws
		IOException,
		ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpServletResponse httpResponse = (HttpServletResponse)response;

		String url = httpRequest.getRequestURI();


		try {
			log.info("Client Request {[][]}", url);
			if(isWhiteListURL(url)){
				// 로그인 체크 로직
				User user = (User)httpRequest.getSession().getAttribute("user");
				if(user == null) {
					System.out.println(user);
					log.info("No Session {[]}",url);
					httpResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
					return;
				}
				log.info("Login {[]}",user);
			}
			else{
				log.info("This Request is WhiteList {[]}",url);
			}
			chain.doFilter(request, response);
		} catch (Exception e){
			throw e;
		}finally {
			log.info("Client Response {[][]}", url);
		}
	}
	private boolean isWhiteListURL(String url){
		return !PatternMatchUtils.simpleMatch(whiteList,url);
	}



	@Override
	public void destroy() {
		Filter.super.destroy();
	}
}
