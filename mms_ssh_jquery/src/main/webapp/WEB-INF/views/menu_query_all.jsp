<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
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
        	if('${msg}'!=null && '${msg}' != '' && '${msg}' != 'null'){
        		alert('${msg}');
        	};
            manager = $("#maingrid").ligerGrid({
            	url : '${cp}/menu/queryMenus?' + $.param({
				typeid : '1',
				parentid : '0',
				child : '1',
				headerImg :'${cp}/static/img/icon/cup.ico'
			}),
			columns : [ 
			{
				display : '图标',
				name : 'icon',
				width : '5%',
				align : 'left',
				render : function (row) {
			        //row    当前的行记录数据
			       var img = "<img src='${cp}/static/img/icon/"+row.icon+"'/>";
			        return img;  //返回此单元格显示的HTML内容(一般根据row的列内容进行组织)
			    }
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
        ms = $("#toptoolbar").ligerToolBar({
			items : [ {
				text : '增加',
				click : function(item) {
					var select= getSelectData(item);
					/* openAddForm(); */
					
					if(select || select==0){
						
						openwinByUpdate('${cp}/menu/addMenu',select.id,select.name);
					}
				},
				icon : 'add'
			}, {
				line : true
			}, {
				text : '修改基本信息',
				click : function(item){
					var select = getSelectData(item);
					var selectItem  = manager.getSelectedRow();
					var parent =manager.getParent(selectItem);
					var pId = "";
					var pName = "";
					if(parent != null){
						pId = parent.id;
						pName = parent.name;
					}
					
					
					openwinByUpdate('${cp}/menu/updateMenuForward',select.id,select.name,select.description,select.url,select.icon,pId,pName);
				}
			}, {
				line : true
			}, {
				text : '删除基本信息',
				click : function(item){
					var id = getSelectData(item).id;
					
					window.location.href= "${cp}/menu/deleteMenu?id="+id;
					top.location.reload();
				}
			}, {
				text : '关联',
				click : function(item){
					var select = getSelectData();
					alert(select.name);
					openwinByUpdate('${cp}/menu/forwardToRelation',select.id,select.name);
				}
			} ]
		});
        
      //弹框
    	
	});

	
</script>
<!-- 设置菜单 -->
<script type="text/javascript">
	/* 刷新方法 */
	function refresh(){
		window.location.href("${cp}/menu/queryAll");
	}

	
	
	
	/* 在选中的菜单下添加新的孩子 */
	function openwinByUpdate(url,select,name,description,urln,icon,pId,pName) {
		$.ligerDialog
				.open({
					height : 500,
					url : url,
					width : 800,
					name : 'wintest4',
					title : '对话框(确认或者双击带回)',
					isResize : true,
					data:{
						id:select,
						name:name,
						description:description,
						url:urln,
						icon:icon,
						pId:pId,
						pName:pName
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
	function getSelectData(item) {
		var data = manager.getSelectedRow();
		if (!data) {
			var te = item.text;
			if(te == '增加'){
				if(confirm("你是要添加到根目录")){
					return 0;
				}
			}else{
				alert("请选择要查看的菜单信息");
			}
			return null;
		} 
		return data;
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
	
		
		<div id="toptoolbar"></div>
		<div style="margin: 2px;">
			菜单： <input type="text" value="菜单" id="txtMenu"> 
			   &nbsp;&nbsp;<input type="button" value="查找" id="query" onclick="queryLike()">
		</div>
		<div id="addMenu" title="创建新的菜单"></div>
		<div id="maingrid"></div>
		
</body>
</html>