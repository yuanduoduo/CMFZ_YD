<%@page pageEncoding="UTF-8" %>

<div style="text-align: center;">
    <form id="saveAlbumInputForm" class="easyui-form" method="post" enctype="multipart/form-data">
        <div style="margin-top: 40px;">
            专辑名字: <input type="text" name="title" class="easyui-textbox">
        </div>
        <div style="margin-top: 20px;">
            专辑封面: <input type="text" name="coverImgaa" class="easyui-filebox">
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