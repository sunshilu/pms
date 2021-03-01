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
			<h2 class="layui-colla-title">部门得分情况统计</h2>
			<div class="layui-colla-content layui-show">
				<fieldset class="layui-elem-field layui-field-title"
					style="margin-top: 0px; padding: 5px">
					<legend>得分信息-查询条件</legend>
					<form class="layui-form">
						<div class="layui-form-item">
<!-- 							<label class="layui-form-label">部门名</label> -->
<!-- 							<div class="layui-input-inline"> -->
<!-- 								<input type="text" name="name" placeholder="请输入" -->
<!-- 									autocomplete="off" class="layui-input" onkeydown="return disableTextSubmit(event)"> -->
<!-- 							</div> -->
							<label class="layui-form-label">部门</label>
							<div class="layui-input-inline">
								<select name="name" lay-filter="changeName"></select>
							</div>
							<label class="layui-form-label"></label> <span> <input
								type="button" class="layui-btn" lay-submit
								lay-filter="user_search" value="查询" onclick="refresh()" /> <input type="reset"
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
// 	 upload.render({ //允许上传的文件后缀
// 		    elem: '#upload'
// 		    ,url: con.app+'/excel/upload'
// 		    ,accept: 'file' //普通文件
// 		    ,done: function(res){
// 		      console.log("34");
// 		    }
// 		  });
ajax("/department/search", {}, "json", function(d){
	var n=0;
		var html="<option value=''></option>";
		$.each(d.data,function(i,dom){
			html+="<option value='"+dom.name+"'>"+dom.name+"</option>";
			});
		$("select[name='name']").html(html);
		form.render();
		});
		refresh();
		function refresh() {
			 table.render({
				    elem: '#demo'
				    ,height: 280
				    ,url: con.app+'/point/searchDepartmentCondition' //数据接口
				    ,page: false //开启分页
				    ,request:{
					    pageName:'pageIndex'
						    ,limitName:'pageLimit'}
				    ,where: {name:$("select[name='name']").val()}
				    ,cols: [[ //表头
				      {field: 'terms', title: '', fixed: 'left',width:'200'}
					  ,{field: 'unname01', title: '',width:'100',align:'center'}
					  ,{field: 'unname02', title: '',width:'100',align:'center'}
					  ,{field: 'unname03', title: '',width:'100',align:'center'}
					  ,{field: 'unname04', title: '',width:'100',align:'center'}
					  ,{field: 'unname05', title: '',width:'100',align:'center'}
					  ,{field: 'unname06', title: '',width:'100',align:'center'}
					  ,{field: 'unname07', title: '',width:'100',align:'center'}
				      ,{field: 'total', title: '',width:'100',align:'center'}
				      ,{field: 'rate', title: '',width:'300',align:'center'}
				    ]]
				    , done: function(res, curr, count){
				    	console.log(res);
				    	if(res.msg!=1){
				        layer.alert(res.msg, {
							icon: 6,
							title: "提示",
							offset: "auto",
							skin: "layui-layer-molv",
						});
				    	}
// 				    	var tableIns = table.render(options);
// 				    	 this.cols = []; //（关键代码）将cols初始化，否则表格重载时无法正确重新渲染表头
				      }
				  });
// 			    table.reload('demo',{
// 			        where:{
// 			            key:{
// 			                year:year,
// 			                month:month,
// 			            }
// 			        },
// 			        cols:[new_cols]  //使用新的表头
// 			    })
		}
		function openUserAdd() {
			openLayer(con.jsp_url+"/WEB-INF/jsp/business/product/add", refresh)
		}
		function openUserUpd(code) {
			openLayer(con.jsp_url+"/WEB-INF/jsp/business/product/upd&code="+ code,
					refresh)
		}
		function delUser(code) {
			openConfirm(function(index) {
				ajax('/product/del', {
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
			window.location.href=con.app+"/excel/export";
				}
// 		禁用回车键
		function disableTextSubmit(e) {
		    if (e.keyCode == 13) {
		        return false;
		    }
		}
		function openUrl(url) {
			
			window.open(con.app+"/unit/forward?url="+url, "rightframe");

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