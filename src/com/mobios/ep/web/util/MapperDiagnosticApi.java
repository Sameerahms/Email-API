package com.mobios.ep.web.util;

import java.util.ArrayList;
import java.util.List;

import com.mobios.ep.web.models.DiagnosticSaveWM;
import com.mobios.ep.web.models.RequestDiagnosticsWM;
import com.mobios.ep.web.models.RequestedSymptomsWM;
import com.mobios.ep.web.models.ResponseDiagnosticReportedSymptomsWM;
import com.mobios.ep.web.models.ResponseDiagnosticStaticsComplainedSymptomsWM;
import com.mobios.ep.web.models.ResponseDiagnosticStaticsNotComplainedSymptomsWM;
import com.mobios.ep.web.models.ResponseDiagnosticStaticsUnexplainedSymptomsWM;
import com.mobios.ep.web.models.ResponseDiagnosticStaticsWM;
import com.mobios.ep.web.models.ResponseDiagnosticsWM;
import com.mobios.ep.web.models.ResponseDifferentialDiagnosisByContributoryProbabilityWM;
import com.mobios.ep.web.models.ResponseDifferentialDiagnosisByExpanatoryProbabilityWM;
import com.mobios.ep.web.models.ResponseFinalDiagnosisWM;
import com.ombios.ep.entity.model.DiagnosticSaveEM;
import com.ombios.ep.entity.model.RequestDiagnostics;
import com.ombios.ep.entity.model.RequestedSymptoms;
import com.ombios.ep.entity.model.ResponseDiagnosticReportedSymptoms;
import com.ombios.ep.entity.model.ResponseDiagnosticStatics;
import com.ombios.ep.entity.model.ResponseDiagnosticStaticsComplainedSymptoms;
import com.ombios.ep.entity.model.ResponseDiagnosticStaticsNotComplainedSymptoms;
import com.ombios.ep.entity.model.ResponseDiagnosticStaticsUnexplainedSymptoms;
import com.ombios.ep.entity.model.ResponseDiagnostics;
import com.ombios.ep.entity.model.ResponseDifferentialDiagnosisByContributoryProbability;
import com.ombios.ep.entity.model.ResponseDifferentialDiagnosisByExpanatoryProbability;
import com.ombios.ep.entity.model.ResponseFinalDiagnosis;

public class MapperDiagnosticApi {

	//RequestDiagnostics
	public RequestDiagnostics mapRequestDiagnostics(RequestDiagnosticsWM requestDiagnosticsWM) throws Exception{
		RequestDiagnostics requestDiagnostics = new RequestDiagnostics();
		
		requestDiagnostics.setId(requestDiagnosticsWM.getId());
		requestDiagnostics.setCreatedBy(requestDiagnosticsWM.getCreatedBy());
		requestDiagnostics.setCreatedDate(requestDiagnosticsWM.getCreatedDate());
		
		return requestDiagnostics;
	}
	
	public RequestDiagnosticsWM mapRequestDiagnostics(RequestDiagnostics requestDiagnostics)  throws Exception{
		RequestDiagnosticsWM requestDiagnosticsWM = new RequestDiagnosticsWM();
		
		requestDiagnosticsWM.setId(requestDiagnostics.getId());
		requestDiagnosticsWM.setCreatedBy(requestDiagnostics.getCreatedBy());
		requestDiagnosticsWM.setCreatedDate(requestDiagnostics.getCreatedDate());
		
		return requestDiagnosticsWM;
	}
	
	
	
	//RequestedSymptoms
	public RequestedSymptoms mapRequestedSymptoms(RequestedSymptomsWM requestedSymptomsWM)  throws Exception{
		RequestedSymptoms requestedSymptom = new RequestedSymptoms();
		
		requestedSymptom.setId(requestedSymptomsWM.getId());
		requestedSymptom.setRequestDiagnosticId(requestedSymptomsWM.getRequestDiagnosticId());
		requestedSymptom.setSymptom(requestedSymptomsWM.getSymptom());
		
		return requestedSymptom;
	}
	
	public RequestedSymptomsWM mapRequestedSymptoms(RequestedSymptoms requestedSymptom)  throws Exception{
		RequestedSymptomsWM requestedSymptomsWM = new RequestedSymptomsWM();
		
		requestedSymptomsWM.setId(requestedSymptom.getId());
		requestedSymptomsWM.setRequestDiagnosticId(requestedSymptom.getRequestDiagnosticId());
		requestedSymptomsWM.setSymptom(requestedSymptom.getSymptom());
		
		return requestedSymptomsWM;
	}
	
	public List<RequestedSymptoms> mapRequestedSymptoms(List<RequestedSymptomsWM> requestedSymptomsWM)  throws Exception{
		List<RequestedSymptoms> requestedSymptoms = new ArrayList<>();
		
		for(RequestedSymptomsWM requestedSymptomWM : requestedSymptomsWM)
			requestedSymptoms.add(mapRequestedSymptoms(requestedSymptomWM));
		
		return requestedSymptoms;
	}
	
