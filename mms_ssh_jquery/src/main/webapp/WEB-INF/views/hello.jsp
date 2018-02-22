<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path">${pageContext.request.contextPath}</c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <title>table模块快速使用</title>
  <link rel="stylesheet" href="${path}/static/js/layui/css/layui.css" media="all">
</head>
<body>
 
<table id="demo" lay-filter="test"></table>
 
<script src="${path}/static/js/layui/layui.js"></script>
<script>
layui.use('table', function(){
  var table = layui.table;
  
  //第一个实例
  table.render({
	  dataType:'json',
    elem: '#demo'
    ,height: 315
    ,url: '${path}/sm/grant/listAllPmsn2' //数据接口
    ,page: true //开启分页
    ,cols: [[ //表头
      {field: 'pmsnId', title: 'ID', width:80, sort: true, fixed: 'left'}
      ,{field: 'pmsnName', title: '权限名', width:80, sort: true}
      ,{field: 'pmsnDescription', title: '权限描述', width:200}
      ,{field: 'pmsnUrl', title: 'URL路径', width:200, sort: true} 
      ,{field: 'pmsnCreateId', title: '创建人id', width: 80, sort: true}
      ,{field: 'pmsnCreateDatetime', title: '创建时间', width: 135, sort: true}
      ,{field: 'pmsnUimId', title: '修改人id', width: 80, sort: true}
      ,{field: 'pmsnUpdateTime', title: '财富', width: 135, sort: true}
    ]]
  });
});
</script>
</body>
</html>