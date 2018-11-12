<%@ page language="java" isELIgnored="false" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<script>

    $(function () {

        $("#dg4").datagrid({
            url:'${pageContext.request.contextPath}/course/findAll',
            toolbar:'#linkbuttons4',
            //开启自适应
            fitColumns:true,
            columns:[[
                {field:"title",title:'必修课名',width:100},
                {field:"marking",title:'课程状态',formatter:function(value,row,index){
                    if(value==1){
                        return "可用";
                    }else {
                        return "不可用";
                    }
                    },width:200},
                {field:"create_date",title:'创建日期',width:100},
            ]],
           onLoadSuccess:function () {
                $('.del').linkbutton();
                $('.edit').linkbutton();
            },


        })
    })




    //打开保存窗口
    function OpenSave() {
        $('#SaveDialog').dialog({
            buttons:[{
                iconCls:'icon-ok',
                text:'保存',
                //保存用户
                handler:function () {
                    $('#SaveForm').form('submit',{
                        url:'${pageContext.request.contextPath}/course/save',
                        success:function(result) {
                            //提示信息
                            $.messager.show({title:'提示',msg:"添加成功"});
                            //关闭对话框
                            $("#SaveDialog").dialog('close');
                            //刷新datagrid
                            $("#dg4").datagrid('reload');
                        }
                    })
                }
            },{
                iconCls:'icon-cancel',
                text:'关闭',
                handler:function(){
                    $("#SaveDialog").dialog('close');
                }
            }],
        })
    }

    //删除多行的事件
    function delMoreRows(){
        var rows=$("#dg4").datagrid('getSelections');
        if(rows.length<=0){
            $.messager.show({title:'提示',msg:"至少选中一行!!!"});
        }else{
            //设置一个空的id数组
            var ids=[];

            for (var i=0;i<rows.length;i++){
                //把接收到的id填充到rwos里
                console.log(rows[i].id);
                ids.push(rows[i].id);
            }
            console.log(ids);
            //发送ajax请求传递数组  注意: $.get $.post 只能传递简单数据(key=value) 不能数组类型的数据
            //                        如果想要传递数组类型的数据只能使用  $.ajax 并且还要设置其中的一个属性
            $.ajax({
                url:'${pageContext.request.contextPath}/course/deleteMore',
                type:"POST",
                traditional:true,//传递数据类型的数据时必须设置这个属性为true
                data:{id:ids},
                success:function (result) {
                    //消息提示
                    $.messager.show({title:'提示',msg:"删除成功!!!"});
                    //刷新datagrid
                    $("#dg4").datagrid('reload');
                },
                error:function () {
                    //消息提示
                    $.messager.show({title:'提示',msg:"删除失败!!!"});
                    //刷新datagrid
                    $("#dg4").datagrid('reload');
                }
            })
        }
    }

    function update() {
        var datagrid4 = $("#dg4").datagrid("getSelections");

        if (datagrid4.length!=1){
            $.messager.show({title:'提示',msg:"只能选择一行"})
        }else{
            var id;
            var headPic;
            for(var i=0;i<datagrid4.length;i++){
                id=datagrid4[i].id;
            }
            $("#UpDialog").dialog({
                href:'${pageContext.request.contextPath}/back/course/update.jsp?id='+id,
                width: 600,
                height: 400,
                buttons:[{
                    text:'修改',
                    handler:function(){
                        $("#UpdateForm").form('submit',{
                            url:'${pageContext.request.contextPath}/course/update',
                            success:function (result) {
                                var parseJSON = $.parseJSON(result);
                                if(parseJSON.success){
                                    $.messager.show({title:'提示',msg:"修改成功"});
                                }else{
                                    $.messager.show({title:'提示',msg:"修改失败"})
                                }
                                //关闭对话框
                                $("#UpDialog").dialog('close');
                                $("#dg4").datagrid("reload");
                            }
                        })
                    }
                },{
                    text:'关闭',
                    handler:function(){
                        $("#UpDialog").dialog('close');
                    }
                }]
            })
        }
    }
</script>
<table id="dg4" data-options="fit:true,"></table>
<div id="linkbuttons4">
    <a  href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="OpenSave()">添加</a>
    <a  href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'" onclick="update()">修改</a>
    <a  href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cut'" onclick="delMoreRows()">删除</a>
</div>


<%--保存对话框--%>
<div id="SaveDialog"  data-options="draggable:true,href:'${pageContext.request.contextPath}/back/course/save.jsp',width:600,height:400,title:'保存',"></div>
<%--修改对话框--%>
<div id="UpDialog"  data-options="draggable:true,href:'${pageContext.request.contextPath}/back/course/update.jsp',width:600,height:400,title:'修改',"></div>

