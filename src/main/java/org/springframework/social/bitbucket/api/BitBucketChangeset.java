/**
 * Copyright 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.bitbucket.api;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A changeset, <i>aka</i> commit.
 * 
 * @author ericbottard
 * 
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BitBucketChangeset {

    /**
     * A modification on a single file.
     * 
     * @author ericbottard
     * 
     */
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class FileModification {

        @JsonProperty
        private String file;

        @JsonProperty
        private FileModificationType type;

        /**
         * The path of the file (or directory) affected.
         */
        public String getFile() {
            return file;
        }

        /**
         * The kind of modification.
         */
        public FileModificationType getType() {
            return type;
        }
    }

    /**
     * The kind of modification on a file path.
     */
    public static enum FileModificationType {
        modified, added, removed;
    }

    @JsonProperty
    private String author;

    @JsonProperty
    private String branch;

    @JsonProperty
    private List<FileModification> files;

    @JsonProperty
    private String message;

    @JsonProperty
    private String node;

    @JsonProperty
    private List<String> parents;

    @JsonProperty("raw_author")
    private String rawAuthor;

    @JsonProperty("raw_node")
    private String rawNode;

    @JsonProperty
    private long revision;

    /**
     * The username of the {@link BitBucketUser} that made the change.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * The name of the branch where the commit occurred.
     */
    public String getBranch() {
        return branch;
    }

    /**
     * A list of affected files.
     */
    public List<FileModification> getFiles() {
        return files;
    }

    /**
     * The commit message as entered by the {@link #getAuthor() author}.
     */
    public String getMessage() {
        return message;
    }

    /**
     * The short node hash.
     */
    public String getNode() {
        return node;
    }

    /**
     * The parent commit(s) of this change.
     */
    public List<String> getParents() {
        return parents;
    }

    /**
     * The raw author identifier of this change (includes email address).
     */
    public String getRawAuthor() {
        return rawAuthor;
    }

    /**
     * The full node hash.
     */
    public String getRawNode() {
        return rawNode;
    }

    public long getRevision() {
        return revision;
    }

    @Override
    public String toString() {
        return getNode();
    }

}
