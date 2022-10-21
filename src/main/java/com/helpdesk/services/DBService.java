package com.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helpdesk.entity.enums.Perfil;
import com.helpdesk.entity.enums.Prioridade;
import com.helpdesk.entity.enums.Status;
import com.helpdesk.entity.model.Chamado;
import com.helpdesk.entity.model.Cliente;
import com.helpdesk.entity.model.Tecnico;
import com.helpdesk.repository.ChamadoRepository;
import com.helpdesk.repository.ClienteRepository;
import com.helpdesk.repository.TecnicoRepository;

@Service
public class DBService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private TecnicoRepository tecnicoRepository;

    @Autowired
    private ChamadoRepository chamadoRepository;

    public void instanciaDB() {
        Tecnico tec1 = new Tecnico(
                null, "Mateus Scarin",
                "47097717823",
                "scarin@mail.com",
                "123");
        tec1.addPerfil(Perfil.ADMIN);

        Cliente cli1 = new Cliente(
                null,
                "Linus Torvalds",
                "40312778813",
                "torvalds@mail.com",
                "123");

        Chamado ch1 = new Chamado(
                null,
                Prioridade.MEDIA,
                Status.ANDAMENTO,
                "Chamado 01",
                "Primeiro chamado",
                tec1,
                cli1);

        tecnicoRepository.saveAll(Arrays.asList(tec1));
        clienteRepository.saveAll(Arrays.asList(cli1));
        chamadoRepository.saveAll(Arrays.asList(ch1));
    }
}
