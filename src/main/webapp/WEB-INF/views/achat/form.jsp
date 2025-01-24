<%@ page import="spring.ModelForm" %>
<%
    ModelForm form = new ModelForm(request);
%>

<%=form.getHtml()%>
<div class="d-flex justify-content-center">
    <div class="card" style="width: 90%">
        <div class="card-header">
            Tableau Recapitulatif
        </div>

        <div class="card-content">
            <table class="table bg-white">
                <tr>
                    <td><b>Montant Total</b></td>
                    <td id="montant-total">0.00</td>
                </tr>
            </table>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>

<script>
    $(document).ready(() => {
        // const a = $(document).find('.d-flex')[0];
        // console.log(a)

        function changeUnitPrice(row) {
            const ingredientSelect = row.find('.ingredient-form');
            console.log(ingredientSelect);
            const qteInput = row.find('.quantite-form');
            console.log(qteInput.val());
            const puInput = row.find('.prixUnitaire-form');
            const totalInput = row.find('.prixTotal-form');

            const prix = parseFloat(ingredientSelect.find(':selected').data('prix')) || 0;
            console.log(prix)
            const qte = parseFloat(qteInput.val()) || 0;

            const total = (prix * qte).toFixed(2);

            puInput.val(prix.toFixed(2));
            totalInput.val(total);
            console.log(total);
        }

        function updatePrixTotal() {
            let sum = 0;
            const montantTotalText = $(document).find('#montant-total');
            $(document).find('.prixTotal-form').each(function () {
                sum += parseFloat($(this).val());
            });
            montantTotalText.html(sum.toFixed(2));
        }

        $('.nx-form').on('change', '.ingredient-form, .quantite-form', function () {
            const row = $(this).closest('.form-repeat-item');
            changeUnitPrice(row)
            updatePrixTotal();
        });


    })
</script>