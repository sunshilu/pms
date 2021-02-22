package com.example.pms.system.controller;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
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
import com.example.pms.system.model.G_ReturnDataModel;
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
		UserModel um1 = (UserModel) session.getAttribute("currentUser");
		String currentUser = um1.getCode();
		String code = model.getCode();
		G_PointModel pointModel = new G_PointModel();
		if (FmtEmpty.isEmpty(code) || ("").equals(code)) {
			code = currentUser;
		}
		pointModel.setMemberCode(code);
//		List<G_PointModel> list = G_PointService.getList(pointModel);// 所有被查询人的得分记录
		String count = G_PointService.getCount(pointModel);// 被查询人的得分记录条数
		List<G_PointModel> unnames = G_PointService.getListGroupBYDate(pointModel);// 所有评分人

		// 按评分人将被查分人的得分记录，分组
		Map<String, List<G_PointModel>> groupMap = new HashMap<>();
		int n = 1;
		List<String> unnamesList = new ArrayList<>();
		for (G_PointModel unname : unnames) {
//			取出日期，放进集合方便以后使用
			unnamesList.add(unname.getDate());
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

		G_PointModel pointModel3 = new G_PointModel();
		List<G_PointModel> list3 = G_PointService.getListGroupBYTerms(pointModel3);
		List<G_ReturnDataModel> list = new ArrayList<>();
		/** 动态加载类 **/
		Class clazz;
		try {
			int h;
			for (int i = 0; i < list3.size(); i++) {
				G_ReturnDataModel returnModel = new G_ReturnDataModel();
				clazz = returnModel.getClass();
				/** 获取类声明的变量 **/
				Field[] fields = clazz.getDeclaredFields();
				returnModel.setTerms(list3.get(i).getTermCode());
				for (int j = 0; j < unnames.size(); j++) {
//					returnModel.setUnname01(unnamesList.get(i));
					Field field = fields[j + 1];
					/** 先获取变量名 **/
					String fieldName = field.getName();
					// 拼接set方法
					String setMethod = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
					// 调用clazz的getMethod方法获取类的指定get方法 通过invoke执行获取变量值
					@SuppressWarnings("unchecked")
					Method curMethod = clazz.getMethod(setMethod, String.class);
					// get后首字母大写
					// curMethod.invoke(model, value);
					h = j + 1;
					if (FmtEmpty.isEmpty(groupMap.get("un" + h).get(i).getGrade())
							|| "".equals(groupMap.get("un" + h).get(i).getGrade())) {
						continue;
					}
					curMethod.invoke(returnModel, groupMap.get("un" + h).get(i).getGrade());// curVO实体对象、value：set的参数值

				}
				list.add(returnModel);
			}
			for (G_ReturnDataModel rdm : list) {
				System.out.println("rdm:" + rdm);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
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
	@RequestMapping(value = "/test", produces = "application/json;charset=utf-8")
	public void test() {
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
		terms.add("1、品德修养、礼貌礼仪、个人仪容仪表");
		terms.add("2、有团队合作意识，能以集体利益为重");
		terms.add("3、沟通能力、亲和力、团结同事");
		terms.add("4、自我学习、工作总结能力");
		terms.add("5、主动发现问题、解决问题的态度和能力");
		terms.add("6、服从管理");
		terms.add("7、遵守法律法规以及公司规章制度");
		terms.add("1、对待工作责任心");
		terms.add("2、对待工作热情度");
		terms.add("3、能主动完成工作任务");
		terms.add("4、能寻求更好的方法来完成工作");
		terms.add("5、积极主动地配合其他岗位的工作，与同事及协作部门保持良好的协作关系");
		terms.add("1、专业业务知识");
		terms.add("2、相关专业知识");
		terms.add("3、办公软件和专业软件应用知识");
		terms.add("4、参加各种专业知识培训，不断学习专业知识和技能");
		terms.add("1、能保质保量完成工作任务");
		terms.add("2、能正确理解上级安排的工作，在执行过程中能主动调动各方资源以达成目标");
		terms.add("3、能准确地表达出自己的看法，在工作中善于沟通并保持良好的人际关系");
		terms.add("4、熟练掌握承担的工作");
		terms.add("5、工作认真、细致，考虑问题深入");
		terms.add("6、对问题认识全面，有系统性");
		terms.add("7、在承担工作上有发展潜力");

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