	public List<RequestedSymptomsWM> mapRequestedSymptomsToWM(List<RequestedSymptoms> requestedSymptoms)  throws Exception{
		List<RequestedSymptomsWM> requestedSymptomsWM = new ArrayList<>();
		
		for(RequestedSymptoms requestedSymptom : requestedSymptoms)
			requestedSymptomsWM.add(mapRequestedSymptoms(requestedSymptom));
		
		return requestedSymptomsWM;
	}
	
	
	
	//ResponseDiagnostics
	public ResponseDiagnostics mapResponseDiagnostics(ResponseDiagnosticsWM responseDiagnosticsWM) throws Exception{
		ResponseDiagnostics responseDiagnostics = new ResponseDiagnostics();
		
		if(responseDiagnosticsWM == null)
			return responseDiagnostics;
		
		responseDiagnostics.setId(responseDiagnosticsWM.getId());
		responseDiagnostics.setRequestDiagnosticId(responseDiagnosticsWM.getRequestDiagnosticId());
		
		return responseDiagnostics;
	}
	
	public ResponseDiagnosticsWM mapResponseDiagnostics(ResponseDiagnostics responseDiagnostics) throws Exception{
		ResponseDiagnosticsWM responseDiagnosticsWM = new ResponseDiagnosticsWM();
		
		responseDiagnosticsWM.setId(responseDiagnostics.getId());
		responseDiagnosticsWM.setRequestDiagnosticId(responseDiagnostics.getRequestDiagnosticId());
		
		return responseDiagnosticsWM;
	}
	
	
	
	//ResponseDiagnosticReportedSymptoms
	public ResponseDiagnosticReportedSymptoms mapResponseDiagnosticReportedSymptoms(
			ResponseDiagnosticReportedSymptomsWM responseDiagnosticReportedSymptomsWM) throws Exception{
		ResponseDiagnosticReportedSymptoms responseDiagnosticReportedSymptoms = new ResponseDiagnosticReportedSymptoms();
		
		responseDiagnosticReportedSymptoms.setId(responseDiagnosticReportedSymptomsWM.getId());
		responseDiagnosticReportedSymptoms.setResponseDiagnosticId(responseDiagnosticReportedSymptomsWM.getResponseDiagnosticId());
		responseDiagnosticReportedSymptoms.setSymptomsReported(responseDiagnosticReportedSymptomsWM.getSymptomsReported());
		
		return responseDiagnosticReportedSymptoms;
	}
	
	public ResponseDiagnosticReportedSymptomsWM mapResponseDiagnosticReportedSymptoms(
			ResponseDiagnosticReportedSymptoms responseDiagnosticReportedSymptoms) throws Exception{
		ResponseDiagnosticReportedSymptomsWM responseDiagnosticReportedSymptomsWM = new ResponseDiagnosticReportedSymptomsWM();
		
		responseDiagnosticReportedSymptomsWM.setId(responseDiagnosticReportedSymptoms.getId());
		responseDiagnosticReportedSymptomsWM.setResponseDiagnosticId(responseDiagnosticReportedSymptoms.getResponseDiagnosticId());
		responseDiagnosticReportedSymptomsWM.setSymptomsReported(responseDiagnosticReportedSymptoms.getSymptomsReported());
		
		return responseDiagnosticReportedSymptomsWM;
	}
	
	public List<ResponseDiagnosticReportedSymptoms> mapResponseDiagnosticReportedSymptoms(
			List<ResponseDiagnosticReportedSymptomsWM> responseDiagnosticReportedSymptomsWM) throws Exception{
		List<ResponseDiagnosticReportedSymptoms> responseDiagnosticReportedSymptoms = new ArrayList<>();
		
		for(ResponseDiagnosticReportedSymptomsWM responseDiagnosticReportedSymptomWM : responseDiagnosticReportedSymptomsWM) {
			responseDiagnosticReportedSymptoms.add(mapResponseDiagnosticReportedSymptoms(responseDiagnosticReportedSymptomWM));
		}
		
		return responseDiagnosticReportedSymptoms;
	}
	
	public List<ResponseDiagnosticReportedSymptomsWM> mapResponseDiagnosticReportedSymptomsToWM(
			List<ResponseDiagnosticReportedSymptoms> responseDiagnosticReportedSymptoms) throws Exception{
		List<ResponseDiagnosticReportedSymptomsWM> responseDiagnosticReportedSymptomsWM = new ArrayList<>();
		
		for(ResponseDiagnosticReportedSymptoms responseDiagnosticReportedSymptom : responseDiagnosticReportedSymptoms) {
			responseDiagnosticReportedSymptomsWM.add(mapResponseDiagnosticReportedSymptoms(responseDiagnosticReportedSymptom));
		}

		return responseDiagnosticReportedSymptomsWM;
	}
	
	
	
	//ResponseDiagnosticStaticsComplainedSymptoms
	public ResponseDiagnosticStaticsComplainedSymptoms mapResponseDiagnosticStaticsComplainedSymptoms(
			ResponseDiagnosticStaticsComplainedSymptomsWM responseDiagnosticStaticsComplainedSymptomsWM) throws Exception {
		
		ResponseDiagnosticStaticsComplainedSymptoms responseDiagnosticStaticsComplainedSymptoms = new ResponseDiagnosticStaticsComplainedSymptoms();
		
		responseDiagnosticStaticsComplainedSymptoms.setId(responseDiagnosticStaticsComplainedSymptomsWM.getId());
		responseDiagnosticStaticsComplainedSymptoms.setResponseDiagnosticStaticsId(responseDiagnosticStaticsComplainedSymptomsWM.getResponseDiagnosticStaticsId());
		responseDiagnosticStaticsComplainedSymptoms.setComplainedSymptoms(responseDiagnosticStaticsComplainedSymptomsWM.getComplainedSymptoms());
		
		return responseDiagnosticStaticsComplainedSymptoms;
	}
	
