package com.mobios.ep.web.models;

import java.util.List;

public class DiagnosticSaveWM {
	
	private RequestDiagnosticsWM requestDiagnosticsWM;
	private List<RequestedSymptomsWM> requestedSymptomsWM;
	private ResponseDiagnosticsWM responseDiagnosticsWM;
	private List<ResponseDiagnosticReportedSymptomsWM> diagnosticReportedSymptomsWM;
	private List<ResponseDiagnosticStaticsWM> responseDiagnosticStaticsWM;
	private List<ResponseDifferentialDiagnosisByExpanatoryProbabilityWM> responseDifferentialDiagnosisByExpanatoryProbabilityWM;
	private List<ResponseDifferentialDiagnosisByContributoryProbabilityWM> responseDifferentialDiagnosisByContributoryProbabilityWM;
	private List<ResponseFinalDiagnosisWM> responseFinalDiagnosisWM;
	
	public RequestDiagnosticsWM getRequestDiagnosticsWM() {
		return requestDiagnosticsWM;
	}
	public void setRequestDiagnosticsWM(RequestDiagnosticsWM requestDiagnosticsWM) {
		this.requestDiagnosticsWM = requestDiagnosticsWM;
	}
	public List<RequestedSymptomsWM> getRequestedSymptomsWM() {
		return requestedSymptomsWM;
	}
	public void setRequestedSymptomsWM(List<RequestedSymptomsWM> requestedSymptomsWM) {
		this.requestedSymptomsWM = requestedSymptomsWM;
	}
	public ResponseDiagnosticsWM getResponseDiagnosticsWM() {
		return responseDiagnosticsWM;
	}
	public void setResponseDiagnosticsWM(ResponseDiagnosticsWM responseDiagnosticsWM) {
		this.responseDiagnosticsWM = responseDiagnosticsWM;
	}
	public List<ResponseDiagnosticReportedSymptomsWM> getDiagnosticReportedSymptomsWM() {
		return diagnosticReportedSymptomsWM;
	}
	public void setDiagnosticReportedSymptomsWM(List<ResponseDiagnosticReportedSymptomsWM> diagnosticReportedSymptomsWM) {
		this.diagnosticReportedSymptomsWM = diagnosticReportedSymptomsWM;
	}
	public List<ResponseDiagnosticStaticsWM> getResponseDiagnosticStaticsWM() {
		return responseDiagnosticStaticsWM;
	}
	public void setResponseDiagnosticStaticsWM(List<ResponseDiagnosticStaticsWM> responseDiagnosticStaticsWM) {
		this.responseDiagnosticStaticsWM = responseDiagnosticStaticsWM;
	}
	public List<ResponseDifferentialDiagnosisByExpanatoryProbabilityWM> getResponseDifferentialDiagnosisByExpanatoryProbabilityWM() {
		return responseDifferentialDiagnosisByExpanatoryProbabilityWM;
	}
	public void setResponseDifferentialDiagnosisByExpanatoryProbabilityWM(
			List<ResponseDifferentialDiagnosisByExpanatoryProbabilityWM> responseDifferentialDiagnosisByExpanatoryProbabilityWM) {
		this.responseDifferentialDiagnosisByExpanatoryProbabilityWM = responseDifferentialDiagnosisByExpanatoryProbabilityWM;
	}
	public List<ResponseDifferentialDiagnosisByContributoryProbabilityWM> getResponseDifferentialDiagnosisByContributoryProbabilityWM() {
		return responseDifferentialDiagnosisByContributoryProbabilityWM;
	}
	public void setResponseDifferentialDiagnosisByContributoryProbabilityWM(
			List<ResponseDifferentialDiagnosisByContributoryProbabilityWM> responseDifferentialDiagnosisByContributoryProbabilityWM) {
		this.responseDifferentialDiagnosisByContributoryProbabilityWM = responseDifferentialDiagnosisByContributoryProbabilityWM;
	}
	public List<ResponseFinalDiagnosisWM> getResponseFinalDiagnosisWM() {
		return responseFinalDiagnosisWM;
	}
	public void setResponseFinalDiagnosisWM(List<ResponseFinalDiagnosisWM> responseFinalDiagnosisWM) {
		this.responseFinalDiagnosisWM = responseFinalDiagnosisWM;
	}
}
