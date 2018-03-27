<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title><!DOCTYPE html>
        <html>
        <head>
            <meta charset="utf-8"/>
            <title>java</title>
            <link rel="stylesheet" href="../../css/style.css"/>
        </head>
<body>
<div class="n-head">
    <div class="g-doc f-cb">
        <div class="user">
            <span class="name" id="whoIsHere"> 卖家你好，${sessionScope.loginName}！<a href="#" id="logout-my">[退出]</a></span>
            <span id="isLogin"> 请<a href="/user/loginskip">[登录]</a></span>
        </div>
        <ul class="nav">
            <li><a href="/content/showContent">首页</a></li>
            <li><a href="/purchased/showPurItem">账务</a></li>
            <li><a href="/content/publicSkip">发布</a></li>
        </ul>
    </div>
</div>
<div class="g-doc">
    <div class="n-result">
        <h3>编辑成功！</h3>
        <p><a href="/content/detail?contentId=${contendId}">[查看内容]</a><a href="/content/showContent">[返回首页]</a></p>
    </div>
</div>
<div class="n-foot">
    <p>版权所有：网易云课堂<a href="http://mooc.study.163.com/smartSpec/detail/85002.htm">Java开发工程师(Web方向)</a>微专业团队</p>
</div>
<script type="text/javascript" src="../../js/jquery1.7.2.js"></script>
<script type="text/javascript">
    window.onload = function () {
        //注意一定是字符创格式！！！不然报错!找不到符号！！
        var sl='${sessionScope.loginName}';
        //alert(sl);
        //字符串空字符！！
        if(sl != ''){
            $("#isLogin").hide();
            $("#whoIsHere").show();
        }else {
            $("#isLogin").show();
            $("#whoIsHere").hide();
        }
    }
    $("#logout-my").click(function () {
        if (confirm("确定退出?")) {
            $.get("/user/logout",
                function (data) {
                    window.location.href = "/content/showContent";
                })
        }
    });
</script>
</body>
</html>

