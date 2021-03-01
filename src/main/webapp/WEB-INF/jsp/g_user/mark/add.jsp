<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--输出,条件,迭代标签库-->
<!DOCTYPE html>
<html>
	<head>
		<%@include file="/web/jsp/header.jsp"%>
		<title>Insert title here</title>
		<style>
			input {
			"border:0px; width:30px; height:25px; background-color:#333; font-size:12px; color:#fff;"
		}
		</style>
	</head>
	<body>
		<div class="layui-collapse" style="overflow:visible">
			<div class="layui-colla-item" style="overflow:visible">
				<h2 class="layui-colla-title">考核标准以及分数</h2>
				<div class="layui-colla-content layui-show" style="overflow:visible">
					<fieldset class="layui-elem-field layui-field-title" style="margin-top: 0px; padding: 5px;overflow:visible">
						<legend>优秀（5分） 良好（4分） 一般（3分） 差（2分）</legend>
						<form id="myform" action="${pageContext.request.contextPath}/point/test">
							<div class="layui-form-item">
								<table class="layui-table">
									<thead>
										<tr>
											<th style="text-align: center"></th>
											<%int i=1;%>
											<c:forEach items="${members}" var="l">
												<th style="text-align: center">${l.code}</th>
												<input class="member" type="hidden" name="member0<%=i%>" value="${l.code}">
												<%i++;%>
											</c:forEach>
										</tr>
									</thead>
									<tbody>
										<th style="text-align: center;">个人素质</th>
										<%
										int n=0;
										%>
										<c:forEach items="${terms.list1}" var="term">
											<tr>
												<td>${term}</td>
												<c:forEach items="${members}" var="l">
													<td>
														<div class="layui-form-item" pane="" style="text-align:center; width:200px;margin:0 auto;">
															<div class="layui-input-inline">
																<input type="radio" name="number<%=n%>" value="5">
																<input type="radio" name="number<%=n%>" value="4">
																<input type="radio" name="number<%=n%>" value="3">
																<input type="radio" name="number<%=n%>" value="2">
															</div>
															<div class="layui-input-inline" style="text-align:center; width:180px;margin:0 auto;">
																<p style="display:inline">优秀&nbsp;</p>
																<p style="display:inline">良好&nbsp;</p>
																<p style="display:inline">一般&nbsp;</p>
																<p style="display:inline">差</p>
															</div>
														</div>
													</td>
													<%n++;%>
												</c:forEach>
											</tr>
										</c:forEach>
<!-- 										// -->
										
										<th style="text-align: center">工作态度</th>
										<c:forEach items="${terms.list2}" var="term">
											<tr>
												<td>${term}</td>
												<c:forEach items="${members}" var="l">
													<td>
														<div class="layui-form-item" pane="" style="text-align:center; width:200px;margin:0 auto;">
															<div class="layui-input-inline">
																<input type="radio" name="number<%=n%>" value="5">
																<input type="radio" name="number<%=n%>" value="4">
																<input type="radio" name="number<%=n%>" value="3">
																<input type="radio" name="number<%=n%>" value="2">
															</div>
															<div class="layui-input-inline" style="text-align:center; width:180px;margin:0 auto;">
																<p style="display:inline">优秀&nbsp;</p>
																<p style="display:inline">良好&nbsp;</p>
																<p style="display:inline">一般&nbsp;</p>
																<p style="display:inline">差</p>
															</div>
														</div>
													</td>
													<%n++;%>
												</c:forEach>
											</tr>
										</c:forEach>
										<th style="text-align: center">专业知识</th>
										<c:forEach items="${terms.list3}" var="term">
											<tr>
												<td>${term}</td>
												<c:forEach items="${members}" var="l">
													<td>
														<div class="layui-form-item" pane="" style="text-align:center; width:200px;margin:0 auto;">
															<div class="layui-input-inline">
																<input type="radio" name="number<%=n%>" value="5">
																<input type="radio" name="number<%=n%>" value="4">
																<input type="radio" name="number<%=n%>" value="3">
																<input type="radio" name="number<%=n%>" value="2">
															</div>
															<div class="layui-input-inline" style="text-align:center; width:180px;margin:0 auto;">
																<p style="display:inline">优秀&nbsp;</p>
																<p style="display:inline">良好&nbsp;</p>
																<p style="display:inline">一般&nbsp;</p>
																<p style="display:inline">差</p>
															</div>
														</div>
													</td>
													<%n++;%>
												</c:forEach>
											</tr>
										</c:forEach>
										<th style="text-align: center">工作能力</th>
										<c:forEach items="${terms.list4}" var="term">
											<tr>
												<td>${term}</td>
												<c:forEach items="${members}" var="l">
													<td>
														<div class="layui-form-item" pane="" style="text-align:center; width:200px;margin:0 auto;">
															<div class="layui-input-inline">
																<input type="radio" name="number<%=n%>" value="5">
																<input type="radio" name="number<%=n%>" value="4">
																<input type="radio" name="number<%=n%>" value="3">
																<input type="radio" name="number<%=n%>" value="2">
															</div>
															<div class="layui-input-inline" style="text-align:center; width:180px;margin:0 auto;">
																<p style="display:inline">优秀&nbsp;</p>
																<p style="display:inline">良好&nbsp;</p>
																<p style="display:inline">一般&nbsp;</p>
																<p style="display:inline">差</p>
															</div>
														</div>
													</td>
													<%n++;%>
												</c:forEach>
											</tr>
										</c:forEach>
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
				var sum = 0;
				$('input:radio:checked').each(function(index, item) {
					var val = $(this).val(); //获取value值
					sum += 1
					vals = vals + val + " ";
				});
				console.log(vals);
				if (sum != (23*<%=i-1%>)) {
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
					if (d == "1") {
						layer.close(load);
						layer.msg("系统录入成功", {
							icon: 6,
							title: "提示",
							offset: "auto",
							skin: "layui-layer-molv"
						});
					} else if (d == "0") {
						layer.close(load);
						layer.msg("每人只有一次评分机会，请勿重复提交", {
							icon: 6,
							title: "提示",
							offset: "auto",
							skin: "layui-layer-molv"
						});
					} else if (d == "2") {
						layer.close(load);
						layer.msg("用户不参与评分,请勿提交", {
							icon: 6,
							title: "提示",
							offset: "auto",
							skin: "layui-layer-molv"
						});
					} else {
						layer.close(load);
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
			input {
				border: 0px;
				width: 30px;
				height: 25px;
				background-color: #333;
				font-size: 12px;
				color: #fff;
			}
		</style>
	</body>
</html>
