package com.youngman.modelmapper.demo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YoungMan on 2019-05-20.
 */

@NoArgsConstructor
@Getter @Setter
public class Destination2 {

	private String id;
	private String destinationName;
	private List<InnerDestination2> innerDestination2s = new ArrayList<>();

	@Builder
	public Destination2(String id, String destinationName, List<InnerDestination2> innerDestination2s) {
		this.id = id;
		this.destinationName = destinationName;
		this.innerDestination2s = innerDestination2s;
	}


	@NoArgsConstructor
	@Getter @Setter
	public static class InnerDestination2 {
		private String id;
		private String innerDestinationName;

		@Builder
		public InnerDestination2(String id, String innerDestinationName) {
			this.id = id;
			this.innerDestinationName = innerDestinationName;
		}
	}
}
