package RESTAPI.Restmodule.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

import RESTAPI.Restmodule.Entities.Domain;
@Repository
public class DomainRepositoryImpl implements DomainRepository {

	@PersistenceContext
	private EntityManager em;
	@SuppressWarnings("unchecked")
	@Override
	public List<Domain> getAllMovies() {
		Query query =  em.createQuery("from Domain d where d.type=movies");
		List<Domain> q = query.getResultList(); 
		return q;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Domain> getAllTvseries() {
		Query query =  em.createQuery("from Domain d where d.type=Tvseries");
		List<Domain> q = query.getResultList(); 
		return q;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Domain getDomainById(long id) {
		Query query =  em.createQuery("select d from Domain d where d.id=:pid");
		query.setParameter("pid", id);
		List<Domain> d = query.getResultList(); 
		if(d!= null && d.size()==1){
			return d.get(0);
		}
		else{
		return null;}
		
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Domain> getDomainByYear(int year) {
		Query query =  em.createQuery("select d from Domain d where d.year=:pyear");
		query.setParameter("pyear", year);
		List<Domain> d = query.getResultList(); 
		
		return d;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Domain> getDomainByGenre(String genre) {
		Query query =  em.createQuery("select d from Domain d where d.genre=:pgenre");
		query.setParameter("pgenre", genre);
		List<Domain> d = query.getResultList(); 
		
		return d;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Domain> getDomainByImdbRatings(float imdbratings) {
		Query query =  em.createQuery("select d from Domain d where d.imdbrating=:pimdbrating");
		query.setParameter("pimdbrating", imdbratings);
		List<Domain> d = query.getResultList(); 
		
		return d;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Domain> getDomainByImdbVotes(int imdbvotes) {
		Query query =  em.createQuery("select d from Domain d where d.imdbvotes=:pimdbvotes");
		query.setParameter("pimdbvotes", imdbvotes);
		List<Domain> d = query.getResultList(); 
		
		return d;
	}

	@Override
	public Domain createDomain(Domain domain) {
		em.persist(domain);
		return domain;
	}

	@Override
	public Domain updateDomain(long id, Domain domain) {
		return em.merge(domain);
	}

	@Override
	public void deleteDomainById(long id) {
		Domain dom = em.find(Domain.class, id);
		em.remove(dom);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void deleteAllDomains() {
		Query query =  em.createQuery(" from Domain d ");
		List<Domain> q = query.getResultList(); 		
		for(Domain d : q)
			 em.remove(d);
			
		
	}

	@Override
	public Domain findById(long id) {
		return em.find(Domain.class, id);
	}

}
