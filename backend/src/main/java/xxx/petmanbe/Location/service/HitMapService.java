package xxx.petmanbe.Location.service;

import xxx.petmanbe.Location.dto.responseDto.HitMapResponseDto;

public interface HitMapService {
	/**
	 * HitMap을 조회하여 Vo에 담아주는 서비스.
	 * @param animalId 해당 동물의 Id
	 * @return
	 */
	public HitMapResponseDto getHitMap(long animalId);
}
