package com.ssq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SsqController {

//	@RequestMapping("/ssq.action")
	@RequestMapping(value="/ssq.action",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView helloWorld() throws Exception {
		
		//返回modelandview
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("hello", "hello world!");
		//指定视图
		modelAndView.setViewName("ssq");
		
		return modelAndView;
	}
	
}
