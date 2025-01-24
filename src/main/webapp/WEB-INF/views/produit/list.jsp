<%@ page import="components.table.DataTable" %>
<%@ page import="annotations.forms.Form" %>
<%@ page import="annotations.forms.Input" %>
<%@ page import="util.FormUtils" %>
<%@ page import="components.forms.HtmlForm" %>
<%@ page import="annotations.forms.Select" %>
<%@ page import="java.util.List" %>
<%@ page import="components.forms.ValueLabel" %><%
    DataTable dataTable = new DataTable<>(request);
    dataTable.setDeletable(false);
    dataTable.setEditable(false);
    dataTable.setViewable(false);

    List<ValueLabel> uniteVL = ((List<ValueLabel>) request.getAttribute("uniteVL"));

    @Form(title = "Filtre Stock")
    class ProduitFilter {
        @Input(name = "nom_like", type = "text")
        public String nom;

        @Input(name = "stock.quantite_gte", type = "number", step = "0.01")
        public Double stockMin;

        @Input(name = "stock.quantite_lte", type = "number", step = "0.01")
        public Double stockMax;

        @Select(name = "unite.id_eq")
        public Integer unite;
    }

    ProduitFilter filter = new ProduitFilter();
    FormUtils.fillFormFromRequest(filter, request);
    HtmlForm form = new HtmlForm(filter);
    form.addData("unite", uniteVL, true);
%>

<%--<div class="d-flex justify-content-center">--%>
    <%=form.getHtml()%>
<%--</div>--%>

<div class="d-flex justify-content-center">
    <%=dataTable.getHtml()%>
</div>