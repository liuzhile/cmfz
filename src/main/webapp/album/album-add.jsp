<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<script type="text/javascript">
    $(function(){
        $("#albumFieldTitle").textbox({
            required:true
        });
        $("#albumFieldPubDate").datetimebox({
            required:true,
            editable:false
        });
        $("#albumFieldAuthor").textbox();
        $("#albumFieldBroadcast").textbox();
        $("#albumFieldBrief").textbox();
        $("#albumFieldCoverImg").filebox({
            required:true,
            buttonText:"选择文件",
            buttonAlign:"right"
        });
        $("#albumFormSubmitBtn").linkbutton({
            iconCls:"icon-ok",
            onClick:function(){
                $("#albumForm").form("submit",{
                    url:"${pageContext.request.contextPath}/album/add",
                    onSubmit:function(){
                        return $("#bannerForm").form("validate");
                    },
                    success:function(){
                        $("#addAblumDialog").dialog("close");
                        $("#ablumTreegrid").treegrid("load");
                        $.messager.show({
                            title:"系统提示",
                            msg:"添加成功！"
                        })
                    }
                });
            }
        });
    });
</script>
<h3 style="padding-top: 30px;text-align: center">添加专辑</h3>
<form id="albumForm" method="post" enctype="multipart/form-data">
    <table cellspacing="5" collspacing="5" align="center">
        <tr>
            <td>标题:</td>
            <td><input id="albumFieldTitle" name="title"/></td>
        </tr>
        <tr>
            <td>作者:</td>
            <td><input id="albumFieldAuthor" name="author"/></td>
        </tr>
        <tr>
            <td>播音员:</td>
            <td><input id="albumFieldBroadcast" name="broadcast"/></td>
        </tr>
        <tr>
            <td>简介:</td>
            <td><input id="albumFieldBrief" name="brief"/></td>
        </tr>
        <tr>
            <td>专辑封面:</td>
            <td><input id="albumFieldCoverImg" name="image"/></td>
        </tr>
        <tr>
            <td>发布时间:</td>
            <td><input id="albumFieldPubDate" name="pubDate"/></td>
        </tr>
        <tr colspan="2">
            <td><a id="albumFormSubmitBtn">提交</a></td>
        </tr>
    </table>
</form>
