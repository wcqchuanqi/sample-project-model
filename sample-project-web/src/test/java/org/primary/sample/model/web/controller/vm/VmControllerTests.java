package org.primary.sample.model.web.controller.vm;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.primary.sample.model.web.util.JsonParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Objects;

@SpringBootTest
@WebAppConfiguration
@Slf4j
public class VmControllerTests {

    @Autowired
    WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    /**
     * PS:junit5 @BeforeEach == @Before
     * 表示在每个测试方法之前执行
     */
    @BeforeEach
    public void setMockMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void vmListPagination() {
        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/vm/info/list/v1")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(Objects.requireNonNull(JsonParam.readJsonParam("VmDetailInfoRequest.json"))))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(MockMvcResultHandlers.log());
        } catch (Exception e) {
            log.error("查询异常堆栈：{}", e);
        }
    }

}
