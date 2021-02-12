/**
 * 
 */
package com.mobios.ep.web.models;

/**
 * @author Nishantha
 *
 */
public class FileUploadInfo {
	private String name;
	private String filePath;
	private String referenceId;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getReferenceId() {
		return referenceId;
	}
	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}
	@Override
	public String toString() {
		return "FileUploadInfo [name=" + name + ", filePath=" + filePath
				+ ", referenceId=" + referenceId + "]";
	}


}
