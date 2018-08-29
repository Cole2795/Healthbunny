<%-- 
    Document   : AdminPillDelete
    Created on : 14-Apr-2018, 16:52:57
    Author     : campb
--%>

<%@page import="DAO.PilDao"%>
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
        if(u !=null){
            
            int id = Integer.parseInt(request.getParameter("id"));
            if(id > 0){
                      PilDao pilldao = new PilDao("healthybunny");
                       int result = pilldao.RemovePill(id);
                       if(result == 1){
                           
                           %>
                           
                            <h1>Delete Successful</h1>
                             <a href="AdminPillDetail.jsp" class="previous">&laquo; Back to pill</a>
        
                           <%
                       }else{
                            %>
                            <h1>Delete Failed</h1>
                              <a href="AdminPillDetail.jsp" class="previous">&laquo; back to Pill></a>
        
                            <%
}
            }else{
            out.println("error.jsp");
                
}
          
        %>
       
       
        
        
        <%
            }else{
out.println("no admin found");
}
%>
    </body>
    
</html>
