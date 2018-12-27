<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<script type="text/javascript">
    $(function(){
        $("#ablumDetailBtn").linkbutton({
            iconCls: 'icon-bell',
            onClick: function(){
                var row = $("#ablumTreegrid").treegrid("getSelected");
                if(row!=null) {
                    if (row.children != null) {
                        $("#showAblumDialog").dialog("open");
                    } else {
                        $.messager.alert('提示', '请先选中专辑！');
                    }
                }else{
                    $.messager.alert('提示', '请先选中专辑！');
                }
            }
        });
        $("#addAlbumBtn").linkbutton({
            iconCls: 'icon-book_add',
            onClick: function(){
                $("#addAblumDialog").dialog("open");
            }
        });
        $("#exportExcelBtn").linkbutton({
            iconCls: 'icon-printer_go',
            onClick: function(){
                $("#exportExcelBtn").prop("href","${pageContext.request.contextPath}/album/export");
            }
        });
        $("#importExcelBtn").linkbutton({
            iconCls: 'icon-printer_mono',
            onClick: function(){
                $("#importExcelBtn").prop("href","${pageContext.request.contextPath}/album/import");
            }
        });
        $("#addChapterBtn").linkbutton({
            iconCls: 'icon-bookmark_add',
            onClick: function(){
                var row = $("#ablumTreegrid").treegrid("getSelected");
                if(row!=null) {
                    if (row.children != null) {
                        $("#addChapterDialog").dialog("open");
                    } else {
                        $.messager.alert('提示', '请先选中专辑！');
                    }
                }else {
                    $.messager.alert('提示', '请先选中专辑！');
                }
            }
        });
        $("#downloadAudioBtn").linkbutton({
            iconCls: 'icon-back',
            onClick: function(){
                var row = $("#ablumTreegrid").treegrid("getSelected");
                if(row!=null){
                    if(row.children==null){
                        $("#downloadAudioBtn").prop("href","${pageContext.request.contextPath}/chapter/download?name="+row.url);
                    }else{
                        $.messager.alert('提示','请先选中音频！');
                    }
                }else{
                    $.messager.alert('提示','请先选中音频！');
                }

            }
        });
        $("#showAblumDialog").dialog({
            title:"专辑详情",
            width:500,
            height:600,
            closed:true,
            cache:false,
            href:"${pageContext.request.contextPath}/album/album-detail.jsp"
        });
        $("#addAblumDialog").dialog({
            title:"添加专辑",
            width:400,
            height:600,
            closed:true,
            cache:false,
            href:"${pageContext.request.contextPath}/album/album-add.jsp"
        });
        $("#addChapterDialog").dialog({
            title:"添加章节",
            width:400,
            height:600,
            closed:true,
            cache:false,
            href:"${pageContext.request.contextPath}/album/chapter-add.jsp"
        });
        $("#audioDialog").dialog({
            title:"播放音频",
            width:400,
            height:100,
            closed:true,
            cache:false
        });
        $("#ablumTreegrid").treegrid({
            url:'${pageContext.request.contextPath}/album/show',
            idField:'id',
            treeField:'title',
            columns:[[
                {title:'名称',field:'title',width:150},
                {field:'size',title:'章节大小',width:60},
                {field:'duration',title:'章节时长',width:80},
                {field:'uploadDate',title:'上传时间',width:80}
            ]],
            onDblClickRow:function(row){
                if(row!=null){
                    if(row.children==null){
                        $("#audioDialog").dialog("open");
                        $("#audio").prop("src","${pageContext.request.contextPath}"+row.url);
                    }else{
                        $.messager.alert('提示','请先选中音频！');
                    }
                }else{
                    $.messager.alert('提示','请先选中音频！');
                }
            },
            fit:true,
            fitColumns:true,
            toolbar:"#ablumTreegridToolBar"
        });
    });
</script>
<table id="ablumTreegrid"></table>
<div id="showAblumDialog"></div>
<div id="addAblumDialog"></div>
<div id="addChapterDialog"></div>
<div id="ablumTreegridToolBar">
    <a id="ablumDetailBtn">专辑详情</a>
    <a id="addAlbumBtn">添加专辑</a>
    <a id="addChapterBtn">添加章节</a>
    <a href="#" id="downloadAudioBtn">下载音频</a>
    <a href="#" id="exportExcelBtn">导出Excel</a>
    <a href="#" id="importExcelBtn">导入Excel</a>
</div>
<div id="audioDialog">
    <audio id="audio" controls="controls" autoplay="autoplay"/>
</div>
<div id="importExeclDialog">
    <input class="easyui-filebox" data-options="buttonText:'选择文件',buttonAlign:'right'"/>
</div>