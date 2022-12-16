package com.acesso.A.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.acesso.A.service.ClientServiceImpl;
import com.acesso.A.service.LogServiceImpl;
import com.acesso.A.service.OpServiceImpl;
import com.acesso.A.service.UserServiceImpl;
import com.acesso.A.web.dto.ClientRegistrationDto;
import com.acesso.A.web.dto.FuncioRegistrationDto;
import com.acesso.A.web.dto.LogRegistrationDto;
import com.acesso.A.web.dto.OpRegistrationDto;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	
	@Autowired
	public ClientServiceImpl clientService;
	public LogServiceImpl logService;
	public OpServiceImpl opService;
	public UserServiceImpl userService;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers("/ignore1", "/ignore2");
    }
//	 @Autowired
//	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//	        auth.userDetailsService(myDBAauthenticationService);
//
//	 }
	 /**@Bean
	    public DataSource dataSource() {
	        return new EmbeddedDatabaseBuilder()
	            .setType(EmbeddedDatabaseType.H2)
	            .addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION)
	            .build();
	    }**/

//    @Bean
//    public UserDetailsManager users(FuncioRegistrationDto funcioRegistrationDto) {
//        UserDetails user = User
//        		.withDefaultPasswordEncoder()
//            .username("username")
//            .password("senha")            
//            .roles("USER")
//            .build();
//        JdbcUserDetailsManager users = new JdbcUserDetailsManager();
//        users.createUser(user);
//        return users;
//    }
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorizeRequests ->
					authorizeRequests
			        	.antMatchers("/css/**", "/index", "/js/**", "/img/**").permitAll()
					    .antMatchers("/registration*", "/login").permitAll()
					    .anyRequest().authenticated()
					    )            
            .requiresChannel(channel -> channel
            					.anyRequest()
            					)
			.formLogin(formLogin -> 
					    formLogin
					    		.loginPage("/login")
					    .permitAll().loginProcessingUrl("/index"))
					    
			.sessionManagement((sessionManagement) ->
                        sessionManagement
                                .sessionConcurrency((sessionConcurrency) ->
                                        sessionConcurrency
                                                .maximumSessions(1)
                                                .expiredUrl("/login?logout"))
                                );
				
        return http.build();
    }
	/**
	@Bean
	SecurityFilterChain http(HttpSecurity http) throws Exception {
	    DelegatingServerLogoutHandler logoutHandler = new DelegatingServerLogoutHandler(
	            new WebSessionServerLogoutHandler(), new SecurityContextServerLogoutHandler()
	    );

	    http
	        .authorizeExchange((exchange) -> exchange.anyExchange().authenticated())
	        .logout((logout) -> logout.logoutHandler(logoutHandler));

	    return http.build();
	}
	**/
	
	//
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userService.loadUserByUsername(username);

	}
	public com.acesso.A.model.User save(FuncioRegistrationDto registrationDto) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public com.acesso.A.model.Client save(ClientRegistrationDto clientRegistrationDto) {
		// TODO Auto-generated method stub
		return null;
	}
	public com.acesso.A.model.Logistic save(LogRegistrationDto logRegistrationDto) {
		// TODO Auto-generated method stub
		return null;
	}
	public com.acesso.A.model.Op save(OpRegistrationDto opRegistrationDto) {
		// TODO Auto-generated method stub
		return null;
	}
		
	}

