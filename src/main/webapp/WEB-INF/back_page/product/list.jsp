<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/back_page/head.jsp" %>
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
//删除
function optDelete() {
	var length=$("input[name='ids']:checked").size();
	if(length<=0){
		alert("请至少选择一个");
		rerutn;
	}
	if(!confirm("确定删除吗?")) {
		return;
	}
	var f = getTableForm();
	f.action="o_delete.do";
	f.submit();
}
//上架
function isShow(pageNum,name,brandId,isShow) {
	var length=$("input[name='ids']:checked").size();
	if(length<=0){
		alert("请至少选择一个");
		rerutn;
	}
	if(!confirm("确定上架吗?")) {
		return;
	}
	$("#tableForm").attr("action","${pageContext.request.contextPath}/product/isShow.do?pageNum="+pageNum+
				"&name="+name+"&brandId="+brandId+"&isShow="+isShow);
	$("#tableForm").submit();
}
</script>
</head>
<body>
<div class="box-positon">
	<div class="rpos">当前位置: 商品管理 - 列表</div>
	<form class="ropt">
		<input class="add" type="button" value="添加" onclick="javascript:window.location.href='<%=request.getContextPath()%>/product/toAdd.do'"/>
	</form>
	<div class="clear"></div>
</div>
<div class="body-box">
<form action="<%=request.getContextPath() %>/product/list.do" method="post" style="padding-top:5px;">
名称: <input type="text" value="${name }" name="name"/>
	<select name="brandId">
		<option value="">请选择品牌</option>
		<c:forEach items="${brands }" var="brand">
			<option value="${brand.id }" <c:if test="${brandId==brand.id }">selected="selected"</c:if>>${brand.name }</option>
		</c:forEach>
	</select>
	<select name="isShow">
		<option value="1" <c:if test="${isShow == 1 }">selected="selected"</c:if>>上架</option>
		<option value="0" <c:if test="${isShow == 0 }">selected="selected"</c:if>>下架</option>
	</select>
	<input type="submit" class="query" value="查询"/>
</form>
<form method="post" id="tableForm">
<table cellspacing="1" cellpadding="0" width="100%" border="0" class="pn-ltable">
	<thead class="pn-lthead">
		<tr>
			<th width="20"><input type="checkbox" onclick="checkbox('ids',this.checked)"/></th>
			<th>商品编号</th>
			<th>商品名称</th>
			<th>图片</th>
			<th width="4%">新品</th>
			<th width="4%">热卖</th>
			<th width="4%">推荐</th>
			<th width="4%">上下架</th>
			<th width="12%">操作选项</th>
		</tr>
	</thead>
	<tbody class="pn-ltbody">
		<c:forEach items="${page.list }" var="product">
		<tr bgcolor="#ffffff" onmouseover="this.bgColor='#eeeeee'" onmouseout="this.bgColor='#ffffff'">
			<td align="center"><input type="checkbox" name="ids" value="${product.id }"/></td>
			<td align="center">${product.no }</td>
			<td align="center">${product.name }</td>
			<td align="center"><img width="50" height="50" src="${product.img.allUrl }"/></td>
			<td align="center">${product.isNew }</td>
			<td align="center">${product.isHot }</td>
			<td align="center">${product.isCommend }</td>
			<td align="center">${product.isShow }</td>
			<td align="center">
			<a href="#" class="pn-opt">查看</a> | <a href="#" class="pn-opt">修改</a> | 
			<a href="#" onclick="if(!confirm('您确定删除吗？')) {return false;}" class="pn-opt">删除</a> | 
			<a href="<%=request.getContextPath() %>/sku/list.do?productNo=${product.no }" class="pn-opt">库存</a>
			</td>
		</tr>
		</c:forEach>
	</tbody>
</table>
<div class="page pb15"><span class="r inb_a page_b">
	
		<a href="<%=request.getContextPath()%>/product/list.do?pageNum=1&name=${name }&brandId=${brandId }&isShow=${isShow}"><font size="2">首页</font></a>
	
		<a href="<%=request.getContextPath()%>/product/list.do?pageNum=${page.pageNum-1 }&name=${name }&brandId=${brandId }&isShow=${isShow}"><font size="2">上一页</font></a>
		
		<c:forEach items="${page.navigatepageNums }" var="page_num">
			<c:if test="${page_num==page.pageNum }">
				<a href="#">${page_num }</a>
			</c:if>
			<c:if test="${page_num!=page.pageNum }">
				<a href="<%=request.getContextPath()%>/product/list.do?pageNum=${page_num }&name=${name }&brandId=${brandId }&isShow=${isShow}">${page_num }</a>
			</c:if>
		</c:forEach>
	
		<a href="<%=request.getContextPath()%>/product/list.do?pageNum=${page.pageNum+1 }&name=${name }&brandId=${brandId }&isShow=${isShow}"><font size="2">下一页</font></a>
	
		<a href="<%=request.getContextPath()%>/product/list.do?pageNum=${page.pages }&name=${name }&brandId=${brandId }&isShow=${isShow}"><font size="2">尾页</font></a>
	
		共<var>${page.pages}</var>页 到第<input type="text" size="3" id="PAGENO"/>页 <input type="button" onclick="javascript:window.location.href = '<%=request.getContextPath()%>/product/list.do?name=${name }&brandId=${brandId }&isShow=${isShow}&pageNum='+$('#PAGENO').val() " value="确定" class="hand btn60x20" id="skip"/>
	
</span></div>
<div style="margin-top:15px;"><input class="del-button" type="button" value="删除" onclick="optDelete();"/><input class="add" type="button" value="上架" onclick="isShow('${page.pageNum}','${name}','${brandId}','${isShow}');"/><input class="del-button" type="button" value="下架" onclick="optDelete();"/></div>
</form>
</div>
</body>
</html>