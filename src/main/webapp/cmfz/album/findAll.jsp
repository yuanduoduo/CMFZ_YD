<%@page pageEncoding="UTF-8" isELIgnored="false" %>

<script>
    $(function () {
        $("#AlbumDg").treegrid({
            url: "${pageContext.request.contextPath}/album/findAll",//发送请求
            pagination: true,//分页工具栏
            pageNumber: 1,//当前页
            pageSize: 2,//每页显示记录数
            pageList: [2, 5, 10, 15, 100],
            rownumbers: true,
            //singleSelect:false,
            //selectOnCheck:true,
            toolbar: '#CC',
            remoteSort: false,
            nowrap: false,
            fitColumns: true,
            idField: 'id',
            treeField: 'title',
            columns: [[
                //{title:'cks',field:'cks',checkbox:true},
                //{title:'id',field:'id',width:120},
                {title: 'title', field: 'title', width: 120},
                {title: 'size', field: 'size', width: 120},
                {title: 'duration', field: 'duration', width: 120},
                {title: 'downPath', field: 'downPath', width: 120},
                {title: 'uploadTime', field: 'uploadTime', width: 120},
                {
                    title: 'options', field: 'options', width: 220,
                    formatter: function (value, row, index) {
                        return "<a href='javascript:;' class='options' onclick=\"delAlbumRow('" + row.id + "')\" data-options=\"iconCls:'icon-remove',plain:true\">删除</a>"
                    }
                },


            ]],
            onLoadSuccess: function () {
                $(".options").linkbutton();
            },
        });
    });

    //删除一行事件
    function delAlbumRow(id) {
        //获取当前点击id发送ajax请求删除id这个信息
        $.post("${pageContext.request.contextPath}/album/remove", {"id": id}, function (result) {//响应成功后回调
            //刷新datagrid数据
            $("#AlbumDg").treegrid('reload');//刷新当前datagrid
        });
    }

    //批量删除多行
    function delAlbumBatchRows() {
        var rows = $("#AlbumDg").treegrid('getSelections');
        if (rows.length <= 0) {
            $.messager.show({title: '提示', msg: '至少选中一行！！！'});
        } else {
            var ids = [];
            for (var i = 0; i < rows.length; i++) {
                console.log(rows[i].id);
                ids.push(rows[i].id);
            }
            console.log(ids);
            // 发送ajax请求传递数组 注意：$.get   $.post 只能传递简单数据（key=value）不能传递数组类型的数据
            //                   如果想要传递数组类型的数据只能使用$.ajax 并且还要设置其中的一个属性
            $.ajax({
                url: "${pageContext.request.contextPath}/album/remove",
                type: "POST",
                traditional: true,//传递数据类型时必须设置这个属性为true
                data: {ids: ids},
                success: function (result) {
                    if (result.success) {
                        //提示消息
                        $.messager.show({title: '提示', msg: result.message});
                    } else {
                        $.messager.show({title: '提示', msg: result.message});
                    }
                    $("#AlbumDg").treegrid('reload');//刷新当前datagrid
                },
            })
        }
    }

    function openSaveAlbumDialog() {
        $("#saveAlbumDialog").dialog({
            href: '${pageContext.request.contextPath}/cmfz/album/save.jsp',
            title:'添加专辑',
            buttons: [{
                iconCls: 'icon-save',
                text: '保存',
                handler: function () {
                    //保存用户信息
                    $("#saveAlbumInputForm").form('submit', {
                        url: '${pageContext.request.contextPath}/album/save',
                        success: function (result) {//响应的一定是json格式字符串   使用应该先转为js对象
                            var resultObj = $.parseJSON(result);
                            if (resultObj.success) {
                                //提示信息
                                $.messager.show({title: '提示', msg: resultObj.message});
                            } else {
                                //提示信息
                                $.messager.show({title: '提示', msg: resultObj.message});
                            }
                            //关闭对话框
                            $("#saveAlbumDialog").dialog('close');
                            //刷新datagrid
                            $("#AlbumDg").treegrid('reload');
                        }
                    });
                }
            }, {
                iconCls: 'icon-cancel',
                text: '关闭',
                handler: function () {
                    $("#saveAlbumDialog").dialog('close');
                }
            }]
        });
    }

    function openSaveChapterDialog() {
        $("#saveAlbumDialog").dialog({
            href: '${pageContext.request.contextPath}/cmfz/album/saveChapter.jsp',
            title:'添加章节',
            buttons: [{
                iconCls: 'icon-save',
                text: '保存',
                handler: function () {
                    //保存用户信息
                    $("#saveChapterInputForm").form('submit', {
                        url: '${pageContext.request.contextPath}/chapter/save',
                        success: function (result) {//响应的一定是json格式字符串   使用应该先转为js对象
                            var resultObj = $.parseJSON(result);
                            if (resultObj.success) {
                                //提示信息
                                $.messager.show({title: '提示', msg: resultObj.message});
                            } else {
                                //提示信息
                                $.messager.show({title: '提示', msg: resultObj.message});
                            }
                            //关闭对话框
                            $("#saveAlbumDialog").dialog('close');
                            //刷新datagrid
                            $("#AlbumDg").treegrid('reload');
                        }
                    });
                }
            }, {
                iconCls: 'icon-cancel',
                text: '关闭',
                handler: function () {
                    $("#saveAlbumDialog").dialog('close');
                }
            }]
        });
    }

    function openSaveAlbumOneDialog() {
        var rows = $("#AlbumDg").treegrid('getSelected');
            if (rows==null || rows.id.length == 36) {
                $.messager.show({title: '提示', msg: '请选中一张专辑！！！'});
            } else {
                $("#saveAlbumDialog").dialog({
                    href: '${pageContext.request.contextPath}/cmfz/album/album.jsp?id=' + rows.id,
                    title:'专辑详情',
                    buttons: [{
                        iconCls: 'icon-cancel',
                        text: '关闭',
                        handler: function () {
                            $("#saveAlbumDialog").dialog('close');
                        }
                    }]
                });
            }
    }

    function openDownLoadOneDialog() {
        var rows = $("#AlbumDg").treegrid('getSelected');
        if (rows == null || rows.id.length < 36) {
            $.messager.show({title: '提示', msg: '请选中一个音频！！！'});
        } else {
            $("#saveAlbumDialog").dialog({
                href: '${pageContext.request.contextPath}/cmfz/album/down.jsp?id=' + rows.downPath,
                title:'下载音频',
                buttons: [{
                    iconCls: 'icon-cancel',
                    text: '关闭',
                    handler: function () {
                        $("#saveAlbumDialog").dialog('close');
                    }
                }]
            });
        }
    }

</script>
<table id="AlbumDg" class="easyui-treegrid" data-options="fit:true">


</table>
<div id="CC">
    <a class="easyui-linkbutton" onclick="openSaveAlbumOneDialog();"
       data-options="iconCls:'icon-add',plain:true">专辑详情</a>
    <a class="easyui-linkbutton" onclick="openSaveAlbumDialog();" data-options="iconCls:'icon-add',plain:true">添加专辑</a>
    <a class="easyui-linkbutton" onclick="openSaveChapterDialog();"
       data-options="iconCls:'icon-add',plain:true">添加章节</a>
    <a class="easyui-linkbutton" onclick="openDownLoadOneDialog();"
       data-options="iconCls:'icon-add',plain:true">下载音频</a>
    <a class="easyui-linkbutton" onclick="delAlbumBatchRows();" data-options="iconCls:'icon-remove',plain:true">批量删除</a>
</div>
<div id="saveAlbumDialog" data-options="draggable:false,iconCls:'icon-save',width:600,height:400,">
</div>

<div id="editAlbumDialog" data-options="draggable:false,iconCls:'icon-edit',width:600,height:400,"></div>
