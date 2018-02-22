<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path">${pageContext.request.contextPath}</c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link
	href="${path}/static/js/ligerUI/lib/ligerUI/skins/Aqua/css/ligerui-all.css"
	rel="stylesheet" type="text/css" />
<link
	href="${path}/static/js/ligerUI/lib/ligerUI/skins/ligerui-icons.css"
	rel="stylesheet" type="text/css" />
	  <link rel="stylesheet" href="${path}/static/js/layui/css/layui.css" media="all">
<link rel="stylesheet" type="text/css" id="mylink" />
<script src="${path}/static/js/ligerUI/lib/jquery/jquery-1.9.0.min.js" type="text/javascript"></script>
<script
	src="${path}/static/js/ligerUI/lib/ligerUI/js/plugins/ligerMenu.js"
	type="text/javascript"></script>
<script
	src="${path}/static/js/ligerUI/lib/ligerUI/js/plugins/ligerMenuBar.js"
	type="text/javascript"></script>
<script
	src="${path}/static/js/ligerUI/lib/ligerUI/js/plugins/ligerToolBar.js"
	type="text/javascript"></script>
<style>
#left-body{
float: left;
border:solid 3px blue;
width: 30%;
}
#right-body{
float: right;
width: 30%;
border:solid 3px blue;
}
body, html {
	height: 100%;
}

body {
	padding: 0px;
	margin: 0;
	overflow: hidden;
}

.l-link {
	display: block;
	height: 26px;
	line-height: 26px;
	padding-left: 10px;
	text-decoration: underline;
	color: #333;
}

.l-link2 {
	text-decoration: underline;
	color: white;
	margin-left: 2px;
	margin-right: 2px;
}

.l-layout-top {
	background: #102A49;
	color: White;
}

.l-layout-bottom {
	background: #E5EDEF;
	text-align: center;
}

#pageloading {
	position: absolute;
	left: 0px;
	top: 0px;
	background: white url('/clps_mms/static/js/ligerUI/lib/images/loading.gif') no-repeat center;
	width: 100%;
	height: 100%;
	z-index: 99999;
}

.l-link {
	display: block;
	line-height: 22px;
	height: 22px;
	padding-left: 16px;
	border: 1px solid white;
	margin: 4px;
}

.l-link-over {
	background: #FFEEAC;
	border: 1px solid #DB9F00;
}

.l-winbar {
	background: #2B5A76;
	height: 30px;
	position: absolute;
	left: 0px;
	bottom: 0px;
	width: 100%;
	z-index: 99999;
}

.space {
	color: #E7E7E7;
}
/* 顶部 */
.l-topmenu {
	margin: 0;
	padding: 0;
	height: 31px;
	line-height: 31px;
	background: url('/clps_mms/static/js/ligerUI/lib/images/top.jpg') repeat-x bottom;
	position: relative;
	border-top: 1px solid #1D438B;
}

.l-topmenu-logo {
	color: #E7E7E7;
	padding-left: 35px;
	line-height: 26px;
	background: url('/clps_mms/static/js/ligerUI/lib/images/topicon.gif') no-repeat 10px 5px;
}

.l-topmenu-welcome {
	position: absolute;
	height: 24px;
	line-height: 24px;
	right: 30px;
	top: 2px;
	color: #070A0C;
}

.l-topmenu-welcome a {
	color: #E7E7E7;
	text-decoration: underline
}

.body-gray2014 #framecenter {
	margin-top: 3px;
}

.viewsourcelink {
	background: #B3D9F7;
	display: block;
	position: absolute;
	right: 10px;
	top: 3px;
	padding: 6px 4px;
	color: #333;
	text-decoration: underline;
}

.viewsourcelink-over {
	background: #81C0F2;
}

