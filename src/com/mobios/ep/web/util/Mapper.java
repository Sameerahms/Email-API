package com.mobios.ep.web.util;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import javassist.compiler.ast.Pair;

import org.apache.commons.collections.MultiHashMap;
import org.springframework.util.MultiValueMap;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.mobios.ep.web.models.AdvertisementResp;
import com.mobios.ep.web.models.AppoinmentWM;
import com.mobios.ep.web.models.AppointmentReq;
import com.mobios.ep.web.models.AppointmentStats;
import com.mobios.ep.web.models.BloodGroupReq;
import com.mobios.ep.web.models.DiagnosticSaveWM;
import com.mobios.ep.web.models.Doctor;
import com.mobios.ep.web.models.DoctorProfileWM;
import com.mobios.ep.web.models.DrugWM;
import com.mobios.ep.web.models.FavouriteDrugWM;
import com.mobios.ep.web.models.HealthWikiResp;
import com.mobios.ep.web.models.HealthWikiSharedReq;
import com.mobios.ep.web.models.HealthWikiWM;
import com.mobios.ep.web.models.Info;
import com.mobios.ep.web.models.InstituteWM;
import com.mobios.ep.web.models.InvestigationEmailInfoM;
import com.mobios.ep.web.models.InvestigationEmailSummaryM;
import com.mobios.ep.web.models.InvestigationEmailWM;
import com.mobios.ep.web.models.InvestigationWM;
import com.mobios.ep.web.models.InvoiceWM;
import com.mobios.ep.web.models.MedicalBillWM;
import com.mobios.ep.web.models.MedicalCertificateWM;
import com.mobios.ep.web.models.MedicalStatWM;
import com.mobios.ep.web.models.MedicalTestsWM;
import com.mobios.ep.web.models.PastDiseases;
import com.mobios.ep.web.models.Patient;
import com.mobios.ep.web.models.PatientNameResp;
import com.mobios.ep.web.models.PrescSaveResponseWM;
import com.mobios.ep.web.models.Prescription;
import com.mobios.ep.web.models.PrescriptionDrugs;
import com.mobios.ep.web.models.PrescriptionImage;
import com.mobios.ep.web.models.PrescriptionList;
import com.mobios.ep.web.models.PrescriptionResp;
import com.mobios.ep.web.models.ReferralLetterWM;
import com.mobios.ep.web.models.RegistrationReq;
import com.mobios.ep.web.models.RegistrationResponse;
import com.mobios.ep.web.models.RequestDiagnosticsWM;
import com.mobios.ep.web.models.RequestedSymptomsWM;
import com.mobios.ep.web.models.ResponseDiagnosticReportedSymptomsWM;
import com.mobios.ep.web.models.ResponseDiagnosticStaticsComplainedSymptomsWM;
import com.mobios.ep.web.models.ResponseDiagnosticStaticsWM;
import com.mobios.ep.web.models.SessionReq;
import com.mobios.ep.web.models.SessionResp;
import com.mobios.ep.web.models.SessionSummaryWM;
import com.mobios.ep.web.models.SessionWM;
import com.mobios.ep.web.models.StatsWM;
import com.mobios.ep.web.models.SubmitOtpReq;
import com.mobios.ep.web.models.TemplateDrugWM;
import com.mobios.ep.web.models.TemplateWM;
import com.mobios.ep.web.models.UserProfileWM;
import com.mobios.ep.web.models.UserWM;
import com.ombios.ep.entity.model.AdvertisementInfo;
import com.ombios.ep.entity.model.Appointment;
import com.ombios.ep.entity.model.DiagnosticSaveEM;
import com.ombios.ep.entity.model.DoctorProfile;
import com.ombios.ep.entity.model.Drug;
import com.ombios.ep.entity.model.FavouriteDrugEM;
import com.ombios.ep.entity.model.HealthWiki;
import com.ombios.ep.entity.model.HealthWikiRespEM;
import com.ombios.ep.entity.model.HealthWikiShared;
import com.ombios.ep.entity.model.Institute;
import com.ombios.ep.entity.model.Investigation;
import com.ombios.ep.entity.model.InvestigationEmailInfoEM;
import com.ombios.ep.entity.model.InvestigationEmailSummaryEM;
import com.ombios.ep.entity.model.Invoice;
import com.ombios.ep.entity.model.MedicalBill;
import com.ombios.ep.entity.model.MedicalCertificate;
import com.ombios.ep.entity.model.MedicalStat;
import com.ombios.ep.entity.model.MedicalTests;
import com.ombios.ep.entity.model.PrescriptionDrugsEM;
import com.ombios.ep.entity.model.PatientEM;
import com.ombios.ep.entity.model.PrescriptionEM;
import com.ombios.ep.entity.model.PrescriptionImageEM;
import com.ombios.ep.entity.model.PrescriptionInfoEM;
import com.ombios.ep.entity.model.ReferralLetter;
import com.ombios.ep.entity.model.RegistrationEM;
import com.ombios.ep.entity.model.RegistrationResponseEM;
import com.ombios.ep.entity.model.RequestDiagnostics;
import com.ombios.ep.entity.model.RequestedSymptoms;
import com.ombios.ep.entity.model.ResponseDiagnosticReportedSymptoms;
import com.ombios.ep.entity.model.ResponseDiagnosticStatics;
import com.ombios.ep.entity.model.ResponseDiagnosticStaticsComplainedSymptoms;
import com.ombios.ep.entity.model.ResponseDiagnostics;
import com.ombios.ep.entity.model.SessionEM;
import com.ombios.ep.entity.model.SessionSummary;
import com.ombios.ep.entity.model.Stats;
import com.ombios.ep.entity.model.Template;
import com.ombios.ep.entity.model.TemplateDrug;
import com.ombios.ep.entity.model.TemplateEM;
import com.ombios.ep.entity.model.User;
import com.ombios.ep.entity.model.UserInfo;
import com.ombios.ep.entity.model.UserProfileEM;

/**
 * @author hasithakaushan
 *
 */
public class Mapper {

	/**
	 * @param drugsList
	 * 
	 *                  maps the saved drugs list to send
	 * 
	 * @return
	 */
	public List<DrugWM> mapData(List<Drug> drugsList) {
		List<DrugWM> mappedDrugList = new ArrayList<DrugWM>();

		for (Drug drug : drugsList) {

			DrugWM drugWM = new DrugWM();
			drugWM.setId(drug.getId());
			drugWM.setDoctorId(drug.getDoctorId());
			drugWM.setTradeName(drug.getTradeName());
			drugWM.setGenericName(drug.getGenericName());
			drugWM.setRawName(drug.getRawName());
			drugWM.setWeight(drug.getWeight().split(","));
			drugWM.setDefaultWeight(drug.getDefaultWeight());
			drugWM.setDefaultFrequency(drug.getDefaultFrequency());
			drugWM.setCategory(drug.getCategoryName());
			drugWM.setLastUpdatedTime(drug.getLastUpdatedTime());
			drugWM.setStatus(drug.getStatus());
			drugWM.setCategory(drug.getCategoryName());
			drugWM.setHasVerified(drug.isHasVerified());
			drugWM.setEnable(drug.getEnable());
			drugWM.setRejectReason(drug.getRejectReason());

			mappedDrugList.add(drugWM);

		}
		return mappedDrugList;
	}

	/**
	 * Maps drug model to drugWM
	 * 
	 * @param drug
	 * @return
	 * @throws JsonProcessingException
	 * @throws ParseException
	 * @throws Exception
	 */
	public DrugWM mapDrug(Drug drug) throws JsonProcessingException, ParseException, Exception {
		DrugWM drugWM = new DrugWM();

		drugWM.setId(drug.getId());
		drugWM.setDoctorId(drug.getDoctorId());
		drugWM.setTradeName(drug.getTradeName());
		drugWM.setGenericName(drug.getGenericName());
		drugWM.setRawName(drug.getRawName());
		drugWM.setWeight(drug.getWeight().split(","));
		drugWM.setDefaultWeight(drug.getDefaultWeight());
		drugWM.setDefaultFrequency(drug.getDefaultFrequency());
		drugWM.setCategory(drug.getCategoryName());
		drugWM.setLastUpdatedTime(drug.getLastUpdatedTime());
		drugWM.setStatus(drug.getStatus());
		drugWM.setCategory(drug.getCategoryName());
		drugWM.setHasVerified(drug.isHasVerified());
		drugWM.setEnable(drug.getEnable());
		drugWM.setRejectReason(drug.getRejectReason());

		return drugWM;
	}

	/**
	 * @param prescription
	 * 
	 *                     maps the received prescription from client
	 * 
	 * @return
	 * @throws JsonProcessingException
	 * @throws ParseException
	 */
	public PrescriptionEM mapPrescription(Prescription prescription) throws JsonProcessingException, ParseException {

		Date now = new Date();
		DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = df2.format(now);
		String appointmentTime = df1.format(now);
		// Date nxtDate = df2.parse(prescription.getNextVisitDate());
		// String nxtTimeStr = df2.format(nxtDate);

		PrescriptionEM mappedPrescription = new PrescriptionEM();
		PatientEM mappedPatient = new PatientEM();
		UserInfo patient = new UserInfo();
		UserInfo doctor = new UserInfo();
		Appointment appointment = new Appointment();
		SessionEM sessionEM = new SessionEM();
		Stats stats = new Stats();
		List<Stats> statsList = new ArrayList<Stats>();
		PrescriptionInfoEM mappedPrescriptionInfo = new PrescriptionInfoEM();
		ObjectMapper objectMapper = new ObjectMapper();

		List<PrescriptionDrugsEM> pdemList = new ArrayList<PrescriptionDrugsEM>();

		/*
		 * mappedPatient.setName(prescription.getPatient().getName());
		 * mappedPatient.setAge(prescription.getPatient().getAge());
		 * mappedPatient.setCreatedDate(now);
		 */
		// mappedPatient.setId(prescription.getPatient().getId());
		doctor.setId(prescription.getDoctorId());
		sessionEM.setId(prescription.getSessionId());
		sessionEM.setDoctor(doctor);
		sessionEM.setInstituteId(prescription.getInstituteId());

		patient.setId(prescription.getPatient().getId());
		patient.setTitle(prescription.getPatient().getTitle());
		patient.setFirstName(prescription.getPatient().getFirstName());
		patient.setLastName(prescription.getPatient().getLastName());
		patient.setNic(prescription.getPatient().getNic());
		patient.setParentNIC(prescription.getPatient().getParentNIC());
		patient.setAge(prescription.getPatient().getAge());
		patient.setEmail(prescription.getPatient().getEmail());
		patient.setAddress(prescription.getPatient().getAddress());
		patient.setMobile(prescription.getPatient().getMobile());
		patient.setGender(prescription.getPatient().getGender());
		patient.setUserType(prescription.getPatient().getUserType());
		patient.setUserRole("PATIENT");
		patient.setCreatedBy("DOCTOR" + prescription.getDoctorId());
		patient.setCreatedDate(time);
		patient.setModifiedDate("0000-00-00 00:00:00");
		patient.setDeletedDate("0000-00-00 00:00:00");
		patient.setLastUpdatedTime(1234567890123L);
		patient.setBloodGroup(prescription.getPatient().getBloodGroup());
		patient.setDateOfBirth(prescription.getPatient().getDateOfBirth());
		patient.setPassportNo(prescription.getPatient().getPassportNo());

		ObjectMapper objectMapperStats = new ObjectMapper();
		AppointmentStats appointmentStats = new AppointmentStats();
		appointmentStats.setBloodPressure1(prescription.getBloodPressure1());
		appointmentStats.setBloodPressure2(prescription.getBloodPressure2());
		appointmentStats.setHeight(prescription.getHeight());
		appointmentStats.setWeight(prescription.getWeight());
		appointmentStats.setPulse(prescription.getPulseRate());
		appointmentStats.setTemperature(prescription.getTemperature());

		String statString = objectMapperStats.writeValueAsString(appointmentStats);
		stats.setPatientId(prescription.getPatient().getId());
		stats.setCreatedDateTime(time);
		stats.setStats(statString);
		statsList.add(stats);

		appointment.setId(prescription.getAppointmentId());
		appointment.setInstituteId(prescription.getInstituteId());
		appointment.setAppointmentNo(prescription.getAppointmentNo());
		appointment.setAppoinmentTime(appointmentTime + " 00:00:00");
		appointment.setAppoinmentSession("M");
		appointment.setCreatedBy("DOCTOR" + prescription.getDoctorId());
		appointment.setCreatedDate(time);
		appointment.setModifiedDate("0000-00-00 00:00:00");
		appointment.setDeletedDate("0000-00-00 00:00:00");
		appointment.setLastUpdatedTime(1234567890123L);
		appointment.setDoctor(doctor);
		appointment.setPatient(patient);
		appointment.setSessionEM(sessionEM);
		// appointment.setStat(stats);
		// appointment.setStats(statsList);

		mappedPatient.setMobile(prescription.getPatient().getMobile());

		mappedPrescriptionInfo.setPatientId(prescription.getPatient().getId());
		mappedPrescriptionInfo.setAppointmentId(prescription.getAppointmentId());
		mappedPrescriptionInfo.setInstituteId(prescription.getInstituteId());
		mappedPrescriptionInfo.setDiagnosis(prescription.getDiagnosis());
		mappedPrescriptionInfo.setBloodPressure1(prescription.getBloodPressure1());
		mappedPrescriptionInfo.setBloodPressure2(prescription.getBloodPressure2());
		mappedPrescriptionInfo.setWeight(prescription.getWeight());
		mappedPrescriptionInfo.setHeight(prescription.getHeight());
		mappedPrescriptionInfo.setTests(prescription.getTests());
		mappedPrescriptionInfo.setNextVisitDate(prescription.getNextVisitDate());
		mappedPrescriptionInfo.setPulseRate(prescription.getPulseRate());
		mappedPrescriptionInfo.setCreatedDate(time);
		mappedPrescriptionInfo.setTemperature(prescription.getTemperature());
		mappedPrescriptionInfo.setComments(prescription.getComments());

		for (PrescriptionDrugs pd : prescription.getDrugs()) {

			PrescriptionDrugsEM pdem = new PrescriptionDrugsEM();

			pdem.setDrugId(pd.getId());
			pdem.setWeight(pd.getWeight());
			pdem.setFrequency(pd.getFrequency());
			pdem.setDuration(pd.getDuration());
			pdem.setQuantity(pd.getQty());
			pdem.setCounter(pd.getCounter());
			pdem.setInHouse(pd.isInHouse());
			// pdem.setCreatedDate(df2.format(now));
			pdem.setPrescriptionInfoEM(mappedPrescriptionInfo);

			pdemList.add(pdem);

		}

		mappedPrescription.setPrescriptionDrugsEMs(pdemList);
		// mappedPrescription.setPatient(mappedPatient);
		mappedPrescriptionInfo.setAppointment(appointment);
		mappedPrescriptionInfo.setUser(patient);
		mappedPrescription.setPrescriptionInfo(mappedPrescriptionInfo);

		return mappedPrescription;

	}

