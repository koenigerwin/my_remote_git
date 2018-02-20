<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
	<script src="${cp}/static/js/ligerUI/lib/ligerUI/js/plugins/ligerCheckBox.js" type="text/javascript"></script>
    <script src="${cp}/static/js/ligerUI/lib/ligerUI/js/plugins/ligerComboBox.js" type="text/javascript"></script>
    <script src="${cp}/static/js/ligerUI/lib/ligerUI/js/plugins/ligerResizable.js" type="text/javascript"></script> 

    <script type="text/javascript">
    

    /*=====================表单=========================  */  
    var eee;
   // alert(eval(${request.roleStr}).roleName);
        $(function (){
        
        	$("#test1").ligerComboBox({  
                data:${rolejson},
                valueFieldID: 'test1',
                onSelected: function (value)
                {
                	$("#roleId").val(value);
                }
                
            }); 
        	
        	$("#test2").ligerComboBox({  
                data:${positionjson}, 
                valueFieldID: 'test2',
                onSelected: function (value)
                {
                	$("#postionId").val(value);
                }
                
            }); 
        	
        	$("#test3").ligerComboBox({  
                data:${deptjson}, 
                valueFieldID: 'test3',
                onSelected: function (value)
                {
                	$("#deptId").val(value);
                }
               
                
            }); 
        	
        	  
            $("#userGender1").ligerComboBox({
            	valueFieldID: 'userGender',
                data: [
                    { text: 'female', id: '0' },
                    { text: 'male', id: '1' },
                    { text: 'other', id: '2' },
                    { text: 'unknown', id: '3' }],
                     onSelected: function ()
                    {
                    	$("#userGender").val(document.getElementById("userGender1").value);
                    } 
              
            });  
        	

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
                   // alert("Submitted!");
                   
                }
            });
            $("form").ligerForm();
            $(".l-button-test").click(function (){
                alert(v.element($("#txtName")));
            });
            $("#Button1").click(function(){
            	
            	 /* alert($("#userGender").val());
            	 
            	 alert($('#form1').serialize()); */
            	 $.ajax({
                 		url:'${cp}/sm/userinfo/user_add',
/*                  	data:{"userName":$("#userName").val(),"userIcon":$("#userIcon").val(),"userDescription":$("#userDescription").val(),"test1":$("#test1").val(),"test2":$("#test2").val(),"test3":$("#test3").val()},
 */                 	 type:"post", 
						data:$('#form1').serialize(),
						success:function(result){
                 			alert(result);
                 		
                 		window.parent.location.href="showusers";
             			parent.$.ligerDialog.close(); //关闭弹出窗
             			parent.$(".l-dialog,.l-window-mask").remove(); //关闭弹出窗
                 	}
                 });
            });
        });  
        
        
        
       
   /*  }); */
      
        
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
        <table cellpadding="0" cellspacing="0" class="l-table-edit" >
            <tr>
                <td align="right" class="l-table-edit-td">用户名称:</td>
                <td align="left" class="l-table-edit-td"><input name="userName" type="text" id="userName" ltype="text" validate="{required:true,minlength:1,maxlength:10}" /></td>
                <td align="left"></td>
            </tr>
            
             <!-- <tr>
                <td align="right" class="l-table-edit-td">:</td>
                <td align="left" class="l-table-edit-td"><select name="userGender" id="userGender">
					    <option value="1" selected="selected">男</option>
					    <option value="0">女</option>
				</select></td>
                <td align="left"></td>
             </tr> -->
             
            <tr>
                <td align="right" class="l-table-edit-td">性别:</td>
                <td align="left" class="l-table-edit-td"><input type="text" id="userGender1" ltype="text" validate="{required:true,minlength:1,maxlength:10}" />
                 <input type="hidden" id="userGender" name="userGender" />
                </td>
                <td align="left"></td>
             </tr>
            
            
            <tr>
                <td align="right" class="l-table-edit-td">用户登录名:</td>
                <td align="left" class="l-table-edit-td"><input name="userLogon" type="text" id="userLogon" ltype="text" validate="{required:true,minlength:1,maxlength:10}" /></td>
                <td align="left"></td>
            </tr>
            
            <tr>
                <td align="right" class="l-table-edit-td">用户密码:</td>
                <td align="left" class="l-table-edit-td"><input name="userPassWord" type="text" id="userPassWord" ltype="text" /></td>
                <td align="left"></td>
            </tr>
            
           <!--   <tr>
                <td align="right" class="l-table-edit-td">确认密码:</td>
                <td align="left" class="l-table-edit-td"><input name="reuserPassword" type="text" id="reuserPassword" onchange= "checkpwd"  ltype="text" validate="{required:true,minlength:1,maxlength:10}" /></td>
                <td align="left"></td>
            </tr>  -->
            
             <tr>
                <td align="right" class="l-table-edit-td">用户邮箱:</td>
                <td align="left" class="l-table-edit-td"><input name="userEmail" type="text" id="userEmail" ltype="text" validate="{required:true,minlength:1,maxlength:10}" /></td>
                <td align="left"></td>
            </tr>
            
            <tr>
                <td align="right" class="l-table-edit-td">用户手机:</td>
                <td align="left" class="l-table-edit-td"><input name="userMobile" type="text" id="userMobile" ltype="text" validate="{required:true,minlength:1,maxlength:10}" /></td>
                <td align="left"></td>
            </tr>
 
  			<tr>
                <td align="right" class="l-table-edit-td">用户座机:</td>
                <td align="left" class="l-table-edit-td"><input name="userPhone" type="text" id="userPhone" ltype="text" validate="{required:true,minlength:1,maxlength:10}" /></td>
                <td align="left"></td>
            </tr>
            
            <tr>
                <td align="right" class="l-table-edit-td">用户生日:</td>
                <td align="left" class="l-table-edit-td"><input name="userBirth" type="text" id="userBirth" ltype="text" validate="{required:true,minlength:1,maxlength:10}" /></td>
                <td align="left"></td>
            </tr>
            
             <tr>
                <td align="right" class="l-table-edit-td">用户微信:</td>
                <td align="left" class="l-table-edit-td"><input name="userWeiXin" type="text" id="userWeiXin" ltype="text" /></td>
                <td align="left"></td>
            </tr>
 <!--  -->
             <tr>
                <td align="right" class="l-table-edit-td">用户角色:</td>
                <td align="left" class="l-table-edit-td"><input type="text" id="test1" ltype="text" validate="{required:true,minlength:1,maxlength:10}" />
                <input type="hidden" id="roleId" name="roleId" /></td>
                <td align="left"></td>
             </tr>
             
             <tr>
                <td align="right" class="l-table-edit-td">用户职位:</td>
                <td align="left" class="l-table-edit-td"><input type="text" id="test2" ltype="text" validate="{required:true,minlength:1,maxlength:10}" />
                <input type="hidden" id="postionId" name="postionId" /></td>
                <td align="left"></td>
             </tr>
             
              <tr>
                <td align="right" class="l-table-edit-td">用户部门:</td>
                <td align="left" class="l-table-edit-td"><input type="text" id="test3" ltype="text" validate="{required:true,minlength:1,maxlength:10}" /> 
                <input type="hidden" id="deptId" name="deptId" />
                </td>
                <td align="left"></td>
             </tr>
 <!--  -->
             <tr>
                <td align="right" class="l-table-edit-td">用户图标:</td>
                <td align="left" class="l-table-edit-td"><input name="userIcon" type="file" id="userIcon" ltype="text" validate="{required:true}" /></td>
                <td align="left"></td>
            </tr>
            
            <tr>
                <td align="right" class="l-table-edit-td">用户描述:</td>
                <td align="left" class="l-table-edit-td"> 
                <textarea name="userDescription" cols=100" rows="4" class="l-textarea" id="userDescription" style="width:350px" validate="{maxlength:200}" ></textarea>
                </td><td align="left"></td>
            </tr>
          <!--   <tr>
            	 <td align="right" class="l-table-edit-td">用户名称:</td>
            	 <td></td>
            	 <td align="left"></td>
            </tr> -->
        </table>
 <br />
<input type="button" value="提交" id="Button1" class="l-button l-button-submit" /> 
 </form>

</body>
</html>