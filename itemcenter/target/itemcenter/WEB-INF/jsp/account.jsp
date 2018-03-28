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
            <span class="name" id="whoIsHere">你好，${sessionScope.loginName}！<a href="#" id="logout-my">[退出]</a></span>
            <span id="isLogin"> 请<a href="/user/loginskip">[登录]</a></span>
        </div>
        <ul class="nav">
            <li><a href="/content/showContent">首页</a></li>
            <li><a href="/purchased/showPurItem" id="account-my">账务</a></li>
            <li><a href="/content/publicSkip" id="public-my">发布</a></li>
        </ul>
    </div>
</div>
<div class="g-doc">
    <div class="m-tab m-tab-fw m-tab-simple f-cb">
        <h2>已购买的内容</h2>
    </div>
    <table class="m-table m-table-row n-table g-b3">
        <colgroup>
            <col class="img"/>
            <col/>
            <col class="time"/>
            <col class="price"/>
        </colgroup>
        <thead>
        <tr>
            <th>内容图片</th>
            <th>内容名称</th>
            <th>购买时间</th>
            <th>购买价格</th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${!empty purItemList}">
            <c:forEach var="purItem" items="${purItemList}">
                <tr>
                    <td><a href="/content/detail?contentId=${purItem.detailId}"><img src="${purItem.imageURL}"alt=""></a>
                    </td>
                    <td><h4><a href="/content/detail?contentId=${purIdtem.detailId}">${purItem.title}</a>
                    </h4></td>
                    <td><span class="v-time">${purItem.buiedTime}</span></td>
                    <td><span class="v-unit">¥</span><span class="value">${purItem.price}</span></td>
                </tr>
            </c:forEach>
        </c:if>
        </tbody>
        <tfoot>
        <tr>
            <td colspan="3">
                <div class="total">总计：</div>
            </td>
            <td><span class="v-unit">¥</span><span class="value">${total}</span></td>
        </tr>
        </tfoot>
    </table>
</div>
<div class="n-foot">
    <p>版权所有：网易云课堂<a href="http://mooc.study.163.com/smartSpec/detail/85002.htm">Java开发工程师(Web方向)</a>微专业团队</p>
</div>
<script type="text/javascript" src="../../js/jquery1.7.2.js"></script>
<script type="text/javascript">
    window.onload = function () {
        //注意一定是字符创格式！！！不然报错!找不到符号！！
        var sl='${sessionScope.loginName}';
        if(sl == "buyer"){
            $("#public-my").hide();
            $("#account-my").show();
        }else if (sl == "seller"){
            $("#account-my").hide();
            $("#public-my").show();
        }
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