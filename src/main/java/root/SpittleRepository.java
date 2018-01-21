package root;

import java.util.List;

import entity.Spittle;

public interface SpittleRepository {
	public List<Spittle> findSpittles(long max, int count);
}
