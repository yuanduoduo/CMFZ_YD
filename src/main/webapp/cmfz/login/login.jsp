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
        function show(){
            //显示验证码
            document.getElementById("imgVcode").src="${pageContext.request.contextPath}/code/code";
        }
        window.onload = function() {
            //document.onload=show();
            show();//页面加载时加载验证码
            //这时无论在ie还是在firefox中，js没有加载完，页面的东西是不会被执行的；
        }
	</script>
</head>
<body style="background:url(../imgs/16.jpg)no-repeat;">
	
		<div class="login">
			<form id="loginForm" action="${pageContext.request.contextPath}/admin/login" method="post" >
				
				<table>
					<tbody>
						<tr>
							<td width="190" rowspan="2" align="center" valign="bottom">
								<img src="../img/header_logo.gif" />
							</td>
							<th style="color: #ffffff;">
								用户名:
							</th>
							<td>
								<input type="text"  name="username" class="text" value="请输入账号" onfocus="javascript:if(this.value=='请输入账号')this.value='';" onblur="javascript:if(this.value=='')this.value='请输入账号';" value="用户名" maxlength="20"/>
							</td>
					  </tr>
					  <tr>
							<th style="color: #ffffff;">
								密&nbsp;&nbsp;&nbsp;码:
							</th>
							<td>
								<input type="password" name="password" class="text" value="请输入密码" onfocus="javascript:if(this.value=='请输入密码')this.value='';" onblur="javascript:if(this.value=='')this.value='请输入密码';" maxlength="20" autocomplete="off"/>
							</td>
					  </tr>
					
						<tr>
							<td>&nbsp;</td>
							<th style="color: #ffffff;">验证码:</th>
							<td>
								<input type="text" id="enCode" name="enCode" class="text captcha" maxlength="4" autocomplete="off"/>
								<a onclick="javascript:show();return false"><img id='imgVcode' src="${pageContext.request.contextPath}/code/code"/></a><br />
							</td>
						</tr>					
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
							<input type="submit" class="loginButton" value="登录" style="color: #000000;background:#ffffff">
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