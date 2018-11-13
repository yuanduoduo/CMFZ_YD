<%@page pageEncoding="UTF-8" %>

<div style="text-align: center;">
    <form id="saveUserInputForm" class="easyui-form" method="post" enctype="multipart/form-data">
        <input type="hidden" name="salt" class="easyui-textbox">
        <div style="margin-top: 40px;">
            账号: <input type="text" name="id" class="easyui-textbox">
        </div>
        <div style="margin-top: 20px;">
            手机号: <input type="text" name="phoneNum" class="easyui-textbox">
        </div>
        <div style="margin-top: 20px;">
            用户名: <input type="text" name="username" class="easyui-textbox">
        </div>
        <div style="margin-top: 20px;">
            密码: <input type="text" name="password" class="easyui-textbox">
        </div>
        <div style="margin-top: 20px;">
            省份: <input type="text" name="province" class="easyui-textbox">
        </div>
        <div style="margin-top: 20px;">
            城市: <input type="text" name="city" class="easyui-textbox">
        </div>
        <div style="margin-top: 20px;">
            法名: <input type="text" name="nickName" class="easyui-textbox">
        </div>
        <div style="margin-top: 20px;">
            性别:<select type="text" name="gender" class="easyui-combobox" style="width: 145px">
            <option value="男" >男</option>
            <option value="女" >女</option>
        </select>
        </div>
        <div style="margin-top: 20px;">
            签名: <input type="text" name="sign" class="easyui-textbox">
        </div>
        <div style="margin-top: 20px;">
            图片: <input type="text" name="userImg" class="easyui-filebox">
        </div>
        <div style="margin-top: 20px;">
            状态:<select type="text" name="status"  class="easyui-combobox" style="width: 145px">
            <option value="y" >显示</option>
            <option value="n" >隐藏</option>
        </select>
        </div>
    </form>
</div>