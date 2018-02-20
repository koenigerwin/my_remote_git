<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="easyui-panel" title="Nested Panel" data-options="width:'100%',minHeight:500,noheader:true,border:false" style="padding:10px;">
    <div class="easyui-layout" data-options="fit:true">
        <div data-options="region:'west',split:false" style="width:250px;padding:5px">
            <ul id="contentCategoryTree" class="easyui-tree" data-options="url:'${pageContext.request.contextPath}/bm/device/item/cat/list',animate: true,method : 'GET'">
            </ul>
        </div>
        <div data-options="region:'center'" style="padding:5px">
			<table class="easyui-datagrid" id="itemList" title="设备列表"
				data-options="singleSelect:false,collapsible:true,pagination:true,url:'${pageContext.request.contextPath}/bm/device/item/list',method:'get',pageSize:30,toolbar:toolbar,queryParams:{categoryId:0}">
				<thead>
					<tr>
						<th data-options="field:'ck',checkbox:true"></th>
						<th data-options="field:'deviceId',width:60">设备ID</th>
						<th data-options="field:'deviceNumber',width:60">设备编号</th>
						<th data-options="field:'deviceName',width:60">设备名称</th>
						<th
							data-options="field:'deviceCategory',width:100,formatter:TAOTAO.formatItemCat">叶子类目</th>
						<th data-options="field:'deviceUserId',width:60">设备管理员ID</th>
						<th data-options="field:'deviceRoomId',width:60">会议室ID</th>
						<th
							data-options="field:'deviceDefault1',width:70,align:'right',formatter:TAOTAO.formatPrice">价格</th>
						<th
							data-options="field:'deviceStatus',width:60,align:'center',formatter:TAOTAO.formatItemStatus">状态</th>
						<th data-options="field:'deviceCreated',width:130,align:'center'">创建日期</th>
						<th data-options="field:'deviceUpdated',width:130,align:'center'">更新日期</th>
						<th data-options="field:'deviceCreatedUserId',width:60">创建人ID</th>
						<th data-options="field:'deviceUpdatedUserId',width:60">更新人ID</th>
						<th
							data-options="field:'deviceDescription',width:130,align:'center'">设备描述</th>
						<!-- <th data-options="field:'created',width:130,align:'center',formatter:TAOTAO.formatDateTime">创建日期</th> -->
						<!-- <th data-options="field:'updated',width:130,align:'center',formatter:TAOTAO.formatDateTime">更新日期</th> -->
					</tr>
				</thead>
			</table>
		</div>
    </div>
</div>

<!-- <table class="easyui-datagrid" id="itemList" title="设备列表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,url:'item/list',method:'get',pageSize:30,toolbar:toolbar,queryParams:{categoryId:0}">
    <thead>
        <tr>   
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'deviceId',width:60">设备ID</th>
        	<th data-options="field:'deviceNumber',width:60">设备编号</th>
        	<th data-options="field:'deviceName',width:60">设备名称</th>
        	<th data-options="field:'deviceCategory',width:100,formatter:TAOTAO.formatItemCat">叶子类目</th>
        	<th data-options="field:'deviceUserId',width:60">设备管理员ID</th>
        	<th data-options="field:'deviceRoomId',width:60">会议室ID</th>
            <th data-options="field:'deviceDefault1',width:70,align:'right',formatter:TAOTAO.formatPrice">价格</th>
            <th data-options="field:'deviceStatus',width:60,align:'center',formatter:TAOTAO.formatItemStatus">状态</th>
            <th data-options="field:'deviceCreated',width:130,align:'center'">创建日期</th>
            <th data-options="field:'deviceUpdated',width:130,align:'center'">更新日期</th>
            <th data-options="field:'deviceCreatedUserId',width:60">创建人ID</th>
            <th data-options="field:'deviceUpdatedUserId',width:60">更新人ID</th>
            <th data-options="field:'deviceDescription',width:130,align:'center'">设备描述</th>
            <th data-options="field:'created',width:130,align:'center',formatter:TAOTAO.formatDateTime">创建日期</th>
            <th data-options="field:'updated',width:130,align:'center',formatter:TAOTAO.formatDateTime">更新日期</th>
        </tr>
    </thead>
