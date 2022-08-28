package com.example.GHTK.AdminTest;

import com.example.GHTK.Model.AdminRight.Type;
import com.example.GHTK.Model.Status.Response;
import com.example.GHTK.Repository.Repository.AdminRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@AutoConfigureMockMvc
public class AdminPutTest {
    @Autowired
    private MockMvc mockMvc;
    @Mock
    private AdminRepository adminRepository = new AdminRepository();
    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    public void methodPutApproveAll_ShouldReturnTrueStatus() throws Exception {
        Response response = new Response(true, "2 order(s) have been approved");
        given(adminRepository.approveAllOrder()).willReturn(response);

        assertTrue(mockMvc.perform(put("/admin/put/approve-all-order"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString()
                .contains("approved"));
    }
    @Test
    public void methodPutOneOrderApprove_ShouldReturnFalseStatus() throws Exception {
        Response response = new Response(false, "No order with this id");
        String id = "DH5";
        given(adminRepository.approveOneOrder(id)).willReturn(response);

        assertTrue(mockMvc.perform(put("/admin/put/approve-one-order/"+id))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString()
                .contains("No order with this id"));
    }
}
