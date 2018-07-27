package com.wolftechnica.fb.accountkit.service;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Hem Chand
 *
 */
@Data
@NoArgsConstructor
public class FBToken implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2859172206234641724L;

	private String id;

	private String access_token;

	private long token_refresh_interval_sec;
	
	private FBError error;

}
