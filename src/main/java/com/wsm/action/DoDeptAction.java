package com.wsm.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wsm.biz.IDeptBiz;
import com.wsm.po.Dept;
@Controller
public class DoDeptAction {
	@Resource
	private IDeptBiz deptbiz;
	@RequestMapping("/showdept.do")
	public ModelAndView show(){
		ModelAndView mv=new ModelAndView();
		mv.addObject("list",deptbiz.findAll());
		mv.setViewName("showdept");
		return mv;
	}
	@RequestMapping("add.do")
	public String test03() {
		deptbiz.add();
		return "success";
	}
	@RequestMapping("findalldept.do")
	public String doshow(HttpServletRequest request,
			@RequestParam(required=true,defaultValue="1") Integer pagenow,
			@RequestParam(required=false,defaultValue="3") Integer pagesize) {
		PageHelper.startPage(pagenow,pagesize);
		List<Dept> list=deptbiz.findAll();
		PageInfo<Dept> info=new PageInfo<Dept>(list);
		request.setAttribute("list", list);
		request.setAttribute("info", info);
		request.setAttribute("acount", info.getTotal());
		return "showdept";		
	}
}
