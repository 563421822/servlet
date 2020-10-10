<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
    <script type="text/javascript" src="js/rain.js"></script>
    <c:if test="${requestScope.success eq '操作成功'}">
        <script type="text/javascript">
            alert("${requestScope.success}")
        </script>
    </c:if>
</head>
<body>
<table border="1">
    <caption>雨量检测信息</caption>
    <tr>
        <td>序号</td>
        <td>区域名称</td>
        <td>监测时间</td>
        <td>雨量值(mm)</td>
        <td>监测站</td>
        <td>站点地址</td>
        <td>操作</td>
    </tr>
    <c:forEach var="l" items="${requestScope.list}">
        <tr>
            <td>${l.id}</td>
            <td>${l.districtName}</td>
            <td>${l.monitorTime}</td>
            <td>${l.rain}</td>
            <td>${l.monitoringStation}</td>
            <td>${l.monitoringAddress}</td>
            <td><a href="javascript:void(0)" onclick="deleteById(${l.id})">删除</a></td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="7"><a href="add.xhtml">添加雨量监测信息</a></td>
    </tr>
</table>
</body>
</html>
