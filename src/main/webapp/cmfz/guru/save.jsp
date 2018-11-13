<%@page pageEncoding="UTF-8" %>

<div style="text-align: center;">
    <form id="saveGuruInputForm" class="easyui-form" method="post" enctype="multipart/form-data">
        <div style="margin-top: 40px;">
            名字: <input type="text" name="name" class="easyui-textbox">
        </div>
        <div style="margin-top: 20px;">
            性别:<select type="text" name="sex" class="easyui-combobox" style="width: 145px">
            <option value="男" >男</option>
            <option value="女" >女</option>
        </select>
        </div>
        <div style="margin-top: 20px;">
            图片: <input type="text" name="headPicaa" class="easyui-filebox">
        </div>
    </form>
</div>