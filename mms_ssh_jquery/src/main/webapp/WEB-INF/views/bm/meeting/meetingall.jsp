<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta content="text/html; charset=UTF-8">
<title></title>
<link href="${pageContext.request.contextPath }/static/js/ligerUI/lib/ligerUI/skins/Aqua/css/ligerui-all.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath }/static/js/ligerUI/lib/ligerUI/skins/ligerui-icons.css" rel="stylesheet"
	type="text/css" />
<script src="${pageContext.request.contextPath }/static/js/ligerUI/lib/jquery/jquery-1.9.0.min.js" type="text/javascript"></script>
   <script type="text/javascript" src="${pageContext.request.contextPath }/static/js/meetinglist.js"></script>  


<script src="${pageContext.request.contextPath }/static/js/ligerUI/lib/ligerUI/js/core/base.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/static/js/ligerUI/lib/ligerUI/js/plugins/ligerGrid.js" type="text/javascript"></script> 
<script src="${pageContext.request.contextPath }/static/js/ligerUI/lib/ligerUI/js/plugins/ligerDialog.js" type="text/javascript"></script>
 <script language="javascript" type="text/javascript" src="${pageContext.request.contextPath }/static/js/My97DatePicker/WdatePicker.js"></script>
 <script language="javascript" type="text/javascript" src="${pageContext.request.contextPath }/static/js/date.js"></script>
<style type="text/css">
body {
	padding: 5px;
	margin: 0;
	padding-bottom: 15px;
}

#top {
	width: 100%;
	padding-bottom: 10px;
}

.select {
	margin: 10dp;
	width: 60px;
}

#search {
	margin: 0px;
	padding: 0px;
}
</style>
<script type="text/javascript">

</script>

</head>
<body style="padding: 2px">
 <form id="meetingForm">
	<div id="top">
		<a>会议标题:</a> 
		<input type="text" id="pageWhere1" name="meetingTitle" value="${meetingvo.meetingTitle }">
		<a>会议负责人:</a>
		<select id="pageWhere2" class="select" name="userId" >
			<option value="-1">---</option>
			<c:forEach var="user" items="${userList }">
			<option  value="${user.userId }"  ${user.userId==meetingvo.userId?'selected=selected':"" }>${user.userName }</option>
			</c:forEach>
		</select> 
		<a>开始时间:</a> 
		<input type="text" class="Wdate" id="pageWhere3" name="meetingBegintime" value="${meetingvo.meetingBegintime }" onClick="WdatePicker()">
		
		<a>结束时间:</a> 
		<input type="text" class="Wdate" id="pageWhere4" name="meetingEndtime" value="${meetingvo.meetingEndtime }" onClick="WdatePicker()">
		
		<a>所在会议室:</a>
		<select id="pageWhere5" class="select" name="roomId">
			<option value="-1" >---</option>
			<c:forEach var="room" items="${roomList }">
			<option  value="${room.roomId }" ${room.roomId==meetingvo.roomId?'selected=selected':"" }>${room.roomName }</option>
			</c:forEach>
		</select> 
		<a>会议状态:</a>
		<select id="pageWhere6" class="select" name="meetingStatus">
			<option value="-1">请选择</option>
			<option value="0" ${meetingvo.meetingStatus==0?'selected=selected':"" }>已结束</option>
			<option value="1" ${meetingvo.meetingStatus==0?'selected=selected':"" }>未开始</option>
		</select> 
		<input type="button" value="查询" id="search" onclick="ser();"/>
		</div> 
		</form>	 
	<form >	
	<div id="logGrid">	
	</div>
	</form>

	<div style="display: none;"></div>
</body>
</html>