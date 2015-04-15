package com.example.webguidemo;

import org.jbehave.web.selenium.WebDriverProvider;

import com.example.webguidemo.pages.PolsatProgrammes;
import com.example.webguidemo.pages.SearchPolsat;
import com.example.webguidemo.pages.Polsat;
import com.example.webguidemo.pages.Sport;
import com.example.webguidemo.pages.Home;

public class Pages {

	private WebDriverProvider driverProvider;
	
	//Pages
	private Home home;
	private Sport sport;
	private Polsat polsat;
	private SearchPolsat searchPolsat;
	private PolsatProgrammes polsatProgrammes;
	// ...

	public Pages(WebDriverProvider driverProvider) {
		super();
		this.driverProvider = driverProvider;
	}

	public Home home() {
		if (home == null) {
			home = new Home(driverProvider);
		}
		return home;
	}
	
	public Sport sport(){
		if (sport == null) {
			sport = new Sport(driverProvider);
		}
		return sport;
	}
	
	public Polsat polsat(){
		if (polsat == null) {
			polsat = new Polsat(driverProvider);
		}
		return polsat;
	}
	
	public SearchPolsat searchPolsat(){
		if (searchPolsat == null) {
			searchPolsat = new SearchPolsat(driverProvider);
		}
		return searchPolsat;
	}
	
	public PolsatProgrammes polsatProgrammes(){
		if (polsatProgrammes == null) {
			polsatProgrammes = new PolsatProgrammes(driverProvider);
		}
		return polsatProgrammes;
	}
}
