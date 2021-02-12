/**
 * 
 */
package com.mobios.ep.web.controllers;

import java.net.Authenticator.RequestorType;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mobios.ep.common.util.AuthTokenValidate;
import com.mobios.ep.common.util.Log4JUtil;
import com.mobios.ep.services.InvoiceService;
import com.mobios.ep.web.models.DateRangeReq;
import com.mobios.ep.web.models.InvoiceDailyListRes;
import com.mobios.ep.web.models.InvoiceListByDatesReq;
import com.mobios.ep.web.models.InvoiceWM;
import com.mobios.ep.web.util.Mapper;
import com.mobios.ep.web.util.NoInvoiceFoundException;
import com.ombios.ep.entity.model.Invoice;
import com.ombios.ep.entity.model.InvoiceDailyListEM;

/**
 * @author Nishantha
 *
 */

@RestController
public class InvoiceController {
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/invoice/save", method = RequestMethod.POST)
	public @ResponseBody int saveInvoice(HttpServletRequest request, @RequestBody InvoiceWM invoiceWM) throws Exception{
		
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
    	
		int id=0;
		Log4JUtil.logger.info("INVOICE,invoice_save_request,Request="+invoiceWM.toString());
		InvoiceService service= new InvoiceService();
		Invoice invoice=new Invoice();
		Mapper mapper = new Mapper();
		try{
			invoice= mapper.mapSaveInvoice(invoiceWM);	
			id= service.saveInvoice(invoice);			
		}catch(Exception exp){
			Log4JUtil.logger.info("INVOICE,invoice_save_request,Request="+invoiceWM.toString()+","+ exp.getMessage());
			exp.printStackTrace();
			throw new NoInvoiceFoundException();
		}
				
		return id;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/invoice/list", method=RequestMethod.POST)
	public List<InvoiceDailyListEM> getInvoiceList(HttpServletRequest request, @RequestBody InvoiceListByDatesReq req) throws Exception{
		
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
    	
		List<InvoiceDailyListEM> invoiceDailyListEMs = new ArrayList<>();
		Log4JUtil.logger.info("INVOICE,get_invoice_list_request,Request="+ req.toString());
		InvoiceService service = new InvoiceService();
		Mapper mapper= new Mapper();
		try{
			invoiceDailyListEMs = service.getInvoiceList(req.getStartDate(), req.getEndDate(), req.getInstituteId());
		}catch(Exception exp){
			Log4JUtil.logger.info("INVOICE,get_invoice_list_request,Request="+req.toString()+","+ exp.getMessage());
			exp.printStackTrace();
			throw new NoInvoiceFoundException();
		}
		
		return invoiceDailyListEMs;
	}
	

}
