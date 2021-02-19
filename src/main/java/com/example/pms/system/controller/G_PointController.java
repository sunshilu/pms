package com.example.pms.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.pms.system.model.G_PointModel;
import com.example.pms.system.service.impl.G_PointService;

@Controller
@RequestMapping("/point")
public class G_PointController {
	
	@Autowired
	private G_PointService<G_PointModel> G_PointService;
	
//	@ResponseBody
//	@RequestMapping(value = "/search", produces = "application/json;charset=utf-8")
//	public String search(ProductModel model) {
//		String code=model.getCode();
//		String name=model.getName();
//		if(!FmtEmpty.isEmpty(code)){
//			model.setCode("%"+code+"%");
//		}
//		if(!FmtEmpty.isEmpty(name)){
//			model.setName("%"+name+"%");
//		}
//		List<ProductModel> list=productService.getList(model);
//		String count=productService.getCount(model);
//		Map<String,Object> map=new HashMap<String, Object>();
//		map.put("data", list);
//		map.put("code", 0);
//		map.put("msg", "");
//		map.put("count", count);
//		System.out.println(map);
//		return new JSONObject(map).toString();
//
//	}
//	@ResponseBody
//	@RequestMapping(value = "/add", produces = "application/json;charset=utf-8")
//	public String add(G_OriginalDataModel model){
//		String code = model.getCode();
//		if (FmtEmpty.isEmpty(G_PointService.selectModel(code))) {
//			if (FmtEmpty.isEmpty(G_PointService.insert(model))) {
//				return "2";
//			}
//			return "0";
//		}
//		return "1";
//	}
//	@ResponseBody
//	@RequestMapping("/del")
//	public String del(String code){
//		if (!FmtEmpty.isEmpty(productService.selectModel(code))) {
//			return productService.delModel(code) + "";
//		}
//		return "3";
//	}
//	@ResponseBody
//	@RequestMapping(value="/initUpd",produces = "application/json;charset=utf-8")
//	public String initUpd(String code){
//		ProductModel model=productService.selectModel(code);
//		return new JSONObject(model).toString();
//	}
//	@ResponseBody
//	@RequestMapping(value="/upd")
//	public String upd(ProductModel model){
//		ProductModel um=productService.selectModel(model.getCode());
//		if (!FmtEmpty.isEmpty(um)) {
//			return productService.updModel(model) + "";
//		}
//		return "0";
//	}

}
