<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>动态创建表格</title>
<link href="${cp}/static/js/ligerUI/lib/ligerUI/skins/Aqua/css/ligerui-all.css"
	rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" id="mylink" />
<style type="text/css">
	.error{padding: .3em;font-color:red}
</style>

<script src="${cp}/static/js/ligerUI/lib/jquery/jquery-1.9.0.min.js"
	type="text/javascript"></script>
<script src="${cp}/static/js/ligerUI/lib/ligerUI/js/ligerui.all.js"
	type="text/javascript"></script>
<script src="${cp}/static/js/ligerUI/lib/jquery.cookie.js"></script>
<script src="${cp}/static/js/ligerUI/lib/json2.js"></script>
<script type="text/javascript">
        var manager;
        $(function ()
        {
            manager = $("#maingrid").ligerGrid({
            	url : '${cp}/menu/queryLike?' + $.param({
				typeid : '1',
				parentid : '0',
				child : '1',
				name:'${name}'
            }),
			columns : [ {
				display : 'id',
				name : 'id',
				id : 'id1',
				width : '5%',
				align : 'left'
			}, {
				display : '菜单图标',
				name : 'icon',
				width : '5%',
				align : 'left'
			}, {
				display : '菜单名称',
				name : 'name',
				width : '25%',
				type : 'int',
				align : 'left'
			},

			{
				display : '菜单链接',
				name : 'url',
				width : '25%',
				align : 'left'
			}, {
				display : '菜单等级',
				name : 'nLevel',
				width : '3%',
				align : 'left'
			}, {
				display : '菜单描述',
				name : 'description',
				width : '30%',
				align : 'left'
			}, {
				display : '菜单状态',
				name : 'status',
				width : '10%',
				align : 'left',
				render : function(rowData) {
					if (rowData.status == "0") {
						return "未激活";
					} else {
						return "激活";
					}
				}
			} ],
			width : '100%',
			pageSizeOptions : [ 5, 10, 15, 20 ],
			height : '97%',
			allowHideColumn : false,
			rownumbers : true,
			colDraggable : true,
			rowDraggable : true,
			checkbox : false,
			alternatingRow : false,
			tree : {
				columnName : 'name'
			},

		});
        $("#toptoolbar").ligerToolBar({
			items : [ {
				text : '增加',
				click : function(item) {
					var select = getSelectData();
					/* openAddForm(); */
					if(select){
						openwin('${cp}/menu/addMenu',select);
					}
				},
				icon : 'add'
			}, {
				line : true
			}, {
				text : '修改',
				click : function(){
					getSelectData();
				}
			}, {
				line : true
			}, {
				text : '删除',
				click : function(){
					getSelectData();
				}
			} ]
		});
        
      //弹框
    	
	});

	
</script>
<!-- 设置菜单 -->
<script type="text/javascript">
	/* 在选中的菜单下添加新的孩子 */
	function openwin(url,select) {
		$.ligerDialog
				.open({
					height : 400,
					url : url,
					width : 600,
					name : 'wintest4',
					title : '对话框(确认或者双击带回)',
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
	
	//检查长度是否合法和为空
	function checkLength(data,min,max){
		if(data== null|| data.val().length>max || data.val().length<min){
			data.addClass("error");
			return false;
		}else{
			return true;
		}
		
	}
	
	//获取选择地方的信息
	function getSelectData() {
		var data = manager.getSelectedRow();
		if (!data) {
			alert("请选择要查看的菜单信息");
			return null;
		} else {
			alert(data.id);
		}
		return data.id;
	}
	//菜单点击时间
	function itemclick(item) {
		if(item == '添加'){
			addChildrenData();
		}
	}
	
	//模糊查询
	function queryLike(){
		var txt = $('#txtMenu').val();
		
		window.location.href="${cp}/menu/queryLikeForward?name="+txt;
		
	}
	
</script>
<style type="text/css">
#menu1, .l-menu-shadow {
	top: 30px;
	left: 50px;
}

#menu1 {
	width: 200px;
}
</style>

</head>

<body>
	<div>
		
		<div id="toptoolbar"></div>
		<div style="margin: 2px;">
			【查询】 菜单： <input type="text" value="菜单" id="txtMenu"> 
			   &nbsp;&nbsp;<input type="button" value="查找" id="query" onclick="queryLike()">
		</div>
		<div id="addMenu" title="创建新的菜单"></div>
		<div id="maingrid"></div>
		
</body>
</html>