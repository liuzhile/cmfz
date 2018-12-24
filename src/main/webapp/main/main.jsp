<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>持名法州主页</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/icon.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/IconExtension.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/datagrid-detailview.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.edatagrid.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	<!--菜单处理-->
    $(function(){
        $("#menuAccordion").accordion({ //初始化accordion
            fillSpace:true,
            border:false,
            animate:false
        });
        $.post(
            "${pageContext.request.contextPath}/menu/show",
            function(data){
                $.each(data,function(index,obj){
                    var a = "";
                    $.each(obj.listMenu,function(index1,result){
                        a+="<p style='text-align:center'><a href=\"#\" class=\"easyui-linkbutton\" onclick=\"addTabs('"+result.title+"','"+result.iconCls+"','"+result.url+"')\" data-options=\"iconCls:'"+result.iconCls+"'\">"+result.title+"</a></p>"
                    })
                    if(obj.parentId==null){
                        $("#menuAccordion").accordion("add",{
                            title:obj.title,
                            iconCls:obj.iconCls,
                            content: a
                        });
                    }
                });
            },
            "JSON"
        );
    });
	function addTabs(title,iconCls,url) {
        if($("#menuTabs").tabs("exists",title)){
            $("#menuTabs").tabs("select",title);
        }else{
            $("#menuTabs").tabs("add",{
                title:title,
                iconCls:iconCls,
                closable:true,
                href:"${pageContext.request.contextPath}"+url
            })
        }
    }
</script>

</head>
<body class="easyui-layout">   
    <div data-options="region:'north',split:true" style="height:60px;background-color:  #5C160C">
    	<div style="font-size: 24px;color: #FAF7F7;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px" >持名法州后台管理系统</div>
    	<div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 300px;float:right;padding-top:15px">欢迎您:${sessionScope.name} &nbsp;<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改密码</a>&nbsp;&nbsp;<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-01'">退出系统</a></div>
    </div>   
    <div data-options="region:'south',split:true" style="height: 40px;background: #5C160C">
    	<div style="text-align: center;font-size:15px; color: #FAF7F7;font-family: 楷体" >&copy;百知教育 htf@zparkhr.com.cn</div>
    </div>   
       
    <div data-options="region:'west',title:'导航菜单',split:true" style="width:220px;">
    	<div id="menuAccordion" class="easyui-accordion" data-options="fit:true"></div>
    </div>   
    <div data-options="region:'center'">
    	<div id="menuTabs" class="easyui-tabs" data-options="fit:true,narrow:true,pill:true">
		    <div title="主页" data-options="iconCls:'icon-neighbourhood',"  style="background-image:url(${pageContext.request.contextPath}/main/image/shouye.jpg);background-repeat: no-repeat;background-size:100% 100%;"></div>
		</div>  
    </div>   
</body> 
</html>