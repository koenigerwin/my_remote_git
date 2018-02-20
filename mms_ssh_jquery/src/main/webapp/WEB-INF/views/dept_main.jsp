<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%request.setCharacterEncoding("UTF-8");%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title></title>
    <link href="${cp}/static/js/ligerUI/lib/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet"
        type="text/css" />
    <script src="${cp}/static/js/ligerUI/lib/jquery/jquery-1.9.0.min.js" type="text/javascript"></script>
    <script src="${cp}/static/js/ligerUI/lib/ligerUI/js/core/base.js" type="text/javascript"></script>
    <script src="${cp}/static/js/ligerUI/lib/ligerUI/js/plugins/ligerTextBox.js" type="text/javascript"></script>
    <script src="${cp}/static/js/ligerUI/lib/ligerUI/js/plugins/ligerGrid.js" type="text/javascript"></script>
    <script src="${cp}/static/js/ligerUI/lib/ligerUI/js/plugins/ligerResizable.js" type="text/javascript"></script>
    <script src="${cp}/static/js/ligerUI/lib/ligerUI/js/plugins/ligerDialog.js" type="text/javascript"></script>
    <script src="${cp}/static/js/ligerUI/lib/ligerUI/js/plugins/ligerDrag.js" type="text/javascript"></script>
    <script src="${cp}/static/js/ligerUI/lib/ligerUI/js/plugins/ligerResizable.js" type="text/javascript"></script>
    <script type="text/javascript">
        var manager;
        var grid = null;
    
        $(function ()
        {
            manager = $("#maingrid").ligerGrid({
                columns: [
                { display: '部门名称', name: 'name', width: 250, align: 'left', editor: { type: 'text'} },
                { display: '部门缩写', name: 'ab', width: 250,align: 'left',editor: { type: 'text'}  },
                { display: '部门负责人', name: 'manager', width: 250, align: 'left', editor: { type: 'text'} },
                { display: '创建时间', name: 'date', width: 250, align: 'left', editor: { type: 'text'} },
                { display: '创建人名', name: 'createName', width: 250, align: 'left', editor: { type: 'text'} },
                ], width: '100%', pageSizeOptions: [5, 10, 15, 20], height: '50%',
                data:${dept},alternatingRow: false, tree: { columnName: 'name' }, checkbox: false,
                autoCheckChildren: false,rownumbers: true,usePager: false,
                onSelectRow: function (rowdata, rowid, rowobj)
                {
                    //员工信息
                    grid = $("#maingrid4").ligerGrid({
                        columns: [
                        { display: '用户头像', name: 'userIcon', align: 'left', width: 120 },
                        { display: '用户姓名', name: 'userName', minWidth: 60 },
                        { display: '性别', name: 'userGender', width: 50,align:'left' },
                        { display: '用户座机', name: 'userPhone', minWidth: 140 },
                        { display: '用户手机', name: 'userMobile', minWidth: 140 },
                        { display: '用户邮箱', name: 'userEmail', minWidth: 140 },
                        { display: '部门缩写', name: 'deptAB', minWidth: 140 },
                        { display: '用户职位', name: 'postionName' }
                        ],  pageSize:30,data:f_getOrdersData(rowdata.id), 
                        width: '100%',height:'50%',rownumbers: true
                    });
                }
            });
      
        });
        
        function f_getOrdersData(deptId) {
            var data = { Rows: [] };
       	 $.ajax({
          	url:'${cp}/sm/dept/findParentAndChildrenDeptId',
          	data:{"deptId":deptId},
          	type:"post",
          	async:false,
          	success:function(result){
                for (var i = 0; i < ${user}.Rows.length; i++){
                	for(var j=0;j< result.length;j++){
                		 if (${user}.Rows[i].deptId == result[j]){
                             data.Rows.push(${user}.Rows[i]);
                             }
                		 }
                	}
                }
          	});
                return data;
 }
        
        function deleteRow()
        {
        	var row = manager.getSelectedRow();
        	if (!row) { 
            	alert('请选择行'); 
            	return;
            }else if(manager.getSelectedRow().id == 0){
            	alert('公司信息不能删除!'); 
            	return;
            }else{
            	var bln = window.confirm("请确认是否删除该信息!"); 
           	 	if(bln == true){
                     $.post("${cp}/sm/dept/deleteDept?id="+manager.getSelectedRow().id,function(){
                    	 alert("删除成功!");
                    	 window.location.reload();
                     });
           	 }
            }
        	 
           
        }
       
        function getSelected()
        {
            var row = manager.getSelectedRow();
            if (!row) { alert('请选择行'); return; }
            return row.id;
        }
        function getSelect()
        {   
            var row = manager.getSelectedRow();
            if (!row) { 
            	alert('请选择行'); 
            	return;
            }else if(manager.getSelectedRow().id == 0){
            	alert('公司信息不能修改!'); 
            	return;
            }
            else{
            	updateDept(row);
            }
        }
        function up()
        {
            var row = manager.getSelected();
            manager.up(row);
        }
        function down()
        {
            var row = manager.getSelected();
            manager.down(row);
        }
        
        /* 在选中的菜单下添加新的孩子 */
    	function openwin(url,select) {
    		$.ligerDialog
    				.open({
    					height : 400,
    					url : url,
    					width : 600,
    					name : 'wintest4',
    					isResize : true,
    					data:{
    						name:select
    					},
    					myData: select
    				});
    	}
    	
        function addDept(){
        	openwin('${cp}/sm/dept/deptAddMain',null);
        }
        function updateDept(row){
        	openwin('${cp}/sm/dept/getUpdateDeptInfo?id='+manager.getSelectedRow().id,null);
        }
        
    </script>
    <style type="text/css">
    .l-button{width: 120px; float: left; margin-left: 10px; margin-bottom:2px; margin-top:2px;}
    </style>
</head>
<body style="padding: 4px">
    <div>
        <div style="margin: 2px;">
            	 <h2>部门信息</h2>
        </div>
    <a class="l-button" onclick="addDept()">新增</a> 
    <a class="l-button"  onclick="getSelect()">修改</a> 
    <a class="l-button"  onclick="deleteRow()">删除</a> 
     <a class="l-button" onclick="up()">上移</a> 
    <a class="l-button" onclick="down()">下移</a>
       <div class="l-clear">
        </div>
    </div>
    <div id="maingrid">
    </div>
    <div id="maingrid4" style="margin:0; padding:0"></div>
  <div style="display:none;">
</div>
</body>
</html>
