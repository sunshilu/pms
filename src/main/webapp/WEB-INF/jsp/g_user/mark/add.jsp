<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<%@include file="/web/jsp/header.jsp"%>
		<title>Insert title here</title>
	</head>
	<body>
		<div class="layui-collapse">
			<div class="layui-colla-item">
				<h2 class="layui-colla-title">工作绩效不记名打分</h2>
				<div class="layui-colla-content layui-show">
					<fieldset class="layui-elem-field layui-field-title" style="margin-top: 0px; padding: 5px">
						<legend>满分100，最小0，最大100</legend>
						<form class="layui-form" id="myform" action="${pageContext.request.contextPath}/point/test">
							<div class="layui-form-item">
								<table class="layui-table">
									<!-- 									<colgroup> -->
									<!-- 										<col width="150"> -->
									<!-- 										<col width="150"> -->
									<!-- 										<col width="200"> -->
									<!-- 										<col> -->
									<!-- 									</colgroup> -->
									<thead>
										<tr>
											<th style="text-align: center"></th>
											<th style="text-align: center">李利群</th>
											<th style="text-align: center">甘超</th>
											<th style="text-align: center">冯泽霖</th>
											<th style="text-align: center">孙世禄</th>
											<th style="text-align: center">张锡国</th>
											<input class="member" type="hidden" name="member01" value="李利群">
											</td>
											<input class="member" type="hidden" name="member02" value="甘超">
											</td>
											<input class="member" type="hidden" name="member03" value="冯泽霖">
											</td>
											<input class="member" type="hidden" name="member04" value="孙世禄">
											</td>
											<input class="member" type="hidden" name="member05" value="张锡国">
											</td>
										</tr>
									</thead>
									<tbody>
										<th style="text-align: center;">个人素质</th>
										<tr>
											<td>1、品德修养、礼貌礼仪、个人仪容仪表</td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
										</tr>
										<tr>
											<td>2、有团队合作意识，能以集体利益为重</td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
										</tr>
										<tr>
											<td>3、沟通能力、亲和力、团结同事</td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
										</tr>
										<tr>
											<td>4、自我学习、工作总结能力</td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
										</tr>
										<tr>
											<td>5、主动发现问题、解决问题的态度和能力</td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
										</tr>
										<tr>
											<td>6、服从管理</td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
										</tr>
										<tr>
											<td>7、遵守法律法规以及公司规章制度</td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
										</tr>
										<th style="text-align: center">工作态度</th>
										<tr>
											<td>1、对待工作责任心</td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
										</tr>
										<tr>
											<td>2、对待工作热情度</td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
										</tr>
										<tr>
											<td>3、能主动完成工作任务</td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
										</tr>
										<tr>
											<td>4、能寻求更好的方法来完成工作</td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
										</tr>
										<tr>
											<td>5、积极主动地配合其他岗位的工作，与同事及协作部门保持良好的协作关系</td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
										</tr>
										<th style="text-align: center">专业知识</th>
										<tr>
											<td>1、专业业务知识</td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
										</tr>
										<tr>
											<td>2、相关专业知识</td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
										</tr>
										<tr>
											<td>3、办公软件和专业软件应用知识</td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
										</tr>
										<tr>
											<td>4、参加各种专业知识培训，不断学习专业知识和技能</td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
										</tr>
										<th style="text-align: center">工作能力</th>
										<tr>
											<td>1、能保质保量完成工作任务</td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
										</tr>
										<tr>
											<td>2、能正确理解上级安排的工作，在执行过程中能主动调动各方资源以达成目标</td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
										</tr>
										<tr>
											<td>3、能准确地表达出自己的看法，在工作中善于沟通并保持良好的人际关系</td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
										</tr>
										<tr>
											<td>4、熟练掌握承担的工作</td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
										</tr>
										<tr>
											<td>5、工作认真、细致，考虑问题深入</td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
										</tr>
										<tr>
											<td>6、对问题认识全面，有系统性</td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
										</tr>
										<tr>
											<td>7、在承担工作上有发展潜力</td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input"></td>
											<td><input type="number" class="layui-input" lay-verify="required"></td>
										</tr>
									</tbody>
								</table>
							</div>
							<button type="button" class="layui-btn" onclick="add()">提交</button>
							<button type="button" class="layui-btn" onclick="re()">重置</button>
						</form>
					</fieldset>
				</div>
			</div>
		</div>
		<script type="text/javascript">
			function add() {
				var object = {};
				$("input[class='member']").each(function(index, item) {
					var name = $(this).attr("name"); //获取name值
					var val = $(this).val(); //获取value值
					object[name] = val;
				});
				var vals = "";
				var state = 0;
				$("input[type='number']").each(function(index, item) {
					var val = $(this).val(); //获取value值
					if (val == 0 || val == "") {
						state = 1;
					}
					vals = vals + val + " ";
				});
				if (state == 1) {
					layer.alert("所有评分均不能为空，请仔细检查填写未评分项", {
						icon: 6,
						title: "提示",
						offset: "auto",
						skin: "layui-layer-molv",
					});
					return
				}
				var load = layer.load();
				object['grade'] = vals;
				ajax("/point/add", object, "json", function(d) {
					if (d = "1") {
						layer.close(load);
						layer.msg("系统录入成功", {
							icon: 6,
							title: "提示",
							offset: "auto",
							skin: "layui-layer-molv"
						});
					} else {
						layer.msg("系统录入失败，请联系管理员", {
							icon: 6,
							title: "提示",
							offset: "auto",
							skin: "layui-layer-molv"
						});
					}
				});
			}

			function re() {
				layer.confirm("确定重置页面，重新填写？", {
					icon: 6,
					title: "提示",
					offset: "auto",
					skin: 'layui-layer-molv',
					anim: 5
				}, function(index) {
					layer.close(index);
					document.getElementById("myform").reset();
				});
			}
		</script>
		<style>
			thead {
				text-align: center;
			}
		</style>
	</body>
</html>
