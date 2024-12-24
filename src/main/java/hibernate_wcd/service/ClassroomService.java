package hibernate_wcd.service;

import hibernate_wcd.dto.req.ClassroomReq;
import hibernate_wcd.dto.res.ClassroomRes;
import hibernate_wcd.entity.Classroom;
import hibernate_wcd.repository.ClassroomRepository;

import java.util.ArrayList;
import java.util.List;

public class ClassroomService {
    private final ClassroomRepository classroomRepository;

    public ClassroomService(ClassroomRepository classroomRepository) {
        this.classroomRepository = classroomRepository;
    }

    public List<ClassroomRes> getAll(){
        List<ClassroomRes> data = new ArrayList<>();
        classroomRepository.all().forEach(
                c -> data.add(new ClassroomRes(c.getId(),c.getName())));

//        List<Classroom> list = classroomRepository.all();
//        for (Classroom c : list){
//            ClassroomRes cr = new ClassroomRes(c.getId(),c.getName());
//            data.add(cr);
//        }
        return data;
    }

    public void createClassroom(ClassroomReq req) throws Exception{
        if(req.getName().isEmpty() || req.getName().length() < 6){
            throw new Exception("Please input name");
        }
        Classroom c = new Classroom();
        c.setName(req.getName());
        classroomRepository.save(c);
    }
}
