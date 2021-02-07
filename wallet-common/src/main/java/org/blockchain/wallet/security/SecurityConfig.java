package org.blockchain.wallet.security;

import lombok.extern.slf4j.Slf4j;
import org.blockchain.wallet.constant.ErrorMessage;
import org.blockchain.wallet.util.JwtUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.servlet.http.HttpServletResponse;

/**
 * @author housirvip
 */
@Slf4j
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expire}")
    private Long expire;

    @Value("${jwt.delay}")
    private Long delay;

    @Bean
    public JwtUtils jwtUtils() {
        return new JwtUtils(secret, expire, delay);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().exceptionHandling()
                .authenticationEntryPoint((httpServletRequest, httpServletResponse, e) ->
                        // rejected because of UNAUTHORIZED, user should login or has some role rather than annoymous
                        httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, ErrorMessage.UNAUTHORIZED))
                .and().authorizeRequests()
                // below path all permitted, needn't to check authorization
                .antMatchers("/auth/**","/update/**", "/blockchainBrowser/**", "/BTC/**", "/BTCTEST/**",
                        "/concept/**", "/email/**", "/exchange/**", "/LTC/**", "/LTCTEST/**",
                        "/fcm/**", "/github/**", "/hotcoin/**", "/BCH/**", "/BCHTEST/**",
                        "/hotWeb/**", "/listingLatest/**", "/liveNews/**",
                        "/test/**", "/turnover/**", "/ETH/**", "/ETHTEST/**").permitAll()
                .antMatchers("/**").authenticated()
                // path start with '/admin' should has role ADMIN or ROOT
                 .antMatchers("/admin/**").hasAnyRole("ADMIN", "ROOT")
                .and().addFilter(new JwtAuthFilter(authenticationManager(), jwtUtils()));
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().mvcMatchers(HttpMethod.OPTIONS, "/**");
        web.ignoring().mvcMatchers("/swagger-ui.html/**", "/configuration/**", "/swagger-resources/**", "/v2/api-docs","/webjars/**");
    }
}
