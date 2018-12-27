<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<script type="text/javascript">
    var myChart = echarts.init(document.getElementById("statistics_main"));
    var option = {
        title: {
            text: '持名法州APP活跃用户',
            subtext: '2018年最近几周数据',
            left: 'center'
        },
        tooltip: {
            trigger: 'item'
        },
        xAxis: {
            type: 'category',
            data: []
        },
        yAxis: {
            type: 'value'
        },
        series: [{
            name:"活跃用户",
            data: [],
            type: 'bar'
        }]
    };
    myChart.setOption(option);
    $(function(){
        $.post(
            "${pageContext.request.contextPath}/data/showActiveUser",
            function (data) {
                console.log(data);
                myChart.setOption({
                    xAxis:{
                        data:data.intervals
                    },
                    series:[{
                        name:"活跃用户",
                        data:data.counts
                    }]
                })
            }
        );
    });
</script>
<div id="statistics_main" style="width: 600px;height: 400px;;margin-top: 30px;margin-left: 30px"></div>