<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<script>
    $(function () {
        $("#queryAlbum").combobox({
            url:'${pageContext.request.contextPath}/album/findAll',
            valueField:'id',
            textField:'title',

            limitToList:true
        })
    })
</script>
<div style="text-align: center;">
    <form class="easyui-form" method="post" id="SaveFormC" enctype="multipart/form-data">
        <div style="text-align: center;margin-top: 40px">
            <div style="margin-top: 10px">
                章节名称：<input type="text" name="title" class="easyui-textbox" data-options="required:true" style="width: 170px;">
            </div>
            <div style="margin-top: 10px">
                选择图片：<input type="text" name="file"  data-options="required:true,buttonText:'请选择文件'"  class="easyui-filebox" style="width: 170px;">
            </div>
            <div style="margin-top: 10px">
                选择专辑：
                <input id="queryAlbum" name="album.id" type="text" style="width: 167px;"/>
            </div>
        </div>

    </form>
</div>