	public ResponseDiagnosticStaticsComplainedSymptomsWM mapResponseDiagnosticStaticsComplainedSymptoms(
			ResponseDiagnosticStaticsComplainedSymptoms responseDiagnosticStaticsComplainedSymptom) throws Exception {
		
		ResponseDiagnosticStaticsComplainedSymptomsWM responseDiagnosticStaticsComplainedSymptomsWM = new ResponseDiagnosticStaticsComplainedSymptomsWM();
		
		responseDiagnosticStaticsComplainedSymptomsWM.setId(responseDiagnosticStaticsComplainedSymptom.getId());
		responseDiagnosticStaticsComplainedSymptomsWM.setResponseDiagnosticStaticsId(responseDiagnosticStaticsComplainedSymptom.getResponseDiagnosticStaticsId());
		responseDiagnosticStaticsComplainedSymptomsWM.setComplainedSymptoms(responseDiagnosticStaticsComplainedSymptom.getComplainedSymptoms());
		
		return responseDiagnosticStaticsComplainedSymptomsWM;
	}
	
	public List<ResponseDiagnosticStaticsComplainedSymptoms> mapResponseDiagnosticStaticsComplainedSymptoms(
			List<ResponseDiagnosticStaticsComplainedSymptomsWM> responseDiagnosticStaticsComplainedSymptomsWM) throws Exception {
		
		List<ResponseDiagnosticStaticsComplainedSymptoms> responseDiagnosticStaticsComplainedSymptoms = new ArrayList<>();
		
		for(ResponseDiagnosticStaticsComplainedSymptomsWM responseDiagnosticStaticsComplainedSymptomWM : responseDiagnosticStaticsComplainedSymptomsWM) {
			responseDiagnosticStaticsComplainedSymptoms.add(mapResponseDiagnosticStaticsComplainedSymptoms(responseDiagnosticStaticsComplainedSymptomWM));
		}

		return responseDiagnosticStaticsComplainedSymptoms;
	}
	
	public List<ResponseDiagnosticStaticsComplainedSymptomsWM> mapResponseDiagnosticStaticsComplainedSymptomsToWM(
			List<ResponseDiagnosticStaticsComplainedSymptoms> responseDiagnosticStaticsComplainedSymptoms) throws Exception {
		
		List<ResponseDiagnosticStaticsComplainedSymptomsWM> responseDiagnosticStaticsComplainedSymptomsWM = new ArrayList<>();
		
		for(ResponseDiagnosticStaticsComplainedSymptoms responseDiagnosticStaticsComplainedSymptom : responseDiagnosticStaticsComplainedSymptoms) {
			responseDiagnosticStaticsComplainedSymptomsWM.add(mapResponseDiagnosticStaticsComplainedSymptoms(responseDiagnosticStaticsComplainedSymptom));
		}

		return responseDiagnosticStaticsComplainedSymptomsWM;
	}
	
	
	
	//ResponseDiagnosticStaticsNotComplainedSymptoms
	public ResponseDiagnosticStaticsNotComplainedSymptoms mapResponseDiagnosticStaticsNotComplainedSymptoms(
			ResponseDiagnosticStaticsNotComplainedSymptomsWM responseDiagnosticStaticsNotComplainedSymptomsWM) throws Exception{
		ResponseDiagnosticStaticsNotComplainedSymptoms responseDiagnosticStaticsNotComplainedSymptoms = new ResponseDiagnosticStaticsNotComplainedSymptoms();
		
		responseDiagnosticStaticsNotComplainedSymptoms.setId(responseDiagnosticStaticsNotComplainedSymptomsWM.getId());
		responseDiagnosticStaticsNotComplainedSymptoms.setResponseDiagnosticStaticsId(responseDiagnosticStaticsNotComplainedSymptomsWM.getResponseDiagnosticStaticsId());
		responseDiagnosticStaticsNotComplainedSymptoms.setNotComplainedSymptoms(responseDiagnosticStaticsNotComplainedSymptomsWM.getNotComplainedSymptoms());
		
		return responseDiagnosticStaticsNotComplainedSymptoms;
	}
	
	public ResponseDiagnosticStaticsNotComplainedSymptomsWM mapResponseDiagnosticStaticsNotComplainedSymptoms(
			ResponseDiagnosticStaticsNotComplainedSymptoms responseDiagnosticStaticsNotComplainedSymptoms) throws Exception{
		ResponseDiagnosticStaticsNotComplainedSymptomsWM responseDiagnosticStaticsNotComplainedSymptomsWM = new ResponseDiagnosticStaticsNotComplainedSymptomsWM();
		
		responseDiagnosticStaticsNotComplainedSymptomsWM.setId(responseDiagnosticStaticsNotComplainedSymptoms.getId());
		responseDiagnosticStaticsNotComplainedSymptomsWM.setResponseDiagnosticStaticsId(responseDiagnosticStaticsNotComplainedSymptoms.getResponseDiagnosticStaticsId());
		responseDiagnosticStaticsNotComplainedSymptomsWM.setNotComplainedSymptoms(responseDiagnosticStaticsNotComplainedSymptoms.getNotComplainedSymptoms());
		
		return responseDiagnosticStaticsNotComplainedSymptomsWM;
	}
	
