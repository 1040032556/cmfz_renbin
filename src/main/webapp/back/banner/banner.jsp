<%@ page language="java" isELIgnored="false" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<script>

    $(function () {

        $("#dg1").datagrid({
            url:'${pageContext.request.contextPath}/banner/findAll',
            toolbar:'#linkbuttons1',
            //开启自适应
            fitColumns:true,
            fixed:false,
            remoteSort:false,

            pagination:true,//显示分页工具栏
            pageNumber:1,//当前页
            pageSize:6,//每页显示记录数
            pageList:[2,3,4,5,6,7],
            striped:true,
            rownumbers:true,
            singleSelect:false,
            ctrlSelect:true,

            //开启分页
            pagination:true,
            pagePosition:'bottom',
            pageNumber:1,
            resizable:false,
            columns:[[
                {field:'checkbox',title:'checkbox',checkbox:true},
                {field:"title",title:'标题',width:100},
                {field:"des",title:'图片描述',width:200},
                {field:"status",title:'图片状态',formatter:function(value,row,index){
                    if(value==1){
                        return "可用";
                    }else {
                        return "不可用";
                    }
                    },width:200},
                {field:"create_date",title:'上传时间',width:200,sortable:true},

            ]],
            onLoadSuccess:function () {
                $('.del').linkbutton();
                $('.edit').linkbutton();
            },

            view: detailview,
            detailFormatter: function(rowIndex, rowData){
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img style="width:100px;height:80px" src="${pageContext.request.contextPath}'+rowData.imgPath+'" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '<p>data: ' + rowData.create_date + '</p>' +
                    '<p>description: ' + rowData.des + '</p>' +
                    '<p>path: ' + rowData.imgPath + '</p>' +
                    '</td>' +
                    '</tr></table>';
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
                        url:'${pageContext.request.contextPath}/banner/save',
                        success:function(result) {
                            //提示信息
                            $.messager.show({title:'提示',msg:"添加成功"});
                            //关闭对话框
                            $("#SaveDialog").dialog('close');
                            //刷新datagrid
                            $("#dg1").datagrid('reload');
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
        var rows=$("#dg1").datagrid('getSelections');
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
                url:'${pageContext.request.contextPath}/banner/deleteMore',
                type:"POST",
                traditional:true,//传递数据类型的数据时必须设置这个属性为true
                data:{id:ids},
                success:function (result) {
                    //消息提示
                    $.messager.show({title:'提示',msg:"删除成功!!!"});
                    //刷新datagrid
                    $("#dg1").datagrid('reload');
                },
                error:function () {
                    //消息提示
                    $.messager.show({title:'提示',msg:"删除失败!!!"});
                    //刷新datagrid
                    $("#dg1").datagrid('reload');
                }
            })
        }
    }

    function update() {
        var datagrid1 = $("#dg1").datagrid("getSelections");

        if (datagrid1.length!=1){
            $.messager.show({title:'提示',msg:"只能选择一行"})
        }else{
            var id;
            var imgPath;
            for(var i=0;i<datagrid1.length;i++){
                id=datagrid1[i].id;
                imgPath=datagrid1[i].imgPath;
            }
            $("#UpDialog").dialog({
                href:'${pageContext.request.contextPath}/back/banner/update.jsp?id='+id+'&imgPath='+imgPath,
                width: 600,
                height: 400,
                buttons:[{
                    text:'修改',
                    handler:function(){
                        $("#UpdateForm").form('submit',{
                            url:'${pageContext.request.contextPath}/banner/update',
                            success:function (result) {
                                var parseJSON = $.parseJSON(result);
                                if(parseJSON.success){
                                    $.messager.show({title:'提示',msg:"修改成功"});
                                }else{
                                    $.messager.show({title:'提示',msg:"修改失败"})
                                }
                                //关闭对话框
                                $("#UpDialog").dialog('close');
                                $("#dg1").datagrid("reload");
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
<table id="dg1" data-options="fit:true,"></table>

<%--datagrid工具栏(添加，删除s)--%>
<div id="linkbuttons1">
    <a  href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="OpenSave()">添加</a>
    <a  href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'" onclick="update()">修改</a>
    <a  href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cut'" onclick="delMoreRows()">删除</a>
</div>
<%--保存对话框--%>
<div id="SaveDialog"  data-options="draggable:true,href:'${pageContext.request.contextPath}/back/banner/save.jsp',width:600,height:400,title:'保存',"></div>
<%--修改对话框--%>
<div id="UpDialog"  data-options="draggable:true,href:'${pageContext.request.contextPath}/back/banner/update.jsp',width:600,height:400,title:'修改',"></div>

