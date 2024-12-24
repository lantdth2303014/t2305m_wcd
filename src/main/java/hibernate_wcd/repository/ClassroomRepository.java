package hibernate_wcd.repository;

import hibernate_wcd.entity.Classroom;

import java.util.List;

public interface ClassroomRepository extends Repository<Classroom,Long>{
    List<Classroom> findByName(String name);
}