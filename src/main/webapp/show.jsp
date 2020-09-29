<%--
  Created by IntelliJ IDEA.
  User: WJ177
  Date: 2020/9/25
  Time: 19:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="assert/js/jquery-1.11.3.js" type="text/javascript"></script>
    <style>
        #search{
            width: 300px;
            height: 50px;
        }
        button{
            height: 50px;
            width: 100px;
        }
        table{
            margin: 0 auto;
            text-align: center;
            width: 100%;
        }
    </style>
    <script type="text/javascript">
        $(function () {
            $("#btn").click(function () {
                $.ajax({
                    url: "<%=application.getContextPath()%>/product?op=like",
                    type: "post",
                    data: {
                            "name":$("#search").val()
                    },
                    success:function (data) {
                        if (data!="null") {
                            var arr = JSON.parse(data);
                            var tr = $("#table").find("tr").first();
                            $("#table").empty();
                            $("#table").append(tr);
                            $.each(arr,function (index,obj) {
                                $("#table").append(
                                "<tr>"+
                                    "<td>"+obj.id+"</td>"+
                                    "<td>"+obj.name+"</td>"+
                                    "<td>"+obj.description+"</td>"+
                                    "<td>"+obj.price+"</td>"+
                                    "<td>"+obj.stock+"</td>"+
                                    "<td>"+obj.categoryLevel1Id+"</td>"+
                                    "<td>"+obj.categoryLevel2Id+"</td>"+
                                    "<td>"+obj.categoryLevel3Id+"</td>"+
                                    "<td>"+obj.fileName+"</td>"+
                                    "<td>"+obj.isDelete+"</td>"+
                                    "<td>"+obj.brand_id+"</td>"+
                                "</tr>")
                            })
                            $("tr:even").css("background","#FEFEFE");
                            $("tr:odd").css("background","#E1EDEE")
                        } else {
                            $("#table").empty();
                            $("#table").append("<thead>没有找到该商品的相关信息！！！</thead>")
                        }
                    },
                    error:function () {
                        
                    }
                });
                return false;
            });
        })
    </script>
</head>
<body>
<input type="text" name="search" id="search">
<button id="btn">搜索</button><br><br>
<button id="all">显示所有商品</button><br><br>
<table id="table">
    <tr>
        <th>商品编号</th>
        <th>商品名称</th>
        <th>商品描述</th>
        <th>商品单价</th>
        <th>库存</th>
        <th>categoryLevel1Id</th>
        <th>categoryLevel2Id</th>
        <th>categoryLevel3Id</th>
        <th>fileName</th>
        <th>isDelete</th>
        <th>brand_id</th>
    </tr>
</table>
</body>
</html>
