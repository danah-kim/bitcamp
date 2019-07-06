package com.spring5.web.interceptors;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.spring5.web.mbr.Member;
import com.spring5.web.mbr.MemberMapper;

@Aspect
@SessionAttributes("loginUser")
public class LoginInterceptor extends HandlerInterceptorAdapter {
	  private static final String LOGIN = "login";
	  private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	  @Autowired Member mbr;
		@Autowired MemberMapper mbrMapper;  
	  

	  @Override
	  public boolean preHandle(HttpServletRequest request, 
	      HttpServletResponse response, Object handler) throws Exception {
		  logger.info("인터셉터 성공");
		  boolean result = false;
		  String webRoot = request.getContextPath();
		  try {
			  String id = (String) request.getSession().getAttribute("user");
			  if(id == null) {
				  /* if(isAjaxRequest(request)) {
					  logger.info("인터셉터1");
					  response.sendError(400);
					  return false;  
				  }else { */
					logger.info("인터셉터2");
					HttpSession session = request.getSession();
					session.setAttribute("loginUser", "danah");
					response.sendRedirect(webRoot+"/mbr/auth");
					result = false;
				/*}else {
					result = true;
				}*/
			  }
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			return false;
		}
		  return result;
	  }  
	}