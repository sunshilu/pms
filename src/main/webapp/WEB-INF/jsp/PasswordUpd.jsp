<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/web/jsp/header.jsp"%>
<title>Insert title here</title>
</head>
<body>
	<fieldset class="layui-elem-field" style="margin: 20px; padding: 15px;">
		<legend>修改密码</legend>
		<form class="layui-form" lay-filter="upduser" method="post">
			<div class="layui-form-item">
				<label class="layui-form-label">新密码:</label>
				<div class="layui-input-inline">
					<input type="text" lay-verify="required"
						placeholder="请输入新密码" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">确认新密码:</label>
				<div class="layui-input-inline">
					<input type="text" name="password" placeholder="请再次输入新密码"
						autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label"></label>
				<div class="layui-input-inline">
					<input type="button" class="layui-btn" lay-submit
						lay-filter="updUser" value="确定" /> <input type="button"
						class="layui-btn" onclick="closeThis()" value="取消" />
				</div>
			</div>
		</form>
	</fieldset>
	<script type="text/javascript">
// 		formSubmit(url, submit, dataType, func) {
// 		formSubmit('/user/updPassword', 'submit(updUser)', 'text', function(
// 				data) {
// 			if (data == 1) {
// 				layer.msg('修改成功');
// 				closeThis(1000);
// 			} else {
// 				layer.msg('修改失败');
// 			}
// 		});
		form.on('submit(updUser)', function(data) {
			console.log(data.field);
			var p=[2];
			$("input[type='text']").each(function(index,item){
				p[index]=$(this).val(); //获取value值
			});
			if(p[0]!=p[1]){
				layer.alert("请确保两次输入的密码相同", {
					icon: 6,
					title: "提示",
					offset: "auto",
					skin: "layui-layer-molv",
				});
				return;
			}
			ajax('/user/updPassword', data.field, 'text', function(
					data) {
				if (data == 1) {
					layer.msg('修改成功');
					closeThis(1000);
				} else {
					layer.msg('修改失败');
				}
			});
		});
	</script>
	<script id="tradd" type="text/html">
	<option value="{{d.value1}}">{{d.value}}</option>
</script>
</body>
</html>