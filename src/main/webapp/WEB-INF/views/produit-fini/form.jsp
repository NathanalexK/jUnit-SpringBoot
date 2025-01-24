<%@ page import="components.forms.HtmlForm" %>
<%@ page import="spring.ModelForm" %>
<%
    ModelForm form = new ModelForm(request);
%>

<%=form.getHtml()%>