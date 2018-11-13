<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>持名法州后台管理中心</title>
			
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    
	<link rel="icon" href="${pageContext.request.contextPath}/cmfz/img/favicon.ico" type="image/x-icon" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/cmfz/css/common.css" type="text/css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/cmfz/css/login.css" type="text/css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/cmfz/script/jquery.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/cmfz/script/common.js"></script>
	<script type="text/javascript">
	</script>
</head>
<body style="background:url(../imgs/15.jpg)no-repeat;">
	
		<div class="login">
			<form id="loginForm" action="${pageContext.request.contextPath}/admin/updatePassword" method="post" >
				<input type="hidden" name="id" value="${requestScope.admin.id}">
				<input type="hidden" name="state" value="${requestScope.admin.state}">
				<table>
					<tbody>
					<tr>
						<td width="190" rowspan="2" align="center" valign="bottom">
							<img src="${pageContext.request.contextPath}/cmfz/img/header_logo.gif" />
						</td>
						<th style="color: #000000;">
							真&nbsp;&nbsp;&nbsp;名:
						</th>
						<td>
							<input type="text"  name="name" class="text" value="${requestScope.admin.name}" maxlength="20"/>
						</td>
					</tr>
					<tr>
						<th style="color: #000000;">
							用户名:
						</th>
						<td>
							<input type="text" name="username" class="text" value="${requestScope.admin.username}" maxlength="20" autocomplete="off"/>
						</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<th style="color: #000000;">密&nbsp;&nbsp;&nbsp;码:</th>
						<td>
							<input type="password" name="password" class="text" value="${requestScope.admin.password}"  maxlength="20" autocomplete="off"/>
						</td>
					</tr>
					<tr>
					

					<tr>
						<td>
							&nbsp;
						</td>
						<th>
							&nbsp;
						</th>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<th>&nbsp;</th>
						<td>
							<input type="submit" class="loginButton" value="修改" style="color: #000000;background: #ffffff">
						</td>
					</tr>
				</tbody></table>
				<div class="powered">COPYRIGHT © 2008-2017</div>
				<div class="link">
					<a href="http://www.chimingfowang.com/">持名佛网首页</a> |
					<a href="http://www.chimingbbs.com/">交流论坛</a> |
					<a href="">关于我们</a> |
					<a href="">联系我们</a> |
					<a href="">授权查询</a>
				</div>
			</form>
		</div>
</body>
</html>