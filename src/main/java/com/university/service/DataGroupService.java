package com.university.service;

import com.university.model.Group;
import com.university.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class DataGroupService implements GroupService {

    @Autowired
    public GroupRepository groupRepository;

    @Override
    public List<Group> findAll() {
        return groupRepository.findAll();
    }

    @Override
    public Group findById(Long id) {
        return groupRepository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void add(Group group) {
        groupRepository.save(group);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        groupRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void update(Group group) {
        groupRepository.save(group);
    }
}
