package com.example.GHTK.AdminTest;

import com.example.GHTK.Model.AdminRight.Area;
import com.example.GHTK.Model.AdminRight.Service;
import com.example.GHTK.Model.AdminRight.TimeLine;
import com.example.GHTK.Model.AdminRight.Type;
import com.example.GHTK.Repository.Repository.AdminRepository;
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

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.mockito.BDDMockito.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

//@SpringBootTest
@WebMvcTest
@AutoConfigureMockMvc
//@RunWith(SpringRunner.class)
public class AdminPostTest {
    @Autowired
    private MockMvc mockMvc;
    @Mock
    private AdminRepository adminRepository;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    void methodInsertExistedArea_ShouldReturnFalse_MeanPass() throws Exception {
        Area area = new Area("Go Vap");
        given(adminRepository.insert(area))
                .willAnswer((invocation) -> invocation.getArgument(0));

        ResultActions response = (ResultActions) AdminTestUtility.PostResultActions(area, "/admin/post/area", mockMvc, objectMapper);

        response.andDo(print()).
                andExpect(status().isCreated())
                .andExpect(jsonPath("$.status",
                        is(false)))
                .andExpect(jsonPath("$.object",
                        is("Duplicated value in database")));
    }

    @Test
    void methodInsertExistedService_ShouldReturnFalse_MeanPass() throws Exception {
        Service service = new Service("Nguoi gui tra phi");
        given(adminRepository.insert(service))
                .willAnswer((invocation) -> invocation.getArgument(0));

        ResultActions response = (ResultActions) AdminTestUtility.PostResultActions(service, "/admin/post/service", mockMvc, objectMapper);

        response.andDo(print()).
                andExpect(status().isCreated())
                .andExpect(jsonPath("$.status",
                        is(false)))
                .andExpect(jsonPath("$.object",
                        is("Duplicated value in database")));
    }
    @Test
    void methodInsertExistedType_ShouldReturnFalse_MeanPass() throws Exception {
        Type type = new Type("Buu kien");
        given(adminRepository.insert(type))
                .willAnswer((invocation) -> invocation.getArgument(0));

        ResultActions response = (ResultActions) AdminTestUtility.PostResultActions(type, "/admin/post/type", mockMvc, objectMapper);

        response.andDo(print()).
                andExpect(status().isCreated())
                .andExpect(jsonPath("$.status",
                        is(false)))
                .andExpect(jsonPath("$.object",
                        is("Duplicated value in database")));
    }

    @Test
    void methodInsertExistedTimeLine_ShouldReturnFalse_MeanPass() throws Exception {
        TimeLine timeLine = new TimeLine("1pm-3pm");
        given(adminRepository.insert(timeLine))
                .willAnswer((invocation) -> invocation.getArgument(0));

        ResultActions response = (ResultActions) AdminTestUtility.PostResultActions(timeLine, "/admin/post/timeLine", mockMvc, objectMapper);

        response.andDo(print()).
                andExpect(status().isCreated())
                .andExpect(jsonPath("$.status",
                        is(false)))
                .andExpect(jsonPath("$.object",
                        is("Duplicated value in database")));
    }


}
