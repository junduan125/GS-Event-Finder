package org.gsef.eventfinder.graphql.query;

import java.util.List;
import java.util.stream.Collectors;

import org.gsef.eventfinder.jpa.model.GSEvent;
import org.springframework.data.domain.Page;

import graphql.relay.ConnectionCursor;
import graphql.relay.DefaultConnectionCursor;
import graphql.relay.DefaultPageInfo;
import graphql.relay.PageInfo;

public class GSEventEdgeConnection {
	private List<GSEventEdge> edges;
	private PageInfo pageInfo;

	public GSEventEdgeConnection(Page<GSEvent> gsEvents) {
		ConnectionCursor pageCursor = new DefaultConnectionCursor(Integer.toString(gsEvents.getNumber()));
		pageInfo = new DefaultPageInfo(pageCursor, pageCursor, gsEvents.hasPrevious(), gsEvents.hasNext());
		edges = gsEvents.stream().map(gsEvent -> GSEventEdge.create(pageCursor, gsEvent))
				.collect(Collectors.toList());
	}

	public List<GSEventEdge> getEdges() {
		return edges;
	}

	public void setEdges(List<GSEventEdge> edges) {
		this.edges = edges;
	}

	public PageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}
}
