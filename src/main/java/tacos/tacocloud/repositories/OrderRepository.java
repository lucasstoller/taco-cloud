package tacos.tacocloud.repositories;

import tacos.tacocloud.entities.TacoOrder;

public interface OrderRepository {
    TacoOrder save(TacoOrder order);
}
