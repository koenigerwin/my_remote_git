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
		

		var sortBox  = null;
		var res='';
		$(function () { 
			
			sortBox = $("#sortId").ligerListBox({
            	 url:'${cp}/menu/getELevelMenu?'+$.param({
	            		id:frameElement.dialog.get("data").id
	            	}),isShowCheckBox: false, isMultiSelect: false,
                  valueFieldID: 'test3',height:100
            });  
            $("#menuName").ligerComboBox({
                onBeforeOpen: f_selectContact, valueFieldID: 'menuId',width:300
            });
            
            if(frameElement.dialog.get("data").pName != null 
            		&& frameElement.dialog.get("data").pName!=""){
            	$("#menuName").val(frameElement.dialog.get("data").pName);
        		$("#pId").val(frameElement.dialog.get("data").pId);
            }else{
            	$("#menuName").val("顶级菜单");
        		$("#pId").val("0");
            }
            
            
            $("#txtName").val(frameElement.dialog.get("data").name);
            $("#txtIcon").val(frameElement.dialog.get("data").icon);
            $("#txtUrl").val(frameElement.dialog.get("data").url);
            $("#txtDescription").val(frameElement.dialog.get("data").description);
            $("#id").val(frameElement.dialog.get("data").id);
            //$("#txtName").val(frameElement.dialog.get("data").menuName);
            
		 });
		
		 function clickee()
	        {
	            alert($("#test3").val());
	        }
		
		//打开弹出框
        function f_selectContact()
        {
            $.ligerDialog.open({ title: '选择父级菜单', name:'winselector',
            	width: 700, height: 300, url: '${cp}/menu/menuUpdateLoadForward?'+$.param({
            		id:frameElement.dialog.get("data").id
            	}), 
            	buttons: [
            
                { text: '确定', onclick: f_selectContactOK },
                { text: '取消', onclick: f_selectContactCancel }
            ]
            });
            return false;
        }
        //选择父类菜单
        function f_selectContactOK(item, dialog)
        {
			var fn = dialog.frame.f_select || dialog.frame.window.f_select; 
            var data = fn(); 
            if (!data)
            {
                alert('请选择行!');
                return;
            }
            $("#menuName").val(data.name);
            $("#pId").val(data.id);
            
            dialog.close();
        }
        
        //取消选择
        function f_selectContactCancel(item, dialog)
        {
            dialog.close();
        }
	
        
        //验证菜单信息并提交
        function validAndSubmit(){
        	//获取所有的排序后的顺序
        	sortBox.selectAll() ;
        	var sortList= sortBox.getSelectedItems();
        	
        	//返回字符串
        	var sortStr = '';
        	for(var index in sortList){
        		sortStr = sortStr+sortList[index].id+",";
        		
        	}
        	
        	$('#sortId1').val(sortStr);
        	
        	$.ajax({
    			async : false,
    		    cache : false,
    		    dataType:"html",
    			url:'${cp}/menu/updateMenuOpe',
    			data:{
    				id:$("#id").val(),
    				pId:$("#pId").val(),
    				txtIcon:$("#iconSelect").val(),
    				txtName:$("#txtName").val(),
    				menuStatus:$("#menuStatus").val(),
    				txtDescription:$("#txtDescription").val(),
    				sortId:$("#sortId1").val(),
    				txtUrl:$("#txtUrl").val()
    				
    			},
    			
    			success:function(data){
    				if(data != null && data!=""){
    					alert(data);
    				}
    			},
    			error:function(data){
    				if(data != null && data!=""){
    					alert(data);
    				}
    			}
    		});
        	top.location.reload();
        	window.parent.location.reload();    
        }
        
        function change(){
    		var v= $("#iconSelect").val();
    		$('#icon').attr('src',"${cp}/static/img/icon/"+v+".ico");
    		
    	}
        
        function upfunction(){
        	var selectItem = sortBox.getSelectedItems()[0];
        	var oldIndex = sortBox.indexOf(selectItem)-1;
        	/* var newItem = sortBox. */
        	//alert(selectItem.id );
        	//移除选中
        	sortBox.removeItems(selectItem);
        	//插入到选中
        	sortBox.insertItem(selectItem,oldIndex);
        }
        
        function downfunction(){
        	var selectItem = sortBox.getSelectedItems()[0];
        	var oldIndex = sortBox.indexOf(selectItem)+1;
        	/* var newItem = sortBox. */
        	//alert(selectItem.id );
        	//移除选中
        	sortBox.removeItems(selectItem);
        	//插入到选中
        	sortBox.insertItem(selectItem,oldIndex);
        }
  
