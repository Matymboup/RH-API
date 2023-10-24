package com.example.rh.rhapi;

import com.example.rh.rhapi.controller.EmployeController;
import com.example.rh.rhapi.model.Employe;

import com.example.rh.rhapi.service.EmployeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.http.RequestEntity.post;
import static org.springframework.http.RequestEntity.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(controllers=EmployeController.class)
class RhApiApplicationTests {
   @Autowired
  private MockMvc myMock;
   @MockBean
   private EmployeService employeService;
//
//    @Test
//    public void testGetEmployees() throws Exception {
//      myMock.perform(get("/employees")).andExpect((status().isOk()));
//    }

    private ObjectMapper objectMapper;
    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    public void testGetEmployees() throws Exception {
        // Créez des données factices d'employés à utiliser dans le test
        List<Employe> employes = Arrays.asList(
                new Employe( "John", "Doe", "john.doe@example.com", "password1"),
                new Employe("Jane", "Smith", "jane.smith@example.com", "password2")
        );

        // Mockez le service pour renvoyer les données factices d'employés
        when(employeService.getEmployees()).thenReturn(employes);

        // Effectuez la requête GET et vérifiez le statut et le contenu
        myMock.perform(get("/employees")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
    }


//
//    @Test
//    public void testSaveEmploye() throws Exception {
//        // Créez un employé factice à utiliser dans le test
//        Employe employe = new Employe( "John", "Doe", "john.doe@example.com", "password1");
//
//        // Mockez le service pour renvoyer l'employé factice après la création
//        when(employeService.saveEmploye(any(Employe.class))).thenReturn(employe);
//
//        // Effectuez la requête POST pour créer un nouvel employé et vérifiez le statut et le contenu
//        myMock.perform(post("/creer-Employe")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(employe)))
//                .andExpect(status().isOk())
//                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
//    }
//
//    @Test
//    public void testUpdateEmployee() throws Exception {
//        Long employeId = 1L;
//
//        // Créez un employé factice avec des données mises à jour à utiliser dans le test
//        Employe updatedEmploye = new Employe( "UpdatedFirstName", "UpdatedLastName", "updated.email@example.com", "updatedpassword");
//
//        // Mockez le service pour renvoyer l'employé factice mis à jour
//        when(employeService.getEmploye(employeId)).thenReturn(Optional.of(updatedEmploye));
//        when(employeService.saveEmploye(any(Employe.class))).thenReturn(updatedEmploye);
//
//        // Effectuez la requête PUT pour mettre à jour l'employé et vérifiez le statut et le contenu
//        myMock.perform(put("/employee-update/{id}", employeId)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(updatedEmploye)))
//                .andExpect(status().isOk())
//                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
//    }
    @Test
    public void testDeleteEmployee() throws Exception {
        Long employeId = 1L;

        // Effectuez la requête DELETE pour supprimer l'employé en fonction de l'ID et vérifiez le statut
        myMock.perform(delete("/employee/{id}", employeId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }



}

