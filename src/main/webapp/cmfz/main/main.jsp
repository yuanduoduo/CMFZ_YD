<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>持名法州主页</title>
    <link rel="stylesheet" type="text/css" href="../themes/black/easyui.css">
    <link rel="stylesheet" type="text/css" href="../themes/IconExtension.css">
    <link rel="stylesheet" type="text/css" href="../themes/icon.css">
    <script type="text/javascript" src="../js/jquery.min.js"></script>
    <script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="../js/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="../js/datagrid-detailview.js"></script>
    <script type="text/javascript">
        <!--菜单处理-->
        $(function () {
            //页面加载完成之后显示菜单数据
            $.post("${pageContext.request.contextPath}/menu/findAll", function (menu) {
                //通过accordion的添加方式追加菜单
                console.log(menu);
                //遍历一级菜单
                $.each(menu, function (inderx, m) {
                    //遍历二级菜单
                    var content = "<div style='text-align: center;'>";
                    $.each(m.children, function (idx, child) {
                        content += "<a onclick=\"addTabs('" + child.name + "','" + child.iconCls + "','" + child.href + "')\"  class='easyui-linkbutton' style='width:95%;margin:10px 0px; border: 2px #cccccc solid;' data-options=\"plain:false,iconCls:'" + child.iconCls + "'\">" + child.name + "</a><br>";
                    });
                    content += "</div>"
                    //添加菜单
                    $("#menu").accordion('add', {
                        title: m.name,
                        iconCls: m.iconCls,
                        content: content,
                    })

                });
            });
        });

        //点击菜单追加选项卡
        function addTabs(title, iconCls, href) {
            //添加以前先判断tabs中是否存在这个选项卡
            if (!$("#tabs").tabs('exists', title)) {
                $("#tabs").tabs('add', {
                    title: title,
                    iconCls: iconCls,
                    closable: true,
                    fit: true,
                    href: "${pageContext.request.contextPath}" + href,
                });
            } else {
                $("#tabs").tabs('select', title);
            }
        }
    </script>

</head>
<body class="easyui-layout">
<div data-options="region:'north',split:true" style="height:60px;background-color:  #4c4c4c">
    <div style="font-size: 24px;color: #FAF7F7;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px">
        持名法州后台管理系统
    </div>
    <div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 300px;float:right;padding-top:15px">
        欢迎您:${sessionScope.admin.name} &nbsp;<a
            href="${pageContext.request.contextPath}/admin/findById?id=${sessionScope.admin.id}"
            class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改密码</a>&nbsp;&nbsp;<a
            href="${pageContext.request.contextPath}/admin/remove" class="easyui-linkbutton"
            data-options="iconCls:'icon-01'">退出系统</a></div>
</div>
<div data-options="region:'south',split:true" style="height: 40px;background: #4c4c4c">
    <div style="text-align: center;font-size:15px; color: #FAF7F7;font-family: 楷体">&copy;百知教育 htf@zparkhr.com.cn</div>
</div>

<div data-options="region:'west',title:'导航菜单',split:true" style="width:220px;">
    <div id="menu" class="easyui-accordion" data-options="fit:true">

    </div>
</div>
<div data-options="region:'center'">
    <div id="tabs" class="easyui-tabs" data-options="fit:true,narrow:true,pill:true">
        <div title="主页" data-options="iconCls:'icon-neighbourhood',"
             style="background-image:url(../imgs/16.jpg);background-repeat: no-repeat;background-size:100% 100%;"></div>
    </div>
</div>
</body>
</html>