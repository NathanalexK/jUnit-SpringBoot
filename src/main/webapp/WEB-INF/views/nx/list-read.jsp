<%@ page import="components.table.DataTable" %>
<%

    DataTable dataTable = new DataTable<>(request);
    dataTable.setDeletable(false);
    dataTable.setEditable(false);
%>

<div class="d-flex justify-content-center">
    <%=dataTable.getHtml()%>
</div>