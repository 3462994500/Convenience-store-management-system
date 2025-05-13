<%--
  Created by IntelliJ IDEA.
  User: YANG
  Date: 2022/9/15
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
    <link rel="stylesheet" href="layui/css/layui.css">
    <script src="layui/layui.js"></script>
    <script>
        //JavaScript代码区域
        layui.use('form', function() {
            var form = layui.form;

        });
    </script>
    <style>
        .box {
            position: relative;
            width: 460px;
            height: 340px;
            background-color: #ffffffaa;
            margin: 180px auto;
            border-radius: 5px;
            padding-top: 40px;
        }
        .box-form {
            margin: 0 0 0 65px;
        }
    </style>
</head>
<body style="background-image: url('img/demo-1-bg.jpg')">
<div class="box">
    <div class="box-form">
        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
            <legend>便利店管理系统</legend>
        </fieldset>
        <form class="layui-form layui-form-pane " action="/login" method="post">
            <!-- 提示：如果你不想用form，你可以换成div等任何一个普通元素 -->
            <div class="layui-form-item">
                <label class="layui-form-label">用户账号</label>
                <div class="layui-input-inline">
                    <input type="text" name="userPhone" required lay-verify="username" placeholder="请输入手机号" autocomplete="off" class="layui-input">
                </div>
                <i class="layui-icon" style="font-size: 30px; color: #1E9FFF;"></i>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">用户密码</label>
                <div class="layui-input-inline">
                    <input type="password" name="userPwd" required lay-verify="password" placeholder="请输入密码" autocomplete="off" class="layui-input">
                </div>
                <i class="layui-icon layui-icon-password" style="font-size: 30px; color: #1E9FFF;"></i>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" lay-submit lay-filter="formDemo">登录</button>
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                </div>
            </div>
        </form>
    </div>

</div>

</body>
</html>
