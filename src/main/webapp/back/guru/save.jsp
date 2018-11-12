<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<div style="text-align: center;">
    <form id="SaveForm" class="easyui-form" method="post" enctype="multipart/form-data">
        <div style="margin-top: 50px;">
        上师名称：<input type="text" name="name" class="easyui-textbox" style="width: 170px;" data-options="required:true">
        </div>
        <div style="margin-top: 20px;">
        上师图片：<input type="text" name="img"  data-options="required:true,buttonText:'请选择图片',accept:'image/jpeg,image/png,image/gif'"  class="easyui-filebox" style="width: 170px;" >
        </div>
        <div style="margin-top: 20px;">
            上师状态：
            <select id="cc" class="easyui-combobox"  name="status"  style="width: 165px" >
                <%--<option value="sel">请选择状态</option>--%>
                <option value="0">禁用</option>
                <option value="1" selected>可用</option>
            </select>
        </div>
        <div style="margin-top: 20px;">
            上师性别：
            <select id="bb" class="easyui-combobox" name="sex"  style="width: 165px" >
               <%-- <option value="sel">请选择性别</option>--%>
                <option value="0" selected>男</option>
                <option value="1">女</option>
            </select>
        </div>
    </form>
</div>