package com.hexacoder.stackoverflow.tag.mapper;

import com.hexacoder.stackoverflow.tag.dto.TagDto;
import com.hexacoder.stackoverflow.tag.entity.Tag;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-22T03:13:36+0900",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.2.1.jar, environment: Java 17.0.8 (IBM Corporation)"
)
@Component
public class TagMapperImpl implements TagMapper {

    @Override
    public TagDto.Response tagToTagResponse(Tag tag) {
        if ( tag == null ) {
            return null;
        }

        long tagId = 0L;
        String tagName = null;

        if ( tag.getTagId() != null ) {
            tagId = tag.getTagId();
        }
        tagName = tag.getTagName();

        TagDto.Response response = new TagDto.Response( tagId, tagName );

        return response;
    }

    @Override
    public List<TagDto.Response> tagsToTagResponse(List<Tag> tags) {
        if ( tags == null ) {
            return null;
        }

        List<TagDto.Response> list = new ArrayList<TagDto.Response>( tags.size() );
        for ( Tag tag : tags ) {
            list.add( tagToTagResponse( tag ) );
        }

        return list;
    }
}
