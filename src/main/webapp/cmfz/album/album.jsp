<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<script>
    $(function () {
        console.log("${param.id}");
        $("#editAlbumInputForm").form('load', '${pageContext.request.contextPath}/album/findOne?id=${param.id}');
        $("#editAlbumInputForm").form({
            onLoadSuccess: function (data) {
                $("img").attr("src", "${pageContext.request.contextPath}/" + data.coverImg);
            }
        })
    })
</script>
<div style="text-align: center;">
    <form id="editAlbumInputForm" class="easyui-form" method="post" enctype="multipart/form-data">
        <div style="margin-top: 40px;">
            专辑名称: <input type="text" name="title" class="easyui-textbox">
        </div>
        <div style="margin-top: 20px;">
            发布时间: <input type="text" name="publishDate" class="easyui-textbox">
        </div>
        <div style="margin-top: 20px;">
            专辑集数: <input type="text" name="count" class="easyui-textbox">
        </div>
        <div style="margin-top: 20px;">
            专辑封面:
            <img src="">
        </div>
        <div style="margin-top: 20px;">
            专辑评分: <input type="text" name="star" class="easyui-textbox">
        </div>
        <div style="margin-top: 20px;">
            专辑作者: <input type="text" name="author" class="easyui-textbox">
        </div>
        <div style="margin-top: 20px;">
            专辑播音: <input type="text" name="broadCast" class="easyui-textbox">
        </div>
        <div style="margin-top: 20px;">
            专辑简介: <input type="text" name="brief" class="easyui-textbox">
        </div>

    </form>
</div>