<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<script type="text/javascript">
    $(function(){
        var row = $("#ablumTreegrid").treegrid("getSelected");
        $("#chapterFieldTitle").textbox({
            required:true
        });
        $("#chapterFieldUploadDate").datetimebox({
            required:true,
            editable:false
        });
        $("#chapterFieldSize").textbox({
            required:true
        });
        $("#chapterFieldDuration").textbox({
            required:true
        });
        $("#chapterUploadAudio").filebox({
            required:true,
            buttonText:"选择文件",
            buttonAlign:"right"
        });
        $("#chapterFormSubmitBtn").linkbutton({
            iconCls:"icon-ok",
            onClick:function(){
                $("#chapterForm").form("submit",{
                    url:"${pageContext.request.contextPath}/chapter/add?aid="+row.id,
                    onSubmit:function(){
                        return $("#chapterForm").form("validate");
                    },
                    success:function(){
                        $("#addChapterDialog").dialog("close");
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
<h3 style="padding-top: 30px;text-align: center">添加音频</h3>
<form id="chapterForm" method="post" enctype="multipart/form-data">
    <table cellspacing="5" collspacing="5" align="center">
        <tr>
            <td>音频名:</td>
            <td><input id="chapterFieldTitle" name="title"/></td>
        </tr>
        <tr>
            <td>音频大小:</td>
            <td><input id="chapterFieldSize" name="size"/></td>
        </tr>
        <tr>
            <td>音频时长:</td>
            <td><input id="chapterFieldDuration" name="duration"/></td>
        </tr>
        <tr>
            <td>上传时间:</td>
            <td><input id="chapterFieldUploadDate" name="uploadDate"/></td>
        </tr>
        <tr>
            <td>上传音频:</td>
            <td><input id="chapterUploadAudio" name="audio"/></td>
        </tr>
        <tr colspan="2">
            <td><a id="chapterFormSubmitBtn">提交</a></td>
        </tr>
    </table>
</form>