.l-topmenu-welcome label {
	color: white;
}

 #skinSelect {
	margin-right: 6px;
}
</style>
<script src="${path}/static/js/ligerUI/lib/jquery/jquery-1.9.0.min.js" type="text/javascript"></script>
<script src="${path}/static/js/ligerUI/lib/ligerUI/js/ligerui.all.js" type="text/javascript"></script>
<script src="${path}/static/js/ligerUI/lib/jquery.cookie.js"></script>
<script src="${path}/static/js/ligerUI/lib/json2.js"></script>
    <script type="text/javascript">
   /*  $(function (){
        $.ajax({
        	url:'${path}/sm/grant/listRole',
        	dataType:'json',
        	method:'get',
        	success:function(data){
        		alert(data)
        		console.info(data);
        		var str='';
        		for(var i=0;i<data.length;i++){
        			str+='<tr><td id="'+data[i].roleId+'" onclick="listMenuPmsn(this)">'+data[i].roleName+"</td></tr>";
        		}
        		$('#r_list').html(str);
        	}
        })
    })
    function listMenuPmsn(item){
    	var roleId=item.id;
    	alert(roleId)
    	$.ajax({
    		method:'get',
    		url:'${path}/sm/grant/getMenuPmsn/'+roleId,
    		dataType:'json',
    		success:function(data){
    			var str=' ';
    			for (var i = 0; i < data.length; i++) {
					str+='<tr><td>'+data[i].menuName+'</tr></td>';
				}
    			$('#mp_list').html(str);
    			console.info(data)
    		}
    	})
    } */
    var tree = null;
    var tab = null;
    var accordion = null;
    var tabItems = [];
    var manager = null;
    $(function() {

    	$("#toptoolbar").ligerToolBar({
			items : [ {
				icon : 'modify',
				text : '保存',
				click : function(item) {
					console.info(manager.getChecked());
					var arr = manager.getChecked();
					$.ajax({
						url:'${path}/sm/grant/deleteRoleMenuPmsn/${roleId}',
						method:'post',
						dataType:'json',
						success:function(data){
							alert(data.msg)
						}
					})
					for (var i = 1; i < arr.length; i++) {
						if(arr[i].data.children==null){
							console.info(arr[i].data);
							console.info(manager.getParent(arr[i].data))
							var pmsnId = arr[i].data.pmsnId;
							var menuId = manager.getParent(arr[i].data).id;
							$.ajax({
								url:'${path}/sm/grant/updataRoleMenuPmsn/${roleId}',
								method:'post',
								dataType:'json',
								data:{pmsnId:pmsnId,menuId:menuId},
								success:function(data){
								
								}
							})
						}
					}
					},
			}, { line: true },
 {
				text : '刷新',
				click : function() {
					manager.reload()
					},
			},{ line: true } ]
		});
    	//布局
    	/* $("#layout1").ligerLayout({
    		leftWidth : '20%',
    		height : '100%',
    		heightDiff : -34,
    		space : 4,
    		onHeightChanged : f_heightChanged,
    		onLeftToggle : function() {
    			tab && tab.trigger('sysWidthChange');
    		},
    		onRightToggle : function() {
    			tab && tab.trigger('sysWidthChange');
    		}
    	});

    	var height = $(".l-layout-center").height();

    	//Tab
    	tab = $("#framecenter").ligerTab({
    		height : height,
    		showSwitchInTab : true,
    		showSwitch : true,
    		onAfterAddTabItem : function(tabdata) {
    			tabItems.push(tabdata);
    			saveTabStatus();
    		},
    		onAfterRemoveTabItem : function(tabid) {
    			for (var i = 0; i < tabItems.length; i++) {
    				var o = tabItems[i];
    				if (o.tabid == tabid) {
    					tabItems.splice(i, 1);
    					saveTabStatus();
    					break;
    				}
    			}
    		},
    		onReload : function(tabdata) {
    			var tabid = tabdata.tabid;
    			addFrameSkinLink(tabid);
    		}
    	});
 */
    	//面板
    	/* $("#accordion1").ligerAccordion({
    		height : height - 24,
    		speed : null
    	}); */

    /* 	$(".l-link").hover(function() {
    		$(this).addClass("l-link-over");
    	}, function() {
    		$(this).removeClass("l-link-over");
    	}); */
    	
    	//树
    	tree =$("#tree1").ligerTree({
    		dataType:'json',
    		url : "${path}/sm/grant/getMenuPmsn/${roleId}",
    		checkbox : true,
    		slide : false,
    		nodeWidth : 120,
    		attribute : [ 'nodename', 'url' ],
    		/* render : function(a) {
    			if (!a.isnew)
    				return a.text;
    			return '<a href="' + a.url + '" target="_blank">'
    					+ a.text + '</a>';
    		} */
    		onSelect:onSelect
    		/* onSelect : function(node) {
    			console.log("node:"+node.data.id);
    			$.cookie('menuId', node.data.id);
    			if (!node.data.url)
    				return;
    			var tabid = $(node.target).attr("tabid");
    			if (!tabid) {
    				tabid = new Date().getTime();
    				$(node.target).attr("tabid", tabid);
    				f_addTab(tabid, node.data.text, node.data.url);
    			} else {
    				if (tab.isTabItemExist(tabid)) {
    					tab.selectTabItem(tabid);
    					tab.reload(tabid);
    				} else {
    					tabid = new Date().getTime();
    					$(node.target).attr("tabid", tabid);
    					f_addTab(tabid, node.data.text, '${path}'+node.data.url);
    				}
    			}
    		}
    		 */
    	});
    	manager = $("#tree1").ligerGetTreeManager();
    /* 	function openNew(url) {
    		var jform = $('#opennew_form');
    		if (jform.length == 0) {
    			jform = $('<form method="post" />').attr('id', 'opennew_form')
    					.hide().appendTo('body');
    		} else {
    			jform.empty();
    		}
    		jform.attr('action', url);
    		jform.attr('target', '_blank');
    		jform.trigger('submit');
    	}
    	; */

    	/* tab = liger.get("framecenter");
    	accordion = liger.get("accordion1"); */
    	tree = liger.get("tree1");
    	$("#pageloading").hide();

    	css_init();
    	//pages_init();
    });
    function onSelect(note) //这里的异步加载逻辑取决于你的数据库设计，把选中节点的id传回去，传回子节点json然后加载  
    {              console.info(note)   
    	if(note.data.children.length==0){
    		$.ajax({
    			method:'post',
    			url:"${path}/sm/grant/getMenuPermission/${roleId}/"+ note.data.id,
    			success:function(data){
    				var json = JSON.parse(data);
    				console.info(json);
    			   if(json.length==1){
    				   if(json[0].pmsnId!=null){
    					   manager.loadData(note.target, "${path}/sm/grant/getMenuPermission/${roleId}/"+ note.data.id);    
    				   }
    			   }
    			   else{
    				   manager.loadData(note.target, "${path}/sm/grant/getMenuPermission/${roleId}/"+ note.data.id);    
    			   }
    				
    			}
    		})
    } 
    }
    function f_heightChanged(options) {
    	if (tab)
    		tab.addHeight(options.diff);
    	if (accordion && options.middleHeight - 24 > 0)
    		accordion.setHeight(options.middleHeight - 24);
    }
    function f_addTab(tabid, text, url) {
    	tab.addTabItem({
    		tabid : tabid,
    		text : text,
    		url : url,
    		callback : function() {
    			//addShowCodeBtn(tabid); 
    			addFrameSkinLink(tabid);
    		}
    	});
    }
    function addTreeItem()
    {
         //根据tree对象获取选中的结点
        var node = manager.getSelected();

        var data= [];
        data.push({ text:'测试'});
        if (node)
            manager.append(node.target, data); 
        else
            manager.append(null, data);
    }
    function addShowCodeBtn(tabid)
     {
         var viewSourceBtn = $('<a class="viewsourcelink" href="javascript:void(0)">查看源码</a>');
         var jiframe = $("#" + tabid);
         viewSourceBtn.insertBefore(jiframe);
         viewSourceBtn.click(function ()
         {
             showCodeView(jiframe.attr("src"));
         }).hover(function ()
         {
             viewSourceBtn.addClass("viewsourcelink-over");
         }, function ()
         {
             viewSourceBtn.removeClass("viewsourcelink-over");
         });
     } 
  function showCodeView(src) {
    	$.ligerDialog.open({
    		title : '源码预览',
    		url : 'dotnetdemos/codeView.aspx?src=' + src,
    		width : $(window).width() * 0.9,
    		height : $(window).height() * 0.9
    	});

    }
   function addFrameSkinLink(tabid) {
    	var prevHref = getLinkPrevHref(tabid) || "";
    	var skin = getQueryString("skin");
    	if (!skin)
    		return;
    	skin = skin.toLowerCase();
    	attachLinkToFrame(tabid, prevHref + skin_links[skin]);
    } 
   var skin_links = {
    	"aqua" : "lib/ligerUI/skins/Aqua/css/ligerui-all.css",
    	"gray" : "lib/ligerUI/skins/Gray/css/all.css",
    	"silvery" : "lib/ligerUI/skins/Silvery/css/style.css",
    	"gray2014" : "lib/ligerUI/skins/gray2014/css/all.css"
    }; 
    function pages_init() {
    	var tabJson = $.cookie('liger-home-tab');
    	if (tabJson) {
    		var tabitems = JSON2.parse(tabJson);
    		for (var i = 0; tabitems && tabitems[i]; i++) {
    			f_addTab(tabitems[i].tabid, tabitems[i].text, tabitems[i].url);
    		}
    	}
    }
    function saveTabStatus() {
    	$.cookie('liger-home-tab', JSON2.stringify(tabItems));
    }
    function css_init() {
    	var css = $("#mylink").get(0), skin = getQueryString("skin");
    	$("#skinSelect").val(skin);
    	$("#skinSelect").change(function() {
    		if (this.value) {
    			location.href = "index.htm?skin=" + this.value;
    		} else {
    			location.href = "index.htm";
    		}
    	});

    	if (!css || !skin)
    		return;
    	skin = skin.toLowerCase();
    	$('body').addClass("body-" + skin);
    	$(css).attr("href", skin_links[skin]);
    }
    function getQueryString(name) {
    	var now_url = document.location.search.slice(1), q_array = now_url
    			.split('&');
    	for (var i = 0; i < q_array.length; i++) {
    		var v_array = q_array[i].split('=');
    		if (v_array[0] == name) {
    			return v_array[1];
    		}
    	}
    	return false;
    } 
    function attachLinkToFrame(iframeId, filename) {
    	if (!window.frames[iframeId])
    		return;
    	var head = window.frames[iframeId].document
    			.getElementsByTagName('head').item(0);
    	var fileref = window.frames[iframeId].document.createElement("link");
    	if (!fileref)
    		return;
    	fileref.setAttribute("rel", "stylesheet");
    	fileref.setAttribute("type", "text/css");
    	fileref.setAttribute("href", filename);
    	head.appendChild(fileref);
    }
    function getLinkPrevHref(iframeId) {
    	if (!window.frames[iframeId])
    		return;
    	var head = window.frames[iframeId].document
    			.getElementsByTagName('head').item(0);
    	var links = $("link:first", head);
    	for (var i = 0; links[i]; i++) {
    		var href = $(links[i]).attr("href");
    		if (href && href.toLowerCase().indexOf("ligerui") > 0) {
    			return href.substring(0, href.toLowerCase().indexOf("lib"));
    		}
    	}
    }

    </script>
