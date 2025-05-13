<%--
  Created by IntelliJ IDEA.
  User: YANG
  Date: 2022/9/14
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%--引入layui的css和js--%>
    <link rel="stylesheet" href="../../layui/css/layui.css">
    <script src="../../layui/layui.js" type="text/javascript"></script>
</head>
<body>

<div style="width: 500px">



    <form class="layui-form" action="/updateVip">
        <input type="hidden" name="id" value="${vip.id}">
        <div class="layui-form-item">
            <label class="layui-form-label">用户名</label>
            <div class="layui-input-block">
                <input type="text" name="vipName" value="${vip.vipName}" required  lay-verify="required" placeholder="请输入新用户名" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">手机号</label>
            <div class="layui-input-block">
                <input type="text" name="vipPhone" value="${vip.vipPhone}" required  lay-verify="required" placeholder="请输入新手机号" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">地址</label>
            <div class="layui-input-block">
                <input type="text" name="vipAddress" value="${vip.vipAddress}" required  lay-verify="required" placeholder="请输入新地址" autocomplete="off" class="layui-input">
            </div>
        </div>


        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="formDemo">修改</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>
<script>
    //Demo
    layui.use('form', function(){
        var form = layui.form;

        //提交
        // form.on('submit(formDemo)', function(data){
        //     layer.msg(JSON.stringify(data.field));
        //     return false;
        // });
    });
</script>
</body>
</html>
