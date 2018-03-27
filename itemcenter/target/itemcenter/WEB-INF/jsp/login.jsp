<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
<meta charset="utf-8"/>
<title>java</title>
<link rel="stylesheet" href="../css/style.css"/>
</head>
<body>
<form class="m-form m-form-ht n-login" id="loginForm-my" onsubmit="return false;" autocomplete="off">
    <div class="fmitem">
        <label class="fmlab">用户名：</label>
        <div class="fmipt">
            <input class="u-ipt" name="userName" autofocus/>
        </div>
    </div>
    <div class="fmitem">
        <label class="fmlab">密码：</label>
        <div class="fmipt">
            <input class="u-ipt" type="password" name="password"/>
        </div>
    </div>
    <div class="fmitem fmitem-nolab fmitem-btn">
        <div class="fmipt">
            <button type="submit" class="u-btn u-btn-primary u-btn-lg u-btn-block" id="submit-my">登 录</button>
        </div>
    </div>
</form>
<div class="n-foot">
    <p>版权所有：网易云课堂<a href="http://mooc.study.163.com/smartSpec/detail/85002.htm">Java开发工程师(Web方向)</a>微专业团队</p>
</div>
<script type="text/javascript" src="../../js/jquery1.7.2.js"></script>
<script type="text/javascript" src="../../js/jquery.md5.js"></script>
<script type="text/javascript" src="../../js/global.js"></script>
<script type="text/javascript" src="../../js/pageLogin.js"></script>

<script type="text/javascript">
    $("#submit-my").click(function(){
        var userNmme = $("input[name='userName']").val();
        var password = $("input[name='password']").val();
        //alert(userNmme);
        //alert(password);
        if(userNmme == '' ||password == ''){
            alert("用户名密码不能为空")
        }else{
            var MD5Password = $.md5(password);
            //alert(MD5Password);
            $.post("/user/login",
                {
                    userName: userNmme,
                    password: MD5Password
                },function (data) {
                if(data == "success"){
                    window.location.href="/content/showContent";
                }else {
                    alert("用户名密码不匹配");
                }
                }
            )
        }
      });


</script>
</body>
</html>