</head>
<body>
   <!--   <div id='left-body'>
        <table id='role_list'>
        <thead style="border: 2px">角色列表</thead>
        <tbody id='r_list'> 
             
         </tbody>
       
        </table>
     
     </div>
     <div id='right-body'>
      <table id='mp_list'>
        </table>
     </div> -->
   <div id="pageloading"></div>
	<!-- <div id="topmenu" class="l-topmenu">
		<div class="l-topmenu-logo">CLPS MMS导航主页</div>
		<div class="l-topmenu-welcome">
			<label> 皮肤切换：</label> <select id="skinSelect">
				<option value="aqua">默认</option>
				<option value="silvery">Silvery</option>
				<option value="gray">Gray</option>
				<option value="gray2014">Gray2014</option>
			</select> <a href="index.aspx" class="l-link2">服务器版本</a> <span class="space">|</span>
			<a href="http://www.ligerui.com/pay.html" class="l-link2"
				target="_blank">捐赠</a> <span class="space">|</span> <a
				href="http://www.ligerui.com/server.html" class="l-link2"
				target="_blank">服务支持</a>
		</div>
	</div> -->
	<!-- <form> -->
	<!-- <div id="layout1"
		style="width: 99.2%; margin: 0 auto; margin-top: 4px;"> -->
		<!-- <div position="left" title="权限设置" id="accordion1"> -->
			<!-- <div > -->
			<div id="topmenu"></div>
			<div id="toptoolbar"></div>
				<ul id="tree1" style="margin-top: 3px;">
			
			<!-- </div> -->
		 <!-- <div title="应用场景">
				<div style="height: 7px;"></div>
				<a class="l-link" href="http://www.ligerui.com/go.aspx?id=case"
					target="_blank">演示系统</a> <a class="l-link"
					href="javascript:f_addTab('listpage','列表页面','demos/case/listpage.htm')">列表页面</a>
				<a class="l-link" href="demos/dialog/win7.htm" target="_blank">模拟Window桌面</a>
				<a class="l-link"
					href="javascript:f_addTab('week','工作日志','demos/case/week.htm')">工作日志</a>
			</div> -->
			<<!-- div title="实验室">
				<div style="height: 7px;"></div>
				<a class="l-link" href="lab/generate/index.htm" target="_blank">表格表单设计器</a>
				<a class="l-link" href="lab/formdesign/index.htm" target="_blank">可视化表单设计</a>
			</div> -->
		<!-- </div> -->
	<!-- <div position="center" id="framecenter">
			<div tabid="home" style="height: 300px">
				<iframe frameborder="0" name="home" id="home" src="/mms_ssh_jquery/main.htm"></iframe>
			</div>
			<p id="pp"></p>
		</div>  -->
<!-- 	</div> -->
</body>
</html>