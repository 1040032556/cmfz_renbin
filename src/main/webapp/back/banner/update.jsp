<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<script>
    $(function () {
        console.log("${param.id}");
        //查询单条数据填充
        $("#UpdateForm").form('load','${pageContext.request.contextPath}/banner/findOne?id=${param.id}');
    })
</script>
<div style="text-align: center;">
    <form id="UpdateForm" class="easyui-form" method="post" enctype="multipart/form-data" >
        <input type="hidden" name="id" value="${param.id}">
        <div style="margin-top: 50px;">
            图片名称：<input type="text" name="title" class="easyui-textbox" style="width: 170px;"  data-options="required:true">
        </div>
       <%-- <div style="margin-top: 20px;">
            图片路径：<input type="text" name="imgPath"  class="easyui-filebox" data-options="buttonText:'请选择图片',accept:'image/jpeg,image/png,image/gif'"  style="width: 170px;">
        </div>--%>
        <div style="margin-top: 20px;">
            图片描述：<input type="text" name="des" class="easyui-textbox" style="width: 170px;"  data-options="required:true">
        </div>
        <div style="margin-top: 20px;">
            图片状态：
            <select id="cc" class="easyui-combobox" name="status"  style="width: 165px" >
                <option value="sel">请选择状态</option>
                <option value="0">禁用</option>
                <option value="1">可用</option>
            </select>
        </div>
        <div style="margin-top: 20px;">
            上传时间：<input type="text" name="create_date" class="easyui-datebox" style="width: 170px;"  data-options="required:true">
        </div>
    </form>
</div>