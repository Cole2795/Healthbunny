<%-- 
    Document   : AdminPillDelete
    Created on : 14-Apr-2018, 16:52:57
    Author     : campb
--%>

<%@page import="DAO.PossibleconditionDetailDao"%>
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

                String title = request.getParameter("title");
            if(title != null){
                      PossibleconditionDetailDao condao = new PossibleconditionDetailDao("healthybunny");
                       int result = condao.RemoveCondtion(title);
                       if(result == 1){

        %>

        <h1>Succesful</h1>
        <a href="AdminConditionsDetail.jsp" class="previous">&laquo;Back to Condition</a>

        <%
        } else {
        %>
        <h1>Delete Failed</h1>
        <a href="AdminConditionsDetail.jsp" class="previous">&laquo; Back to Condition</a>

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
