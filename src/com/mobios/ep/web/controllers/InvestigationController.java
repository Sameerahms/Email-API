/**
 * 
 */
package com.mobios.ep.web.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mobios.ep.common.util.AuthTokenValidate;
import com.mobios.ep.common.util.Log4JUtil;
import com.mobios.ep.services.InvestigationService;
import com.mobios.ep.web.models.InvestigationEmailDetailsWM;
import com.mobios.ep.web.models.InvestigationEmailInfoM;
import com.mobios.ep.web.models.InvestigationEmailSummaryM;
import com.mobios.ep.web.models.InvestigationEmailSummaryReq;
import com.mobios.ep.web.models.InvestigationEmailWM;
import com.mobios.ep.web.models.InvestigationWM;
import com.mobios.ep.web.util.Mapper;
import com.mobios.ep.web.util.NoInstituteFoundException;
import com.mobios.ep.web.util.NoInvestigationFoundException;
import com.ombios.ep.entity.model.Investigation;
import com.ombios.ep.entity.model.InvestigationEmailInfoEM;
import com.ombios.ep.entity.model.InvestigationEmailSummaryEM;

/**
 * Controller class for save and get investigations
 * 
 * @author Nishantha
 *
 */
@RestController
@CrossOrigin(origins = "*")
public class InvestigationController {

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "investigation/save", method = RequestMethod.POST)
	public @ResponseBody int saveInvestigation(HttpServletRequest request, @RequestBody InvestigationWM investigationWM) throws Exception {
		
    	String authKey = request.getHeader("Auth-Key");
    	System.out.println("Auth Key ===> "+authKey);
    
    	AuthTokenValidate authTokenValidate = new AuthTokenValidate();
    	com.mobios.ep.common.util.AuthToken isValid = authTokenValidate.TokenValidate(authKey);
    	
    	System.out.println(isValid.getUsername());
    	System.out.println(isValid.getToken());
    	
    	if(isValid.getToken().equals("false")) {
    		System.out.println("12345");
    		throw new Exception("token invalid");
    	}
    	
		int id = 0;
		Log4JUtil.logger.info("INVESTIGATION,investigation_save_request,Request=" + investigationWM.toString());
		Investigation investigation = new Investigation();
		InvestigationWM wm = new InvestigationWM();
		InvestigationService service = new InvestigationService();
		Mapper mapper = new Mapper();
		investigation = mapper.mapSaveInvestigation(investigationWM);
		try {
			id = service.saveInvestigation(investigation);
		} catch (Exception exp) {
			Log4JUtil.logger.info("INVESTIGATION,investigation_save_request,Request=" + investigationWM.toString() + ","
					+ exp.getMessage());
			throw new NoInvestigationFoundException();
		}
		return id;
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "investigation/list", method = RequestMethod.POST)
	public List<String> getInvestigation(HttpServletRequest request, @RequestBody InvestigationWM investigationWM) throws Exception {
		
    	String authKey = request.getHeader("Auth-Key");
    	System.out.println("Auth Key ===> "+authKey);
    
    	AuthTokenValidate authTokenValidate = new AuthTokenValidate();
    	com.mobios.ep.common.util.AuthToken isValid = authTokenValidate.TokenValidate(authKey);
    	
    	System.out.println(isValid.getUsername());
    	System.out.println(isValid.getToken());
    	
    	if(isValid.getToken().equals("false")) {
    		System.out.println("12345");
    		throw new Exception("token invalid");
    	}
    	
		List<String> investigations = new ArrayList<String>();
		Log4JUtil.logger.info("INVESTIGATION,investigation_get_request,Request=" + investigationWM.toString());
		InvestigationService service = new InvestigationService();
		Mapper mapper = new Mapper();
		try {
			investigations = service.getInvestigation(investigationWM.getDoctorId());
		} catch (Exception exp) {
			Log4JUtil.logger.info("INVESTIGATION,investigation_get_request,Request=" + investigationWM.toString() + ","
					+ exp.getMessage());
			throw new NoInvestigationFoundException();
		}
		if (investigations.size() == 0)
			throw new NoInvestigationFoundException();

		return investigations;
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "investigation/listByInstitudeId", method = RequestMethod.POST)
	public List<InvestigationEmailInfoM> getInvestigationByInsId(HttpServletRequest request,
			@RequestBody InvestigationEmailDetailsWM investigationEmailDetailsWM) throws Exception {
		
    	String authKey = request.getHeader("Auth-Key");
    	System.out.println("Auth Key ===> "+authKey);
    
    	AuthTokenValidate authTokenValidate = new AuthTokenValidate();
    	com.mobios.ep.common.util.AuthToken isValid = authTokenValidate.TokenValidate(authKey);
    	
    	System.out.println(isValid.getUsername());
    	System.out.println(isValid.getToken());
    	
    	if(isValid.getToken().equals("false")) {
    		System.out.println("12345");
    		throw new Exception("token invalid");
    	}

		List<InvestigationEmailInfoEM> investigationsInfo = new ArrayList<InvestigationEmailInfoEM>();
		List<InvestigationEmailInfoM> investigationEmailInfoM = new ArrayList<InvestigationEmailInfoM>();
		Log4JUtil.logger.info("INVESTIGATION,investigationByInstitudeID_get_request,Request="
				+ investigationEmailDetailsWM.toString());
		InvestigationService service = new InvestigationService();
		Mapper mapper = new Mapper();
		try {
			investigationsInfo = service.getInvestigationByInsId(investigationEmailDetailsWM.getInstitudeId());

			System.out.println("Investigation Controller 1 " + investigationsInfo.get(0).getDoctor().getFirstName());

		} catch (Exception exp) {
			Log4JUtil.logger.info("INVESTIGATION,investigationByIstitudeId_get_request,Request="
					+ investigationEmailDetailsWM.toString() + "," + exp.getMessage());
			throw new NoInvestigationFoundException();
		}
		if (investigationsInfo == null) throw new NoInvestigationFoundException();
		
		investigationEmailInfoM = mapper.mapListInvestigationEmailInfo(investigationsInfo);

		/*System.out.println("Investigation Controller 2 " + investigationEmailInfoM.get(0).getDoctor().getFirstName());
		System.out.println("Investigation Controller 2 " + investigationEmailInfoM.get(1).getDoctor().getFirstName());
		System.out.println("Investigation Controller 2 " + investigationEmailInfoM.get(2).getDoctor().getFirstName());
		System.out.println("Investigation Controller 2 " + investigationEmailInfoM.get(3).getDoctor().getFirstName());*/
		
		/*for(int i = 0;i<=investigationEmailInfoM.size();i++) {
			System.out.println("Investigation Controller 2 " + investigationEmailInfoM.get(i).getDoctor().getFirstName());
		}*/
		
		return investigationEmailInfoM;
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "investigation/delete", method = RequestMethod.POST)
	public @ResponseBody boolean deleteInvestigation(HttpServletRequest request, @RequestBody InvestigationWM investigationWM) throws Exception {
		
    	String authKey = request.getHeader("Auth-Key");
    	System.out.println("Auth Key ===> "+authKey);
    
    	AuthTokenValidate authTokenValidate = new AuthTokenValidate();
    	com.mobios.ep.common.util.AuthToken isValid = authTokenValidate.TokenValidate(authKey);
    	
    	System.out.println(isValid.getUsername());
    	System.out.println(isValid.getToken());
    	
    	if(isValid.getToken().equals("false")) {
    		System.out.println("12345");
    		throw new Exception("token invalid");
    	}
    	
		boolean isSuccess = false;
		Log4JUtil.logger.info("INVESTIGATION,investigation_delete_request,Request=" + investigationWM.toString());
		InvestigationService service = new InvestigationService();
		Mapper mapper = new Mapper();
		try {
			isSuccess = service.deleteInvestigation(investigationWM.getId());
		} catch (Exception exp) {
			Log4JUtil.logger.info("INVESTIGATION,investigation_delete_request,Request=" + investigationWM.toString()
					+ "," + exp.getMessage());
			throw new NoInvestigationFoundException();
		}
		return isSuccess;
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "investigation/deleteByTest", method = RequestMethod.POST)
	public boolean deleteByTest(HttpServletRequest request, @RequestBody InvestigationWM investigationWM) throws Exception {
		
    	String authKey = request.getHeader("Auth-Key");
    	System.out.println("Auth Key ===> "+authKey);
    
    	AuthTokenValidate authTokenValidate = new AuthTokenValidate();
    	com.mobios.ep.common.util.AuthToken isValid = authTokenValidate.TokenValidate(authKey);
    	
    	System.out.println(isValid.getUsername());
    	System.out.println(isValid.getToken());
    	
    	if(isValid.getToken().equals("false")) {
    		System.out.println("12345");
    		throw new Exception("token invalid");
    	}
    	
		boolean isSuccess = false;
		Log4JUtil.logger.info("INVESTIGATION,investigation_deleteByTest_request,Request=" + investigationWM.toString());
		InvestigationService service = new InvestigationService();
		try {
			isSuccess = service.deleteByTest(investigationWM.getDoctorId(), investigationWM.getTest());
		} catch (Exception exp) {
			Log4JUtil.logger.info("INVESTIGATION,investigation_deleteByTest_request,Request="
					+ investigationWM.toString() + "," + exp.getMessage());
			throw new NoInvestigationFoundException();
		}

		return isSuccess;
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "investigation/saveInvestigationEmail", method = RequestMethod.POST)
	public @ResponseBody int saveEmail(HttpServletRequest request, @RequestBody InvestigationEmailWM investigationEmailWM) throws Exception {
		
    	String authKey = request.getHeader("Auth-Key");
    	System.out.println("Auth Key ===> "+authKey);
    
    	AuthTokenValidate authTokenValidate = new AuthTokenValidate();
    	com.mobios.ep.common.util.AuthToken isValid = authTokenValidate.TokenValidate(authKey);
    	
    	System.out.println(isValid.getUsername());
    	System.out.println(isValid.getToken());
    	
    	if(isValid.getToken().equals("false")) {
    		System.out.println("12345");
    		throw new Exception("token invalid");
    	}
    	
		int id = 0;

		Log4JUtil.logger.info("INVESTIGATION,investigation_saveInvestigationEmail_request,Request="
				+ investigationEmailWM.toString());
		InvestigationEmailInfoEM investigationEmail = new InvestigationEmailInfoEM();
		// InvestigationEmailWM wm= new InvestigationEmailWM();
		InvestigationService service = new InvestigationService();
		Mapper mapper = new Mapper();
		investigationEmail = mapper.mapSaveInvestigationEmail(investigationEmailWM);
		try {
			id = service.saveInvestigationEmail(investigationEmail);
		} catch (Exception exp) {
			Log4JUtil.logger.info("INVESTIGATION,investigation_saveInvestigationEmail_request,Request="
					+ investigationEmailWM.toString() + "," + exp.getMessage());
			throw new NoInvestigationFoundException();
		}
		return id;
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "investigation/getInvestigationEmailSummaryByInstitute", method = RequestMethod.POST)
	public List<InvestigationEmailSummaryM> getInvestigationEmailSummaryGroupByInstitute(HttpServletRequest request,
			@RequestBody InvestigationEmailDetailsWM investigationEmailDetailsWM) throws Exception {
		
    	String authKey = request.getHeader("Auth-Key");
    	System.out.println("Auth Key ===> "+authKey);
    
    	AuthTokenValidate authTokenValidate = new AuthTokenValidate();
    	com.mobios.ep.common.util.AuthToken isValid = authTokenValidate.TokenValidate(authKey);
    	
    	System.out.println(isValid.getUsername());
    	System.out.println(isValid.getToken());
    	
    	if(isValid.getToken().equals("false")) {
    		System.out.println("12345");
    		throw new Exception("token invalid");
    	}

		List<InvestigationEmailSummaryEM> investigationsEmailSummary = new ArrayList<InvestigationEmailSummaryEM>();
		List<InvestigationEmailSummaryM> investigationEmailSummaryM = new ArrayList<InvestigationEmailSummaryM>();
		Log4JUtil.logger.info("INVESTIGATION,investigationEmailSummaryByInstitude_get_request,Request="
				+ investigationEmailDetailsWM.toString());
		InvestigationService service = new InvestigationService();
		Mapper mapper = new Mapper();
		try {
			investigationsEmailSummary = service
					.getInvestigationEmailSummaryGroubByInstitude(investigationEmailDetailsWM.getInstitudeId());
		} catch (Exception exp) {
			Log4JUtil.logger.info("INVESTIGATION,investigationEmailSummaryByInstitude_get_request,Request="
					+ investigationEmailDetailsWM.toString() + "," + exp.getMessage());
			throw new NoInvestigationFoundException();
		}
		if (investigationsEmailSummary == null)
			throw new NoInvestigationFoundException();
		investigationEmailSummaryM = mapper.mapListInvestigationEmailSummary(investigationsEmailSummary);
		return investigationEmailSummaryM;
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "investigation/getInvestigationEmailSummaryGroupByDate", method = RequestMethod.POST)
	public List<InvestigationEmailSummaryM> getInvestigationEmailSummaryGroupByDate(HttpServletRequest request,
			@RequestBody InvestigationEmailSummaryReq investigationEmailSummaryReq) throws Exception {
		
    	String authKey = request.getHeader("Auth-Key");
    	System.out.println("Auth Key ===> "+authKey);
    
    	AuthTokenValidate authTokenValidate = new AuthTokenValidate();
    	com.mobios.ep.common.util.AuthToken isValid = authTokenValidate.TokenValidate(authKey);
    	
    	System.out.println(isValid.getUsername());
    	System.out.println(isValid.getToken());
    	
    	if(isValid.getToken().equals("false")) {
    		System.out.println("12345");
    		throw new Exception("token invalid");
    	}

		List<InvestigationEmailSummaryEM> investigationsEmailSummary = new ArrayList<InvestigationEmailSummaryEM>();
		List<InvestigationEmailSummaryM> investigationEmailSummaryM = new ArrayList<InvestigationEmailSummaryM>();
		Log4JUtil.logger.info("INVESTIGATION,investigationEmailSummaryByDate_get_request,Request="
				+ investigationEmailSummaryReq.toString());
		InvestigationService service = new InvestigationService();
		Mapper mapper = new Mapper();
		try {
			investigationsEmailSummary = service.getInvestigationEmailSummaryGroubByDate(
					investigationEmailSummaryReq.getInstitudeId(), investigationEmailSummaryReq.getstartDate(),
					investigationEmailSummaryReq.getendDate());
		} catch (Exception exp) {
			Log4JUtil.logger.info("INVESTIGATION,investigationEmailSummaryByDate_get_request,Request="
					+ investigationEmailSummaryReq.toString() + "," + exp.getMessage());
			throw new NoInvestigationFoundException();
		}
		if (investigationsEmailSummary == null)
			throw new NoInvestigationFoundException();
		investigationEmailSummaryM = mapper.mapListInvestigationEmailSummary(investigationsEmailSummary);
		return investigationEmailSummaryM;
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "investigation/updateInvestigationCheckedStatus", method = RequestMethod.POST)
	public @ResponseBody boolean updateInvestigationStatus(HttpServletRequest request,
			@RequestBody InvestigationEmailSummaryReq investigationEmailSummaryReq) throws Exception {
		
    	String authKey = request.getHeader("Auth-Key");
    	System.out.println("Auth Key ===> "+authKey);
    
    	AuthTokenValidate authTokenValidate = new AuthTokenValidate();
    	com.mobios.ep.common.util.AuthToken isValid = authTokenValidate.TokenValidate(authKey);
    	
    	System.out.println(isValid.getUsername());
    	System.out.println(isValid.getToken());
    	
    	if(isValid.getToken().equals("false")) {
    		System.out.println("12345");
    		throw new Exception("token invalid");
    	}
    	
		boolean isSuccess = false;
		Log4JUtil.logger.info("INVESTIGATION,investigation_update_checked_status_request,Request="
				+ investigationEmailSummaryReq.toString());
		InvestigationService service = new InvestigationService();
		Mapper mapper = new Mapper();
		try {
			isSuccess = service.updateInvestigationCheckedStatus(investigationEmailSummaryReq.getId(),
					investigationEmailSummaryReq.getStatus());
		} catch (Exception exp) {
			Log4JUtil.logger.info("INVESTIGATION,investigation_update_checked_status_request,Request="
					+ investigationEmailSummaryReq.toString() + "," + exp.getMessage());
			throw new NoInvestigationFoundException();
		}
		return isSuccess;
	}

}
