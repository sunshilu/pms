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
			<h2 class="layui-colla-title">个人得分情况</h2>
			<div class="layui-colla-content layui-show">
				<fieldset class="layui-elem-field layui-field-title"
					style="margin-top: 0px; padding: 5px">
					<legend>得分信息-查询条件</legend>
					<form class="layui-form">
						<div class="layui-form-item">
<!-- 							<label class="layui-form-label">商品编号</label> -->
<!-- 							<div class="layui-input-inline"> -->
<!-- 								<input type="text" name="code" placeholder="请输入" -->
<!-- 									autocomplete="off" class="layui-input"> -->
<!-- 							</div> -->
							<label class="layui-form-label">姓名</label>
							<div class="layui-input-inline">
								<input type="text" name="code" placeholder="请输入"
									autocomplete="off" class="layui-input" onkeydown="return disableTextSubmit(event)">
							</div>
							<label class="layui-form-label"></label> <span> <input
								type="button" class="layui-btn" lay-submit
								lay-filter="user_search" value="查询" onclick="refresh()" /> <input type="reset"
								class="layui-btn" value="重置" /> 
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
// 	 upload.render({ //允许上传的文件后缀
// 		    elem: '#upload'
// 		    ,url: con.app+'/excel/upload'
// 		    ,accept: 'file' //普通文件
// 		    ,done: function(res){
// 		      console.log("34");
// 		    }
// 		  });
		refresh();
		function refresh() {
			 table.render({
				    elem: '#demo'
				    ,height: 800
				    ,url: con.app+'/point/search' //数据接口
				    ,page: false //开启分页
				    ,request:{
					    pageName:'pageIndex'
						    ,limitName:'pageLimit'}
				    ,where: {code:$("input[name='code']").val()}
				    ,cols: [[ //表头
					    {title:'序号',type:'numbers',fixed:'left'},
				      {field: 'terms', title: '打分项', fixed: 'left',width:'550'}
					  ,{field: 'unname01', title: '匿名者1评分',width:'80'} 
				      ,{field: 'unname02', title: '匿名者2评分',width:'80'}
				      ,{field: 'unname03', title: '匿名者3评分',width:'80'}
				      ,{field: 'unname04', title: '匿名者4评分',width:'80'} 
				      ,{field: 'unname05', title: '匿名者5评分',width:'80'}
				      ,{field: 'unname06', title: '匿名者6评分',width:'80'}
				      ,{field: 'unname07', title: '匿名者7评分',width:'80'}
				    ]]
				  });
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