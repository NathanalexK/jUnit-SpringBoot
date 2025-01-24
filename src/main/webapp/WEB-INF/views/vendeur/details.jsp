<%@ page import="java.lang.reflect.Field" %>
<%@ page import="java.lang.reflect.Method" %>
<%@ page import="util.StringUtils" %>
<%
    Object model = request.getAttribute("model");
    String id = String.valueOf(model.getClass().getDeclaredMethod("getId").invoke(model));
%>

<div class="d-flex justify-content-center">
    <div class="card w-50">
        <div class="card-header">
            <h5>Details</h5>
        </div>

        <div class="card-body">
<%--            <br>--%>
            <table class="table table-bordered my-2">
                <tbody>
                    <% for(Field field: model.getClass().getDeclaredFields()) {
                        Method method = model.getClass().getDeclaredMethod("get" + StringUtils.capitalize(field.getName()));
                        Object value = method.invoke(model);
                    %>
                        <tr>
                            <td><b><%=field.getName()%></b></td>
                            <td><%=String.valueOf(value)%></td>
                        </tr>
                    <% } %>
                </tbody>
            </table>

        </div>

        <div class="card-footer d-flex justify-content-end gap-3">
            <button class="btn btn-danger" onclick="history.back()">Retour</button>
            <a href="form?id=<%=id%>"><button class="btn btn-warning">Modifier</button></a>

        </div>
    </div>
</div>