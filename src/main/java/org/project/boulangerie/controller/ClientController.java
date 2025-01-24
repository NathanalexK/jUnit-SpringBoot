package org.project.boulangerie.controller;

import org.project.boulangerie.model.Client;
import org.project.boulangerie.service.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.nx.CrudController;
import spring.nx.NxService;

@Controller
@RequestMapping("/client")
public class ClientController extends CrudController<Client, Integer> {
    public ClientController(ClientService service) {
        super(service);
    }
}
