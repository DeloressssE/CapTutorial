<%@ page import="com.project.Model.User"%>
<%@ page contentType="text/html;charset=UTF-8"  %>
<% User auth = (User) request.getSession().getAttribute("auth");
    if(auth!=null){
        response.sendRedirect("index.jsp");
    }
%>
<!doctype html>
<html>
  <head>
    <title>Cart</title>
    <%@include file = "includes/header.jsp"%>
   </head>
  <body>
     <%@include file = "includes/navbar.jsp"%>
    <%@include file = "includes/footer.jsp"%>
   </body>
</html>