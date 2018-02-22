<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path">${pageContext.request.contextPath}</c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${path}/static/js/ligerUI/lib/ligerUI/skins/Aqua/css/ligerui-all.css"
	rel="stylesheet" type="text/css" />
<link href="${path}/static/js/ligerUI/lib/ligerUI/skins/Gray/css/all.css" rel="stylesheet"
	type="text/css" />
 
    <script src="${path}/static/js/ligerUI/lib/jquery/jquery-1.9.0.min.js" type="text/javascript"></script>
    <script src="${path}/static/js/ligerUI/lib/ligerUI/js/core/base.js" type="text/javascript"></script>
    <script src="${path}/static/js/ligerUI/lib/jquery.cookie.js"></script>
    <script src="${path}/static/js/ligerUI/lib/ligerUI/js/plugins/ligerForm.js" type="text/javascript"></script>
    <script src="${path}/static/js/ligerUI/lib/ligerUI/js/plugins/ligerDateEditor.js" type="text/javascript"></script>
    <script src="${path}/static/js/ligerUI/lib/ligerUI/js/plugins/ligerComboBox.js" type="text/javascript"></script>
    <script src="${path}/static/js/ligerUI/lib/ligerUI/js/plugins/ligerCheckBox.js" type="text/javascript"></script>
    <script src="${path}/static/js/ligerUI/lib/ligerUI/js/plugins/ligerButton.js" type="text/javascript"></script>
    <script src="${path}/static/js/ligerUI/lib/ligerUI/js/plugins/ligerDialog.js" type="text/javascript"></script>
    <script src="${path}/static/js/ligerUI/lib/ligerUI/js/plugins/ligerRadio.js" type="text/javascript"></script>
    <script src="${path}/static/js/ligerUI/lib/ligerUI/js/plugins/ligerSpinner.js" type="text/javascript"></script>
    <script src="${path}/static/js/ligerUI/lib/ligerUI/js/plugins/ligerTextBox.js" type="text/javascript"></script> 
    <script src="${path}/static/js/ligerUI/lib/ligerUI/js/plugins/ligerTip.js" type="text/javascript"></script>
    <script src="${path}/static/js/ligerUI/lib/jquery-validation/jquery.validate.min.js" type="text/javascript"></script> 
    <script src="${path}/static/js/ligerUI/lib/jquery-validation/jquery.metadata.js" type="text/javascript"></script>
    <script src="${path}/static/js/ligerUI/lib/jquery-validation/messages_cn.js" type="text/javascript"></script>

<script type="text/javascript">
function loadData() //选择一笔,按确认按钮带回 
{
	$.ajax({
		url:'${path}/sm/grant/updatePmsn',
		method:'post',
		dataType:'json',
		data:$('#form1').serialize(),
		success:function(info){
			console.info(info)
			
	var data = frameElement.dialog;
	/* var dataName = data.get("data"); */
	var dataName = data.get("data").name;
	$("#txtPid").val(dataName);  
	alert("修改成功");
	window.parent.location.reload();
		}
		
	})
	
	//parent.$.ligerDialog.close();
}
$(function(){
	  var pmsnId =$.cookie('pmsnId')
			$.ajax({
				url : '${path}/sm/grant/getPmsnById',
				type : 'get',
				async : false,
				data :{
					pmsnId : pmsnId
				},
				dataType : 'json',
				success : function(data) { 
					 
					alert(data.pmsnId)
					$('#txtPid').val(data.pmsnId)
					 $('#table_t').val(data.pmsnName);
					$('#txtUrl').val(data.pmsnUrl)
					$('#txtName').val(data.pmsnCreateName)
					$('#txtTime').val(data.pmsnCreateDatetime)
					/* $('#m_superid').val(sss.m_superid);
					$('#m_image').val(sss.m_image);
					$('#m_address').val(sss.m_address); */
					$('#txtDescription').val(data.pmsnDescription);
				}
			});
  }) 
		
</script>
<style type="text/css">
tr{
height: 50px}
body {
	font-size: 12px;
}
#txtTime,#txtName{
color: gray;
}

</style>

</head>
<body style="padding: 10px">
	
            <form id="form1" name="form1">
                <input type="hidden" id="txtPid" name="pmsnId"/>
                <table cellpadding="0" cellspacing="0" class="l-table-edit" >
                    	
                   
                     <tr>
                  
                     
                        <td class="td1"> 权限名字:</td>
                        <td ><select id="table_t" name="pmsnName">
                        <option>新增</option>
                        <option>删除</option>
                        <option>修改</option>
                        <option>查询</option>
                        </select></td>
                        
                    </tr>
                <tr>
                    	           
                        <td>创建人名:</td>
                        <td><input   name="pmsnCreateName" type="text" id="txtName" ltype="text" readonly="readonly" /></td>
                       
                    </tr> <tr>
                    	           
                        <td>创建时间:</td>
                        <td><input name="pmsnCreateDatetime"  type="text" id="txtTime" ltype="text" readonly="readonly" /></td>
                       
                    </tr>
                     <tr>
                    	           
                        <td>链接地址:</td>
                        <td><input name="pmsnUrl" type="text" id="txtUrl" ltype="text" validate="{required:true,email:true}" /></td>
                       
                    </tr>
                   
                   
                    <tr>
                    	
                        
                        	<td > 描述:</td>
                        	<td ><textarea cols="100" rows="4" class="l-textarea" id="txtDescription" name="pmsnDescription" style="width:100%" validate="{required:true}" ></textarea>
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