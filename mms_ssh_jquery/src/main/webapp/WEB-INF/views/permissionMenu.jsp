<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path">${pageContext.request.contextPath}</c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>权限列表</title>
<link
	href="${path}/static/js/ligerUI/lib/ligerUI/skins/Aqua/css/ligerui-all.css"
	rel="stylesheet" type="text/css" />
<link
	href="${path}/static/js/ligerUI/lib/ligerUI/skins/ligerui-icons.css"
	rel="stylesheet" type="text/css" />
<style type="text/css">
mainBody_head, mainBody_font {
	border: solid 1px red;
}

li {
	width: 80px;
	display: inline-block;
}
td{
width: 80px;

}
</style>
<script src="${path}/static/js/ligerUI/lib/jquery/jquery-1.9.0.min.js"
	type="text/javascript"></script>
<script src="${path}/static/js/ligerUI/lib/ligerUI/js/core/base.js"
	type="text/javascript"></script>
	<script type="text/javascript" src="${path}/static/js/ligerUI/lib/jquery.cookie.js"></script>
<script
	src="${path}/static/js/ligerUI/lib/ligerUI/js/plugins/ligerGrid.js"
	type="text/javascript"></script>
<script
	src="${path}/static/js/ligerUI/lib/ligerUI/js/plugins/ligerDialog.js"
	type="text/javascript"></script>
<script
	src="${path}/static/js/ligerUI/lib/ligerUI/js/plugins/ligerMenu.js"
	type="text/javascript"></script>
<script
	src="${path}/static/js/ligerUI/lib/ligerUI/js/plugins/ligerMenuBar.js"
	type="text/javascript"></script>
<script
	src="${path}/static/js/ligerUI/lib/ligerUI/js/plugins/ligerToolBar.js"
	type="text/javascript"></script>
	<script src="${path}/static/js/ligerUI/lib/ligerUI/js/plugins/ligerFilter.js" type="text/javascript"></script>  
<script type="text/javascript">
	var grid;
	var dd;
	var d = {
		"text" : "aa"
	}
	function itemclick(item) {
		alert(item.text);
	}
	$(function() {

		$("#toptoolbar").ligerToolBar({
			items : [ {
				text : '增加',
				click :  function(item) {
					var select = getSelectData(item);
					var title='增加权限'
			
						openwin('${path}/sm/grantview/showAddPmsn',select,title);
				
					},
				icon : 'add'
			}, {
				line : true
			}, {
				icon : 'modify',
				text : '修改',
				click : function(item) {
					var select = getSelectData(item);
					if(select){
					 f_open(select)
					}
					},
			}, {
				line : true
			}, {
				icon : 'delete',
				text : '删除',
				click :function(item) {
						var pmsnId = getSelectData(item).pmsnId;
						if(pmsnId){
					      if(confirm("确定删除吗?")){
					    $.ajax({
					    	url:'${path}/sm/grant/deletePmsn',
					    	method:'post',
					    	dataType:'json',
					    	data:{
					    		pmsnId:pmsnId
					    	},
					    	success:function(data){
					    		alert("删除成功!")
					    	}
					    })
					    window.location.href='${path}/sm/grantview/showAllPmsn';
					    
					      }
					}
						},
			},{
				icon : 'config',
				text : '查询',
				click :function(item) {var pname = $('#table_t').val();
				var purl = $('#txtUrl').val();
				var pdes =$('#txtDescription').val();
				$("#logGrid").ligerGrid({
					columns : [ {
						display : '权限编号',
						name : 'pmsnId',
						align : 'left',
						width : 250
					}, {
						display : '权限名字:',
						name : 'pmsnName',
						width : 60
					}, {
						display : '权限URL',
						name : 'pmsnUrl',
						width : 250,
						align : 'left'
					}, {
						display : '创建人',
						name : 'pmsnCreateId',
						width : 60
					}, {
						display : '创建时间',
						name : 'pmsnCreateDatetime'
					}, {
						display : '操作人',
						name : 'pmsnUimId',
						width : 60
					}, {
						display : '修改时间',
						name : 'pmsnUpdateTime'
					} ],
					parms : {
						pmsnName:pname,
						pmsnUrl:purl,
						pmsnDescription:pdes
					},
					method : 'post',
					dataType : 'json',
					dataAction : 'local',
					url : '${path}/sm/grant/searchPmsn',
					pageSize : 10,
					pageSizeOptions : [ 5, 10, 20, 30, 40, 50 ],
					sortName : 'pmsnName',
					rownumbers : true,
					width : '100%',
					height : '100%',
					allowUnSelectRow : true
				});},
			} ]
		});
		
		grid = $("#logGrid").ligerGrid({
			columns : [ {
				display : '权限编号',
				name : 'pmsnId',
				align : 'left',
				width : 250
			}, {
				display : '权限名字:',
				name : 'pmsnName',
				width : 60
			}, {
				display : '权限URL',
				name : 'pmsnUrl',
				width : 250,
				align : 'left'
			}, {
				display : '创建人',
				name : 'pmsnCreateId',
				width : 60
			}, {
				display : '创建时间',
				name : 'pmsnCreateDatetime'
			}, {
				display : '操作人',
				name : 'pmsnUimId',
				width : 60
			}, {
				display : '修改时间',
				name : 'pmsnUpdateTime'
			} ],
			method : 'get',
			dataType : 'json',
			dataAction : 'local',
			url : '${path}/sm/grant/listAllPmsn',
			pageSize : 10,
			pageSizeOptions : [ 5, 10, 20, 30, 40, 50 ],
			sortName : 'pmsnName',
			rownumbers : true,
			width : '100%',
			height : '100%',
			allowUnSelectRow : true
		});
	});
	function openwin(url,select,title) {
		$.ligerDialog
				.open({
					height : 500,
					url : url,
					width : 750,
					name : 'addWindow',
					title : title,
					isResize : true,
					data:{
						name:select
					},
					myData: select,
					buttons : [
							 {
								text : '关闭',
								onclick : function(item, dialog) {
									dialog.close();
								}
							} ]
				});
	}
	//获取选择地方的信息
