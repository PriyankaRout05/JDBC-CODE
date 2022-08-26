package com.SbSecurity.configuaration;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.SbSecurity.Student;
import com.sbSecurity.auth.ApplicationUserService;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

	
	private final ApplicationUserService applicationUserService;
	private final PasswordEncoder passwordEncoder;
	

	@Autowired
	public ApplicationSecurityConfig(PasswordEncoder passwordEncoder,
			ApplicationUserService applicationUserService) {
		
		this.applicationUserService = applicationUserService;
		this.passwordEncoder = passwordEncoder;
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
	     .csrf().disable()
         .authorizeRequests()
         .antMatchers("/", "index", "/css/*", "/js/*").permitAll()
         .antMatchers("/api/**").hasRole(Student.name())
//		        .antMatchers(HttpMethod.DELETE, "/management/api/**").hasAuthority(COURSE_WRITE.getPermission())
//       		.antMatchers(HttpMethod.POST, "/management/api/**").hasAuthority(COURSE_WRITE.getPermission())
//      		.antMatchers(HttpMethod.PUT, "/management/api/**").hasAuthority(COURSE_WRITE.getPermission())
//      		.antMatchers("/management/api/**").hasAnyRole(ADMIN.name(), ADMINTRAINEE.name())
				.anyRequest().authenticated().and()
				// .httpBasic();
				.formLogin()
				.loginPage("/login")
				.permitAll()
				.defaultSuccessUrl("/courses", true)
				.passwordParameter("password")
				.usernameParameter("username")
				.and()
				.rememberMe()
				.tokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(21)).key("somethingverysecured")
				.rememberMeParameter("remember-me")

				.and()
				.logout()
				.logoutUrl("/logout")
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET")) // https://docs.spring.io/spring-security/site/docs/4.2.12.RELEASE/apidocs/org/springframework/security/config/annotation/web/configurers/LogoutConfigurer.html
				.clearAuthentication(true).invalidateHttpSession(true).deleteCookies("JSESSIONID", "remember-me")
				.logoutSuccessUrl("/login");
	}

//	@Override
//	@Bean
//	protected UserDetailsService userDetailsService() {
//
//		UserDetails priyaUser = User.builder()
//				.username("priya") // this is ROLE_STUDENT
//				.password(passwordEncoder
//						.encode("password"))
//				.roles(ApplicationUserRole.STUDENT.name())
//			    //.authorities(STUDENT.getGrantedAuthorities())
//				.build();
//
//		UserDetails lindaUser = User.builder()
//				.username("linda") // this is ROLE_ADMIN
//				.password(passwordEncoder
//						.encode("password123"))
//				.roles(ApplicationUserRole.ADMIN.name())
//			    //.authorities(ADMIN.getGrantedAuthorities())
//				.build();
//
//		UserDetails tomUser = User.builder()
//				.username("tom") // ROLE_ADMINTRAINEE
//				.password(passwordEncoder.encode("password133"))
//				.roles(ApplicationUserRole.ADMINTRAINEE.name())
//				//.authorities(ADMINTRAINEE.getGrantedAuthorities())
//				.build();
//
//		return new InMemoryUserDetailsManager(priyaUser, lindaUser, tomUser
//
//		);
//	}
//	public static void main(String args[]) {
//	        System.out.println(TimeUnit.DAYS.toSeconds(1));
//	    }
//
 //	}
	
	
	
	//*******for database Authentication
	  @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.authenticationProvider(daoAuthenticationProvider());
	    }

	    @Bean
	    public DaoAuthenticationProvider daoAuthenticationProvider() {
	        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
	        provider.setPasswordEncoder(passwordEncoder);
	        provider.setUserDetailsService(applicationUserService);
	        return provider;
	    }

	}


