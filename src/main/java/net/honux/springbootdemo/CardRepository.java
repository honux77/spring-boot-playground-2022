package net.honux.springbootdemo;

import org.springframework.data.repository.CrudRepository;

public interface CardRepository extends CrudRepository <Card, Long> {

}
