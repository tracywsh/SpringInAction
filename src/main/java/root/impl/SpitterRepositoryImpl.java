package root.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import entity.Spitter;
import root.SpitterRepository;

@Component
public class SpitterRepositoryImpl implements SpitterRepository {
	
	private List<Spitter> spitters = new ArrayList<Spitter>();

//	@Override
	public void save(Spitter spitter) {
		spitters.add(spitter);
	}

//	@Override
	public Spitter findByUserName(String userName) {
		if (StringUtils.isBlank(userName)){
			return null;
		}
		for (Spitter spi : spitters){
			if (userName.equals(spi.getUsername())){
				return spi;
			}
		}
		return null;
	}

}
