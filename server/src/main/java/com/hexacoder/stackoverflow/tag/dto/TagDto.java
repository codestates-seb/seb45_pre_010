package com.hexacoder.stackoverflow.tag.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hexacoder.stackoverflow.tag.entity.Tag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class TagDto {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request {
        @JsonProperty(value = "tagName")
        private String tagName;

        @JsonProperty(value = "tagContent")
        private String tagContent;

        public Tag toEntity() {
            return new Tag(this.tagName);
        }
    }
    @AllArgsConstructor
    @Getter
    public static class Response {

        private long tagId;
        private String tagName;

    }
}