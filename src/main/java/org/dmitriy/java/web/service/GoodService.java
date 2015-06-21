package org.dmitriy.java.web.service;

import java.util.List;
import org.dmitriy.java.web.model.Good;

public interface GoodService {
    List<Good> all();
    List<Good> all(Integer categoryId);
}
