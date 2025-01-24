<%@ page import="java.util.List" %>
<%@ page import="org.project.boulangerie.dto.CommissionVendeurDTO" %>
<%@ page import="components.table.ModelTable" %>
<%@ page import="components.table.HtmlTable" %>
<%@ page import="annotations.forms.Form" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="annotations.forms.Input" %>
<%@ page import="util.FormUtils" %>
<%@ page import="components.forms.HtmlForm" %><%
    List<CommissionVendeurDTO> model = ((List<CommissionVendeurDTO>) request.getAttribute("model"));

    HtmlTable<CommissionVendeurDTO> table = new HtmlTable<>();
    table.setData(model);
    table.addColumn("ID", c -> c.getId());
    table.addColumn("Nom Vendeur", c -> c.getNom());
    table.addColumn("Genre", c -> c.getGenre());
    table.addColumn("Total Commission", c -> c.getTotal());


    @Form(title = "Filtre par date")
    class CommissionFilter {
        @Input(type = "date", name = "debut_eq")
        public LocalDate debut;

        @Input(type = "date", name = "fin_eq")
        public LocalDate fin;
    }

    CommissionFilter filter = new CommissionFilter();
    FormUtils.fillFormFromRequest(filter, request);
    HtmlForm form = new HtmlForm(filter);
    form.setAction("/vente/commissions");
%>

<%--<h1>Commission</h1>--%>
<div>
    <%=form.getHtml()%>
</div>
<div class="card">
    <%=table.getHtml()%>
</div>

