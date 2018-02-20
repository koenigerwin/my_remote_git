<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<HTML>
<HEAD>
<TITLE>Meeting</TITLE>
<META content="text/html; charset=UTF-8" http-equiv=content-type>
<META name=description content="jQuery fullcalendar demo">
<META name=keywords content="gbin1.com, jQuery full calendar">
<META name=author content="terry li">

<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/util/fullCalendar/mainstructure.css"> 
<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/util/fullCalendar/maincontent.css"> 
<!-- Jquery and Jquery UI -->

<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/fullCalendar/jquery-1.4.2.min.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/fullCalendar/jquery-ui-1.8.6.custom.min.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/fullCalendar/jquery-ui-timepicker-addon.js"></script>

<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/util/fullCalendar/redmond/jquery-ui-1.8.1.custom.css"> 

<!-- Jquery and Jquery UI -->

<script src="${pageContext.request.contextPath }/static/js/fullCalendar/formValidator/js/jquery.validationEngine.js" type="text/javascript"></script>

<script src="${pageContext.request.contextPath }/static/js/fullCalendar/formValidator/js/jquery.validationEngine-en.js" type="text/javascript"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath }/static/js/fullCalendar/formValidator/css/validationEngine.jquery.css" type="text/css" media="screen" charset="utf-8" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/js/fullCalendar/fullcal/css/fullcalendar.css" />

<!-- FullCalender -->
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/fullCalendar/fullcal/fullcalendar.js"></script>

    
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/meetingInfo.js"></script>

 <script language="javascript" type="text/javascript" src="${pageContext.request.contextPath }/static/js/My97DatePicker/WdatePicker.js"></script>
</HEAD>
<BODY>
<STYLE type="text/css">
	#loading {
		TOP: 0px; RIGHT: 0px
	}
	.tooltip {
		PADDING-BOTTOM: 25px; 
		PADDING-LEFT: 25px; 
		WIDTH: 160px; 
		PADDING-RIGHT: 25px; 
		DISPLAY: none; 
		BACKGROUND: url(images/black_arrow.png);
		HEIGHT: 70px; 
		COLOR: #fff; 
		FONT-SIZE: 12px; 
		PADDING-TOP: 25px; 
		z-order: 100
	}
</STYLE>

<DIV id="wrap">
	<DIV id="calendar"></DIV>
	<DIV id="reserveinfo" title="Details">
		<DIV id="revtitle"></DIV>
		<DIV id="revdesc"></DIV>
	</DIV>
	<DIV style="DISPLAY: none;" id="reservebox" title="Reserve meeting room">
		<FORM id="reserveformID" method="post">
			<DIV class="sysdesc">&nbsp;<input type="hidden" name="meetingId" id="meetingId"/></DIV>								
			<DIV class="rowElem">
				<LABEL >会议参与者:*</LABEL> 				
				<input name="meetinguser" id="meetinguser" class="validate[required]"/>
			</DIV>
		<!-- 	<DIV class="rowElem">
				<LABEL>抄送:</LABEL> 
				<INPUT id="title" name="title"/>
			</DIV>	 -->
			<DIV class="rowElem">
				<LABEL>会议标题:*</LABEL> 
				<INPUT id="meetingTitle" name="meetingTitle" class="validate[required]"/>
			</DIV>
			<DIV class="rowElem">
			<LABEL>会议开始时间:*</LABEL> 
				<INPUT id="meetingBegintime" class="Wdate" name="meetingBegintime" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'})"> 
			</DIV>
			<DIV class="rowElem">
				<LABEL>会议结束时间:</LABEL> 
				<INPUT id="meetingEndtime" class="Wdate"  name="meetingEndtime" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'})"> 
			</DIV>			
			<DIV class="rowElem">
				<LABEL>会议室名:*</LABEL> 
				<SELECT id="roomId" class="validate[required]" name="roomId">
					<OPTION selected value="-1">请选择</OPTION>
				<c:forEach var="room" items="${roomList }">
					<OPTION  value="${room.roomId }">${room.roomName }</OPTION>
				</c:forEach>
				</SELECT>			
	       </DIV>
		<DIV class="rowElem">
			<LABEL>会议负责人:*</LABEL> 
			<SELECT id="userId" class="validate[required]" name="userId">
				<OPTION selected value="-1">请选择</OPTION>
			<c:forEach var="user" items="${userList }">
				<OPTION  value="${user.userId }">${user.userName }</OPTION>
			</c:forEach>
			</SELECT>
	   </DIV>
			<DIV >
				<LABEL>会议内容:</LABEL> 				
				<textarea id="meetingContent" name="meetingContent" class="ckeditor"></textarea> 	    
		</DIV>
			
			<DIV class="rowElem"> </DIV>
			<DIV class="rowElem"> </DIV>
			<DIV id="addhelper" class="ui-widget">
				<DIV style="PADDING-BOTTOM: 5px; PADDING-LEFT: 5px; PADDING-RIGHT: 5px; PADDING-TOP: 5px" 
					 class="ui-state-error ui-corner-all">
					<DIV id="addresult"></DIV>
				</DIV>
			</DIV>
		</FORM>
	</DIV>
</DIV>
    
<script src="${pageContext.request.contextPath }/static/js/ckeditor/ckeditor.js"></script>
 <script type="text/javascript">CKEDITOR.replace('meetingContent'); </script> 
</BODY>
</HTML>