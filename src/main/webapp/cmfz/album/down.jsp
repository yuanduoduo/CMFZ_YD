<%@page pageEncoding="UTF-8"  isELIgnored="false" %>
<div style="text-align: center;">
    <div style="margin-top: 80px;">
        <a href="${pageContext.request.contextPath}/album/download?fileName=${param.id}&openStyle=inline" class="easyui-linkbutton" data-options="">在线播放</a>
    </div>
    <div style="margin-top: 20px;">
        <a href="${pageContext.request.contextPath}/album/download?fileName=${param.id}&openStyle=attachment" class="easyui-linkbutton" data-options="">下载音频</a>
    </div>
</div>