	/**
	 * @param prescriptionInfoEM
	 * 
	 *                           maps the saved prescription to send.
	 * 
	 * @return
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 */
	public Prescription mapRetrievedPrescription(PrescriptionInfoEM prescriptionInfoEM)
			throws JsonParseException, JsonMappingException, IOException {

		Prescription prescription = new Prescription();
		Patient patient = new Patient();
		Doctor doctor = new Doctor();
		// UserWM patient = new UserWM();
		// UserWM doctor = new UserWM();
		ObjectMapper objectMapper = new ObjectMapper();
		List<PrescriptionDrugs> prescriptionDrugs = new ArrayList<PrescriptionDrugs>();
		// Info patientInfo =
		// objectMapper.readValue(prescriptionInfoEM.getAppointment().getPatient().getInfo(),
		// Info.class);
		Info doctorInfo = objectMapper.readValue(prescriptionInfoEM.getAppointment().getDoctor().getInfo(), Info.class);

		doctor.setId(prescriptionInfoEM.getAppointment().getDoctor().getId());
		doctor.setTitle(prescriptionInfoEM.getAppointment().getDoctor().getTitle());
		doctor.setFirstName(prescriptionInfoEM.getAppointment().getDoctor().getFirstName());
		doctor.setLastName(prescriptionInfoEM.getAppointment().getDoctor().getLastName());
		doctor.setAge(prescriptionInfoEM.getAppointment().getDoctor().getAge());
		doctor.setMobile(prescriptionInfoEM.getAppointment().getDoctor().getMobile());
		doctor.setNic(prescriptionInfoEM.getAppointment().getDoctor().getNic());
		doctor.setEmail(prescriptionInfoEM.getAppointment().getDoctor().getEmail());
		doctor.setGender(prescriptionInfoEM.getAppointment().getDoctor().getGender());
		doctor.setUserType(prescriptionInfoEM.getAppointment().getDoctor().getUserType());
		doctor.setInfo(doctorInfo);

		patient.setId(prescriptionInfoEM.getAppointment().getPatient().getId());
		patient.setTitle(prescriptionInfoEM.getAppointment().getPatient().getTitle());
		patient.setFirstName(prescriptionInfoEM.getAppointment().getPatient().getFirstName());
		patient.setLastName(prescriptionInfoEM.getAppointment().getPatient().getLastName());
		patient.setAge(prescriptionInfoEM.getAppointment().getPatient().getAge());
		patient.setNic(prescriptionInfoEM.getAppointment().getPatient().getNic());
		patient.setEmail(prescriptionInfoEM.getAppointment().getPatient().getEmail());
		patient.setMobile(prescriptionInfoEM.getAppointment().getPatient().getMobile());
		patient.setUserType(prescriptionInfoEM.getAppointment().getPatient().getUserType());
		patient.setGender(prescriptionInfoEM.getAppointment().getPatient().getGender());
		patient.setBloodGroup(prescriptionInfoEM.getAppointment().getPatient().getBloodGroup());
		patient.setDateOfBirth(prescriptionInfoEM.getAppointment().getPatient().getDateOfBirth());
		patient.setPassportNo(prescriptionInfoEM.getAppointment().getPatient().getPassportNo());

		for (PrescriptionDrugsEM prescriptionDrugsEM : prescriptionInfoEM.getPrescriptionDrugsEMs()) {

			PrescriptionDrugs drug = new PrescriptionDrugs();

			drug.setId(prescriptionDrugsEM.getDrugId());
			drug.setCounter(prescriptionDrugsEM.getCounter());
			drug.setTradeName(prescriptionDrugsEM.getDrug().getTradeName());
			drug.setGenericName(prescriptionDrugsEM.getDrug().getGenericName());
			drug.setRawName(prescriptionDrugsEM.getDrug().getRawName());
			drug.setWeight(prescriptionDrugsEM.getWeight());
			drug.setDuration(prescriptionDrugsEM.getDuration());
			drug.setQty(prescriptionDrugsEM.getQuantity());
			drug.setFrequency(prescriptionDrugsEM.getFrequency());
			drug.setCategory(prescriptionDrugsEM.getDrug().getCategoryName());
			drug.setInHouse(prescriptionDrugsEM.isInHouse());

			prescriptionDrugs.add(drug);
		}
		prescription.setId(prescriptionInfoEM.getId());
		prescription.setAppointmentId(prescriptionInfoEM.getAppointmentId());
		prescription.setBloodPressure1(prescriptionInfoEM.getBloodPressure1());
		prescription.setBloodPressure2(prescriptionInfoEM.getBloodPressure2());
		prescription.setNextVisitDate(prescriptionInfoEM.getNextVisitDate());
		prescription.setPulseRate(prescriptionInfoEM.getPulseRate());
		prescription.setTests(prescriptionInfoEM.getTests());
		prescription.setTemperature(prescriptionInfoEM.getTemperature());
		prescription.setComments(prescriptionInfoEM.getComments());
		prescription.setDrugs(prescriptionDrugs);
		prescription.setDiagnosis(prescriptionInfoEM.getDiagnosis());
		prescription.setHeight(prescriptionInfoEM.getHeight());
		prescription.setWeight(prescriptionInfoEM.getWeight());
		prescription.setCreatedDate(prescriptionInfoEM.getCreatedDate());
		prescription.setPatient(patient);
		prescription.setDoctor(doctor);

		return prescription;

	}

	public InvestigationEmailInfoEM mapSaveInvestigationEmail(InvestigationEmailWM investigationEmailWM)
			throws JsonProcessingException, Exception {
		Date now = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = df.format(now);

		InvestigationEmailInfoEM investigationEmail = new InvestigationEmailInfoEM();
		investigationEmail.setId(investigationEmailWM.getId());
		investigationEmail.setPrescriptionId(investigationEmailWM.getPrescriptionId());
		investigationEmail.setDoctorId(investigationEmailWM.getDoctorId());
		investigationEmail.setDoctorHospitalId(investigationEmailWM.getDoctorHospitalId());
		investigationEmail.setInstituteId(investigationEmailWM.getInstitudeId());
		investigationEmail.setCreatedBy("DOCTOR" + investigationEmailWM.getDoctorId());
		investigationEmail.setCreatedDate(time);
		investigationEmail.setChecked("check");
		// TO DO fill the rest

		return investigationEmail;

	}

	public List<InvestigationEmailSummaryM> mapListInvestigationEmailSummary(
			List<InvestigationEmailSummaryEM> investigationsEmailSummaries)
			throws JsonParseException, JsonMappingException, IOException {

		List<InvestigationEmailSummaryM> investigationEmailSummaryM = new ArrayList<InvestigationEmailSummaryM>();
		for (InvestigationEmailSummaryEM investigationsEmailSummaryEM : investigationsEmailSummaries) {

			InvestigationEmailSummaryM investigationSummaryM = new InvestigationEmailSummaryM();
			investigationSummaryM.setCount(investigationsEmailSummaryEM.getCount());
			investigationSummaryM.setName(investigationsEmailSummaryEM.getName());
			investigationEmailSummaryM.add(investigationSummaryM);
		}
		return investigationEmailSummaryM;
	}

	public List<InvestigationEmailInfoM> mapListInvestigationEmailInfo(List<InvestigationEmailInfoEM> investigationsInfos) throws JsonParseException, JsonMappingException, IOException {
		
		System.out.println("Mapper 1 "+investigationsInfos.get(0).getDoctor().getFirstName());
		
		// InvestigationEmailInfoM investigationEmailInfoM = new
		// InvestigationEmailInfoM();
		// Doctor doctor = new Doctor();
		// ObjectMapper objectMapper = new ObjectMapper();
		// Info doctorInfo =
		// objectMapper.readValue(investigationsInfo.getDoctor().getInfo(), Info.class);

		List<InvestigationEmailInfoM> investigationEmailInfoM = new ArrayList<InvestigationEmailInfoM>();
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		for (InvestigationEmailInfoEM investigationsInfo : investigationsInfos) {
			
			Doctor doctor = new Doctor();
			
			System.out.println("Mapper 2 "+investigationsInfo.getDoctor().getFirstName());
			
			InvestigationEmailInfoM investigationInfoM = new InvestigationEmailInfoM();

			Institute institute = new Institute();
			// UserWM patient = new UserWM();
			// UserWM doctor = new UserWM();

			Info doctorInfo = objectMapper.readValue(investigationsInfo.getDoctor().getInfo(), Info.class);

			doctor.setId(investigationsInfo.getDoctor().getId());
			doctor.setTitle(investigationsInfo.getDoctor().getTitle());
			doctor.setFirstName(investigationsInfo.getDoctor().getFirstName());
			doctor.setLastName(investigationsInfo.getDoctor().getLastName());
			doctor.setAge(investigationsInfo.getDoctor().getAge());
			doctor.setMobile(investigationsInfo.getDoctor().getMobile());
			doctor.setNic(investigationsInfo.getDoctor().getNic());
			doctor.setEmail(investigationsInfo.getDoctor().getEmail());
			doctor.setGender(investigationsInfo.getDoctor().getGender());
			doctor.setUserType(investigationsInfo.getDoctor().getUserType());
			doctor.setInfo(doctorInfo);
			
			System.out.println("Mapper 3 "+doctor.getFirstName());

			institute.setName(investigationsInfo.getInstitute().getName());
			institute.setPrescriptionAddress1(investigationsInfo.getInstitute().getPrescriptionAddress1());
			institute.setPrescriptionAddress2(investigationsInfo.getInstitute().getPrescriptionAddress2());
			institute.setPrescriptionPhone(investigationsInfo.getInstitute().getPrescriptionPhone());
			institute.setPrescriptionEmail(investigationsInfo.getInstitute().getPrescriptionEmail());
			institute.setPrescriptionURL(investigationsInfo.getInstitute().getImageURL());

			investigationInfoM.setId(investigationsInfo.getId());
			investigationInfoM.setPrescriptionId(investigationsInfo.getPrescriptionId());
			investigationInfoM.setDoctorId(investigationsInfo.getDoctorId());
			investigationInfoM.setDoctorHospitalId(investigationsInfo.getDoctorHospitalId());
			investigationInfoM.setCreatedDate(investigationsInfo.getCreatedDate());
			investigationInfoM.setChecked(investigationsInfo.getChecked());

			investigationInfoM.setDoctor(doctor);
			
			System.out.println("Mapper 4 "+investigationInfoM.getDoctor().getFirstName());
			
			investigationInfoM.setInstitute(institute);
			investigationEmailInfoM.add(investigationInfoM);
			
			System.out.println("Mapper 5 "+investigationEmailInfoM.get(0).getDoctor().getFirstName());
		}
		
		System.out.println("Mapper 5 outside forloop "+investigationEmailInfoM.get(0).getDoctor().getFirstName());
		
		return investigationEmailInfoM;
	}

	public Prescription mapRetrievedPrescriptionByUuid(PrescriptionInfoEM prescriptionInfoEM)
			throws JsonParseException, JsonMappingException, IOException {

		Prescription prescription = new Prescription();
		Patient patient = new Patient();
		Doctor doctor = new Doctor();
		// UserWM patient = new UserWM();
		// UserWM doctor = new UserWM();
		ObjectMapper objectMapper = new ObjectMapper();
		List<PrescriptionDrugs> prescriptionDrugs = new ArrayList<PrescriptionDrugs>();
		// Info patientInfo =
		// objectMapper.readValue(prescriptionInfoEM.getAppointment().getPatient().getInfo(),
		// Info.class);
		Info doctorInfo = objectMapper.readValue(prescriptionInfoEM.getAppointment().getDoctor().getInfo(), Info.class);

		doctor.setId(prescriptionInfoEM.getAppointment().getDoctor().getId());
		doctor.setTitle(prescriptionInfoEM.getAppointment().getDoctor().getTitle());
		doctor.setFirstName(prescriptionInfoEM.getAppointment().getDoctor().getFirstName());
		doctor.setLastName(prescriptionInfoEM.getAppointment().getDoctor().getLastName());
		doctor.setAge(prescriptionInfoEM.getAppointment().getDoctor().getAge());
		doctor.setMobile(prescriptionInfoEM.getAppointment().getDoctor().getMobile());
		doctor.setNic(prescriptionInfoEM.getAppointment().getDoctor().getNic());
		doctor.setEmail(prescriptionInfoEM.getAppointment().getDoctor().getEmail());
		doctor.setGender(prescriptionInfoEM.getAppointment().getDoctor().getGender());
		doctor.setUserType(prescriptionInfoEM.getAppointment().getDoctor().getUserType());
		doctor.setInfo(doctorInfo);

		patient.setId(prescriptionInfoEM.getAppointment().getPatient().getId());
		patient.setTitle(prescriptionInfoEM.getAppointment().getPatient().getTitle());
		patient.setFirstName(prescriptionInfoEM.getAppointment().getPatient().getFirstName());
		patient.setLastName(prescriptionInfoEM.getAppointment().getPatient().getLastName());
		patient.setAge(prescriptionInfoEM.getAppointment().getPatient().getAge());
		patient.setNic(prescriptionInfoEM.getAppointment().getPatient().getNic());
		patient.setEmail(prescriptionInfoEM.getAppointment().getPatient().getEmail());
		patient.setMobile(prescriptionInfoEM.getAppointment().getPatient().getMobile());
		patient.setUserType(prescriptionInfoEM.getAppointment().getPatient().getUserType());
		patient.setGender(prescriptionInfoEM.getAppointment().getPatient().getGender());
		patient.setBloodGroup(prescriptionInfoEM.getAppointment().getPatient().getBloodGroup());
		patient.setDateOfBirth(prescriptionInfoEM.getAppointment().getPatient().getDateOfBirth());
		patient.setPassportNo(prescriptionInfoEM.getAppointment().getPatient().getPassportNo());

		for (PrescriptionDrugsEM prescriptionDrugsEM : prescriptionInfoEM.getPrescriptionDrugsEMs()) {

			PrescriptionDrugs drug = new PrescriptionDrugs();

			drug.setId(prescriptionDrugsEM.getDrugId());
			drug.setCounter(prescriptionDrugsEM.getCounter());
			drug.setTradeName(prescriptionDrugsEM.getDrug().getTradeName());
			drug.setGenericName(prescriptionDrugsEM.getDrug().getGenericName());
			drug.setRawName(prescriptionDrugsEM.getDrug().getRawName());
			drug.setWeight(prescriptionDrugsEM.getWeight());
			drug.setDuration(prescriptionDrugsEM.getDuration());
			drug.setQty(prescriptionDrugsEM.getQuantity());
			drug.setFrequency(prescriptionDrugsEM.getFrequency());
			drug.setCategory(prescriptionDrugsEM.getDrug().getCategoryName());
			drug.setInHouse(prescriptionDrugsEM.isInHouse());
			prescriptionDrugs.add(drug);
		}
		prescription.setId(prescriptionInfoEM.getId());
		prescription.setUuid(prescriptionInfoEM.getUuid());
		prescription.setAppointmentId(prescriptionInfoEM.getAppointmentId());
		prescription.setBloodPressure1(prescriptionInfoEM.getBloodPressure1());
		prescription.setBloodPressure2(prescriptionInfoEM.getBloodPressure2());
		prescription.setNextVisitDate(prescriptionInfoEM.getNextVisitDate());
		prescription.setPulseRate(prescriptionInfoEM.getPulseRate());
		prescription.setTests(prescriptionInfoEM.getTests());
		prescription.setTemperature(prescriptionInfoEM.getTemperature());
		prescription.setComments(prescriptionInfoEM.getComments());
		prescription.setDrugs(prescriptionDrugs);
		prescription.setDiagnosis(prescriptionInfoEM.getDiagnosis());
		prescription.setHeight(prescriptionInfoEM.getHeight());
		prescription.setWeight(prescriptionInfoEM.getWeight());
		prescription.setCreatedDate(prescriptionInfoEM.getCreatedDate());
		prescription.setPatient(patient);
		prescription.setDoctor(doctor);

		return prescription;

	}

