<%@ page import="components.table.DataTable" %>
<%@ page import="lombok.Getter" %>
<%@ page import="annotations.forms.Form" %>
<%@ page import="java.util.List" %>
<%@ page import="annotations.forms.Input" %>
<%@ page import="annotations.forms.Checkbox" %>
<%@ page import="util.FormUtils" %>
<%@ page import="spring.ModelForm" %>
<%@ page import="components.forms.HtmlForm" %>
<%@ page import="components.forms.ValueLabel" %>
<%@ page import="org.project.boulangerie.model.CategorieProduit" %>
<%@ page import="annotations.forms.Select" %>
<%
    DataTable dataTable = new DataTable<>(request);
    dataTable.setDeletable(false);
    List<ValueLabel> ingredientsVL = ((List<ValueLabel>) request.getAttribute("ingredientsVL"));
    List<ValueLabel> categoriesVL = ((List<ValueLabel>) request.getAttribute("categoriesVL"));
%>

<%
    @Getter
    @Form(title = "Filtre Produit Fini")
    class ProduitFiniFilter {
        @Input(name = "produit.nom_like", type = "text")
        String nom;

        @Input(name = "produit.prixVente_gte", type = "number", step = "0.01")
        Double prixVenteMin;

        @Input(name = "produit.prixVente_lte", type = "number", step = "0.01")
        Double prixVenteMax;

        @Select(name = "categorie_eq")
        Integer categorie;

        @Checkbox(name = "recettes.ingredient.id_seq", type = Integer.class)
        List<Integer> ingredients;
    }

    ProduitFiniFilter filter = new ProduitFiniFilter();
    FormUtils.fillFormFromRequest(filter, request);
    HtmlForm form = new HtmlForm(filter);
    form.addData("categorie", categoriesVL, true);
    form.addData("ingredients", ingredientsVL);
%>

<div>
    <%=form.getHtml()%>
</div>

<div class="d-flex justify-content-center ">
    <%=dataTable.getHtml()%>
</div>