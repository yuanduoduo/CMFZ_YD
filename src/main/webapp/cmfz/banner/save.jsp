<%@page pageEncoding="UTF-8" %>

<div style="text-align: center;">
    <form id="saveBannerInputForm" class="easyui-form" method="post" enctype="multipart/form-data">
        <div style="margin-top: 20px;">
            名字: <input type="text" name="title" class="easyui-textbox">
        </div>
        <div style="margin-top: 20px;">
            介绍: <input type="text" name="descA" class="easyui-textbox">
        </div>
        <div style="margin-top: 20px;">
            状态: <select type="text" name="status" id="status" class="easyui-combobox" style="width: 145px">
            <option value="y">显示</option>
            <option value="n">隐藏</option>
        </select>
        </div>
        <div style="margin-top: 20px;">
            添加时间: <input type="date" name="createDate" class="easyui-datebox">
        </div>
        <div style="margin-top: 20px;">
            图片: <input type="text" name="imgPathaa" class="easyui-filebox">
        </div>
    </form>
</div>