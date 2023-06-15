package tacos.tacocloud.repositories;

import org.springframework.data.repository.CrudRepository;
import tacos.tacocloud.entities.TacoOrder;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {}
