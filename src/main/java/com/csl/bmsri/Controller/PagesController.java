package com.csl.bmsri.Controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.csl.bmsri.JPA.AttnInfoJPA;
import com.csl.bmsri.JPA.AttnRemarksJPA;
import com.csl.bmsri.Models.Attn_App_Info;
import com.csl.bmsri.Models.Attn_Remarks;
import com.csl.bmsri.Models.User;
import com.csl.bmsri.userService.UserService;


@Controller
public class PagesController {
	

    @Autowired
    private UserService userService;
	
	@Autowired
	private AttnRemarksJPA attnjpa;
	
	@Autowired
	private AttnInfoJPA attninfojpa;
	
	@RequestMapping("/home")
	public String index(Model model)
	{
		
		List<Attn_Remarks> list = attnjpa.findAll();
		System.out.println("size : " + list.size());
		Attn_App_Info attnobj = new Attn_App_Info();
		model.addAttribute("attnobj", attnobj);

		model.addAttribute("remarkslist", list);
		return "pages/attendance/index";
	}
	
	@RequestMapping(value= {"/", "/login"})
	public String login(Model model)
	{
		return "pages/user/login";
	}
	
	@RequestMapping("/signup")
	public String signup(Model model)
	{
		return "pages/user/singup";
	}
	
	@RequestMapping(value= "/attendance/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("") Attn_App_Info attninfo, @Param("idno") String idno, @Param("attnremid") String attnremid)
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		
		//supplier.setSs_facty_ss_facty_id(user.getSs_facty_id());
		
		attninfo.setAttn_status("Y");
		String iddno = user.getIdno();
	    attninfo.setIdno(iddno);
	    System.out.println("get id: "+iddno);
	    
	    int attnremmid = Integer.parseInt(attnremid);
	    attninfo.setAttnremid(attnremmid);
	    System.out.println("get remid: "+attnremmid);
		/*
		 * System.out.println("get id: "+attninfo.getIdno());
		 * System.out.println("get remid: "+attninfo.getAttnremid());
		 * System.out.println("get remarks: "+attninfo.getAttnremid());
		 */
		
		Date date = new Date();
	    String strDateFormat = "hh:mm:ss";
	    DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
	    String formattedDate= dateFormat.format(date);
	    attninfo.setTime(formattedDate);
	    
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MMM-dd");  
	    Date dates = new Date();  
	    System.out.println(formatter.format(dates));
	    
	    System.out.println(dates);
	    
	    attninfo.setDate(dates);
	    
		attninfojpa.save(attninfo);
		System.out.println("Data Successfully Saved");
		return "redirect:/home";
	}

}
