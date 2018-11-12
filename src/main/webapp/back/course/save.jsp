<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<div style="text-align: center;">
    <form id="SaveForm" class="easyui-form" method="post" enctype="multipart/form-data">
        <div style="margin-top: 50px;">
        课程名称：<input type="text" name="title" class="easyui-textbox" style="width: 170px;" data-options="required:true">
        </div>
        <div style="margin-top: 20px;">
            课程状态：
            <select id="dd" class="easyui-combobox"  name="marking"  style="width: 165px" >
                <option value="0">禁用</option>
                <option value="1" selected>可用</option>
            </select>
        </div>
    </form>
</div>