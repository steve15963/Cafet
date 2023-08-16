package xxx.petmanbe.Kiosk.webSocket.dto;

import java.util.List;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class MessageDto {
	// private Menu menu;
	private long shopId;

	private long tableId;

	public String[][] content;

	@Getter
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Content{
		public String[][] data;
	}

	// @Getter
	// @NoArgsConstructor
	// @AllArgsConstructor
	// public static class Data{
	//
	// 	String type;
	//
	// 	int money;
	//
	// 	int quantity;
	//
	// 	String size;
	//
	// 	String ulr;
	//
	//
	// }

}
