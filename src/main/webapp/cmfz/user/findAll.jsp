<%@page pageEncoding="UTF-8" isELIgnored="false"%>

<script>
    $(function () {
        $("#UserDg").datagrid({
            url:"${pageContext.request.contextPath}/user/findAll",//发送请求
            pagination:true,//分页工具栏
            pageNumber:1,//当前页
            pageSize:2,//每页显示记录数
            pageList:[2,5,10,15,100],
            rownumbers:true,
            singleSelect:false,
            selectOnCheck:true,
            toolbar:'#UU',
            remoteSort:false,
            nowrap:false,
            fitColumns:true,
            onLoadSuccess:function () {
                $(".options").linkbutton();
            },
            columns:[[
                {title:'cks',field:'cks',checkbox:true},
                {title:'账号',field:'id',width:120},
                {title:'手机号',field:'phoneNum',width:120},
                {title:'用户名',field:'username',width:120},
                {title:'密码',field:'password',width:120},
                {title:'省份',field:'province',width:120},
                {title:'城市',field:'city',width:120},
                {title:'法名',field:'nickName',width:120},
                {title:'性别',field:'gender',width:120},
                {title:'签名',field:'sign',width:120},
                {title:'图片路径',field:'headPic',width:120},
                {title:'状态',field:'status',width:120},
                {title:'注册时间',field:'createDate',width:120},
                {title:'options',field:'options',width:220,
                    formatter:function (value,row,index) {
                        return "<a href='javascript:;' class='options' onclick=\"delUserRow('"+row.id+"')\" data-options=\"iconCls:'icon-remove',plain:true\">删除</a>&nbsp;&nbsp;"+
                            "<a href='javascript:;' class='options' onclick=\"openEditUserDialog('"+row.id+"')\" data-options=\"iconCls:'icon-edit',plain:true\">更新</a>";
                    }
                },


            ]],
            view:detailview,
            detailFormatter: function(rowIndex, rowData){
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/'+rowData.headPic+'" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '<p>name: ' + rowData.username + '</p>' +
                    '<p>sex: ' + rowData.password + '</p>' +
                    '</td>' +
                    '</tr></table>';
            }

        });
    });
    function openEditUserDialog(id) {
        $("#editUserDialog").dialog({
            href:'${pageContext.request.contextPath}/cmfz/user/edit.jsp?id='+id,
            title:'修改用户',
            buttons:[
                {
                    iconCls:'icon-save',
                    text:"修改",
                    handler:function () {
                        $("#editUserInputForm").form('submit',{
                            url:"${pageContext.request.contextPath}/user/motify",
                            success:function (result) {//注意一定是json字符串   使用需要转为js对象
                                //关闭dialog
                                $("#editUserDialog").dialog('close');
                                //刷新datagrid
                                $("#UserDg").datagrid('reload');//刷新当前datagrid
                                var parseJSON = $.parseJSON(result);
                                if(parseJSON.success){
                                    //提示修改信息
                                    $.messager.show({title:'提示',msg:result.message});
                                }else{
                                    $.messager.show({title:'提示',msg:result.message});
                                }

                            }
                        })
                    }
                },
                {
                    iconCls:'icon-cancel',
                    text:'取消',
                    handler:function () {
                        $("#editUserDialog").dialog('close');
                    }
                },
            ]
        });
    }
    //删除一行事件
    function delUserRow(id) {
        //获取当前点击id发送ajax请求删除id这个信息
        $.post("${pageContext.request.contextPath}/user/remove",{"id":id},function (result) {//响应成功后回调
            //刷新datagrid数据
            $("#UserDg").datagrid('reload');//刷新当前datagrid
        });
    }

    //批量删除多行
    function delUserBatchRows() {
        var rows=$("#UserDg").datagrid('getSelections');
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
                url:"${pageContext.request.contextPath}/user/remove",
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
                    $("#UserDg").datagrid('reload');//刷新当前datagrid
                },
            })
        }
    }
    function openSaveUserDialog() {
        $("#saveUserDialog").dialog({
            href:'${pageContext.request.contextPath}/cmfz/user/save.jsp',
            title:'添加用户',
            buttons:[{
                iconCls:'icon-save',
                text:'保存',
                handler:function(){
                    //保存用户信息
                    $("#saveUserInputForm").form('submit',{
                        url:'${pageContext.request.contextPath}/user/save',
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
                            $("#saveUserDialog").dialog('close');
                            //刷新datagrid
                            $("#UserDg").datagrid('reload');
                        }
                    });
                }
            },{
                iconCls:'icon-cancel',
                text:'关闭',
                handler:function(){
                    $("#saveUserDialog").dialog('close');
                }
            }]
        });
    }
    function loginUser() {
        $("#saveUserDialog").dialog({
            href:'${pageContext.request.contextPath}/cmfz/user/loginUser.jsp',
            title:'登陆',
            buttons:[{
                iconCls:'icon-save',
                text:'登陆',
                handler:function(){
                    //保存用户信息
                    $("#loginUserFrom").form('submit',{
                        url:'${pageContext.request.contextPath}/user/loginUser',
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
                            $("#saveUserDialog").dialog('close');
                            //刷新datagrid
                            $("#UserDg").datagrid('reload');
                        }
                    });
                }
            },{
                iconCls:'icon-cancel',
                text:'关闭',
                handler:function(){
                    $("#saveUserDialog").dialog('close');
                }
            }]
        });
    }
</script>
<table id="UserDg" class="easyui-datagrid" data-options="fit:true">


</table>
<div id="UU">
    <a class="easyui-linkbutton" onclick="openSaveUserDialog();" data-options="iconCls:'icon-add',plain:true">添加</a>
    <a class="easyui-linkbutton" onclick="delUserBatchRows();" data-options="iconCls:'icon-remove',plain:true">批量删除</a>
    <a class="easyui-linkbutton" onclick="loginUser();" data-options="iconCls:'icon-remove',plain:true">验证登陆</a>
</div>
<div id="saveUserDialog" data-options="draggable:false,iconCls:'icon-save',width:600,height:400,">
</div>
<%--更新用户对话框--%>
<div id="editUserDialog" data-options="draggable:false,iconCls:'icon-edit',width:600,height:400,"></div>
