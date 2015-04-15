package com.example.webguidemo.pages;

import java.util.concurrent.TimeUnit;

import org.jbehave.web.selenium.WebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;

public class PolsatProgrammes extends WebDriverPage {

	public PolsatProgrammes(WebDriverProvider driverProvider) {
		super(driverProvider);
	}

	public void open() {
		get("http://www.teleman.pl/search?q=Polsat&type=programmes");
		manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
}

