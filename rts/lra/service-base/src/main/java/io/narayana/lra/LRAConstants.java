/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2019, Red Hat, Inc., and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package io.narayana.lra;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.regex.Pattern;

public final class LRAConstants {
    public static final String COORDINATOR_PATH_NAME = "lra-coordinator";
    public static final String RECOVERY_COORDINATOR_PATH_NAME = "recovery";

    public static final String COMPLETE = "complete";
    public static final String COMPENSATE = "compensate";
    public static final String STATUS = "status";
    public static final String LEAVE = "leave";
    public static final String AFTER = "after";
    public static final String FORGET = "forget";

    public static final String STATUS_PARAM_NAME = "Status";
    public static final String CLIENT_ID_PARAM_NAME = "ClientID";
    public static final String TIMELIMIT_PARAM_NAME = "TimeLimit";
    public static final String PARENT_LRA_PARAM_NAME = "ParentLRA";
    public static final String QUERY_PAIR_SEPARATOR = "&"; // separator to isolate each "key=value" pair of a URI query component
    public static final String QUERY_FIELD_SEPARATOR = "="; // separator to pick out the key and value of each pair
    public static final String RECOVERY_PARAM = "recoveryCount";
    public static final String HTTP_METHOD_NAME = "method"; // the name of the HTTP method used to invoke participants

    /*
     * Supported Narayana LRA API versions.
     * Any version not mentioned in the list of the supported versions is unsupported
     * and will fail on incoming HTTP call.
     * The valid version format is specified in API.adoc document.
     * When a new version with a new features is added consider adding API tests under 'test/basic'.
     */
    public static final String[] NARAYANA_LRA_API_SUPPORTED_VERSIONS = new String[] {
            "1.0"
    };

    /**
     * The Narayana API version for LRA coordinator supported for the release.
     * Any higher version is considered as unimplemented and unknown.
     */
    public static final String CURRENT_API_VERSION_STRING = "1.0";

    public static final String NARAYANA_LRA_API_VERSION_HEADER_NAME = "Narayana-LRA-API-version";

    /**
     * Number of seconds to wait for requests to participant.
     * The timeout is hardcoded as the protocol expects retry in case of failure and timeout.
     */
    public static final long PARTICIPANT_TIMEOUT = 2;

    private static final Pattern UID_REGEXP_EXTRACT_MATCHER = Pattern.compile(".*/([^/?]+).*");

    private LRAConstants() {
        // utility class
    }

    /**
     * Extract the uid part from an LRA id.
     *
     * @param lraId  LRA id to extract the uid from
     * @return  uid of LRA
     */
    public static String getLRAUid(String lraId) {
        return lraId == null ? null : UID_REGEXP_EXTRACT_MATCHER.matcher(lraId).replaceFirst("$1");
    }

    /**
     * Extract the uid part from an LRA id.
     *
     * @param lraId  LRA id to extract the uid from
     * @return  uid of LRA
     */
    public static String getLRAUid(URI lraId) {
        if (lraId == null) return null;
        String path = lraId.getPath();
        if (path == null) return null;
        return path.substring(path.lastIndexOf('/') + 1);
    }

    /*
     * Extract the coordinator URL from the provided LRA id.
     *
     * @implNote Narayana LRA id is defined as an URL, e.g. {@code http://localhost:8080/deployment/lra-coordinator/0_ffff0a28054b_9133_5f855916_a7}.
     *           The LRA coordinator is available at {@code http://localhost:8080/deployment/lra-coordinator}
     *           and the {@code 0_ffff0a28054b_9133_5f855916_a7} is the LRA uid.
     *
     * @param lraId  LRA id to extract the LRA coordinator URI from
     * @return LRA Coordinator URL
     * @throws IllegalStateException if the LRA coordinator URL, extracted from the LRA id, is not assignable to URI
     */
    public static URI getLRACoordinatorUrl(URI lraId) {
        if (lraId == null) return null;
        String lraIdPath = lraId.getPath();
        String lraCoordinatorPath = lraIdPath.substring(0, lraIdPath.lastIndexOf(COORDINATOR_PATH_NAME)) + COORDINATOR_PATH_NAME;
        try {
            return new URI(lraId.getScheme(), lraId.getUserInfo(), lraId.getHost(), lraId.getPort(), lraCoordinatorPath,
                    null, null);
        } catch (URISyntaxException use) {
            throw new IllegalStateException("Cannot construct URI from the LRA coordinator URL path '" + lraCoordinatorPath
                    + "' extracted from the LRA id URI '" + lraId + "'");
        }
    }
}
