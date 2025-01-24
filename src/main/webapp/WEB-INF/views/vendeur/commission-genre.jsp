<%@ page import="java.util.List" %>
<%@ page import="org.project.boulangerie.dto.CommissionVendeurDTO" %>
<%@ page import="components.table.ModelTable" %>
<%@ page import="components.table.HtmlTable" %>
<%@ page import="annotations.forms.Form" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="annotations.forms.Input" %>
<%@ page import="util.FormUtils" %>
<%@ page import="components.forms.HtmlForm" %>
<%@ page import="org.project.boulangerie.dto.CommissionGenreDTO" %><%
    List<CommissionGenreDTO> model = ((List<CommissionGenreDTO>) request.getAttribute("model"));

    HtmlTable<CommissionGenreDTO> table = new HtmlTable<>();
    table.setData(model);
    table.addColumn("NOM", c -> c.getNom());
//    table.addColumn("Nom Vendeur", c -> c.getNom());
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
    form.setAction("/vendeur/commissions/genre");
%>

<%--<h1>Commission</h1>--%>
<div>
    <%=form.getHtml()%>
</div>
<div class="card">
    <%=table.getHtml()%>
</div>

