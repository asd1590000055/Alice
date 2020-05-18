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
    <title>前台页面</title>
    <link rel="stylesheet" href="${app}/statics/boot/css/bootstrap.css">
    <link rel="stylesheet" href="${app}/statics/jqgrid/css/ui.jqgrid-bootstrap.css">
    <%--引入js文件--%>
    <script src="${app}/statics/boot/js/jquery-3.3.1.min.js"></script>
    <script src="${app}/statics/boot/js/bootstrap.min.js"></script>
    <script src="${app}/statics/jqgrid/js/jquery.jqGrid.min.js"></script>
    <script src="${app}/statics/jqgrid/js/grid.locale-cn.js"></script>
</head>

<body>
<!--引入导航栏-->
<div>
    <div class="row">
        <nav class="navbar navbar-inverse">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                            data-target="#bs-example-navbar-collapse-1" aria-expanded="false"/>
                    </button>
                    <a class="navbar-brand" href="">个人博客专栏</a>
                </div>

                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav" id="nv1">
                        <li class="active" id="firstPage"><a href="/article">首页</a></li>
                        <li id="javaPage"><a href="">Java专栏</a></li>
                        <li id="springPage"><a href="">Spring专栏</a></li>
                        <li id="jsPage"><a href="">Js专栏</a></li>
                        <li id="algorPage"><a href="">算法专栏</a></li>
                    </ul>
                    <form class="navbar-form navbar-right" href="">
                        <div class="input-group">
                            <input type="text" class="form-control" placeholder="搜索" name="key"/>
                            <span class="input-group-btn">
        <button class="btn btn-default" type="submit">Go!</button>
      </span>
                        </div>
                    </form>
                </div>
            </div>
        </nav>
    </div>

    <div>
        <c:if test="${requestScope.list!=null}">
            <c:forEach var="article" items="${requestScope.list}">
                <div class="row">
                    <div class="container">
                        <div class="jumbotron">
                            <h3>${article.title}</h3>
                            <span class="summary">${article.date}</span><br/><br/>
                            <p><a class="btn btn-primary btn-lg"
                                  href="${pageContext.request.contextPath}/article/selectOne?id=${article.id}"
                                  role="button">阅读全文</a></p>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </c:if>
    </div>


</div>

</body>
</html>