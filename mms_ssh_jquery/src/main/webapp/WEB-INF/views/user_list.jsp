<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>  
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<link href="/mms_ssh_jquery/static/js/ligerUI/lib/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />
	<link href="/mms_ssh_jquery/static/js/ligerUI/lib/ligerUI/skins/ligerui-icons.css" rel="stylesheet" type="text/css" />
    <link href="/mms_ssh_jquery/static/js/ligerUI/lib/ligerUI/skins/Gray/css/all.css" rel="stylesheet" type="text/css" />
	<script src="/mms_ssh_jquery/static/js/ligerUI/lib/jquery/jquery-1.9.0.min.js" type="text/javascript"></script>
	<script src="/mms_ssh_jquery/static/js/ligerUI/lib/ligerUI/js/core/base.js" type="text/javascript"></script>
    <script src="/mms_ssh_jquery/static/js/ligerUI/lib/ligerUI/js/ligerui.all.js"></script>
    <script type="text/javascript">
        function itemclick(item){
            if(item.text=="修改"){
    	    	var obj=g.getSelected();
    	    	var id=obj.roleId;
        		$.ligerDialog.open({ 
            		url: 'goupdateuser?'+$.param({
            			roleId:id
            			}), 
            		title:'修改用户',
            		height: 600,width: 500,
            		buttons: [ { text: '关闭', onclick: function (item, dialog) { 
            						  dialog.close(); 
            					  } 
            				} 
            		]}
            	);
            
     	   }if(item.text=="增加"){
    		$.ligerDialog.open({ 
        		url: 'goadduser', 
        		title:'增加用户',
        		
        		height: 600,width: 500,
        		buttons: [ { text: '关闭', onclick: function (item, dialog) { 
        						  dialog.close(); 
        					  } 
        				} 
        		]}
        	);
   		   }else if(item.text=="删除"){
	    		$.ajax({
	    			url:"user_delete",
	    			data:{"userId":g.getSelected().userId},
	        		success:function(result){
	             		
	             			alert(result);    //TODO 解决外键
	             		
	             		window.location.href = "showusers";
	        		}	
	    		});
	        }
}
        $(function () {
            window['g'] =
            $("#maingrid").ligerGrid({
                height: '100%',
                columns: [
                { display: '登录名称', name: 'userLogon', align: 'left', width: 100, minWidth: 60 },
                { display: '用户姓名', name: 'userName', minWidth: 120 },
                { display: '性别', name: 'userGender', minWidth: 140 },
                { display: '用户手机', name: 'userMobile', minWidth: 120 },
                { display: '用户邮箱', name: 'userEmail', minWidth: 140 },
                { display: '用户微信', name: 'userWeiXin', minWidth: 120 },
                { display: '用户状态', name: 'userStatus', minWidth: 140 },
                { display: '操作时间', name: 'userUpdatedDateTime', minWidth: 120 },
                { display: '操作人名', name: 'userUpdatedName' }], 
                data:${users},
                pageSize: 30,
                rownumbers: true,
                toolbar: {
                    items: [
                    { text: '增加', click: itemclick, icon: 'add' },
                    { line: true },
                    { text: '修改', click: itemclick, icon: 'modify' },
                    { line: true },
                    { text: '删除', click: itemclick, img: '/mms_ssh_jquery/static/js/ligerUI/lib/ligerUI/skins/icons/delete.gif' }
                    ]
                },
                autoFilter: true
            });
             

            $("#pageloading").hide();
        });

        function deleteRow()
        {
            g.deleteSelectedRow();
        }

    </script>
</head>
<body style="overflow-x:hidden; padding:2px;">
<div class="l-loading" style="display:block" id="pageloading"></div>
 <a class="l-button" style="width:120px;float:left; margin-left:10px; display:none;" onclick="deleteRow()">删除选择的行</a>

 
 <div class="l-clear"></div>

    <div id="maingrid"></div>
   
  <div style="display:none;">
  
</div>
<body>

</body>
</html>