	public List<ResponseDiagnosticStaticsNotComplainedSymptoms> mapResponseDiagnosticStaticsNotComplainedSymptoms(
			List<ResponseDiagnosticStaticsNotComplainedSymptomsWM> responseDiagnosticStaticsNotComplainedSymptomsWM) throws Exception{
		List<ResponseDiagnosticStaticsNotComplainedSymptoms> responseDiagnosticStaticsNotComplainedSymptoms = new ArrayList<>();
		
		for(ResponseDiagnosticStaticsNotComplainedSymptomsWM responseDiagnosticStaticsNotComplainedSymptomWM : responseDiagnosticStaticsNotComplainedSymptomsWM) {
			responseDiagnosticStaticsNotComplainedSymptoms.add(mapResponseDiagnosticStaticsNotComplainedSymptoms(responseDiagnosticStaticsNotComplainedSymptomWM));
		}
		
		return responseDiagnosticStaticsNotComplainedSymptoms;
	}
	
	public List<ResponseDiagnosticStaticsNotComplainedSymptomsWM> mapResponseDiagnosticStaticsNotComplainedSymptomsToWM(
			List<ResponseDiagnosticStaticsNotComplainedSymptoms> responseDiagnosticStaticsNotComplainedSymptoms) throws Exception{
		List<ResponseDiagnosticStaticsNotComplainedSymptomsWM> responseDiagnosticStaticsNotComplainedSymptomsWM = new ArrayList<>();
		
		for(ResponseDiagnosticStaticsNotComplainedSymptoms responseDiagnosticStaticsNotComplainedSymptom : responseDiagnosticStaticsNotComplainedSymptoms) {
			responseDiagnosticStaticsNotComplainedSymptomsWM.add(mapResponseDiagnosticStaticsNotComplainedSymptoms(responseDiagnosticStaticsNotComplainedSymptom));
		}
		
		return responseDiagnosticStaticsNotComplainedSymptomsWM;
	}
	
	
	
	//ResponseDiagnosticStaticsUnexplainedSymptoms
	public ResponseDiagnosticStaticsUnexplainedSymptoms mapResponseDiagnosticStaticsUnexplainedSymptoms(
			ResponseDiagnosticStaticsUnexplainedSymptomsWM responseDiagnosticStaticsUnexplainedSymptomsWM) throws Exception{
		ResponseDiagnosticStaticsUnexplainedSymptoms responseDiagnosticStaticsUnexplainedSymptoms = new ResponseDiagnosticStaticsUnexplainedSymptoms();
		
		responseDiagnosticStaticsUnexplainedSymptoms.setId(responseDiagnosticStaticsUnexplainedSymptomsWM.getId());
		responseDiagnosticStaticsUnexplainedSymptoms.setResponseDiagnosticStaticsId(responseDiagnosticStaticsUnexplainedSymptomsWM.getResponseDiagnosticStaticsId());
		responseDiagnosticStaticsUnexplainedSymptoms.setUnexplainedSymptoms(responseDiagnosticStaticsUnexplainedSymptomsWM.getUnexplainedSymptoms());
		
		return responseDiagnosticStaticsUnexplainedSymptoms;
	}
	
	public ResponseDiagnosticStaticsUnexplainedSymptomsWM mapResponseDiagnosticStaticsUnexplainedSymptoms(
			ResponseDiagnosticStaticsUnexplainedSymptoms responseDiagnosticStaticsUnexplainedSymptoms) throws Exception{
		ResponseDiagnosticStaticsUnexplainedSymptomsWM responseDiagnosticStaticsUnexplainedSymptomsWM = new ResponseDiagnosticStaticsUnexplainedSymptomsWM();
		
		responseDiagnosticStaticsUnexplainedSymptomsWM.setId(responseDiagnosticStaticsUnexplainedSymptoms.getId());
		responseDiagnosticStaticsUnexplainedSymptomsWM.setResponseDiagnosticStaticsId(responseDiagnosticStaticsUnexplainedSymptoms.getResponseDiagnosticStaticsId());
		responseDiagnosticStaticsUnexplainedSymptomsWM.setUnexplainedSymptoms(responseDiagnosticStaticsUnexplainedSymptoms.getUnexplainedSymptoms());
		
		return responseDiagnosticStaticsUnexplainedSymptomsWM;
	}
	
