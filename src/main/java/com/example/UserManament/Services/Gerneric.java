package com.example.UserManament.Services;

import java.util.List;

public interface Gerneric<T> {
    List<T> getAll();
    T getById(int id);
}
