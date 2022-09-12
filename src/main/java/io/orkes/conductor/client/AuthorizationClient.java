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
package io.orkes.conductor.client;

import java.util.List;
import java.util.Map;

import io.orkes.conductor.client.http.model.*;

public interface AuthorizationClient {

    // Permissions

    Map<String, List<Subject>> getPermissions(String type, String id);

    void grantPermissions(AuthorizationRequest body);

    void removePermissions(AuthorizationRequest body);

    // Users
    void deleteUser(String id);

    GrantedAccessResponse getGrantedPermissionsForUser(String userId);

    ConductorUser getUser(String id);

    List<ConductorUser> listUsers(Boolean apps);

    void sendInviteEmail(String id, ConductorUser body);

    ConductorUser upsertUser(UpsertUserRequest body, String id);

    // Groups
    void addUserToGroup(String groupId, String userId);

    void deleteGroup(String id);

    GrantedAccessResponse getGrantedPermissionsForGroup(String groupId);

    Group getGroup(String id);

    List<ConductorUser> getUsersInGroup(String id);

    List<Group> listGroups();

    void removeUserFromGroup(String groupId, String userId);

    Group upsertGroup(UpsertGroupRequest body, String id);

    // Applications
    void addRoleToApplicationUser(String applicationId, String role);

    CreateAccessKeyResponse createAccessKey(String id);

    ConductorApplication createApplication(CreateOrUpdateApplicationRequest body);

    void deleteAccessKey(String applicationId, String keyId);

    void deleteApplication(String id);

    List<AccessKeyResponse> getAccessKeys(String id);

    ConductorApplication getApplication(String id);

    List<ConductorApplication> listApplications();

    void removeRoleFromApplicationUser(String applicationId, String role);

    AccessKeyResponse toggleAccessKeyStatus(String applicationId, String keyId);

    ConductorApplication updateApplication(CreateOrUpdateApplicationRequest body, String id);
}