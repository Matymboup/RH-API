package com.example.rh.rhapi;

import com.example.rh.rhapi.controller.EmployeController;
import com.example.rh.rhapi.model.Employe;

import com.example.rh.rhapi.service.EmployeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers= EmployeController.class)

class RhApiApplicationTests {
    @Autowired
    private MockMvc myMock;
    @MockBean
    private EmployeService employeService;

    @Test
    public void testGetEmployees() throws Exception {
      myMock.perform(get("/employees")).andExpect((status().isOk()));
    }


}

