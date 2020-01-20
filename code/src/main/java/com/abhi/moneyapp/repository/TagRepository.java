package com.abhi.moneyapp.repository;

import com.abhi.moneyapp.repository.model.Tag;
import com.abhi.moneyapp.repository.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag,Long> {

    Tag findTagByName(String tagname);

}
