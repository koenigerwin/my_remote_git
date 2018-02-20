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
	var selecteds2 = null ;
	$(function () { 
		
		if('${msg}' != null && '${msg}' != ""){
			alert('${msg}');
		}
		$('#menuName').val(frameElement.dialog.get("data").name);
		 var menuBox =  $("#menuBox").ligerListBox({
              url:'${cp}/menu/getPermissionByMId?'+$.param({
            	  id:frameElement.dialog.get("data").id
              }),
			  isShowCheckBox: false,
              isMultiSelect: true,
              height: 140
          });
		 
		  
		  $("#functionBox").ligerListBox({
			  url:'${cp}/menu/loadNoExistPer?'+$.param({
            	  id:frameElement.dialog.get("data").id
              }),
			  isShowCheckBox: false,
              isMultiSelect: true,
              height: 140
          });
		  
		 

         /*  var data = [
                  { text: '张三', id: '1' },
                  { text: '李四', id: '2' },
                  { text: '赵武2', id: '3' },
                  { text: '赵武3', id: '4' },
                  { text: '赵武4', id: '5' },
                  { text: '赵武5', id: '6' },
                  { text: '赵武6', id: '7' },
                  { text: '赵武7', id: '8' }
          ];
          liger.get("menuBox").setData(data);  */    
	            
	 });
	function moveToLeft(){
		var box1 = liger.get("menuBox"), box2 = liger.get("functionBox");
        var selecteds = box2.getSelectedItems();
        if (!selecteds || !selecteds.length) return;
        for(var index in selecteds){
        	var selectID = selecteds[index].id;
        	if(selectID.indexOf("R") != -1){
        		selectID =selectID.substring(1,selectID.length);
        		
        	}
        	selectID ='L'+selectID; 
        	selecteds[index].id = selectID;
        	alert(selecteds[index].id);
        }
        box2.removeItems(selecteds);
        box1.addItems(selecteds);
	}
	
	//显示所有的
	function showAll(){
		box2 = liger.get("functionBox");
		box2.reload() ;
		/* 
		for(var index in selecteds2){
			alert(selecteds2[index].text);
		}
		
		if( selecteds2 != null){
			
        	box2.data = selecteds2;
        } */
	}
	
	//显示不存在的
	function showNoExist(){
		var box1 = liger.get("menuBox"), box2 = liger.get("functionBox");
		selecteds2 = box2.data;   //所有的菜单权限
		
        var selectedss = box1.data;    //菜单已有的菜单权限
        
        var selectID;
        var selectID2;
       	for(var y in selectedss){      //遍历已有的菜单权限
       			selectID2 = selectedss[y].id;
       			
       			for(var index in selecteds2){       //遍历所有的菜单权限
        	
        			selectID = selecteds2[index].id; 
        			
       				if(selectID.indexOf(selectID2) !=-1){
       					
       					box2.removeItem(selectID);
       				}
       			}
        	
        }
	}
	
	function moveToRight(){
		var box1 = liger.get("menuBox"), box2 = liger.get("functionBox");
        var selecteds = box1.getSelectedItems();
        if (!selecteds || !selecteds.length) return;
        var selectID ;
        for(var index in selecteds){
        	selectID = selecteds[index].id;
			if(selectID.indexOf("L") != -1){
        		
				selectID =selectID.substring(1,selectID.length);
        	}
        	selectID ='R'+selectID; 
        	selecteds[index].id = selectID;
        	alert(selecteds[index].id);
        }
        box1.removeItems(selecteds);
        box2.addItems(selecteds);
	}
	
	function moveAllToLeft(){
		var box1 = liger.get("menuBox"), box2 = liger.get("functionBox");
        var selecteds = box2.data;
        if (!selecteds || !selecteds.length) return;
        for(var index in selecteds){
        	var selectID = selecteds[index].id;
			if(selectID.indexOf("R") != -1){
        		
				selectID =selectID.substring(1,selectID.length);
        	}
        	selectID ='L'+selectID; 
        	selecteds[index].id = selectID;
        	alert(selecteds[index].id);
        }
        box1.addItems(selecteds);
        box2.removeItems(selecteds);
	}
	
	function moveAllToRight(){
		var box1 = liger.get("menuBox"), box2 = liger.get("functionBox");
        var selecteds = box1.data;
        if (!selecteds || !selecteds.length) return;
        for(var index in selecteds){
        	var selectID = selecteds[index].id;
			if(selectID.indexOf("L") != -1){
        		
				selectID =selectID.substring(1,selectID.length);
        	}
        	selectID ='R'+selectID; 
        	selecteds[index].id = selectID;
        	alert(selecteds[index].id);
        }
        box2.addItems(selecteds);
        box1.removeItems(selecteds);
	}
	//点击提交
	function updatePermission(){
		var existPers = liger.get("menuBox"), noExistPers = liger.get("functionBox");
        var selecteds = existPers.data;
        if (!selecteds || !selecteds.length) return;
	
		 $.ajax({
			url:'${cp}/menu/updatePermission',
			data:{
				"existPers":JSON.stringify(existPers.data),
				"noExistPers":JSON.stringify(noExistPers.data),
				'mId':frameElement.dialog.get("data").id,
				
			},
			success:function(msg){
					
				if(msg !='' && msg !=""){
					alert(msg);
				}
				
			},
			error:function(msg){
				if(msg !='' && msg !=""){
					alert(msg);
				}
				
				
			}
		}); 
		//window.location.reload();
		
	}
		
  
</script>


</head>
<body style="padding:10px"> 
     <div style="margin:4px;float:left;">
         <input  type="text" readonly="readonly" id="menuName"/>
     </div>
     <div style="margin:4px;float:left;">
         <div id="menuBox"></div>  
     </div>
    
     <div style="margin:4px;float:left;" class="middle">
           <input type="button" onclick="moveToLeft()" value='左移'/>
           <br/>
        	  <input type="button" onclick="moveToRight()" value='右移' />
           <br/>
          <input type='button' onclick='moveAllToLeft()' value='全部左移' />
           <br/>
         <input type='button' onclick='moveAllToRight()' value='全部右移' />
           <br/>
			         
     </div>
    <div style="margin:4px;float:left;">
        <div id="functionBox"></div> 
        <div><input type="button" id="btnNoExist" onclick="showNoExist()" value="显示未赋权的权限"/></div>
        <div><input type="button" id="btnShowAll" onclick="showAll()" value="显示所有权限"/></div>
    </div>
    <div>
    	<input type="button" name="btn" id="btn" value="修改" onclick="updatePermission()"/>
    </div>
</body>

</html>