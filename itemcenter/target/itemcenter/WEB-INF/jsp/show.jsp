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
    <div class="n-show f-cb" id="showContent_my">
        <div class="img"><img src=${contentDetail.imageURL} alt=""></div>
        <div class="cnt">
            <h2>${contentDetail.title}</h2>
            <p class="summary">${contentDetail.summary}</p>
            <div class="price">
                <span class="v-unit">¥</span><span class="v-value">${contentDetail.price} </span>
            </div>
            <div class="oprt f-cb">
                <button class="u-btn u-btn-primary" id="buyItem" data-buy="1">购 买</button>
                <span class="u-btn u-btn-primary z-dis" id="hasBuied">已购买</span>
                <span class="buyprice" id="buyprice">当时购买价格：¥${buyPrice}</span>
                <a href="/content/editSkip?contentId=${contentDetail.id}" id="edit-my" class="u-btn u-btn-primary">编
                    辑</a>
                <button class="u-btn u-btn-primary" id="deleteItem">删 除</button>
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
<script type="text/javascript">

    //Jquery在页面加载后执行
    window.onload = function () {
        //注意一定是字符创格式！！！不然报错!找不到符号！！
        var sl = '${sessionScope.loginName}';
        // alert(sl=='seller');
        //字符串空字符！！
        if (sl == 'buyer') {
            $("#public-my").hide();
            $("#deleteItem").hide();
            $("#edit-my").hide();
            $("#buyItem").show();
            $("#hasBuied").show();
            $("#buyprice").show();
            $("#account-my").show();
        } else {
            $("#account-my").hide();
            $("#buyItem").hide();
            $("#hasBuied").hide();
            $("#buyprice").hide();
            $("#deleteItem").show();
            $("#edit-my").show();
            $("#public-my").show();
        }
        if (sl != '') {
            $("#isLogin").hide();
            $("#whoIsHere").show();
        } else {
            $("#isLogin").show();
            $("#whoIsHere").hide();
        }

        var isSale =${contentDetail.isSale};
        if (isSale == 1) {
            $("#hasBuied").hide();
            $("#buyprice").hide();
        } else {
            $("#buyItem").hide();
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
    $("#buyItem").click(function () {
        if (confirm("确定购买?")) {
            $.post("/purchased/add",
                {
                    id:${contentDetail.id}
                },
                function (data) {
                    alert("购买成功！");
                    window.location.href = "/purchased/showPurItem";
                })
        }
    });
    $("#deleteItem").click(function () {
        var isSale =${contentDetail.isSale};
        alert(isSale)
        if (isSale == 0) {
            alert("该商品已经出售不能删除！");
        } else if (confirm("确定删除?")) {
            $.post("/content/delete",
                {
                    id:${contentDetail.id}
                },
                function (data) {
                    alert("删除成功！");
                    window.location.href = "/content/showContent";
                })
        }
    });
</script>
</body>
</html>