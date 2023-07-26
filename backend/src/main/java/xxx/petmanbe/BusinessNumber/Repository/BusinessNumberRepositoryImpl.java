package xxx.petmanbe.BusinessNumber.Repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
import xxx.petmanbe.BusinessNumber.DTO.Request.Detail.RequestBusinessNumberBodyDto;
import xxx.petmanbe.BusinessNumber.DTO.Request.Detail.RequestBusinessNumberDetailDto;
import xxx.petmanbe.BusinessNumber.DTO.Request.Nomal.RequestBusinessNumberDto;
import xxx.petmanbe.BusinessNumber.DTO.Response.detail.ResponseBusinessNumberStatusDetailDto;
import xxx.petmanbe.BusinessNumber.DTO.Response.nomal.ResponseBusinessNumberStatusDto;

@Slf4j
@Repository
public class BusinessNumberRepositoryImpl implements BusinessNumberRepository {

	@Value("${opendata.key}")
	private String key;

	private ObjectMapper mapper;

	public BusinessNumberRepositoryImpl() {
		mapper = new ObjectMapper();
	}

	@Override
	public ResponseBusinessNumberStatusDto BusinessNumberSearch(String BusinessNumber) {
		ResponseBusinessNumberStatusDto joinData = null;
		HttpURLConnection conn = null;

		try {
			URL url = new URL(
				"https://api.odcloud.kr/api/nts-businessman/v1/status?serviceKey=" + key + "&returnType=JSON");
			conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setDoOutput(true);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
			bw.write(
				mapper.writeValueAsString(
					new RequestBusinessNumberDto(
						BusinessNumber
					)
				)
			);
			bw.flush();
			bw.close();
			joinData = mapper.readValue(
				new BufferedReader(new InputStreamReader(conn.getInputStream())),
				ResponseBusinessNumberStatusDto.class
			);
		} catch (MalformedURLException e) {
			log.info("BusinessNumber is not correct");
		} catch (StreamReadException e) {
			log.info("Network Or OS Error");
		} catch (DatabindException e) {
			System.out.println(e.getMessage());
			log.info("Entity is not correct");
		} catch (IOException e) {
			System.out.println(e.getMessage());
			log.info("IO Error");
		}
		return joinData;
	}

	@Override
	public ResponseBusinessNumberStatusDetailDto BusinessNumberSearchDetail(String BusinessNumber, String StartDateTime,
		String RepresentativeName) {
		ResponseBusinessNumberStatusDetailDto joinData = null;
		HttpURLConnection conn = null;

		try {
			URL url = new URL(
				"https://api.odcloud.kr/api/nts-businessman/v1/validate?serviceKey=" + key + "&returnType=JSON");
			conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setDoOutput(true);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
			bw.write(
				mapper.writeValueAsString(
					new RequestBusinessNumberDetailDto(
						new RequestBusinessNumberBodyDto(
							BusinessNumber,
							StartDateTime,
							RepresentativeName
						)
					)
				)
			);

			bw.flush();
			bw.close();
			joinData = mapper.readValue(
				new BufferedReader(new InputStreamReader(conn.getInputStream())),
				ResponseBusinessNumberStatusDetailDto.class
			);
		} catch (MalformedURLException e) {
			log.info("BusinessNumber is not correct");
		} catch (StreamReadException e) {
			log.info("Network Or OS Error");
		} catch (DatabindException e) {
			System.out.println(e.getMessage());
			log.info("Entity is not correct");
		} catch (IOException e) {
			System.out.println(e.getMessage());
			log.info("IO Error");
		}
		return joinData;
	}
}