</script>


</head>
<body style="padding:10px">

    <form id="myForm" name="form1" method="post" action="${cp}/menu/updateMenuOpe" >
        <input type="hidden" id="txtPid" name="txtPid" value=""/>
        <input type="hidden" id="id" name="id" value=""/>
        <table cellpadding="0" cellspacing="0" class="l-table-edit" >
            	
           
             <tr style="margin-top:100px">
           
            	 <td  class="l-table-edit-td" colspan="2" > 
                	
             
               
                <p style="valign:top;align:left">图标:</p>
                	<select id="iconSelect" onchange="change()" name="txtIcon">
			            <option value="1">第一张</option>
			            <option value="2">第二张</option>
			            <option value="3">第三张</option>
			            <option value="4">第四张</option>
			            <option value="5">第五张</option>
			            <option value="6">第六张</option>
			            <option value="7">第七张</option>
			            <option value="8">第八张</option>
			            <option value="9">第九张</option>
			            <option value="10">第十张</option>
			            <option value="12">第十一张</option>
			            <option value="13">第十二张</option>
			        </select>
			        <img id="icon" src="${cp }/static/img/icon/1.ico" width="100"/>
                </td>
                
            </tr>
           	
           	
           	 <tr>
            	<td></td>
            	<td></td>              
                <td align="right" class="l-table-edit-td" width="70%">菜单名称:<input name="txtName" type="text" id="txtName"  /></td>
               
            </tr>	
                 
             <tr>
            	<td></td>
            	<td></td>              
                <td align="right" class="l-table-edit-td" width="70%">链接地址:<input name="txtUrl" type="text" id="txtUrl" ltype="text" validate="{required:true,email:true}" /></td>
               
            </tr>
           
           
            <tr>
            	
                
                <td  class="l-table-edit-td" colspan="1" > 
                	<p style="valign:top;align:left">选择父类菜单:</p>
                	<input type="text" id="menuName" />
       				<input type="hidden" id="pId" name="pId" />
       				<input type="hidden" id="sortId1" name="sortId" />
       				
     			 
                </td>
                <td></td>
                <td class="l-table-edit-td" align="right">
                	<p style="valign:top;align:right">菜单状态:</p>
                	<select id="menuStatus" name="menuStatus" style="align:right;width: 180px" >
                		<option value="1" selected="selected">激活</option>
                		<option value="0">不激活</option>
                	</select>
                </td>
                <br/>
            </tr>
            
            <tr>
            	
                
                <td  class="l-table-edit-td" colspan="3" > 
                	<div><input type="button" id="up" value="up" onclick="upfunction();"/></div>
                	<div style="valign:top;align:left">菜单排序:</div>
                	 <div id="sortId"></div>
                	 <div><input type="button" id="down" value="down" onclick="downfunction()"/></div> 
      			<br />
                </td>
            </tr>
            
            <tr>
            	
                
                <td  class="l-table-edit-td" colspan="3" > 
                	<p style="valign:top;align:left">描述:</p>
                	<textarea cols="100" rows="4" class="l-textarea" id="txtDescription" name="txtDescription" style="width:100%" validate="{required:true}" >
                	</textarea>
      			<br />
                </td>
            </tr>
        </table>
 <br />
<input type="button" value="提交" class="l-button l-button-test" onclick="validAndSubmit()"/>
<input type="button" value="显示" class="l-button l-button-test" onclick="clickee()"/>
<input type="reset" value="重置" id="Button1" class="l-button l-button-submit" /> 
    </form>
    <div style="display:none">
    <!--  数据统计代码 --></div>

    
</body>

</html>