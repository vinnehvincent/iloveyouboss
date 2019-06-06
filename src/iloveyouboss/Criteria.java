package iloveyouboss;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Criteria implements Iterable<Criterion> {
	
	List<Criterion> criterionList = new ArrayList<>();
	
	@Override
	public Iterator<Criterion> iterator() {
		return criterionList.iterator();
	}

	public void add(Criterion criterion) {
		criterionList.add(criterion);		
	}

}
