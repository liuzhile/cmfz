<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<script type="text/javascript">
    $(function(){
        var row = $("#ablumTreegrid").treegrid("getSelected");
        console.log(row);
        $.post(
            "${pageContext.request.contextPath}/album/detail",
            "id="+row.id,
            function(data){
                var tag = '<table style="margin-top:30px" align="center"><tr>' +
                    '<td rowspan=2><img src="${pageContext.request.contextPath}' + data.coverImg + '" style="height:200px;"></td>' +
                    '<td align="left" style="font-size:13px">' +
                    '<p>评分: ' + data.score + '</p>' +
                    '<p>标题:' + data.title + '</p>' +
                    '<p>作者: ' + data.author + '</p>' +
                    '<p>播音员: ' + data.broadcast + '</p>' +
                    '<p>章节数: ' + data.count + '</p>' +
                    '<p>时间: ' + data.pubDate + '</p>' +
                    '</td>' +
                    '</tr></table>';
                    $("h2").append(tag);
            },
            "JSON"
        );
    });
</script>
<h2 style="text-align: center">专辑详情</h2>
<%--<table border="0" cellspacing="5" collspacing="5" align="center">
    <tr>
        <td rowspan=2 style="border:0"><img></td>
        <td><input id="bannerFieldTitle" name="title"/></td>
    </tr>
</table>--%>
