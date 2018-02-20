<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

<link href="${cp}/static/js/ligerUI/lib/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet"
	type="text/css" />
<link rel="stylesheet" type="text/css" id="mylink" />
<script src="${cp}/static/js/ligerUI/lib/jquery/jquery-1.9.0.min.js"
	type="text/javascript"></script>
<script src="${cp}/static/js/ligerUI/lib/ligerUI/js/ligerui.all.js"
	type="text/javascript"></script>
<script src="${cp}/static/js/ligerUI/lib/jquery.cookie.js"></script>
<script src="${cp}/static/js/ligerUI/lib/json2.js"></script>
<script type="text/javascript">
        var g = null;
        $(function () {
        	
           //设置弹出表格
        	g = $("#maingrid4").ligerGrid({
        		 url: '${cp}/menu/menuUpdateLoad?'+$.param({
        			 
                 	id:${param.id}
                 }), 
        		columns: [
                { display: '菜单编号', name: 'id', align: 'left', width: 140 },
                { display: '菜单名称', name: 'name', width: 160, align: 'left' },  
                { display: '菜单描述', name: 'description', width: 130, minWidth: 60 }, 
                { display: '菜单链接', name: 'url' }
                ],  pageSize:10,
                     	
                width: '100%',height:'100%'
            }); 
            $("#pageloading").hide();
        });
        function f_select()
        {
            return g.getSelectedRow();
        }
    </script>
</head>
<body style="padding:6px; overflow:hidden;">
 
    <div id="maingrid4" style="margin:0; padding:0"></div>
 


  <div style="display:none;">
  <!-- g data total ttt -->
</div>
 
</body>

</html>