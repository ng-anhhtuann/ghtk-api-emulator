package com.example.GHTK.ShopTest;

import com.example.GHTK.Model.Custom.OrderDetails;
import com.example.GHTK.Model.Status.Response;
import com.example.GHTK.Model.UserRight.Order;
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
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@AutoConfigureMockMvc
public class ShopPostTest {
    @Autowired
    private MockMvc mockMvc;
    @Mock
    private ShopRepository shopRepository = new ShopRepository();
    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    public void methodPostNewOrder_ShouldReturnTrue() throws Exception {
        Order order = new Order("KH2", "DV2", "MH1", "TG2", "Vaegabond"
                , 3.5f, 2000000, "Ai Ma Biet", "0936158274", "So 123 Cau giay"
                , false);
        String id = order.getIdshopOrder();
        Response response = new Response(true, order);
        given(shopRepository.createOrder(order)).willReturn(response);

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(order);

        mockMvc.perform(post("/" + id + "/post/post-order").contentType(APPLICATION_JSON_UTF8)
                        .content(requestJson))
                .andExpect(status().isOk());
    }

}