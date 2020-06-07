package com.nuc.zp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.nuc.zp.entity.Course;
import com.nuc.zp.entity.Dict;
import com.nuc.zp.entity.User;
import com.nuc.zp.mapper.CourseMapper;
import com.nuc.zp.mapper.DictMapper;
import com.nuc.zp.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 分布式之之分库分表：水平分表
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShardingSphereApplicationTest {

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DictMapper dictMapper;

    @Test
    public void addCourse() {
        for (int i = 0; i < 10; i++) {
            Course course = new Course();
            course.setCourseName("java");
            course.setCourseStatus("Normal");
            course.setUserId((long) i);
            courseMapper.insert(course);
        }
    }

    @Test
    public void findCourseById() {
        QueryWrapper<Course> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", 1269442516684500993L);
        Course course = courseMapper.selectOne(queryWrapper);
        System.out.println(course);
    }

    @Test
    public void findCourseByIdAndUserId() {
        QueryWrapper<Course> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", 1269456783370395649L);
        queryWrapper.eq("user_id", 5);
        Course course = courseMapper.selectOne(queryWrapper);
        System.out.println(course);
    }

    @Test
    public void addUser() {
        User user = new User();
        user.setUserName("jack");
        user.setUserStatus("1");
        userMapper.insert(user);
    }

    @Test
    public void findUser() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", 476358709128200193L);
        User user = userMapper.selectOne(queryWrapper);
        System.out.println(user);

    }


    @Test
    public void addDict() {
        Dict dict = new Dict();
        dict.setDictStatus("1");
        dict.setDictValue("已启用");
        dictMapper.insert(dict);
    }

    @Test
    public void deleteDict() {
        QueryWrapper<Dict> deleteWrapper = new QueryWrapper<>();
        deleteWrapper.eq("dict_id", 476362999783751681L);
        dictMapper.delete(deleteWrapper);
    }

}
