<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/back_page/head.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>babasport-list</title>
<script type="text/javascript">
//全选
function checkBox(name,checked) {
	$("input[name='"+name+"']").attr("checked",checked);
}
//批量删除
function optDelete(name,isDisplay) {
	var length=$("input[name='ids']:checked").size();
	if(length<=0){
		alert("请至少选择一个");
		rerutn;
	}
	if (!confirm("您确定删除吗？")) {
		return;
	}
	$("#jvForm").attr("action","${pageContext.request.contextPath}/brand/deletes.do?name="+ name +"&isDisplay=" + isDisplay);
	$("#jvForm").attr("method","POST").submit();
}
</script>
</head>
<body>
<div class="box-positon">
	<div class="rpos">当前位置: 品牌管理 - 列表</div>
	<form class="ropt">
		<input class="add" type="button" value="添加" onclick="javascript:window.location.href='<%=request.getContextPath()%>/brand/toAdd.do'"/>
	</form>
	<div class="clear"></div>
</div>
<div class="body-box">
<form action="<%=request.getContextPath()%>/brand/list.do" method="post" style="padding-top:5px;">
品牌名称: <input type="text" name="name" value="${name }"/>
	<select name="isDisplay">
		<option value="1" <c:if test="${isDisplay==1 }">selected="selected"</c:if> >是</option>
		<option value="0" <c:if test="${isDisplay==0 }">selected="selected"</c:if> >不是</option>
	</select>
	<input type="submit" class="query" value="查询"/>
</form>
<form id="jvForm">
<table cellspacing="1" cellpadding="0" border="0" width="100%" class="pn-ltable">
	<thead class="pn-lthead">
		<tr>
			<th width="20"><input type="checkbox" onclick="checkBox('ids',this.checked)"/></th>
			<th>品牌ID</th>
			<th>品牌名称</th>
			<th>品牌图片</th>
			<th>品牌描述</th>
			<th>排序</th>
			<th>是否可用</th>
			<th>操作选项</th>
		</tr>
	</thead>
	<tbody class="pn-ltbody">
		<c:forEach items="${page.list }" var="brand">
			<tr bgcolor="#ffffff" onmouseout="this.bgColor='#ffffff'" onmouseover="this.bgColor='#eeeeee'">
				<td align="center"><input type="checkbox" value="${brand.id }" name="ids"/></td>
				<td align="center">${brand.id }</td>
				<td align="center">${brand.name }</td>
				<td align="center"><img width="40" height="40" src="${brand.allUrl }"/></td>
				<td align="center">${brand.description }</td>
				<td align="center">${brand.sort }</td>
				<td align="center">
					<c:if test="${brand.isDisplay==1 }">是</c:if>
					<c:if test="${brand.isDisplay==0 }">不是</c:if>
				</td>
				<td align="center">
				<a class="pn-opt" href="<%=request.getContextPath()%>/brand/toEdit.do?id=${brand.id }">修改</a> | 
				<a class="pn-opt" onclick='return confirm("确认要删除吗？")' 
					href="<%=request.getContextPath()%>/brand/delete.do?id=${brand.id }&name=${name }&isDisplay=${isDisplay }">删除</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</form>
<div class="page pb15"><span class="r inb_a page_b">
	
		<a href="<%=request.getContextPath()%>/brand/list.do?pageNum=1&name=${name }&isDisplay=${isDisplay }"><font size="2">首页</font></a>
	
		<a href="<%=request.getContextPath()%>/brand/list.do?pageNum=${page.pageNum-1 }&name=${name }&isDisplay=${isDisplay }"><font size="2">上一页</font></a>
		
		<c:forEach items="${page.navigatepageNums }" var="page_num">
			<c:if test="${page_num==page.pageNum }">
				<a href="#">${page_num }</a>
			</c:if>
			<c:if test="${page_num!=page.pageNum }">
				<a href="<%=request.getContextPath()%>/brand/list.do?pageNum=${page_num }&name=${name }&isDisplay=${isDisplay }">${page_num }</a>
			</c:if>
		</c:forEach>
	
		<a href="<%=request.getContextPath()%>/brand/list.do?pageNum=${page.pageNum+1 }&name=${name }&isDisplay=${isDisplay }"><font size="2">下一页</font></a>
	
		<a href="<%=request.getContextPath()%>/brand/list.do?pageNum=${page.pages }&name=${name }&isDisplay=${isDisplay }"><font size="2">尾页</font></a>
	
		共<var>${page.pages }</var>页 到第<input type="text" size="3" id="PAGENO"/>页 <input type="button" onclick="javascript:window.location.href = '<%=request.getContextPath()%>/brand/list.do?&amp;isShow=0&amp;name=${name }&isDisplay=${isDisplay }&pageNum='+$('#PAGENO').val() " value="确定" class="hand btn60x20" id="skip"/>
	
</span></div>
<div style="margin-top:15px;"><input class="del-button" type="button" value="删除" onclick="optDelete('${name}','${isDisplay}');"/></div>
</div>
</body>
</html>