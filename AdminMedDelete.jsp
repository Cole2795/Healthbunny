<%-- 
    Document   : AdminPillDelete
    Created on : 14-Apr-2018, 16:52:57
    Author     : campb
--%>

<%@page import="DAO.MedicineDao"%>
<%@page import="Business.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
      
    </head>
    <body>
        <% User u = (User) session.getAttribute("admin");
            if (u != null) {

                int id = Integer.parseInt(request.getParameter("id"));
                if (id > 0) {
                    MedicineDao meddao = new MedicineDao("healthybunny");
                    int result = meddao.RemoveMedicine(id);
                    if (result == 1) {

        %>

        <h1>Succesful</h1>
        <a href="AdminDrugDetail.jsp" class="previous">&laquo;Back to medicine</a>

        <%
        } else {
        %>
        <h1>Delete Failed</h1>
        <a href="AdminDrugDetail.jsp" class="previous">&laquo; Back to Medicine</a>

        <%
                }
            } else {
                out.println("error.jsp");

            }

        %>




        <%} else {
            out.println("no admin found");
        %>

        <a href="Login.jsp"/>Back to Login</a>
        <%
            }
        %>
</body>


</html>
