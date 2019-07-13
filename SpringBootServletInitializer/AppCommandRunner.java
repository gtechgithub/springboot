package springbatch.batch;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class AppCommandRunner implements CommandLineRunner {

	@Autowired
	PersonRepository repo;
	
    @Override
    public void run(String... args) throws Exception {
    	List<Person> personList = repo.findAll();
		personList.forEach(person -> {
			System.out.println("person:" + person);
		});
				
	}
}
