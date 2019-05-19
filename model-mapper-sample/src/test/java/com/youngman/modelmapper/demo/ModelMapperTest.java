package com.youngman.modelmapper.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by YoungMan on 2019-05-19.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ModelMapperTest {

	@Autowired
	private ModelMapper modelMapper;

	@Before
	public void setUp() {
		modelMapper.getConfiguration().setFieldMatchingEnabled(true)
				.setFieldAccessLevel(Configuration.AccessLevel.PRIVATE)//Private 필드 매핑
				.setMatchingStrategy(MatchingStrategies.LOOSE);//계층 구조 Mapping 을 위해 매칭전략 변경
	}

	@Test
	public void mapSourceToDestination() throws Exception {

		//given
		Source source = Source.builder()
				.id("ID1")
				.name("NAME1")
				.innerSources(
						Arrays.asList(
								Source.InnerSource.builder()
										.id("INNER_ID1")
										.name("INNER_NAME1")
										.build(),
								Source.InnerSource.builder()
										.id("INNER_ID2")
										.name("INNER_NAME2")
										.build()
						)
				)
				.build();

		//when
		Destination destination = modelMapper.map(source, Destination.class);

		//then
		assertThat(destination.getId(), is("ID1"));
		assertThat(destination.getInnerDestinations().size(), is(2));

	}

	@Test
	public void expressionMapping() throws Exception {

		//given
		Source2 source2 = Source2.builder()
				.id("ID1")
				.sourceName("SOURCE_NAME")
				.innerSource2s(
						Arrays.asList(
								Source2.InnerSource2.builder()
										.id("INNER_ID1")
										.innerSourceName("INNER_SOURCE_NAME1")
										.build()
						)
				)
				.build();

		//when
		modelMapper.addMappings(new PropertyMap<Source2, Destination2>() {
			protected void configure() {
				map().setDestinationName(source.getSourceName());
			}
		});

		Destination2 destination2 = modelMapper.map(source2, Destination2.class);

		//then
		assertThat(destination2.getId(), is("ID1"));
		assertThat(destination2.getDestinationName(), is("SOURCE_NAME"));
		assertThat(destination2.getInnerDestination2s().get(0).getId(), is("INNER_ID1"));
		//TODO 이름으로 Mapping 하기 때문에 가능하지 싶다
		assertThat(destination2.getInnerDestination2s().get(0).getInnerDestinationName(), is("INNER_SOURCE_NAME1"));
	}
}
