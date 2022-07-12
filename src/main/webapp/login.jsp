<%@ page import="com.project.Model.User"%>
<%@page import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8"  %>
<% User auth = (User) request.getSession().getAttribute("auth");
if(auth!=null){
response.sendRedirect("index.jsp");
}
%>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <%@include file="includes/header.jsp" %>
</head>
<body>
<%@include file="includes/navbar.jsp" %>
<div class="container">
    <div class="card w-50 mx-auto my-5">
        <div class="card-header text-center">User Login</div>
        <div class="card-body">
            <form action="user-login" method="post">
                <div class="form-group">
                    <label>Email address</label>
                    <label>
                        <input type="email" class="form-control" name="login-email" placeholder="Enter email">
                    </label>
                </div>
                <div class="form-group">
                    <label>Password</label>
                    <label>
                        <input type="password" name="login-password" class="form-control" placeholder="Password">
                    </label>
                </div>
                <div class="text-center">
                    <button type="submit" class="btn btn-primary">Login</button>
                </div>
            </form>
        </div>
    </div>
</div>

<%@include file="includes/footer.jsp"%>
</body>
</html>
