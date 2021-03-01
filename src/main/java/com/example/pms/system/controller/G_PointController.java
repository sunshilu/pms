package com.example.pms.system.controller;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.pms.system.model.G_DepartmentModel;
import com.example.pms.system.model.G_OriginalDataModel;
import com.example.pms.system.model.G_PointModel;
import com.example.pms.system.model.G_PointRecordModel;
import com.example.pms.system.model.G_ReturnDataModel;
import com.example.pms.system.model.UserModel;
import com.example.pms.system.service.impl.G_DepartmentService;
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
	@Autowired
	private G_DepartmentService<G_DepartmentModel> G_DepartmentService;
	
//	@Autowired
//	private G_PointRecordService<G_PointRecordModel> G_PointRecordService;
	

	@ResponseBody
	@RequestMapping(value = "/search", produces = "application/json;charset=utf-8")
	public String search(UserModel model, HttpSession session) throws Exception {
		System.out.println(model);
		UserModel currentUser = (UserModel) session.getAttribute("currentUser");
		String currentUserCode = currentUser.getCode();
		String code = model.getCode();
		if (FmtEmpty.isEmpty(code) || ("").equals(code)) {
			code = currentUserCode;
			model = currentUser;
		}

//		Calendar c = Calendar.getInstance();
//		c.set(Calendar.DAY_OF_MONTH, 1);
//		Date startDate = c.getTime();
//		c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
//		Date endDate = c.getTime();

//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// 注意月份是MM
//		System.out.println(model.getStartDate());
//		if (model.getStartDate() != null && !"".equals(model.getStartDate())) {
//			startDate = parse(model.getStartDate(), "EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
//			System.out.println("model-startDate:_________" + startDate);
//		}
//		if (model.getEndDate() != null && !"".equals(model.getEndDate())) {
//			endDate = parse(model.getEndDate(), "EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
//		}
//		System.out.println("startDate:_________" + startDate);
//		System.out.println("endDate__________" + endDate);
		G_PointModel pointModel = new G_PointModel();
		pointModel.setMemberCode(code);
//		pointModel.setStartDate(startDate);
//		pointModel.setEndDate(endDate);
		List<G_PointModel> unnames = G_PointService.getListGroupBYDate(pointModel);// 按打分日期分组，找出 所有匿名评分人
		// 按评分人将被查分人的得分记录，分组
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
		G_PointModel pointModel3 = new G_PointModel();
		List<G_PointModel> list3 = G_PointService.getListGroupBYTerms(pointModel3);
		List<G_ReturnDataModel> list = new ArrayList<>();
		/** 动态拼接类属性 **/
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", list);
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", "0");
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
		UserModel um1 = (UserModel) session.getAttribute("currentUser");
		if (um1.getDepartmentCode().equals("d001")) {
			return "2";
		}
		if ("0".equals(um1.getMarkState())) {
			return "0";
		}
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
		g_PointModel.setDate(new Date());
		g_PointModel.setField1((Integer.parseInt(um1.getMarkTime()) + 1) + "");// 第n次绩效打分，对应用户的打分次数
		g_PointModel.setUserCode(um1.getCode());
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
		um1.setMarkState("0");
		um1.setMarkTime((Integer.parseInt(um1.getMarkTime()) + 1) + "");
		userService.updModel(um1);
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
	@ResponseBody
	@RequestMapping(value = "/searchDepartmentCondition", produces = "application/json;charset=utf-8")
	public String search2(G_DepartmentModel model, HttpSession session) {
		List<G_DepartmentModel> departments = G_DepartmentService.getList(model);// 查询的部门
		UserModel um1 = new UserModel();

		Map<String, Object> map = new HashMap<String, Object>();// 要返回的数据
		if (FmtEmpty.isEmpty(model.getName()) || ("").equals(model.getName())) {
			UserModel currentUser = (UserModel) session.getAttribute("currentUser");
			model = G_DepartmentService.selectModel(currentUser.getDepartmentCode());// 登录用户的部门
			if (model.getParentDepart().equals("00")) {
				map.put("data", new ArrayList<>());
				map.put("code", 0);
				map.put("msg", "用户不参与评分，请手动查询部门评分");
				map.put("count", "0");
				System.out.println(map);
				return new JSONObject(map).toString();
			}
			um1.setDepartmentCode(model.getCode());
		} else {

			um1.setDepartmentCode(departments.get(0).getCode());
		}
		um1.setState(1);
		List<UserModel> members = userService.getList(um1);
		G_PointModel pm1 = new G_PointModel();
		int sum;
		Integer total = 0;
		Map<String, String> user_grade = new HashMap<>();
		List<G_ReturnDataModel> returnList = new ArrayList<>();
		// 部门下没有成员时处理
		if (members.size() < 1) {
			map.put("data", new ArrayList<>());
			map.put("code", 0);
			map.put("msg", "该部门下没有部员，无法查分");
			map.put("count", "0");
			System.out.println(map);
			return new JSONObject(map).toString();
		}
		for (UserModel um : members) {
//			System.out.println(um);
//			验证是否部门内所有成员都已评分，方可进行查看
			if ("1".equals(um.getMarkState())) {
				map.put("data", new ArrayList<>());
				map.put("code", 0);
				map.put("msg", "评分未完成，待所有人评分完毕后，方可查看");
				map.put("count", "0");
				System.out.println(map);
				return new JSONObject(map).toString();
			}
			sum = 0;
			pm1.setMemberCode(um.getCode());
			List<G_PointModel> list = G_PointService.getList(pm1);
			for (G_PointModel pm : list) {
				sum += Integer.valueOf(pm.getGrade()).intValue();
				total += Integer.valueOf(pm.getGrade()).intValue();
			}
			user_grade.put(um.getCode(), sum + "");

		}
		// 计算每一分的权重
		int a = 700 * members.size();
		int b = total;
		// 部门总分为0，说明本部门未评分或不进行评分，处理
		if (total == 0) {
			map.put("data", new ArrayList<>());
			map.put("code", 0);
			map.put("msg", "本部门未评分或不进行评分，无法查分");
			map.put("count", "0");
			System.out.println(map);
			return new JSONObject(map).toString();
		}
		DecimalFormat df = new DecimalFormat("0.00");// 格式化小数
		String rate = df.format((float) a / b);// 返回的是String类型

		/** 动态加载类 **/
		Class clazz;
		try {
			G_ReturnDataModel rdm = new G_ReturnDataModel();
			clazz = rdm.getClass();
			Field[] fields = clazz.getDeclaredFields();
			rdm.setTerms("<h4 style='text-align:center;font-size:30px'>部员</h4>");
			for (int i = 0; i < members.size(); i++) {
				Field field = fields[i + 1];
				String fieldName = field.getName();
				String setMethod = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
				@SuppressWarnings("unchecked")
				Method curMethod = clazz.getMethod(setMethod, String.class);
				curMethod.invoke(rdm, members.get(i).getCode());// curVO实体对象、value：set的参数值

			}
			rdm.setTotal("部门总计");
			rdm.setRate("分值权重");
			returnList.add(rdm);

			G_ReturnDataModel rdm2 = new G_ReturnDataModel();
			clazz = rdm2.getClass();
			Field[] fields2 = clazz.getDeclaredFields();
			rdm2.setTerms("<h4 style='text-align:center;font-size:30px'>得分</h4>");
			for (int i = 0; i < members.size(); i++) {
				Field field = fields2[i + 1];
				String fieldName = field.getName();
				String setMethod = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
				@SuppressWarnings("unchecked")
				Method curMethod = clazz.getMethod(setMethod, String.class);
				curMethod.invoke(rdm2, user_grade.get(members.get(i).getCode()).toString());// curVO实体对象、value：set的参数值

			}

			rdm2.setTotal(total.toString() + "分");
			rdm2.setRate(rate + "元/分（每得1分获得" + rate + "元）");
			returnList.add(rdm2);

			// 计算绩效
			for (UserModel um : members) {
				BigDecimal a1 = new BigDecimal(700 * members.size());
				BigDecimal b1 = new BigDecimal(total);
				BigDecimal num1 = new BigDecimal(user_grade.get(um.getCode()));
				BigDecimal num2 = a1.divide(b1, 20, BigDecimal.ROUND_HALF_UP);
				BigDecimal result = num1.multiply(num2);
				DecimalFormat df1 = new DecimalFormat("0.00");// 格式化小数
				String performance = df1.format(result);// 返回的是String类型
				user_grade.put(um.getCode(), performance);
			}

			G_ReturnDataModel rdm3 = new G_ReturnDataModel();
			clazz = rdm3.getClass();
			Field[] fields3 = clazz.getDeclaredFields();
			rdm3.setTerms("<h4 style='text-align:center;font-size:30px'>绩效工资</h4>");
			for (int i = 0; i < members.size(); i++) {
				Field field = fields3[i + 1];
				String fieldName = field.getName();
				String setMethod = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
				@SuppressWarnings("unchecked")
				Method curMethod = clazz.getMethod(setMethod, String.class);
				curMethod.invoke(rdm3, user_grade.get(members.get(i).getCode()).toString());// curVO实体对象、value：set的参数值

			}

			rdm3.setTotal(a + "元");
			rdm3.setRate(rate + "元/分（每得1分获得" + rate + "元）");
			returnList.add(rdm3);
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("data", returnList);
		map.put("code", 0);
		map.put("msg", "1");
		map.put("count", "0");
		System.out.println(map);
		return new JSONObject(map).toString();

	}

//	开启打分通道，将要打分的用户markState设置为1；
	@ResponseBody
	@RequestMapping("/open")
	private String open(G_DepartmentModel department) {
		UserModel um1 = new UserModel();
		um1.setDepartmentCode(department.getCode());
		List<UserModel> list = userService.getListNoLimit(um1);
		String markTime;
		if (list.size() != 0) {
			markTime = list.get(0).getMarkTime();
//			markTime = (Integer.parseInt(markTime) + 1) + "";
		} else {
			return "2";
		}
		for (UserModel um : list) {
			if (!"d001".equals(um.getDepartmentCode()) && um.getDepartmentCode() != null) {
				um.setMarkState("1");
				if (!"1".equals(userService.updModel(um))) {
					return "0";
				}
			}
		}
//		G_PointRecordModel rm = new G_PointRecordModel();
//		rm.setCode(department.getCode() + markTime);
//		rm.setName(department.getCode() + "第"+markTime+"次打分");
//		rm.setPointMarkTime(markTime);
//		rm.setState(1);
//		rm.setTimeQuantum(new Date().toString());
//		rm.setDepartmentCode(department.getCode());
//		
		return "1";
	}

	public static Date parse(String str, String pattern, Locale locale) {
		if (str == null || pattern == null) {
			return null;
		}
		try {
			return new SimpleDateFormat(pattern, locale).parse(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
