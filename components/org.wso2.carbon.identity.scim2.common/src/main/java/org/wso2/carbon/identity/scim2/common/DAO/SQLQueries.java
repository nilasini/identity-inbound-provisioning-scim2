/*
 * Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.carbon.identity.scim2.common.DAO;
/**
 * SQL Queries for SCIM_IDENTITY_TABLE which persists SCIM_GROUP info.
 */
public class SQLQueries {

    public static final String LIST_SCIM_GROUPS_SQL =
            "SELECT ROLE_NAME FROM IDN_SCIM_GROUP WHERE IDN_SCIM_GROUP.ATTR_NAME = ?";
    public static final String LIST_SCIM_GROUPS_WITH_PAGINATION_SQL = "SELECT DISTINCT ROLE_NAME FROM IDN_SCIM_GROUP " +
            "WHERE IDN_SCIM_GROUP.ATTR_NAME = ? AND TENANT_ID=? ORDER BY ROLE_NAME ASC LIMIT ? OFFSET ?";
    public static final String LIST_SCIM_GROUPS_WITH_FILTER_SQL = "SELECT DISTINCT ROLE_NAME FROM " +
            "IDN_SCIM_GROUP WHERE ROLE_NAME LIKE ? AND TENANT_ID=? ORDER BY ROLE_NAME";
    public static final String LIST_SCIM_GROUPS_WITH_FILTER_PAGINATION_SQL = "SELECT DISTINCT ROLE_NAME FROM " +
            "IDN_SCIM_GROUP WHERE ROLE_NAME LIKE ? AND TENANT_ID=? ORDER BY ROLE_NAME ASC LIMIT ? OFFSET ?";
    public static final String LIST_SCIM_GROUPS_WITH_FILTER_PAGINATED_DB2 =
            "SELECT DISTINCT ROLE_NAME FROM (SELECT ROW_NUMBER() OVER (ORDER BY " +
                    "ROLE_NAME) AS rn, p.*  FROM (SELECT DISTINCT ROLE_NAME  FROM IDN_SCIM_GROUP U WHERE U.ROLE_NAME LIKE ? " +
                    "AND U.TENANT_ID = ?) AS p) WHERE rn BETWEEN ? AND ?";
    public static final String LIST_SCIM_GROUPS_WITH_FILTER_PAGINATED_MSSQL =
            "SELECT DISTINCT ROLE_NAME FROM IDN_SCIM_GROUP WHERE ROLE_NAME LIKE ? AND TENANT_ID=?  ORDER BY " +
                    "ROLE_NAME OFFSET ? ROW FETCH NEXT ? ROW ONLY";
    public static final String LIST_SCIM_GROUPS_WITH_FILTER_PAGINATED_ORACLE = "SELECT DISTINCT ROLE_NAME FROM " +
            "(SELECT DISTINCT" +
            "ROLE_NAME, TENANT_ID, rownum AS rnum FROM (SELECT ROLE_NAME, TENANT_ID FROM IDN_SCIM_GROUP ORDER BY" +
            " ROLE_NAME) WHERE ROLE_NAME LIKE ? AND TENANT_ID=? AND rownum <= ?) WHERE  rnum > ?";
    public static final String LIST_SCIM_GROUPS_WITH_PAGINATED_DB2 =
            "SELECT ROLE_NAME FROM (SELECT ROW_NUMBER() OVER " +
                    "(ORDER BY ROLE_NAME) AS rn, p.*  FROM (SELECT DISTINCT ROLE_NAME  FROM IDN_SCIM_GROUP U " +
                    "WHERE U.ATTR_NAME = ? AND TENANT_ID=?) AS p) WHERE rn BETWEEN ? AND ?";
    public static final String LIST_SCIM_GROUPS_WITH_PAGINATED_MSSQL =
            "SELECT DISTINCT ROLE_NAME FROM IDN_SCIM_GROUP WHERE IDN_SCIM_GROUP.ATTR_NAME = ? AND TENANT_ID=?  " +
                    "ORDER BY ROLE_NAME OFFSET ? ROW FETCH NEXT ? ROW ONLY";
    public static final String LIST_SCIM_GROUPS_WITH_PAGINATED_ORACLE = "SELECT ROLE_NAME FROM (SELECT ROLE_NAME," +
            " TENANT_ID, rownum AS rnum FROM (SELECT ROLE_NAME, TENANT_ID FROM IDN_SCIM_GROUP ORDER BY " +
            "ROLE_NAME) WHERE IDN_SCIM_GROUP.ATTR_NAME = ? AND TENANT_ID=? AND rownum <= ?) WHERE  rnum > ?";

    public static final String GET_ATTRIBUTES_SQL =
            "SELECT ATTR_NAME, ATTR_VALUE FROM IDN_SCIM_GROUP WHERE IDN_SCIM_GROUP.TENANT_ID=? AND " +
                    "IDN_SCIM_GROUP.ROLE_NAME=?";
    public static final String GET_GROUP_NAME_BY_ID_SQL =
            "SELECT ROLE_NAME FROM IDN_SCIM_GROUP WHERE IDN_SCIM_GROUP.TENANT_ID=? AND " +
                    "IDN_SCIM_GROUP.ATTR_VALUE=? AND IDN_SCIM_GROUP.ATTR_NAME=?";
    public static final String ADD_ATTRIBUTES_SQL =
            "INSERT INTO IDN_SCIM_GROUP (TENANT_ID, ROLE_NAME, ATTR_NAME, ATTR_VALUE) VALUES (?, ?, ?, ?)";
    public static final String UPDATE_ATTRIBUTES_SQL =
            "UPDATE IDN_SCIM_GROUP SET UM_ATTR_VALUE=? WHERE TENANT_ID=? AND ROLE_NAME=? AND ATTR_NAME=?";
    public static final String UPDATE_GROUP_NAME_SQL =
            "UPDATE IDN_SCIM_GROUP SET ROLE_NAME=? WHERE TENANT_ID=? AND ROLE_NAME=?";
    public static final String DELETE_GROUP_SQL =
            "DELETE FROM IDN_SCIM_GROUP WHERE TENANT_ID=? AND ROLE_NAME=?";
    public static final String CHECK_EXISTING_ATTRIBUTE_SQL =
            "SELECT TENANT_ID, ROLE_NAME, ATTR_NAME FROM IDN_SCIM_GROUP WHERE IDN_SCIM_GROUP.TENANT_ID=? AND " +
                    "IDN_SCIM_GROUP.ROLE_NAME=? AND IDN_SCIM_GROUP.ATTR_NAME=?";
    public static final String LIST_SCIM_GROUPS_SQL_BY_ATT_AND_ATT_VALUE =
            "SELECT ROLE_NAME FROM IDN_SCIM_GROUP WHERE IDN_SCIM_GROUP.TENANT_ID=? AND " +
                    "IDN_SCIM_GROUP.ATTR_NAME=? AND ATTR_VALUE LIKE ?";
    public static final String LIST_SCIM_GROUPS_SQL_BY_ATT_AND_ATT_VALUE_AND_ROLE_NAME =
            "SELECT ROLE_NAME FROM IDN_SCIM_GROUP WHERE IDN_SCIM_GROUP.TENANT_ID=? AND "
                    + "IDN_SCIM_GROUP.ATTR_NAME=? AND ATTR_VALUE LIKE ? AND IDN_SCIM_GROUP.ROLE_NAME LIKE ?";
    private SQLQueries(){}
}
