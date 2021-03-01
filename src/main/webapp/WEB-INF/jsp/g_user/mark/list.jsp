<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.pms.system.model.UserModel" %>
<!DOCTYPE html>
<html>
	<head>
		<%@include file="/web/jsp/header.jsp"%>
		<title>Insert title here</title>
	</head>
	<body>
		<div class="layui-collapse">
			<div class="layui-colla-item">
				<h2 class="layui-colla-title">个人得分情况</h2>
				<div class="layui-colla-content layui-show">
					<fieldset class="layui-elem-field layui-field-title" style="margin-top: 0px; padding: 5px;overflow:hidden;">
						<legend>得分信息-查询条件</legend>
						<form class="layui-form">
							<div class="layui-form-item">
								<label class="layui-form-label">姓名</label>
								<div class="layui-input-inline">
									<input type="text" name="code" placeholder="请输入" autocomplete="off" class="layui-input" onkeydown="return disableTextSubmit(event)">
								</div>
<!-- 								<div class="layui-inline" style="border:1px solid rgb(242,242,242);"> -->
<!-- 									<label class="layui-form-label">时间范围：</label> -->
<!-- 									<div class="layui-input-inline"> -->
<!-- 										<input type="text" class="layui-input" id="startDate" placeholder="yyyy-MM-dd"> -->
<!-- 									</div> -->
<!-- 									<div class="layui-input-inline"> -->
<!-- 										<input type="text" class="layui-input" id="endDate" placeholder="yyyy-MM-dd"> -->
<!-- 									</div> -->
<!-- 								</div> -->
								<label class="layui-form-label"></label> <span> <input type="button" class="layui-btn" lay-submit lay-filter="user_search"
									 value="查询" onclick="refresh()" /> <input type="reset" class="layui-btn" value="重置" />
								</span>
							</div>
							<!-- 						<div class="layui-form-item"> -->
							<!-- 						<label class="layui-form-label"></label> <span>  -->
							<!-- 						<input type="button" class="layui-btn" value="导出excel" onclick="exportExcel()" /> -->
							<!-- 						<input type="button" class="layui-btn" value="下载模板" onclick="downLoad()" />  -->
							<!-- 						<input type="button" class="layui-btn" value="上传文件" id="upload"/> -->
							<!-- 							</span> -->
							<!-- 						</div> -->
						</form>
					</fieldset>
				</div>
			</div>
		</div>
		<table id="demo" lay-filter="test"></table>
		<script type="text/javascript">
// 		var date = new Date(), 
// 		y = date.getFullYear(), 
// 		m = date.getMonth();
// 		var firstDay = new Date(y, m, 1);
// 		var lastDay = new Date(y, m + 1, 1);
// 		laydate.render({
// 			elem: '#startDate'
// 			,format: 'yyyy-MM-dd'
// 			,value: firstDay
// 			,isInitValue: true
// 		});
// 		laydate.render({
// 			elem: '#endDate'
// 			,format: 'yyyy-MM-dd'
// 			,value: lastDay
// 			,isInitValue: true
// 		});
		
			// 	 upload.render({ //允许上传的文件后缀
			// 		    elem: '#upload'
			// 		    ,url: con.app+'/excel/upload'
			// 		    ,accept: 'file' //普通文件
			// 		    ,done: function(res){
			// 		      console.log("34");
			// 		    }
			// 		  });
			refresh();
			console.log($("#startDate").val());
			function refresh() {
				table.render({
					elem: '#demo',
					height: 1000,
					url: con.app + '/point/search' //数据接口
						,
					page: false //开启分页
						,
					request: {
						pageName: 'pageIndex',
						limitName: 'pageLimit'
					},
					where: {
						code: $("input[name='code']").val()
						,startDate:$("#startDate").val()
						,endDate:$("#endDate").val()
					},
					cols: [
						[ //表头
							{
								title: '序号',
								type: 'numbers',
								fixed: 'left'
							},
							{
								field: 'terms',
								title: '打分项',
								fixed: 'left',
								width: '550',
								align: 'left',
								halign: 'center'
							}
							<%
					    List<UserModel> list=(List<UserModel>) request.getSession().getAttribute("members");
					    for(int m=1;m<=list.size();m++){
					    %>
							,{
								field: 'unname0<%=m%>',
								title: '匿名者<%=m%>的评分',
								width: '180',
								align: 'center'
							}
							<%	
					    }
					    %>
						]
					]
				});
			}

			function openUserAdd() {
				openLayer(con.jsp_url + "/WEB-INF/jsp/business/product/add", refresh)
			}

			function openUserUpd(code) {
				openLayer(con.jsp_url + "/WEB-INF/jsp/business/product/upd&code=" + code,
					refresh)
			}

			function delUser(code) {
				openConfirm(function(index) {
					ajax('/product/del', {
						code: code
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

			function exportExcel() {
				window.location.href = con.app + "/excel/export";
			}
			// 		禁用回车键
			function disableTextSubmit(e) {
				if (e.keyCode == 13) {
					return false;
				}
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
