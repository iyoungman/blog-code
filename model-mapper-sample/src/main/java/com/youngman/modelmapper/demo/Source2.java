package com.youngman.modelmapper.demo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YoungMan on 2019-05-20.
 */

@NoArgsConstructor
@Getter
public class Source2 {

	private String id;
	private String sourceName;
	private List<InnerSource2> innerSource2s = new ArrayList<>();

	@Builder
	public Source2(String id, String sourceName, List<InnerSource2> innerSource2s) {
		this.id = id;
		this.sourceName = sourceName;
		this.innerSource2s = innerSource2s;
	}

	@NoArgsConstructor
	@Getter
	public static class InnerSource2 {
		private String id;
		private String innerSourceName;

		@Builder
		public InnerSource2(String id, String innerSourceName) {
			this.id = id;
			this.innerSourceName = innerSourceName;
		}
	}
}
