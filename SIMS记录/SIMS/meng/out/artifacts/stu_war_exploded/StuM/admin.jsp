<%@ page import="service.FindStuService" %>
<%@ page import="java.util.*" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: lanqiao
  Date: 2017/5/24
  Time: 上午11:59
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员页面</title>
</head>
<body>
您好管理员！
<table>
    <tr>
        <td>名称</td>
        <td>状态</td>
        <td>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        </td>
        <td>
            <c:out value="${requestScope.backt}"></c:out><br>
            <form name="add" method="post" action="../stu/AddServlet">
                姓名：<input type="text" name="stu_name">
                密码：<input type="text" name="stu_pwd">
                状态：<input type="text" name="stu_status">
                     <input type="submit" value="添加"><br>
            </form>
        </td>

        <td>
            <c:out value="${requestScope.backt}"></c:out><br>
            <form name="alter" method="post" action="../stu/UpdateServlet">
                姓名：<input type="text" name="stu_name">
                密码：<input type="text" name="stu_pwd">
                状态：<input type="text" name="stu_status">
                     <input type="submit" value="修改"><br>
            </form>
        </td>

    </tr>
    <c:forEach items="${requestScope.AAA}" var="stu">
    <tr>
        <td>${stu.stu_name}</td>
        <td>${stu.stu_status}</td>
        <td></td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
