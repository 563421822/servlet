<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<c:if test="${requestScope.message eq '添加成功!'}">
    <script type="text/javascript">
        alert("${requestScope.message}");
    </script>
</c:if>
<body>
<form action="ByInfoServlet" method="get">
    <table>
        <tr>
            <th>品种:</th>
            <th><select name="breed">
                <optgroup label="请选择">
                    <option value="1">狗</option>
                    <option value="2">猫</option>
                    <option value="3">鸟</option>
                    <option value="4">兔</option>
                </optgroup>
            </select><input type="submit" value="查询"/></th>
            <th><a href="addPet.xhtml">新增宠物</a></th>
        </tr>
    </table>
</form>
<table border="1">
    <tr>
        <td>宠物昵称</td>
        <td>出生日期</td>
        <td>性别</td>
    </tr>
    <c:forEach var="l" items="${requestScope.list}" varStatus="status">
        <tr ${status.index%2 eq 0?"style='background-color: lightblue'":"style='background-color: darkseagreen'"}>
            <td>${l.nickname}</td>
            <td>${l.birthday}</td>
            <td>${l.gender eq "1"?"雌":"雄"}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
