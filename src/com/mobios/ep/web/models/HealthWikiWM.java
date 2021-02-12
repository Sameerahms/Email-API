/**
 * 
 */
package com.mobios.ep.web.models;

/**
 * @author Nishantha
 *
 */
public class HealthWikiWM {
	private int id;
	private String name;
	private int doctorId;
	private String filePath;
	private String category;
	private String description;
	private String referenceId;
	
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
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getReferenceId() {
		return referenceId;
	}
	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}
	
	@Override
	public String toString() {
		return "HealthWikiWM [id=" + id + ", name=" + name + ", doctorId="
				+ doctorId + ", filePath=" + filePath + ", category="
				+ category + ", description=" + description + ", referenceId="
				+ referenceId + "]";
	}

	
	
}
