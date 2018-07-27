package com.wolftechnica.fb.accountkit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

public abstract class AbstarctContoller {

	@Autowired
	protected Environment environment; 
	
	
}
