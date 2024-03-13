package com.cibertec.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class TicketRequest {
	private String title;
	private String description;
	private Long categoryId;
	private Long kindId;
	private Long priorityId;
	private Long projectId;
	private Long statusId;
	private Long userId;
}
