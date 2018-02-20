<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path">${pageContext.request.contextPath}</c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    <link href="${path}/static/js/ligerUI/lib/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" /> 
    <link href="${path}/static/js/ligerUI/lib/ligerUI/skins/Gray/css/all.css" rel="stylesheet" type="text/css" /> 
    <style type="text/css">
    .td1{
    width: 70px;
    
    }
    tr {
	height: 50px;
}
    </style>
    
    
    <script src="${path}/static/js/ligerUI/lib/jquery/jquery-1.9.0.min.js" type="text/javascript"></script>
    <script src="${path}/static/js/ligerUI/lib/ligerUI/js/core/base.js" type="text/javascript"></script>
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
           
     /*       $(function(){ $.ajax({
        		method:'get',
        		url:'${path}/sm/grant/listAll',
        		dataType:'json',
        		success:function(data){
        		var str;
        			for (var i = 0; i < data.Total; i++) {
						str+='<option>'+data.Rows[i].pmsnName+'<option/>';
					}
        			
        		console.info(str)
        			$('#table_t').html(str)
        			console.info(data)
        			
        		}
        	})
        });  */
        	//获取父窗口信息信息
        	function loadData() //选择一笔,按确认按钮带回 
        	{
        		$.ajax({
        			url:'${path}/sm/grant/add',
        			method:'post',
        			dataType:'json',
        			data:$('#form1').serialize(),
        			success:function(info){
        				console.info(info)
        				alert(info.msg);
        		var data = frameElement.dialog;
        		/* var dataName = data.get("data"); */
        		var dataName = data.get("data").name;
        		$("#txtPid").val(dataName);   		
        		window.parent.location.reload();
        			}
        			
        		})
        		
        		//parent.$.ligerDialog.close();
        	}
        </script>


        </head>
        <body style="padding:10px">

            <form id="form1" name="form1">
                <input type="hidden" id="txtPid" name="txtPid" value=""/>
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