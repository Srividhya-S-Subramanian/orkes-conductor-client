/*
 * Copyright 2022 Orkes, Inc.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package io.orkes.conductor.client.http.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.v3.oas.annotations.media.Schema;

/** TaskDef */
public class TaskDef {
    @SerializedName("backoffScaleFactor")
    private Integer backoffScaleFactor = null;

    @SerializedName("concurrentExecLimit")
    private Integer concurrentExecLimit = null;

    @SerializedName("createTime")
    private Long createTime = null;

    @SerializedName("createdBy")
    private String createdBy = null;

    @SerializedName("description")
    private String description = null;

    @SerializedName("executionNameSpace")
    private String executionNameSpace = null;

    @SerializedName("inputKeys")
    private List<String> inputKeys = null;

    @SerializedName("inputTemplate")
    private Map<String, Object> inputTemplate = null;

    @SerializedName("isolationGroupId")
    private String isolationGroupId = null;

    @SerializedName("name")
    private String name = null;

    @SerializedName("outputKeys")
    private List<String> outputKeys = null;

    @SerializedName("ownerApp")
    private String ownerApp = null;

    @SerializedName("ownerEmail")
    private String ownerEmail = null;

    @SerializedName("pollTimeoutSeconds")
    private Integer pollTimeoutSeconds = null;

    @SerializedName("rateLimitFrequencyInSeconds")
    private Integer rateLimitFrequencyInSeconds = null;

    @SerializedName("rateLimitPerFrequency")
    private Integer rateLimitPerFrequency = null;

    @SerializedName("responseTimeoutSeconds")
    private Long responseTimeoutSeconds = null;

    @SerializedName("retryCount")
    private Integer retryCount = null;

    @SerializedName("retryDelaySeconds")
    private Integer retryDelaySeconds = null;

    /** Gets or Sets retryLogic */
    @JsonAdapter(RetryLogicEnum.Adapter.class)
    public enum RetryLogicEnum {
        FIXED("FIXED"),
        EXPONENTIAL_BACKOFF("EXPONENTIAL_BACKOFF"),
        LINEAR_BACKOFF("LINEAR_BACKOFF");

        private String value;

        RetryLogicEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static RetryLogicEnum fromValue(String input) {
            for (RetryLogicEnum b : RetryLogicEnum.values()) {
                if (b.value.equals(input)) {
                    return b;
                }
            }
            return null;
        }

        public static class Adapter extends TypeAdapter<RetryLogicEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final RetryLogicEnum enumeration)
                    throws IOException {
                jsonWriter.value(String.valueOf(enumeration.getValue()));
            }

