package io.mesmer.training.spring.webapp.Main.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.mesmer.training.spring.webapp.Main.Customers.Customer;
import io.mesmer.training.spring.webapp.Main.Customers.CustomerRepository;
import io.mesmer.training.spring.webapp.Main.Customers.WebAppApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes= WebAppApplication.class)
@AutoConfigureMockMvc
@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
@ContextConfiguration
public class CustomerControllerTest {

    @Autowired
    private MockMvc mvc;
    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testIndex() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Greetings Customers!")));
    }

    @Test
    public void testListing() throws Exception {
        List<Customer> customers = new ArrayList<>();
        Iterable<Customer> iterable = customerRepository.findAll();
        iterable.forEach(customers::add);
        mvc.perform(MockMvcRequestBuilders.get("/customers").accept(MediaType.APPLICATION_JSON)).
                andExpect(status().isOk()).andExpect(content().string(equalTo(customers)));
    }

    @Test
    public void testCreation() throws Exception {
        ObjectMapper mapper = null;
        String json = mapper.writeValueAsString(new Customer(99,"test_cust","ind","test@e.com"));
        mvc.perform(MockMvcRequestBuilders.post("/customers")
                .content(json).contentType(MediaType.APPLICATION_JSON)).
                andExpect(status().isCreated());

    }


}
