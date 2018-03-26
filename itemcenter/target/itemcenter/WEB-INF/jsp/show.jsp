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
<div class="n-head">
    <div class="g-doc f-cb">
        <div class="user">
            买家你好，<span class="name">mmmmm</span>！<a href="">[退出]</a>
            请<a href="/user/loginskip">[登录]</a>
        </div>
        <ul class="nav">
            <li><a href="/content/showContent">首页</a></li>
            <li><a href="/purchased/showPurItem">账务</a></li>
            <li><a href="/content/publicSkip">发布</a></li>
        </ul>
    </div>
</div>
<div class="g-doc">
    <div class="n-show f-cb" id="showContent">
        <div class="img"><img src=${contentDetail.imageURL} alt=""></div>
        <div class="cnt">
            <h2>${contentDetail.title}</h2>
            <p class="summary">${contentDetail.summary}</p>
            <div class="price">
                <span class="v-unit">¥</span><span class="v-value">${contentDetail.price} </span>
            </div>
            <div class="oprt f-cb">
                <button class="u-btn u-btn-primary" data-buy="0">购 买</button>
                <span class="u-btn u-btn-primary z-dis">已购买</span>
                <span class="buyprice">当时购买价格：¥${contentDetail.price}</span>
                <a href="/content/editSkip?contentId=${contentDetail.id}" class="u-btn u-btn-primary">编 辑</a>
            </div>
        </div>
    </div>
    <div class="m-tab m-tab-fw m-tab-simple f-cb">
        <h2>详细信息</h2>
    </div>
    <div class="n-detail">
        ${contentDetail.detail}
    </div>
    <div class="n-foot">
        <p>版权所有：网易云课堂<a href="http://mooc.study.163.com/smartSpec/detail/85002.htm">Java开发工程师(Web方向)</a>微专业团队</p>
    </div>
</div>
<script type="text/javascript" src="../../js/global.js"></script>
<script type="text/javascript" src="../../js/pageShow.js"></script>
<script type="text/javascript" src="../../js/jquery1.7.2.js"></script>
</body>
</html>