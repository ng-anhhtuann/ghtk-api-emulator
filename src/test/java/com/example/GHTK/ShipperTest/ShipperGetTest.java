package com.example.GHTK.ShipperTest;

import com.example.GHTK.Model.Custom.OrderDetails;
import com.example.GHTK.Model.Status.Response;
import com.example.GHTK.Repository.Repository.ShipperRepository;
import com.example.GHTK.Repository.Repository.ShopRepository;
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
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@AutoConfigureMockMvc
public class ShipperGetTest {
    @Autowired
    private MockMvc mockMvc;
    @Mock
    private ShipperRepository shipperRepository = new ShipperRepository();
    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }
    @Test
    public void methodGetOrdersByIdShipper_ShouldReturnNoOrder() throws Exception {
        List<OrderDetails> list = new ArrayList<>();
        String id = "TV10";
        Response response = new Response(true, list);
        given(shipperRepository.queryAllOrderByIdShipper(id)).willReturn(response);

        ResultActions resultActions = mockMvc.perform(get("/"+id+"/get/all-order-registered")
                .param("id", id));

        resultActions.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.status", is(true)))
                .andExpect(jsonPath("$.object", is(list)));
    }
    @Test
    public void methodGetOrdersAvailable_ShouldReturnNoOrder() throws Exception {
        List<OrderDetails> list = new ArrayList<>();
        String id = "TV10";
        Response response = new Response(true, list);
        given(shipperRepository.queryAllOrderByIdShipper(id)).willReturn(response);

        ResultActions resultActions = mockMvc.perform(get("/"+id+"/get/all-available-order")
                .param("id", id));

        resultActions.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.status", is(true)))
                .andExpect(jsonPath("$.object", is(list)));
    }

}
