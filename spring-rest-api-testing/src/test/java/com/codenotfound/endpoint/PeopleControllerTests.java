package com.codenotfound.endpoint;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.codenotfound.model.People;
import com.codenotfound.repository.PeopleRepository;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest
public class PeopleControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private PeopleRepository repo;

	@Test
	public void testFindAll() throws Exception {
		when(repo.findAll()).thenReturn(Lists.newArrayList(
				new People("1", "Luke Skywalker", 172, 77), new People("2", "C-3PO", 167, 75)));
		mockMvc.perform(get("/api/people")).andExpect(status().isOk())
				.andExpect(jsonPath("$.[0].id", is("1")))
				.andExpect(jsonPath("$.[0].name", is("Luke Skywalker")))
				.andExpect(jsonPath("$.[0].height", is(172)))
				.andExpect(jsonPath("$.[0].mass", is(77))).andExpect(jsonPath("$.[1].id", is("2")))
				.andExpect(jsonPath("$.[1].name", is("C-3PO")))
				.andExpect(jsonPath("$.[1].height", is(167)))
				.andExpect(jsonPath("$.[1].mass", is(75)));
	}

	@Test
	public void testFindById() throws Exception {
		when(repo.findById("1")).thenReturn(new People("1", "Luke Skywalker", 172, 77));
		mockMvc.perform(get("/api/people/1")).andExpect(status().isOk())
				.andExpect(jsonPath("$.id", is("1")))
				.andExpect(jsonPath("$.name", is("Luke Skywalker")))
				.andExpect(jsonPath("$.height", is(172))).andExpect(jsonPath("$.mass", is(77)));
	}

	@Test
	public void testSave() throws Exception {
		when(repo.save(any())).thenReturn(new People("1", "Luke Skywalker", 172, 77));
		mockMvc.perform(post("/api/people").contentType(MediaType.APPLICATION_JSON)
				.content("{\"name\": \"Luke Skywalker\",\"height\": 172,\"mass\": 77}"))
				.andExpect(status().isOk()).andExpect(jsonPath("$.id", is("1")))
				.andExpect(jsonPath("$.name", is("Luke Skywalker")))
				.andExpect(jsonPath("$.height", is(172))).andExpect(jsonPath("$.mass", is(77)));
	}

	@Test
	public void testUpdate() throws Exception {
		when(repo.update(any(), any())).thenReturn(new People("1", "Luke Skywalker", 172, 87));
		mockMvc.perform(put("/api/people/1").contentType(MediaType.APPLICATION_JSON)
				.content("{\"name\": \"Luke Skywalker\",\"height\": 172,\"mass\": 87}"))
				.andExpect(status().isOk()).andExpect(jsonPath("$.id", is("1")))
				.andExpect(jsonPath("$.name", is("Luke Skywalker")))
				.andExpect(jsonPath("$.height", is(172))).andExpect(jsonPath("$.mass", is(87)));
	}

	@Test
	public void testDelete() throws Exception {
		mockMvc.perform(delete("/api/people/1")).andExpect(status().isOk());
	}
}
