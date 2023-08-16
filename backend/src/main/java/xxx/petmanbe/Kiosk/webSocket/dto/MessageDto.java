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

	private Content content;

	private long tableId;

	@Getter
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Content{
		private Props props;
	}

	@Getter
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Props{

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
