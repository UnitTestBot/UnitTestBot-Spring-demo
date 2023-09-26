package com.rest.order.standard.flow.controllers;

import com.rest.order.standard.flow.models.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTestContextBootstrapper;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.BootstrapWith;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.web.util.UriComponentsBuilder.fromPath;

@SpringBootTest
@BootstrapWith(SpringBootTestContextBootstrapper.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@Transactional
@AutoConfigureTestDatabase
@AutoConfigureMockMvc
public class OrderControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @PersistenceContext
    private EntityManager entityManager;


    /**
     * This sanity check test fails if the application context cannot start.
     */
    @Test
    public void contextLoads() {
    }


    ///region Test suites for executable com.rest.order.standard.flow.controllers.OrderController.isMajorityExpensive


    @Test
    public void testIsMajorityExpensive1() throws Exception {
        UriComponentsBuilder uriComponentsBuilder = fromPath("/api/isMajorityExpensive");
        Object[] values = {4097};
        UriComponentsBuilder uriComponentsBuilder1 = uriComponentsBuilder.queryParam("threshold", values);
        String urlTemplate = uriComponentsBuilder1.toUriString();
        Object[] uriVariables = {};
        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = get(urlTemplate, uriVariables);

        ResultActions actual = mockMvc.perform(mockHttpServletRequestBuilder);

        actual.andDo(print());
        actual.andExpect((status()).is(200));
        actual.andExpect((content()).string("false"));
    }

    @Test
    public void testIsMajorityExpensive2() throws Exception {
        Order order = new Order(0L, "#$\\\"'", -1, -1);
        entityManager.persist(order);
        entityManager.flush();
        UriComponentsBuilder uriComponentsBuilder = fromPath("/api/isMajorityExpensive");
        Object[] values = {524289};
        UriComponentsBuilder uriComponentsBuilder1 = uriComponentsBuilder.queryParam("threshold", values);
        String urlTemplate = uriComponentsBuilder1.toUriString();
        Object[] uriVariables = {};
        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = get(urlTemplate, uriVariables);

        ResultActions actual = mockMvc.perform(mockHttpServletRequestBuilder);

        actual.andDo(print());
        actual.andExpect((status()).is(200));
        actual.andExpect((content()).string("false"));
    }

    @Test
    public void testIsMajorityExpensive3() throws Exception {
        Order order = new Order(0L, "\n\t\r", -1, Integer.MIN_VALUE);
        order.setBuyer("\n\t\r");
        entityManager.persist(order);
        entityManager.flush();
        UriComponentsBuilder uriComponentsBuilder = fromPath("/api/isMajorityExpensive");
        Object[] values = {-2147450880};
        UriComponentsBuilder uriComponentsBuilder1 = uriComponentsBuilder.queryParam("threshold", values);
        String urlTemplate = uriComponentsBuilder1.toUriString();
        Object[] uriVariables = {};
        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = get(urlTemplate, uriVariables);

        ResultActions actual = mockMvc.perform(mockHttpServletRequestBuilder);

        actual.andDo(print());
        actual.andExpect((status()).is(200));
        actual.andExpect((content()).string("true"));
    }

    ///endregion
}
