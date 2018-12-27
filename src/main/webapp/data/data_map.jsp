<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<script type="text/javascript">
    var myChart = echarts.init(document.getElementById('statistics_china'));
    var option = {
        title: {
            text: '持名法州APP用户分布图',
            subtext: '2018年最新数据',
            left: 'center'
        },
        tooltip: {
            trigger: 'item'
        },
        legend: {
            orient: 'vertical',
            left: 'left',
            data: ['男','女']
        },
        visualMap: {
            min: 0,
            max: 5,
            left: 'left',
            top: 'bottom',
            text: ['高', '低'],           // 文本，默认为数值文本
            calculable: true
        },
        toolbox: {
            show: true,
            orient: 'vertical',
            left: 'right',
            top: 'center',
            feature: {
                mark: {show: true},
                dataView: {show: true, readOnly: false},
                restore: {show: true},
                saveAsImage: {show: true}
            }
        },
        series: [
            {
                name: '男',
                type: 'map',
                mapType: 'china',
                roam: false,
                label: {
                    normal: {
                        show: false
                    },
                    emphasis: {
                        show: true
                    },
                    data:[]
                }
            },{
                name: '女',
                type: 'map',
                mapType: 'china',
                roam: false,
                label: {
                    normal: {
                        show: false
                    },
                    emphasis: {
                        show: true
                    },
                    data:[]
                }
            }
        ]
    };
    myChart.setOption(option);
    $(function(){
        $.post(
            "${pageContext.request.contextPath}/data/showDataMapByMale",
            function (data) {
                console.log(data);
                myChart.setOption({
                    series:[{
                        name:'男',
                        data:data
                    }]
                })
            },
            "json"
        );
        $.post(
            "${pageContext.request.contextPath}/data/showDataMapByFemale",
            function (data) {
                console.log(data);
                myChart.setOption({
                    series:[{
                        name:'女',
                        data:data
                    }]
                })
            },
            "json"
        );
    });
</script>
<div id="statistics_china" style="width: 100%;height: 100%;margin-top: 30px;margin-left: 30px"></div>