function getSelectData(item) {
	if(te == '增加'||te=='查询'){
			return 0;
	}
	else{
		var data = grid.getSelectedRow();
		if (!data) {
			var te = item.text;
			if(te == '修改'){
				alert("请选择要修改的信息!");
			}
			else if(te == '删除'){
				alert("请选择要删除的信息!")
			}
			return null;
		} else {
			/* alert(data.pmsnId); */
		}
		return data;
		}
	}
	
function f_open(row) {
	console.log(row);
	if (row != null) {
		$.cookie('pmsnId', row.pmsnId);
		$.ligerDialog.open({
			url : '${path}/sm/grantview/showUpdatePmsn',
			data : {
				pmsn : row
			},
			onClosed : function() {
				$.ligerDialog.success('修改成功');
				g.loadData();
			},
			height : 500,
			width : 750,
			title : '修改权限',
			isResize : true
		});
	} else {
		var m = $.ligerDialog.tip({
			title : '提示信息',
			content : '请选择你想要更新的行！'
		});
		setTimeout(function() {
			m.hide();
		}, 2000)
	}
}
function search(){
	
}
</script>
</head>
<body>
	<div id="mainBody">
		<div id="mainBody_head">
			<form id="serach_form">
			<select id="table_t" name="pmsnName">
                        <option>新增</option>
                        <option>删除</option>
                        <option>修改</option>
                        <option>查询</option>
                        </select>
                        
                
               
                     
                    	           
                        链接地址:
                        <input name="pmsnUrl" type="text" id="txtUrl" ltype="text" validate="{required:true,email:true}" />
                       
                   
                   
                   
                    
                        描述:
                        	<input id="txtDescription" name="pmsnDescription" type="text"/>
                    
                   
                
         <br />
        
			</form>
			<div id="topmenu"></div>
			<div id="toptoolbar"></div>
		</div>
		<div id="mainBody_font">
			<form id='form_show'>
				<div id="logGrid"></div>
			</form>
		</div>
	</div>

</body>
</html>