            @Override
            public RetryLogicEnum read(final JsonReader jsonReader) throws IOException {
                Object value = jsonReader.nextString();
                return RetryLogicEnum.fromValue((String) (value));
            }
        }
    }

    @SerializedName("retryLogic")
    private RetryLogicEnum retryLogic = null;

    /** Gets or Sets timeoutPolicy */
    @JsonAdapter(TimeoutPolicyEnum.Adapter.class)
    public enum TimeoutPolicyEnum {
        RETRY("RETRY"),
        TIME_OUT_WF("TIME_OUT_WF"),
        ALERT_ONLY("ALERT_ONLY");

        private String value;

        TimeoutPolicyEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static TimeoutPolicyEnum fromValue(String input) {
            for (TimeoutPolicyEnum b : TimeoutPolicyEnum.values()) {
                if (b.value.equals(input)) {
                    return b;
                }
            }
            return null;
        }

        public static class Adapter extends TypeAdapter<TimeoutPolicyEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final TimeoutPolicyEnum enumeration)
                    throws IOException {
                jsonWriter.value(String.valueOf(enumeration.getValue()));
            }

            @Override
            public TimeoutPolicyEnum read(final JsonReader jsonReader) throws IOException {
                Object value = jsonReader.nextString();
                return TimeoutPolicyEnum.fromValue((String) (value));
            }
        }
    }

    @SerializedName("timeoutPolicy")
    private TimeoutPolicyEnum timeoutPolicy = null;

    @SerializedName("timeoutSeconds")
    private Long timeoutSeconds = null;

    @SerializedName("updateTime")
    private Long updateTime = null;

    @SerializedName("updatedBy")
    private String updatedBy = null;

    public TaskDef backoffScaleFactor(Integer backoffScaleFactor) {
        this.backoffScaleFactor = backoffScaleFactor;
        return this;
    }

    /**
     * Get backoffScaleFactor minimum: 1
     *
     * @return backoffScaleFactor
     */
    @Schema(description = "")
    public Integer getBackoffScaleFactor() {
        return backoffScaleFactor;
    }

    public void setBackoffScaleFactor(Integer backoffScaleFactor) {
        this.backoffScaleFactor = backoffScaleFactor;
    }

    public TaskDef concurrentExecLimit(Integer concurrentExecLimit) {
        this.concurrentExecLimit = concurrentExecLimit;
        return this;
    }

    /**
     * Get concurrentExecLimit
     *
     * @return concurrentExecLimit
     */
    @Schema(description = "")
    public Integer getConcurrentExecLimit() {
        return concurrentExecLimit;
    }

    public void setConcurrentExecLimit(Integer concurrentExecLimit) {
        this.concurrentExecLimit = concurrentExecLimit;
    }

    public TaskDef createTime(Long createTime) {
        this.createTime = createTime;
        return this;
    }

    /**
     * Get createTime
     *
     * @return createTime
     */
    @Schema(description = "")
    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public TaskDef createdBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    /**
     * Get createdBy
     *
     * @return createdBy
     */
    @Schema(description = "")
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public TaskDef description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Get description
     *
     * @return description
     */
    @Schema(description = "")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskDef executionNameSpace(String executionNameSpace) {
        this.executionNameSpace = executionNameSpace;
        return this;
    }

    /**
     * Get executionNameSpace
     *
     * @return executionNameSpace
     */
    @Schema(description = "")
    public String getExecutionNameSpace() {
        return executionNameSpace;
    }

    public void setExecutionNameSpace(String executionNameSpace) {
        this.executionNameSpace = executionNameSpace;
    }

    public TaskDef inputKeys(List<String> inputKeys) {
        this.inputKeys = inputKeys;
        return this;
    }

    public TaskDef addInputKeysItem(String inputKeysItem) {
        if (this.inputKeys == null) {
            this.inputKeys = new ArrayList<String>();
        }
        this.inputKeys.add(inputKeysItem);
        return this;
    }

    /**
     * Get inputKeys
     *
     * @return inputKeys
     */
    @Schema(description = "")
    public List<String> getInputKeys() {
        return inputKeys;
    }

    public void setInputKeys(List<String> inputKeys) {
        this.inputKeys = inputKeys;
    }

    public TaskDef inputTemplate(Map<String, Object> inputTemplate) {
        this.inputTemplate = inputTemplate;
        return this;
    }

    public TaskDef putInputTemplateItem(String key, Object inputTemplateItem) {
        if (this.inputTemplate == null) {
            this.inputTemplate = new HashMap<String, Object>();
        }
        this.inputTemplate.put(key, inputTemplateItem);
        return this;
    }

    /**
     * Get inputTemplate
     *
     * @return inputTemplate
     */
    @Schema(description = "")
    public Map<String, Object> getInputTemplate() {
        return inputTemplate;
    }

    public void setInputTemplate(Map<String, Object> inputTemplate) {
        this.inputTemplate = inputTemplate;
    }

    public TaskDef isolationGroupId(String isolationGroupId) {
        this.isolationGroupId = isolationGroupId;
        return this;
    }

    /**
     * Get isolationGroupId
     *
     * @return isolationGroupId
     */
    @Schema(description = "")
    public String getIsolationGroupId() {
        return isolationGroupId;
    }

    public void setIsolationGroupId(String isolationGroupId) {
        this.isolationGroupId = isolationGroupId;
    }

    public TaskDef name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get name
     *
     * @return name
     */
    @Schema(required = true, description = "")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TaskDef outputKeys(List<String> outputKeys) {
        this.outputKeys = outputKeys;
        return this;
    }

    public TaskDef addOutputKeysItem(String outputKeysItem) {
        if (this.outputKeys == null) {
            this.outputKeys = new ArrayList<String>();
        }
        this.outputKeys.add(outputKeysItem);
        return this;
    }

    /**
     * Get outputKeys
     *
     * @return outputKeys
     */
    @Schema(description = "")
    public List<String> getOutputKeys() {
        return outputKeys;
    }

    public void setOutputKeys(List<String> outputKeys) {
        this.outputKeys = outputKeys;
    }

    public TaskDef ownerApp(String ownerApp) {
        this.ownerApp = ownerApp;
        return this;
    }

    /**
     * Get ownerApp
     *
     * @return ownerApp
     */
    @Schema(description = "")
    public String getOwnerApp() {
        return ownerApp;
    }

    public void setOwnerApp(String ownerApp) {
        this.ownerApp = ownerApp;
    }

    public TaskDef ownerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
        return this;
    }

    /**
     * Get ownerEmail
     *
     * @return ownerEmail
     */
    @Schema(description = "")
    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public TaskDef pollTimeoutSeconds(Integer pollTimeoutSeconds) {
        this.pollTimeoutSeconds = pollTimeoutSeconds;
        return this;
    }

    /**
     * Get pollTimeoutSeconds minimum: 0
     *
     * @return pollTimeoutSeconds
     */
    @Schema(description = "")
    public Integer getPollTimeoutSeconds() {
        return pollTimeoutSeconds;
    }

    public void setPollTimeoutSeconds(Integer pollTimeoutSeconds) {
        this.pollTimeoutSeconds = pollTimeoutSeconds;
    }

    public TaskDef rateLimitFrequencyInSeconds(Integer rateLimitFrequencyInSeconds) {
        this.rateLimitFrequencyInSeconds = rateLimitFrequencyInSeconds;
        return this;
    }

    /**
     * Get rateLimitFrequencyInSeconds
     *
     * @return rateLimitFrequencyInSeconds
     */
    @Schema(description = "")
    public Integer getRateLimitFrequencyInSeconds() {
        return rateLimitFrequencyInSeconds;
    }

    public void setRateLimitFrequencyInSeconds(Integer rateLimitFrequencyInSeconds) {
        this.rateLimitFrequencyInSeconds = rateLimitFrequencyInSeconds;
    }

    public TaskDef rateLimitPerFrequency(Integer rateLimitPerFrequency) {
        this.rateLimitPerFrequency = rateLimitPerFrequency;
        return this;
    }

    /**
     * Get rateLimitPerFrequency
     *
     * @return rateLimitPerFrequency
     */
    @Schema(description = "")
    public Integer getRateLimitPerFrequency() {
        return rateLimitPerFrequency;
    }

    public void setRateLimitPerFrequency(Integer rateLimitPerFrequency) {
        this.rateLimitPerFrequency = rateLimitPerFrequency;
    }

    public TaskDef responseTimeoutSeconds(Long responseTimeoutSeconds) {
        this.responseTimeoutSeconds = responseTimeoutSeconds;
        return this;
    }

    /**
     * Get responseTimeoutSeconds minimum: 1
     *
     * @return responseTimeoutSeconds
     */
    @Schema(description = "")
    public Long getResponseTimeoutSeconds() {
        return responseTimeoutSeconds;
    }

    public void setResponseTimeoutSeconds(Long responseTimeoutSeconds) {
        this.responseTimeoutSeconds = responseTimeoutSeconds;
    }

    public TaskDef retryCount(Integer retryCount) {
        this.retryCount = retryCount;
        return this;
    }

    /**
     * Get retryCount minimum: 0
     *
     * @return retryCount
     */
    @Schema(description = "")
    public Integer getRetryCount() {
        return retryCount;
    }

    public void setRetryCount(Integer retryCount) {
        this.retryCount = retryCount;
    }

    public TaskDef retryDelaySeconds(Integer retryDelaySeconds) {
        this.retryDelaySeconds = retryDelaySeconds;
        return this;
    }

    /**
     * Get retryDelaySeconds
     *
     * @return retryDelaySeconds
     */
    @Schema(description = "")
    public Integer getRetryDelaySeconds() {
        return retryDelaySeconds;
    }

    public void setRetryDelaySeconds(Integer retryDelaySeconds) {
        this.retryDelaySeconds = retryDelaySeconds;
    }

    public TaskDef retryLogic(RetryLogicEnum retryLogic) {
        this.retryLogic = retryLogic;
        return this;
    }

    /**
     * Get retryLogic
     *
     * @return retryLogic
     */
    @Schema(description = "")
    public RetryLogicEnum getRetryLogic() {
        return retryLogic;
    }

    public void setRetryLogic(RetryLogicEnum retryLogic) {
        this.retryLogic = retryLogic;
    }

    public TaskDef timeoutPolicy(TimeoutPolicyEnum timeoutPolicy) {
        this.timeoutPolicy = timeoutPolicy;
        return this;
    }

    /**
     * Get timeoutPolicy
     *
     * @return timeoutPolicy
     */
    @Schema(description = "")
    public TimeoutPolicyEnum getTimeoutPolicy() {
        return timeoutPolicy;
    }

    public void setTimeoutPolicy(TimeoutPolicyEnum timeoutPolicy) {
        this.timeoutPolicy = timeoutPolicy;
    }

    public TaskDef timeoutSeconds(Long timeoutSeconds) {
        this.timeoutSeconds = timeoutSeconds;
        return this;
    }

    /**
     * Get timeoutSeconds
     *
     * @return timeoutSeconds
     */
    @Schema(required = true, description = "")
    public Long getTimeoutSeconds() {
        return timeoutSeconds;
    }

    public void setTimeoutSeconds(Long timeoutSeconds) {
        this.timeoutSeconds = timeoutSeconds;
    }

    public TaskDef updateTime(Long updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    /**
     * Get updateTime
     *
     * @return updateTime
     */
    @Schema(description = "")
    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public TaskDef updatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
        return this;
    }

    /**
     * Get updatedBy
     *
     * @return updatedBy
     */
    @Schema(description = "")
    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TaskDef taskDef = (TaskDef) o;
        return Objects.equals(this.backoffScaleFactor, taskDef.backoffScaleFactor)
                && Objects.equals(this.concurrentExecLimit, taskDef.concurrentExecLimit)
                && Objects.equals(this.createTime, taskDef.createTime)
                && Objects.equals(this.createdBy, taskDef.createdBy)
                && Objects.equals(this.description, taskDef.description)
                && Objects.equals(this.executionNameSpace, taskDef.executionNameSpace)
                && Objects.equals(this.inputKeys, taskDef.inputKeys)
                && Objects.equals(this.inputTemplate, taskDef.inputTemplate)
                && Objects.equals(this.isolationGroupId, taskDef.isolationGroupId)
                && Objects.equals(this.name, taskDef.name)
                && Objects.equals(this.outputKeys, taskDef.outputKeys)
                && Objects.equals(this.ownerApp, taskDef.ownerApp)
                && Objects.equals(this.ownerEmail, taskDef.ownerEmail)
                && Objects.equals(this.pollTimeoutSeconds, taskDef.pollTimeoutSeconds)
                && Objects.equals(
                        this.rateLimitFrequencyInSeconds, taskDef.rateLimitFrequencyInSeconds)
                && Objects.equals(this.rateLimitPerFrequency, taskDef.rateLimitPerFrequency)
                && Objects.equals(this.responseTimeoutSeconds, taskDef.responseTimeoutSeconds)
                && Objects.equals(this.retryCount, taskDef.retryCount)
                && Objects.equals(this.retryDelaySeconds, taskDef.retryDelaySeconds)
                && Objects.equals(this.retryLogic, taskDef.retryLogic)
                && Objects.equals(this.timeoutPolicy, taskDef.timeoutPolicy)
                && Objects.equals(this.timeoutSeconds, taskDef.timeoutSeconds)
                && Objects.equals(this.updateTime, taskDef.updateTime)
                && Objects.equals(this.updatedBy, taskDef.updatedBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                backoffScaleFactor,
                concurrentExecLimit,
                createTime,
                createdBy,
                description,
                executionNameSpace,
                inputKeys,
                inputTemplate,
                isolationGroupId,
                name,
                outputKeys,
                ownerApp,
                ownerEmail,
                pollTimeoutSeconds,
                rateLimitFrequencyInSeconds,
                rateLimitPerFrequency,
                responseTimeoutSeconds,
                retryCount,
                retryDelaySeconds,
                retryLogic,
                timeoutPolicy,
                timeoutSeconds,
                updateTime,
                updatedBy);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TaskDef {\n");

        sb.append("    backoffScaleFactor: ")
                .append(toIndentedString(backoffScaleFactor))
                .append("\n");
        sb.append("    concurrentExecLimit: ")
                .append(toIndentedString(concurrentExecLimit))
                .append("\n");
        sb.append("    createTime: ").append(toIndentedString(createTime)).append("\n");
        sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    executionNameSpace: ")
                .append(toIndentedString(executionNameSpace))
                .append("\n");
        sb.append("    inputKeys: ").append(toIndentedString(inputKeys)).append("\n");
        sb.append("    inputTemplate: ").append(toIndentedString(inputTemplate)).append("\n");
        sb.append("    isolationGroupId: ").append(toIndentedString(isolationGroupId)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    outputKeys: ").append(toIndentedString(outputKeys)).append("\n");
        sb.append("    ownerApp: ").append(toIndentedString(ownerApp)).append("\n");
        sb.append("    ownerEmail: ").append(toIndentedString(ownerEmail)).append("\n");
        sb.append("    pollTimeoutSeconds: ")
                .append(toIndentedString(pollTimeoutSeconds))
                .append("\n");
        sb.append("    rateLimitFrequencyInSeconds: ")
                .append(toIndentedString(rateLimitFrequencyInSeconds))
                .append("\n");
        sb.append("    rateLimitPerFrequency: ")
                .append(toIndentedString(rateLimitPerFrequency))
                .append("\n");
        sb.append("    responseTimeoutSeconds: ")
                .append(toIndentedString(responseTimeoutSeconds))
                .append("\n");
        sb.append("    retryCount: ").append(toIndentedString(retryCount)).append("\n");
        sb.append("    retryDelaySeconds: ")
                .append(toIndentedString(retryDelaySeconds))
                .append("\n");
        sb.append("    retryLogic: ").append(toIndentedString(retryLogic)).append("\n");
        sb.append("    timeoutPolicy: ").append(toIndentedString(timeoutPolicy)).append("\n");
        sb.append("    timeoutSeconds: ").append(toIndentedString(timeoutSeconds)).append("\n");
        sb.append("    updateTime: ").append(toIndentedString(updateTime)).append("\n");
        sb.append("    updatedBy: ").append(toIndentedString(updatedBy)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces (except the first
     * line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
