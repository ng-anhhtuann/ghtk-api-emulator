package com.example.GHTK.AdminTest;

import com.example.GHTK.Model.AdminRight.Area;
import com.example.GHTK.Model.AdminRight.Service;
import com.example.GHTK.Model.AdminRight.TimeLine;
import com.example.GHTK.Model.AdminRight.Type;
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
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
    private AdminRepository adminRepository = new AdminRepository();
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

    @Test
    public void methodGetAllArea_ShouldReturnAreaList() throws Exception {

        List<Area> list = new ArrayList<>();
        list.add(new Area("Son Tra"));
        list.add(new Area("Go Vap"));
        Response response = new Response(true, list);
        given(adminRepository.queryArea()).willReturn(response);

        assertTrue(mockMvc.perform(get("/admin/get/all-area"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString()
                .contains("Go Vap"));
    }

    @Test
    public void methodGetAreaById_ShouldReturnArea() throws Exception {
        Area area = new Area("Son Tra");
        Response response = new Response(true, area);
        String id = "KV1";
        given(adminRepository.queryAreaById(id)).willReturn(response);

        assertTrue(mockMvc.perform(get("/admin/get/area-by-id").param("id", id))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString()
                .contains(area.getNameArea()));
    }

    @Test
    public void methodGetAllTime_ShouldReturnTimeList() throws Exception {

        List<TimeLine> list = new ArrayList<>();
        list.add(new TimeLine("7pm-9pm"));
        list.add(new TimeLine("3pm-5pm"));
        list.add(new TimeLine("1pm-3pm"));

        Response response = new Response(true, list);
        given(adminRepository.queryTime()).willReturn(response);

        assertTrue(mockMvc.perform(get("/admin/get/all-time"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString()
                .contains("3pm-5pm"));   //mid pos
    }

    @Test
    public void methodGetTimeById_ShouldReturnTime() throws Exception {
        TimeLine area = new TimeLine("7pm-9pm");
        Response response = new Response(true, area);
        String id = "TG1";
        given(adminRepository.queryTimeById(id)).willReturn(response);

        assertTrue(mockMvc.perform(get("/admin/get/time-by-id").param("id", id))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString()
                .contains(area.getDescription()));
    }

    @Test
    public void methodGetAllService_ShouldReturnServiceList() throws Exception {

        List<Service> list = new ArrayList<>();
        list.add(new Service("Hang Nha nuoc free"));
        list.add(new Service("Nguoi nhan tra phi"));
        list.add(new Service("Nguoi gui tra phi"));

        Response response = new Response(true, list);
        given(adminRepository.queryService()).willReturn(response);

        assertTrue(mockMvc.perform(get("/admin/get/all-service"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString()
                .contains("Nguoi nhan tra phi"));   //mid pos
    }

    @Test
    public void methodGetServiceById_ShouldReturnService() throws Exception {
        Service area = new Service("Hang Nha nuoc free");
        Response response = new Response(true, area);
        String id = "DV2";
        given(adminRepository.queryServiceById(id)).willReturn(response);

        assertTrue(mockMvc.perform(get("/admin/get/service-by-id").param("id", id))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString()
                .contains(area.getNameService()));
    }

    @Test
    public void methodGetAllType_ShouldReturnTypeList() throws Exception {

        List<Type> list = new ArrayList<>();
        list.add(new Type("Buu kien"));
        list.add(new Type("Quan ao"));

        Response response = new Response(true, list);
        given(adminRepository.queryType()).willReturn(response);

        assertTrue(mockMvc.perform(get("/admin/get/all-type"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString()
                .contains("Buu kien"));   //last pos
    }

    @Test
    public void methodGetTypeById_ShouldReturnType() throws Exception {
        Type area = new Type("Buu kien");
        Response response = new Response(true, area);
        String id = "MH1";
        given(adminRepository.queryTypeById(id)).willReturn(response);

        assertTrue(mockMvc.perform(get("/admin/get/type-by-id").param("id", id))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString()
                .contains(area.getNameProduct()));
    }

}
