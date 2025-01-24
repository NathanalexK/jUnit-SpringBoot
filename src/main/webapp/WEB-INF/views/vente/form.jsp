<%@ page import="spring.ModelForm" %><%
    ModelForm form = new ModelForm(request);
%>

<%=form.getHtml()%>