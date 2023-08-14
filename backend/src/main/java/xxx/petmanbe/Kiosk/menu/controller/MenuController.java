package xxx.petmanbe.Kiosk.menu.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import xxx.petmanbe.Kiosk.menu.dto.requestDto.PostMenuDto;
import xxx.petmanbe.Kiosk.menu.dto.responseDto.GetMenuDto;
import xxx.petmanbe.Kiosk.menu.service.MenuService;
import xxx.petmanbe.Kiosk.menufile.service.MenuFileService;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/menu")
@CrossOrigin("*")
public class MenuController {

	private final MenuService menuService;

	private final MenuFileService menuFileService;

	@PostMapping(value="/menu")
	public ResponseEntity<?> PostMenu(@RequestPart("dto") PostMenuDto request, @RequestPart(value="file") MultipartFile file) throws IOException {

		System.out.println(file.getBytes().getClass());
		System.out.println(file.getContentType());
		long menuId = menuService.postMenu(request);

		if(!file.isEmpty()){
			if(!menuFileService.keepFile(file, menuId)){
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		}

		return new ResponseEntity<>(HttpStatus.OK);

	}

	@GetMapping("/show/{shopId}")
	public ResponseEntity<?> GetMenu(@PathVariable long shopId){

		List<GetMenuDto> getMenuDtoList = menuService.getMenu(shopId);


		return new ResponseEntity<>(getMenuDtoList, HttpStatus.OK);
	}





}