	public List<ResponseDiagnosticStaticsUnexplainedSymptoms> mapResponseDiagnosticStaticsUnexplainedSymptoms(
			List<ResponseDiagnosticStaticsUnexplainedSymptomsWM> responseDiagnosticStaticsUnexplainedSymptomsWM) throws Exception{
		List<ResponseDiagnosticStaticsUnexplainedSymptoms> responseDiagnosticStaticsUnexplainedSymptoms = new ArrayList<>();
		
		for(ResponseDiagnosticStaticsUnexplainedSymptomsWM responseDiagnosticStaticsUnexplainedSymptomWM : responseDiagnosticStaticsUnexplainedSymptomsWM) {
			responseDiagnosticStaticsUnexplainedSymptoms.add(mapResponseDiagnosticStaticsUnexplainedSymptoms(responseDiagnosticStaticsUnexplainedSymptomWM));
		}
		
		return responseDiagnosticStaticsUnexplainedSymptoms;
	}
	
	public List<ResponseDiagnosticStaticsUnexplainedSymptomsWM> mapResponseDiagnosticStaticsUnexplainedSymptomsToWM(
			List<ResponseDiagnosticStaticsUnexplainedSymptoms> responseDiagnosticStaticsUnexplainedSymptoms) throws Exception{
		List<ResponseDiagnosticStaticsUnexplainedSymptomsWM> responseDiagnosticStaticsUnexplainedSymptomsWM = new ArrayList<>();
		
		for(ResponseDiagnosticStaticsUnexplainedSymptoms responseDiagnosticStaticsUnexplainedSymptom : responseDiagnosticStaticsUnexplainedSymptoms) {
			responseDiagnosticStaticsUnexplainedSymptomsWM.add(mapResponseDiagnosticStaticsUnexplainedSymptoms(responseDiagnosticStaticsUnexplainedSymptom));
		}
		return responseDiagnosticStaticsUnexplainedSymptomsWM;
	}
	
	
	
	//ResponseDiagnosticStatics
	public ResponseDiagnosticStatics mapResponseDiagnosticStatics(ResponseDiagnosticStaticsWM responseDiagnosticStaticsWM) throws Exception{
		ResponseDiagnosticStatics responseDiagnosticStatics = new ResponseDiagnosticStatics();
		
		responseDiagnosticStatics.setId(responseDiagnosticStaticsWM.getId());
		responseDiagnosticStatics.setResponseDiagnosticId(responseDiagnosticStaticsWM.getResponseDiagnosticId());
		responseDiagnosticStatics.setDisease(responseDiagnosticStaticsWM.getDisease());
		responseDiagnosticStatics.setComorbidityProbability(responseDiagnosticStaticsWM.getComorbidityProbability());
		responseDiagnosticStatics.setContributoryProbability(responseDiagnosticStaticsWM.getContributoryProbability());
		responseDiagnosticStatics.setExplanatoryProbabiliy(responseDiagnosticStaticsWM.getExplanatoryProbabiliy());
		responseDiagnosticStatics.setRuleOutProbability(responseDiagnosticStaticsWM.getRuleOutProbability());
		responseDiagnosticStatics.setSymptomsComplained(responseDiagnosticStaticsWM.getSymptomsComplained());
		responseDiagnosticStatics.setSymptomsNotComplained(responseDiagnosticStaticsWM.getSymptomsNotComplained());
		responseDiagnosticStatics.setSymptomsUnexplained(responseDiagnosticStaticsWM.getSymptomsUnexplained());
		
		responseDiagnosticStatics.setResponseDiagnosticStaticsComplainedSymptoms(
				mapResponseDiagnosticStaticsComplainedSymptoms(responseDiagnosticStaticsWM.getResponseDiagnosticStaticsComplainedSymptomsWMs()));
		
		responseDiagnosticStatics.setResponseDiagnosticStaticsNotComplainedSymptoms(
				mapResponseDiagnosticStaticsNotComplainedSymptoms(responseDiagnosticStaticsWM.getResponseDiagnosticStaticsNotComplainedSymptomsWMs()));
		
		responseDiagnosticStatics.setResponseDiagnosticStaticsUnexplainedSymptoms(
				mapResponseDiagnosticStaticsUnexplainedSymptoms(responseDiagnosticStaticsWM.getResponseDiagnosticStaticsUnexplainedSymptomsWMs()));
		
		return responseDiagnosticStatics;
	}
	
	
	public ResponseDiagnosticStaticsWM mapResponseDiagnosticStatics(ResponseDiagnosticStatics responseDiagnosticStatics) throws Exception{
		ResponseDiagnosticStaticsWM responseDiagnosticStaticsWM = new ResponseDiagnosticStaticsWM();
		
		responseDiagnosticStaticsWM.setId(responseDiagnosticStatics.getId());
		responseDiagnosticStaticsWM.setResponseDiagnosticId(responseDiagnosticStatics.getResponseDiagnosticId());
		responseDiagnosticStaticsWM.setDisease(responseDiagnosticStatics.getDisease());
		responseDiagnosticStaticsWM.setComorbidityProbability(responseDiagnosticStatics.getComorbidityProbability());
		responseDiagnosticStaticsWM.setContributoryProbability(responseDiagnosticStatics.getContributoryProbability());
		responseDiagnosticStaticsWM.setExplanatoryProbabiliy(responseDiagnosticStatics.getExplanatoryProbabiliy());
		responseDiagnosticStaticsWM.setRuleOutProbability(responseDiagnosticStatics.getRuleOutProbability());
		responseDiagnosticStaticsWM.setSymptomsComplained(responseDiagnosticStatics.getSymptomsComplained());
		responseDiagnosticStaticsWM.setSymptomsNotComplained(responseDiagnosticStatics.getSymptomsNotComplained());
		responseDiagnosticStaticsWM.setSymptomsUnexplained(responseDiagnosticStatics.getSymptomsUnexplained());
		
		responseDiagnosticStaticsWM.setResponseDiagnosticStaticsComplainedSymptomsWMs(
				mapResponseDiagnosticStaticsComplainedSymptomsToWM(responseDiagnosticStatics.getResponseDiagnosticStaticsComplainedSymptoms()));
		
		responseDiagnosticStaticsWM.setResponseDiagnosticStaticsNotComplainedSymptomsWMs(
				mapResponseDiagnosticStaticsNotComplainedSymptomsToWM(responseDiagnosticStatics.getResponseDiagnosticStaticsNotComplainedSymptoms()));
		
		responseDiagnosticStaticsWM.setResponseDiagnosticStaticsUnexplainedSymptomsWMs(
				mapResponseDiagnosticStaticsUnexplainedSymptomsToWM(responseDiagnosticStatics.getResponseDiagnosticStaticsUnexplainedSymptoms()));
		
		return responseDiagnosticStaticsWM;
	}
	
