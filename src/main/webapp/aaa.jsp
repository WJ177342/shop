<%--
  Created by IntelliJ IDEA.
  User: WJ177
  Date: 2020/9/27
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="assert/js/jquery-1.11.3.js" type="text/javascript"></script>
    <script type="javascript">
        $(function (){
            $("#btn").click(function () {
                alert(111)
                var data = $("#form").serializeArray();
                var s = JSON.stringify(data);
                $("#div1").empty().text(s);
                $.each(data,function (index,obj) {
                    $("#div1").append("<p>"+obj.name+"----"+obj.value+"</p>")
                });
            });
        })
    </script>
</head>
<body>
<form action="#" method="post" id="myform">
   <%-- <input type="button" value="get"><br>--%>
    <input type="text" name="username" placeholder="用户名"><br>
    <input type="password" name="password" placeholder="密码"><br>
    <input type="datetime-local" name="time"><br>
    <input type="number" name="age" placeholder="年龄"><br>
    <input type="radio" name="sex" value="男">男
    <input type="radio" name="sex" value="女">女<br>
    <input type="checkbox" name="hobby" value="111">111
    <input type="checkbox" name="hobby" value="222">222
    <input type="checkbox" name="hobby" value="333">333<br>

</form>
<%--<input type="button" id="btn" value="提交">--%>

<button id="btn">提交</button>
<div id="div1"></div>
</body>
</html>
