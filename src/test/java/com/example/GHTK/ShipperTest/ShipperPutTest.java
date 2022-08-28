package com.example.GHTK.ShipperTest;

import com.example.GHTK.Model.Status.Response;
import com.example.GHTK.Repository.Repository.AdminRepository;
import com.example.GHTK.Repository.Repository.ShipperRepository;
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
//import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@AutoConfigureMockMvc
public class ShipperPutTest {
    @Autowired
    private MockMvc mockMvc;
    @Mock
    private ShipperRepository shipperRepository = new ShipperRepository();
    @Autowired
    private WebApplicationContext webApplicationContext;
    private final ObjectMapper mapper = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false);
    private final ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
    @BeforeEach
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    public void methodRegisterOrder_ShouldReturnUnknownId() throws Exception {
        String idShipper = "TV5";
        String idOrder = "DH7";
        Response response = new Response(false, "No order with id: " + idOrder);
        given(shipperRepository.registerOrder(idOrder,idShipper)).willReturn(response);

        String requestJsonOrder=ow.writeValueAsString(idOrder);

        mockMvc.perform(put("/"+idShipper+"/update/take-order").contentType(APPLICATION_JSON_UTF8)
                        .content(requestJsonOrder))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status", is(false)));
    }
    @Test
    public void methodUpdateAddressShipper_ShouldReturnUnknownId() throws Exception {
        String id = "TV5";
        String newAddress = "Nga 3 chuong duong sa xi";
        Response response = new Response(false, "Unknown id :"+id);
        given(shipperRepository.updateAddressShipper(id,newAddress)).willReturn(response);

        String requestJson=ow.writeValueAsString(newAddress);

        mockMvc.perform(put("/"+id+"/update/address-shipper").contentType(APPLICATION_JSON_UTF8)
                        .content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status", is(false)));
    }
    @Test
    public void methodUpdateNameShiper_ShouldReturnUnknownId() throws Exception {
        String id = "TV5";
        String newThing = "Tui ten ti'";
        Response response = new Response(false, "Unknown id :"+id);
        given(shipperRepository.updateAddressShipper(id,newThing)).willReturn(response);

        String requestJson=ow.writeValueAsString(newThing);

        mockMvc.perform(put("/"+id+"/update/name-shipper").contentType(APPLICATION_JSON_UTF8)
                        .content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status", is(false)));
    }
    @Test
    public void methodUpdateNumberShipper_ShouldReturnUnknownId() throws Exception {
        String id = "TV5";
        String newThing = "0762389821";
        Response response = new Response(false, "Unknown id :"+id);
        given(shipperRepository.updateNumberShipper(id,newThing)).willReturn(response);

        String requestJson=ow.writeValueAsString(newThing);

        mockMvc.perform(put("/"+id+"/update/number-shipper").contentType(APPLICATION_JSON_UTF8)
                        .content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status", is(false)));
    }
    @Test
    public void methodUpdateMailShipper_ShouldReturnUnknownId() throws Exception {
        String id = "TV5";
        String newThing = "kjnasdadf@gmail.com";
        Response response = new Response(false, "Unknown id :"+id);
        given(shipperRepository.updateMailShipper(id,newThing)).willReturn(response);

        String requestJson=ow.writeValueAsString(newThing);

        mockMvc.perform(put("/"+id+"/update/mail-shipper").contentType(APPLICATION_JSON_UTF8)
                        .content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status", is(false)));
    }
}
