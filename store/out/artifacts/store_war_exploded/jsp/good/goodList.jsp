<%--
  Created by IntelliJ IDEA.
  User: 86135
  Date: 2022/9/14
  Time: 17:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>商品列表</title>
    <link rel="stylesheet" href="../../layui/css/layui.css">
</head>
<body>

<table class="layui-table">
    <colgroup>
        <col width="150">
        <col width="200">
        <col>
    </colgroup>
    <thead>
    <tr>
        <th>id</th>
        <th>编号</th>
        <th>商品</th>
        <th>价格</th>
        <th>单位</th>
        <th>会员价</th>
        <th>供应商</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${goodList}" var="good">
        <tr>
            <td>${good.id}</td>
            <td>${good.goodNum}</td>
            <td>${good.goodName}</td>
            <td>${good.price}</td>
            <td>${good.unit}</td>
            <td>${good.vPrice}</td>
            <td>${good.vendorId}</td>
            <td>
                <a href="updateGood?goodId=${good.id}&flag=1" class="layui-btn" >修改</a>
                <a href="delGood?goodId=${good.id}" class="layui-btn layui-btn-danger" >删除</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>