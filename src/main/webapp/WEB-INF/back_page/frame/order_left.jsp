<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>product-left</title>
<link href="<%=request.getContextPath() %>/res/itcast/css/admin.css" rel="stylesheet" type="text/css"/>
<link href="<%=request.getContextPath() %>/res/common/css/theme.css" rel="stylesheet" type="text/css"/>
<link href="<%=request.getContextPath() %>/res/common/css/jquery.validate.css" rel="stylesheet" type="text/css"/>
<link href="<%=request.getContextPath() %>/res/common/css/jquery.treeview.css" rel="stylesheet" type="text/css"/>
<link href="<%=request.getContextPath() %>/res/common/css/jquery.ui.css" rel="stylesheet" type="text/css"/>

<!-- <script src="/thirdparty/ckeditor/ckeditor.js" type="text/javascript"></script> -->
<!-- <script src="/thirdparty/My97DatePicker/WdatePicker.js" type="text/javascript"></script> -->
<script type="text/javascript" src="<%=request.getContextPath() %>/res/fckeditor/fckeditor.js"></script>
<script src="<%=request.getContextPath() %>/res/common/js/jquery.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/res/common/js/jquery.ext.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/res/common/js/jquery.form.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/res/common/js/itcast.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/res/itcast/js/admin.js" type="text/javascript"></script>
</head>
<body class="lbody">
<div class="left">
<%@ include file="/WEB-INF/back_page/date.jsp" %>
     <ul class="w-lful">
		<li><a target="rightFrame" href="<%=request.getContextPath()%>/order/list.do?isPaiy=0">货到付款</a></li>
		<li><a target="rightFrame" href="<%=request.getContextPath()%>/order/list.do?isPaiy=1">待付款</a></li>
		<li><a target="rightFrame" href="<%=request.getContextPath()%>/order/list.do?isPaiy=5">已取消</a></li>
		<li><a target="rightFrame" href="<%=request.getContextPath()%>/order/list.do?isPaiy=2">已付款</a></li>
		<li><a target="rightFrame" href="<%=request.getContextPath()%>/order/list.do?state=1">仓库配货</a></li>
		<li><a target="rightFrame" href="<%=request.getContextPath()%>/order/list.do?state=2">商品出库</a></li>
		<li><a target="rightFrame" href="<%=request.getContextPath()%>/order/list.do?state=3">等待收货</a></li>
		<li><a target="rightFrame" href="<%=request.getContextPath()%>/order/list.do?state=4">已完成</a></li>
		<li><a target="rightFrame" href="<%=request.getContextPath()%>/order/list.do?state=5">待退货</a></li>
		<li><a target="rightFrame" href="<%=request.getContextPath()%>/order/list.do?isPaiy=3">待退款</a></li>
		<li><a target="rightFrame" href="<%=request.getContextPath()%>/order/list.do?state=6">已退货</a></li>
		<li><a target="rightFrame" href="<%=request.getContextPath()%>/order/list.do?isPaiy=4">已退款</a></li>
     </ul>
</div>
</body>
</html>