<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<%@include file="/web/jsp/header.jsp"%>
		<title></title>
	</head>
	<body>
<div class="layui-collapse">
		<div class="layui-colla-item">
			<h2 class="layui-colla-title"></h2>
			<div class="layui-colla-content layui-show">
				<fieldset class="layui-elem-field layui-field-title"
					style="margin-top: 0px; padding: 5px">
					<legend>开启打分-选择部门，开启打分</legend>
					<form class="layui-form">
						<div class="layui-form-item">
							<label class="layui-form-label">部门</label>
							<div class="layui-input-inline">
								<select name="code" lay-filter="changeName"></select>
							</div>
							<label class="layui-form-label"></label> <span> <input
								type="button" class="layui-btn" lay-submit
								lay-filter="user_search" value="开启打分" onclick="openMark()" /> <input type="reset"
								class="layui-btn" value="重置" /> 
							</span>
						</div>
					</form>
				</fieldset>
			</div>
		</div>
	</div>
	<table id="demo" lay-filter="test"></table>
	<script type="text/javascript">
ajax("/department/search", {}, "json", function(d){
	var n=0;
		var html="<option value=''></option>";
		$.each(d.data,function(i,dom){
			html+="<option value='"+dom.code+"'>"+dom.name+"</option>";
			});
		$("select[name='code']").html(html);
		form.render();
		});
// 		禁用回车键
		function disableTextSubmit(e) {
		    if (e.keyCode == 13) {
		        return false;
		    }
		}
		function openMark(){
			ajax("/point/open", {code:$("select[name='code']").val()}, "text", function(d) {
				if (d == 1) {
					layer.msg('成功开启打分通道，现在用户可以正常进行打分了！');
				} else if(d==2){
					layer.msg('该部门未分配人员，无法开启，请先分配人员');
				} {
					layer.msg('开启失败，请联系管理员！');
				}
			});
		}
	</script>
</body>
</html>
