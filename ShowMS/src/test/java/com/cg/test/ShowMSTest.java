package com.cg.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.exceptions.misusing.MissingMethodInvocationException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import com.cg.show.DAO.ShowEntity;
import com.cg.show.DAO.ShowRepository;
import com.cg.show.model.Show;
import com.cg.show.service.ShowServiceImp;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = com.cg.test.ShowMSTest.class)
public class ShowMSTest {
	@InjectMocks
	ShowServiceImp showService;
	@MockBean
	ShowRepository showRepository;

	@Before
	public void setUp() {
		ShowEntity showEntity = new ShowEntity(12345678, 9, 12, 250, "Avengersss", 1234, 5678);
		Optional<ShowEntity> optional = Optional.of(showEntity);
		Show show = new Show();
		show.setShowId(showEntity.getShowId());
		show.setShowStartTime(showEntity.getShowStartTime());
		show.setShowEndTime(showEntity.getShowEndTime());
		show.setSeats(showEntity.getSeats());
		show.setShowName(showEntity.getShowName());
		show.setMovieId(showEntity.getMovieId());
		show.setTheatreId(showEntity.getTheaterId());
		MockitoAnnotations.initMocks(this);

	}

	@Test
	public void contextLoads() {
	}

	@Test
	public void readShowPositiveTest() {
		Integer showId = 12345678;
		ShowEntity showEntity = new ShowEntity(12345678, 9, 12, 250, "Avengersss", 1234, 5678);
		Optional<ShowEntity> optional = Optional.of(showEntity);
		when(showRepository.findById(showId)).thenReturn(optional);
		assertNotNull(showService.readShow(showId));
	}

	@Test(expected = NullPointerException.class)
	public void readShowNegetiveTest() {
		Integer showId = 1234567;
		ShowEntity showEntity = new ShowEntity(12345678, 9, 12, 250, "Avengersss", 1234, 5678);
		Optional<ShowEntity> optional = Optional.of(showEntity);
		when(showRepository.findById(showId)).thenReturn(null);
		assertEquals("ShowId not found", showService.readShow(showId));
	}

	@Test
	public void createShowPositiveTest() {
		Show show = new Show(12345678, 9, 12, 250, "Avengersss", 1234, 5678);
		assertNotNull(showService.createShow(show));
	}

	@Test(expected = MissingMethodInvocationException.class)
	public void createShowNegetiveTest() {
		Show show = new Show(1234567, 9, 12, 250, "Avengersss", 1234, 5678);
		when(showService.createShow(show)).thenReturn(false);
		assertEquals(false, showService.createShow(show));
	}

	@Test
	public void updateShowPositiveTest() {
		Integer showId = 12345678;
		Show show = new Show(12345678, 9, 12, 250, "Avengersss", 1234, 5678);
		assertNotNull(showService.updateShow(showId, show));
	}

	@Test(expected = NullPointerException.class)
	public void updateShowNegetivetiveTest() {
		Integer showId = 1234567;
		Show show = new Show(12345678, 9, 12, 250, "Avengersss", 1234, 5678);
		when(showRepository.findById(showId)).thenReturn(null);
		assertEquals(null, showService.updateShow(showId, show));
	}

	@Test
	public void deleteShowPositiveTest() {
		Integer showId = 12345678;
		ShowEntity showEntity = new ShowEntity(12345678, 9, 12, 250, "Avengersss", 1234, 5678);
		Optional<ShowEntity> optional = Optional.of(showEntity);
		when(showRepository.findById(showId)).thenReturn(optional);
		assertNotNull(showService.deleteShow(showId));
	}

	@Test(expected = AssertionError.class)
	public void deleteShowNegetiveTest() {
		Integer showId = 1234567;
		assertEquals(false, showService.deleteShow(showId));
	}

	@Test
	public void readShowByMovieIdPositive() {
		Integer movieId = 1234;
		ShowEntity showEntity = new ShowEntity(12345678, 9, 12, 250, "Avengersss", 1234, 5678);
		when(showRepository.findByMovieId(movieId)).thenReturn(Stream.of(showEntity).collect(Collectors.toList()));
		assertEquals(1, showService.readShowByMovieId(movieId).size());
	}

	@Test
	public void readShowByMovieIdNegetive() {
		Integer movieId = 123;
		ShowEntity showEntity = new ShowEntity(12345678, 9, 12, 250, "Avengersss", 1234, 5678);
		List<ShowEntity> s = new ArrayList<ShowEntity>();
		when(showRepository.findByMovieId(movieId)).thenReturn(s);
		assertEquals(0, showService.readShowByMovieId(movieId).size());
	}
}