</table> -->
<div id="itemEditWindow" class="easyui-window" title="编辑设备" data-options="modal:true,closed:true,iconCls:'icon-save',href:'${pageContext.request.contextPath}/bm/device/rest/page/item-edit'" style="width:80%;height:80%;padding:10px;">
</div>
<script>


	$(function() {
		var tree = $("#contentCategoryTree");
		var datagrid = $("#itemList");
		tree.tree({
			onClick : function(node) {
				if (tree.tree("isLeaf", node.target)) {
					datagrid.datagrid('reload', {
						categoryId : node.id
					});
				}
			}
		});
	});

	function getSelectionsIds() {
		var itemList = $("#itemList");
		var sels = itemList.datagrid("getSelections");
		var ids = [];
		for ( var i in sels) {
			ids.push(sels[i].deviceId);
		}
		ids = ids.join(",");
		return ids;
	}

	var toolbar = [
			{
				text : '新增',
				iconCls : 'icon-add',
				handler : function() {
					$(".tree-title:contains('新增设备')").parent().click();
				}
			},
			{
				text : '编辑',
				iconCls : 'icon-edit',
				handler : function() {
					var ids = getSelectionsIds();
					if (ids.length == 0) {
						$.messager.alert('提示', '必须选择一个设备才能编辑!');
						return;
					}
					if (ids.indexOf(',') > 0) {
						$.messager.alert('提示', '只能选择一个设备!');
						return;
					}

					$("#itemEditWindow")
							.window(
									{
										onLoad : function() {
											//回显数据
											var data = $("#itemList").datagrid(
													"getSelections")[0];
											data.priceView = TAOTAO
													.formatPrice(data.deviceDefault1);
											$("#itemeEditForm").form("load",
													data);

											// 加载商品描述
											/* $.getJSON('/rest/item/query/item/desc/'+data.id,function(_data){
												if(_data.status == 200){
													//UM.getEditor('itemeEditDescEditor').setContent(_data.data.itemDesc, false);
													itemEditEditor.html(_data.data.itemDesc);
												}
											}); */

											//加载商品规格
											/* $.getJSON('/rest/item/param/item/query/'+data.id,function(_data){
												if(_data && _data.status == 200 && _data.data && _data.data.paramData){
													$("#itemeEditForm .params").show();
													$("#itemeEditForm [name=itemParams]").val(_data.data.paramData);
													$("#itemeEditForm [name=itemParamId]").val(_data.data.id);
													
													//回显商品规格
													 var paramData = JSON.parse(_data.data.paramData);
													
													 var html = "<ul>";
													 for(var i in paramData){
														 var pd = paramData[i];
														 html+="<li><table>";
														 html+="<tr><td colspan=\"2\" class=\"group\">"+pd.group+"</td></tr>";
														 
														 for(var j in pd.params){
															 var ps = pd.params[j];
															 html+="<tr><td class=\"param\"><span>"+ps.k+"</span>: </td><td><input autocomplete=\"off\" type=\"text\" value='"+ps.v+"'/></td></tr>";
														 }
														 
														 html+="</li></table>";
													 }
													 html+= "</ul>";
													 $("#itemeEditForm .params td").eq(1).html(html);
												}
											}); */

											TAOTAO
													.init({
														"pics" : data.image,
														"cid" : data.deviceCategory.deviceCategoryId,
														fun : function(node) {
															//TAOTAO.changeItemParam(node, "itemeEditForm");
														}
													});
										}
									}).window("open");
				}
			},
			{
				text : '删除',
				iconCls : 'icon-cancel',
				handler : function() {
					var ids = getSelectionsIds();
					if (ids.length == 0) {
						$.messager.alert('提示', '未选中设备!');
						return;
					}
					/* 这里加了一个'warning' */
					$.messager
							.confirm(
									'确认',
									'确定删除ID为 ' + ids + ' 的设备吗？',
									function(r) {
										if (r) {
											var params = {
												"ids" : ids
											};
											$
													.post(
															"${pageContext.request.contextPath}/bm/device/rest/item/delete",
															params,
															function(data) {
																if (data.status == 200) {
																	$.messager
																			.alert(
																					'提示',
																					'删除设备成功!',
																					undefined,
																					function() {
																						$(
																								"#itemList")
																								.datagrid(
																										"reload");
																					});
																}
															});
										}
									});
				}
			},
			'-',
			{
				text : '占用',
				iconCls : 'icon-remove',
				handler : function() {
					var ids = getSelectionsIds();
					if (ids.length == 0) {
						$.messager.alert('提示', '未选中设备!');
						return;
					}
					$.messager
							.confirm(
									'确认',
									'确定占用ID为 ' + ids + ' 的设备吗？',
									function(r) {
										if (r) {
											var params = {
												"ids" : ids
											};

											$.messager
													.prompt(
															"输入提示",
															"您需要输入占用设备的会议室ID:",
															function(data) {
																if (data) {
																	var params2 = {
																		"ids" : ids,
																		"roomId" : data
																	};
																	$
																			.post(
																					"${pageContext.request.contextPath}/bm/device/rest/item/borrow",
																					params2,
																					function(
																							data) {
																						if (data.status == 200) {
																							$.messager
																									.alert(
																											'提示',
																											'占用设备成功!',
																											undefined,
																											function() {
																												$(
																														"#itemList")
																														.datagrid(
																																"reload");
																											});
																						}
																					});
																}
															});

											/* $.post("/rest/item/instock",params, function(data){
												if(data.status == 200){
													$.messager.alert('提示','下架商品成功!',undefined,function(){
														$("#itemList").datagrid("reload");
													});
												}
											}); */

										}
									});

				}
			},
			{
				text : '归还',
				iconCls : 'icon-remove',
				handler : function() {
					var ids = getSelectionsIds();
					if (ids.length == 0) {
						$.messager.alert('提示', '未选中设备!');
						return;
					}
					$.messager
							.confirm(
									'确认',
									'确定归还ID为 ' + ids + ' 的设备吗？',
									function(r) {
										if (r) {
											var params = {
												"ids" : ids
											};
											$
													.post(
															"${pageContext.request.contextPath}/bm/device/rest/item/restore",
															params,
															function(data) {
																if (data.status == 200) {
																	$.messager
																			.alert(
																					'提示',
																					'归还设备成功!',
																					undefined,
																					function() {
																						$(
																								"#itemList")
																								.datagrid(
																										"reload");
																					});
																}
															});
										}
									});
				}
			},
			{
				text : '维修',
				iconCls : 'icon-remove',
				handler : function() {
					var ids = getSelectionsIds();
					if (ids.length == 0) {
						$.messager.alert('提示', '未选中设备!');
						return;
					}
					$.messager
							.confirm(
									'确认',
									'确定维修ID为 ' + ids + ' 的设备吗？',
									function(r) {
										if (r) {
											var params = {
												"ids" : ids
											};
											$
													.post(
															"${pageContext.request.contextPath}/bm/device/rest/item/repair",
															params,
															function(data) {
																if (data.status == 200) {
																	$.messager
																			.alert(
																					'提示',
																					'设置维修设备成功!',
																					undefined,
																					function() {
																						$(
																								"#itemList")
																								.datagrid(
																										"reload");
																					});
																}
															});
										}
									});
				}
			},
			'-',
			'-',
			{
				text : '<div>设备编号<input type="text" id="deviceNumber"/>'
				+'设备名称<input type="text" id="deviceName"/><br/>负责人ID<input type="text" id="deviceUserId"/>会议室ID<input type="text" id="deviceRoomId"/></div>'
				+'负责人姓名<select id="userName" onclick="aboutRoom()" ><option value="null">未选择</option></select>会议室名称<select id="roomName" onclick="aboutRoom()"><option value="null">未选择</option></select>',
				//iconCls:'icon-search',
				handler : function() {
					var ids = getSelectionsIds();
					/* $.messager.confirm('确认','确定维修ID为 '+ids+' 的设备吗？',function(r){
					    if (r){
					    	var params = {"ids":ids};
					    	$.post("rest/item/repair",params, function(data){
								if(data.status == 200){
									$.messager.alert('提示','设置维修设备成功!',undefined,function(){
										$("#itemList").datagrid("reload");
									});
								}
							});
					    }
					}); */
					
					//aboutRoom();
					
				}
			}, {
				text : '搜索',
				iconCls : 'icon-search',
				handler : function() {
					var deviceNumber = $("#deviceNumber").val();
					var deviceName = $("#deviceName").val();
					var deviceUserId = $("#deviceUserId").val();
					var deviceRoomId = $("#deviceRoomId").val();
					var params={"deviceNumber":deviceNumber,"deviceName":deviceName,"deviceUserId":deviceUserId,"deviceRoomId":deviceRoomId};
					/* $.post("item/list",params, function(data){
						if(data.status == 200){
							$("#itemList").datagrid("reload");
							/* $.messager.alert('提示','设置维修设备成功!',undefined,function(){
								$("#itemList").datagrid("reload");
								var tree = $("#contentCategoryTree");
							var datagrid = $("#itemList");
							tree.tree({
								onClick : function(node) {
									if (tree.tree("isLeaf", node.target)) {
										datagrid.datagrid('reload', {
											categoryId : node.id
										});
									}
								}
							});
							}); 
						}
					}); */
					var select1=$("#userName");
					var options1=$("#userName option:selected");
					var userName=(options1.val());
					
					var select2=$("#roomName");
					var options2=$("#roomName option:selected");
					var roomName=(options2.val());
					
					var datagrid=$("#itemList");
					var queryParams=datagrid.datagrid('options').queryParams;
					queryParams.deviceNumber=deviceNumber;
					queryParams.deviceName=deviceName;
					queryParams.deviceUserId=deviceUserId;
					queryParams.deviceRoomId=deviceRoomId;
					queryParams.userName=userName;
					queryParams.roomName=roomName;
					$('#itemList').datagrid('reload');
					//datagrid.datagrid('reload');
					
					
				}
			} ];
	function aboutRoom() {
		//alert('aboutRoom'); //这是可行的.
		var params;
		var select1=$("#userName");
		var options1=$("#userName option:selected");
		var userName=(options1.val());
		
		var select2=$("#roomName");
		var options2=$("#roomName option:selected");
		var roomName=(options2.val());
		
		//select1.append("<option value='aaa'>aaa</option>");
		//$("#selectId").append("<option value='"+value+"'>"+text+"</option>");
		//alert($("#userName option").size());  计算option的个数.

		if(userName=='null' && $("#userName option").size()<10 ){
			
			//alert($("#userName option").size());
			$.post("${pageContext.request.contextPath}/bm/device/find/item/room",params, function(data){
				if(data.status == 200){
					//alert(data.data[0].roomName);
					var arrays=data.data;
					for (var i = 0; i < arrays.length; i++) {
						select1.append("<option value='"+arrays[i].userName+"'>"+arrays[i].userName+"</option");
						select2.append("<option value='"+arrays[i].roomName+"'>"+arrays[i].roomName+"</option");
					}
				}
			});
		}
		
		
	}
	
	$(function() {
		var tree = $("#contentCategoryTree");
		var datagrid = $("#itemList");
		//alert('123');
		
		
	});
</script>