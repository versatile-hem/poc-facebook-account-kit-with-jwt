package com.wolftechnica.fb.accountkit.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.wolftechnica.fb.accountkit.jwt.LoginModel;

@Service
@PropertySource(value = { "fb.properties" }, ignoreResourceNotFound = true)
public class AccountKitService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private Environment environment;

	Log log = LogFactory.getLog(AccountKitService.class);

	public FBToken authorizeToken(String appId, String appSecret, String code) throws FacebookException {
		String authUrl = this.environment.getProperty(FacebookConstant.CONFIG_FB_GRAPH_AK_URL_ACCESS_TOKEN)
				+ "?grant_type=authorization_code&code=" + code + "&access_token=AA|" + appId + "|" + appSecret;
		log.info("authUrl : " + authUrl );
		FBToken response= new FBToken();
		try{ 
		    response = this.restTemplate.getForObject(authUrl, FBToken.class);
		} catch (Exception e) {
			log.error(e);
		}
		
		log.info("Token : " + code + " | response : " + response);
		return response;
	}

	public String getRegisteredMobileNumberToken(String code) throws FacebookException {
		return null;
	}

	public LoginModel authorizeToken(String code, String mobile) throws FacebookException {
		LoginModel loginModel = new LoginModel();
		FBToken fbToken = authorizeToken(this.environment.getProperty(FacebookConstant.CONFIG_FB_GRAPH_AK_APP_ID),
				this.environment.getProperty(FacebookConstant.CONFIG_FB_GRAPH_AK_APP_SECRET), code);
		if(fbToken.getAccess_token() == null) {
			loginModel.setUsername(mobile);
			loginModel.setRole("GUEST");
		}
		return loginModel;
	}

}
