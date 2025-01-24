<%@ page import="components.table.DataTable" %>
<%@ page import="annotations.forms.Input" %>
<%@ page import="annotations.forms.Select" %>
<%@ page import="annotations.forms.Checkbox" %>
<%@ page import="java.util.List" %>
<%@ page import="util.FormUtils" %>
<%@ page import="components.forms.HtmlForm" %>
<%@ page import="components.forms.ValueLabel" %>
<%@ page import="annotations.forms.Form" %>
<%@ page import="lombok.Getter" %>
<%@ page import="java.time.LocalDate" %><%
    DataTable dataTable = new DataTable<>(request);
    dataTable.setDeletable(false);
    dataTable.setEditable(false);
    dataTable.setViewable(false);

    List<ValueLabel> ingredientsVL = ((List<ValueLabel>) request.getAttribute("ingredientsVL"));
    List<ValueLabel> pfVL = ((List<ValueLabel>) request.getAttribute("produitsFiniVL"));

    @Getter
    @Form(title = "Filtre Production")
    class ProductionFilter {
        @Select(name = "produitFini.id_eq")
        Integer produitFini;

        @Input(name = "dateProduction_gte", type = "date", step = "0.01")
        LocalDate dateMin;

        @Input(name = "dateProduction_lte", type = "date", step = "0.01")
        LocalDate dateMax;

        @Checkbox(name = "produitFini.recettes.ingredient.id_seq", type = Integer.class)
        List<Integer> ingredients;
    }

    ProductionFilter filter = new ProductionFilter();
    FormUtils.fillFormFromRequest(filter, request);
    HtmlForm form = new HtmlForm(filter);
    form.addData("produitFini", pfVL, true);
    form.addData("ingredients", ingredientsVL);
%>
<div>
    <%=form.getHtml()%>
</div>

<div class="d-flex justify-content-center">
    <%=dataTable.getHtml()%>
</div>