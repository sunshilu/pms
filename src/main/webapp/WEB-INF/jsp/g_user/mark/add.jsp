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
						<form class="layui-form">
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
										<tr>
											<td>打分项1</td>
											<td><input type="number" name="t01_m01" value="1"></td>
											<td><input type="number" name="t01_m02" value="2"></td>
											<td><input type="number" name="t01_m03" value="3"></td>
											<td><input type="number" name="t01_m04" value="4"></td>
											<td><input type="number" name="t01_m05" value="5"></td>
										</tr>
										<tr>
											<td>打分项2</td>
											<td><input type="number" name="t02_m01" value="6"></td>
											<td><input type="number" name="t02_m02" value="7"></td>
											<td><input type="number" name="t02_m03" value="8"></td>
											<td><input type="number" name="t02_m04" value="9"></td>
											<td><input type="number" name="t02_m05" value="10"></td>
										</tr>
										<tr>
											<td>打分项3</td>
											<td><input type="number" name="t03_m01" value="11"></td>
											<td><input type="number" name="t03_m02" value="12"></td>
											<td><input type="number" name="t03_m03" value="13"></td>
											<td><input type="number" name="t03_m04" value="14"></td>
											<td><input type="number" name="t03_m05" value="15"></td>
										</tr>
									</tbody>
								</table>
							</div>
							<button type="button" onclick="add()">提交</button>
							<button type="button" onclick="">取消</button>
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
				$("input[type='number']").each(function(index, item) {
					var val = $(this).val(); //获取value值
					vals = vals + val + " ";
				});
				object['grade'] = vals;
				layer.msg("您已提交评分，请待系统录入后，再进行操作", {
					icon: 6,
					title: "提示",
					offset: "auto",
					skin: "layui-layer-molv"
				});
				ajax("/point/add", object, "json", function(d) {
					if (d = "1") {
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
		</script>
		<style>
			tr,
			td,
			th,
			thead {
				text-align: center;
			}
		</style>
	</body>
</html>
