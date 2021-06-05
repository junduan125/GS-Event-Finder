package org.gsef.eventfinder.graphql.query.model;

import java.util.List;

public class PageOption {

	private int first;
	private int page;
	private List<SortOption> sortOptions;
	
	public int getFirst() {
		return first;
	}
	public void setFirst(int first) {
		this.first = first;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public List<SortOption> getSortOptions() {
		return sortOptions;
	}
	public void setSortOptions(List<SortOption> sortOptions) {
		this.sortOptions = sortOptions;
	}
}
