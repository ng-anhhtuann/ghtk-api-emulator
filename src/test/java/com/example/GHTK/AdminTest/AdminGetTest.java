package com.example.GHTK.AdminTest;

import com.example.GHTK.Model.AdminRight.Area;
import com.example.GHTK.Model.Custom.OrderDetails;
import com.example.GHTK.Model.Status.Response;
import com.example.GHTK.Model.UserRight.Customer;
import com.example.GHTK.Model.UserRight.Order;
import com.example.GHTK.Model.UserRight.Shipper;
import com.example.GHTK.Repository.Repository.AdminRepository;
import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.mockito.BDDMockito.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest
@AutoConfigureMockMvc
public class AdminGetTest {
    @Autowired
    private MockMvc mockMvc;
    @Mock
    private AdminRepository adminRepository;
    //    @Autowired
//    private ObjectMapper objectMapper;
    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    /*
    Almost database here are null in order to test the bad request
     */
    @Test
    public void methodGetAllCustomer_ShouldReturnEmptyCustomersList() throws Exception {
        List<Customer> list = new ArrayList<>();
        Response response = new Response(true, list);
        given(adminRepository.queryCustomer()).willReturn(response);

        ResultActions resultActions = mockMvc.perform(get("/admin/get/all-customer"));

        resultActions.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.status", is(true)))
                .andExpect(jsonPath("$.object", is(list)));
    }

    @Test
    public void methodGetAllCustomerById_ShouldReturnNoCustomer() throws Exception {
//        Customer customer = new Customer("KH1", "Le Thanh", "Quan ao nam", "KV2", "0934726528", "so 2 Hoang Kiem", "quanaovip@gmail.com", "01373");
        String id = "KH1";
//        Response response = new Response(true, customer);
        Response responseFail = new Response(false, "No customer with this id");
        given(adminRepository.queryCustomerById(id)).willReturn(responseFail);
        /*
        Based on database
         */
        ResultActions resultActions = mockMvc.perform(get("/admin/get/customer-by-id").param("id", id));

        resultActions.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.status", is(false)))
                .andExpect(jsonPath("$.object", is(responseFail.getObject())));
    }

    @Test
    public void methodGetAllShipper_ShouldReturnEmptyShipperList() throws Exception {
        List<Shipper> list = new ArrayList<>();
        Response response = new Response(true, list);
        given(adminRepository.queryShipper()).willReturn(response);

        ResultActions resultActions = mockMvc.perform(get("/admin/get/all-shipper"));

        resultActions.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.status", is(true)))
                .andExpect(jsonPath("$.object", is(list)));
    }

    @Test
    public void methodGetShipperById_ShouldReturnNoShipper() throws Exception {
        String id = "TV1";
        Response response = new Response(false, "No shipper with this id");
        given(adminRepository.queryShipperById(id)).willReturn(response);
        /*
        Based on database
         */
        ResultActions resultActions = mockMvc.perform(get("/admin/get/shipper-by-id").param("id", id));

        resultActions.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.status", is(false)))
                .andExpect(jsonPath("$.object", is(response.getObject())));
    }

    /*
    Methods will all return list of Order details with id or some status inside
    Almost methods return OrderDetails(shortened version of Order)
    Info in another tables that included in Order table is missing or wrong
    Therefore arraylist wont return all whole completed list of OrderDetails -- this is not passive
     */
    @Test
    public void methodGetAllOrder_ShouldReturnEmptyOrderList() throws Exception {
        List<OrderDetails> list = new ArrayList<>();
        Response response = new Response(true, list);
        given(adminRepository.queryOrder()).willReturn(response);

        ResultActions resultActions = mockMvc.perform(get("/admin/get/all-order"));

        resultActions.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.status", is(true)))
                .andExpect(jsonPath("$.object", is(list)));
    }

    @Test
    public void methodGetOrderById_ShouldReturnNoOrder() throws Exception {
        String id = "DH1";
        Response response = new Response(false, "No order with this id");
        given(adminRepository.queryOrderByIdOrder(id)).willReturn(response);
        /*
        Based on database
         */
        ResultActions resultActions = mockMvc.perform(get("/admin/get/order-by-id").param("id", id));

        resultActions.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.status", is(false)))
                .andExpect(jsonPath("$.object", is(response.getObject())));
    }

    @Test
    public void methodGetOrdersByIdCustomer_ShouldReturnNoOrder() throws Exception {
        List<OrderDetails> list = new ArrayList<>();
        String id = "KH1";
        Response response = new Response(true, list);
        given(adminRepository.queryAllOrderByIdCustomer(id)).willReturn(response);

        ResultActions resultActions = mockMvc.perform(get("/admin/get/all-order-same-shop")
                .param("id", id));

        resultActions.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.status", is(true)))
                .andExpect(jsonPath("$.object", is(list)));
    }

    @Test
    public void methodGetOrdersByIdShipper_ShouldReturnNoOrder() throws Exception {
        List<OrderDetails> list = new ArrayList<>();
        String id = "TV1";
        Response response = new Response(true, list);
        given(adminRepository.queryAllOrderByIdShipper(id)).willReturn(response);

        ResultActions resultActions = mockMvc.perform(get("/admin/get/all-order-same-shipper")
                .param("id", id));

        resultActions.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.status", is(true)))
                .andExpect(jsonPath("$.object", is(list)));
    }

    @Test
    public void methodGetAllOrderNotApproved_ShouldReturnEmptyOrderList() throws Exception {
        List<OrderDetails> list = new ArrayList<>();
        Response response = new Response(true, list);
        given(adminRepository.queryAllOrderNotApproved()).willReturn(response);

        ResultActions resultActions = mockMvc.perform(get("/admin/get/all-order-not-approved"));

        resultActions.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.status", is(true)))
                .andExpect(jsonPath("$.object", is(list)));
    }

    @Test
    public void methodGetAllOrderApproved_ShouldReturnEmptyOrderList() throws Exception {
        List<OrderDetails> list = new ArrayList<>();
        Response response = new Response(true, list);
        given(adminRepository.queryAllOrderApproved()).willReturn(response);

        ResultActions resultActions = mockMvc.perform(get("/admin/get/all-order-approved"));

        resultActions.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.status", is(true)))
                .andExpect(jsonPath("$.object", is(list)));
    }

    
}
