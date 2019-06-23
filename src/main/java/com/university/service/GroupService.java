package com.university.service;

import com.university.model.Group;

import java.util.List;

public interface GroupService {

    List<Group> findAll();

    Group findById(Long id);

    void add(Group group);

    void delete(Long id);

    void update(Group group);

}
