<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!-- 利用el获取值的原理，从get方法中获取数据：

pageContext.getRequest()得到HttpServletRequest对象，这是第一步，第二步是利用拿到的HttpServletRequest调用getContextPath方法。

　　作用是：取出部署的应用程序名，这样不管如何部署，所用路径都是正确的  -->	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>用户注册</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<script href="<%=path%>/static/js/ligerUI/lib/jquery/jquery.min.js" type="text/javascript"></script>
<script href="<%=path%>/static/js/ligerUI/lib/jquery/jquery.form.js" type="text/javascript"></script>
<script href="<%=path%>/static/js/ligerUI/li/jquery/json.parse.js" type="text/javascript"></script> 
<style>
/*  */
@charset "utf-8";

/*header*/
#header,#menu{width:100%; min-width:1200px; background:#fff;}
.header{width:1200px; margin:0 auto; height:100px; line-height:100px; padding-top:15px; position:relative;}
.header h1{width:400px; height:100px; background:url(<%=path%>/static/img/icon/clps_logo.png) 0 0 no-repeat; position:absolute; left:0; top:40px; text-indent:-999em; }
.header ul{position:absolute; right:0; top:44px; width:320px;}
.header ul li{float:left;}
.header ul li a{display:block;height:32px; line-height:32px;}
.index_login a, .index_reg a{background:#009fe3; color:#fff; border-radius:14px; width:90px; box-shadow:0 2px 1px #999; text-align:center; font-weight:bold; letter-spacing:6px;}
.index_reg a{background:#f87e5a; margin:0 30px 0 15px;}
.index_login a:hover{background:#0897d5;}
.index_reg a:hover{background:#f56a40;}
.iphone a{color:#666; font-size:14px; background:url(<%=path%>/static/img/icon/iphone.png) 0 4px no-repeat; text-indent:22px;}
.iphone a:hover{text-decoration:underline;}



#footer{margin:20px auto 45px; width:1170px; padding-left:30px; height:170px; background:#fff; border-bottom:1px solid #ebebeb;border-top:1px solid #ebebeb; position:relative;}
#footer h1{width:150px; height:30px; background:url(static/img/icon/logo2.png) 0 0 no-repeat; position:absolute; left:30px; top:30px; text-indent:-999em;}
.friendLink{position:absolute; top:86px; left:30px; font-size:12px;}
.friendLink a{color:#009fe3; float:left; margin-right:30px;}
.friendLink a:hover{text-decoration:underline;}
/*  */

input[type="text"]:focus,input[type="password"]:focus{
  outline:0;
  -webkit-box-shadow:inset 0 1px 1px rgba(0,0,0,0.075),0 0 4px rgba(82,168,236,0.8);
  -moz-box-shadow:inset 0 1px 1px rgba(0,0,0,0.075),0 0 4px rgba(82,168,236,0.8);
  box-shadow:inset 0 1px 1px rgba(0,0,0,0.075),0 0 4px rgba(82,168,236,0.8)
}

.header a{position:absolute; top:60px; right:50px; font-size:12px; color:#666; height:20px; line-height:20px;background:url(static/img/icon/iPhone.png) -25px -290px no-repeat; text-indent:20px;}
.header a:hover{color:#009fe3;}
.header h3{position:absolute; top:56px; left:214px; height:24px; font:18px/24px 'Microsoft YaHei'; border-left:1px solid #afafaf; padding:0 12px;}


.bg{height:34px;background:url(/static/img/icon/aaa.png) left 0 repeat-x;}
.step_ul{padding:0 40px; margin-top:32px; height:64px; background:url(<%=path%>/static/img/icon/iPhone.png) 0 -314px no-repeat;}



#username,#mail,#password1,#password2,#varcode{width:308px; height:26px;line-height:26px;padding:10px 5px; border:1px solid #aeaeae; border-radius:4px; color:#666;}
.input_div span{ margin-left:6px;}
#btn, .btn2, .success_login, .login_btn{width:460px; height:60px; text-align:center; font:bold 16px/60px '宋体'; border:0 none; border-radius:4px; color:#fff; cursor:pointer; background:#009fe3;letter-spacing:6px;}
#btn{width:320px;}
#btn:hover, .btn2:hover, .success_login:hover,.login_btn:hover{background:#0697d5;}

/*login*/
.login_bg{width:100%; min-width:1200px; height:600px; background:url(<%=path%>/static/img/icon/login_banner.png) center center no-repeat #00a0e9;}
.form{width:1200px; margin:0 auto;position:relative;}
#login_form{width:350px; position:absolute; top:130px; right:70px;}
#login_form h2{background:url(static/img/icon/iPhone.png) left -452px no-repeat; padding-left:46px; color:#009fe3; font-size:16px; font-weight:bold; height:20px; line-height:20px; margin-bottom:24px;}

.username, .pw{width:290px; padding:10px 5px 10px 45px; border:1px solid #009fe3; height:20px; line-height:20px; margin-bottom:10px; border-radius:4px; color:#666;}
.div_user, .div_pw{position:relative;}
.div_user span, .div_pw span{position:absolute; left:15px; top:12px; width:16px; height:18px; background:url(static/img/icon/iPhone.png) 0 -480px no-repeat; z-index:1;}
.div_pw span{background-position:0 -506px;}

.div_box{margin-top:5px; height:20px; line-height:20px; position:relative;}
.div_box a, .login_reg{position:absolute; right:5px;; top:0; color:#009fe3;}
.login_reg{font-weight:bold;}
.div_box a:hover, .login_reg:hover{text-decoration:underline;}
.div_box input{position:absolute; top:4px; left:0;}

.login_btn{display:block; width:340px;box-shadow:0 2px 1px #999; margin-top:20px;}
#login_form h4{height:40px; line-height:40px; position:relative;}

.form .button{position:absolute; left:135px; top:179px; width:190px; height:40px;text-align:center; line-height:40px; font-size:16px; color:#009fe3; font-weight:bold;}


/*  */
	.loginad{
		width:580px;
		height:595px;
		position: absolute;
	}
	.loginad .loginadtitle{
		width:100%;
		text-align:center;
		line-height:60px;
		font-size:32px;
		font-family:"幼圆",Microsoft Yahei;
		margin-top:70px;
		color:#FFF;
	}
	.loginad .loginaddes{
		line-height:30px;
		color:#FFF;
		font-family:Microsoft Yahei;
		font-size:16px;
		text-align:center
	}
	.loginad .loginadimg{
		width:100%; 
		height:320px;
		margin-top:40px;
		
	}
	.loginad .loginadbtn{ width:100%; height:40px; margin-top:30px; }
	.loginad .loginadbtn a{ display:block; width:190px; height:40px; margin:0 auto; text-align:center; line-height:40px; font-size:16px; color:#009fe3; font-weight:bold; background:url(static/img/icon/btn.png) center center no-repeat;
		-moz-border-radius:6px;
		-khtml-border-radius:6px;
		-webkit-border-radius:6px;
		border-radius:6px;
	}
</style>
</head>
<body>
	<div id="header">
		<div class="header">
			<h1 class="png_bg">CLPS办公室管理系统</h1>
			<a href="#">返回主页</a>
		</div>
	</div>	
	
	<div class="login_bg">
		<div class="form">
			<form name="loginForm" id="login_form" method="post" action="login.action">
				<h2>登录CLPS办公室管理系统</h2>
				<div class="div_user"><span></span><input  name="username" class="username" type="text" placeholder="用户名" /></div>
				<div class="div_pw"><span></span><input class="pw" name="password" type="password" placeholder="密码" /></div>
				<div class="div_box">
					<label><input type="checkbox" class="" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;下次自动登录</label>
					<a class="forgetPw" href="jsp/findpwd.jsp">忘记密码？</a>
				</div>
				<div><input class="login_btn" id="loginBtn" type="submit" value="登录" /></div>
                <div style="line-height:30px; text-indent:5px;color:#F30" id="loginTips">&nbsp;</div>
				<h4>可以使用下面方式登录<a class="#" href="toRegister">立即注册</a></h4>
			</form>
		</div>
	</div>
<!-- footer start -->
<div id="footer" class="clear">
    <h1 class="png_bg">CLPS办公室管理系统</h1>
    <div class="friendLink clear">
        <a  href="#" target="_blank" title="隐私政策" rel="nofollow">隐私政策</a>
        <a href="#" target="_blank" rel="nofollow">服务条款</a>
        <a href="#" target="_blank" rel="nofollow">关于我们</a>
        <a href="#" target="_blank" rel="nofollow">人员招聘</a>
        <a href="#" target="_blank" rel="nofollow">联系我们</a>
        <a href="#" target="_blank" rel="nofollow">友情链接</a>
    </div>
</div>

</body></html>