	/**
	 * 
	 * maps the details with regards to login
	 * 
	 * @param userInfo
	 * @return
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 */
	public UserWM mapUserInfo(UserInfo userInfo) throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper objectMapper = new ObjectMapper();
		Info info = new Info();
		if (userInfo.getUserType().equals("DOCTOR")) {
			info = objectMapper.readValue(userInfo.getInfo(), Info.class);
		}

		UserWM userInfoWM = new UserWM();

		userInfoWM.setId(userInfo.getId());
		userInfoWM.setTitle(userInfo.getTitle());
		userInfoWM.setFirstName(userInfo.getFirstName());
		userInfoWM.setLastName(userInfo.getLastName());
		userInfoWM.setNic(userInfo.getNic());
		userInfoWM.setMobile(userInfo.getMobile());
		userInfoWM.setEmail(userInfo.getEmail());
		userInfoWM.setAddress(userInfo.getAddress());
		userInfoWM.setAge(userInfo.getAge());
		userInfoWM.setGender(userInfo.getGender());
		userInfoWM.setInfo(info);
		userInfoWM.setUserType(userInfo.getUserType());
		userInfoWM.setAccessToken(userInfo.getUser().getAccessToken());
		userInfoWM.setBloodGroup(userInfo.getBloodGroup());
		userInfoWM.setDateOfBirth(userInfo.getDateOfBirth());

