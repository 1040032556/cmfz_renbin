
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>

<script>
    $(function () {
        $("#albumForm").form('load','${pageContext.request.contextPath}/album/findOne?id=${param.id}');
    });
</script>
<div style="text-align: center;margin-top: 20px;">
    <form id="albumForm" method="post" class="easyui-form" >
            <input type="hidden" name="id"   data-options="label:'id:',width:300,"/>

        <br>
        <div>
            标题:  <input type="text"  name="title" class="easyui-textbox" data-options="width:200,"/>

        </div>
        <br>
        <div>
            作者:  <input type="text"  name="author" class="easyui-textbox" data-options="width:200,"/>

        </div>
        <br>
        <div>
            播音: <input type="text"  name="broadcast" class="easyui-textbox" data-options="width:200,"/>

        </div>
        <br>

        <div>
            创建时间：<input type="text" name="create_date" class="easyui-datebox" data-options="width:170,"/>

        </div>
        <br>
        <div>
            <span style="vertical-align:top">专辑图片:</span><img src="${pageContext.request.contextPath}${sessionScope.imgsrc}" alt="专辑图片" title="专辑图片" style="width: 180px;height: 110px">
        <br>
        <div>
            星级:&nbsp;&nbsp;&nbsp; <input type="text"  name="star" class="easyui-textbox" data-options="width:180,"/>

        </div>
        <br>
        <div>
           单曲数: <input type="text"  name="count" class="easyui-textbox" data-options="width:180,"/>

        </div>
        <br>
    </form>
</div>



