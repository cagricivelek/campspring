package kodlama.io.homework.business.abstracts;

import java.util.List;

import kodlama.io.homework.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageService {
	
	List<ProgrammingLanguage> getAll();
	ProgrammingLanguage getById(int id);
	void add(ProgrammingLanguage programmingLanguage) throws Exception;
	void update(int id, String name) throws Exception;
	void delete(int id) throws Exception;

}