	public List<ResponseDiagnosticStatics> mapResponseDiagnosticStatics(
			List<ResponseDiagnosticStaticsWM> responseDiagnosticStaticsWM) throws Exception{
		List<ResponseDiagnosticStatics> responseDiagnosticStatics = new ArrayList<>();
		
		for(ResponseDiagnosticStaticsWM responseDiagnosticStaticWM : responseDiagnosticStaticsWM) {
			responseDiagnosticStatics.add(mapResponseDiagnosticStatics(responseDiagnosticStaticWM));
		}
		return responseDiagnosticStatics;
	}
	
	public List<ResponseDiagnosticStaticsWM> mapResponseDiagnosticStaticsToWM(
			List<ResponseDiagnosticStatics> responseDiagnosticStatics) throws Exception{
		List<ResponseDiagnosticStaticsWM> responseDiagnosticStaticsWM = new ArrayList<>();
		
		for(ResponseDiagnosticStatics responseDiagnosticStatic : responseDiagnosticStatics) {
			responseDiagnosticStaticsWM.add(mapResponseDiagnosticStatics(responseDiagnosticStatic));
		}
		
		return responseDiagnosticStaticsWM;
	}
	
	
	
	//ResponseDifferentialDiagnosisByContributoryProbability
	public ResponseDifferentialDiagnosisByContributoryProbability mapResponseDifferentialDiagnosisByContributoryProbability(
			ResponseDifferentialDiagnosisByContributoryProbabilityWM responseDifferentialDiagnosisByContributoryProbabilityWM) throws Exception{
		ResponseDifferentialDiagnosisByContributoryProbability responseDifferentialDiagnosisByContributoryProbability = new ResponseDifferentialDiagnosisByContributoryProbability();
		
		responseDifferentialDiagnosisByContributoryProbability.setId(responseDifferentialDiagnosisByContributoryProbabilityWM.getId());
		responseDifferentialDiagnosisByContributoryProbability.setDisease(responseDifferentialDiagnosisByContributoryProbabilityWM.getDisease());
		responseDifferentialDiagnosisByContributoryProbability.setProbability(responseDifferentialDiagnosisByContributoryProbabilityWM.getProbability());
		responseDifferentialDiagnosisByContributoryProbability.setResponseDiagnosticId(responseDifferentialDiagnosisByContributoryProbabilityWM.getResponseDiagnosticId());
		
		return responseDifferentialDiagnosisByContributoryProbability;
	}
	
	public ResponseDifferentialDiagnosisByContributoryProbabilityWM mapResponseDifferentialDiagnosisByContributoryProbability(
			ResponseDifferentialDiagnosisByContributoryProbability responseDifferentialDiagnosisByContributoryProbability) throws Exception{
		ResponseDifferentialDiagnosisByContributoryProbabilityWM responseDifferentialDiagnosisByContributoryProbabilityWM = new ResponseDifferentialDiagnosisByContributoryProbabilityWM();
		
		responseDifferentialDiagnosisByContributoryProbabilityWM.setId(responseDifferentialDiagnosisByContributoryProbability.getId());
		responseDifferentialDiagnosisByContributoryProbabilityWM.setDisease(responseDifferentialDiagnosisByContributoryProbability.getDisease());
		responseDifferentialDiagnosisByContributoryProbabilityWM.setProbability(responseDifferentialDiagnosisByContributoryProbability.getProbability());
		responseDifferentialDiagnosisByContributoryProbabilityWM.setResponseDiagnosticId(responseDifferentialDiagnosisByContributoryProbability.getResponseDiagnosticId());
		
		return responseDifferentialDiagnosisByContributoryProbabilityWM;
	}
	
