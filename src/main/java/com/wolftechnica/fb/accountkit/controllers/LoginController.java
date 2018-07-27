package com.wolftechnica.fb.accountkit.controllers;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wolftechnica.fb.accountkit.jwt.JwtTokenHandler;
import com.wolftechnica.fb.accountkit.jwt.LoginModel;
import com.wolftechnica.fb.accountkit.service.AccountKitService;
import com.wolftechnica.fb.accountkit.service.FacebookException;

/**
 * @author b0202777
 *
 */
@Validated
@RestController
@RequestMapping(value = "/login")
public class LoginController {

	@Autowired
	private JwtTokenHandler jwtTokenHandler;

	@Autowired
	private AccountKitService accountKitService;
 
	@PostMapping("/ak")
	public APIResponse loginViaFB(@RequestParam String mobile, @RequestParam String code) throws FacebookException {
		return manipulateLoginResponse(this.accountKitService.authorizeToken(code, mobile));
	}
	
	private APIResponse manipulateLoginResponse(LoginModel loginModel){
		APIResponse apiResponse = new APIResponse();  
		if (loginModel.getUsername() == null) {
			apiResponse.setMessage("Authentication failed");
			apiResponse.setStatus(false);
			apiResponse.setStatusCode(HttpStatus.UNAUTHORIZED.value());
		} else {
			String token = jwtTokenHandler.generate(loginModel.getUsername(), loginModel.getRole());
			HashMap<String, String> hashMap = new HashMap<>(2);
			hashMap.put("token", token);
			hashMap.put("role", loginModel.getRole());
			apiResponse.setMessage("Authenticated");
			apiResponse.setStatus(true);
			apiResponse.setStatusCode(HttpStatus.OK.value());
			apiResponse.setResult(hashMap);
		}
		return apiResponse;
	}
	
}
