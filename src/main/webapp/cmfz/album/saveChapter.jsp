<%@page pageEncoding="UTF-8" %>
<script>
    $(function () {
        $("#album").combobox({
            url:'${pageContext.request.contextPath}/album/findAll',
            valueField:'id',
            textField:'title',
        })
    })
</script>

<div style="text-align: center;">
    <form id="saveChapterInputForm" class="easyui-form" method="post" enctype="multipart/form-data">
        <div style="margin-top: 40px;">
            专辑名字: <input type="text" name="title" class="easyui-textbox">
        </div>
        <div style="margin-top: 20px;">
            专辑内容: <input type="text" name="downPathaa" class="easyui-filebox">
        </div>
        <div style="margin-top: 20px;">
            专辑ID: <input type="text" id="album" name="album_id">
        </div>
    </form>
</div>