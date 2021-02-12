package com.mobios.ep.web.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ombios.ep.entity.model.Institute;

public class InvestigationEmailSummaryM {
	
private long count;
	
	
	private String name;


	public long getCount() {
		return count;
	}


	public void setCount(long count) {
		this.count = count;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
}
