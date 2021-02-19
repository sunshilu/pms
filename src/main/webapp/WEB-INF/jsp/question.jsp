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
											<th style="text-align:center"></th>
											<th style="text-align:center">李利群</th>
											<th style="text-align:center">甘超</th>
											<th style="text-align:center">冯泽霖</th>
											<th style="text-align:center">孙世禄</th>
											<th style="text-align:center">张锡国</th>
											<input class="A" type="hidden" name="member01" value="李利群"></td>
											<input class="A" type="hidden" name="member02" value="甘超"></td>
											<input type="hidden" name="member03" value="冯泽霖"></td>
											<input type="hidden" name="member04" value="孙世禄"></td>
											<input type="hidden" name="member05" value="张锡国"></td>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>打分项1</td>
											<td><input type="number" name="t01_m01"></td>
											<td><input type="number" name="t01_m02"></td>
											<td><input type="number" name="t01_m03"></td>
											<td><input type="number" name="t01_m04"></td>
											<td><input type="number" name="t01_m05"></td>
										</tr>
										<tr>
											<td>打分项2</td>
											<td><input type="number" name="t02_m01"></td>
											<td><input type="number" name="t02_m02"></td>
											<td><input type="number" name="t02_m03"></td>
											<td><input type="number" name="t02_m04"></td>
											<td><input type="number" name="t02_m05"></td>
										</tr>
										<tr>
											<td>打分项3</td>
											<td><input type="number" name="t03_m01"></td>
											<td><input type="number" name="t03_m02"></td>
											<td><input type="number" name="t03_m03"></td>
											<td><input type="number" name="t03_m04"></td>
											<td><input type="number" name="t03_m05"></td>
										</tr>
									</tbody>
								</table>
							</div>
						</form>
					</fieldset>
				</div>
			</div>
		</div>
		<script type="text/javascript">
		var field;
		console.log($(".A").val());
// 		ajax("/pms/point/add", field, "json", function(d){
			
// 		});
		</script>
		<style>
		tr,td,th,thead {
		text-align: center;}
		</style
	</body>
</html>
