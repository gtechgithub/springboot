package com.javapoint;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.apache.lucene.search.Query;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HibernateSearchService {

	
	 @Autowired
	 private final EntityManager centityManager;
	 

    @Autowired
    public HibernateSearchService(EntityManager entityManager) {
        this.centityManager = entityManager;
    }


    public void initializeHibernateSearch() {

    	try {
    		FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(centityManager);
    		fullTextEntityManager.createIndexer().startAndWait();
    	}
    	catch(InterruptedException e) {
            e.printStackTrace();
    	}
    }
    
    public List<BaseballCard> fuzzySearch(String searchTerm) {
    	List<BaseballCard> baseballCard =  null;
        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(centityManager);
        QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(BaseballCard.class).get();
        Query luceneQuery = queryBuilder.keyword().fuzzy().withEditDistanceUpTo(1).withPrefixLength(1).onFields("name").matching(searchTerm).createQuery();
        
        javax.persistence.Query jpaQuery = fullTextEntityManager.createFullTextQuery(luceneQuery, BaseballCard.class);

        
        try {
            baseballCard = jpaQuery.getResultList();
    	}
    	catch(NoResultException  e) {
    		//do nothing
    	}
        
    	return baseballCard;
    }
}