		return userInfoWM;

	}

	public UserWM mapUserInfoPatient(UserInfo userInfo) throws JsonParseException, JsonMappingException, IOException {

		UserWM userInfoWM = new UserWM();

		userInfoWM.setId(userInfo.getId());
		userInfoWM.setTitle(userInfo.getTitle());
		userInfoWM.setFirstName(userInfo.getFirstName());
		userInfoWM.setLastName(userInfo.getLastName());
		userInfoWM.setNic(userInfo.getNic());
		userInfoWM.setParentNIC(userInfo.getParentNIC());
		userInfoWM.setMobile(userInfo.getMobile());
		userInfoWM.setEmail(userInfo.getEmail());
		userInfoWM.setAddress(userInfo.getAddress());
		userInfoWM.setAge(userInfo.getAge());
		userInfoWM.setGender(userInfo.getGender());
		// userInfoWM.setInfo(info);
		userInfoWM.setUserType(userInfo.getUserType());
		// userInfoWM.setAccessToken(userInfo.getUser().getAccessToken());
		userInfoWM.setBloodGroup(userInfo.getBloodGroup());
		userInfoWM.setDateOfBirth(userInfo.getDateOfBirth());

		return userInfoWM;

	}

	/**
	 * 
	 * maps the details of the appointment. i.e. patient's details, doctor's
	 * details, appointment details etc...
	 * 
	 * @param appointment
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public AppoinmentWM mapAppointment(Appointment appointment, Stats stats)
			throws JsonParseException, JsonMappingException, IOException {

		AppoinmentWM appoinmentWM = new AppoinmentWM();
		Patient Patient = new Patient();
		Doctor Doctor = new Doctor();
		// AppointmentStats appointmentStats= new AppointmentStats();
		List<AppointmentStats> appointmentStatsList = new ArrayList<>();

		ObjectMapper objectMapper = new ObjectMapper();
		Info infoDoctor = objectMapper.readValue(appointment.getDoctor().getInfo(), Info.class);

		Patient.setId(appointment.getPatient().getId());
		Patient.setTitle(appointment.getPatient().getTitle());
		Patient.setFirstName(appointment.getPatient().getFirstName());
		Patient.setLastName(appointment.getPatient().getLastName());
		Patient.setNic(appointment.getPatient().getNic());
		Patient.setParentNIC(appointment.getPatient().getParentNIC());
		Patient.setMobile(appointment.getPatient().getMobile());
		Patient.setEmail(appointment.getPatient().getEmail());
		Patient.setGender(appointment.getPatient().getGender());
		Patient.setAge(appointment.getPatient().getAge());
		Patient.setUserType(appointment.getPatient().getUserType());
		Patient.setBloodGroup(appointment.getPatient().getBloodGroup());
		Patient.setDateOfBirth(appointment.getPatient().getDateOfBirth());
		Patient.setPassportNo(appointment.getPatient().getPassportNo());

		Doctor.setId(appointment.getDoctor().getId());
		Doctor.setTitle(appointment.getDoctor().getTitle());
		Doctor.setFirstName(appointment.getDoctor().getFirstName());
		Doctor.setLastName(appointment.getDoctor().getLastName());
		Doctor.setNic(appointment.getDoctor().getNic());
		Doctor.setMobile(appointment.getDoctor().getMobile());
		Doctor.setEmail(appointment.getDoctor().getEmail());
		Doctor.setGender(appointment.getDoctor().getGender());
		Doctor.setAge(appointment.getDoctor().getAge());
		Doctor.setUserType(appointment.getDoctor().getUserType());
		Doctor.setInfo(infoDoctor);

		// if(appointment.getStats().size()==0) appointmentStatsList.add(new
		// AppointmentStats());
		// for(Stats s : appointment.getStats()){
		AppointmentStats appointmentStats = new AppointmentStats();
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> map = new HashMap<String, Object>();
		map = mapper.readValue(stats.getStats(), new TypeReference<Map<String, Object>>() {
		});

		appointmentStats.setWeight((String) map.get("weight"));
		appointmentStats.setTemperature((String) map.get("temperature"));
		appointmentStats.setPulse((String) map.get("pulse"));
		appointmentStats.setHeight((String) map.get("height"));
		appointmentStats.setBloodPressure1((String) map.get("bloodPressure1"));
		appointmentStats.setBloodPressure2((String) map.get("bloodPressure2"));
		appointmentStats.setCreatedDateTime(stats.getCreatedDateTime());
		appointmentStatsList.add(appointmentStats);
		// }

		appoinmentWM.setId(appointment.getId());
		appoinmentWM.setAppointmentNo(appointment.getAppointmentNo());
		appoinmentWM.setInstituteId(appointment.getInstituteId());
		appoinmentWM.setAppoinmentTime(appointment.getAppoinmentTime());
		appoinmentWM.setAppoinmentSession(appointment.getAppoinmentSession());
		if (appointment.getInfoEMs() != null)
			appoinmentWM.setHasPrescription(true);
		appoinmentWM.setPatient(Patient);
		appoinmentWM.setDoctor(Doctor);
		if (appointmentStatsList.size() != 0)
			appoinmentWM.setStats(appointmentStatsList.get(0));

		return appoinmentWM;

	}

	public Appointment mapSaveAppointment(AppointmentReq appointmentReq)
			throws JsonParseException, JsonMappingException, IOException, Exception {
		Date now = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = df.format(now);

		Appointment appointmentEM = new Appointment();
		UserInfo patient = new UserInfo();
		UserInfo doctor = new UserInfo();
		SessionEM sessionEM = new SessionEM();
		Stats stats = new Stats();
		List<Stats> statsList = new ArrayList<Stats>();

		patient.setId(appointmentReq.getPatientId());
		doctor.setId(appointmentReq.getDoctorId());
		sessionEM.setId(appointmentReq.getSessionId());
		sessionEM.setInstituteId(appointmentReq.getInstituteId());
		sessionEM.setDoctor(doctor);

		ObjectMapper objectMapper = new ObjectMapper();
		AppointmentStats appointmentStats = new AppointmentStats();
		appointmentStats.setBloodPressure1(appointmentReq.getStats().getBloodPressure1());
		appointmentStats.setBloodPressure2(appointmentReq.getStats().getBloodPressure2());
		appointmentStats.setHeight(appointmentReq.getStats().getHeight());
		appointmentStats.setWeight(appointmentReq.getStats().getWeight());
		appointmentStats.setPulse(appointmentReq.getStats().getPulse());
		appointmentStats.setTemperature(appointmentReq.getStats().getTemperature());

		String statString = objectMapper.writeValueAsString(appointmentStats);
		stats.setStats(statString);
		stats.setPatientId(appointmentReq.getPatientId());
		stats.setCreatedDateTime(time);
		// stats.setAppointment(appointmentEM);
		statsList.add(stats);

		appointmentEM.setId(appointmentReq.getId());
		appointmentEM.setAppointmentNo(appointmentReq.getNoOfAppointment());
		appointmentEM.setInstituteId(appointmentReq.getInstituteId());
		appointmentEM.setAppoinmentTime(appointmentReq.getAppointmentTime());
		appointmentEM.setAppoinmentSession("M");
		appointmentEM.setCreatedBy("DOCTOR" + appointmentReq.getDoctorId());
		appointmentEM.setCreatedDate(time);
		appointmentEM.setModifiedDate("0000-00-00 00:00:00");
		appointmentEM.setDeletedDate("0000-00-00 00:00:00");
		appointmentEM.setLastUpdatedTime(1234567890123L);
		appointmentEM.setSessionEM(sessionEM);
		appointmentEM.setPatient(patient);
		appointmentEM.setDoctor(doctor);
		// appointmentEM.setStats(statsList);

		return appointmentEM;
	}

	public List<AppoinmentWM> mapAppointmentList(List<Appointment> appointments, List<Stats> stats)
			throws JsonParseException, JsonMappingException, IOException, Exception {
		List<AppoinmentWM> appoinmentWMs = new ArrayList<AppoinmentWM>();
		for (Appointment appointment : appointments) {
			AppoinmentWM appoinmentWM = new AppoinmentWM();
			Patient Patient = new Patient();
			Doctor Doctor = new Doctor();
			AppointmentStats appointmentStats = new AppointmentStats();

			ObjectMapper objectMapper = new ObjectMapper();
			Info infoDoctor = objectMapper.readValue(appointment.getDoctor().getInfo(), Info.class);

			Patient.setId(appointment.getPatient().getId());
			Patient.setTitle(appointment.getPatient().getTitle());
			Patient.setFirstName(appointment.getPatient().getFirstName());
			Patient.setLastName(appointment.getPatient().getLastName());
			Patient.setNic(appointment.getPatient().getNic());
			Patient.setParentNIC(appointment.getPatient().getParentNIC());
			Patient.setMobile(appointment.getPatient().getMobile());
			Patient.setEmail(appointment.getPatient().getEmail());
			Patient.setGender(appointment.getPatient().getGender());
			Patient.setAge(appointment.getPatient().getAge());
			Patient.setUserType(appointment.getPatient().getUserType());
			Patient.setBloodGroup(appointment.getPatient().getBloodGroup());
			Patient.setDateOfBirth(appointment.getPatient().getDateOfBirth());
			Patient.setPassportNo(appointment.getPatient().getPassportNo());

			Doctor.setId(appointment.getDoctor().getId());
			Doctor.setTitle(appointment.getDoctor().getTitle());
			Doctor.setFirstName(appointment.getDoctor().getFirstName());
			Doctor.setLastName(appointment.getDoctor().getLastName());
			Doctor.setNic(appointment.getDoctor().getNic());
			Doctor.setMobile(appointment.getDoctor().getMobile());
			Doctor.setEmail(appointment.getDoctor().getEmail());
			Doctor.setGender(appointment.getDoctor().getGender());
			Doctor.setAge(appointment.getDoctor().getAge());
			Doctor.setUserType(appointment.getDoctor().getUserType());
			Doctor.setInfo(infoDoctor);

			for (Stats s : stats) {
				if (s.getAppointmentId() == appointment.getId()) {
					ObjectMapper mapper = new ObjectMapper();
					Map<String, Object> map = new HashMap<String, Object>();
					map = mapper.readValue(s.getStats(), new TypeReference<Map<String, Object>>() {
					});
					// AppointmentStats appointmentStats =
					// objectMapper.readValue(appointment.getStat().getStats(),
					// AppointmentStats.class);

					appointmentStats.setWeight((String) map.get("weight"));
					appointmentStats.setTemperature((String) map.get("temperature"));
					appointmentStats.setPulse((String) map.get("pulse"));
					appointmentStats.setHeight((String) map.get("height"));
					appointmentStats.setBloodPressure1((String) map.get("bloodPressure1"));
					appointmentStats.setBloodPressure2((String) map.get("bloodPressure2"));
					appointmentStats.setCreatedDateTime(s.getCreatedDateTime());
				}
			}

			appoinmentWM.setId(appointment.getId());
			appoinmentWM.setAppointmentNo(appointment.getAppointmentNo());
			appoinmentWM.setInstituteId(appointment.getInstituteId());
			appoinmentWM.setAppoinmentTime(appointment.getAppoinmentTime());
			appoinmentWM.setAppoinmentSession(appointment.getAppoinmentSession());

			if (appointment.getInfoEMs().size() != 0)
				appoinmentWM.setHasPrescription(true);
			appoinmentWM.setPatient(Patient);
			appoinmentWM.setDoctor(Doctor);
			appoinmentWM.setStats(appointmentStats);

			appoinmentWMs.add(appoinmentWM);
		}
		return appoinmentWMs;

	}

	/**
	 * 
	 * maps the prescription list
	 * 
	 * 
	 * @param prescriptionInfoEMs
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public List<Prescription> mapPrescriptionList(List<PrescriptionInfoEM> prescriptionInfoEMs)
			throws JsonParseException, JsonMappingException, IOException {

		List<Prescription> prescriptions = new ArrayList<Prescription>();

		for (PrescriptionInfoEM prescriptionInfoEM : prescriptionInfoEMs) {

			Prescription prescription = new Prescription();
			Patient patient = new Patient();
			Doctor doctor = new Doctor();
			Institute institute = new Institute();
			// UserWM patient = new UserWM();
			// UserWM doctor = new UserWM();
			ObjectMapper objectMapper = new ObjectMapper();
			List<PrescriptionDrugs> prescriptionDrugs = new ArrayList<PrescriptionDrugs>();
			// Info patientInfo =
			// objectMapper.readValue(prescriptionInfoEM.getAppointment().getPatient().getInfo(),
			// Info.class);
			Info doctorInfo = objectMapper.readValue(prescriptionInfoEM.getAppointment().getDoctor().getInfo(),
					Info.class);

			doctor.setId(prescriptionInfoEM.getAppointment().getDoctor().getId());
			doctor.setTitle(prescriptionInfoEM.getAppointment().getDoctor().getTitle());
			doctor.setFirstName(prescriptionInfoEM.getAppointment().getDoctor().getFirstName());
			doctor.setLastName(prescriptionInfoEM.getAppointment().getDoctor().getLastName());
			doctor.setAge(prescriptionInfoEM.getAppointment().getDoctor().getAge());
			doctor.setMobile(prescriptionInfoEM.getAppointment().getDoctor().getMobile());
			doctor.setNic(prescriptionInfoEM.getAppointment().getDoctor().getNic());
			doctor.setEmail(prescriptionInfoEM.getAppointment().getDoctor().getEmail());
			doctor.setGender(prescriptionInfoEM.getAppointment().getDoctor().getGender());
			doctor.setUserType(prescriptionInfoEM.getAppointment().getDoctor().getUserType());
			doctor.setInfo(doctorInfo);

			patient.setId(prescriptionInfoEM.getAppointment().getPatient().getId());
			patient.setTitle(prescriptionInfoEM.getAppointment().getPatient().getTitle());
			patient.setFirstName(prescriptionInfoEM.getAppointment().getPatient().getFirstName());
			patient.setLastName(prescriptionInfoEM.getAppointment().getPatient().getLastName());
			patient.setAge(prescriptionInfoEM.getAppointment().getPatient().getAge());
			patient.setNic(prescriptionInfoEM.getAppointment().getPatient().getNic());
			patient.setParentNIC(prescriptionInfoEM.getAppointment().getPatient().getParentNIC());
			patient.setEmail(prescriptionInfoEM.getAppointment().getPatient().getEmail());
			patient.setMobile(prescriptionInfoEM.getAppointment().getPatient().getMobile());
			patient.setUserType(prescriptionInfoEM.getAppointment().getPatient().getUserType());
			patient.setGender(prescriptionInfoEM.getAppointment().getPatient().getGender());
			patient.setBloodGroup(prescriptionInfoEM.getAppointment().getPatient().getBloodGroup());
			patient.setDateOfBirth(prescriptionInfoEM.getAppointment().getPatient().getDateOfBirth());
			patient.setPassportNo(prescriptionInfoEM.getAppointment().getPatient().getPassportNo());

			institute.setId(prescriptionInfoEM.getInstitute().getId());
			institute.setName(prescriptionInfoEM.getInstitute().getName());
			institute.setPrescriptionHeader1(prescriptionInfoEM.getInstitute().getPrescriptionHeader1());
			institute.setPrescriptionHeader2(prescriptionInfoEM.getInstitute().getPrescriptionHeader2());
			institute.setPrescriptionMoto(prescriptionInfoEM.getInstitute().getPrescriptionMoto());
			institute.setPrescriptionAddress1(prescriptionInfoEM.getInstitute().getPrescriptionAddress1());
			institute.setPrescriptionAddress2(prescriptionInfoEM.getInstitute().getPrescriptionAddress2());
			institute.setPrescriptionPhone(prescriptionInfoEM.getInstitute().getPrescriptionPhone());
			institute.setPrescriptionEmail(prescriptionInfoEM.getInstitute().getPrescriptionEmail());
			institute.setPrescriptionURL(prescriptionInfoEM.getInstitute().getPrescriptionURL());
			institute.setImageURL(prescriptionInfoEM.getInstitute().getImageURL());
			institute.setType(prescriptionInfoEM.getInstitute().getType());
			institute.setLatitude(prescriptionInfoEM.getInstitute().getLatitude());
			institute.setLongitude(prescriptionInfoEM.getInstitute().getLongitude());
			institute.setReferenceId(prescriptionInfoEM.getInstitute().getReferenceId());
			institute.setLicenseStartDate(prescriptionInfoEM.getInstitute().getLicenseStartDate());
			institute.setLicenseEndDate(prescriptionInfoEM.getInstitute().getLicenseEndDate());

			for (PrescriptionDrugsEM prescriptionDrugsEM : prescriptionInfoEM.getPrescriptionDrugsEMs()) {

				PrescriptionDrugs drug = new PrescriptionDrugs();

				drug.setId(prescriptionDrugsEM.getDrugId());
				drug.setTradeName(prescriptionDrugsEM.getDrug().getTradeName());
				drug.setGenericName(prescriptionDrugsEM.getDrug().getGenericName());
				drug.setRawName(prescriptionDrugsEM.getDrug().getRawName());
				drug.setWeight(prescriptionDrugsEM.getWeight());
				drug.setDuration(prescriptionDrugsEM.getDuration());
				drug.setQty(prescriptionDrugsEM.getQuantity());
				drug.setCounter(prescriptionDrugsEM.getCounter());
				drug.setFrequency(prescriptionDrugsEM.getFrequency());
				drug.setCategory(prescriptionDrugsEM.getDrug().getCategoryName());
				drug.setInHouse(prescriptionDrugsEM.isInHouse());

				prescriptionDrugs.add(drug);
			}
			prescription.setId(prescriptionInfoEM.getId());
			prescription.setUuid(prescriptionInfoEM.getUuid());
			prescription.setAppointmentId(prescriptionInfoEM.getAppointmentId());
			prescription.setBloodPressure1(prescriptionInfoEM.getBloodPressure1());
			prescription.setBloodPressure2(prescriptionInfoEM.getBloodPressure2());
			prescription.setNextVisitDate(prescriptionInfoEM.getNextVisitDate());
			prescription.setPulseRate(prescriptionInfoEM.getPulseRate());
			prescription.setTests(prescriptionInfoEM.getTests());
			prescription.setTemperature(prescriptionInfoEM.getTemperature());
			prescription.setComments(prescriptionInfoEM.getComments());
			prescription.setDrugs(prescriptionDrugs);
			prescription.setDiagnosis(prescriptionInfoEM.getDiagnosis());
			prescription.setHeight(prescriptionInfoEM.getHeight());
			prescription.setWeight(prescriptionInfoEM.getWeight());
			prescription.setCreatedDate(prescriptionInfoEM.getCreatedDate());
			prescription.setPatient(patient);
			prescription.setDoctor(doctor);
			prescription.setInstitute(institute);

			prescriptions.add(prescription);

		}

		// prescriptionList.setPrescriptionsList(prescriptions);

		return prescriptions;

	}

	/**
	 * 
	 * maps the prescription resp list
	 * 
	 * 
	 * @param prescriptionInfoEMs
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public List<PrescriptionResp> mapPrescriptionRespList(HashMap<PrescriptionInfoEM, Boolean> map)
			throws JsonParseException, JsonMappingException, IOException {
		List<PrescriptionResp> prescriptionResps = new ArrayList<PrescriptionResp>();
		for (Entry<PrescriptionInfoEM, Boolean> entry : map.entrySet()) {
			PrescriptionInfoEM prescription = entry.getKey();
			Boolean status = entry.getValue();

			PrescriptionResp resp = new PrescriptionResp();
			Patient patient = new Patient();
			Doctor doctor = new Doctor();
			Institute institute = new Institute();
			// UserWM patient = new UserWM();
			// UserWM doctor = new UserWM();
			ObjectMapper objectMapper = new ObjectMapper();
			List<PrescriptionDrugs> prescriptionDrugs = new ArrayList<PrescriptionDrugs>();
			// Info patientInfo =
			// objectMapper.readValue(prescriptionInfoEM.getAppointment().getPatient().getInfo(),
			// Info.class);
			Info doctorInfo = objectMapper.readValue(prescription.getAppointment().getDoctor().getInfo(), Info.class);

			doctor.setId(prescription.getAppointment().getDoctor().getId());
			doctor.setTitle(prescription.getAppointment().getDoctor().getTitle());
			doctor.setFirstName(prescription.getAppointment().getDoctor().getFirstName());
			doctor.setLastName(prescription.getAppointment().getDoctor().getLastName());
			doctor.setAge(prescription.getAppointment().getDoctor().getAge());
			doctor.setMobile(prescription.getAppointment().getDoctor().getMobile());
			doctor.setNic(prescription.getAppointment().getDoctor().getNic());
			doctor.setEmail(prescription.getAppointment().getDoctor().getEmail());
			doctor.setGender(prescription.getAppointment().getDoctor().getGender());
			doctor.setUserType(prescription.getAppointment().getDoctor().getUserType());
			doctor.setInfo(doctorInfo);

			patient.setId(prescription.getAppointment().getPatient().getId());
			patient.setTitle(prescription.getAppointment().getPatient().getTitle());
			patient.setFirstName(prescription.getAppointment().getPatient().getFirstName());
			patient.setLastName(prescription.getAppointment().getPatient().getLastName());
			patient.setAge(prescription.getAppointment().getPatient().getAge());
			patient.setNic(prescription.getAppointment().getPatient().getNic());
			patient.setParentNIC(prescription.getAppointment().getPatient().getParentNIC());
			patient.setEmail(prescription.getAppointment().getPatient().getEmail());
			patient.setMobile(prescription.getAppointment().getPatient().getMobile());
			patient.setUserType(prescription.getAppointment().getPatient().getUserType());
			patient.setGender(prescription.getAppointment().getPatient().getGender());
			patient.setBloodGroup(prescription.getAppointment().getPatient().getBloodGroup());
			patient.setDateOfBirth(prescription.getAppointment().getPatient().getDateOfBirth());
			patient.setPassportNo(prescription.getAppointment().getPatient().getPassportNo());

			institute.setId(prescription.getInstitute().getId());
			institute.setName(prescription.getInstitute().getName());
			institute.setPrescriptionHeader1(prescription.getInstitute().getPrescriptionHeader1());
			institute.setPrescriptionHeader2(prescription.getInstitute().getPrescriptionHeader2());
			institute.setPrescriptionMoto(prescription.getInstitute().getPrescriptionMoto());
			institute.setPrescriptionAddress1(prescription.getInstitute().getPrescriptionAddress1());
			institute.setPrescriptionAddress2(prescription.getInstitute().getPrescriptionAddress2());
			institute.setPrescriptionPhone(prescription.getInstitute().getPrescriptionPhone());
			institute.setPrescriptionEmail(prescription.getInstitute().getPrescriptionEmail());
			institute.setPrescriptionURL(prescription.getInstitute().getPrescriptionURL());
			institute.setImageURL(prescription.getInstitute().getImageURL());
			institute.setType(prescription.getInstitute().getType());
			institute.setLatitude(prescription.getInstitute().getLatitude());
			institute.setLongitude(prescription.getInstitute().getLongitude());
			institute.setReferenceId(prescription.getInstitute().getReferenceId());
			institute.setLicenseStartDate(prescription.getInstitute().getLicenseStartDate());
			institute.setLicenseEndDate(prescription.getInstitute().getLicenseEndDate());

			for (PrescriptionDrugsEM prescriptionDrugsEM : prescription.getPrescriptionDrugsEMs()) {

				PrescriptionDrugs drug = new PrescriptionDrugs();

				drug.setId(prescriptionDrugsEM.getDrugId());
				drug.setTradeName(prescriptionDrugsEM.getDrug().getTradeName());
				drug.setGenericName(prescriptionDrugsEM.getDrug().getGenericName());
				drug.setRawName(prescriptionDrugsEM.getDrug().getRawName());
				drug.setWeight(prescriptionDrugsEM.getWeight());
				drug.setDuration(prescriptionDrugsEM.getDuration());
				drug.setQty(prescriptionDrugsEM.getQuantity());
				drug.setCounter(prescriptionDrugsEM.getCounter());
				drug.setFrequency(prescriptionDrugsEM.getFrequency());
				drug.setCategory(prescriptionDrugsEM.getDrug().getCategoryName());
				drug.setInHouse(prescriptionDrugsEM.isInHouse());

				prescriptionDrugs.add(drug);
			}
			resp.setId(prescription.getId());
			resp.setUuid(prescription.getUuid());
			resp.setAppointmentId(prescription.getAppointmentId());
			resp.setBloodPressure1(prescription.getBloodPressure1());
			resp.setBloodPressure2(prescription.getBloodPressure2());
			resp.setNextVisitDate(prescription.getNextVisitDate());
			resp.setPulseRate(prescription.getPulseRate());
			resp.setTests(prescription.getTests());
			resp.setTemperature(prescription.getTemperature());
			resp.setComments(prescription.getComments());
			resp.setDrugs(prescriptionDrugs);
			resp.setDiagnosis(prescription.getDiagnosis());
			resp.setHeight(prescription.getHeight());
			resp.setWeight(prescription.getWeight());
			resp.setCreatedDate(prescription.getCreatedDate());
			resp.setHasInvoiced(status);
			resp.setPatient(patient);
			resp.setDoctor(doctor);
			resp.setInstitute(institute);

			prescriptionResps.add(resp);

		}

		return prescriptionResps;
	}

	/**
	 * 
	 * maps the medical stats to send to the client
	 * 
	 * @param {"id":1,"patientId":1,"allergies":"Amoxiline","pastDiseases":"Heart
	 *        Disese","pastSurgeries":"Heart","gynoObstetrics":"NONE","investigations":"NONE"}
	 * @return {"id":1,"patientId":1,"allergies":"Amoxiline","pastDiseases":"Heart
	 *         Disese","pastSurgeries":"Heart","gynoObstetrics":"NONE","investigations":"NONE"}
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 */
	public MedicalStatWM mapMedicalStat(MedicalStat medicalStat)
			throws JsonParseException, JsonMappingException, IOException {

		MedicalStatWM medicalStatWM = new MedicalStatWM();
		ObjectMapper objectMapper = new ObjectMapper();
		TypeFactory typeFactory = objectMapper.getTypeFactory();
		CollectionType collectionType = typeFactory.constructCollectionType(List.class, PastDiseases.class);
		List<PastDiseases> diseases = objectMapper.readValue(medicalStat.getPastDiseases(), collectionType);

		medicalStatWM.setId(medicalStat.getId());
		medicalStatWM.setPatientId(medicalStat.getPatientId());
		medicalStatWM.setDrugAllergies(medicalStat.getDrugAllergies());
		medicalStatWM.setFoodAllergies(medicalStat.getFoodAllergies());
		medicalStatWM.setPastDiseases(diseases);
		medicalStatWM.setInvestigations(medicalStat.getInvestigations());
		medicalStatWM.setPastSurgeries(medicalStat.getPastSurgeries());
		medicalStatWM.setGynoObstetrics(medicalStat.getGynoObstetrics());

		return medicalStatWM;

	}

	public List<MedicalTestsWM> mapMedicalTests(List<MedicalTests> medicalTests)
			throws JsonParseException, JsonMappingException, IOException {

		List<MedicalTestsWM> medicalTestsWMArray = new ArrayList<MedicalTestsWM>();

		for (MedicalTests mtest : medicalTests) {
			MedicalTestsWM medicalTestsWM = new MedicalTestsWM();

			medicalTestsWM.setId(mtest.getId());
			medicalTestsWM.setName(mtest.getName());
			medicalTestsWM.setCategory(mtest.getCategory());
			medicalTestsWM.setLastUpdatedTime(mtest.getLastUpdatedTime());
			medicalTestsWM.setStatus(mtest.getStatus());
			medicalTestsWMArray.add(medicalTestsWM);
		}

		return medicalTestsWMArray;
	}

	public List<UserWM> mapPatient(List<UserInfo> userInfo)
			throws JsonParseException, JsonMappingException, IOException {

		List<UserWM> userWMList = new ArrayList<UserWM>();

		for (UserInfo userInfoEM : userInfo) {
			UserWM userWM = new UserWM();

			userWM.setId(userInfoEM.getId());
			userWM.setTitle(userInfoEM.getTitle());
			userWM.setFirstName(userInfoEM.getFirstName());
			userWM.setLastName(userInfoEM.getLastName());
			userWM.setNic(userInfoEM.getNic());
			userWM.setParentNIC(userInfoEM.getParentNIC());
			userWM.setMobile(userInfoEM.getMobile());
			userWM.setEmail(userInfoEM.getEmail());
			userWM.setAddress(userInfoEM.getAddress());
			userWM.setAge(userInfoEM.getAge());
			userWM.setGender(userInfoEM.getGender());
			userWM.setUserType(userInfoEM.getUserType());
			userWM.setBloodGroup(userInfoEM.getBloodGroup());
			userWM.setDateOfBirth(userInfoEM.getDateOfBirth());
			userWM.setPassportNo(userInfoEM.getPassportNo());
			userWMList.add(userWM);
		}
		return userWMList;
	}
	
	public UserWM mapUser(UserInfo userInfo)
			throws JsonParseException, JsonMappingException, IOException {
		
			UserWM userWM = new UserWM();
			if(userInfo!=null) {
				userWM.setId(userInfo.getId());
				userWM.setTitle(userInfo.getTitle());
				userWM.setFirstName(userInfo.getFirstName());
				userWM.setLastName(userInfo.getLastName());
				userWM.setNic(userInfo.getNic());
				userWM.setParentNIC(userInfo.getParentNIC());
				userWM.setMobile(userInfo.getMobile());
				userWM.setEmail(userInfo.getEmail());
				userWM.setAddress(userInfo.getAddress());
				userWM.setAge(userInfo.getAge());
				userWM.setGender(userInfo.getGender());
				userWM.setUserType(userInfo.getUserType());
				userWM.setBloodGroup(userInfo.getBloodGroup());
				userWM.setDateOfBirth(userInfo.getDateOfBirth());
				userWM.setPassportNo(userInfo.getPassportNo());
			}
			
			return userWM;
	}

	public MedicalStat mapmedicalStatToSave(MedicalStatWM medicalStatWM) throws JsonProcessingException {
		Date now = new Date();
		DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = df2.format(now);

		MedicalStat medicalStat = new MedicalStat();
		ObjectMapper objectMapper = new ObjectMapper();

		// objectMapper.readValue(medicalStatWM., Info.class);

		List<PastDiseases> diseases = new ArrayList<PastDiseases>();

		// medicalStat.setId(medicalStatWM.getId());
		medicalStat.setId(medicalStatWM.getId());
		medicalStat.setPatientId(medicalStatWM.getPatientId());
		medicalStat.setDrugAllergies(medicalStatWM.getDrugAllergies());
		medicalStat.setFoodAllergies(medicalStatWM.getFoodAllergies());
		medicalStat.setPastDiseases(objectMapper.writeValueAsString(medicalStatWM.getPastDiseases()));
		medicalStat.setInvestigations(medicalStatWM.getInvestigations());
		medicalStat.setPastSurgeries(medicalStatWM.getPastSurgeries());
		medicalStat.setGynoObstetrics(medicalStatWM.getGynoObstetrics());
		medicalStat.setCreatedDate(now);

		return medicalStat;

	}

	public UserInfo mapPatientSave(Patient patient) throws JsonProcessingException {
		Date now = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = df.format(now);

		UserInfo userInfo = new UserInfo();
		userInfo.setId(patient.getId());
		userInfo.setFirstName(patient.getFirstName());
		userInfo.setLastName(patient.getLastName());
		userInfo.setAge(patient.getAge());
		userInfo.setMobile(patient.getMobile());
		userInfo.setNic(patient.getNic());
		userInfo.setEmail(patient.getEmail());
		userInfo.setGender(patient.getGender());
		userInfo.setAddress(patient.getAddress());
		userInfo.setTitle(patient.getTitle());
		userInfo.setParentNIC(patient.getParentNIC());
		userInfo.setUserType(patient.getUserType());
		userInfo.setUserRole(patient.getUserRole());
		userInfo.setCreatedDate(time);
		userInfo.setCreatedBy(patient.getCreatedBy());
		userInfo.setBloodGroup(patient.getBloodGroup());
		userInfo.setDateOfBirth(patient.getDateOfBirth());
		userInfo.setPassportNo(patient.getPassportNo());

		return userInfo;
	}

	public UserInfo mapBloodGroupReq(BloodGroupReq bloodGroupReq) throws Exception {
		UserInfo userInfo = new UserInfo();
		userInfo.setId(bloodGroupReq.getId());
		userInfo.setBloodGroup(bloodGroupReq.getBloodGroup());
		return userInfo;
	}

	public RegistrationResponseEM mapUserRegister(RegistrationReq registrationReq) {
		RegistrationResponseEM registrationResponse = new RegistrationResponseEM();
		registrationResponse.setMobile(registrationReq.getMobile());
		registrationResponse.setNic(registrationReq.getNic());
		registrationResponse.setName(registrationReq.getName());
		registrationResponse.setEmail(registrationReq.getEmail());
		registrationResponse.setImei(registrationReq.getImei());
		registrationResponse.setTimestamp(registrationReq.getTimestamp());
		registrationResponse.setReferenceId(registrationReq.getReferenceId());

		return registrationResponse;
	}

	public RegistrationResponseEM mapGetOtp(SubmitOtpReq submitOtpReq) {
		RegistrationResponseEM registrationResponse = new RegistrationResponseEM();
		registrationResponse.setReferenceId(submitOtpReq.getReferenceId());
		registrationResponse.setOtp(submitOtpReq.getOtp());
		registrationResponse.setImei(submitOtpReq.getImei());
		registrationResponse.setTimestamp(submitOtpReq.getTimestamp());

		return registrationResponse;
	}

	public UserProfileEM mapUserProfile(UserProfileWM userProfileWM) {
		UserProfileEM userProfileEM = new UserProfileEM();
		userProfileEM.setEmail(userProfileWM.getEmail());
		userProfileEM.setFirstName(userProfileWM.getFirstName());
		userProfileEM.setGender(userProfileWM.getGender());
		userProfileEM.setImei(userProfileWM.getImei());
		userProfileEM.setLastName(userProfileWM.getLastName());
		userProfileEM.setNic(userProfileWM.getNic());
		userProfileEM.setReferenceId(userProfileWM.getReferenceId());
		userProfileEM.setTimestamp(userProfileWM.getTimestamp());
		userProfileEM.setTitle(userProfileWM.getTitle());
		userProfileEM.setMobile(userProfileWM.getMobile());

		return userProfileEM;
	}

	public Drug mapSavingDrug(DrugWM drugWm) throws Exception {
		Date now = new Date();
		DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = df2.format(now);

		Drug drug = new Drug();
		drug.setId(drugWm.getId());
		drug.setDoctorId(drugWm.getDoctorId());
		drug.setTradeName(drugWm.getTradeName());
		drug.setGenericName(drugWm.getGenericName());
		drug.setRawName(drugWm.getRawName());

		String weightArr[] = drugWm.getWeight();
		StringBuilder weight = new StringBuilder();
		for (int i = 0; i < weightArr.length; i++) {
			if (weightArr.length == i + 1) {
				weight.append(weightArr[i]);
			} else {
				weight.append(weightArr[i] + ",");
			}

		}
		drug.setWeight(weight.toString());
		drug.setDefaultWeight(drugWm.getDefaultWeight());
		drug.setDefaultFrequency(drugWm.getDefaultFrequency());
		drug.setCategoryName(drugWm.getCategory());
		drug.setLastUpdatedTime(new Date().getTime());
		drug.setStatus("ADD");
		drug.setCreatedDate(time);
		drug.setCreatedBy("ADMIN");
		drug.setIsDeleted(0);
		drug.setHasVerified(drugWm.isHasVerified());
		drug.setEnable(drugWm.getEnable());

		return drug;

	}

	public List<SessionWM> mapSession(List<SessionEM> sessionEMList) throws Exception {

		List<SessionWM> sessionWMs = new ArrayList<SessionWM>();
		for (SessionEM sem : sessionEMList) {
			SessionWM wm = new SessionWM();
			wm.setId(sem.getId());
			wm.setRoomNo(sem.getRoomNo());
			wm.setDate(sem.getSessionDate());
			wm.setStartTime(sem.getSessionStartTime());
			wm.setEndTime(sem.getSessionEndTime());
			wm.setIsDeleted(sem.getIsDeleted());
			sessionWMs.add(wm);

		}
		return sessionWMs;
	}

	/*
	 * public List<SessionResp> mapSessionListByDateRange(List<SessionEM>
	 * sessionEMList) throws Exception { List<SessionResp> sessionResps = new
	 * ArrayList<SessionResp>(); for(SessionEM sem : sessionEMList){ SessionResp wm
	 * = new SessionResp(); wm.setId(sem.getId()); wm.setRoomNo(sem.getRoomNo());
	 * wm.setInstituteId(sem.getInstituteId());
	 * wm.setStartTime(sem.getSessionStartTime());
	 * wm.setEndTime(sem.getSessionEndTime()); wm.setIsDeleted(sem.getIsDeleted());
	 * sessionResps.add(wm);
	 * 
	 * } return sessionResps; }
	 */
	public List<SessionResp> mapSessionResp(List<SessionEM> sessionEMList) throws Exception {

		List<SessionResp> sessionResps = new ArrayList<SessionResp>();
		for (SessionEM sem : sessionEMList) {
			SessionResp wm = new SessionResp();
			wm.setId(sem.getId());
			wm.setRoomNo(sem.getRoomNo());
			wm.setDate(sem.getSessionDate());
			wm.setInstituteId(sem.getInstituteId());
			wm.setStartTime(sem.getSessionStartTime());
			wm.setEndTime(sem.getSessionEndTime());
			wm.setIsDeleted(sem.getIsDeleted());
			sessionResps.add(wm);

		}
		return sessionResps;
	}

	/**
	 * @param sessionReq maps SessionEM models to SessionResp to get session list
	 * @return
	 * @throws JsonProcessingException
	 * @throws Exception
	 * @throws JsonProcessingException
	 */
	public SessionEM mapSessionSave(SessionReq sessionReq) throws JsonProcessingException, Exception {
		SessionEM sessionEM = new SessionEM();
		UserInfo doctor = new UserInfo();
		doctor.setId(sessionReq.getDoctorId());
		sessionEM.setId(sessionReq.getId());
		sessionEM.setRoomNo(sessionReq.getRoomNo());
		sessionEM.setSessionDate(sessionReq.getDate());
		sessionEM.setSessionStartTime(sessionReq.getStartTime());
		sessionEM.setSessionEndTime(sessionReq.getEndTime());
		sessionEM.setInstituteId(sessionReq.getInstituteId());
		sessionEM.setDoctor(doctor);

		return sessionEM;
	}

	public SessionSummaryWM mapSummary(SessionSummary sessionSummary) throws Exception {
		SessionSummaryWM sessionSummaryWM = new SessionSummaryWM();
		sessionSummaryWM.setTotalNoOfAppointments(sessionSummary.getTotalNoOfAppointments());
		sessionSummaryWM.setNoOfPatientsWithPrescriptions(sessionSummary.getNoOfPatientsWithPrescriptions());
		sessionSummaryWM.setTotalPrescriptions(sessionSummary.getTotalPrescriptions());

		return sessionSummaryWM;
	}

	public Stats mapSaveStats(StatsWM statsWM) throws JsonParseException, JsonMappingException, Exception {
		Date now = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = df.format(now);

		Stats stats = new Stats();
		stats.setAppointmentId(statsWM.getAppointmentId());
		stats.setPatientId(statsWM.getPatientId());
		stats.setCreatedDateTime(statsWM.getCreatedDateTime());

		String mapAsJson = new ObjectMapper().writeValueAsString(statsWM.getStats());
		stats.setStats(mapAsJson);

		return stats;
	}

	public List<StatsWM> mapStatsList(List<Stats> stats) throws JsonParseException, JsonMappingException, Exception {
		List<StatsWM> statsWMs = new ArrayList<>();
		for (Stats stat : stats) {
			StatsWM wm = new StatsWM();
			wm.setId(stat.getId());
			wm.setAppointmentId(stat.getAppointmentId());
			wm.setPatientId(stat.getPatientId());
			wm.setCreatedDateTime(stat.getCreatedDateTime());

			ObjectMapper objectMapper = new ObjectMapper();
			Map<String, Object> map = new HashMap<String, Object>();

			// convert JSON string to Map
			if (stat.getStats() != null)
				map = objectMapper.readValue(stat.getStats(), new TypeReference<Map<String, String>>() {
				});
			wm.setStats(map);

			statsWMs.add(wm);
		}

		return statsWMs;
	}

	public StatsWM mapStats(Stats stats) throws JsonParseException, JsonMappingException, Exception {
		StatsWM statsWM = new StatsWM();
		statsWM.setId(stats.getId());
		statsWM.setAppointmentId(stats.getAppointmentId());
		statsWM.setPatientId(stats.getPatientId());
		statsWM.setCreatedDateTime(stats.getCreatedDateTime());

		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> map = new HashMap<String, Object>();

		// convert JSON string to Map
		if (stats.getStats() != null)
			map = objectMapper.readValue(stats.getStats(), new TypeReference<Map<String, String>>() {
			});
		statsWM.setStats(map);

		return statsWM;
	}

	public Stats mapStatReq(AppointmentStats appointmentStats) throws JsonProcessingException, Exception {
		Date now = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = df.format(now);

		Stats stats = new Stats();
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> map = new HashMap<>();
		map.put("weight", appointmentStats.getWeight());
		map.put("temperature", appointmentStats.getTemperature());
		map.put("pulse", appointmentStats.getPulse());
		map.put("height", appointmentStats.getHeight());
		map.put("bloodPressure1", appointmentStats.getBloodPressure1());
		map.put("bloodPressure2", appointmentStats.getBloodPressure2());

		String mapAsJson = new ObjectMapper().writeValueAsString(map);
		stats.setStats(mapAsJson);
		stats.setCreatedDateTime(time);

		return stats;
	}

	/**
	 * @param medicalCertificateWM maps the saved medical certificate to send
	 * @return
	 * @throws JsonProcessingException
	 * @throws Exception
	 */
	public MedicalCertificate mapMedicalCertificate(MedicalCertificateWM medicalCertificateWM)
			throws JsonProcessingException, Exception {
		Date now = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = df.format(now);
		MedicalCertificate certificate = new MedicalCertificate();
		certificate.setId(medicalCertificateWM.getId());
		certificate.setDoctorId(medicalCertificateWM.getDoctorId());
		certificate.setPatientId(medicalCertificateWM.getPatientId());
		certificate.setInstituteId(medicalCertificateWM.getInstituteId());
		certificate.setResidentialAddress(medicalCertificateWM.getResidentialAddress());
		certificate.setWhereEmployed(medicalCertificateWM.getWhereEmployed());
		certificate.setNatureOfDiseases(medicalCertificateWM.getNatureOfDiseases());
		certificate.setRecommendedDays(medicalCertificateWM.getRecommendedDays());
		certificate.setLeaveWithEffectFrom(medicalCertificateWM.getLeaveWithEffectFrom());
		certificate.setCreatedDateTime(time);
		certificate.setCreatedBy("DOCTOR" + medicalCertificateWM.getDoctorId());

		return certificate;
	}
	
	public MedicalCertificateWM mapMedicalCertificate(MedicalCertificate certificate)
			throws JsonProcessingException, Exception {
		Date now = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = df.format(now);
		MedicalCertificateWM medicalCertificateWM = new MedicalCertificateWM();
		medicalCertificateWM.setId(certificate.getId());
		medicalCertificateWM.setDoctorId(certificate.getDoctorId());
		medicalCertificateWM.setPatientId(certificate.getPatientId());
		medicalCertificateWM.setInstituteId(certificate.getInstituteId());
		medicalCertificateWM.setResidentialAddress(certificate.getResidentialAddress());
		medicalCertificateWM.setWhereEmployed(certificate.getWhereEmployed());
		medicalCertificateWM.setNatureOfDiseases(certificate.getNatureOfDiseases());
		medicalCertificateWM.setRecommendedDays(certificate.getRecommendedDays());
		medicalCertificateWM.setLeaveWithEffectFrom(certificate.getLeaveWithEffectFrom());
		//medicalCertificateWM.setCreatedDateTime(time);
		//medicalCertificateWM.setCreatedBy("DOCTOR" + medicalCertificateWM.getDoctorId());

		return medicalCertificateWM;
	}

	/**
	 * @param templateWM maps the saved prescription template to send
	 * @return
	 * @throws JsonProcessingException
	 * @throws Exception
	 */
	public TemplateEM mapSaveTemplate(TemplateWM templateWM) throws JsonProcessingException, Exception {
		Date now = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = df.format(now);

		TemplateEM templateEM = new TemplateEM();
		Template template = new Template();
		UserInfo doctor = new UserInfo();
		doctor.setId(templateWM.getDoctorId());

		template.setId(templateWM.getId());
		template.setName(templateWM.getName());
		template.setDoctorId(templateWM.getDoctorId());
		template.setDoctor(doctor);
		template.setInvestigations(templateWM.getInvestigations());
		template.setDescription(templateWM.getDescription());
		template.setCreatedDateTime(time);
		template.setCreatedBy("DOCTOR" + templateWM.getDoctorId());

		List<TemplateDrug> templateDrugs = new ArrayList<TemplateDrug>();

		for (TemplateDrugWM wm : templateWM.getDrugs()) {
			TemplateDrug templateDrug = new TemplateDrug();
			templateDrug.setDrugId(wm.getId());
			templateDrug.setWeight(wm.getWeight());
			templateDrug.setFrequency(wm.getFrequency());
			templateDrug.setDuration(wm.getDuration());
			templateDrug.setQuantity(wm.getQty());
			templateDrug.setCounter(wm.getCounter());
			Drug drug = new Drug();
			drug.setId(wm.getId());
			templateDrug.setTemplate(template);
			templateDrugs.add(templateDrug);
		}
		templateEM.setTemplate(template);
		templateEM.setTemplateDrugs(templateDrugs);

		return templateEM;
	}

	/**
	 * @param templates maps the get prescription template list to send
	 * @return
	 * @throws JsonProcessingException
	 * @throws Exception
	 */
	public List<TemplateWM> mapTemplateList(List<Template> templates) throws JsonProcessingException, Exception {
		Date now = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = df.format(now);
		List<TemplateWM> templateWMs = new ArrayList<TemplateWM>();
		for (Template template : templates) {
			TemplateWM templateWM = new TemplateWM();
			templateWM.setId(template.getId());
			templateWM.setName(template.getName());
			templateWM.setInvestigations(template.getInvestigations());
			templateWM.setDescription(template.getDescription());

			UserInfo doctor = new UserInfo();
			doctor.setId(template.getDoctorId());
			templateWM.setDoctorId(template.getDoctorId());

			List<TemplateDrugWM> templateDrugWMs = new ArrayList<TemplateDrugWM>();
			for (TemplateDrug templateDrug : template.getTemplateDrugs()) {
				TemplateDrugWM templateDrugWM = new TemplateDrugWM();
				templateDrugWM.setId(templateDrug.getDrugId());
				templateDrugWM.setWeight(templateDrug.getWeight());
				templateDrugWM.setFrequency(templateDrug.getFrequency());
				templateDrugWM.setCounter(templateDrug.getCounter());
				templateDrugWM.setDuration(templateDrug.getDuration());
				templateDrugWM.setQty(templateDrug.getQuantity());
				templateDrugWMs.add(templateDrugWM);
			}
			templateWM.setDrugs(templateDrugWMs);
			templateWMs.add(templateWM);
		}

		return templateWMs;
	}

	/**
	 * @param favouriteDrugWM maps the add drug to Dr's favourite list
	 * @return
	 * @throws JsonProcessingException
	 * @throws Exception
	 */
	public FavouriteDrugEM mapAddDrugToFav(FavouriteDrugWM favouriteDrugWM) throws JsonProcessingException, Exception {
		Date now = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = df.format(now);

		FavouriteDrugEM favouriteDrugEM = new FavouriteDrugEM();
		favouriteDrugEM.setId(favouriteDrugWM.getId());
		favouriteDrugEM.setDoctorId(favouriteDrugWM.getDoctorId());
		favouriteDrugEM.setDrugId(favouriteDrugWM.getDrugId());
		favouriteDrugEM.setCreatedDateTime(time);
		favouriteDrugEM.setCreatedBy("DOCTOR" + favouriteDrugWM.getDoctorId());

		return favouriteDrugEM;
	}

	/**
	 * Get institute by id
	 * 
	 * @param institute maps the institute models
	 * @return
	 * @throws JsonProcessingException
	 * @throws Exception
	 */
	public InstituteWM mapInstitute(Institute institute) throws JsonProcessingException, Exception {
		InstituteWM instituteWM = new InstituteWM();
		instituteWM.setId(institute.getId());
		instituteWM.setName(institute.getName());
		instituteWM.setPrescriptionHeader1(institute.getPrescriptionHeader1());
		instituteWM.setPrescriptionHeader2(institute.getPrescriptionHeader2());
		instituteWM.setPrescriptionMoto(institute.getPrescriptionMoto());
		instituteWM.setPrescriptionAddress1(institute.getPrescriptionAddress1());
		instituteWM.setPrescriptionAddress2(institute.getPrescriptionAddress2());
		instituteWM.setCity(institute.getCity());
		instituteWM.setPrescriptionPhone(institute.getPrescriptionPhone());
		instituteWM.setPrescriptionEmail(institute.getPrescriptionEmail());
		instituteWM.setPrescriptionURL(institute.getPrescriptionURL());
		instituteWM.setImageURL(institute.getImageURL());
		instituteWM.setType(institute.getType());
		instituteWM.setLatitude(institute.getLatitude());
		instituteWM.setLongitude(institute.getLongitude());
		instituteWM.setReferenceId(institute.getReferenceId());
		instituteWM.setLicenseStartDate(institute.getLicenseStartDate());
		instituteWM.setLicenseEndDate(institute.getLicenseEndDate());

		return instituteWM;
	}

	/**
	 * Save institute
	 * 
	 * @param instituteWM maps the institute models to save an institute
	 * @return
	 * @throws JsonProcessingException
	 * @throws Exception
	 */
	public Institute mapSaveInstitute(InstituteWM instituteWM) throws JsonProcessingException, Exception {
		Date now = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = df.format(now);

		Institute institute = new Institute();
		institute.setId(instituteWM.getId());
		institute.setName(instituteWM.getName());
		institute.setPrescriptionHeader1(instituteWM.getPrescriptionHeader1());
		institute.setPrescriptionHeader2(instituteWM.getPrescriptionHeader2());
		institute.setPrescriptionMoto(instituteWM.getPrescriptionMoto());
		institute.setPrescriptionAddress1(instituteWM.getPrescriptionAddress1());
		institute.setPrescriptionAddress2(instituteWM.getPrescriptionAddress2());
		institute.setCity(instituteWM.getCity());
		institute.setPrescriptionPhone(instituteWM.getPrescriptionPhone());
		institute.setPrescriptionURL(instituteWM.getPrescriptionURL());
		institute.setImageURL(instituteWM.getImageURL());
		institute.setType(instituteWM.getType());
		institute.setLatitude(instituteWM.getLatitude());
		institute.setLongitude(instituteWM.getLongitude());
		institute.setReferenceId(instituteWM.getReferenceId());
		institute.setLicenseStartDate(instituteWM.getLicenseStartDate());
		institute.setLicenseEndDate(instituteWM.getLicenseEndDate());
		institute.setCreatedDateTime(time);
		institute.setCreatedBy("ADMIN");

		return institute;
	}

	/**
	 * Get institute list by type
	 * 
	 * @param institutes maps the List<Institute> models
	 * @return
	 * @throws JsonProcessingException
	 * @throws Exception
	 */
	public List<InstituteWM> mapInstitutes(List<Institute> institutes) throws JsonProcessingException, Exception {
		List<InstituteWM> instituteWMs = new ArrayList<InstituteWM>();

		for (Institute institute : institutes) {
			InstituteWM instituteWM = new InstituteWM();
			instituteWM.setId(institute.getId());
			instituteWM.setName(institute.getName());
			instituteWM.setPrescriptionHeader1(institute.getPrescriptionHeader1());
			instituteWM.setPrescriptionHeader2(institute.getPrescriptionHeader2());
			instituteWM.setPrescriptionMoto(institute.getPrescriptionMoto());
			instituteWM.setPrescriptionAddress1(institute.getPrescriptionAddress1());
			instituteWM.setPrescriptionAddress2(institute.getPrescriptionAddress2());
			instituteWM.setCity(institute.getCity());
			instituteWM.setPrescriptionPhone(institute.getPrescriptionPhone());
			instituteWM.setPrescriptionEmail(institute.getPrescriptionEmail());
			instituteWM.setPrescriptionURL(institute.getPrescriptionURL());
			instituteWM.setImageURL(institute.getImageURL());
			instituteWM.setType(institute.getType());
			instituteWM.setLatitude(institute.getLatitude());
			instituteWM.setLongitude(institute.getLongitude());
			instituteWM.setReferenceId(institute.getReferenceId());
			instituteWM.setLicenseStartDate(institute.getLicenseStartDate());
			instituteWM.setLicenseEndDate(institute.getLicenseEndDate());

			instituteWMs.add(instituteWM);
		}

		return instituteWMs;
	}

	/**
	 * @param doctor maps the doctor models
	 * @return
	 * @throws JsonProcessingException
	 * @throws Exception
	 */
	public UserInfo mapSaveDoctor(Doctor doctor) throws JsonProcessingException, Exception {
		Date now = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = df.format(now);

		UserInfo doctorInfo = new UserInfo();
		doctorInfo.setId(doctor.getId());
		doctorInfo.setTitle(doctor.getTitle());
		doctorInfo.setFirstName(doctor.getFirstName());
		doctorInfo.setLastName(doctor.getLastName());
		doctorInfo.setAge(doctor.getAge());
		doctorInfo.setMobile(doctor.getMobile());
		doctorInfo.setNic(doctor.getNic());
		doctorInfo.setEmail(doctor.getEmail());
		doctorInfo.setGender(doctor.getGender());
		doctorInfo.setUserType(doctor.getUserType());
		doctorInfo.setCreatedDate(time);
		doctorInfo.setModifiedBy("ADMIN");
		doctorInfo.setDateOfBirth("1900-01-01 00:00:00");

		Info info = new Info();
		info.setRegNo(doctor.getInfo().getRegNo());
		info.setHospitals(doctor.getInfo().getHospitals());
		info.setField(doctor.getInfo().getField());
		info.setQualifications(doctor.getInfo().getQualifications());

		ObjectMapper objectMapper = new ObjectMapper();
		String infoJson = objectMapper.writeValueAsString(info);
		doctorInfo.setInfo(infoJson);

		return doctorInfo;
	}

	/**
	 * @param investigation maps the investigation models to save investigation
	 * @return
	 * @throws JsonProcessingException
	 * @throws Exception
	 */
	public Investigation mapSaveInvestigation(InvestigationWM investigationWM)
			throws JsonProcessingException, Exception {
		Date now = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = df.format(now);

		Investigation investigation = new Investigation();
		investigation.setId(investigationWM.getId());
		investigation.setTestId(investigationWM.getTestId());
		investigation.setDoctorId(investigationWM.getDoctorId());
		investigation.setTest(investigationWM.getTest());
		investigation.setCreatedBy("DOCTOR" + investigationWM.getDoctorId());
		investigation.setCreatedDate(time);
		// TO DO fill the rest

		return investigation;

	}

	/**
	 * @param doctorProfileWM maps the doctor Profile models to save doctor Profile
	 * @return
	 * @throws JsonProcessingException
	 * @throws Exception
	 */
	public DoctorProfile mapSaveDoctorExtended(DoctorProfileWM doctorProfileWM)
			throws JsonProcessingException, Exception {
		DoctorProfile doctorProfile = new DoctorProfile();
		Date now = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = df.format(now);

		UserInfo doctor = new UserInfo();
		doctor.setId(doctorProfileWM.getDoctorId());
		doctorProfile.setId(doctorProfileWM.getId());
		doctorProfile.setDoctorId(doctorProfileWM.getDoctorId());
		doctorProfile.setTitle(doctorProfileWM.getTitle());
		doctorProfile.setOthers(doctorProfileWM.getOthers());
		doctorProfile.setFirstName(doctorProfileWM.getFirstName());
		doctorProfile.setLastName(doctorProfileWM.getLastName());
		doctorProfile.setAge(doctorProfileWM.getAge());
		doctorProfile.setNic(doctorProfileWM.getNic());
		doctorProfile.setGender(doctorProfileWM.getGender());
		doctorProfile.setPrintName(doctorProfileWM.getPrintName());
		doctorProfile.setHomeAddressNo(doctorProfileWM.getHomeAddressNo());
		doctorProfile.setStreetName1(doctorProfileWM.getStreetName1());
		doctorProfile.setStreetName2(doctorProfileWM.getStreetName2());
		doctorProfile.setTown(doctorProfileWM.getTown());
		doctorProfile.setDistrict(doctorProfileWM.getDistrict());
		doctorProfile.setFacebookUrl(doctorProfileWM.getFacebookUrl());
		doctorProfile.setLinkedInUrl(doctorProfileWM.getLinkedInUrl());
		doctorProfile.setHomeLandTelNo(doctorProfileWM.getHomeLandTelNo());
		doctorProfile.setMobile(doctorProfileWM.getMobile());
		doctorProfile.setMobileNo1(doctorProfileWM.getMobileNo1());
		doctorProfile.setMobileNo2(doctorProfileWM.getMobileNo2());
		doctorProfile.setEmail(doctorProfileWM.getEmail());
		doctorProfile.setEmail1(doctorProfileWM.getEmail1());
		doctorProfile.setEmail2(doctorProfileWM.getEmail2());
		doctorProfile.setVisitingHospitals(Arrays.toString(doctorProfileWM.getVisitingHospitals()));
		doctorProfile.setOtherHospital(doctorProfileWM.getOtherHospitals());
		doctorProfile.setImagePath(doctorProfileWM.getImagePath());
		doctorProfile.setUserType(doctorProfileWM.getUserType());

		ObjectMapper objectMapper = new ObjectMapper();
		String infoString = objectMapper.writeValueAsString(doctorProfileWM.getInfo());

		doctorProfile.setInfo(infoString);
		doctorProfile.setCreatedBy("DOCTOR");
		doctorProfile.setCreatedDate(time);
		doctorProfile.setModifiedBy("");

		return doctorProfile;
	}

	/**
	 * @param doctorProfile maps the doctor Profile models to get doctor Profile
	 * @return
	 * @throws JsonProcessingException
	 * @throws Exception
	 */
	public DoctorProfileWM mapGetDoctorExtended(DoctorProfile doctorProfile) throws JsonProcessingException, Exception {
		DoctorProfileWM doctorProfileWM = new DoctorProfileWM();
		doctorProfileWM.setId(doctorProfile.getId());
		doctorProfileWM.setTitle(doctorProfile.getTitle());
		doctorProfileWM.setOthers(doctorProfile.getOthers());
		doctorProfileWM.setFirstName(doctorProfile.getFirstName());
		doctorProfileWM.setLastName(doctorProfile.getLastName());
		doctorProfileWM.setAge(doctorProfile.getAge());
		doctorProfileWM.setNic(doctorProfile.getNic());
		doctorProfileWM.setGender(doctorProfile.getGender());
		doctorProfileWM.setPrintName(doctorProfile.getPrintName());
		doctorProfileWM.setHomeAddressNo(doctorProfile.getHomeAddressNo());
		doctorProfileWM.setStreetName1(doctorProfile.getStreetName1());
		doctorProfileWM.setStreetName2(doctorProfile.getStreetName2());
		doctorProfileWM.setTown(doctorProfile.getTown());
		doctorProfileWM.setDistrict(doctorProfile.getDistrict());
		doctorProfileWM.setFacebookUrl(doctorProfile.getFacebookUrl());
		doctorProfileWM.setLinkedInUrl(doctorProfile.getLinkedInUrl());
		doctorProfileWM.setHomeLandTelNo(doctorProfile.getHomeLandTelNo());
		doctorProfileWM.setMobile(doctorProfile.getMobile());
		doctorProfileWM.setMobileNo1(doctorProfile.getMobileNo1());
		doctorProfileWM.setMobileNo2(doctorProfile.getMobileNo2());
		doctorProfileWM.setEmail1(doctorProfile.getEmail1());
		doctorProfileWM.setEmail2(doctorProfile.getEmail2());
		doctorProfileWM.setVisitingHospitals(doctorProfile.getVisitingHospitals().split(","));
		doctorProfileWM.setOtherHospitals(doctorProfile.getOtherHospital());
		doctorProfileWM.setImagePath(doctorProfile.getImagePath());
		doctorProfileWM.setUserType(doctorProfile.getUserType());

		ObjectMapper objectMapper = new ObjectMapper();
		Info info = objectMapper.readValue(doctorProfile.getInfo(), Info.class);
		doctorProfileWM.setInfo(info);

		return doctorProfileWM;
	}

	/**
	 * maps the doctor extended models
	 * 
	 * @param doctorProfiles
	 * @return
	 * @throws JsonProcessingException
	 * @throws Exception
	 */
	public List<DoctorProfileWM> mapGetDoctorExtendedList(List<DoctorProfile> doctorProfiles)
			throws JsonProcessingException, Exception {
		List<DoctorProfileWM> doctorProfileWMs = new ArrayList<DoctorProfileWM>();

		for (DoctorProfile doctorProfile : doctorProfiles) {
			DoctorProfileWM doctorProfileWM = new DoctorProfileWM();

			doctorProfileWM.setId(doctorProfile.getId());
			doctorProfileWM.setTitle(doctorProfile.getTitle());
			doctorProfileWM.setOthers(doctorProfile.getOthers());
			doctorProfileWM.setFirstName(doctorProfile.getFirstName());
			doctorProfileWM.setLastName(doctorProfile.getLastName());
			doctorProfileWM.setAge(doctorProfile.getAge());
			doctorProfileWM.setNic(doctorProfile.getNic());
			doctorProfileWM.setGender(doctorProfile.getGender());
			doctorProfileWM.setPrintName(doctorProfile.getPrintName());
			doctorProfileWM.setHomeAddressNo(doctorProfile.getHomeAddressNo());
			doctorProfileWM.setStreetName1(doctorProfile.getStreetName1());
			doctorProfileWM.setStreetName2(doctorProfile.getStreetName2());
			doctorProfileWM.setTown(doctorProfile.getTown());
			doctorProfileWM.setDistrict(doctorProfile.getDistrict());
			doctorProfileWM.setFacebookUrl(doctorProfile.getFacebookUrl());
			doctorProfileWM.setLinkedInUrl(doctorProfile.getLinkedInUrl());
			doctorProfileWM.setHomeLandTelNo(doctorProfile.getHomeLandTelNo());
			doctorProfileWM.setMobile(doctorProfile.getMobile());
			doctorProfileWM.setMobileNo1(doctorProfile.getMobileNo1());
			doctorProfileWM.setMobileNo2(doctorProfile.getMobileNo2());
			doctorProfileWM.setEmail1(doctorProfile.getEmail1());
			doctorProfileWM.setEmail2(doctorProfile.getEmail2());
			doctorProfileWM.setVisitingHospitals(doctorProfile.getVisitingHospitals().split(","));
			doctorProfileWM.setOtherHospitals(doctorProfile.getOtherHospital());
			doctorProfileWM.setImagePath(doctorProfile.getImagePath());
			doctorProfileWM.setUserType(doctorProfile.getUserType());

			ObjectMapper objectMapper = new ObjectMapper();
			Info info = objectMapper.readValue(doctorProfile.getInfo(), Info.class);
			doctorProfileWM.setInfo(info);

			doctorProfileWMs.add(doctorProfileWM);
		}

		return doctorProfileWMs;
	}

	/**
	 * @param healthWikiWM maps Health wiki models to save health wiki
	 * @return
	 * @throws JsonProcessingException
	 * @throws Exception
	 */
	public HealthWiki mapSaveHealthWiki(HealthWikiWM healthWikiWM) throws JsonProcessingException, Exception {
		Date now = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = df.format(now);

		HealthWiki healthWiki = new HealthWiki();
		UserInfo doctor = new UserInfo();
		doctor.setId(healthWikiWM.getDoctorId());

		healthWiki.setId(healthWikiWM.getId());
		healthWiki.setName(healthWikiWM.getName());
		healthWiki.setDoctorId(healthWikiWM.getDoctorId());
		healthWiki.setFilePath(healthWikiWM.getFilePath());
		healthWiki.setCategory(healthWikiWM.getCategory());
		healthWiki.setDescription(healthWikiWM.getDescription());
		healthWiki.setReferenceId(healthWikiWM.getReferenceId());
		healthWiki.setCreatedDateTime(time);
		healthWiki.setCreatedBy("DOCTOR" + healthWikiWM.getDoctorId());
		healthWiki.setDoctor(doctor);

		return healthWiki;
	}

	/**
	 * @param healthWiki maps Health wiki models to get health wiki
	 * @return
	 * @throws JsonProcessingException
	 * @throws Exception
	 */
	public List<HealthWikiWM> mapHealthWiki(List<HealthWiki> healthWikis) throws JsonProcessingException, Exception {
		List<HealthWikiWM> healthWikiWMs = new ArrayList<HealthWikiWM>();

		for (HealthWiki healthWiki : healthWikis) {
			HealthWikiWM healthWikiWM = new HealthWikiWM();
			healthWikiWM.setId(healthWiki.getId());
			healthWikiWM.setName(healthWiki.getName());
			healthWikiWM.setDoctorId(healthWiki.getDoctorId());
			healthWikiWM.setFilePath(healthWiki.getFilePath());
			healthWikiWM.setCategory(healthWiki.getCategory());
			healthWikiWM.setDescription(healthWiki.getDescription());
			healthWikiWM.setReferenceId(healthWiki.getReferenceId());

			healthWikiWMs.add(healthWikiWM);
		}
		/*
		 * healthWikiWM.setId(healthWiki.getId());
		 * healthWikiWM.setName(healthWiki.getName());
		 * healthWikiWM.setDoctorId(healthWiki.getDoctorId());
		 * healthWikiWM.setFilePath(healthWiki.getFilePath());
		 * healthWikiWM.setCategory(healthWiki.getCategory());
		 * healthWikiWM.setDescription(healthWiki.getDescription());
		 * healthWikiWM.setReferenceId(healthWiki.getReferenceId());
		 */

		return healthWikiWMs;
	}

	/**
	 * 
	 * maps the HealthWikiShared model and HealthWikiSharedReq model
	 * 
	 * @param req
	 * @return
	 */
	public HealthWikiShared mapSaveHealthWikiShared(HealthWikiSharedReq req) throws JsonProcessingException, Exception {
		Date now = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = df.format(now);

		HealthWikiShared wikiShared = new HealthWikiShared();
		wikiShared.setId(req.getId());
		wikiShared.setDoctorId(req.getDoctorId());
		wikiShared.setPatientId(req.getPatientId());
		wikiShared.setHealthWikiId(req.getHealthWikiId());
		wikiShared.setCreatedDateTime(time);
		wikiShared.setCreatedBy("ADMIN");

		return wikiShared;
	}

	/**
	 * maps HealthWikiSharedReq model and HealthWikiShared model
	 * 
	 * @param healthWikiShared
	 * @return
	 * @throws JsonProcessingException
	 * @throws Exception
	 */
	public List<HealthWikiSharedReq> mapHealthWikiShareds(List<HealthWikiShared> healthWikiShareds)
			throws JsonProcessingException, Exception {
		List<HealthWikiSharedReq> healthWikiSharedReq = new ArrayList<>();
		for (HealthWikiShared hws : healthWikiShareds) {
			HealthWikiSharedReq hsr = new HealthWikiSharedReq();
			hsr.setId(hws.getId());
			hsr.setDoctorId(hws.getDoctorId());
			// TO DO

		}
		return healthWikiSharedReq;
	}

	/**
	 * maps HealthWikiResp model with HealthWikiRespEM model
	 * 
	 * @param healthWikiResps
	 * @return
	 * @throws JsonProcessingException
	 * @throws Exception
	 */
	public List<HealthWikiResp> mapHealthWikiResp(List<HealthWikiRespEM> healthWikiRespEMs)
			throws JsonProcessingException, Exception {
		List<HealthWikiResp> wikiResps = new ArrayList<>();
		for (HealthWikiRespEM respEM : healthWikiRespEMs) {
			HealthWikiResp resp = new HealthWikiResp();
			resp.setPatientId(respEM.getPatientId());
			resp.setFirstname(respEM.getFirstname());
			resp.setLastname(respEM.getLastname());
			List<HealthWikiWM> healthWikiWMs = new ArrayList<>();
			for (HealthWiki hw : respEM.getHealthWikis()) {
				HealthWikiWM hwwm = new HealthWikiWM();
				hwwm.setId(hw.getId());
				hwwm.setName(hw.getName());
				hwwm.setDoctorId(hw.getDoctorId());
				hwwm.setFilePath(hw.getFilePath());
				hwwm.setCategory(hw.getCategory());
				hwwm.setDescription(hw.getDescription());
				hwwm.setReferenceId(hw.getReferenceId());

				healthWikiWMs.add(hwwm);
			}

			resp.setHealthWikis(healthWikiWMs);
			wikiResps.add(resp);
		}

		return wikiResps;
	}

	/**
	 * maps PatientResp model and UserInfo
	 * 
	 * @param patientUIs
	 * @return
	 * @throws JsonProcessingException
	 * @throws Exception
	 */
	public List<PatientNameResp> mapPatientResps(List<UserInfo> patientUIs) throws JsonProcessingException, Exception {
		List<PatientNameResp> patientNameResps = new ArrayList<>();
		for (UserInfo pui : patientUIs) {
			PatientNameResp patientNameResp = new PatientNameResp();
			patientNameResp.setId(pui.getId());
			patientNameResp.setFirstname(pui.getFirstName());
			patientNameResp.setLastname(pui.getLastName());
			patientNameResps.add(patientNameResp);
		}

		return patientNameResps;
	}

	/**
	 * maps MedicalBill and MedicalBillWM models
	 * 
	 * @param medicalBillWM
	 * @return
	 * @throws JsonProcessingException
	 * @throws Exception
	 */
	public MedicalBill mapMedicalBill(MedicalBillWM medicalBillWM) throws JsonProcessingException, Exception {
		Date now = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = df.format(now);

		MedicalBill medicalBill = new MedicalBill();
		medicalBill.setId(medicalBillWM.getId());
		medicalBill.setPatientId(medicalBillWM.getPatientId());
		medicalBill.setDoctorId(medicalBillWM.getDoctorId());
		medicalBill.setInstituteId(medicalBillWM.getInstituteId());
		medicalBill.setHomeAddress(medicalBillWM.getHomeAddress());
		medicalBill.setOfficeAddress(medicalBillWM.getOfficeAddress());
		medicalBill.setDrugs(medicalBillWM.getDrugs());
		medicalBill.setInvestigations(medicalBillWM.getInvestigations());
		medicalBill.setDoctorFee(medicalBillWM.getDoctorFee());
		medicalBill.setOther(medicalBillWM.getOther());
		medicalBill.setCreatedDateTime(time);
		medicalBill.setCreatedBy("DOCTOR" + medicalBillWM.getDoctorId());

		return medicalBill;
	}
	
	public MedicalBillWM mapMedicalBill(MedicalBill medicalBill) throws JsonProcessingException, Exception {
		Date now = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = df.format(now);

		MedicalBillWM medicalBillWM = new MedicalBillWM();
		medicalBillWM.setId(medicalBill.getId());
		medicalBillWM.setPatientId(medicalBill.getPatientId());
		medicalBillWM.setDoctorId(medicalBill.getDoctorId());
		medicalBillWM.setInstituteId(medicalBill.getInstituteId());
		medicalBillWM.setHomeAddress(medicalBill.getHomeAddress());
		medicalBillWM.setOfficeAddress(medicalBill.getOfficeAddress());
		medicalBillWM.setDrugs(medicalBill.getDrugs());
		medicalBillWM.setInvestigations(medicalBill.getInvestigations());
		medicalBillWM.setDoctorFee(medicalBill.getDoctorFee());
		medicalBillWM.setOther(medicalBill.getOther());
		//medicalBillWM.setCreatedDateTime(time);
		//medicalBillWM.setCreatedBy("DOCTOR" + medicalBillWM.getDoctorId());

		return medicalBillWM;
	}

	/**
	 * maps Invoice model and InvoiceWM model
	 * 
	 * @param invoiceWM
	 * @return
	 * @throws JsonProcessingException
	 * @throws Exception
	 */
	public Invoice mapSaveInvoice(InvoiceWM invoiceWM) throws JsonProcessingException, Exception {
		Date now = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = df.format(now);

		Invoice invoice = new Invoice();
		invoice.setId(invoiceWM.getId());
		/*
		 * invoice.setPatientId(invoiceWM.getPatientId());
		 * invoice.setDoctorId(invoiceWM.getDoctorId());
		 */
		invoice.setInstituteId(invoiceWM.getInstituteId());
		invoice.setPrescriptionId(invoiceWM.getPrescriptionId());
		invoice.setAmount(invoiceWM.getAmount());
		invoice.setVat(invoiceWM.getVat());
		invoice.setTotal(invoiceWM.getTotal());
		invoice.setCreatedDateTime(time);
		/* invoice.setCreatedBy("DOCTOR"+invoiceWM.getDoctorId()); */

		return invoice;
	}

	/*
	 * public Stats getStats(AppointmentStats appointmentStats){ Stats stats = new
	 * Stats(); String mapAsJson = new
	 * ObjectMapper().writeValueAsString(statsWM.getStats());
	 * stats.setStats(mapAsJson);
	 * 
	 * return stats; }
	 */

	/**
	 * maps AdvertismentResp and AdvertismentInfo models
	 * 
	 * @param advertismentInfo
	 * @return
	 * @throws JsonProcessingException
	 * @throws Exception
	 */
	public List<AdvertisementResp> mapAdvertisementResp(List<AdvertisementInfo> advertisementInfo)
			throws JsonProcessingException, Exception {
		List<AdvertisementResp> advertisementResp = new ArrayList<>();

		for (AdvertisementInfo adInfo : advertisementInfo) {
			AdvertisementResp adResp = new AdvertisementResp();

			adResp.setAdvertismentId(adInfo.getId());
			adResp.setAdvertismentName(adInfo.getAdvertisementName());
			adResp.setIsActive(adInfo.getIsActive());
			adResp.setAdvertismentPath(adInfo.getAdvertisementPath());

			advertisementResp.add(adResp);
		}

//		medicalBill.setHomeAddress(medicalBillWM.getHomeAddress());
//		medicalBill.setOfficeAddress(medicalBillWM.getOfficeAddress());
//		medicalBill.setDrugs(medicalBillWM.getDrugs());
//		medicalBill.setInvestigations(medicalBillWM.getInvestigations());
//		medicalBill.setDoctorFee(medicalBillWM.getDoctorFee());
//		medicalBill.setOther(medicalBillWM.getOther());
//		medicalBill.setCreatedDateTime(time);
//		medicalBill.setCreatedBy("DOCTOR"+medicalBillWM.getDoctorId());

		return advertisementResp;
	}
	
	
	
	/**
	 * maps PrescriptionImage model and PrescriptionImageEM
	 * 
	 * @param patientUIs
	 * @return
	 * @throws JsonProcessingException
	 * @throws Exception
	 */
	public List<PrescriptionImage> mapPrescriptionImageEM(List<PrescriptionImageEM> prescriptionImagesEM) throws JsonProcessingException, Exception {
		List<PrescriptionImage> images = new ArrayList<>();
		Base64Convert base64Convert=new Base64Convert();
		for (PrescriptionImageEM prescriptionImageEM : prescriptionImagesEM) {
			PrescriptionImage image = new PrescriptionImage();
			image.setId(prescriptionImageEM.getId());
			image.setCreatedBy(prescriptionImageEM.getCreatedBy());
			image.setCreatedDate(prescriptionImageEM.getCreatedDate());
			image.setDataEntered(prescriptionImageEM.getDataEntered());
			//image.setImage(base64Convert.toBase64String(prescriptionImageEM.getImagePath()));
			image.setInstituteId(prescriptionImageEM.getInstituteId());
			image.setModifiedBy(prescriptionImageEM.getModifiedBy());
			image.setModifiedDate(prescriptionImageEM.getModifiedDate());
			image.setPatientId(prescriptionImageEM.getPatientId());
			image.setUserId(prescriptionImageEM.getUserId());
			
			images.add(image);
		}

		return images;
	}
	
	
	// region Diagnostic AI
	
	//RequestDiagnostics
	public RequestDiagnosticsWM mapRequestDiagnostics(RequestDiagnostics requestDiagnostics) throws Exception{
		RequestDiagnosticsWM requestDiagnosticsWM = new RequestDiagnosticsWM();
		
		requestDiagnosticsWM.setId(requestDiagnostics.getId());
		requestDiagnosticsWM.setCreatedBy(requestDiagnostics.getCreatedBy());
		requestDiagnosticsWM.setCreatedDate(requestDiagnostics.getCreatedDate());
		
		return requestDiagnosticsWM;
	}
	
	public List<RequestDiagnosticsWM> mapRequestDiagnostics(List<RequestDiagnostics> requestDiagnostics) throws Exception{
		List<RequestDiagnosticsWM> requestDiagnosticsWM = new ArrayList<>();
		
		for(RequestDiagnostics requestDiagnostic : requestDiagnostics) {
			
			RequestDiagnosticsWM requestDiagnosticWM = new RequestDiagnosticsWM();
			
			requestDiagnosticWM.setId(requestDiagnostic.getId());
			requestDiagnosticWM.setCreatedBy(requestDiagnostic.getCreatedBy());
			requestDiagnosticWM.setCreatedDate(requestDiagnostic.getCreatedDate());
			
			requestDiagnosticsWM.add(requestDiagnosticWM);
		}
		return requestDiagnosticsWM;
	}
	
	public RequestDiagnostics mapRequestDiagnostics(RequestDiagnosticsWM requestDiagnosticsWM) throws Exception{
		RequestDiagnostics requestDiagnostics = new RequestDiagnostics();
		
		requestDiagnostics.setId(requestDiagnosticsWM.getId());
		requestDiagnostics.setCreatedBy(requestDiagnosticsWM.getCreatedBy());
		requestDiagnostics.setCreatedDate(requestDiagnosticsWM.getCreatedDate());
		
		return requestDiagnostics;
	}
	
	
	
	//RequestedSymptoms
	public RequestedSymptomsWM mapRequestedSymptoms(RequestedSymptoms requestedSymptoms) throws Exception{
		RequestedSymptomsWM requestedSymptomsWM = new RequestedSymptomsWM();
		
		requestedSymptomsWM.setId(requestedSymptoms.getId());
		requestedSymptomsWM.setRequestDiagnosticId(requestedSymptoms.getRequestDiagnosticId());
		requestedSymptomsWM.setSymptom(requestedSymptoms.getSymptom());
		
		return requestedSymptomsWM;
	}
	
	public List<RequestedSymptomsWM> mapRequestedSymptoms(List<RequestedSymptoms> requestedSymptoms) throws Exception{
		List<RequestedSymptomsWM> requestedSymptomsWM = new ArrayList<>();
		
		for(RequestedSymptoms requestedSymptom : requestedSymptoms) {
			
			RequestedSymptomsWM requestedSymptomWM = new RequestedSymptomsWM();
			
			requestedSymptomWM.setId(requestedSymptom.getId());
			requestedSymptomWM.setRequestDiagnosticId(requestedSymptom.getRequestDiagnosticId());
			requestedSymptomWM.setSymptom(requestedSymptom.getSymptom());
			
			requestedSymptomsWM.add(requestedSymptomWM);
		}
		return requestedSymptomsWM;
	}
	
	public RequestedSymptoms mapRequestedSymptoms(RequestedSymptomsWM requestedSymptomsWM) throws Exception{
		RequestedSymptoms requestedSymptoms = new RequestedSymptoms();
		
		requestedSymptoms.setId(requestedSymptomsWM.getId());
		requestedSymptoms.setRequestDiagnosticId(requestedSymptomsWM.getRequestDiagnosticId());
		requestedSymptoms.setSymptom(requestedSymptomsWM.getSymptom());
		
		return requestedSymptoms;
	}
	
	
	//ResponseDiagnosticReportedSymptoms
	public ResponseDiagnosticReportedSymptomsWM mapResponseDiagnosticReportedSymptoms(ResponseDiagnosticReportedSymptoms responseDiagnosticReportedSymptoms) throws Exception{
		ResponseDiagnosticReportedSymptomsWM responseDiagnosticReportedSymptomsWM = new ResponseDiagnosticReportedSymptomsWM();

		responseDiagnosticReportedSymptomsWM.setId(responseDiagnosticReportedSymptoms.getId());
		responseDiagnosticReportedSymptomsWM.setResponseDiagnosticId(responseDiagnosticReportedSymptoms.getResponseDiagnosticId());
		responseDiagnosticReportedSymptomsWM.setSymptomsReported(responseDiagnosticReportedSymptoms.getSymptomsReported());
		
		return responseDiagnosticReportedSymptomsWM;
	}
	
	public List<ResponseDiagnosticReportedSymptomsWM> mapResponseDiagnosticReportedSymptoms(List<ResponseDiagnosticReportedSymptoms> responseDiagnosticReportedSymptoms) throws Exception{
		
		List<ResponseDiagnosticReportedSymptomsWM> responseDiagnosticReportedSymptomsWM = new ArrayList<>();
		
		for(ResponseDiagnosticReportedSymptoms responseDiagnosticReportedSymptom : responseDiagnosticReportedSymptoms) {
			ResponseDiagnosticReportedSymptomsWM responseDiagnosticReportedSymptomWM = new ResponseDiagnosticReportedSymptomsWM();
			
			responseDiagnosticReportedSymptomWM.setId(responseDiagnosticReportedSymptom.getId());
			responseDiagnosticReportedSymptomWM.setResponseDiagnosticId(responseDiagnosticReportedSymptom.getResponseDiagnosticId());
			responseDiagnosticReportedSymptomWM.setSymptomsReported(responseDiagnosticReportedSymptom.getSymptomsReported());
			
			responseDiagnosticReportedSymptomsWM.add(responseDiagnosticReportedSymptomWM);
		}
		
		return responseDiagnosticReportedSymptomsWM;
	}
	
	public ResponseDiagnosticReportedSymptoms mapResponseDiagnosticReportedSymptoms(ResponseDiagnosticReportedSymptomsWM responseDiagnosticReportedSymptomsWM) throws Exception{
		ResponseDiagnosticReportedSymptoms responseDiagnosticReportedSymptoms = new ResponseDiagnosticReportedSymptoms();

		responseDiagnosticReportedSymptoms.setId(responseDiagnosticReportedSymptomsWM.getId());
		responseDiagnosticReportedSymptoms.setResponseDiagnosticId(responseDiagnosticReportedSymptomsWM.getResponseDiagnosticId());
		responseDiagnosticReportedSymptoms.setSymptomsReported(responseDiagnosticReportedSymptomsWM.getSymptomsReported());
		
		return responseDiagnosticReportedSymptoms;
	}
	
	
	
	
	//ResponseDiagnosticStaticsComplainedSymptoms
	public ResponseDiagnosticStaticsComplainedSymptomsWM mapResponseDiagnosticStaticsComplainedSymptoms(ResponseDiagnosticStaticsComplainedSymptoms responseDiagnosticStaticsComplainedSymptoms) throws Exception{
		ResponseDiagnosticStaticsComplainedSymptomsWM responseDiagnosticStaticsComplainedSymptomsWM = new ResponseDiagnosticStaticsComplainedSymptomsWM();
		
		responseDiagnosticStaticsComplainedSymptomsWM.setId(responseDiagnosticStaticsComplainedSymptoms.getId());
		responseDiagnosticStaticsComplainedSymptomsWM.setComplainedSymptoms(responseDiagnosticStaticsComplainedSymptoms.getComplainedSymptoms());
		responseDiagnosticStaticsComplainedSymptomsWM.setResponseDiagnosticStaticsId(responseDiagnosticStaticsComplainedSymptoms.getResponseDiagnosticStaticsId());
		
		return responseDiagnosticStaticsComplainedSymptomsWM;
	}
	
	public List<ResponseDiagnosticStaticsComplainedSymptomsWM> mapResponseDiagnosticStaticsComplainedSymptoms(List<ResponseDiagnosticStaticsComplainedSymptoms> responseDiagnosticStaticsComplainedSymptoms) throws Exception{
		List<ResponseDiagnosticStaticsComplainedSymptomsWM> responseDiagnosticStaticsComplainedSymptomsWM = new ArrayList<>();
		
		for(ResponseDiagnosticStaticsComplainedSymptoms responseDiagnosticStaticsComplainedSymptom : responseDiagnosticStaticsComplainedSymptoms) {
			ResponseDiagnosticStaticsComplainedSymptomsWM responseDiagnosticStaticsComplainedSymptomWM = new ResponseDiagnosticStaticsComplainedSymptomsWM();
			
			responseDiagnosticStaticsComplainedSymptomWM.setId(responseDiagnosticStaticsComplainedSymptom.getId());
			responseDiagnosticStaticsComplainedSymptomWM.setComplainedSymptoms(responseDiagnosticStaticsComplainedSymptom.getComplainedSymptoms());
			responseDiagnosticStaticsComplainedSymptomWM.setResponseDiagnosticStaticsId(responseDiagnosticStaticsComplainedSymptom.getResponseDiagnosticStaticsId());
			
			responseDiagnosticStaticsComplainedSymptomsWM.add(responseDiagnosticStaticsComplainedSymptomWM);
		}
		
		return responseDiagnosticStaticsComplainedSymptomsWM;
	}
	
	// end region Diagnostic AI
	
	
	/**
	 * @param ReferralLetterWM maps the saved ReferralLetter to send
	 * @return
	 * @throws JsonProcessingException
	 * @throws Exception
	 */
	public ReferralLetter mapReferralLetter(ReferralLetterWM referralLetterWM)
			throws JsonProcessingException, Exception {
		Date now = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = df.format(now);
		ReferralLetter referralLetter = new ReferralLetter();
		referralLetter.setId(referralLetterWM.getId());
		referralLetter.setDoctorId(referralLetterWM.getDoctorId());
		referralLetter.setPatientId(referralLetterWM.getPatientId());
		referralLetter.setInstituteId(referralLetterWM.getInstituteId());
		referralLetter.setMessage(referralLetterWM.getMessage());
		referralLetter.setReferringDoctor(referralLetterWM.getReferringDoctor());
		referralLetter.setCreatedDateTime(time);
		referralLetter.setCreatedBy("DOCTOR" + referralLetterWM.getDoctorId());

		return referralLetter;
	}
	
	public ReferralLetterWM mapReferralLetter(ReferralLetter referralLetter)
			throws JsonProcessingException, Exception {
		Date now = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = df.format(now);
		
		ReferralLetterWM referralLetterWM = new ReferralLetterWM();
		referralLetterWM.setId(referralLetter.getId());
		referralLetterWM.setDoctorId(referralLetter.getDoctorId());
		referralLetterWM.setPatientId(referralLetter.getPatientId());
		referralLetterWM.setInstituteId(referralLetter.getInstituteId());
		referralLetterWM.setMessage(referralLetter.getMessage());
		referralLetterWM.setReferringDoctor(referralLetter.getReferringDoctor());
		//referralLetterWM.setCreatedDateTime(time);
		//referralLetterWM.setCreatedBy("DOCTOR" + referralLetterWM.getDoctorId());

		return referralLetterWM;
	}
	
}
