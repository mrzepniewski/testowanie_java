package com.example.webguidemo.pages;

import java.util.concurrent.TimeUnit;

import org.jbehave.web.selenium.WebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;

public class Polsat extends WebDriverPage {

	public Polsat(WebDriverProvider driverProvider) {
		super(driverProvider);
	}

	public void open() {
		get("http://www.teleman.pl/program-tv/stacje/Polsat");
		manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
}
