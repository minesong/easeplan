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
            <span class="name" id="whoIsHere"> 你好，${sessionScope.loginName}！<a href="#" id="logout-my">[退出]</a></span>
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
        <h2>内容发布</h2>
        <h2><c:if test="${!empty errorMSG}">
            <c:forEach var="err" items="${errorMSG}">
                <br/>${err.defaultMessage}
            </c:forEach>
        </c:if>
        </h2>
    </div>
    <div class="n-public">
        <form class="m-form m-form-ht" id="form" method="post" action="/content/add" onsubmit="return false;" autocomplete="off"   enctype="multipart/form-data">
            <div class="fmitem">
                <label class="fmlab">标题：</label>
                <div class="fmipt">
                    <input class="u-ipt ipt" name="title" autofocus placeholder="2-80字符" value="${contentDetail.title}"/>
                </div>
            </div>
            <div class="fmitem">
                <label class="fmlab">摘要：</label>
                <div class="fmipt">
                    <input class="u-ipt ipt" name="summary" placeholder="2-140字符"  value="${contentDetail.summary}"/>
                </div>
            </div>
            <div class="fmitem">
                <label class="fmlab">图片：</label>
                <div class="fmipt">
                    <input class="u-ipt ipt" name="imageURL" placeholder="选择图片地址或者文件上传" value="${contentDetail.imageURL}"/>
                    <input type="file" value="选择图片" name="myfiles">

                </div>
            </div>
            <div class="fmitem">
                <label class="fmlab">正文：</label>
                <div class="fmipt">
                    <textarea class="u-ipt" name="detail" rows="10" placeholder="2-1000个字符">${contentDetail.detail}</textarea>
                </div>
            </div>
            <div class="fmitem">
                <label class="fmlab">价格：</label>
                <div class="fmipt">
                    <input class="u-ipt price" name="price" value="${contentDetail.price}" />元
                </div>
            </div>
            <div class="fmitem fmitem-nolab fmitem-btn">
                <div class="fmipt">
                    <button type="submit" class="u-btn u-btn-primary u-btn-lg">发 布</button>
                </div>
            </div>
        </form>
        <span class="imgpre"><img src="http://nec.netease.com/img/l/1.jpg" alt="" id="imgpre"></span>
    </div>
</div>
<div class="n-foot">
    <p>版权所有：网易云课堂<a href="http://mooc.study.163.com/smartSpec/detail/85002.htm">Java开发工程师(Web方向)</a>微专业团队</p>
</div>
<script type="text/javascript" src="../../js/global.js"></script>
<script type="text/javascript" src="../../js/public.js"></script>
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

    function login() {
        $.ajax({
            //几个参数需要注意一下
            type: "POST",//方法类型
            dataType: "multipart/form-data",//预期服务器返回的数据类型
            url: "/uploadFile/upload" ,//url
            data: input["name='myfiles'"],
            success: function (result) {
                console.log(result);//打印服务端返回的数据(调试用)
                if (result.resultCode == 200) {
                    alert("SUCCESS");
                }
            },
            error : function() {
                alert("异常！");
            }
        });
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
</div>
</body>
</html>