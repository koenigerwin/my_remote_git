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
		

		
		$(function () {            
            $("#positionName").val(frameElement.dialog.get("data").name);
            $("#positionAbbreviation").val(frameElement.dialog.get("data").pAbb);
            $("#positionDescription").val(frameElement.dialog.get("data").description);
           
            $("#id").val(frameElement.dialog.get("data").id);
            //$("#txtName").val(frameElement.dialog.get("data").menuName);
            
		 });
		//获取父窗口信息信息
		function validAndSubmit() //选择一笔,按确认按钮带回 
		{
			//$('#form1').submit();		
			
			$.ajax({
	         	url:'${cp}/sm/position/updatePositionOpe',
	         	data:{"positionName":$("#positionName").val(),"positionAbbreviation":$("#positionAbbreviation").val(),"positionDescription":$("#positionDescription").val()
	         		,"positionId":$("#id").val()
	         	},
	         	success:function(result){
	         		alert(result);
	         		window.parent.location.href="menu_query_all";
	         	}
	         });
			window.parent.location.reload(); 
			//parent.$.ligerDialog.close();
		}
  
</script>


</head>
<body style="padding:10px">

    <form id="myForm" name="form1" method="post" action="${cp}/sm/position/updateMenuOpe" >
        <input type="hidden" id="id" name="positionId" value=""/>
        <table cellpadding="0" cellspacing="0" class="l-table-edit" >
            	
           <tr >
           
            	 
             	
                <td align="left" class="l-table-edit-td" colspan="1" >  职位名字:</td>
                <td align="left" class="l-table-edit-td" colspan="1" >  <input name="positionName" type="text" id="positionName"   /></td>
                
            </tr>
           
              
             <tr>
            	
            	          
                <td colspan="1" align="left" class="l-table-edit-td"  rowspan="1">职位缩写:</td>
                <td colspan="1" align="left" class="l-table-edit-td"  rowspan="1"><input name="positionAbbreviation" type="text" id="positionAbbreviation"  /></td>
                
            </tr>
                 
           
           
            <tr>
            	
                
                <td  class="l-table-edit-td" colspan="1"  rowspan="1"> 
                	描述:
                </td>
                <td  class="l-table-edit-td" colspan="1"  rowspan="1"> 
                	<textarea cols="100" rows="4" class="l-textarea" id="positionDescription" name="description"  style="width:100%;"  ></textarea>
                </td>
            </tr>
             
        </table>
 <br />
<input type="button" value="提交" class="l-button l-button-test" onclick="validAndSubmit()"/>
<input type="reset" value="重置" id="Button1" class="l-button l-button-submit" /> 
    </form>
    <div style="display:none">
    <!--  数据统计代码 --></div>

    
</body>

</html>