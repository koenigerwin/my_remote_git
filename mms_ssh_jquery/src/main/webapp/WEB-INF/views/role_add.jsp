<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>roleAdd</title>
    <link href="${cp}/static/js/ligerUI/lib/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" /> 
    <link href="${cp}/static/js/ligerUI/lib/ligerUI/skins/Gray/css/all.css" rel="stylesheet" type="text/css" /> 
    <script src="${cp}/static/js/ligerUI/lib/jquery/jquery-1.9.0.min.js" type="text/javascript"></script>
    <script src="${cp}/static/js/ligerUI/lib/ligerUI/js/core/base.js" type="text/javascript"></script>
    <script src="${cp}/static/js/ligerUI/lib/ligerUI/js/plugins/ligerForm.js" type="text/javascript"></script>
    <script src="${cp}/static/js/ligerUI/lib/ligerUI/js/plugins/ligerDateEditor.js" type="text/javascript"></script>
    <script src="${cp}/static/js/ligerUI/lib/ligerUI/js/plugins/ligerComboBox.js" type="text/javascript"></script>
    <script src="${cp}/static/js/ligerUI/lib/ligerUI/js/plugins/ligerCheckBox.js" type="text/javascript"></script>
    <script src="${cp}/static/js/ligerUI/lib/ligerUI/js/plugins/ligerButton.js" type="text/javascript"></script>
    <script src="${cp}/static/js/ligerUI/lib/ligerUI/js/plugins/ligerDialog.js" type="text/javascript"></script>
    <script src="${cp}/static/js/ligerUI/lib/ligerUI/js/plugins/ligerRadio.js" type="text/javascript"></script>
    <script src="${cp}/static/js/ligerUI/lib/ligerUI/js/plugins/ligerSpinner.js" type="text/javascript"></script>
    <script src="${cp}/static/js/ligerUI/lib/ligerUI/js/plugins/ligerTextBox.js" type="text/javascript"></script> 
    <script src="${cp}/static/js/ligerUI/lib/ligerUI/js/plugins/ligerTip.js" type="text/javascript"></script>
    <script src="${cp}/static/js/ligerUI/lib/jquery-validation/jquery.validate.min.js" type="text/javascript"></script> 
    <script src="${cp}/static/js/ligerUI/lib/jquery-validation/jquery.metadata.js" type="text/javascript"></script>
    <script src="${cp}/static/js/ligerUI/lib/jquery-validation/messages_cn.js" type="text/javascript"></script>

    <script type="text/javascript">
    /*=====================表单=========================  */  
    var eee;
        $(function (){
            $.metadata.setType("attr", "validate");
            var v = $("form").validate({
                debug: true,
                errorPlacement: function (lable, element){
                    if (element.hasClass("l-textarea")){
                        element.ligerTip({ content: lable.html(), target: element[0] }); 
                    }
                    else if (element.hasClass("l-text-field")){
                        element.parent().ligerTip({ content: lable.html(), target: element[0] });
                    }
                    else{
                        lable.appendTo(element.parents("td:first").next("td"));
                    }
                },
                success: function (lable){
                    lable.ligerHideTip();
                    lable.remove();
                },
                submitHandler: function (){
                   $("form .l-text,.l-textarea").ligerHideTip();
                }
            });
            $("form").ligerForm();
            $(".l-button-test").click(function (){
                alert(v.element($("#txtName")));
            });
            $("#Button1").click(function(){
            	 $.ajax({
                 	url:'role_add',
                 	data:{"roleName":$("#roleName").val(),"roleIcon":$("#roleIcon").val(),"roleDescription":$("#roleDescription").val()},
                 	success:function(result){
                 		alert(result);
                 		window.parent.location.href="role_list";
             			parent.$.ligerDialog.close(); //关闭弹出窗
             			parent.$(".l-dialog,.l-window-mask").remove(); //关闭弹出窗
                 	}
                 });
            });
            $("#roleName").blur(function(){
            	$.ajax({
            		url:"validate",
            		data:{'roleName':$("#roleName").val()},
            		success:function(result){
            			if(result != ""){
            				alert(result);
            			}
            		}
            	});
            });
        });  
        function change(){
    		var v= $("#roleIcon").val();
    		$('#icon').attr('src',"${cp}/static/img/icon/"+v+".ico");
    		
    	}
    </script>
    <style type="text/css">
           body{ font-size:12px;}
        .l-table-edit {}
        .l-table-edit-td{ padding:4px;}
        .l-button-submit,.l-button-test{width:80px; float:left; margin-left:10px; padding-bottom:2px;}
        .l-verify-tip{ left:230px; top:120px;}
    </style>

</head>

<body style="padding:10px">

    <form name="form1" method="post" id="form1">
<div>
</div>
        <table cellpadding="0" cellspacing="0" class="l-table-edit" >
            <tr>
                <td align="right" class="l-table-edit-td">角色名称:</td>
                <td align="left"  class="l-table-edit-td"><input name="roleName" type="text" id="roleName" ltype="text" validate="{required:true,minlength:1,maxlength:30}" /></td>
                <td align="left"></td>
            </tr>
            <tr>
                <td align="right" class="l-table-edit-td">角色图标:</td>
                <td align="left" class="l-table-edit-td"> <p style="valign:top;align:left"></p>
                	<select id="roleIcon" onchange="change()" name="roleIcon">
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
			        <img id="icon" src="${cp }/static/img/icon/1.ico" width="20"/></td>
                <td align="left"></td>
            </tr>

            <tr>
                <td align="right" class="l-table-edit-td">角色描述:</td>
                <td align="left" class="l-table-edit-td"> 
                <textarea name="roleDescription" cols=100" rows="4" class="l-textarea" id="roleDescription" style="width:350px" validate="{maxlength:200}" ></textarea>
                </td><td align="left"></td>
            </tr>
        </table>
 	<br/>
		<input style="margin-left:336px;margin-top:19px;" type="submit" value="提交" id="Button1" class="l-button l-button-submit" /> 
    </form>

</body>
</html>