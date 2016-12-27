package com.xstyx.distromatic.work;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface WorkRepository extends MongoRepository<Work, String> {

}
