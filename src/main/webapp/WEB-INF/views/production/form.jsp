<%@ page import="components.forms.HtmlForm" %>
<%@ page import="spring.ModelForm" %>
<%
    ModelForm form = new ModelForm(request);
%>

<%=form.getHtml()%>

<div class="d-flex justify-content-center">
    <h4>Recettes</h4>
</div>

<div class="d-flex justify-content-center">
    <div class="card w-50">
<%--        <div class="card-header">--%>
<%--            <h5>Recettes</h5>--%>
<%--        </div>--%>
<%--    </div>--%>

    <div class="card-content" id="recette-table">
    </div>
    </div>
</div>

<script>
    $(document).ready(function () {
        const recetteTable = $(document).find('#recette-table');
        const produitFiniSelect = $(document).find('.produitFini-form');

        function updateRecette() {
            recetteTable.html("");
            $.ajax({
                url: 'http://localhost:8083/api/recettes/' + produitFiniSelect.find(':selected').val(),
                method: 'GET',
                dataType: 'json',
                success: function (response) {
                    console.log(response);
                    recetteTable.html(createTableFromObject(response))
                },
                error: function (err) {
                    console.error(err);
                }
            })
        }

        $('.nx-form').on('change', '.produitFini-form', function () {
            updateRecette();
        })

    });
</script>
