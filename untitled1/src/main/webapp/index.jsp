<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
    <c:if test="${requestScope.message eq '添加成功!'}">
        <script type="text/javascript">
            alert("${requestScope.message}")
        </script>
    </c:if>
</head>
<body>

<form method="get" action="FiltrateServlet">
    <table>
        <tr>
            <th>产品代码:<input type="text" name="id"/></th>
            <th>风险评级:
                <select name="riskLevel">
                    <optgroup label="请选择">
                        <option value="R2">R2</option>
                        <option value="R3">R3</option>
                    </optgroup>
                </select>
                <input type="submit" value="查询"/>
            </th>
            <th><a href="addProduct.xhtml">新增理财信息</a></th>
        </tr>
    </table>
</form>

<table border="1">
    <caption>理财产品列表</caption>
    <tr>
        <td>产品代码</td>
        <td>风险评级</td>
        <td>预期收益</td>
        <td>发售起始日</td>
        <td>发售截止日</td>
        <td>产品到期日</td>
    </tr>
    <c:forEach var="l" items="${requestScope.list}" varStatus="status">
        <tr ${status.count%2==0?"style='background-color: aqua'":"style='background-color: red'"}>
            <td>${status.index}__${l.id}</td>
            <td>${status.index}__${l.riskLevel}</td>
            <td>${status.index}__${l.prospectiveEarning}</td>
            <td>${status.index}__${l.startSale}</td>
            <td>${status.index}__${l.endSale}</td>
            <td>${status.index}__${l.expire}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
