<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<script type="text/javascript">
    $(function(){
        $("#bannerFieldTitle").textbox({
            required:true
        });
        $("#bannerFieldUploadDate").datetimebox({
            required:true,
            editable:false
        });
        $("#bannerFieldDescription").textbox();
        $("#bannerUploadPic").filebox({
            required:true,
            buttonText:"选择文件",
            buttonAlign:"right"
        });
        $("#bannerFormSubmitBtn").linkbutton({
            iconCls:"icon-ok",
            onClick:function(){
                $("#bannerForm").form("submit",{
                    url:"${pageContext.request.contextPath}/banner/add",
                    onSubmit:function(){
                        return $("#bannerForm").form("validate");
                    },
                    success:function(){
                        $("#bannerDialog").dialog("close");
                        $("#bannerDatagrid").edatagrid("load");
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
<h3 style="padding-top: 30px;text-align: center">添加轮播图</h3>
<form id="bannerForm" method="post" enctype="multipart/form-data">
    <table border="0" cellspacing="5" collspacing="5" align="center">
        <tr>
            <td>标题:</td>
            <td><input id="bannerFieldTitle" name="title"/></td>
        </tr>
        <tr>
            <td>上传时间:</td>
            <td><input id="bannerFieldUploadDate" name="uploadDate"/></td>
        </tr>
        <tr>
            <td>状态:</td>
            <td><input type="radio" name="status" value="Y"/>Y&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="status" value="N"/>N</td>
        </tr>
        <tr>
            <td>描述:</td>
            <td><input id="bannerFieldDescription" name="description"/></td>
        </tr>
        <tr>
            <td>上传图片:</td>
            <td><input id="bannerUploadPic" name="image"/></td>
        </tr>
        <tr colspan="2">
            <td><a id="bannerFormSubmitBtn">提交</a></td>
        </tr>
    </table>
</form>
