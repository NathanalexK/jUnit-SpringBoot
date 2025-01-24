<%@ page import="java.util.List" %>
<%@ page import="org.project.boulangerie.model.Vente" %>
<%@ page import="components.table.ModelTable" %>
<%@ page import="components.table.HtmlTable" %>
<%@ page import="org.project.boulangerie.model.VenteDetail" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="annotations.forms.Input" %>
<%@ page import="components.forms.HtmlForm" %>
<%@ page import="annotations.forms.Form" %>
<%@ page import="util.FormUtils" %><%
    List<Vente> ventes = ((List<Vente>) request.getAttribute("model"));
    HtmlTable<Vente> table = new HtmlTable<>();
    table.setData(ventes);http://localhost:8083/vente/clients
    table.addColumn("ID", Vente::getId);
    table.addColumn("Client", v -> v.getClient() != null ? v.getClient().getNom() : "Client Divers");
    table.addColumn("Date", v -> v.getDateHeure());
    table.addColumn("Montant Total", v -> {
        double sum = 0.0;
        for(VenteDetail vd: v.getVenteDetailList()) {
            sum += vd.getQuantite() * vd.getDPrixUnitaire();
        }
        return sum;

    });

    @Form(title = "Filtre Client")
    class ClientFilter {

        @Input(name = "date", type = "date")
        public LocalDate date;
    }

    ClientFilter clientFilter = new ClientFilter();
    FormUtils.fillFormFromRequest(clientFilter, request);
    HtmlForm form = new HtmlForm(clientFilter);
%>

<div>
    <%=form.getHtml()%>
</div>


<div class="card">
    <%=table.getHtml()%>

</div>