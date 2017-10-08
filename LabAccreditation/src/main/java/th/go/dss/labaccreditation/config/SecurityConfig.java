package th.go.dss.labaccreditation.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
                .withUser("user").password("password").roles("USER");
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    http
	    	.authorizeRequests()
				.antMatchers("/static/**").permitAll()
				.antMatchers("/webjars/**").permitAll()
				.antMatchers("/logout**").permitAll()
				.antMatchers("/login**").permitAll()
				.antMatchers("/**").permitAll()
				.antMatchers("/api/**").permitAll()
				.antMatchers("/FILES/**").permitAll()
				.antMatchers("/manager/**").hasAnyRole("SITE_ADMIN", "ORG_ADMIN")
				.anyRequest().fullyAuthenticated()
				.and()
			.csrf().disable()
			.formLogin()
				.loginPage("/login").permitAll()
				.loginProcessingUrl("/login").permitAll()
				.defaultSuccessUrl("/web/")
				.and()
			.logout().logoutUrl("/logout").logoutSuccessUrl("/web/")
			;
	    
	    http
	    	.headers()
	    	.defaultsDisabled()
			.cacheControl();
	}

	
}
