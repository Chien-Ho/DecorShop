package com.aptech.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.authenticator.SpnegoAuthenticator.AuthenticateAction;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
@Configuration
public class CustomLoginSuccessHandle extends SimpleUrlAuthenticationSuccessHandler{
	 @Override
	    public void onAuthenticationSuccess(HttpServletRequest request, 
	      HttpServletResponse response, Authentication authentication)
	      throws IOException {
		 String tagetUrl = determineTagetUrl(authentication);
		 if(response.isCommitted()) {
			 return;
		 }
		 RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
		 redirectStrategy.sendRedirect(request, response, tagetUrl);
	 }
	 protected String determineTagetUrl(Authentication authentication) {
		 String url = "/login?incorrectAccount";
		 Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		 List<String> roles = new ArrayList<>();
		 for(GrantedAuthority a: authorities) {
			 roles.add(a.getAuthority());
		 }
		if(roles.contains("ADMIN")) {
			url = "/admin";
		}
		if(roles.contains("USER")) {
			url = "/";
		}
		return url;
		 
	 }
}
