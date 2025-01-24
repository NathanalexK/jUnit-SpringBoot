<%@ page import="components.table.DataTable" %>
<%@ page import="annotations.forms.Input" %>
<%@ page import="annotations.forms.Select" %>
<%@ page import="util.FormUtils" %>
<%@ page import="java.util.List" %>
<%@ page import="org.project.boulangerie.model.Parfum" %>
<%@ page import="components.forms.ValueLabel" %>
<%@ page import="components.forms.HtmlForm" %>
<%@ page import="annotations.forms.Form" %>
<%@ page import="java.util.Locale" %>
<%@ page import="java.time.LocalDate" %><%
    DataTable dataTable = new DataTable<>(request);
    dataTable.setViewable(false);
    dataTable.setEditable(false);
    dataTable.setDeletable(false);

    List<ValueLabel> parfums = ((List<ValueLabel>) request.getAttribute("parfums"));
    List<ValueLabel> categories = ((List<ValueLabel>) request.getAttribute("categories"));


    @Form(title = "Filtre Vente")
    class VenteFilter {
        @Select(name = "produitFini.categorie.id_eq")
        private Integer categorie;

        @Select(name = "produitFini.parfum.id_eq")
        private Integer parfum;

        @Input(type = "date", name = "vente.dateHeure_eq")
        private LocalDate date;

    }

    VenteFilter venteFilter = new VenteFilter();
    FormUtils.fillFormFromRequest(venteFilter, request);
    HtmlForm form = new HtmlForm(venteFilter);
    form.addData("categorie", categories, true);
    form.addData("parfum", parfums, true);


%>

<div>
    <%=form.getHtml()%>
</div>

<div class="d-flex justify-content-center">
    <%=dataTable.getHtml()%>
</div>