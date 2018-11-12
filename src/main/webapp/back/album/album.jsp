
<%@ page language="java" isELIgnored="false" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<script>

        $('#dg3').treegrid({
            fitColumns:true,
            url:'${pageContext.request.contextPath}/album/findAll',
            idField:'id',
            treeField:'title',
            toolbar:'#linkbuttons3',
            columns:[[
                {field:'title',title:'名字',width:180},
                {field:'downPath',title:'downPath',width:200},
                {field:'size',title:'章节大小',width:200},
                {field:'duration',title:'章节时长',width:180}
            ]],
            animate:true,
            fix:true,
            lines:true,
        });

    //打开保存窗口
    function OpenSaveA() {
        $('#SaveDialogA').dialog({
            buttons:[{
                iconCls:'icon-ok',
                text:'保存',
                //保存用户
                handler:function () {
                    $('#SaveFormA').form('submit',{
                        url:'${pageContext.request.contextPath}/album/save',
                        success:function(result) {
                            //提示信息
                            $.messager.show({title:'提示',msg:"添加成功"});

                            //关闭对话框
                            $("#SaveDialogA").dialog('close');
                            //刷新datagrid
                            $("#dg3").treegrid('reload');

                        }
                    })
                }
            },{
                iconCls:'icon-cancel',
                text:'关闭',
                handler:function(){
                    $("#SaveDialogA").dialog('close');
                }
            }],
        })
    }

        //打开章节保存窗口
        function OpenSaveC() {
            $('#SaveDialogC').dialog({
                buttons:[{
                    iconCls:'icon-ok',
                    text:'保存',
                    //保存用户
                    handler:function () {
                        $('#SaveFormC').form('submit',{
                            url:'${pageContext.request.contextPath}/chapter/save',
                            success:function(result) {
                           if($.parseJSON(result).success) {
                               //提示信息
                               $.messager.show({title: '提示', msg: "添加成功"});

                               //关闭对话框
                               $("#SaveDialogC").dialog('close');
                               //刷新datagrid
                               $("#dg3").treegrid('reload');
                           }else{
                               $.messager.show({title: '提示', msg: "请选择MP3格式音频"});
                           }

                            }
                        })
                    }
                },{
                    iconCls:'icon-cancel',
                    text:'关闭',
                    handler:function(){
                        $("#SaveDialogC").dialog('close');
                    }
                }],
            })
        }

        /*下载章节*/
        function downchild() {
            var rows =  $("#dg3").treegrid('getSelected');

            if(rows==null){alert("请选择！！！");}
            if(rows.downPath==null){
                alert("请选择章节！！！！");
            }
            else{

                location.href="${pageContext.request.contextPath}/chapter/download?fileName="+rows.downPath;
            }
        }
        /*专辑详情*/
       function OpenChapter() {
           var rows =  $("#dg3").treegrid('getSelected');
           if(rows==null){alert("请选择！！！");}
           if(rows.downPath!=null){
               alert("请选择专辑！！！！");
           }else{
            $("#detailDialog").dialog({
                href:'${pageContext.request.contextPath}/back/album/details.jsp?id='+rows.id,
                closed : false,
                width:500,
                height: 550,
                title:'专辑详情',
                buttons:[{
                    iconCls:'icon-cancel',
                    text:'关闭',
                    handler:function () {

                        $("#detailDialog").dialog('close');
                    },
                }],
            });
           }
        }
</script>
<table id="dg3"></table>
<div id="linkbuttons3">
    <a  href="javascript:;" class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="OpenChapter()">专辑详情</a>
    <a  href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="OpenSaveA()">添加专辑</a>
    <a  href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="OpenSaveC()">添加章节</a>
    <a  href="#" class="easyui-linkbutton" data-options="iconCls:'icon-download'" onclick="downchild()">下载音频</a>
</div>
<%--detail对话框--%>
<div id="detailDialog" data-options="resizable:true"></div>
<%--保存专辑对话框--%>
<div id="SaveDialogA"  data-options="draggable:true,href:'${pageContext.request.contextPath}/back/album/saveAlbum.jsp',width:600,height:400,title:'保存',"></div>
<%--保存列表对话框--%>
<div id="SaveDialogC"  data-options="draggable:true,href:'${pageContext.request.contextPath}/back/album/saveChapter.jsp',width:600,height:400,title:'保存',"></div>


