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

	private Props content;

	private String tableId;

	public static class Props{

		public List<Data> data;

	}

	public static class Data{

		String type;

		int money;

		String size;

		String ulr;


	}

}
