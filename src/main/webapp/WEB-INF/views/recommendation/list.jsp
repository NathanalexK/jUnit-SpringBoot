<%@ page import="components.table.DataTable" %>
<%@ page import="annotations.forms.Form" %>
<%@ page import="annotations.forms.Select" %>
<%@ page import="annotations.forms.Input" %>
<%@ page import="util.FormUtils" %>
<%@ page import="spring.ModelForm" %>
<%@ page import="components.forms.HtmlForm" %>
<%@ page import="java.util.List" %>
<%@ page import="components.forms.ValueLabel" %><%
    DataTable dataTable = new DataTable<>(request);
    dataTable.setDeletable(false);
    dataTable.setViewable(false);
    dataTable.setEditable(false);

    List<ValueLabel> valueLabels = ((List<ValueLabel>) request.getAttribute("moisVL"));

    @Form(title = "Recherche Recommendation")
    class RecommendationFilter {
        @Select(name = "mois_eq")
        private Integer mois;

        @Input(name = "annee_eq", type = "number")
        private Integer annee;
    }

    RecommendationFilter filter = new RecommendationFilter();
    FormUtils.fillFormFromRequest(filter, request);
    HtmlForm form = new HtmlForm(filter);
    form.addData("mois", valueLabels, true);

//    dataTable.sho
%>

<%--<div class="d-flex justify-content-center">--%>
    <%=form.getHtml()%>
<%--</div>--%>

<div class="d-flex justify-content-center">
    <%=dataTable.getHtml()%>
</div>