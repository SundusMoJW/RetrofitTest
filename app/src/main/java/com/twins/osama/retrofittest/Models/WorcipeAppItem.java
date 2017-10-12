package com.twins.osama.retrofittest.Models;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class WorcipeAppItem{

	@SerializedName("category_image")
	private String categoryImage;

	@SerializedName("category_name")
	private String categoryName;

	@SerializedName("cid")
	private String cid;

	@SerializedName("status")
	private String status;

	public void setCategoryImage(String categoryImage){
		this.categoryImage = categoryImage;
	}

	public String getCategoryImage(){
		return categoryImage;
	}

	public void setCategoryName(String categoryName){
		this.categoryName = categoryName;
	}

	public String getCategoryName(){
		return categoryName;
	}

	public void setCid(String cid){
		this.cid = cid;
	}

	public String getCid(){
		return cid;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"WorcipeAppItem{" + 
			"category_image = '" + categoryImage + '\'' + 
			",category_name = '" + categoryName + '\'' + 
			",cid = '" + cid + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}