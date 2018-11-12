<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<script>


    $(function () {
        $.extend($.fn.validatebox.defaults.rules,{
            confirmpwd:{
                validator:function (value,param) {
                    return $(param[0]).val() == value;
                },
                message:"两次输入的密码不一致",
            }
        });
    })
</script>
<div style="text-align: center;">
    <form id="adminForm" class="easyui-form" method="post">

        <div style="margin-top: 70px;">
            原始密码: <input type="text" id="password0" name="oldpassword" class="easyui-textbox" data-options="required:true,validType:'pwd'">
        </div>
        <div style="margin-top: 20px;">
            新密码:
            <input type="text"  id="password1" name="password" class="easyui-passwordbox" data-options="required:true">
        </div>
        <div style="margin-top: 20px;">
            确认密码:
            <input type="text" class="easyui-passwordbox" id="password2" data-options="validType:'confirmpwd[\'#pwd\']'">
        </div>
    </form>
</div>


</body>
</html>
