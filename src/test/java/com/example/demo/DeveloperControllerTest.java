package com.example.demo;

import com.example.demo.IssuetrackerApplication;
import com.example.demo.controller.DeveloperController;
import com.example.demo.webservices.DeveloperService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



//Teste den DeveloperController

//@RunWith(SpringJUnit4ClassRunner.class)

@WebMvcTest(DeveloperController.class)      //benötigt für das "mockMvc"

//@SpringBootTest(classes = IssuetrackerApplication.class)

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = IssuetrackerApplication.class)
public class DeveloperControllerTest {

    @MockBean
    private DeveloperService developerService;

    @Autowired
    private MockMvc mockMvc;

    //teste ob der Controller den erwartet Rückgabewerte über die REST API liefert
    @Test
    public void testSimpleDeveloperOutput() throws Exception {
        String result ="";
        //check if any String is returned as a result
        given(this.developerService.simpleDeveloperOutput()).willReturn(result);
        this.mockMvc.perform(get("/getdeveloperscontroller/teststring"))
                    .andExpect(status().isOk());
//                    .andExpect(content().string(containsString("Hi DeveloperService here")));
    }

}
