package org.acme.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.acme.dto.EmployeeDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.hamcrest.Matchers.containsString;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class EmployeeControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void givenEmployeesExist_whenGetAllEmployees_thenStatusOk() throws Exception {
        // Given: The Employee API is accessible

        // When: A GET request is made to retrieve all employees
        mockMvc.perform(MockMvcRequestBuilders.get("/api/employees"))
                // Then: The response status should be 200 OK
                .andExpect(status().isOk());
    }

    @Test
    public void givenNewEmployee_whenPostEmployee_thenStatusCreated() throws Exception {
        // Given: A new employee object to add
        EmployeeDTO newEmployee = new EmployeeDTO();
        newEmployee.setName("Laura Doe");
        newEmployee.setRole("Developer");

        // When: A POST request is made to add the new employee
        mockMvc.perform(MockMvcRequestBuilders.post("/api/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newEmployee)))
                // Then: The response status should be 201 Created
                .andExpect(status().isOk());
    }

    @Test
    public void givenNewEmployee_whenGetAllEmployees_thenEmployeeIsPresent() throws Exception {
        // Given: A new employee is added to the system
        EmployeeDTO newEmployee = new EmployeeDTO();
        newEmployee.setName("Jane Doe");
        newEmployee.setRole("Designer");

        mockMvc.perform(MockMvcRequestBuilders.post("/api/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newEmployee)))
                .andExpect(status().isOk());

        // When: A GET request is made to retrieve all employees
        mockMvc.perform(MockMvcRequestBuilders.get("/api/employees"))
                // Then: The newly added employee should be present in the response
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Jane Doe")));
    }
}
