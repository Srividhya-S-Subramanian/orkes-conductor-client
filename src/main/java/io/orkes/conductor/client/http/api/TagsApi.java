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
package io.orkes.conductor.client.http.api;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.orkes.conductor.client.http.*;
import io.orkes.conductor.client.http.model.TagObject;
import io.orkes.conductor.client.http.model.TagString;

import com.google.gson.reflect.TypeToken;

public class TagsApi {
    private ApiClient apiClient;

    public TagsApi() {
        this(Configuration.getDefaultApiClient());
    }

    public TagsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for addTaskTag
     *
     * @param body (required)
     * @param taskName (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call addTaskTagCall(
            TagObject body,
            String taskName,
            final ProgressResponseBody.ProgressListener progressListener,
            final ProgressRequestBody.ProgressRequestListener progressRequestListener)
            throws ApiException {
        Object localVarPostBody = body;

        // create path and map variables
        String localVarPath =
                "/api/metadata/task/{taskName}/tags"
                        .replaceAll(
                                "\\{" + "taskName" + "\\}",
                                apiClient.escapeString(taskName.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {};

        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {"application/json"};
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient
                    .getHttpClient()
                    .networkInterceptors()
                    .add(
                            new com.squareup.okhttp.Interceptor() {
                                @Override
                                public com.squareup.okhttp.Response intercept(
                                        com.squareup.okhttp.Interceptor.Chain chain)
                                        throws IOException {
                                    com.squareup.okhttp.Response originalResponse =
                                            chain.proceed(chain.request());
                                    return originalResponse
                                            .newBuilder()
                                            .body(
                                                    new ProgressResponseBody(
                                                            originalResponse.body(),
                                                            progressListener))
                                            .build();
                                }
                            });
        }

        String[] localVarAuthNames = new String[] {"api_key"};
        return apiClient.buildCall(
                localVarPath,
                "POST",
                localVarQueryParams,
                localVarCollectionQueryParams,
                localVarPostBody,
                localVarHeaderParams,
                localVarFormParams,
                localVarAuthNames,
                progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call addTaskTagValidateBeforeCall(
            TagObject body,
            String taskName,
            final ProgressResponseBody.ProgressListener progressListener,
            final ProgressRequestBody.ProgressRequestListener progressRequestListener)
            throws ApiException {
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new ApiException(
                    "Missing the required parameter 'body' when calling addTaskTag(Async)");
        }
        // verify the required parameter 'taskName' is set
        if (taskName == null) {
            throw new ApiException(
                    "Missing the required parameter 'taskName' when calling addTaskTag(Async)");
        }

        com.squareup.okhttp.Call call =
                addTaskTagCall(body, taskName, progressListener, progressRequestListener);
        return call;
    }

    /**
     * Adds the tag to the task
     *
     * @param body (required)
     * @param taskName (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
     *     response body
     */
    public void addTaskTag(TagObject body, String taskName) throws ApiException {
        addTaskTagWithHttpInfo(body, taskName);
    }

    /**
     * Adds the tag to the task
     *
     * @param body (required)
     * @param taskName (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
     *     response body
     */
    public ApiResponse<Void> addTaskTagWithHttpInfo(TagObject body, String taskName)
            throws ApiException {
        com.squareup.okhttp.Call call = addTaskTagValidateBeforeCall(body, taskName, null, null);
        return apiClient.execute(call);
    }

    /**
     * Adds the tag to the task (asynchronously)
     *
     * @param body (required)
     * @param taskName (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body
     *     object
     */
    public com.squareup.okhttp.Call addTaskTagAsync(
            TagObject body, String taskName, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener =
                    new ProgressResponseBody.ProgressListener() {
                        @Override
                        public void update(long bytesRead, long contentLength, boolean done) {
                            callback.onDownloadProgress(bytesRead, contentLength, done);
                        }
                    };

            progressRequestListener =
                    new ProgressRequestBody.ProgressRequestListener() {
                        @Override
                        public void onRequestProgress(
                                long bytesWritten, long contentLength, boolean done) {
                            callback.onUploadProgress(bytesWritten, contentLength, done);
                        }
                    };
        }

        com.squareup.okhttp.Call call =
                addTaskTagValidateBeforeCall(
                        body, taskName, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /**
     * Build call for addWorkflowTag
     *
     * @param body (required)
     * @param name (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call addWorkflowTagCall(
            TagObject body,
            String name,
            final ProgressResponseBody.ProgressListener progressListener,
            final ProgressRequestBody.ProgressRequestListener progressRequestListener)
            throws ApiException {
        Object localVarPostBody = body;

        // create path and map variables
        String localVarPath =
                "/api/metadata/workflow/{name}/tags"
                        .replaceAll(
                                "\\{" + "name" + "\\}", apiClient.escapeString(name.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {};

        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {"application/json"};
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient
                    .getHttpClient()
                    .networkInterceptors()
                    .add(
                            new com.squareup.okhttp.Interceptor() {
                                @Override
                                public com.squareup.okhttp.Response intercept(
                                        com.squareup.okhttp.Interceptor.Chain chain)
                                        throws IOException {
                                    com.squareup.okhttp.Response originalResponse =
                                            chain.proceed(chain.request());
                                    return originalResponse
                                            .newBuilder()
                                            .body(
                                                    new ProgressResponseBody(
                                                            originalResponse.body(),
                                                            progressListener))
                                            .build();
                                }
                            });
        }

        String[] localVarAuthNames = new String[] {"api_key"};
        return apiClient.buildCall(
                localVarPath,
                "POST",
                localVarQueryParams,
                localVarCollectionQueryParams,
                localVarPostBody,
                localVarHeaderParams,
                localVarFormParams,
                localVarAuthNames,
                progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call addWorkflowTagValidateBeforeCall(
            TagObject body,
            String name,
            final ProgressResponseBody.ProgressListener progressListener,
            final ProgressRequestBody.ProgressRequestListener progressRequestListener)
            throws ApiException {
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new ApiException(
                    "Missing the required parameter 'body' when calling addWorkflowTag(Async)");
        }
        // verify the required parameter 'name' is set
        if (name == null) {
            throw new ApiException(
                    "Missing the required parameter 'name' when calling addWorkflowTag(Async)");
        }

        com.squareup.okhttp.Call call =
                addWorkflowTagCall(body, name, progressListener, progressRequestListener);
        return call;
    }

    /**
     * Adds the tag to the workflow
     *
     * @param body (required)
     * @param name (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
     *     response body
     */
    public void addWorkflowTag(TagObject body, String name) throws ApiException {
        addWorkflowTagWithHttpInfo(body, name);
    }

    /**
     * Adds the tag to the workflow
     *
     * @param body (required)
     * @param name (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
     *     response body
     */
    public ApiResponse<Void> addWorkflowTagWithHttpInfo(TagObject body, String name)
            throws ApiException {
        com.squareup.okhttp.Call call = addWorkflowTagValidateBeforeCall(body, name, null, null);
        return apiClient.execute(call);
    }

    /**
     * Adds the tag to the workflow (asynchronously)
     *
     * @param body (required)
     * @param name (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body
     *     object
     */
    public com.squareup.okhttp.Call addWorkflowTagAsync(
            TagObject body, String name, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener =
                    new ProgressResponseBody.ProgressListener() {
                        @Override
                        public void update(long bytesRead, long contentLength, boolean done) {
                            callback.onDownloadProgress(bytesRead, contentLength, done);
                        }
                    };

            progressRequestListener =
                    new ProgressRequestBody.ProgressRequestListener() {
                        @Override
                        public void onRequestProgress(
                                long bytesWritten, long contentLength, boolean done) {
                            callback.onUploadProgress(bytesWritten, contentLength, done);
                        }
                    };
        }

        com.squareup.okhttp.Call call =
                addWorkflowTagValidateBeforeCall(
                        body, name, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /**
     * Build call for deleteTaskTag
     *
     * @param body (required)
     * @param taskName (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call deleteTaskTagCall(
            TagString body,
            String taskName,
            final ProgressResponseBody.ProgressListener progressListener,
            final ProgressRequestBody.ProgressRequestListener progressRequestListener)
            throws ApiException {
        Object localVarPostBody = body;

        // create path and map variables
        String localVarPath =
                "/metadata/task/{taskName}/tags"
                        .replaceAll(
                                "\\{" + "taskName" + "\\}",
                                apiClient.escapeString(taskName.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {};

        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {"application/json"};
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient
                    .getHttpClient()
                    .networkInterceptors()
                    .add(
                            new com.squareup.okhttp.Interceptor() {
                                @Override
                                public com.squareup.okhttp.Response intercept(
                                        com.squareup.okhttp.Interceptor.Chain chain)
                                        throws IOException {
                                    com.squareup.okhttp.Response originalResponse =
                                            chain.proceed(chain.request());
                                    return originalResponse
                                            .newBuilder()
                                            .body(
                                                    new ProgressResponseBody(
                                                            originalResponse.body(),
                                                            progressListener))
                                            .build();
                                }
                            });
        }

        String[] localVarAuthNames = new String[] {"api_key"};
        return apiClient.buildCall(
                localVarPath,
                "DELETE",
                localVarQueryParams,
                localVarCollectionQueryParams,
                localVarPostBody,
                localVarHeaderParams,
                localVarFormParams,
                localVarAuthNames,
                progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call deleteTaskTagValidateBeforeCall(
            TagString body,
            String taskName,
            final ProgressResponseBody.ProgressListener progressListener,
            final ProgressRequestBody.ProgressRequestListener progressRequestListener)
            throws ApiException {
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new ApiException(
                    "Missing the required parameter 'body' when calling deleteTaskTag(Async)");
        }
        // verify the required parameter 'taskName' is set
        if (taskName == null) {
            throw new ApiException(
                    "Missing the required parameter 'taskName' when calling deleteTaskTag(Async)");
        }

        com.squareup.okhttp.Call call =
                deleteTaskTagCall(body, taskName, progressListener, progressRequestListener);
        return call;
    }

    /**
     * Removes the tag of the task
     *
     * @param body (required)
     * @param taskName (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
     *     response body
     */
    public void deleteTaskTag(TagString body, String taskName) throws ApiException {
        deleteTaskTagWithHttpInfo(body, taskName);
    }

    /**
     * Removes the tag of the task
     *
     * @param body (required)
     * @param taskName (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
     *     response body
     */
    public ApiResponse<Void> deleteTaskTagWithHttpInfo(TagString body, String taskName)
            throws ApiException {
        com.squareup.okhttp.Call call = deleteTaskTagValidateBeforeCall(body, taskName, null, null);
        return apiClient.execute(call);
    }

    /**
     * Removes the tag of the task (asynchronously)
     *
     * @param body (required)
     * @param taskName (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body
     *     object
     */
    public com.squareup.okhttp.Call deleteTaskTagAsync(
            TagString body, String taskName, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener =
                    new ProgressResponseBody.ProgressListener() {
                        @Override
                        public void update(long bytesRead, long contentLength, boolean done) {
                            callback.onDownloadProgress(bytesRead, contentLength, done);
                        }
                    };

            progressRequestListener =
                    new ProgressRequestBody.ProgressRequestListener() {
                        @Override
                        public void onRequestProgress(
                                long bytesWritten, long contentLength, boolean done) {
                            callback.onUploadProgress(bytesWritten, contentLength, done);
                        }
                    };
        }

        com.squareup.okhttp.Call call =
                deleteTaskTagValidateBeforeCall(
                        body, taskName, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /**
     * Build call for deleteWorkflowTag
     *
     * @param body (required)
     * @param name (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call deleteWorkflowTagCall(
            TagObject body,
            String name,
            final ProgressResponseBody.ProgressListener progressListener,
            final ProgressRequestBody.ProgressRequestListener progressRequestListener)
            throws ApiException {
        Object localVarPostBody = body;

        // create path and map variables
        String localVarPath =
                "/metadata/workflow/{name}/tags"
                        .replaceAll(
                                "\\{" + "name" + "\\}", apiClient.escapeString(name.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {};

        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {"application/json"};
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient
                    .getHttpClient()
                    .networkInterceptors()
                    .add(
                            new com.squareup.okhttp.Interceptor() {
                                @Override
                                public com.squareup.okhttp.Response intercept(
                                        com.squareup.okhttp.Interceptor.Chain chain)
                                        throws IOException {
                                    com.squareup.okhttp.Response originalResponse =
                                            chain.proceed(chain.request());
                                    return originalResponse
                                            .newBuilder()
                                            .body(
                                                    new ProgressResponseBody(
                                                            originalResponse.body(),
                                                            progressListener))
                                            .build();
                                }
                            });
        }

        String[] localVarAuthNames = new String[] {"api_key"};
        return apiClient.buildCall(
                localVarPath,
                "DELETE",
                localVarQueryParams,
                localVarCollectionQueryParams,
                localVarPostBody,
                localVarHeaderParams,
                localVarFormParams,
                localVarAuthNames,
                progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call deleteWorkflowTagValidateBeforeCall(
            TagObject body,
            String name,
            final ProgressResponseBody.ProgressListener progressListener,
            final ProgressRequestBody.ProgressRequestListener progressRequestListener)
            throws ApiException {
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new ApiException(
                    "Missing the required parameter 'body' when calling deleteWorkflowTag(Async)");
        }
        // verify the required parameter 'name' is set
        if (name == null) {
            throw new ApiException(
                    "Missing the required parameter 'name' when calling deleteWorkflowTag(Async)");
        }

        com.squareup.okhttp.Call call =
                deleteWorkflowTagCall(body, name, progressListener, progressRequestListener);
        return call;
    }

    /**
     * Removes the tag of the workflow
     *
     * @param body (required)
     * @param name (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
     *     response body
     */
    public void deleteWorkflowTag(TagObject body, String name) throws ApiException {
        deleteWorkflowTagWithHttpInfo(body, name);
    }

    /**
     * Removes the tag of the workflow
     *
     * @param body (required)
     * @param name (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
     *     response body
     */
    public ApiResponse<Void> deleteWorkflowTagWithHttpInfo(TagObject body, String name)
            throws ApiException {
        com.squareup.okhttp.Call call = deleteWorkflowTagValidateBeforeCall(body, name, null, null);
        return apiClient.execute(call);
    }

    /**
     * Removes the tag of the workflow (asynchronously)
     *
     * @param body (required)
     * @param name (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body
     *     object
     */
    public com.squareup.okhttp.Call deleteWorkflowTagAsync(
            TagObject body, String name, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener =
                    new ProgressResponseBody.ProgressListener() {
                        @Override
                        public void update(long bytesRead, long contentLength, boolean done) {
                            callback.onDownloadProgress(bytesRead, contentLength, done);
                        }
                    };

            progressRequestListener =
                    new ProgressRequestBody.ProgressRequestListener() {
                        @Override
                        public void onRequestProgress(
                                long bytesWritten, long contentLength, boolean done) {
                            callback.onUploadProgress(bytesWritten, contentLength, done);
                        }
                    };
        }

        com.squareup.okhttp.Call call =
                deleteWorkflowTagValidateBeforeCall(
                        body, name, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /**
     * Build call for getTags
     *
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getTagsCall(
            final ProgressResponseBody.ProgressListener progressListener,
            final ProgressRequestBody.ProgressRequestListener progressRequestListener)
            throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/metadata/tags";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {"*/*"};
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {};

        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient
                    .getHttpClient()
                    .networkInterceptors()
                    .add(
                            new com.squareup.okhttp.Interceptor() {
                                @Override
                                public com.squareup.okhttp.Response intercept(
                                        com.squareup.okhttp.Interceptor.Chain chain)
                                        throws IOException {
                                    com.squareup.okhttp.Response originalResponse =
                                            chain.proceed(chain.request());
                                    return originalResponse
                                            .newBuilder()
                                            .body(
                                                    new ProgressResponseBody(
                                                            originalResponse.body(),
                                                            progressListener))
                                            .build();
                                }
                            });
        }

        String[] localVarAuthNames = new String[] {"api_key"};
        return apiClient.buildCall(
                localVarPath,
                "GET",
                localVarQueryParams,
                localVarCollectionQueryParams,
                localVarPostBody,
                localVarHeaderParams,
                localVarFormParams,
                localVarAuthNames,
                progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getTagsValidateBeforeCall(
            final ProgressResponseBody.ProgressListener progressListener,
            final ProgressRequestBody.ProgressRequestListener progressRequestListener)
            throws ApiException {

        com.squareup.okhttp.Call call = getTagsCall(progressListener, progressRequestListener);
        return call;
    }

    /**
     * List all tags
     *
     * @return List&lt;TagObject&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
     *     response body
     */
    public List<TagObject> getTags() throws ApiException {
        ApiResponse<List<TagObject>> resp = getTagsWithHttpInfo();
        return resp.getData();
    }

    /**
     * List all tags
     *
     * @return ApiResponse&lt;List&lt;TagObject&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
     *     response body
     */
    public ApiResponse<List<TagObject>> getTagsWithHttpInfo() throws ApiException {
        com.squareup.okhttp.Call call = getTagsValidateBeforeCall(null, null);
        Type localVarReturnType = new TypeToken<List<TagObject>>() {}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List all tags (asynchronously)
     *
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body
     *     object
     */
    public com.squareup.okhttp.Call getTagsAsync(final ApiCallback<List<TagObject>> callback)
            throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener =
                    new ProgressResponseBody.ProgressListener() {
                        @Override
                        public void update(long bytesRead, long contentLength, boolean done) {
                            callback.onDownloadProgress(bytesRead, contentLength, done);
                        }
                    };

            progressRequestListener =
                    new ProgressRequestBody.ProgressRequestListener() {
                        @Override
                        public void onRequestProgress(
                                long bytesWritten, long contentLength, boolean done) {
                            callback.onUploadProgress(bytesWritten, contentLength, done);
                        }
                    };
        }

        com.squareup.okhttp.Call call =
                getTagsValidateBeforeCall(progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<TagObject>>() {}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getTaskTags
     *
     * @param taskName (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getTaskTagsCall(
            String taskName,
            final ProgressResponseBody.ProgressListener progressListener,
            final ProgressRequestBody.ProgressRequestListener progressRequestListener)
            throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath =
                "/metadata/task/{taskName}/tags"
                        .replaceAll(
                                "\\{" + "taskName" + "\\}",
                                apiClient.escapeString(taskName.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {"application/json"};
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {};

        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient
                    .getHttpClient()
                    .networkInterceptors()
                    .add(
                            new com.squareup.okhttp.Interceptor() {
                                @Override
                                public com.squareup.okhttp.Response intercept(
                                        com.squareup.okhttp.Interceptor.Chain chain)
                                        throws IOException {
                                    com.squareup.okhttp.Response originalResponse =
                                            chain.proceed(chain.request());
                                    return originalResponse
                                            .newBuilder()
                                            .body(
                                                    new ProgressResponseBody(
                                                            originalResponse.body(),
                                                            progressListener))
                                            .build();
                                }
                            });
        }

        String[] localVarAuthNames = new String[] {"api_key"};
        return apiClient.buildCall(
                localVarPath,
                "GET",
                localVarQueryParams,
                localVarCollectionQueryParams,
                localVarPostBody,
                localVarHeaderParams,
                localVarFormParams,
                localVarAuthNames,
                progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getTaskTagsValidateBeforeCall(
            String taskName,
            final ProgressResponseBody.ProgressListener progressListener,
            final ProgressRequestBody.ProgressRequestListener progressRequestListener)
            throws ApiException {
        // verify the required parameter 'taskName' is set
        if (taskName == null) {
            throw new ApiException(
                    "Missing the required parameter 'taskName' when calling getTaskTags(Async)");
        }

        com.squareup.okhttp.Call call =
                getTaskTagsCall(taskName, progressListener, progressRequestListener);
        return call;
    }

    /**
     * Returns all the tags of the task
     *
     * @param taskName (required)
     * @return List&lt;TagObject&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
     *     response body
     */
    public List<TagObject> getTaskTags(String taskName) throws ApiException {
        ApiResponse<List<TagObject>> resp = getTaskTagsWithHttpInfo(taskName);
        return resp.getData();
    }

    /**
     * Returns all the tags of the task
     *
     * @param taskName (required)
     * @return ApiResponse&lt;List&lt;TagObject&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
     *     response body
     */
    public ApiResponse<List<TagObject>> getTaskTagsWithHttpInfo(String taskName)
            throws ApiException {
        com.squareup.okhttp.Call call = getTaskTagsValidateBeforeCall(taskName, null, null);
        Type localVarReturnType = new TypeToken<List<TagObject>>() {}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Returns all the tags of the task (asynchronously)
     *
     * @param taskName (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body
     *     object
     */
    public com.squareup.okhttp.Call getTaskTagsAsync(
            String taskName, final ApiCallback<List<TagObject>> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener =
                    new ProgressResponseBody.ProgressListener() {
                        @Override
                        public void update(long bytesRead, long contentLength, boolean done) {
                            callback.onDownloadProgress(bytesRead, contentLength, done);
                        }
                    };

            progressRequestListener =
                    new ProgressRequestBody.ProgressRequestListener() {
                        @Override
                        public void onRequestProgress(
                                long bytesWritten, long contentLength, boolean done) {
                            callback.onUploadProgress(bytesWritten, contentLength, done);
                        }
                    };
        }

        com.squareup.okhttp.Call call =
                getTaskTagsValidateBeforeCall(taskName, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<TagObject>>() {}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getWorkflowTags
     *
     * @param name (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getWorkflowTagsCall(
            String name,
            final ProgressResponseBody.ProgressListener progressListener,
            final ProgressRequestBody.ProgressRequestListener progressRequestListener)
            throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath =
                "/metadata/workflow/{name}/tags"
                        .replaceAll(
                                "\\{" + "name" + "\\}", apiClient.escapeString(name.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {"application/json"};
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {};

        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient
                    .getHttpClient()
                    .networkInterceptors()
                    .add(
                            new com.squareup.okhttp.Interceptor() {
                                @Override
                                public com.squareup.okhttp.Response intercept(
                                        com.squareup.okhttp.Interceptor.Chain chain)
                                        throws IOException {
                                    com.squareup.okhttp.Response originalResponse =
                                            chain.proceed(chain.request());
                                    return originalResponse
                                            .newBuilder()
                                            .body(
                                                    new ProgressResponseBody(
                                                            originalResponse.body(),
                                                            progressListener))
                                            .build();
                                }
                            });
        }

        String[] localVarAuthNames = new String[] {"api_key"};
        return apiClient.buildCall(
                localVarPath,
                "GET",
                localVarQueryParams,
                localVarCollectionQueryParams,
                localVarPostBody,
                localVarHeaderParams,
                localVarFormParams,
                localVarAuthNames,
                progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getWorkflowTagsValidateBeforeCall(
            String name,
            final ProgressResponseBody.ProgressListener progressListener,
            final ProgressRequestBody.ProgressRequestListener progressRequestListener)
            throws ApiException {
        // verify the required parameter 'name' is set
        if (name == null) {
            throw new ApiException(
                    "Missing the required parameter 'name' when calling getWorkflowTags(Async)");
        }

        com.squareup.okhttp.Call call =
                getWorkflowTagsCall(name, progressListener, progressRequestListener);
        return call;
    }

    /**
     * Returns all the tags of the workflow
     *
     * @param name (required)
     * @return List&lt;TagObject&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
     *     response body
     */
    public List<TagObject> getWorkflowTags(String name) throws ApiException {
        ApiResponse<List<TagObject>> resp = getWorkflowTagsWithHttpInfo(name);
        return resp.getData();
    }

    /**
     * Returns all the tags of the workflow
     *
     * @param name (required)
     * @return ApiResponse&lt;List&lt;TagObject&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
     *     response body
     */
    public ApiResponse<List<TagObject>> getWorkflowTagsWithHttpInfo(String name)
            throws ApiException {
        com.squareup.okhttp.Call call = getWorkflowTagsValidateBeforeCall(name, null, null);
        Type localVarReturnType = new TypeToken<List<TagObject>>() {}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Returns all the tags of the workflow (asynchronously)
     *
     * @param name (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body
     *     object
     */
    public com.squareup.okhttp.Call getWorkflowTagsAsync(
            String name, final ApiCallback<List<TagObject>> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener =
                    new ProgressResponseBody.ProgressListener() {
                        @Override
                        public void update(long bytesRead, long contentLength, boolean done) {
                            callback.onDownloadProgress(bytesRead, contentLength, done);
                        }
                    };

            progressRequestListener =
                    new ProgressRequestBody.ProgressRequestListener() {
                        @Override
                        public void onRequestProgress(
                                long bytesWritten, long contentLength, boolean done) {
                            callback.onUploadProgress(bytesWritten, contentLength, done);
                        }
                    };
        }

        com.squareup.okhttp.Call call =
                getWorkflowTagsValidateBeforeCall(name, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<TagObject>>() {}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for setTaskTags
     *
     * @param body (required)
     * @param taskName (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call setTaskTagsCall(
            List<TagObject> body,
            String taskName,
            final ProgressResponseBody.ProgressListener progressListener,
            final ProgressRequestBody.ProgressRequestListener progressRequestListener)
            throws ApiException {
        Object localVarPostBody = body;

        // create path and map variables
        String localVarPath =
                "/metadata/task/{taskName}/tags"
                        .replaceAll(
                                "\\{" + "taskName" + "\\}",
                                apiClient.escapeString(taskName.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {};

        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {"application/json"};
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient
                    .getHttpClient()
                    .networkInterceptors()
                    .add(
                            new com.squareup.okhttp.Interceptor() {
                                @Override
                                public com.squareup.okhttp.Response intercept(
                                        com.squareup.okhttp.Interceptor.Chain chain)
                                        throws IOException {
                                    com.squareup.okhttp.Response originalResponse =
                                            chain.proceed(chain.request());
                                    return originalResponse
                                            .newBuilder()
                                            .body(
                                                    new ProgressResponseBody(
                                                            originalResponse.body(),
                                                            progressListener))
                                            .build();
                                }
                            });
        }

        String[] localVarAuthNames = new String[] {"api_key"};
        return apiClient.buildCall(
                localVarPath,
                "PUT",
                localVarQueryParams,
                localVarCollectionQueryParams,
                localVarPostBody,
                localVarHeaderParams,
                localVarFormParams,
                localVarAuthNames,
                progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call setTaskTagsValidateBeforeCall(
            List<TagObject> body,
            String taskName,
            final ProgressResponseBody.ProgressListener progressListener,
            final ProgressRequestBody.ProgressRequestListener progressRequestListener)
            throws ApiException {
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new ApiException(
                    "Missing the required parameter 'body' when calling setTaskTags(Async)");
        }
        // verify the required parameter 'taskName' is set
        if (taskName == null) {
            throw new ApiException(
                    "Missing the required parameter 'taskName' when calling setTaskTags(Async)");
        }

        com.squareup.okhttp.Call call =
                setTaskTagsCall(body, taskName, progressListener, progressRequestListener);
        return call;
    }

    /**
     * Adds the tag to the task
     *
     * @param body (required)
     * @param taskName (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
     *     response body
     */
    public void setTaskTags(List<TagObject> body, String taskName) throws ApiException {
        setTaskTagsWithHttpInfo(body, taskName);
    }

    /**
     * Adds the tag to the task
     *
     * @param body (required)
     * @param taskName (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
     *     response body
     */
    public ApiResponse<Void> setTaskTagsWithHttpInfo(List<TagObject> body, String taskName)
            throws ApiException {
        com.squareup.okhttp.Call call = setTaskTagsValidateBeforeCall(body, taskName, null, null);
        return apiClient.execute(call);
    }

    /**
     * Adds the tag to the task (asynchronously)
     *
     * @param body (required)
     * @param taskName (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body
     *     object
     */
    public com.squareup.okhttp.Call setTaskTagsAsync(
            List<TagObject> body, String taskName, final ApiCallback<Void> callback)
            throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener =
                    new ProgressResponseBody.ProgressListener() {
                        @Override
                        public void update(long bytesRead, long contentLength, boolean done) {
                            callback.onDownloadProgress(bytesRead, contentLength, done);
                        }
                    };

            progressRequestListener =
                    new ProgressRequestBody.ProgressRequestListener() {
                        @Override
                        public void onRequestProgress(
                                long bytesWritten, long contentLength, boolean done) {
                            callback.onUploadProgress(bytesWritten, contentLength, done);
                        }
                    };
        }

        com.squareup.okhttp.Call call =
                setTaskTagsValidateBeforeCall(
                        body, taskName, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /**
     * Build call for setWorkflowTags
     *
     * @param body (required)
     * @param name (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call setWorkflowTagsCall(
            List<TagObject> body,
            String name,
            final ProgressResponseBody.ProgressListener progressListener,
            final ProgressRequestBody.ProgressRequestListener progressRequestListener)
            throws ApiException {
        Object localVarPostBody = body;

        // create path and map variables
        String localVarPath =
                "/metadata/workflow/{name}/tags"
                        .replaceAll(
                                "\\{" + "name" + "\\}", apiClient.escapeString(name.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {};

        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {"application/json"};
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient
                    .getHttpClient()
                    .networkInterceptors()
                    .add(
                            new com.squareup.okhttp.Interceptor() {
                                @Override
                                public com.squareup.okhttp.Response intercept(
                                        com.squareup.okhttp.Interceptor.Chain chain)
                                        throws IOException {
                                    com.squareup.okhttp.Response originalResponse =
                                            chain.proceed(chain.request());
                                    return originalResponse
                                            .newBuilder()
                                            .body(
                                                    new ProgressResponseBody(
                                                            originalResponse.body(),
                                                            progressListener))
                                            .build();
                                }
                            });
        }

        String[] localVarAuthNames = new String[] {"api_key"};
        return apiClient.buildCall(
                localVarPath,
                "PUT",
                localVarQueryParams,
                localVarCollectionQueryParams,
                localVarPostBody,
                localVarHeaderParams,
                localVarFormParams,
                localVarAuthNames,
                progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call setWorkflowTagsValidateBeforeCall(
            List<TagObject> body,
            String name,
            final ProgressResponseBody.ProgressListener progressListener,
            final ProgressRequestBody.ProgressRequestListener progressRequestListener)
            throws ApiException {
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new ApiException(
                    "Missing the required parameter 'body' when calling setWorkflowTags(Async)");
        }
        // verify the required parameter 'name' is set
        if (name == null) {
            throw new ApiException(
                    "Missing the required parameter 'name' when calling setWorkflowTags(Async)");
        }

        com.squareup.okhttp.Call call =
                setWorkflowTagsCall(body, name, progressListener, progressRequestListener);
        return call;
    }

    /**
     * Set the tags of the workflow
     *
     * @param body (required)
     * @param name (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
     *     response body
     */
    public void setWorkflowTags(List<TagObject> body, String name) throws ApiException {
        setWorkflowTagsWithHttpInfo(body, name);
    }

    /**
     * Set the tags of the workflow
     *
     * @param body (required)
     * @param name (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
     *     response body
     */
    public ApiResponse<Void> setWorkflowTagsWithHttpInfo(List<TagObject> body, String name)
            throws ApiException {
        com.squareup.okhttp.Call call = setWorkflowTagsValidateBeforeCall(body, name, null, null);
        return apiClient.execute(call);
    }

    /**
     * Set the tags of the workflow (asynchronously)
     *
     * @param body (required)
     * @param name (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body
     *     object
     */
    public com.squareup.okhttp.Call setWorkflowTagsAsync(
            List<TagObject> body, String name, final ApiCallback<Void> callback)
            throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener =
                    new ProgressResponseBody.ProgressListener() {
                        @Override
                        public void update(long bytesRead, long contentLength, boolean done) {
                            callback.onDownloadProgress(bytesRead, contentLength, done);
                        }
                    };

            progressRequestListener =
                    new ProgressRequestBody.ProgressRequestListener() {
                        @Override
                        public void onRequestProgress(
                                long bytesWritten, long contentLength, boolean done) {
                            callback.onUploadProgress(bytesWritten, contentLength, done);
                        }
                    };
        }

        com.squareup.okhttp.Call call =
                setWorkflowTagsValidateBeforeCall(
                        body, name, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
}
