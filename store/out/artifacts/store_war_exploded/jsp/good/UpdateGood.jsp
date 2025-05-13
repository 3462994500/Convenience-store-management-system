<%--
  Created by IntelliJ IDEA.
  User: YANG
  Date: 2022/9/14
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Title</title>
  <%--引入layui的css和js--%>
  <link rel="stylesheet" href="../../layui/css/layui.css">
  <script src="../../layui/layui.js" type="text/javascript"></script>
</head>
<body>

<div style="width: 500px">



  <form class="layui-form" action="/updateGood">
    <input type="hidden" name="id" value="${good.id}">
    <div class="layui-form-item">

      <label class="layui-form-label">商品编号</label>
      <div class="layui-input-block">
        <input type="text" name="goodNum" value="${good.goodNum}" required  lay-verify="required" placeholder="请输入商品编号" autocomplete="off" class="layui-input">
      </div>
    </div>

    <div class="layui-form-item">
      <label class="layui-form-label">商品名称</label>
      <div class="layui-input-block">
        <input type="text" name="goodName" value="${good.goodName}" required  lay-verify="required" placeholder="请输入商品名称" autocomplete="off" class="layui-input">
      </div>
    </div>

    <div class="layui-form-item">
      <label class="layui-form-label">价格</label>
      <div class="layui-input-block">
        <input type="text" name="price" value="${good.price}" required  lay-verify="required" placeholder="请输入价格" autocomplete="off" class="layui-input">
      </div>
    </div>
    <div class="layui-form-item">
      <label class="layui-form-label">单位</label>
      <div class="layui-input-block">
        <input type="text" name="unit" value="${good.unit}" required  lay-verify="required" placeholder="请输入单位" autocomplete="off" class="layui-input">
      </div>
    </div>
    <div class="layui-form-item">
      <label class="layui-form-label">会员价格</label>
      <div class="layui-input-block">
        <input type="text" name="vPrice" value="${good.vPrice}" required  lay-verify="required" placeholder="请输入会员价格" autocomplete="off" class="layui-input">
      </div>
    </div>

    <div class="layui-form-item">
      <label class="layui-form-label">供应商</label>
      <div class="layui-input-block">
        <select name="vendorId" lay-verify="required">
          <option value=""></option>
          <c:forEach items="${vendorList}" var="v">
            <option value="${v.id}" ${v.id==good.vendorId ? 'selected':''}>${v.vendorName}</option>
          </c:forEach>
        </select>
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
