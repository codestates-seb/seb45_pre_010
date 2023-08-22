package com.hexacoder.stackoverflow.tag.repository;

import com.hexacoder.stackoverflow.tag.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
    Tag findByTagName(String tagName);
}
