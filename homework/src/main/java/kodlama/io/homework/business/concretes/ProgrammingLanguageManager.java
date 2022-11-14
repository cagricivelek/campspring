package kodlama.io.homework.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.homework.business.abstracts.ProgrammingLanguageService;
import kodlama.io.homework.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.homework.entities.concretes.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService{
	
	private ProgrammingLanguageRepository programmingLanguageRepository;
	
	@Autowired
	public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository) {
		this.programmingLanguageRepository = programmingLanguageRepository;
	}

	@Override
	public List<ProgrammingLanguage> getAll() {
		return programmingLanguageRepository.getAll();
	}

	@Override
	public ProgrammingLanguage getById(int id) {
		return programmingLanguageRepository.getById(id);
	}

	@Override
	public void add(ProgrammingLanguage programmingLanguage) throws Exception {
		
		if (programmingLanguage.getName().isEmpty()) {
			throw new Exception("Programlama dili boş olamaz.");
		}
		
		for (ProgrammingLanguage language : getAll()) {
			if (language.getName().equals(programmingLanguage.getName())) {
				throw new Exception("Programlama dili tekrar edemez.");
			}
		}
		
		programmingLanguageRepository.add(programmingLanguage);
		
	}

	@Override
	public void update(int id, String name) throws Exception {
		
		for (ProgrammingLanguage language : getAll()) {
			if (language.getId() == id) {
				programmingLanguageRepository.update(id, name);

			} 
		}
	}

	@Override
	public void delete(int id) throws Exception {
		
		for (ProgrammingLanguage language : getAll()) {
			if (language.getId() == id) {
				programmingLanguageRepository.delete(id);
			}
		}
		
	}


	



}