	public List<ResponseDifferentialDiagnosisByContributoryProbability> mapResponseDifferentialDiagnosisByContributoryProbability(
			List<ResponseDifferentialDiagnosisByContributoryProbabilityWM> responseDifferentialDiagnosisByContributoryProbabilityWM) throws Exception{
		List<ResponseDifferentialDiagnosisByContributoryProbability> responseDifferentialDiagnosisByContributoryProbability = new ArrayList<>();
		
		for(ResponseDifferentialDiagnosisByContributoryProbabilityWM item : responseDifferentialDiagnosisByContributoryProbabilityWM) {
			responseDifferentialDiagnosisByContributoryProbability.add(mapResponseDifferentialDiagnosisByContributoryProbability(item));
		}
		
		return responseDifferentialDiagnosisByContributoryProbability;
	}
	
	public List<ResponseDifferentialDiagnosisByContributoryProbabilityWM> mapResponseDifferentialDiagnosisByContributoryProbabilityToWM(
			List<ResponseDifferentialDiagnosisByContributoryProbability> responseDifferentialDiagnosisByContributoryProbability) throws Exception{
		List<ResponseDifferentialDiagnosisByContributoryProbabilityWM> responseDifferentialDiagnosisByContributoryProbabilityWM = new ArrayList<>();
		
		for(ResponseDifferentialDiagnosisByContributoryProbability item : responseDifferentialDiagnosisByContributoryProbability) {
			responseDifferentialDiagnosisByContributoryProbabilityWM.add(mapResponseDifferentialDiagnosisByContributoryProbability(item));
		}
		
		return responseDifferentialDiagnosisByContributoryProbabilityWM;
	}
	
	
	
	//ResponseDifferentialDiagnosisByExpanatoryProbability
	public ResponseDifferentialDiagnosisByExpanatoryProbability mapResponseDifferentialDiagnosisByExpanatoryProbability(
			ResponseDifferentialDiagnosisByExpanatoryProbabilityWM responseDifferentialDiagnosisByExpanatoryProbabilityWM) throws Exception{
		ResponseDifferentialDiagnosisByExpanatoryProbability responseDifferentialDiagnosisByExpanatoryProbability = new ResponseDifferentialDiagnosisByExpanatoryProbability();
		
		responseDifferentialDiagnosisByExpanatoryProbability.setDisease(responseDifferentialDiagnosisByExpanatoryProbabilityWM.getDisease());
		responseDifferentialDiagnosisByExpanatoryProbability.setId(responseDifferentialDiagnosisByExpanatoryProbabilityWM.getId());
		responseDifferentialDiagnosisByExpanatoryProbability.setProbability(responseDifferentialDiagnosisByExpanatoryProbabilityWM.getProbability());
		responseDifferentialDiagnosisByExpanatoryProbability.setResponseDiagnosticId(responseDifferentialDiagnosisByExpanatoryProbabilityWM.getResponseDiagnosticId());
		
		return responseDifferentialDiagnosisByExpanatoryProbability;
	}
	
	public ResponseDifferentialDiagnosisByExpanatoryProbabilityWM mapResponseDifferentialDiagnosisByExpanatoryProbability(
			ResponseDifferentialDiagnosisByExpanatoryProbability responseDifferentialDiagnosisByExpanatoryProbability) throws Exception{
		ResponseDifferentialDiagnosisByExpanatoryProbabilityWM responseDifferentialDiagnosisByExpanatoryProbabilityWM = new ResponseDifferentialDiagnosisByExpanatoryProbabilityWM();
		
		responseDifferentialDiagnosisByExpanatoryProbabilityWM.setDisease(responseDifferentialDiagnosisByExpanatoryProbability.getDisease());
		responseDifferentialDiagnosisByExpanatoryProbabilityWM.setId(responseDifferentialDiagnosisByExpanatoryProbability.getId());
		responseDifferentialDiagnosisByExpanatoryProbabilityWM.setProbability(responseDifferentialDiagnosisByExpanatoryProbability.getProbability());
		responseDifferentialDiagnosisByExpanatoryProbabilityWM.setResponseDiagnosticId(responseDifferentialDiagnosisByExpanatoryProbability.getResponseDiagnosticId());
		
		return responseDifferentialDiagnosisByExpanatoryProbabilityWM;
	}
	
	public List<ResponseDifferentialDiagnosisByExpanatoryProbability> mapResponseDifferentialDiagnosisByExpanatoryProbability(
			List<ResponseDifferentialDiagnosisByExpanatoryProbabilityWM> responseDifferentialDiagnosisByExpanatoryProbabilityWM) throws Exception{
		List<ResponseDifferentialDiagnosisByExpanatoryProbability> responseDifferentialDiagnosisByExpanatoryProbability = new ArrayList<>();
		
		for(ResponseDifferentialDiagnosisByExpanatoryProbabilityWM item : responseDifferentialDiagnosisByExpanatoryProbabilityWM) {
			responseDifferentialDiagnosisByExpanatoryProbability.add(mapResponseDifferentialDiagnosisByExpanatoryProbability(item));
		}
		
		return responseDifferentialDiagnosisByExpanatoryProbability;
	}
	
