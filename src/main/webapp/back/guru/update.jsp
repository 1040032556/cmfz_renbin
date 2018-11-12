<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<script>
    $(function () {
        console.log("${param.id}");
        //查询单条数据填充
        $("#UpdateForm").form('load','${pageContext.request.contextPath}/guru/findOne?id=${param.id}');
    })
</script>
<div style="text-align: center;">
    <form id="UpdateForm" class="easyui-form" method="post" enctype="multipart/form-data" >
        <input type="hidden" name="id" value="${param.id}">
        <div style="margin-top: 50px;">
            上师名称：<input type="text" name="name" class="easyui-textbox" style="width: 170px;" data-options="required:true">
        </div>
        <div style="margin-top: 20px;">
            上师状态：
            <select id="cc" class="easyui-combobox" name="status"  style="width: 165px" >
                <option value="0">禁用</option>
                <option value="1" selected>可用</option>
            </select>
        </div>
        <div style="margin-top: 20px;">
            上师性别：
            <select id="bb" class="easyui-combobox" name="sex"  style="width: 165px" >

                <option value="0" selected>男</option>
                <option value="1">女</option>
            </select>
        </div>
    </form>
</div>