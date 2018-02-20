<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
    <link href="${cp}/static/js/ligerUI/lib/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet"
        type="text/css" />
    <script src="${cp}/static/js/ligerUI/lib/jquery/jquery-1.9.0.min.js" type="text/javascript"></script>
    <script src="${cp}/static/js/ligerUI/lib/ligerUI/js/core/base.js" type="text/javascript"></script>
    <script src="${cp}/static/js/ligerUI/lib/ligerUI/js/plugins/ligerCheckBox.js" type="text/javascript"></script>
    <script src="${cp}/static/js/ligerUI/lib/ligerUI/js/plugins/ligerComboBox.js" type="text/javascript"></script>
    <script src="${cp}/static/js/ligerUI/lib/ligerUI/js/plugins/ligerResizable.js" type="text/javascript"></script> 
    <script src="${cp}/static/js/ligerUI/lib/ligerUI/js/plugins/ligerTree.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(function ()
        { 
        	document.getElementById("pid").value = ${pname};
        	document.getElementById("id").value = ${id};
        	document.getElementById("pid1").value = ${pid};
        	document.getElementById("name").value = ${name};
        	document.getElementById("ab").value = ${ab};
        	document.getElementById("manager").value = ${managerId};
        	document.getElementById("manager1").value = ${managerName};
        	 
            $("#pid").ligerComboBox({
                width: 180,
                selectBoxWidth: 200,
                selectBoxHeight: 200,  treeLeafOnly: false,
                tree: {
                    url:'${cp}/sm/dept/getupdateDeptTree', checkbox: false, ajaxType: 'get'
                },
                value: ${pid},
                initIsTriggerEvent: false,
                onSelected: function (value)
                {
                	$("#pid1").val(value);
                }
            });
            
            $("#manager1").ligerComboBox({
                width : 180,
                data: ${hr},
                initIsTriggerEvent: false,
                value:${managerId},
                onSelected: function (value)
                {
                	$("#manager").val(value);
                }
            });
        }); 
		
        function SendForm(){
        	document.getElementById("span2").innerHTML = null;
        	document.getElementById("span3").innerHTML = null;
        	var val;
        	val = document.getElementById("name").value;
        	if(val == ""){
        		document.getElementById("span2").innerHTML="部门名称不能为空!";
        		return false;
        	}
        	val = document.getElementById("ab").value;
        	if(val == ""){
        		document.getElementById("span3").innerHTML="部门缩写不能为空!";
        		return false;
        	}
        	$.ajax({
             	url:'${cp}/sm/dept/updateDept',
             	type:"post",
             	data:$('#addForm').serialize(),
             	success:function(result){
             		if(result==true){
             			alert("修改成功");
             		}else if(result==false){
             			alert("修改失败");
             		}
             		window.parent.location.href="${cp}/sm/dept/findAll";
         			parent.$.ligerDialog.close(); //关闭弹出窗
             	}
             });
        }
    </script>

</head>
<body style="padding:0px; overflow:hidden;"> 
<form id="addForm" name="addForm" action="${cp}/sm/dept/updateDept" method="post"> 
    <label >上级部门</label>
     <input type="text" id="pid"/>
     <input type="hidden" id="pid1" name="pid"/>
     <input type="hidden" id="id" name="id"/>
     <span id="span1"></span>
    <br/> 
    
    <label>部门名称</label>
    <input type="text" name="name" id="name">
    <span id="span2"></span>
    <br/>
    
    <label>部门缩写</label>
    <input type="text" name="ab" id="ab" >
    <span id="span3"></span>
    <br/>
    
    <label>负责人名</label>
    <input type="text" id="manager1"/>
    <input type="hidden" id="manager" name="manager"/>
    <br/>
    
   <input type="button" name="sub" id="sub" value="提交" onclick="SendForm()">
</form> 
</body> 

</html>