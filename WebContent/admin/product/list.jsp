<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<HTML>
<HEAD>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/css/Style1.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/public.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>


<script type="text/javascript">

	function changePage(pageNum){
		//1 将页码的值放入对应表单隐藏域中
			$("#currentPageInput").val(pageNum);
		//2 提交表单
			$("#pageForm").submit();
	};
	
	function changePageSize(pageSize){
		//1 将页码的值放入对应表单隐藏域中
		$("#pageSizeInput").val(pageSize);
	//2 提交表单
		$("#pageForm").submit();
	};
	
	function addProduct(){
		window.location.href = "${pageContext.request.contextPath}/admin/product/add.jsp";
	} 

/* function delProduct(pid){
	var isDel = confirm("您确认要删除吗？");
	if(isDel){
		//要删除
		location.href = "${pageContext.request.contextPath}/adminDelProduct?pid="+pid;
	}
} */
</script>
</HEAD>
<body>
	<br>


	<%-- <form id="Form1" name="Form1"
		action="${pageContext.request.contextPath }/ProductAction_list"
		method="post"> --%>
	<table cellSpacing="1" cellPadding="0" width="100%" align="center"
		bgColor="#f5fafe" border="0">
		<tr>
			<td class="ta_01" align="center" bgColor="#afd1f3"><strong>商品列表</strong>
			</TD>
		</tr>
		<tr>
			<form id="pageForm" name="productForm" width="100%"
				action="${pageContext.request.contextPath }/ProductAction_list"
				method=post text-align: center>
				<!-- 隐藏域.当前页码 -->
				<input type="hidden" name="currentPage" id="currentPageInput"
					value="<s:property value="#pageBean.currentPage" />" />
				<!-- 隐藏域.每页显示条数 -->
				<input type="hidden" name="pageSize" id="pageSizeInput"
					value="<s:property value="#pageBean.pageSize" />" />
				<table cellSpacing="1" cellPadding="0" width="100%" align="center"
					bgColor="#f5fafe" border="0">
					<tr>
						<td>商品名称： <input class=textbox id=sChannel2
							style="width: 80px" maxLength=50 name="pname"
							value="${param.pname}"> <input class=button id=sButton2
							type=submit value=" 筛选 " name=sButton2>
						</td>
						<td class="ta_01" align="right">
							<button type="button" id="add" name="add" value="添加"
								class="button_add" onclick="addProduct()">
								&#28155;&#21152;</button>
						</td>
					</tr>
				</table>

			</form>
		</tr>
		<!-- <tr>
			<td class="ta_01" align="right">
				<button type="button" id="add" name="add" value="添加"
					class="button_add" onclick="addProduct()">
					&#28155;&#21152;</button>

			</td>
		</tr> -->
		<tr>
			<td class="ta_01" align="center" bgColor="#f5fafe">
				<table cellspacing="0" cellpadding="1" rules="all"
					bordercolor="gray" border="1" id="DataGrid1"
					style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
					<tr
						style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">

						<td align="center" width="18%">序号</td>
						<td align="center" width="17%">商品图片</td>
						<td align="center" width="17%">商品名称</td>
						<td align="center" width="17%">商品价格</td>
						<td align="center" width="17%">是否热门</td>
						<td width="7%" align="center">编辑</td>
						<td width="7%" align="center">删除</td>
					</tr>
					<c:forEach items="${pageBean.list}" var="pro" varStatus="vs">

						<tr onmouseover="this.style.backgroundColor = 'white'"
							onmouseout="this.style.backgroundColor = '#F5FAFE';">
							<td style="cursor: hand; height: 22px" align="center" width="18%">${vs.count }</td>
							<td style="cursor: hand; height: 22px" align="center" width="17%"><img
								width="40" height="45"
								src="${pageContext.request.contextPath }/${pro.pimage }">
							</td>
							<td style="cursor: hand; height: 22px" align="center" width="17%">${pro.pname }</td>
							<td style="cursor: hand; height: 22px" align="center" width="17%">${pro.shopPrice }</td>
							<td style="cursor: hand; height: 22px" align="center" width="17%">${pro.isHot==1?"是":"否" }</td>
							<td align="center" style="height: 22px"><a
								href="${ pageContext.request.contextPath }/adminUpdateProductUI?pid=${pro.pid}">
									<img src="${pageContext.request.contextPath}/images/i_edit.gif"
									border="0" style="cursor: hand">
							</a></td>

							<td align="center" style="height: 22px"><a
								href="javascript:void(0);" onclick="delProduct('${pro.pid}')">
									<img src="${pageContext.request.contextPath}/images/i_del.gif"
									width="16" height="16" border="0" style="cursor: hand">
							</a></td>
						</tr>

					</c:forEach>
				</table>
			</td>

			<tr><td><span id=pagelink>
					<div style="line-height: 20px; height: 20px; text-align: center">
						共[<b><s:property value="#pageBean.totalCount" /> </b>]条记录,[<b><s:property
								value="#pageBean.totalPage" /></b>]页 ,每页显示 <select name="pageSize"
							onchange="changePageSize($('#pageSizeSelect option:selected').val())"
							id="pageSizeSelect">
							<option value="8"
								<s:property value="#pageBean.pageSize==8?'selected':''" />>8</option>
							<option value="10"
								<s:property value="#pageBean.pageSize==10?'selected':''" />>10</option>
						</select> 条 [<a href="javaScript:void(0)"
							onclick="changePage(<s:property value='#pageBean.currentPage-1' />)">前一页</a>]
						<b><s:property value="#pageBean.currentPage" /></b> [<a
							href="javaScript:void(0)"
							onclick="changePage(<s:property value='#pageBean.currentPage+1' />)">后一页</a>]
						到 <input type="text" size="3" id="page" name="page"
							value="<s:property value="#pageBean.currentPage" />" /> 页 <input
							type="button" value="Go" onclick="changePage($('#page').val())" />
					</div>
			</span></td>
		</tr>








		</tr>
	</table>
	<!-- </form> -->
</body>
</HTML>

