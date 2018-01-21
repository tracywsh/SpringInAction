package root;

import entity.Spitter;

public interface SpitterRepository {
	public void save(Spitter spitter);
	
	public Spitter findByUserName(String userName);
}
