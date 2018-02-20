var grid;
var userName;
$(function (){    	  
    grid = $("#logGrid").ligerGrid({
        columns: [
        { display: '会议Id', name: 'meetingId', align: 'left'},
        { display: '会议标题', name: 'meetingTitle', align: 'left'},
        { display: '会议参与者', name: 'meetingUserNames', align: 'left' },
        { display: '会议内容', name: 'meetingContent', minWidth: 60 },
        { display: '会议开始时间', name: 'meetingBegintime', align: 'left' },
        { display: '会议结束时间', name: 'meetingEndtime' },
        { display: '会议负责人', name: 'userName', align: 'left'},
        { display: '所在会议室', name: 'roomName', align: 'left' },
        { display: '会议状态', name: 'meetingStatus', align: 'left',render: function (item){
         if (parseInt(item.meetingStatus) == 1)  {return '未开始'}
	        else if(parseInt(item.meetingStatus) == 0)  {return '已结束'}
	        else{ return '其他'}     
         }
        },
        { display: '创建日期', name: 'meetingCreateDatetime', align: 'left',render: function (item){
            return toLocalDateFormat(item.meetingCreateDatetime); 
         }},
       { display: '创建人', name: 'meetingCreateName', align: 'left'
    	   //,render: function (item){
//        	$.ajax({ url: '/clps_mms/bm/meeting/getUser',data: item.meetingCreateName, success: function(data){
//        		
//          userName= userNamedata.userName;
//    	
//        	}
//         });
        	//return  userName;
       // }
         }             
        ],dataAction: 'local',
        url:'/clps_mms/bm/meeting/meetingList', 
        sortName:'meetingBegintime',
        pageSize:10,
        pageSizeOptions : [5, 10, 20, 30, 40, 50],                        
        rownumbers :true,
        width: '100%', height: '100%',allowUnSelectRow:true 
    });
});

function ser(){
	   var metting = $('#pageWhere1').val();
	   var data = $('#meetingForm').serializeArray();
	   $("#logGrid").ligerGrid({
		   url:'/clps_mms/bm/meeting/meetingList', 
         parms:data
	   }); 
}