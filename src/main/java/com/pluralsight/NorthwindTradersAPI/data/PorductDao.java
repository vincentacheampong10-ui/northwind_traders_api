package com.pluralsight.NorthwindTradersAPI.data;

import com.pluralsight.NorthwindTradersAPI.model.Product;
import org.springframework.web.servlet.mvc.condition.ProducesRequestCondition;

import java.util.List;

public interface PorductDao {
    List<Product> getAll();

}
