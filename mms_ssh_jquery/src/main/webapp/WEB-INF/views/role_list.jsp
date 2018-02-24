<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>roleList</title>
	<style type="text/css">
	    #menu1,.l-menu-shadow{top:30px; left:50px;}
	    #menu1{  width:200px;}
	</style>
		<link href="${cp}/static/js/ligerUI/lib/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />
		<link href="${cp}/static/js/ligerUI/lib/ligerUI/skins/ligerui-icons.css" rel="stylesheet" type="text/css" />
		<script src="${cp}/static/js/ligerUI/lib/jquery/jquery-1.9.0.min.js" type="text/javascript"></script>
		<script src="${cp}/static/js/ligerUI/lib/ligerUI/js/core/base.js" type="text/javascript"></script>
		<script src="${cp}/static/js/ligerUI/lib/ligerUI/js/plugins/ligerGrid.js" type="text/javascript"></script>
        <script src="${cp}/static/js/ligerUI/lib/ligerUI/js/plugins/ligerCheckBox.js" type="text/javascript"></script>
        <script src="${cp}/static/js/ligerUI/lib/ligerUI/js/plugins/ligerMenu.js" type="text/javascript"></script>
        <script src="${cp}/static/js/ligerUI/lib/ligerUI/js/plugins/ligerMenuBar.js" type="text/javascript"></script>
        <script src="${cp}/static/js/ligerUI/lib/ligerUI/js/plugins/ligerToolBar.js" type="text/javascript"></script>
        <script src="${cp}/static/js/ligerUI/lib/ligerUI/js/plugins/ligerDialog.js" type="text/javascript"></script>
<script type="text/javascript">
function at(rowindex){
	alert(rowindex);
}
function itemclick(item){
    if(item.text=="修改"){
	    	var obj=g.getSelected();
	    	if(obj==null){
	    		alert("请先选中行");
	    	}
	    	var id=obj.roleId;
    		$.ligerDialog.open({ 
        		url: 'goupdaterole?'+$.param({
        			roleId:id
        		}), 
        		title:'修改角色',
        		height: 324,width: 500
        		
        		});
    		
    }else if(item.text=="删除"){
    	if(obj==null){
    		alert("请先选中行");
    	}
		$.ajax({
			url:"role_delete",
			data:{"roleId":g.getSelected().roleId},
    		success:function(result){
         		alert(result);
         		window.location.href = "role_list";
    		}	
		});
    }
   
}
//菜单
$(function (){
	function TabReload(tabid) {
	    $("#maingrid").ligerGetTabManager().reload(tabid);
	}
    $("#toptoolbar").ligerToolBar({ items: [{
            text: '增加', click: function (item){
               // alert(item.text);
            	$.ligerDialog.open({ 
            		url: 'goaddrole', 
            		title:'新增角色',
            		height: 324,width: 500
            	} 
            	);
            }, icon:'add'},
		        { line:true },
		        { text: '修改', click: itemclick },
		        { line:true },
		        { text: '删除', click: itemclick }
		    ]
    });
});

//表格
	 	var g;
        $(function (){
            f_showCustomers(); 
        });
        //显示顾客
        function f_showCustomers(){
            g = $("#maingrid").ligerGrid({
                columns: [
                { display: '角色编号', name: 'roleId', align: 'center'},
                { display: '角色名称', name: 'roleName' },
                { display: '角色描述', name: 'roleDescription' },
                { display: '角色图标',name: 'roleIcon',
                	render : function (row) {
    			        //row    当前的行记录数据
    			       var img = "<img src='${cp}/static/img/icon/"+row.roleIcon+".ico'/>";
    			       return img;  //返回此单元格显示的HTML内容(一般根据row的列内容进行组织)
    			    }	
                },
                { display: '角色修改时间', name: 'roleUpdatedDatetime' },
                { display: '角色修改人', name: 'roleUpdatedUserId' }
                ],
 
		isScroll: false,
		frozen:false,
		pageSizeOptions: [3,10, 20, 30], 
		data:${roles},
		showTitle: false,
		width:'100%',
		detail: { onShowDetail: f_showOrder,height:'auto'},
		
		/* onDblClickRow : function (data, rowindex, rowobj)
		                {
		                 $.ligerDialog.alert('选择的是' + data.roleId);
		                } , */
		onError: function (a, b){ 
		                }
		            });
		        }
		       function f_getOrdersData(roleid){
		            var data = { Rows: [] };
		            for (var i = 0; i < ${users}.Rows.length; i++){
		                if (${users}.Rows[i].roleId == roleid)
		                    data.Rows.push(${users}.Rows[i]);
		            }
		            return data;
		        }
		        //显示顾客订单
		        function f_showOrder(row, detailPanel,callback){
		            var grid = document.createElement('div'); 
		            $(detailPanel).append(grid);
		            $(grid).css('margin',10).ligerGrid({
		                columns:
		                      [	  { display: '用户编号', name: 'userId'},
			                      { display: '用户名称', name: 'userName' },
			                      { display: '用户性别', name: 'userGender' },
			                      { display: '用户手机', name: 'userMobile' },
			                      { display: '用户邮箱', name: 'userEmail', width:150 },
			                      { display: '用户状态', name: 'userStatus' }],
						isScroll: false, 
						showToggleColBtn: false, 
						width:'656',
		                data: f_getOrdersData(row.roleId) ,
		                showTitle: false, 
		                columnWidth: 100,
		                onAfterShowData: callback,
		                frozen:false,
		                onContextmenu : function (parm,e){
		  		      	alert(parm.data.userId);
		  		         } 
		            });  
		        } 
</script>
</head>
<body>	 
		<div id="toptoolbar"></div>
	    <div id="maingrid"></div><br> 
	    <div style="display:none;"></div>
</body>
</html>