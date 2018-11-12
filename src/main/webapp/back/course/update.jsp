<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<script>
    $(function () {
        console.log("${param.id}");
        //查询单条数据填充
        $("#UpdateForm").form('load','${pageContext.request.contextPath}/course/findOne?id=${param.id}');
    })
</script>
<div style="text-align: center;">
    <form id="UpdateForm" class="easyui-form" method="post" enctype="multipart/form-data" >
        <input type="hidden" name="id" value="${param.id}">
        <div style="margin-top: 50px;">
            课程名称：<input type="text" name="title" class="easyui-textbox" style="width: 170px;" data-options="required:true">
        </div>
        <div style="margin-top: 20px;">
            课程状态：
            <select id="cc" class="easyui-combobox" name="marking"  style="width: 165px" >
                <option value="0">禁用</option>
                <option value="1" selected>可用</option>
            </select>
        </div>

    </form>
</div>