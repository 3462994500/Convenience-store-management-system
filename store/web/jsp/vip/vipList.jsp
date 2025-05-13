<%--
  Created by IntelliJ IDEA.
  Vip: 86135
  Date: 2022/9/14
  Time: 17:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>会员列表</title>
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
        <th>用户名</th>
        <th>电话</th>
        <th>地址</th>
        <th>创建时间</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${vipList}" var="vip">
        <tr>
            <td>${vip.id}</td>
            <td>${vip.vipName}</td>
            <td>${vip.vipPhone}</td>
            <td>${vip.vipAddress}</td>
            <td>${vip.createDate}</td>
            <td>
                <a href="updateVip?vipId=${vip.id}&flag=1" class="layui-btn" >修改</a>
                <a href="delVip?vipId=${vip.id}" class="layui-btn layui-btn-danger" >删除</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>