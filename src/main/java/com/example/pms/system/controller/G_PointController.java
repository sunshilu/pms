package com.example.pms.system.controller;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.pms.system.model.G_OriginalDataModel;
import com.example.pms.system.model.G_PointModel;
import com.example.pms.system.model.UserModel;
import com.example.pms.system.service.impl.G_PointService;
import com.example.pms.system.service.impl.UserService;
import com.example.pms.util.FmtEmpty;

@Controller
@RequestMapping("/point")
public class G_PointController {

	@Autowired
	private G_PointService<G_PointModel> G_PointService;
	@Autowired
	private UserService<UserModel> userService;

	@ResponseBody
	@RequestMapping(value = "/search", produces = "application/json;charset=utf-8")
	public String search(UserModel model, HttpSession session) {
		UserModel um1 =(UserModel) session.getAttribute("currentUser");
		String code=um1.getCode();
		System.out.println(code);
		G_PointModel pointModel = new G_PointModel();
		if (!FmtEmpty.isEmpty(code)) {
			pointModel.setMemberCode(code);
		}
		List<G_PointModel> list = G_PointService.getList(pointModel);
		System.out.println(list.get(0));
		String count = G_PointService.getCount(pointModel);
		List<G_PointModel> unnames = G_PointService.getListGroupBYDate(pointModel);
		Map<String, List<G_PointModel>> groupMap = new HashMap<>();
		int n = 1;
		for (G_PointModel unname : unnames) {
			G_PointModel pointModel2 = new G_PointModel();
			pointModel2.setMemberCode(code);
			pointModel2.setDate(unname.getDate());
			List<G_PointModel> list2 = G_PointService.getList(pointModel2);
			groupMap.put("un" + n, list2);
			n++;
		}
		System.out.println(groupMap.get("un1"));
		System.out.println(groupMap.get("un2"));
		System.out.println(groupMap.get("un3"));
		System.out.println(groupMap.get("un4"));
		System.out.println(groupMap.get("un5"));

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", list);
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", count);
		System.out.println(map);
		return new JSONObject(map).toString();

	}

	public static List<String> reflect(G_OriginalDataModel model) {
		int count = 0;
		Class cls = model.getClass();
		Field[] fields = cls.getDeclaredFields();
		List<String> list = new ArrayList<>();
		for (int i = 0; i < fields.length - 1; i++) {
			Field f = fields[i];
			f.setAccessible(true);
			try {
				if (!FmtEmpty.isEmpty(f.get(model))) {
					count += 1;
					list.add(f.get(model).toString());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@ResponseBody
	@RequestMapping(value = "/add", produces = "application/json;charset=utf-8")
	public String add(G_OriginalDataModel model, HttpSession session) {
		session.getAttribute("userCode");
		List<String> list = reflect(model);
		String grade = model.getGrade();
		grade.trim(); // 去掉首尾空格
		String[] grades = grade.split("\\s+");
		G_PointModel g_PointModel = new G_PointModel();
		List<String> terms = new ArrayList<>();
		terms.add("打分项1");
		terms.add("打分项2");
		terms.add("打分项3");
		int i = 0;
		g_PointModel.setDate(new Date().toString());
		for (String term : terms) {
			g_PointModel.setTermCode(term);
			for (String p : list) {
				g_PointModel.setMemberCode(p);
				g_PointModel.setGrade(grades[i]);
				if (FmtEmpty.isEmpty(G_PointService.insert(g_PointModel))) {
					return "0";
				}
				i++;
			}
		}
		return "1";
	}
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
