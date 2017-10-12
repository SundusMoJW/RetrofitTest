package com.twins.osama.retrofittest.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Response{

	@SerializedName("WorcipeApp")
	private List<WorcipeAppItem> worcipeApp;

	public void setWorcipeApp(List<WorcipeAppItem> worcipeApp){
		this.worcipeApp = worcipeApp;
	}

	public List<WorcipeAppItem> getWorcipeApp(){
		return worcipeApp;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"worcipeApp = '" + worcipeApp + '\'' + 
			"}";
		}
}