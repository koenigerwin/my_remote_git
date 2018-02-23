<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>   
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>
    <title></title>
    <style type="text/css">
    	
    </style>
    <link href="${cp}/static/js/ligerUI/lib/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />
    <script src="${cp}/static/js/ligerUI/lib/jquery/jquery-1.9.0.min.js" type="text/javascript"></script>  
    <script src="${cp}/static/js/ligerUI/lib/ligerUI/js/core/base.js" type="text/javascript"></script>
    <script src="${cp}/static/js/ligerUI/lib/ligerUI/js/core/inject.js" type="text/javascript"></script>
    <script src="${cp}/static/js/ligerUI/lib/ligerUI/js/plugins/ligerCheckBox.js" type="text/javascript"></script>  
    <script src="${cp}/static/js/ligerUI/lib/ligerUI/js/plugins/ligerButton.js" type="text/javascript"></script>
    <script src="${cp}/static/js/ligerUI/lib/ligerUI/js/plugins/ligerListBox.js" type="text/javascript"></script>
    <script src="${cp}/static/js/ligerUI/lib/ligerUI/js/plugins/ligerCheckBox.js" type="text/javascript"></script>
    <script src="${cp}/static/js/ligerUI/lib/ligerUI/js/plugins/ligerComboBox.js" type="text/javascript"></script>
    <script src="${cp}/static/js/ligerUI/lib/ligerUI/js/plugins/ligerResizable.js" type="text/javascript"></script> 
    <script type="text/javascript">
        $(function (){ 
        	$("#test1").ligerComboBox({  
        	   data:${rolejson},
        	   valueFieldID: 'test3',
        	}); 
            $("#listbox1").ligerListBox({
                isShowCheckBox: true,
                isMultiSelect: true,
                height: 280,
                width:180
            });
            $("#listbox2").ligerListBox({
                isShowCheckBox: true,
                isMultiSelect: true,
                height: 280,
                width:180
            });
            liger.get("listbox2").setData(${userjson});
            $("#test1").change(function(){
            	var box1 = liger.get("listbox1");
            	box1.clearContent();
	            clickee();
	            });
	        });
        function moveToLeft() {
            var box1 = liger.get("listbox1"),box2 = liger.get("listbox2");
            var selecteds = box2.getSelectedItems();
            if (!selecteds || !selecteds.length) return;
            box2.removeItems(selecteds);
            box1.addItems(selecteds);
        }
        function moveToRight(){
            var box1 = liger.get("listbox1"), box2 = liger.get("listbox2");
            var selecteds = box1.getSelectedItems();
            if (!selecteds || !selecteds.length) return;
            box1.removeItems(selecteds);
            box2.addItems(selecteds);
        }
        function moveAllToLeft() { 
            var box1 = liger.get("listbox1"), box2 = liger.get("listbox2");
            var selecteds = box2.data;
            if (!selecteds || !selecteds.length) return;
            box1.addItems(selecteds);
            box2.removeItems(selecteds); 
        }
        function moveAllToRight() { 
            var box1 = liger.get("listbox1"), box2 = liger.get("listbox2");
            var selecteds = box1.data;
            if (!selecteds || !selecteds.length) return;
            box2.addItems(selecteds);
            box1.removeItems(selecteds);
        }
        function clickee(){
 	   		$.ajax({
	 	   		url:'showusers',
	 	   		data:{"roleId":$("#test3").val()},
	 	   		success:function(result){
	 	   			liger.get("listbox1").setData(result);
 	   			}
 	   		});
 	  	 }
        function submit(){
        	 var box1 = liger.get("listbox1");
        	 var box2 = liger.get("listbox2");
        	 var selected = box1.data;
        	 var noselected = box2.data;
        	 $.ajax({
 	 	   		url:'updateuserrole',
 	 	   		data:{"roleId":$("#test3").val(),
 	 	   			  "selected":JSON.stringify(selected),  
 	 	   			  "noselected":JSON.stringify(noselected)
 	 	   		},
 	 	   		success:function(result){
 	 	   			alert(result);
 	 	   			window.location.href="gorolelistadd";
  	   			}
  	   		});
  	  	 }
    </script>
    <style type="text/css">
        .middle input {
            display: block;width:111px; margin:2px;
        }
      
    </style>
</head>
<body style="padding:10px"> 
<!-- 下拉框 -->
<div style="margin:10px;margin-top:100px;margin-right:35px;float:left;">请选择角色
      <input type="text" id="test1" />
	  <input type="hidden" id="test2" /><br />
	         
</div>
	 
<!--  listbox-->
     <div style="margin:4px;float:left;">当前用户列表
         <div id="listbox1"></div>  
     </div>
     <div style="margin:4px;float:left;" class="middle">
     <br><br><br><br>
         <input type="button" onclick="moveToLeft()" value="添加到左边" /><br>
         <input type="button" onclick="moveToRight()" value="添加到右边" /><br>
         <input type="button" onclick="moveAllToLeft()" value="全部添加到左边" /><br>
         <input type="button" onclick="moveAllToRight()" value="全部添加到右边" /><br>
     </div>
     <div style="margin:4px;float:left;">暂无角色用户列表
         <div id="listbox2"></div> 
     </div>
     <input style="cursor:pointer;position:absolute; margin-top:320px;margin-left:-36px;" type=button value="提交" onclick="submit()"/>
</body>
</html>
