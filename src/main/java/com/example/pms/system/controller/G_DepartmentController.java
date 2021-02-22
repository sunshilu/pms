package com.example.pms.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.pms.system.model.G_DepartmentModel;
import com.example.pms.system.service.impl.G_DepartmentService;
import com.example.pms.util.FmtEmpty;

@Controller
@RequestMapping("/department")
public class G_DepartmentController {
	@Autowired
	private G_DepartmentService<G_DepartmentModel> departmentService;

	@ResponseBody
	@RequestMapping(value = "/search", produces = "application/json;charset=utf-8")
	public String search(G_DepartmentModel model) {
		String code = model.getCode();
		String name = model.getName();
		if (!FmtEmpty.isEmpty(code)) {
			model.setCode("%" + code + "%");
		}
		if (!FmtEmpty.isEmpty(name)) {
			model.setName("%" + name + "%");
		}
		List<G_DepartmentModel> list = departmentService.getList(model);
		String count = departmentService.getCount(model);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", list);
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", count);
		System.out.println(map);
		return new JSONObject(map).toString();

	}

	@ResponseBody
	@RequestMapping(value = "/add", produces = "application/json;charset=utf-8")
	public String add(G_DepartmentModel model) {
		String code = model.getCode();
		if (FmtEmpty.isEmpty(departmentService.selectModel(code))) {
			if (FmtEmpty.isEmpty(departmentService.insert(model))) {
				return "2";
			}
			return "0";
		}
		return "1";
	}

	@ResponseBody
	@RequestMapping("/del")
	public String del(String code) {
		if (!FmtEmpty.isEmpty(departmentService.selectModel(code))) {
			return departmentService.delModel(code) + "";
		}
		return "3";
	}

	@ResponseBody
	@RequestMapping(value = "/initUpd", produces = "application/json;charset=utf-8")
	public String initUpd(String code) {
		G_DepartmentModel model = departmentService.selectModel(code);
		return new JSONObject(model).toString();
	}

	@ResponseBody
	@RequestMapping(value = "/upd")
	public String upd(G_DepartmentModel model) {
		G_DepartmentModel um = departmentService.selectModel(model.getCode());
		if (!FmtEmpty.isEmpty(um)) {
			return departmentService.updModel(model) + "";
		}
		return "0";
	}

}
