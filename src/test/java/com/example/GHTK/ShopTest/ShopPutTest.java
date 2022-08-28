package com.example.GHTK.ShopTest;

import com.example.GHTK.Model.Status.Response;
import com.example.GHTK.Repository.Repository.AdminRepository;
import com.example.GHTK.Repository.Repository.ShopRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@AutoConfigureMockMvc
public class ShopPutTest {
    @Autowired
    private MockMvc mockMvc;
    @Mock
    private ShopRepository shopRepository = new ShopRepository();
    @Autowired
    private WebApplicationContext webApplicationContext;
    private final ObjectMapper mapper = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false);
    private final ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();

    @BeforeEach
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    public void methodUpdateAddress_ShouldReturnUnknownId() throws Exception {
        String id = "KH5";
        String newAddress = "Nga 3 chuong duong sa xi";
        Response response = new Response(false, "Unknown id :"+id);
        given(shopRepository.updateAddressCustomer(id,newAddress)).willReturn(response);

        String requestJson=ow.writeValueAsString(newAddress);

        mockMvc.perform(put("/"+id+"/update/address-customer").contentType(APPLICATION_JSON_UTF8)
                        .content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status", is(false)));
    }
    @Test
    public void methodUpdateNameShop_ShouldReturnUnknownId() throws Exception {
        String id = "KH5";
        String newThing = "Quan khac ne ";
        Response response = new Response(false, "Unknown id :"+id);
        given(shopRepository.updateNameShopCustomer(id,newThing)).willReturn(response);

        String requestJson=ow.writeValueAsString(newThing);

        mockMvc.perform(put("/"+id+"/update/name-shop").contentType(APPLICATION_JSON_UTF8)
                        .content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status", is(false)));
    }
    @Test
    public void methodUpdateNameCustomer_ShouldReturnUnknownId() throws Exception {
        String id = "KH5";
        String newThing = "Nguyen Thi Vip Pro";
        Response response = new Response(false, "Unknown id :"+id);
        given(shopRepository.updateNameCustomer(id,newThing)).willReturn(response);

        String requestJson=ow.writeValueAsString(newThing);

        mockMvc.perform(put("/"+id+"/update/name-customer").contentType(APPLICATION_JSON_UTF8)
                        .content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status", is(false)));
    }
    @Test
    public void methodUpdateAreaCustomer_ShouldReturnUnknownId() throws Exception {
        String id = "KH5";
        String newThing = "Tay Son";
        Response response = new Response(false, "Unknown id :"+id);
        given(shopRepository.updateAreaCustomer(id,newThing)).willReturn(response);

        String requestJson=ow.writeValueAsString(newThing);

        mockMvc.perform(put("/"+id+"/update/area-customer").contentType(APPLICATION_JSON_UTF8)
                        .content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status", is(false)));
    }
    @Test
    public void methodUpdateNumber_ShouldReturnUnknownId() throws Exception {
        String id = "KH5";
        String newThing = "0712389821";
        Response response = new Response(false, "Unknown id :"+id);
        given(shopRepository.updateNumberCustomer(id,newThing)).willReturn(response);

        String requestJson=ow.writeValueAsString(newThing);

        mockMvc.perform(put("/"+id+"/update/number-customer").contentType(APPLICATION_JSON_UTF8)
                        .content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status", is(false)));
    }
    @Test
    public void methodUpdateMailShop_ShouldReturnUnknownId() throws Exception {
        String id = "KH5";
        String newThing = "kjnasdadf@gmail.com";
        Response response = new Response(false, "Unknown id :"+id);
        given(shopRepository.updateMailCustomer(id,newThing)).willReturn(response);

        String requestJson=ow.writeValueAsString(newThing);

        mockMvc.perform(put("/"+id+"/update/mail-customer").contentType(APPLICATION_JSON_UTF8)
                        .content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status", is(false)));
    }

}
