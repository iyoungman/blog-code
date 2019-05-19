package com.youngman.modelmapper.demo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YoungMan on 2019-05-19.
 */

@NoArgsConstructor
@Getter
public class Destination {

	private String id;
	private List<InnerDestination> innerDestinations = new ArrayList();

	@Builder
	public Destination(String id, List<InnerDestination> innerDestinations) {
		this.id = id;
		this.innerDestinations = innerDestinations;
	}

	@NoArgsConstructor
	public static class InnerDestination {
		private String id;

		@Builder
		public InnerDestination(String id) {
			this.id = id;
		}
	}


}
