<%@ page import="com.project.Connection.*"%>
<%@ page import="com.project.Model.User"%>
<%@ page contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<<% User auth = (User) request.getSession().getAttribute("auth");
    if(auth!=null){
        response.sendRedirect("index.jsp");
    }
%>
    <!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Welcome Page</title>
    <%@include file = "includes/header.jsp"%>
    </head>
    <body>
    <%@include file = "includes/navbar.jsp"%>
    <%@include file = "includes/footer.jsp"%>
   </body>
</html>
