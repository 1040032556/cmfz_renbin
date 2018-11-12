<%@ page language="java" isELIgnored="false" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>持名法州主页</title>
<link rel="stylesheet" type="text/css" href="../themes/default/easyui.css">   
<link rel="stylesheet" type="text/css" href="../themes/IconExtension.css">   
<script type="text/javascript" src="../js/jquery.min.js"></script>   
<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>  
<script type="text/javascript" src="../js/easyui-lang-zh_CN.js"></script>
 <script type="text/javascript" src="../js/datagrid-detailview.js"></script>
<script type="text/javascript">
	/*菜单处理*/
        /*$(function () {
            //页面加载完成之后显示菜单数据
            $.post("${pageContext.request.contextPath}/menu/findAllMenu",function (menu) {
                //遍历一级菜单
                $.each(menu,function (index,m) {
                    //设置菜单项位置
                    var content="<div style='text-align: center;'>";
                    //遍历二级菜单
                    $.each(m.zmenu,function (idx,child) {
                        content+="<a onclick=\"addTabs('"+child.name+"','"+child.iconCls+"','"+child.href+"')\" style='width:90%; margin:10px 0 10px 0; border:1px lawngreen solid;' class='easyui-linkbutton' data-options=\"plain:true,iconCls:'"+child.iconCls+"'\">"+child.name+"</a></br>";
                    });
                    content+="</div>";

                    //添加菜单
                    $("#menu").accordion('add',{
                        title:m.name,
                        iconCls:m.iconCls,
                        content:content,
                    });
                })
            })
        })
*/
    $(function () {
        //页面加载完成之后显示菜单数据
        $.ajax({
            url:"${pageContext.request.contextPath}/menu/findAllMenu",
            type:"post",
            data:'menu',
            dataType:"json",
            success:function(menu) {
                //遍历一级菜单
                $.each(menu, function (index, m) {
                    //设置菜单项位置
                    var content = "<div style='text-align: center;'>";
                    //遍历二级菜单
                    $.each(m.zmenu, function (idx, child) {
                        content += "<a onclick=\"addTabs('" + child.name + "','" + child.iconCls + "','" + child.href + "')\" style='width:90%; margin:10px 0 10px 0; border:1px lawngreen solid;' class='easyui-linkbutton' data-options=\"plain:true,iconCls:'" + child.iconCls + "'\">" + child.name + "</a></br>";
                    });
                    content += "</div>";

                    //添加菜单
                    $("#menu").accordion('add', {
                        title: m.name,
                        iconCls: m.iconCls,
                        content: content,
                    });
                })
            },
            error:function(){
                location.href="${pageContext.request.contextPath}/back/login.jsp";
            }
        })

    })

    //点击菜单追加菜单项
         function addTabs(title,iconCls,href) {
        //添加以前先判断tabs中是否存在这个菜单项
             if(!$('#tabs').tabs('exists',title)){
                 $('#tabs').tabs('add',{
                     title:title,
                     iconCls:iconCls,
                     href:'${pageContext.request.contextPath}/back'+href,
                     fit:true,
                     closable:true,
                 })
             }else{
                 $("#tabs").tabs('select',title);
             }
         }
    //修改管理员密码
    function removeSession() {
        $.post("${pageContext.request.contextPath}/admin/remove")
        location.href="http://localhost:8080/cmfz_lizh/back/login.jsp";

    }


    //打开修改密码的对话框
    function editAdmin() {
        $("#editAdmin").dialog({
            title: '修改密码',
            width: 400,
            height: 400,
            closed: false,
            cache: false,
            href: '../update.jsp',
            modal: true,
            buttons:[{
                text:'保存',
                handler:function(){
                    $("#adminForm").form("submit",{
                        url:'${pageContext.request.contextPath}/admin/update',
                        onSubmit: function(){

                            if ($("#password1").val()!=$("#password2").val() ){
                                alert("两次密码不一致")
                                return false;
                            }
                            if ($("#password0").val()!="${sessionScope.login.password}" ){
                                alert("原密码错误")
                                return false;
                            }

                            return true;
                        },
                        success: function () {
                            $("#editAdmin").dialog("close");
                            removeSession();
                            location.href="http://localhost:8989/cmfz_renbin/back/login.jsp";
                        }

                    })


                }
            },{
                text:'关闭',
                handler:function(){
                    $("#editAdmin").dialog("close");
                }
            }]
        });

    }

</script>

</head>
<body class="easyui-layout">   
    <div data-options="region:'north',split:true" style="height:60px;background-color:  #5C160C">
    	<div style="font-size: 24px;color: #FAF7F7;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px" >持名法州后台管理系统</div>
    	<div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 300px;float:right;padding-top:15px">欢迎您:${sessionScope.login.name} &nbsp;<a href="javascript:;" class="easyui-linkbutton" onclick="editAdmin()" data-options="iconCls:'icon-edit'">修改密码</a>&nbsp;&nbsp;
            <a href="${pageContext.request.contextPath}/admin/logout" onclick="removeSession()" class="easyui-linkbutton" data-options="iconCls:'icon-01'">退出系统</a></div>
        <div id="editAdmin" ></div>
    </div>
    <div data-options="region:'south',split:true" style="height: 40px;background: #5C160C">
    	<div style="text-align: center;font-size:15px; color: #FAF7F7;font-family: 楷体" >&copy;百知教育 htf@zparkhr.com.cn</div>
    </div>   
       
    <div data-options="region:'west',title:'导航菜单',split:true" style="width:220px;">
    	<div id="menu" class="easyui-accordion" data-options="fit:true">
    		
		</div>  
    </div>   
    <div data-options="region:'center'">
    	<div id="tabs" class="easyui-tabs" data-options="fit:true,narrow:true,pill:true">
		    <div title="主页" data-options="iconCls:'icon-neighbourhood',"  style="background-image:url(image/shouye.jpg);background-repeat: no-repeat;background-size:100% 100%;"></div>

		</div>  
    </div>   
</body> 
</html>