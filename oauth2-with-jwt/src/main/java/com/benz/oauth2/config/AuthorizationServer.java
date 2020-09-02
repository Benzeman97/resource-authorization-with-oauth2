package com.benz.oauth2.config;

import com.benz.oauth2.dao.OAuthClientDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

import javax.sql.DataSource;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServer  extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private DataSource dataSource;
    
    @Autowired
    private OAuthClientDAO oauthClientDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
          //  security.checkTokenAccess("isAuthenticated()").tokenKeyAccess("permitAll()");
             security.checkTokenAccess("permitAll()");
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

    /*  OAuthClient oauth2=oauthClientDao.findByClientId("web")
    		     .orElseThrow(()->new UsernameNotFoundException("not found"));*/

     clients.jdbc(dataSource).passwordEncoder(passwordEncoder);

    	/*clients.inMemory().withClient("web").secret(passwordEncoder.encode("webadmin"))
                .scopes("READ,WRITE").authorizedGrantTypes("password","refresh_token","authorized_grant_type");*/
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
     //   endpoints.tokenStore(tokenStore()).tokenEnhancer(accessTokenConverter()).
        endpoints.authenticationManager(authenticationManager);
    }

    /*@Bean
    public JwtAccessTokenConverter accessTokenConverter()
    {
        JwtAccessTokenConverter converter=new JwtAccessTokenConverter();
        return converter;

    }

    @Bean
    public JwtTokenStore tokenStore()
    {
        return new JwtTokenStore(accessTokenConverter());
    }*/
}

