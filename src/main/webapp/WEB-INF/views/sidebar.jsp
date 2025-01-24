<%--<%@ page import="org.project.imeuble.mock.SidebarMock" %>--%>
<%@ page import="components.menu.Sidebar" %>
<%@ page import="components.menu.Menu" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    Sidebar sidebar = new Sidebar()
            .addMenu(
                    new Menu("Produits")
                            .withIcon("bx bx-briefcase-alt-2")
                            .addSubmenu(
                                    new Menu("Ingredients")
                                            .withIcon("bx bxs-flask")
                                            .addSubmenu(
                                                new Menu("Saisie Ingredient")
                                                        .withLien("/ingredient/form")
                                            )
                                            .addSubmenu(
                                                new Menu("Lister Ingredients")
                                                        .withLien("/ingredient/list")
                                            )
                            )
                            .addSubmenu(
                                    new Menu("Produits Finis")
                                            .withIcon("bx bx-dish")
                                            .addSubmenu(
                                                    new Menu("Saisie Produit Fini")
                                                            .withLien("/produit-fini/form")
//                                                        .withIcon("bx bx-plus")
                                            )
                                            .addSubmenu(
                                                new Menu("Lister Produit Fini")
                                                        .withLien("/produit-fini/list")
                                            )


                            )
                            .addSubmenu(
                                    new Menu("Recommendation Produit")
                                            .withIcon("bx bx-bulb")
                                            .addSubmenu(
                                                    new Menu("Saisie recommendation")
                                                            .withIcon("bx bx-plus")
                                                            .withLien("/recommendation/form")
                                            )
                                            .addSubmenu(
                                                    new Menu("Lister recommendation")
                                                            .withIcon("bx bx-list-ol")
                                                            .withLien("/recommendation/list")
                                            )
                            )
//                            .addSubmenu(
//                                new Menu("Lister Produits")
//                                        .withIcon("bx bx-list-ol")
//                                        .withLien("/produit/list")
//                            )
            )
            .addMenu(
                new Menu("Achats")
                        .withIcon("bx bx-cart-alt")
                        .addSubmenu(
                            new Menu("Sasie achat")
                                    .withIcon("bx bx-plus")
                                    .withLien("/achat/form")
                        )
                        .addSubmenu(
                            new Menu("Lister achat")
                                    .withIcon("bx bx-list-ol")
                                    .withLien("/achat/list")
                        )
            )
            .addMenu(
                new Menu("Vente")
                        .withIcon("bx bx-box")
                        .addSubmenu(
                            new Menu("Saisie vente")
                                    .withIcon("bx bx-plus")
                                    .withLien("/vente/form")
                        )
                        .addSubmenu(
                            new Menu("Lister vente")
                                    .withIcon("bx bx-list-ol")
                                    .withLien("/vente/list")
                        )
                        .addSubmenu(
                                new Menu("Lister vente client")
                                        .withIcon("bx bx-group")
                                        .withLien("/vente/client")
                        )
                        .addSubmenu(
                                new Menu("Commissions")
                                        .withIcon("bx bx-coin-stack")
                                        .addSubmenu(
                                                new Menu("Commission Par Client")
                                                        .withLien("/vendeur/commissions")
                                        )
                                        .addSubmenu(
                                                new Menu("Commission Par Genre")
                                                        .withLien("/vendeur/commissions/genre")
                                        )
                        )

            )
            .addMenu(
                new Menu("Production")
                        .withIcon("bx bx-dish")
                        .addSubmenu(
                            new Menu("Saisie production")
                                    .withIcon("bx bx-plus")
                                    .withLien("/production/form")
                        )
                        .addSubmenu(
                                new Menu("Lister production")
                                        .withIcon("bx bx-list-ol")
                                        .withLien("/production/list")
                        )
            )
            .addMenu(
                new Menu("Stock")
                        .withIcon("bx bx-cube")
                        .withSubmenus(
                            new Menu("Afficher liste Stock")
                                    .withIcon("bx bx-list-ol")
                                    .withLien("/produit/list")
                        )
            )
            .addMenu(
                    new Menu("Ressources Humaines")
                            .withIcon("bx bx-group")
                            .addSubmenu(
                                    new Menu("Vendeur")
                                            .withIcon("bx bx-user")
                                            .addSubmenu(
                                                new Menu("Saisie Vendeur")
                                                        .withIcon("bx bx-plus")
                                                        .withLien("/vendeur/form")
                                            )
                                            .addSubmenu(
                                                new Menu("Lister Vendeur")
                                                        .withIcon("bx bx-list-ol")
                                                        .withLien("/vendeur/list")
                                            )
                            )
                            .addSubmenu(
                                    new Menu("Client")
                                            .withIcon("bx bx-user")
                                            .addSubmenu(
                                                    new Menu("Saisie Client")
                                                            .withIcon("bx bx-plus")
                                                            .withLien("/client/form")
                                            )
                                            .addSubmenu(
                                                    new Menu("Lister Clients")
                                                            .withIcon("bx bx-list-ol")
                                                            .withLien("/client/list")
                                            )
                            )
                            .addSubmenu(
                                new Menu("Fournisseur")
                                        .withIcon("bx bx-user")
                                        .addSubmenu(
                                                new Menu("Saisie Fournisseur")
                                                        .withIcon("bx bx-plus")
                                                        .withLien("/fournisseur/form")
                                        )
                                        .addSubmenu(
                                                new Menu("Lister Fournisseurs")
                                                        .withIcon("bx bx-list-ol")
                                                        .withLien("/fournisseur/list")
                                        )
                            )
            )
            .addMenu(
                new Menu("Configuration")
                        .withIcon("bx bx-cog")
                        .addSubmenu(
                            new Menu("Type Produit")
                                    .withIcon("bx bxs-shapes")
                                    .addSubmenu(
                                        new Menu("Saisie type produit")
                                                .withLien("/type-produit/form")
                                    )
                                    .addSubmenu(
                                        new Menu("Lister type produit")
                                                .withLien("/type-produit/list")
                                    )
                        )
                        .addSubmenu(
                            new Menu("Categorie Produit")
                                    .withIcon("bx bx-category")
                                    .addSubmenu(
                                        new Menu("Saisie categorie produit")
                                                .withLien("/categorie-produit/form")
                                    )
                                    .addSubmenu(
                                        new Menu("Lister categorie produit")
                                                .withLien("/categorie-produit/list")
                                    )
                        )
                        .addSubmenu(
                            new Menu("Unite Produit")
                                    .withIcon("bx bx-ruler")
                                    .addSubmenu(
                                        new Menu("Saisie unite produit")
                                                .withLien("/unite/form")
                                    )
                                    .addSubmenu(
                                        new Menu("Lister unite produit")
                                                .withLien("/unite/list")
                                    )
                        )
                        .addSubmenu(
                            new Menu("Parfum")
                                    .withIcon("bx bx-food-menu")
                                    .addSubmenu(
                                        new Menu("Saisie Parfum")
                                                .withLien("/parfum/form")
                                    )
                                    .addSubmenu(
                                        new Menu("Lister Parfum")
                                                .withLien("/parfum/list")
                                    )
                        )
            )


            ;
%>

<%=sidebar.getHtml(request, "")%>


