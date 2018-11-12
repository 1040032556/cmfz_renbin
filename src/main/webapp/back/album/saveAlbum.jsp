<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<div style="text-align: center;">
    <form class="easyui-form" method="post" id="SaveFormA" enctype="multipart/form-data">
        <div style="text-align: center;margin-top: 40px">
            <div style="margin-top: 10px">
                专辑名称：<input type="text" name="title" class="easyui-textbox" data-options="required:true">
            </div>
            <div style="margin-top: 10px">
                专辑集数：<input type="text" name="count" class="easyui-numberbox" data-options="required:true">
            </div>
            <div style="margin-top: 10px">
                专辑图片：<input type="text" name="img"  data-options="required:true,buttonText:'请选择图片',accept:'image/jpeg,image/png,image/gif'"  class="easyui-filebox" style="width: 160px;">
            </div>
            <div style="margin-top: 10px">
                专辑评分：
                <select class="easyui-combobox" name="star"  style="width: 154px" >
                    <option value="1">⭐</option>
                    <option value="2">⭐⭐</option>
                    <option value="3">⭐⭐⭐</option>
                    <option value="4">⭐⭐⭐⭐</option>
                    <option value="5" selected>⭐⭐⭐⭐⭐</option>
                </select>
            </div>
            <div style="margin-top: 10px">
                专辑作者：<input type="text" name="author" class="easyui-textbox" data-options="required:true" style="width: 157px">
            </div>
            <div style="margin-top: 10px">
                专辑播音：<input type="text" name="broadcast" class="easyui-textbox" data-options="required:true" style="width: 157px">
            </div>
            <div style="margin-top: 10px">
                专辑简介：<input type="text" name="brief" class="easyui-textbox" data-options="required:true,multiline:true" style="width: 157px">
            </div>
        </div>

    </form>
</div>