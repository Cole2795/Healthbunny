

<!-- create a form to change the language based on changing the drop down selection -->
<div class="onside">
<form action="FrontController" method="post">
    <!-- When the value of the drop down changes, 
    submit the form and send the value to the controller -->
    <select name ="language" onchange="this.form.submit()">
        <%
            String language = (String) session.getAttribute("language");
            if (language == null || language.equals("en")) {


        %>
        <option value="en" selected>English</option>
        <option value="fr">Irish</option>
        
        <% } else
         if (language.equals("fr")) {
        %>
        <option value="en">English</option>
        <option value="fr" selected>Irish</option>
        

        <%
            }
%>
       





    </select>
    <input type="hidden" name="action" value="changeLanguage"/>
</div>
</form>