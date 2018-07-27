package com.wolftechnica.fb.accountkit.jwt;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

/**
 * @author b0202777
 *
 */
@Data
public class LoginModel implements Serializable {

	private static final long serialVersionUID = -7967837054965675647L;

	@NotEmpty
	private String username;

	@NotEmpty
	private String password;

	@JsonIgnore
	private String role;

}
