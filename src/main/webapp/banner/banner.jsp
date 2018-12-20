<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<script type="text/javascript">
    $(function(){
        var toolbar =  [{
            iconCls: 'icon-add',
            text:"添加",
            handler: function(){
                $("#bannerDialog").dialog("open");
            }
        },'-',{
            iconCls: 'icon-edit',
            text:"修改",
            handler: function(){
                var row = $("#bannerDatagrid").edatagrid("getSelected");
                if(row!=null){
                    var index = $("#bannerDatagrid").edatagrid("getRowIndex",row);
                    $("#bannerDatagrid").edatagrid("editRow",index);
                }else{
                    $.messager.alert('提示','请先选中行！');
                }
            }
        },'-',{
            iconCls: 'icon-remove',
            text:"删除",
            handler: function(){
                $("#bannerDatagrid").edatagrid("destroyRow");
            }
        },'-',{
            text:"保存",
            iconCls: 'icon-save',
            handler: function(){
                $("#bannerDatagrid").edatagrid("saveRow");
            }
        }];
        $("#bannerDialog").dialog({
            title:"添加轮播图",
            width:400,
            height:300,
            closed:true,
            cache:false,
            href:"${pageContext.request.contextPath}/banner/banner-add.jsp"
        });
        $("#bannerDatagrid").edatagrid({
            url:"${pageContext.request.contextPath}/banner/show",
            updateUrl:"${pageContext.request.contextPath}/banner/update",
            columns:[[
                {field:"id",title:"编号",width:100},
                {field:"title",title:"标题",width:100},
                {field:"status",title:"状态",width:100,editor: {
                        type: "text",
                        options: {required:true}
                    }},
                {field:"imgPath",title:"路径",width:100},
                {field:"uploadDate",title:"上传时间",width:100}
            ]],
            fitColumns:true,
            fit:true,
            pagination:true,
            pageSize:3,
            pageList:[3,4,5],
            toolbar:toolbar,
            view: detailview,
            detailFormatter: function(rowIndex, rowData){
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}' + rowData.imgPath + '" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '<p>Date: ' + rowData.uploadDate + '</p>' +
                    '<p>Description: ' + rowData.description + '</p>' +
                    '<p>Status: ' + rowData.status + '</p>' +
                    '</td>' +
                    '</tr></table>';
            },
            destroyMsg:{
                norecord:{    // 在没有记录选择的时候执行
                    title:'警告',
                    msg:'请先选中行！'
                },
                confirm:{       // 在选择一行的时候执行
                    title:'提示',
                    msg:'您确认删除吗?'
                }
            },
            onDestroy:function (index,row) {
                $.post(
                    "${pageContext.request.contextPath}/banner/delete",
                    "id="+row.id,
                    function(){
                        $("#bannerDatagrid").edatagrid("reload");
                    },
                    "text"
                );
            }
        });
    });
</script>
<table id="bannerDatagrid"></table>
<div id="bannerDialog"></div>