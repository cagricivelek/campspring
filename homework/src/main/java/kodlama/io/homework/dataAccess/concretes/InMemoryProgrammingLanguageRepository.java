package kodlama.io.homework.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kodlama.io.homework.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.homework.entities.concretes.ProgrammingLanguage;

@Repository
public class InMemoryProgrammingLanguageRepository implements ProgrammingLanguageRepository{
	
	List<ProgrammingLanguage> programmingLanguages;
	
	@Autowired
	public InMemoryProgrammingLanguageRepository() {
		programmingLanguages = new ArrayList<ProgrammingLanguage>();
		programmingLanguages.add(new ProgrammingLanguage(1,"Java"));
		programmingLanguages.add(new ProgrammingLanguage(2,"C#"));
		programmingLanguages.add(new ProgrammingLanguage(3,"Phyton"));
		programmingLanguages.add(new ProgrammingLanguage(4,"Php"));
	}

	@Override
	public List<ProgrammingLanguage> getAll() {
		return programmingLanguages;
	}

	@Override
	public ProgrammingLanguage getById(int id) {
		
		for (ProgrammingLanguage programmingLanguage : programmingLanguages) {
			if (programmingLanguage.getId() == id) {
				return programmingLanguage;
			}
		}
		
		return null;
	}

	@Override
	public void add(ProgrammingLanguage programmingLanguage) {
		programmingLanguages.add(programmingLanguage);
		
	}

	@Override
	public void update(int id, String name) {
		
		for (ProgrammingLanguage language : programmingLanguages) {
			if (language.getId() == id) {
				language.setName(name);
			}
		}
		
	}

	@Override
	public void delete(int id) {
	
		programmingLanguages.remove(id);
		
	}



}
