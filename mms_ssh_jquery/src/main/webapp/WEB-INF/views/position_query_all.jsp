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
            	onSelectRow:showAllUser,url : '${cp}/sm/position/getPositions',
			columns : [ 
			{
				display : '职位名称',
				name : 'name',
				width : '25%',
				type : 'int',
				align : 'left'
			},

			{
				display : '职位缩写',
				name : 'pAbbreviation',
				width : '8%',
				align : 'left'
			}, {
				display : '职位描述',
				name : 'description',
				width : '30%',
				align : 'left'
			}, {
				display : '创建日期',
				name : 'createDate',
				width : '30%',
				align : 'left'
			}, {
				display : '创建人名',
				name : 'createName',
				width : '10%',
				align : 'left',
				
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
			

		});   
            
        ms = $("#toptoolbar").ligerToolBar({
			items : [ {
				text : '增加',
				click : function(item) {
					
					/* openAddForm(); */
					
					
					openwin('${cp}/sm/position/addPositionForward');
					
				},
				icon : 'add'
			}, {
				line : true
			}, {
				text : '修改',
				click : function(item){
					var select = getSelectData();
					if(select){
						openwinUpdate('${cp}/sm/position/updatePositionForward',select.id,select.name,select.pAbbreviation,select.description);
					}
				}
			}, {
				line : true
			}, {
				text : '删除',
				click : function(item){
					var id = getSelectData().id;		
					window.location.href= "${cp}/sm/position/deletePosition?id="+id;
				}
			} ]
		});
        
      //弹框
    	
	});

	
</script>
<!-- 设置职位 -->
<script type="text/javascript">
	/* 刷新方法 */
	function refresh(){
		window.location.href("${cp}/position/queryAll");
	}

	/* 添加新的孩子弹窗 */
	function openwin(url) {
		$.ligerDialog
				.open({
					height : 500,
					url : url,
					width : 800,
					name : 'wintest4',
					title : '对话框(确认或者双击带回)',
					isResize : true,					
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
		var data = manager.getSelectedRow();
		if (!data) {
			//var te = item.text;
			
			alert("请选择要查看的菜单信息");	
			
			
		}else{
			return data;
		}
	}
	
	/* 添加新的孩子弹窗 */
	function openwinUpdate(url,id,name,pAbb,description) {
		$.ligerDialog
				.open({
					height : 500,
					url : url,
					width : 800,
					name : 'wintest4',
					title : '对话框(确认或者双击带回)',
					isResize : true,
					data:{
						id:id,
						name:name,
						pAbb:pAbb,
						description:description
					},
					buttons : [
							 {
								text : '关闭',
								onclick : function(item, dialog) {
									dialog.close();
								}
					} ]
				});
	}
	//选中一个职位显示所有该职位的人
	function showAllUser(rowdata, rowid, rowobj){
		alert(rowdata.id);
		//显示所有数据
        manager = $("#showAllPeople").ligerGrid({
        	url : '${cp}/sm/position/getPositionsDetail?'+$.param({
        		pId : rowdata.id
        	}),
		columns : [ 
		{
			display : '用户头像',
			name : 'userIcon',
			width : '10%',
			
			align : 'left'
		},

		{
			display : '用户姓名',
			name : 'userName',
			width : '20%',
			align : 'left'
		}, {
			display : '性别',
			name : 'userGender',
			width : '5%',
			align : 'left',
			render : function(rowData) {
				if (rowData.status == "0") {
					return "女";
				} else if(rowData.status == "1"){
					return "男";
				}else if(rowData.status == "2"){
					return "其他";
				}else {
					return "保密";
				}
			}
		}, {
			display : '用户座机',
			name : 'userPhone',
			width : '10%',
			align : 'left'
		}, {
			display : '用户手机',
			name : 'userMobile',
			width : '10%',
			align : 'left',
			
		} , {
			display : '用户邮箱',
			name : 'userEmail',
			width : '20%',
			align : 'left',
			
		}, {
			display : '部门名称',
			name : 'deptName',
			width : '8%',
			align : 'left',
			
		}, {
			display : '部门缩写',
			name : 'deptAB',
			width : '8%',
			align : 'left',
			
		}],
		width : '100%',
		pageSizeOptions : [ 5, 10, 15, 20 ],
		height : '97%',
		allowHideColumn : false,
		rownumbers : true,
		colDraggable : true,
		rowDraggable : true,
		checkbox : false,
		alternatingRow : false,
		

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
	
	
	//职位点击时间
	function itemclick(item) {
		if(item == '添加'){
			addChildrenData();
		}
	}
	
	//模糊查询
	function queryLike(){
		var txt = $('#txtPosition').val();
		
		window.location.href="${cp}/position/queryLikeForward?name="+txt;
		
	}
	
</script>
<style type="text/css">
#position1, .l-position-shadow {
	top: 30px;
	left: 50px;
}

#position1 {
	width: 200px;
}
</style>

</head>

<body>
	
		
		<div id="toptoolbar"></div>
		<div style="margin: 2px;">
			职位： <input type="text" value="职位" id="txtPosition"> 
			   &nbsp;&nbsp;<input type="button" value="查找" id="query" onclick="queryLike()">
		</div>
		<div id="addPosition" title="创建新的职位"></div>
		<div id="maingrid"></div>
		<div id="showAllPeople"></div>
		
</body>
</html>