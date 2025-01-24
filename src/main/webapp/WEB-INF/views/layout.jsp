<%@ page import="org.hibernate.Session" %>
<%@ page import="components.misc.swal.SweetAlert" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    String pg = ((String) request.getAttribute("content")) + ".jsp";
    String msg = ((String) request.getAttribute("msg"));

%>


<!doctype html>
<html lang="fr" class="light-style layout-navbar-fixed layout-menu-fixed layout-compact " dir="ltr" data-theme="theme-default" data-assets-path="${pageContext.request.contextPath}/assets/" data-template="vertical-menu-template" data-style="light">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0"/>
    <link rel="icon" href="${pageContext.request.contextPath}/assets/img/favicon/favicon.ico">
    <title>Boulangerie</title>

    <%--    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/vendor/fonts/boxicons.css"/>--%>
    <link href="${pageContext.request.contextPath}/assets/vendor/fonts/boxicons.css" rel="stylesheet">
    <%--    <link href="${pageContext.request.contextPath}/assets/vendor/fonts/boxicons.min.css" rel="stylesheet">--%>


    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/vendor/fonts/fontawesome.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/vendor/fonts/flag-icons.css"/>


    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/vendor/css/rtl/core.css" class="template-customizer-core-css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/vendor/css/rtl/theme-default.css" class="template-customizer-theme-css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/demo.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css"/>
rr
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/vendor/libs/perfect-scrollbar/perfect-scrollbar.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/vendor/libs/typeahead-js/typeahead.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/vendor/libs/bootstrap-maxlength/bootstrap-maxlength.css"/>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/vendor/libs/datatables-bs5/datatables.bootstrap5.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/vendor/libs/datatables-responsive-bs5/responsive.bootstrap5.css">

    <script>

    </script>
    <script src="${pageContext.request.contextPath}/assets/vendor/js/helpers.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/config.js"></script>
    <script src="${pageContext.request.contextPath}/assets/vendor/libs/chartjs/chartjs.js"></script>
    <script src="${pageContext.request.contextPath}/assets/vendor/libs/jquery/jquery.js"></script>

    <style>
        #layout-navbar, #layout-menu {
            transition: 0.3s ease-in-out;
        }

    </style>
</head>

<body>
<div class="layout-wrapper layout-navbar-full layout-horizontal layout-without-menu">
    <div class="layout-container">

        <div class="layout-page" style="padding-top: 0px!important; margin-top: 62px">
            <div class="content-wrapper">
                <%--                <div id="navbar-container">--%>
                <nav class="layout-navbar navbar navbar-expand-xl align-items-center bg-navbar-theme white" id="layout-navbar" style="z-index: 10">
                    <div class="container-xxl">


                        <div class="navbar-brand app-brand demo d-none d-xl-flex py-0 me-4">
                            <a href="/" class="app-brand-link gap-2">

                            <span class="app-brand-logo demo">


                            </span>
                                <span class="app-brand-text demo menu-text fw-bold text-heading text-uppercase">Boulangerie</span>
                            </a>


                            <a href="javascript:void(0);" class="layout-menu-toggle menu-link text-large ms-auto d-xl-none">
                                <i class="bx bx-chevron-left bx-sm d-flex align-items-center justify-content-center"></i>
                            </a>

                        </div>


                        <div class="layout-menu-toggle navbar-nav align-items-xl-center me-4 me-xl-0  d-xl-none  ">
                            <a class="nav-item nav-link px-0 me-xl-6" href="javascript:void(0)">
                                <i class="bx bx-menu bx-md"></i>
                            </a>
                        </div>


                        <div class="navbar-nav-right d-flex align-items-center" id="navbar-collapse">


                            <ul class="navbar-nav flex-row align-items-center ms-auto">


                                <!-- User -->
                                <li class="nav-item navbar-dropdown dropdown-user dropdown">
                                    <a class="nav-link dropdown-toggle hide-arrow p-0" href="javascript:void(0);" data-bs-toggle="dropdown">
                                        ADMIN
<%--                                        <div class="avatar avatar-online">--%>
<%--                                            <img src="${pageContext.request.contextPath}/assets/img/avatars/8.jpg" alt="" class="w-px-40 h-auto rounded-circle">--%>
<%--                                        </div>--%>
                                    </a>
                                    <ul class="dropdown-menu dropdown-menu-end">
<%--                                        <li>--%>
<%--                                            <a class="dropdown-item" href="pages-account-settings-account.html">--%>
<%--                                                <div class="d-flex">--%>
<%--                                                    <div class="flex-shrink-0 me-3">--%>
<%--                                                        <div class="avatar avatar-online">--%>
<%--                                                            <img src="${pageContext.request.contextPath}/assets/img/avatars/8.jpg" alt="" class="w-px-40 h-auto rounded-circle">--%>
<%--                                                        </div>--%>
<%--                                                    </div>--%>
<%--                                                    <div class="flex-grow-1">--%>
<%--                                                        <h6 class="mb-0">Nathanalex</h6>--%>
<%--                                                        <small class="text-muted">ETU002498</small>--%>
<%--                                                    </div>--%>
<%--                                                </div>--%>
<%--                                            </a>--%>
<%--                                        </li>--%>
<%--                                        <li>--%>
<%--                                            <div class="dropdown-divider my-1"></div>--%>
<%--                                        </li>--%>

                                        <li>
                                            <a class="dropdown-item" href="auth-login-cover.html" target="_blank">
                                                <i class="bx bx-power-off bx-md me-3"></i><span>Se Deconnecter</span>
                                            </a>
                                        </li>
                                    </ul>
                                </li>


                            </ul>
                        </div>


                    </div>
                </nav>
                <jsp:include page="sidebar.jsp"/>


                <div class="flex-grow-1 container-p-y container-fluid">
                    <%--                        <button onclick="history.back()">Retour</button>--%>
                    <jsp:include page="<%=pg%>"/>
                </div>
            </div>
        </div>
    </div>
