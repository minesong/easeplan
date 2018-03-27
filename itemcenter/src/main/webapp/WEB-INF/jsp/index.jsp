<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <meta charset="utf-8"/>
    <title>java</title>
    <link rel="stylesheet" href="../../css/style.css"/>
</head>
<body>
<div class="n-support">请使用Chrome、Safari等webkit内核的浏览器！</div>
<div class="n-head">
    <div class="g-doc f-cb">
        <div class="user">
           <span class="name" id="whoIsHere"> 买家你好，${sessionScope.loginName}！<a href="#" id="logout-my">[退出]</a></span>
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
    <div class="m-tab m-tab-fw m-tab-simple f-cb">
        <div class="tab">
            <ul>
                <li class="z-sel"><a href="/content/showContent">所有内容</a></li>
                <li><a href="/content/isSale">未购买的内容</a></li>
            </ul>
        </div>
    </div>
    <div class="n-plist">
        <ul class="f-cb" id="plist">
            <c:if test="${!empty contentList}">
                <c:forEach var="cl" items="${contentList}">
                    <li id="p-1">
                        <input type="hidden" name="contentId" value=${cl.id}>
                        <a href="/content/detail?contentId=${cl.detailId}" class="link">
                            <div class="img"><img src=${cl.imageURL} alt=""></div>
                            <h3>${cl.title}</h3>
                            <div class="price"><span class="v-unit">¥</span><span class="v-value">${cl.price}</span>
                            </div>
                            <span class="had"><b>${(cl.isSale eq 1) ? "在售" : "已售出"} </b></span>
                        </a>
                    </li>
                </c:forEach>
            </c:if>
        </ul>
    </div>
</div>
<div class="n-foot">
    <p>版权所有：网易云课堂<a href="http://mooc.study.163.com/smartSpec/detail/85002.htm">Java开发工程师(Web方向)</a>微专业团队</p>
</div>
<script type="text/javascript" src="../../js/global.js"></script>
<script type="text/javascript" src="../../js/pageIndex.js"></script>
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