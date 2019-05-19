package com.youngman.modelmapper.demo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YoungMan on 2019-05-19.
 */

@NoArgsConstructor
@Getter
public class Source {

	private String id;
	private String name;
	private List<InnerSource> innerSources = new ArrayList();

	@Builder
	public Source(String id, String name, List<InnerSource> innerSources) {
		this.id = id;
		this.name = name;
		this.innerSources = innerSources;
	}

	@NoArgsConstructor
	public static class InnerSource {
		private String id;
		private String name;

		@Builder
		public InnerSource(String id, String name) {
			this.id = id;
			this.name = name;
		}
	}
}
