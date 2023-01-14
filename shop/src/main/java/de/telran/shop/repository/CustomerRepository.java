package de.telran.shop.repository;

import de.telran.shop.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CustomerRepository implements CommonRepository<Customer> {

    private static final String SQL_CREATE = "INSERT INTO customers (id, fistName, lastName, age) " +
            "VALUES (:id, :fistName, :lastName, :age)";

    private static final String SQL_UPDATE = "UPDATE customers (id, fistName, lastName, age) SET" +
            "fistName = :fistName, lastName = :lastName, age = :age WHERE id = :id";

    private static final String SQL_FIND_BY_ID = "SELECT * FROM customers WHERE id = :id";

    private static final String SQL_FIND_ALL = "SELECT * FROM customers";

    private static final String SQL_DELETE = "DELETE FROM customers WHERE id = :id";


    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public CustomerRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Customer save(Customer entity) {
        Customer customer = findById(entity.getId());
        if (customer != null) {
            return upsert(entity, SQL_UPDATE);
        }
        return upsert(entity, SQL_CREATE);
    }

    private Customer upsert(Customer customer, String sql) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("id", customer.getId());
        parameters.put("firstName", customer.getFirstName());

    }

    @Override
    public Iterable<Customer> save(Iterable<Customer> entities) {
        return null;
    }

    @Override
    public Customer delete(String id) {
        return null;
    }

    @Override
    public Customer findById(String id) {
        return null;
    }

    @Override
    public Iterable<Customer> findAll() {
        return null;
    }

}
