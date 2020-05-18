<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${pageContext.request.contextPath}" var="app"></c:set>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>管理员登录页面</title>
    <link rel="stylesheet" href="${app}/statics/signin.css">
    <link rel="stylesheet" href="${app}/statics/boot/css/bootstrap.css">
    <link rel="stylesheet" href="${app}/statics/jqgrid/css/ui.jqgrid-bootstrap.css">
    <%--引入js文件--%>
    <script src="${app}/statics/boot/js/jquery-3.3.1.min.js"></script>
    <script src="${app}/statics/boot/js/bootstrap.min.js"></script>
    <script src="${app}/statics/jqgrid/js/jquery.jqGrid.min.js"></script>
    <script src="${app}/statics/jqgrid/js/grid.locale-cn.js"></script>

</head>
<body>

<form class="form-signin" action="${pageContext.request.contextPath}/admin/login" method="get">
    <h2 class="form-signin-heading">请登录</h2>
    <c:if test="${requestScope.error eq 'aa'}">
        <p style="color: red">密码或者用户名错误</p>
    </c:if>

    <label for="inputEmail" class="sr-only">请输入用户名</label>
    <input type="text" id="inputEmail" name="name" class="form-control" placeholder="用户名" required autofocus>

    <label for="inputPassword" class="sr-only">密码</label>
    <input type="password" id="inputPassword" name="password" class="form-control" placeholder="密码" required>

    <div class="checkbox">
        <label>
            <input type="checkbox" value="remember-me"> 记住我
        </label>
    </div>
    <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
</form>

</div>
</body>
</html>