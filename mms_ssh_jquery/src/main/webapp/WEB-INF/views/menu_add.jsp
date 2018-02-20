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
var eee;
$(function ()
{
	
	sortBox = $("#sortId").ligerListBox({
   	 url:'${cp}/menu/getELevelMenu?'+$.param({
       		id:frameElement.dialog.get("data").id
       	}),isShowCheckBox: false, isMultiSelect: false,
         valueFieldID: 'test3',height:100
   	});  
	
	
	
    //$.metadata.setType("attr", "validate");
   
	var data = frameElement.dialog;
	/* var dataName = data.get("data"); */
	var dataName = data.get("data").name;
	var dataId = data.get("data").id;
	

	$("#txtPName").ligerComboBox({  
        data: [
        	{ text: dataName, id: dataId },
            { text: '无', id: 0 }
        ], valueFieldID: 'txtPid'
    });
	
	$("#txtPName").val(dataName);
	$("#txtPid").val(dataId);
	/* $("#txtPName").get(0).text(dataName);       //设置下拉框的显示值
	$("#txtPName").get(0).val(dataId);       //设置下拉框的值 */
   
});  
	//获取父窗口信息信息
	function loadData() //选择一笔,按确认按钮带回 
	{	
		//获取所有的排序后的顺序
    	sortBox.selectAll() ;
    	var sortList= sortBox.getSelectedItems();
    	
    	//返回字符串
    	var sortStr = '';
    	for(var index in sortList){
    		sortStr = sortStr+sortList[index].id+",";
    		
    	}
    	
    	$('#sortId').val(sortStr);
		
		
		
		$.ajax({
			async : false,
		    cache : false,
			
			url:'${cp}/menu/addMenuOpe',
			data:{
				txtPid:$("#txtPid").val(),
				txtIcon:$("#iconSelect").val(),
				txtName:$("#txtName").val(),
				menuStatus:$("#menuStatus").val(),
				txtDescription:$("#txtDescription").val(),
				sortId:$("#sortId2").val(),
				txtUrl:$("#txtUrl").val()
				
			},
			dataType:"html",
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
	
	function change(){
		var v= $("#iconSelect").val();
		$('#icon').attr('src',"${cp}/static/img/icon/"+v+".ico");
		
	}
</script>


</head>
<body style="padding:10px">

    <form id="form1" name="form1" method="post" action="${cp}/menu/addMenuOpe" >
        <input type="hidden" id="txtPid" name="txtPid" value=""/>
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
             
                <td align="right" class="l-table-edit-td">  菜单名字:<input name="txtName" type="text" id="txtName" /></td>
                
            </tr>
           
            <tr style="margin-top:100px">
           
            	 <td  class="l-table-edit-td" colspan="2" > 
                	
                </td>
             
                <td align="left" class="l-table-edit-td">  父类菜单:
					 
      				<input type="text" id="txtPName" readonly="readonly" />
       				<!-- <input type="hidden" id="txtPid" /> -->
       				<input type="hidden" id="sortId2" name="sortId" />
      				<br />
				</td>
                
            </tr>
             <tr>
            	<td></td>
            	          
                <td align="left" class="l-table-edit-td" width="90%">链接地址:<input name="txtUrl" type="text" id="txtUrl" ltype="text" validate="{required:true,email:true}" width="100%"/></td>
                <td class="l-table-edit-td" align="right">
                	<p style="valign:top;align:right">菜单状态:</p>
                	<select id="menuStatus" name="menuStatus" style="align:right;width: 180px" onchange="" >
                		<option value="1" selected="selected">激活</option>
                		<option value="0">不激活</option>
                	</select>
                </td>
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
                	<p style="valign:top;align:left">描述:</p><textarea cols="100" rows="4" class="l-textarea" id="txtDescription" name="txtDescription" style="width:100%" validate="{required:true}" ></textarea>
                </td>
            </tr>
        </table>
 <br />
<input type="button" value="提交" class="l-button l-button-test" onclick="loadData()"/>
<input type="reset" value="重置" id="Button1" class="l-button l-button-submit" /> 
    </form>
    <div style="display:none">
    <!--  数据统计代码 --></div>
	
    
</body>

</html>