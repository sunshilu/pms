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
			<h2 class="layui-colla-title">用户信息维护</h2>
			<div class="layui-colla-content layui-show">
				<fieldset class="layui-elem-field layui-field-title"
					style="margin-top: 0px; padding: 5px">
					<legend>用户信息-查询条件</legend>
					<form class="layui-form">
						<div class="layui-form-item">
							<label class="layui-form-label">账号</label>
							<div class="layui-input-inline">
								<input type="text" name="code" placeholder="请输入账号"
									autocomplete="off" class="layui-input">
							</div>
							<label class="layui-form-label">用户名</label>
							<div class="layui-input-inline">
								<input type="text" name="name" placeholder="请输入姓名"
									autocomplete="off" class="layui-input">
							</div>
							<label class="layui-form-label"></label> <span> <input
								type="button" class="layui-btn" lay-submit
								lay-filter="user_search" value="查询" onclick="refresh()" /> <input type="reset"
								class="layui-btn" value="重置" /> <input type="button"
								class="layui-btn" value="添加" onclick="openUserAdd()" />
							</span>
						</div>
						<div class="layui-form-item">
						<label class="layui-form-label"></label> <span> 
						<input type="button" class="layui-btn" value="导出excel" onclick="exportExcel()" />
						<input type="button" class="layui-btn" value="下载模板" onclick="downLoad()" /> 
						<input type="button" class="layui-btn" value="上传文件" id="upload"/>
							</span>
						</div>
					</form>
				</fieldset>
			</div>
		</div>
	</div>
	<table id="demo" lay-filter="test"></table>
	<script type="text/javascript">
	 upload.render({ //允许上传的文件后缀
		    elem: '#upload'
		    ,url: con.app+'/excel/upload'
		    ,accept: 'file' //普通文件
		    ,done: function(res){
		      console.log("34");
		    }
		  });
		refresh();
		function refresh() {
			 table.render({
				    elem: '#demo'
				    ,height: 550
				    ,url: con.app+'/user/search' //数据接口
				    ,page: true //开启分页
				    ,limit:10
				    ,limits:[10,20,30,40,50]
				    ,request:{
					    pageName:'pageIndex'
						    ,limitName:'pageLimit'}
				    ,where: {code:$("input[name='code']").val(),name:$("input[name='name']").val()}
				    ,cols: [[ //表头
					    {title:'全选',type:'checkbox',fixed:'left'},
					    {title:'序号',type:'numbers',fixed:'left'}
				      ,{field: 'code', title: '用户编号'}
				      ,{field: 'name', title: '姓名', sort: true}
				      ,{field: 'password', title: '密码'} 
				      ,{field: 'roleCode', title: '角色'}
				      ,{field: 'parentName', title: '上级人员', sort: true}
				      ,{field: 'parentDepartmentName', title: '上级部门', sort: true}
				      ,{title:'操作1',templet:"#tradd"}
				    ]]
				  });
		}
		function openUserAdd() {
			openLayer(con.jsp_url+"/WEB-INF/jsp/admin/user/add", refresh)
		}
		function openUserUpd(code) {
			openLayer(con.jsp_url+"/WEB-INF/jsp/admin/user/upd&code="+ code,
					refresh)
		}
		function delUser(code) {
			openConfirm(function(index) {
				ajax('/user/del', {
					code : code
				}, 'text', function(data) {
					console.log(data);
					if (data == 1) {
						layer.msg('删除成功');
						$("input[name='pageIndex']").val(1);
					} else if (data == 2) {
						layer.msg('删除失败--账号已被使用');
					} else if (data == 3) {
						layer.msg('删除失败--当前账号不存在');
					}
					refresh();
				})
			})
		}
		function exportExcel(){
// 			window.location.href=con.app+"/user/export";
			ajax("/user/export", {code:$("input[name='code']").val(),name:$("input[name='name']").val()}, "text", function(){
				console.log("1")});
				}
		
	</script>
	<script id="tradd" type="text/html">
    <input type='button' value='修改' class='layui-btn' 
           onclick='openUserUpd("{{ d.code }}")'/>&nbsp;
    <a href="javascript:delUser('{{ d.code }}')" 
       class="layui-btn layui-btn-xs layui-btn-danger">
        <i class="layui-icon layui-icon-delete"></i></a>&nbsp;
<input type='button' value='头像' class='layui-btn' 
           onclick='openHeadPhoto("{{ d.code }}")'/>
</script>
</body>
</html>