<%@page pageEncoding="UTF-8" isELIgnored="false"%>

<script>
    $(function () {
        $("#GuruDg").datagrid({
            url:"${pageContext.request.contextPath}/guru/findAll",//发送请求
            pagination:true,//分页工具栏
            pageNumber:1,//当前页
            pageSize:2,//每页显示记录数
            pageList:[2,5,10,15,100],
            rownumbers:true,
            singleSelect:false,
            selectOnCheck:true,
            toolbar:'#AA',
            remoteSort:false,
            nowrap:false,
            fitColumns:true,
            onLoadSuccess:function () {
                $(".options").linkbutton();
            },
            columns:[[
                {title:'cks',field:'cks',checkbox:true},
                {title:'id',field:'id',width:120},
                {title:'name',field:'name',width:120},
                {title:'headPic',field:'headPic',width:120},
                {title:'sex',field:'sex',width:120},
                {title:'options',field:'options',width:220,
                    formatter:function (value,row,index) {
                        return "<a href='javascript:;' class='options' onclick=\"delGuruRow('"+row.id+"')\" data-options=\"iconCls:'icon-remove',plain:true\">删除</a>&nbsp;&nbsp;"+
                            "<a href='javascript:;' class='options' onclick=\"openEditGuruDialog('"+row.id+"')\" data-options=\"iconCls:'icon-edit',plain:true\">更新</a>";
                    }
                },


            ]],
            view:detailview,
            detailFormatter: function(rowIndex, rowData){
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/'+rowData.headPic+'" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '<p>name: ' + rowData.name + '</p>' +
                    '<p>sex: ' + rowData.sex + '</p>' +
                    '</td>' +
                    '</tr></table>';
            }

        });
    });
    function openEditGuruDialog(id) {
        $("#editGuruDialog").dialog({
            href:'${pageContext.request.contextPath}/cmfz/guru/edit.jsp?id='+id,
            title:'修改上师',
            buttons:[
                {
                    iconCls:'icon-save',
                    text:"修改",
                    handler:function () {
                        $("#editGuruInputForm").form('submit',{
                            url:"${pageContext.request.contextPath}/guru/motify",
                            success:function (result) {//注意一定是json字符串   使用需要转为js对象
                                //关闭dialog
                                $("#editGuruDialog").dialog('close');
                                //刷新datagrid
                                $("#GuruDg").datagrid('reload');//刷新当前datagrid
                                var parseJSON = $.parseJSON(result);
                                if(parseJSON.success){
                                    //提示修改信息
                                    $.messager.show({title:'提示',msg:parseJSON.message});
                                }else{
                                    $.messager.show({title:'提示',msg:parseJSON.message});
                                }

                            }
                        })
                    }
                },
                {
                    iconCls:'icon-cancel',
                    text:'取消',
                    handler:function () {
                        $("#editGuruDialog").dialog('close');
                    }
                },
            ]
        });
    }
    //删除一行事件
    function delGuruRow(id) {
        //获取当前点击id发送ajax请求删除id这个信息
        $.post("${pageContext.request.contextPath}/guru/remove",{"id":id},function (result) {//响应成功后回调
            //刷新datagrid数据
            $("#GuruDg").datagrid('reload');//刷新当前datagrid
        });
    }

    //批量删除多行
    function delGuruBatchRows() {
        var rows=$("#GuruDg").datagrid('getSelections');
        if (rows.length<=0){
            $.messager.show({title:'提示',msg:'至少选中一行！！！'});
        } else{
            var ids=[];
            for (var i=0;i<rows.length;i++){
                console.log(rows[i].id);
                ids.push(rows[i].id);
            }
            console.log(ids);
            // 发送ajax请求传递数组 注意：$.get   $.post 只能传递简单数据（key=value）不能传递数组类型的数据
            //                   如果想要传递数组类型的数据只能使用$.ajax 并且还要设置其中的一个属性
            $.ajax({
                url:"${pageContext.request.contextPath}/guru/remove",
                type:"POST",
                traditional:true,//传递数据类型时必须设置这个属性为true
                data:{ids:ids},
                success:function (result) {
                    if(result.success){
                        //提示消息
                        $.messager.show({title:'提示',msg:result.message});
                    }else{
                        $.messager.show({title:'提示',msg:result.message});
                    }
                    $("#GuruDg").datagrid('reload');//刷新当前datagrid
                },
            })
        }
    }
    function openSaveGuruDialog() {
        $("#saveGuruDialog").dialog({
            href:'${pageContext.request.contextPath}/cmfz/guru/save.jsp',
            title:'添加上师',
            buttons:[{
                iconCls:'icon-save',
                text:'保存',
                handler:function(){
                    //保存用户信息
                    $("#saveGuruInputForm").form('submit',{
                        url:'${pageContext.request.contextPath}/guru/save',
                        success:function(result){//响应的一定是json格式字符串   使用应该先转为js对象
                            var resultObj = $.parseJSON(result);
                            if(resultObj.success){
                                //提示信息
                                $.messager.show({title:'提示',msg:resultObj.message});
                            }else{
                                //提示信息
                                $.messager.show({title:'提示',msg:resultObj.message});
                            }
                            //关闭对话框
                            $("#saveGuruDialog").dialog('close');
                            //刷新datagrid
                            $("#GuruDg").datagrid('reload');
                        }
                    });
                }
            },{
                iconCls:'icon-cancel',
                text:'关闭',
                handler:function(){
                    $("#saveGuruDialog").dialog('close');
                }
            }]
        });
    }
</script>
<table id="GuruDg" class="easyui-datagrid" data-options="fit:true">


</table>
<div id="AA">
    <a class="easyui-linkbutton" onclick="openSaveGuruDialog();" data-options="iconCls:'icon-add',plain:true">添加</a>
    <a class="easyui-linkbutton" onclick="delGuruBatchRows();" data-options="iconCls:'icon-remove',plain:true">批量删除</a>
</div>
<div id="saveGuruDialog" data-options="draggable:false,iconCls:'icon-save',width:600,height:400,">
</div>
<%--更新用户对话框--%>
<div id="editGuruDialog" data-options="draggable:false,iconCls:'icon-edit',width:600,height:400,"></div>
