package com.hexacoder.stackoverflow.tag.mapper;

import com.hexacoder.stackoverflow.tag.dto.TagDto;
import com.hexacoder.stackoverflow.tag.entity.Tag;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TagMapper {

    TagDto.Response tagToTagResponse(Tag tag);

    List<TagDto.Response> tagsToTagResponse(List<Tag> tags);

}
