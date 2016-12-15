package com.xstyx.distromatic.work;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface WorkRepository extends MongoRepository<Work, String> {

}
