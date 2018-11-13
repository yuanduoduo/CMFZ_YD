<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<script>
    $(function () {
        console.log("${param.id}");
        $("#editCourseInputForm").form('load', '${pageContext.request.contextPath}/course/findOne?id=${param.id}');
    })
</script>
<div style="text-align: center;">
    <form id="editCourseInputForm" class="easyui-form" method="post">
        <input type="hidden" name="id">
        <div style="margin-top: 20px;">
            名字: <input type="text" name="title" class="easyui-textbox">
        </div>
        <div style="margin-top: 20px;">
            标志: <input type="text" name="marking" class="easyui-textbox">
        </div>
        <div style="margin-top: 20px;">
            时间: <input type="text" name="creatTime" class="easyui-datebox">
        </div>
    </form>
</div>