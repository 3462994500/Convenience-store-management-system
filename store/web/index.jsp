<%--
  Created by IntelliJ IDEA.
  User: YANG
  Date: 2022/9/13
  Time: 21:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width">
  <title>便利店管理系统</title>
  <link rel="stylesheet" href="layui/css/layui.css">
</head>

<body>
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
    <div class="layui-logo layui-hide-xs layui-bg-black">

      <i class="layui-icon layui-icon-read"></i>
      便利店管理系统</div>
    <!-- 头部区域（可配合layui 已有的水平导航） -->
    <ul class="layui-nav layui-layout-left">
      <!-- 移动端显示 -->
      <li class="layui-nav-item layui-show-xs-inline-block layui-hide-sm" lay-header-event="menuLeft">
        <i class="layui-icon layui-icon-spread-left"></i>
      </li>

    </ul>
    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item layui-hide layui-show-md-inline-block">
        <a href="javascript:;">
          ${session_user.userName}
        </a>

      </li>

    </ul>
  </div>

  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
      <ul class="layui-nav layui-nav-tree" lay-filter="test">
        <li class="layui-nav-item layui-nav-itemed">
          <a class="" href="javascript:;">门店管理</a>
          <dl class="layui-nav-child">
            <dd>
              <a href="jsp/store/addStore.jsp" target="iframeMain" >门店添加</a>
            </dd>
            <dd>
              <a href="storeList" target="iframeMain" >门店列表</a>
            </dd>

          </dl>
        </li>
        <li class="layui-nav-item">
          <a href="javascript:;">用户管理</a>
          <dl class="layui-nav-child">
            <dd>
              <a href="jsp/user/addUser.jsp" target="iframeMain" >用户添加</a>
            </dd>
            <dd>
              <a href="userList" target="iframeMain">用户列表</a>
            </dd>
          </dl>
        </li>

        <li class="layui-nav-item">
          <a href="javascript:;">会员管理</a>
          <dl class="layui-nav-child">
            <dd>
              <a href="jsp/vip/addVip.jsp" target="iframeMain">会员添加</a>
            </dd>
            <dd>
              <a href="vipList" target="iframeMain">会员列表</a>
            </dd>
          </dl>
        </li>

        <li class="layui-nav-item">
          <a href="javascript:;">商品管理</a>
          <dl class="layui-nav-child">
            <dd>
              <a href="addGood?flag=1" target="iframeMain">商品添加</a>
            </dd>
            <dd>
              <a href="goodList" target="iframeMain">商品列表</a>
            </dd>
          </dl>
        </li>

        <li class="layui-nav-item">
          <a href="javascript:;">供应商管理</a>
          <dl class="layui-nav-child">
            <dd>
              <a href="jsp/vendor/addVendor.jsp" target="iframeMain">供应商添加</a>
            </dd>
            <dd>
              <a href="vendorList" target="iframeMain">供应商列表</a>
            </dd>
          </dl>
        </li>

        <li class="layui-nav-item">
          <a href="javascript:;">系统管理</a>
          <dl class="layui-nav-child">
            <dd>
              <a href="loginOut">退出登录</a>
            </dd>
          </dl>
        </li>

      </ul>
    </div>
  </div>

  <div class="layui-body">
    <!-- 内容主体区域 -->
    <div style="padding: 15px; height: 100%;">
      <iframe src="welcome.jsp" width="100%" height="100%" style="border: 0;" name="iframeMain" id="iframeMain"></iframe>
    </div>
  </div>

  <div class="layui-footer">
    <!-- 底部固定区域 -->
    实训项目
  </div>
</div>
<script src="layui/layui.js"></script>
<script src="js/jquery-3.6.0.min.js"></script>
<script>


</script>
</body>

</html>