	public List<ResponseDifferentialDiagnosisByExpanatoryProbabilityWM> mapResponseDifferentialDiagnosisByExpanatoryProbabilityToWM(
			List<ResponseDifferentialDiagnosisByExpanatoryProbability> responseDifferentialDiagnosisByExpanatoryProbability) throws Exception{
		List<ResponseDifferentialDiagnosisByExpanatoryProbabilityWM> responseDifferentialDiagnosisByExpanatoryProbabilityWM = new ArrayList<>();
		
		for(ResponseDifferentialDiagnosisByExpanatoryProbability item : responseDifferentialDiagnosisByExpanatoryProbability) {
			responseDifferentialDiagnosisByExpanatoryProbabilityWM.add(mapResponseDifferentialDiagnosisByExpanatoryProbability(item));
		}

		return responseDifferentialDiagnosisByExpanatoryProbabilityWM;
	}
	
	
	
	//ResponseFinalDiagnosis
	public ResponseFinalDiagnosis mapResponseFinalDiagnosis(ResponseFinalDiagnosisWM responseFinalDiagnosisWM) throws Exception{
		ResponseFinalDiagnosis responseFinalDiagnosis = new ResponseFinalDiagnosis();
		
		responseFinalDiagnosis.setAdvice(responseFinalDiagnosisWM.getAdvice());
		responseFinalDiagnosis.setDisease(responseFinalDiagnosisWM.getDisease());
		responseFinalDiagnosis.setId(responseFinalDiagnosisWM.getId());
		responseFinalDiagnosis.setProbability(responseFinalDiagnosisWM.getProbability());
		responseFinalDiagnosis.setResponseDiagnosticId(responseFinalDiagnosisWM.getResponseDiagnosticId());
		
		return responseFinalDiagnosis;
	}
	
	public ResponseFinalDiagnosisWM mapResponseFinalDiagnosis(ResponseFinalDiagnosis responseFinalDiagnosis) throws Exception{
		ResponseFinalDiagnosisWM responseFinalDiagnosisWM = new ResponseFinalDiagnosisWM();
		
		responseFinalDiagnosisWM.setAdvice(responseFinalDiagnosis.getAdvice());
		responseFinalDiagnosisWM.setDisease(responseFinalDiagnosis.getDisease());
		responseFinalDiagnosisWM.setId(responseFinalDiagnosis.getId());
		responseFinalDiagnosisWM.setProbability(responseFinalDiagnosis.getProbability());
		responseFinalDiagnosisWM.setResponseDiagnosticId(responseFinalDiagnosis.getResponseDiagnosticId());
		
		return responseFinalDiagnosisWM;
	}
	
	public List<ResponseFinalDiagnosis> mapResponseFinalDiagnosis(List<ResponseFinalDiagnosisWM> responseFinalDiagnosisWM) throws Exception{
		List<ResponseFinalDiagnosis> responseFinalDiagnosis = new ArrayList<>();
		
		for(ResponseFinalDiagnosisWM item : responseFinalDiagnosisWM) {
			responseFinalDiagnosis.add(mapResponseFinalDiagnosis(item));
		}
		
		return responseFinalDiagnosis;
	}
	
	public List<ResponseFinalDiagnosisWM> mapResponseFinalDiagnosisToWM(List<ResponseFinalDiagnosis> responseFinalDiagnosis) throws Exception{
		List<ResponseFinalDiagnosisWM> responseFinalDiagnosisWM = new ArrayList<>();
		
		for(ResponseFinalDiagnosis item : responseFinalDiagnosis) {
			responseFinalDiagnosisWM.add(mapResponseFinalDiagnosis(item));
		}
		
		return responseFinalDiagnosisWM;
	}
	
	
	
	//DiagnosticSave
	public DiagnosticSaveEM mapDiagnosticSave(DiagnosticSaveWM diagnosticSaveWM)  throws Exception{
		DiagnosticSaveEM diagnosticSaveEM = new DiagnosticSaveEM();
		
		diagnosticSaveEM.setRequestDiagnostics(mapRequestDiagnostics(diagnosticSaveWM.getRequestDiagnosticsWM()));
		
		diagnosticSaveEM.setRequestedSymptoms(mapRequestedSymptoms(diagnosticSaveWM.getRequestedSymptomsWM()));
		
		diagnosticSaveEM.setResponseDiagnostics(mapResponseDiagnostics(diagnosticSaveWM.getResponseDiagnosticsWM()));
		
		diagnosticSaveEM.setDiagnosticReportedSymptoms(mapResponseDiagnosticReportedSymptoms(diagnosticSaveWM.getDiagnosticReportedSymptomsWM()));
		
		diagnosticSaveEM.setResponseDiagnosticStatics(mapResponseDiagnosticStatics(diagnosticSaveWM.getResponseDiagnosticStaticsWM()));
		
		diagnosticSaveEM.setResponseDifferentialDiagnosisByContributoryProbabilities(mapResponseDifferentialDiagnosisByContributoryProbability(diagnosticSaveWM.getResponseDifferentialDiagnosisByContributoryProbabilityWM()));
		
		diagnosticSaveEM.setResponseDifferentialDiagnosisByExpanatoryProbabilities(mapResponseDifferentialDiagnosisByExpanatoryProbability(diagnosticSaveWM.getResponseDifferentialDiagnosisByExpanatoryProbabilityWM()));
		
		diagnosticSaveEM.setResponseFinalDiagnosis(mapResponseFinalDiagnosis(diagnosticSaveWM.getResponseFinalDiagnosisWM()));
		
		return diagnosticSaveEM;
	}
	
}
