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
    <title>门店列表</title>
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
        <th>门店编号</th>
        <th>门店名称</th>
        <th>门店地址</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${storeList}" var="store">
        <tr>
            <td>${store.id}</td>
            <td>${store.storeNum}</td>
            <td>${store.storeName}</td>
            <td>${store.storeAddress}</td>
            <td>
                <a href="updateStore?storeId=${store.id}&flag=1" class="layui-btn" >修改</a>
                <a href="delStore?storeId=${store.id}" class="layui-btn layui-btn-danger" >删除</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>