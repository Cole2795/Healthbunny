<%-- 
    Document   : internationalisationHeader
    Created on : 03-Dec-2017, 22:17:10
    Author     : Ayesha/nicole
--%>
<%@page import="java.util.Locale"%>
<%@page import="java.util.ResourceBundle"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    // Retrieve the appropriate Locale - check if it's already been set within the site
    Locale clientLocale = (Locale) session.getAttribute("currentLocale");

    // If there was no locale already set -- it's their first time here or their session timed out
    if (clientLocale == null) {
        // Get the locale for the client's browser (that is what's stored in the request)
        clientLocale = request.getLocale();
        // Save it as the currently selected locale
        session.setAttribute("currentLocale", clientLocale);
    }
%>
 <%
            // Retrieve the resource bundle from the session
            ResourceBundle dataBundle = (ResourceBundle) session.getAttribute("dataBundle");
            // If there is no bundle stored (i.e. if this is the first time you're coming to the site)
            if(dataBundle == null){
                // Create a resource bundle based on the client's current locale settings
                dataBundle = ResourceBundle.getBundle("ClassicModels", clientLocale);

                // Store this resource bundle for future use
                session.setAttribute("dataBundle", dataBundle);
            }
            
        %>



