/**
 * 
 */
package com.mobios.ep.web.models;

import java.util.List;

/**
 * @author Nishantha
 *
 */
public class TemplateWM {
	private int id;
	private String name;
	private int doctorId;
	private List<TemplateDrugWM> drugs;
	private String investigations;
	private String description;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public List<TemplateDrugWM> getDrugs() {
		return drugs;
	}
	public void setDrugs(List<TemplateDrugWM> drugs) {
		this.drugs = drugs;
	}
	public String getInvestigations() {
		return investigations;
	}
	public void setInvestigations(String investigations) {
		this.investigations = investigations;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "TemplateWM [id=" + id + ", name=" + name + ", doctorId="
				+ doctorId + ", drugs=" + drugs + ", investigations="
				+ investigations + ", description=" + description + "]";
	}
	

}
