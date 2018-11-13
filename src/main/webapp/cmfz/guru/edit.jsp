<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<script>
    $(function () {
        console.log("${param.id}");
        $("#editGuruInputForm").form('load', '${pageContext.request.contextPath}/guru/findOne?id=${param.id}');
        $("#editGuruInputForm").form({
            onLoadSuccess:function (data) {
                $("img").attr("src","${pageContext.request.contextPath}/"+data.headPic);
            }
        })
    })
</script>
<div style="text-align: center;">
    <form id="editGuruInputForm" class="easyui-form" method="post" enctype="multipart/form-data">
            <input type="hidden" name="id">
            <input type="hidden" name="headPic">
        <div style="margin-top: 40px;">
            名字: <input type="text" name="name" class="easyui-textbox">
        </div>
        <div style="margin-top: 20px;">
            性别:<select type="text" name="sex"  class="easyui-combobox" style="width: 145px">
            <option value="男" >男</option>
            <option value="女" >女</option>
        </select>
        </div>
        <div style="margin-top: 20px;">
            <img src="">
        </div>
        <div style="margin-top: 20px;">
            图片: <input type="text" name="headPicaa" class="easyui-filebox">
        </div>
    </form>
</div>