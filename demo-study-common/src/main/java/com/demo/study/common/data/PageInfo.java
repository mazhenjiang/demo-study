package com.demo.study.common.data;

import java.util.LinkedList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PageInfo<T> {
	public PageInfo(List<T> list, Pagination pagination) {
		this.list = list;
		this.pagination = pagination;
	}

	private List<T> list;
	private Pagination pagination;

	public List<T> getList() {
		if (this.list == null) {
			this.list = new LinkedList<>();
		}
		return list;
	}

	@Getter
	@Setter
	public static class Pagination {
		public Pagination() {
			this.current_page = 1L;
			this.page_size = 0;
			this.total = 0L;
			this.total_page = 0L;
		}

		public Pagination(long current_page, int page_size, long total) {
			this.current_page = current_page;
			this.page_size = page_size;
			this.total = total;
		}

		private long current_page;
		private int page_size;
		private long total;
		private Long total_page;

		public long getTotal_page() {
			if (total_page == null || total_page == 0) {
				total_page = total / page_size;
				if (total % page_size != 0) {
					total_page++;
				}
			}
			return total_page;
		}
	}
}
