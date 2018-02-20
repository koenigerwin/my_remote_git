<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
    <link href="<%=path%>/static/lib/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />
    <style type="text/css">
    </style>
    <script src="<%=path%>/static/lib/jquery/jquery-1.9.0.min.js" type="text/javascript"></script>  
    <script src="<%=path%>/static/lib/ligerUI/js/core/base.js" type="text/javascript"></script>
    <script src="<%=path%>/static/lib/ligerUI/js/plugins/ligerCheckBox.js" type="text/javascript"></script>
    <script src="<%=path%>/static/lib/ligerUI/js/plugins/ligerComboBox.js" type="text/javascript"></script>
    <script src="<%=path%>/static/lib/ligerUI/js/plugins/ligerResizable.js" type="text/javascript"></script> 
        <script src="<%=path%>/static/lib/ligerUI/js/plugins/ligerTree.js" type="text/javascript"></script>
    <style type="text/css">

        .beijing {
            color: red;
        }
    </style>
    <script type="text/javascript">
        $(function ()
        { 
            $("#test2").ligerComboBox({
                width: 180,
                selectBoxWidth: 200,
                selectBoxHeight: 200,  treeLeafOnly: false,
                tree: {
                    data: [
                        { "text": "节点1.1" ,"id":"0101" },
                        { "text": "节点1.2", "id": "0102" },
                        {
                            "text": "节点1.3", "id": "0103", "children": [
                                {
                                    "text": "节点1.3.1", "id": "010301", "children": [
					                { "text": "节点1.3.1.1", "id": "01030101" },
					                { "text": "节点1.3.1.2", "id": "01030102" }]
                                },
                                { "text": "节点1.3.2", "id": "010302" }
                        ]
                        }
                 ], checkbox: false, ajaxType: 'get'
                },
                value: '0101',
                initIsTriggerEvent: false,
                onSelected: function (value)
                {
                    alert('选中事件:' + value);
                }
            });
        }); 
    </script>
</head>
<body style="padding:10px"> 
    <div style="margin-top:10px;"> <input type="text" id="test2" /> </div>
 <div style="display:none;">
 
</div>
</body>
</html>