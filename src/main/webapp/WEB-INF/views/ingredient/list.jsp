<%@ page import="components.table.DataTable" %><%
    DataTable dataTable = new DataTable<>(request);
    dataTable.setViewable(false);
    dataTable.setDeletable(false);
//    dataTable.sho
%>

<div class="d-flex justify-content-center">
    <%=dataTable.getHtml()%>
</div>