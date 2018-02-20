$(document).ready(function() {
	$("#reserveformID").validationEngine({
		validationEventTriggers:"keyup blur", 
		openDebug: true
	});
			
	$("#start").timepicker({
		dateFormat:'yyyy-MM-dd', 
		timeFormat:'hh:mm:ss', 
		hourMin: 5, 
		hourMax: 24, 
		hourGrid: 3, 
		minuteGrid: 15
	}); 
	$("#end").timepicker({
		dateFormat:'yyyy-MM-dd', 
		timeFormat:'hh:mm:ss', 
		hourMin: 5, 
		hourMax: 24, 
		hourGrid: 3, 
		minuteGrid: 15
	}); 
			
	$("#addhelper").hide();		
	//生成日历主界面
	$('#calendar').fullCalendar({
		header:{
			right: 'prev,next today',
			center: 'title',
			left: 'month,agendaWeek,agendaDay'
		},
		theme: true,
		editable: false,  //日历拖拽功能
		allDaySlot : false,
		events:  function(start, end , callback){
			//获取当前日历显示的月份(yyyy-MM-dd,该月的第一天)
			var view = $('#calendar').fullCalendar("getView");//获取视图
			var d = $('#calendar').fullCalendar("getView").start;//当前日历显示的月份日期(该月第一天yyyy-MM-dd)
			var selectdate = $.fullCalendar.formatDate(d, "yyyy-MM");	
			//生成需要的日历项目
			var events = [];
			var date = {date:selectdate}  //当前日历显示的月份日期(该月第一天yyyy-MM-dd)显示当月第一天		
			//获取该月的会议信息
			$.ajax({
				type:'POST',
				dataType:'json',
				url:'/clps_mms/bm/meeting/getMeetingByMonth?date='+selectdate,		
				success:function(data){
					console.log("这里是获取该月会议信息：");									
						for(var i=0;i<data.length;i++){
							var date = data[i].meetingBegintime.split("-");//该条信息所在天(年月日)														
							var meetingTitle=data[i].meetingTitle;
							var meetingId=data[i].meetingId;
							var begintime=data[i].meetingBegintime;
							var endtime=data[i].meetingEndtime;
							var meetingContent=data[i].meetingContent;						
							var userId=data[i].userId;
							var roomId=data[i].roomId;
							var userName=data[i].userName;
							var roomName=data[i].roomName;
							var roomStatus=data[i].roomStatus;
							var meetingUserIds=data[i].meetingUserIds;
							var meetingUserNames=data[i].meetingUserNames;
							events.push({	
								sid: 1,
								uid: 1,
								title: meetingTitle,//会议标题
								start: begintime,  //会议开始时间 start_time
								meetingId:meetingId,  //会议的Id
								endtime:endtime,//会议结束时间
								meetingContent:meetingContent,//会议内容
								userId:userId,//用户Id
								roomId:roomId,//会议室Id
								userName:userName,//用户名称
								roomName:roomName,//房间名称
								roomStatus:roomStatus,//房间状态
								meetingUserIds:meetingUserIds,
								meetingUserNames:meetingUserNames
							});	
						}						
						callback(events);
					}
			});
		},
		//定义了点击日历中日期格子的动作，这里将会调用jQueryUi的dialog生成创建新日历项的对话框
		dayClick: function(date, allDay, jsEvent, view) { 
			var selectdate = $.fullCalendar.formatDate(date, "yyyy-MM-dd");	
			$("#reserveformID")[0].reset();//这里表示清除更新时留下的数据
			$( "#reservebox" ).dialog({
				autoOpen: false,
				height: 600,
				width: 1000,
				title: 'Reserve meeting  on ' + selectdate,
				modal: true,
				position: "top",
				draggable: true,    //是否可移动
				beforeClose: function(event, ui) {				
					$.validationEngine.closePrompt("#meetingTitle");
					$.validationEngine.closePrompt("#meetingBegintime");												
					$.validationEngine.closePrompt("#roomId");
					$.validationEngine.closePrompt("#userId");					
				},
				buttons: {
					"重置": function() {
					$("#reserveformID")[0].reset();
					},
					"添加": function() {		
						if($("#reserveformID").validationEngine({returnIsValid:true})){
							//需要的会议信息
							var meetingId=$("#meetingId").val().trim();//会议Id
							var meetinguser = $("#meetinguser").val().trim();//会议参与者
							//var title = $("#title").val().trim();//抄送
							var meetingTitle = $("#meetingTitle").val().trim();//会议标题
							var meetingBegintime =$("#meetingBegintime").val().trim();//会议开始时间
							var meetingEndtime =$("#meetingEndtime").val().trim();//会议结束时间
							var roomId = $("#roomId").val().trim();//所在会议室
							var userId =$("#userId").val().trim();//会议负责人
							var meetingContent =$("#meetingContent").val().trim();//会议内容
							var meetingvo= {meetingId:meetingId,meetingUserIds:meetinguser,meetingTitle:meetingTitle,
									meetingBegintime:meetingBegintime,meetingEndtime:meetingEndtime,
									roomId:roomId,userId:userId,meetingContent:meetingContent};
							console.log("预约的会议信息：");
							$.ajax({
								type:'POST',
								/*dataType:'json',   注意前后返回值均为json格式，不然会至error*/
								url:'/clps_mms/bm/meeting/addMeeting',
								data: meetingvo,
								success:function(data){
									alert('添加成功！！');
											$( "#reservebox" ).dialog( "close" );
											window.location.reload(); //即时更新										
								},
								error:function(){
									alert('添加失败！！');
								}
							});
						}
					}
				}
			
			});
			$( "#reservebox" ).dialog( "open" );
			return false;
		},
		timeFormat: 'HH:mm:ss',
		// 定义了点击日历项的动作，这里将会调用jQueryUi的dialog显示日历项的内容
		eventClick: function(event) {
			var fstart  = $.fullCalendar.formatDate(event.start, "yyyy-MM-dd HH:mm:ss");	
			$( "#reserveinfo" ).dialog({
				autoOpen: false,
				height: 450,
				width: 600,
				modal: true,
				position: "center",
				draggable: true,   //是否可移动
				buttons: {
					"close": function() {
						$( this ).dialog( "close" );
					}
				}
			});		
				$("#reserveinfo").dialog("option","buttons", {
					"编辑":function(){
						var selectdate = $.fullCalendar.formatDate(event.start, "yyyy-MM-dd HH:mm");
						//已有的会议信息						
						var meetingId=event.meetingId;//会议Id
						var meetinguser = event.meetinguser;//会议参与者
						//var title = event.title;//抄送					
						var meetingTitle = event.title;//会议标题
						var meetingBegintime =selectdate;//会议开始时间
						var meetingEndtime =event.endtime;//会议结束时间
						var meetingContent =event.meetingContent;//会议内容
						var roomId = event.roomId;//所在会议室
						var userId =event.userId;//会议负责人
						var meetingUserIds=event.meetingUserIds;//会议参与者id字符串
						var meetingUserNames=event.meetingUserNames;//会议参与者名字字符串
						$("#meetingId").val(meetingId);
						$("#meetinguser").val(meetingUserIds);
						//$("#title").val(title);
						$("#meetingTitle").val(meetingTitle);
						$("#meetingBegintime").val(meetingBegintime);
						$("#meetingEndtime").val(meetingEndtime);	
						$("#roomId").val(roomId);
						if(roomId==$("#roomId").val()){
							$("#roomId").attr(selected='selected');
						}
						$("#userId").val(userId);	
						if(userId==$("#userId").val()){
							$("#userId").attr(selected='selected');
						}
						$("meetingContent").val(meetingContent);						
						$( "#reservebox" ).dialog({
							autoOpen: false,
							height: 600,
							width: 1000,
							title: 'Update meeting on ' + selectdate,
							modal: true,
							position: "top",
							draggable: true,    //是否可移动
							buttons: {
								"取消": function() {
									$( "#reservebox" ).dialog( "close" );
								},
								"更新": function() {		
									if($("#reserveformID").validationEngine({returnIsValid:true})){
										console.log("更新的会议信息：");										
										var meetingId=$("#meetingId").val().trim();//会议Id							
										var meetinguser = $("#meetinguser").val().trim();//会议参与者
										//var title = $("#title").val().trim();//抄送
										var meetingTitle = $("#meetingTitle").val().trim();//会议标题
										var meetingBegintime =$("#meetingBegintime").val().trim();//会议开始时间
										var meetingEndtime =$("#meetingEndtime").val().trim();//会议结束时间
										var roomId = $("#roomId").val().trim();//所在会议室
										var userId =$("#userId").val().trim();//会议负责人
										var meetingContent =$("#meetingContent").val().trim();//会议内容
										var meetingvo= {meetingId:meetingId,meetingUserIds:meetinguser,meetingTitle:meetingTitle,
												meetingBegintime:meetingBegintime,meetingEndtime:meetingEndtime,
												roomId:roomId,userId:userId,meetingContent:meetingContent};							
										$.ajax({
											type:'POST',
											//dataType:'json',  声明此类型时传过来的值必须是json格式，而success返回来的值不是json而是字符串200
											url:'/clps_mms/bm/meeting/addMeeting',
											data: meetingvo,
											success:function(data){
												alert("更新成功！！")
														$( "#reservebox" ).dialog( "close" );
														window.location.reload(); //即时更新													
											},error:function(){
												alert("更新失败！！")
											}
										});
									}
								}
							}
						});
						$( "#reservebox" ).dialog( "open" );
						return false;
					},
					"删除会议": function() {
						var meeting={meetingId:event.meetingId};
						var answer = confirm("是否删除该条会议？");
						if(answer){
							$.ajax({
								type:'POST',
								url:'/clps_mms/bm/meeting/deleteMeeting',
								data:meeting,  //传过去的是会议编号
								success:function(data){
									alert("删除成功！！");
										$( "#reserveinfo" ).dialog( "close" );										
										window.location.reload(); //即时更新		
								},error:function(){
									alert("删除失败！！！");
								}
							});
						}
					}
					
				});
			
			var showtopic = '';
			
			if(event.title.length>6){
				showtopic = event.title.substring(0, 6) + '...';
			}else{
				showtopic = event.title;
			}
			$("#revdesc").html('<div style="font-weight:bold;color:#5383c2;border-bottom: 1px dotted #5383c2; padding: 3px 0px 3px;">'  
								+ showtopic + "这是个当点击具体日程弹出来的日程详细信息</div>");
			$( "#reserveinfo" ).dialog({ 
				title:fstart + "-" +showtopic
			});
			$( "#reserveinfo" ).dialog( "open" );
			return false;
		},
		loading: function(bool) {
			if (bool) $('#loading').show();
			else $('#loading').hide();
		},
		eventMouseover: function(calEvent, jsEvent, view) {
			var fstart  = $.fullCalendar.formatDate(calEvent.start, "yyyy/MM/dd HH:mm:ss");
			var meetingTitle=calEvent.title;
			$(this).attr('title', meetingTitle+"-"+fstart);
			$(this).css('font-weight', 'normal');				
			$(this).tooltip({
				effect:'toggle',
				cancelDefault: true
			});
		},
		eventMouseout: function(calEvent, jsEvent, view) {
			$(this).css('font-weight', 'normal');
		},
		eventRender: function(event, element) {
			var fstart  = $.fullCalendar.formatDate(event.start, "HH:mm");
			var fend  = $.fullCalendar.formatDate(event.end, "HH:mm");				
		},
		//日历上展现出来的会议信息
		eventAfterRender : function(event, element, view) {
			var fstart  = $.fullCalendar.formatDate(event.start, "HH:mm");
			var meetingTitle="";
			if(event.title.length>6){
				meetingTitle = event.title.substring(0, 6) + '...';
			}else{
				meetingTitle = event.title;
			}
			var confbg='';
			if(event.confid==1){
				confbg = confbg + '<span class="fc-event-bg"></span>';
			}else if(event.confid==2){
				confbg = confbg + '<span class="fc-event-bg"></span>';
			}else if(event.confid==3){
				confbg = confbg + '<span class="fc-event-bg"></span>';
			}else if(event.confid==4){
				confbg = confbg + '<span class="fc-event-bg"></span>';
			}else if(event.confid==5){
				confbg = confbg + '<span class="fc-event-bg"></span>';
			}else if(event.confid==6){
				confbg = confbg + '<span class="fc-event-bg"></span>';
			}else{
				confbg = confbg + '<span class=n "fc-event-bg"></span>';
			}
			var titlebg =  '<span class="fc-event-conf" style="background:'+  event.confcolor +'"></span>';
			if(view.name=="month"){
				var evtcontent = '';
				evtcontent = evtcontent + confbg;
				evtcontent = evtcontent + '<span class="fc-event-titlebg"><a href='+'javascript:void(0)'+'>' + fstart+ "- " + meetingTitle + '</a></span>';	
				element.html(evtcontent);
			}
		},
		eventDragStart: function( event, jsEvent, ui, view ) {
			ui.helper.draggable("option", "revert", true);
		},
		eventDragStop: function( event, jsEvent, ui, view ) {},
		eventDrop: function( event, dayDelta, minuteDelta, allDay, revertFunc, jsEvent, ui, view ) { 
			if(1==1||2==event.uid){
				var schdata = {startdate:event.start, enddate:event.end, confid:event.confid, sid:event.sid};
			}else{
				revertFunc();
			}
		},
		eventResizeStart:  function( event, jsEvent, ui, view ) {
			//alert('resizing');
		},
		eventResize: function(event,dayDelta,minuteDelta,revertFunc) {
			if(1==1||2==event.uid){
				var schdata = {startdate:event.start, enddate:event.end, confid:event.confid, sid:event.sid};
			}else{
				revertFunc();
			}
		}
	});
			
	//goto date function
	if($.browser.msie){
		$("#calendar .fc-header-right table td:eq(0)").before('<td><div class="ui-state-default ui-corner-left ui-corner-right" style="border-right:0px;padding:1px 3px 2px;" ><input type="text" id="selecteddate" size="10" style="padding:0px;"></div></td><td><div class="ui-state-default ui-corner-left ui-corner-right"><a><span id="selectdate" class="ui-icon ui-icon-search">goto</span></a></div></td><td><span class="fc-header-space"></span></td>');
	}else{
		$("#calendar .fc-header-right table td:eq(0)").before('<td><div class="ui-state-default ui-corner-left ui-corner-right" style="border-right:0px;padding:3px 2px 4px;" ><input type="text" id="selecteddate" size="10" style="padding:0px;"></div></td><td><div class="ui-state-default ui-corner-left ui-corner-right"><a><span id="selectdate" class="ui-icon ui-icon-search">goto</span></a></div></td><td><span class="fc-header-space"></span></td>');
	}
	$("#selecteddate").datepicker({
		dateFormat:'yy-mm-dd',
		beforeShow: function (input, instant) {  
			setTimeout(
				function () {
					$('#ui-datepicker-div').css("z-index", 15);
				}, 150
			);
		}
	});
								
	$("#selectdate").click(function() {
		var selectdstr = 	$("#selecteddate").val();	
		var selectdate = $.fullCalendar.parseDate(selectdstr, "yyyy-mm-dd");					
		$('#calendar').fullCalendar( 'gotoDate', selectdate.getFullYear(), selectdate.getMonth(), selectdate.getDate());
	});
				
	// conference function
	$("#calendar .fc-header-left table td:eq(0)").before(
			'<td><div class="ui-state-default ui-corner-left ui-corner-right" id="selectmeeting"><a href="meetingroom.jsp"><span id="selectdate" class="ui-icon ui-icon-search" style="float: left;padding-left: 5px; padding-top:1px"></span>meeting room</a></div></td><td><span class="fc-header-space"></span></td>');
	});
		
	