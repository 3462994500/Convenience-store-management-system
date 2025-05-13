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
    <title>用户列表</title>
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
        <th>密码</th>
        <th>电话</th>
        <th>地址</th>
        <th>创建时间</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
        <c:forEach items="${userList}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.userName}</td>
                <td>${user.userPwd}</td>
                <td>${user.userPhone}</td>
                <td>${user.userAddress}</td>
                <td>${user.createDate}</td>
                <td>
                    <a href="updateUser?userId=${user.id}&flag=1" class="layui-btn" >修改</a>
                    <a href="delUser?userId=${user.id}" class="layui-btn layui-btn-danger" >删除</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>