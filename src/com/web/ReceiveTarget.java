package com.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.page.Page;
import com.pojo.AttributePo;
import com.pojo.ReceiveTargetPo;
import com.service.AttributeService;
import com.service.ReceiveTargetService;

/**
 * 接待对象
 * @author zhouchao
 *
 */
@Controller
@RequestMapping("/ReceiveTarget")
public class ReceiveTarget {
	
	@Autowired
	private ReceiveTargetService receiveTargetService;
	
	@Autowired
	private AttributeService attributeService;
	
	
	@RequestMapping("/tolist")
	public ModelAndView list(HttpServletRequest request, Integer currentPage, String txtname){
		ModelAndView mv=null;
		mv=new ModelAndView("/receivetarget/list");
		Page<ReceiveTargetPo> vo=new Page<ReceiveTargetPo>();
		if (currentPage==null) {
			currentPage=1;
		}else if (currentPage==0) {
			currentPage=1;
		}
		if(txtname==null)
		{
			txtname="";
		}
		vo.setCurrentPage(currentPage);
		vo=this.receiveTargetService.pageFuzzyselect(txtname, vo);
		mv.addObject("list",vo);
		mv.addObject("txtname",txtname);
		return mv;
	}
	
	@RequestMapping("/toadd")
	public ModelAndView toadd(){
		ModelAndView mv=null;
		List<AttributePo> listOne=attributeService.selectTargetType();
		mv=new ModelAndView("/receivetarget/add");
		mv.addObject("listOne",listOne);
		return mv;
	}
	
	@RequestMapping("/add")
	public ModelAndView add(ReceiveTargetPo receiveTargetPo){
		ModelAndView mv=null;
		receiveTargetService.insertAll(receiveTargetPo);
		mv=new ModelAndView("redirect:/ReceiveTarget/tolist.do");
		return mv;
	}
	
	@RequestMapping("/toupdate")
	public ModelAndView toupdate(int id){
		ModelAndView mv=null;
		List<AttributePo> listOne=attributeService.selectTargetType();
		ReceiveTargetPo list=receiveTargetService.selectById(id);
		mv=new ModelAndView("/receivetarget/update");
		mv.addObject("listOne",listOne);
		mv.addObject("list",list);
		return mv;
	}
	
	@RequestMapping("/update")
	public ModelAndView update(ReceiveTargetPo receiveTargetPo){
		ModelAndView mv=null;
		receiveTargetService.updateById(receiveTargetPo);
		mv=new ModelAndView("redirect:/ReceiveTarget/tolist.do");
		return mv;
	}
	
	@RequestMapping("/delete")
	public ModelAndView delete(String id){
		ModelAndView mv=null;
		String[] FenGe=id.split(",");
		for (int i = 0; i < FenGe.length; i++) {
			 receiveTargetService.deleteById(Integer.parseInt(FenGe[i]));
		}
		mv=new ModelAndView("redirect:/ReceiveTarget/tolist.do");
		return mv;
	}
	
	@ResponseBody
	@RequestMapping(value="/YZ")
	public Object YZ(String teamCode){
		int YorN=receiveTargetService.selectYZ(teamCode);
		Gson gson =new Gson();
		return gson.toJson(YorN);
	}
	

}
