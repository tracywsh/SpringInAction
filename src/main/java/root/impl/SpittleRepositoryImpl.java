package root.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import entity.Spittle;
import root.SpittleRepository;

@Component
public class SpittleRepositoryImpl implements SpittleRepository{

	@SuppressWarnings("serial")
//	@Override
	public List<Spittle> findSpittles(long max, int count) {
		return new ArrayList<Spittle>(){
			{
				add(new Spittle(1l, "a", new Date(), 1.1, 2.2));
				add(new Spittle(2l, "b", new Date(), 3.3, 4.4));
				add(new Spittle(3l, "c", new Date(), 5.5, 6.6));
			}
		};
	}

}
