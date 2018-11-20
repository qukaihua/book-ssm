<%--
  Created by IntelliJ IDEA.
  User: 96283
  Date: 2018/11/7
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>book</title>
</head>
<body>
     <h1>新增图书</h1>
<form  action="/book-ssm/book/insert" method="post">
    书名：<input type="text" name="name"><br>
    描述：<input type="text" name="description"><br>
    库存：<input type="text" name="kc"><br>
    <input type="submit" value="新增">
</form>
     <hr style="height:1px;border:none;border-top:1px dashed #0066CC;" />
     <h1>删除图书</h1>
     <form  action="/book-ssm/book/delete" method="post">
         ID:<input type="text" name="id"><br>
         <input type="submit" value="删除">
     </form>
     <hr style="height:1px;border:none;border-top:1px dashed #0066CC;" />
     <h1>编辑图书</h1>
     <form  action="/book-ssm/book/update" method="post">
         ID:<input type="text" name="id"><br>
         书名：<input type="text" name="name"><br>
         描述：<input type="text" name="description"><br>
         库存：<input type="text" name="kc"><br>
         <input type="submit" value="编辑">
     </form>
     <hr style="height:1px;border:none;border-top:1px dashed #0066CC;" />
     <h1>查询图书</h1>
     <form  action="/book-ssm/book/search" method="post">
     书名：<input type="text" name="name"><br>
     描述：<input type="text" name="description"><br>
     库存：<input type="text" name="kc"><br>
     页码：<input type="text" name="page">条数:<input type="text" name="rows">排序:<input type="text" name="sort">字段:<input type="text" name="seq">
     <input type="submit" value="查询">
     </form>




</body>
</html>
