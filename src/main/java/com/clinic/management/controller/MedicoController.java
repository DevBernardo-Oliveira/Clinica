package com.clinic.management.controller;

import com.clinic.management.dto.MedicoUpdateDTO;
import com.clinic.management.domain.Medico;
import com.clinic.management.service.MedicoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class MedicoController
{

    private final MedicoService service;

    public MedicoController(MedicoService service)
    {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Medico> create(@RequestBody Medico medico)
    {
        Medico saved = service.cadastrarMedico(medico);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medico> getById(@PathVariable Long id)
    {
        Medico medico = service.buscarPorId(id);
        return ResponseEntity.ok(medico);
    }

    @GetMapping
    public ResponseEntity<List<Medico>> getAll()
    {
        List<Medico> medicos = service.listarTodos();
        return ResponseEntity.ok(medicos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Medico> update(@PathVariable Long id, @RequestBody MedicoUpdateDTO dto)
    {
        Medico updated = service.atualizarMedico(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id)
    {
        service.deletarMedico(id);
        return ResponseEntity.noContent().build();
    }
}
