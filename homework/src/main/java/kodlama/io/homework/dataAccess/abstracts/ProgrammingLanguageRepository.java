package kodlama.io.homework.dataAccess.abstracts;

import java.util.List;

import kodlama.io.homework.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageRepository {
	
	List<ProgrammingLanguage> getAll();
	ProgrammingLanguage getById(int id);
	void add(ProgrammingLanguage programmingLanguage) throws Exception;
	void update(int id, String name);
	void delete(int id);

}