</div>
</body>


<script src="${pageContext.request.contextPath}/assets/js/sweetalert2.js"></script>
<script src="${pageContext.request.contextPath}/assets/vendor/libs/popper/popper.js"></script>
<script src="${pageContext.request.contextPath}/assets/vendor/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/assets/vendor/libs/perfect-scrollbar/perfect-scrollbar.js"></script>
<script src="${pageContext.request.contextPath}/assets/vendor/libs/hammer/hammer.js"></script>
<script src="${pageContext.request.contextPath}/assets/vendor/libs/i18n/i18n.js"></script>
<script src="${pageContext.request.contextPath}/assets/vendor/libs/typeahead-js/typeahead.js"></script>
<script src="${pageContext.request.contextPath}/assets/vendor/js/menu.js"></script>

<!-- endbuild -->

<!-- Vendors JS -->
<script src="${pageContext.request.contextPath}/assets/vendor/libs/autosize/autosize.js"></script>
<script src="${pageContext.request.contextPath}/assets/vendor/libs/cleavejs/cleave.js"></script>
<script src="${pageContext.request.contextPath}/assets/vendor/libs/cleavejs/cleave-phone.js"></script>
<script src="${pageContext.request.contextPath}/assets/vendor/libs/bootstrap-maxlength/bootstrap-maxlength.js"></script>
<script src="${pageContext.request.contextPath}/assets/vendor/libs/jquery-repeater/jquery-repeater.js"></script>


<!-- Main JS -->
<script src="${pageContext.request.contextPath}/assets/js/main.js"></script>


<!-- Page JS -->
<script src="${pageContext.request.contextPath}/assets/js/forms-extras.js"></script>

<%

    Object sessionErrorObj = session.getAttribute("eswal");
    if (sessionErrorObj != null) {
        SweetAlert swal = new SweetAlert();
        swal.setIcon(SweetAlert.Icon.ERROR);
        swal.setTitle("Erreur");
        swal.setMessage(String.valueOf(sessionErrorObj));
        out.print(swal.fire());
        session.removeAttribute("eswal");
    }

    Object sessionSuccessObj = session.getAttribute("sswal");
    if (sessionSuccessObj != null) {
        SweetAlert swal = new SweetAlert();
        swal.setIcon(SweetAlert.Icon.SUCCESS);
        swal.setTitle("Success");
        swal.setMessage(String.valueOf(sessionSuccessObj));
        out.print(swal.fire());
        session.removeAttribute("sswal");
    }

    Object sessionInfoObj = session.getAttribute("swal");
    if (sessionInfoObj != null) {
        SweetAlert swal = new SweetAlert();
        swal.setIcon(SweetAlert.Icon.INFO);
        swal.setTitle("Info");
        swal.setMessage(String.valueOf(sessionInfoObj));
        out.print(swal.fire());
        session.removeAttribute("swal");
    }
%>

<script>
    document.addEventListener("DOMContentLoaded", () => {
        const navbar = document.getElementById("layout-navbar");
        const menu = document.getElementById("layout-menu");

        document.addEventListener("scroll", () => {
            if (window.scrollY > 100) {
                console.log(document.getElementById("layout-navbar").height);

                navbar.style.transform = 'translateY(-63px)';
                menu.style.transform = 'translateY(-63px)';


            } else {
                navbar.style.transform = 'translateY(0px)';
                menu.style.transform = 'translateY(0px)';
            }
        });
    });

    function createTableFromObject(data) {
        if (!data || data.length === 0) {
            return document.createTextNode("...");
        }

        const headers = Object.keys(data[0]);
        console.log(data);
        console.log(headers);

        // Create table and set its styles
        const table = document.createElement("table");
        table.className = "table bordered";
        // table.style.border = "1px solid black";
        // table.style.borderCollapse = "collapse";
        // table.style.width = "100%";
        // table.style.textAlign = "left";

        // Create thead
        const thead = document.createElement("thead");
        const headerRow = document.createElement("tr");
        headers.forEach(header => {
            const th = document.createElement("th");
            th.textContent = header;
            // th.style.border = "1px solid black";
            headerRow.appendChild(th);
        });
        thead.appendChild(headerRow);
        table.appendChild(thead);

        // Create tbody
        const tbody = document.createElement("tbody");
        data.forEach(item => {
            console.log(item);
            const row = document.createElement("tr");
            headers.forEach(header => {
                const td = document.createElement("td");
                let value = item[header];
                td.textContent = value;
                // td.style.border = "1px solid black";
                row.appendChild(td);
            });
            tbody.appendChild(row);
        });
        table.appendChild(tbody);

        return table;
    }

</script>
</html>
