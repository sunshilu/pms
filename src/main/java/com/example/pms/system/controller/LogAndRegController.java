package com.example.pms.system.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.pms.system.model.MenuModel;
import com.example.pms.system.model.RootModel;
import com.example.pms.system.model.UserModel;
import com.example.pms.system.service.impl.RootService;
import com.example.pms.system.service.impl.UserService;
import com.example.pms.util.FmtEmpty;

@Controller
@RequestMapping("/loginAndReg")
public class LogAndRegController {
	@Autowired
	private UserService<UserModel> userService;
	@Autowired
	private RootService<RootModel> rootService;

	@RequestMapping("/login")
	private String login(UserModel um, HttpSession session, Model model) {
		String msg;
		String view = null;
		System.out.println(um);
		UserModel um1 = userService.selectModel(um.getCode());
		if (!FmtEmpty.isEmpty(um1)) {
			if (um1.getPassword().trim().equals(um.getPassword().trim())) {
				session.setAttribute("userCode", um1);
				model.addAttribute("menu", getMenu(um1));
				view = "/WEB-INF/jsp/question";
				msg = "登录成功！";
			} else {
				view = "/web/jsp/failed";
				msg = "密码错误！";
			}

		} else {
			view = "/web/jsp/failed";
			msg = "账号不存在";
		}
		System.out.println("msg" + msg);
		model.addAttribute("msg", msg);
		return view;
	}

	public List<MenuModel> getMenu(UserModel um1) {
		String roleCode = um1.getRoleCode();
		if (FmtEmpty.isEmpty(roleCode)) {
			return null;
		}
		RootModel rm = new RootModel();
		rm.setRoleCode(roleCode);
		rm.setOrderBy("menu_code");
		List<RootModel> list = rootService.getList(rm);
		List<MenuModel> list2 = new ArrayList<>();
		for (RootModel rm1 : list) {
			if (rm1.getMenuModel().getParentCode().equals("00")) {
				list2.add(rm1.getMenuModel());
				continue;
			}
			for (MenuModel mm : list2) {
				if (rm1.getMenuModel().getParentCode().equals(mm.getCode())) {
					mm.getChild().add(rm1.getMenuModel());
				}
			}
		}
		System.out.println(list2);
		return list2;
	}

	@RequestMapping("/loginOut")
	private String loginOut(UserModel userCode, HttpSession session) {
		session.removeAttribute("userCode");
		return "/web/jsp/login";
	}

	@RequestMapping("/login2")
	private String login2(UserModel um, HttpSession session, Model model) {
		String msg;
		String view = null;
		System.out.println(um.getCode());
		UserModel um1 = userService.selectModel(um.getCode());
		if (!FmtEmpty.isEmpty(um1)) {
			if (um1.getPassword().trim().equals(um.getPassword().trim())) {
				session.setAttribute("currentUser", um1);
				List<MenuModel> menu = getMenu(um1);
				model.addAttribute("menu", menu);
				// 人员登录后将人员所在部门的所有成员存入session方便生成页面
				List<UserModel> members = getMembers(um1);
				session.setAttribute("members", members);
				session.setAttribute("searchMembers", members);//全部门查询时使用的成员，点击查询后会变成要查询的部门成员
				// 登录后将所有的打分项存入session 方便生成页面
				Map<String, List<String>> terms = getTerms();
				session.setAttribute("terms", terms);
//					List<MenuModel> menus=new ArrayList<>();
//					MenuModel menu=new MenuModel();
//					
//					model.addAttribute("menu",menus);
				view = "/WEB-INF/jsp/main2";
				msg = "登录成功！";
			} else {
				view = "/web/jsp/failed";
				msg = "密码错误！";
			}

		} else {
			view = "/web/jsp/failed";
			msg = "账号不存在";
		}
		System.out.println("msg" + msg);
		model.addAttribute("msg", msg);
		return view;
	}

	private List<UserModel> getMembers(UserModel um1) {
		UserModel um = new UserModel();
		um.setDepartmentCode(um1.getDepartmentCode());
		List<UserModel> list = userService.getList(um);
		return list;
	}

	private Map<String, List<String>> getTerms() {
		Map<String, List<String>> map = new HashMap<>();
		List<String> list1 = new ArrayList<>();
		list1.add("1、品德修养、礼貌礼仪、个人仪容仪表");
		list1.add("2、有团队合作意识，能以集体利益为重");
		list1.add("3、沟通能力、亲和力、团结同事");
		list1.add("4、自我学习、工作总结能力");
		list1.add("5、主动发现问题、解决问题的态度和能力");
		list1.add("6、服从管理");
		list1.add("7、遵守法律法规以及公司规章制度");
		List<String> list2 = new ArrayList<>();
		list2.add("1、对待工作责任心");
		list2.add("2、对待工作热情度");
		list2.add("3、能主动完成工作任务");
		list2.add("4、能寻求更好的方法来完成工作");
		list2.add("5、积极主动地配合其他岗位的工作，与同事及协作部门保持良好的协作关系");
		List<String> list3 = new ArrayList<>();
		list3.add("1、专业业务知识");
		list3.add("2、相关专业知识");
		list3.add("3、办公软件和专业软件应用知识");
		list3.add("4、参加各种专业知识培训，不断学习专业知识和技能");
		List<String> list4 = new ArrayList<>();
		list4.add("1、能保质保量完成工作任务");
		list4.add("2、能正确理解上级安排的工作，在执行过程中能主动调动各方资源以达成目标");
		list4.add("3、能准确地表达出自己的看法，在工作中善于沟通并保持良好的人际关系");
		list4.add("4、熟练掌握承担的工作");
		list4.add("5、工作认真、细致，考虑问题深入");
		list4.add("6、对问题认识全面，有系统性");
		list4.add("7、在承担工作上有发展潜力");
		map.put("list1", list1);
		map.put("list2", list2);
		map.put("list3", list3);
		map.put("list4", list4);
		return map;
	}
}
