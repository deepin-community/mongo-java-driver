/*
 * Copyright 2016 MongoDB, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package com.mongodb.connection;

class TestServerMonitorFactory implements ServerMonitorFactory {

    private final TestServerMonitor monitor;

    TestServerMonitorFactory(final ServerId serverId) {
        this.monitor = new TestServerMonitor(serverId);
    }

    @Override
    public TestServerMonitor create(final ChangeListener<ServerDescription> serverStateListener) {
        monitor.setServerStateListener(serverStateListener);
        return monitor;
    }

    public void sendNotification(final ServerDescription serverDescription) {
        monitor.sendNotification(serverDescription);
    }
}
