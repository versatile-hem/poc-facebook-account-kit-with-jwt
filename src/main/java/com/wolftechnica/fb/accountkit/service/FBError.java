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
public class FBError implements Serializable {

	private String message;

	private String type;

	private int code;

	private String fbtrace_id;
}
