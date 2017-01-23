package RESTAPI.Restmodule.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import RESTAPI.Restmodule.Entities.Domain;
import RESTAPI.Restmodule.Exception.BadRequestException;
import RESTAPI.Restmodule.Exception.UserNotFoundException;
import RESTAPI.Restmodule.Repository.DomainRepository;
@Service
public class DomainServiceImpl implements DomainService {
	@Autowired
	DomainRepository domainRepository;
	@Override
	@Transactional
	public List<Domain> findAllMovies() {
		return domainRepository.getAllMovies();
	}

	@Override
	@Transactional
	public List<Domain> findAllTvseries() {
		return domainRepository.getAllTvseries();
	}

	@Override
	@Transactional
	public Domain findDomainById(long id) {
		Domain d = domainRepository.getDomainById(id);
		if(d==null){
			throw new UserNotFoundException("Movie not found");
		}
		return d;
	}

	

	@Override
	@Transactional
	public List<Domain> findDomainByYear(int year) {
		return domainRepository.getDomainByYear(year);
	}

	@Override
	@Transactional
	public List<Domain> findDomainByGenre(String genre) {
		return domainRepository.getDomainByGenre(genre);
	}

	@Override
	@Transactional
	public List<Domain> findByImdbRatings(float imdbratings) {
		return domainRepository.getDomainByImdbRatings(imdbratings);
	}

	@Override
	@Transactional
	public List<Domain> findByImdbVotes(int imdbvotes) {
		return domainRepository.getDomainByImdbVotes(imdbvotes);
	}

	@Override
	@Transactional
	public Domain createDomain(Domain domain) {
		Domain exists = domainRepository.findById(domain.getId());
		if (exists != null) {
			throw new BadRequestException("domain with the id already exists");
		}
		return domainRepository.createDomain(domain);
	}

	@Override
	@Transactional
	public Domain updateDomain(long id, Domain domain) {
		Domain exists = domainRepository.findById(id);
		if (exists == null) {
			throw new UserNotFoundException("domain does not exist");
		}
		return domainRepository.updateDomain(id, domain);
	}

	@Override
	@Transactional
	public void deleteDomainById(long id) {
		Domain exists = domainRepository.findById(id);
		if (exists == null) {
			throw new UserNotFoundException("domain does not exist");
		}
		else domainRepository.deleteDomainById(id);
	}

	@Override
	@Transactional
	public void deleteAllDomains() {
		domainRepository.deleteAllDomains();
	}

}
